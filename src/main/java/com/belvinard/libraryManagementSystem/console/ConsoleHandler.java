package com.belvinard.libraryManagementSystem.console;

import com.belvinard.libraryManagementSystem.service.BookService;
import com.belvinard.libraryManagementSystem.service.HistoryService;
import com.belvinard.libraryManagementSystem.service.SearchService;
import com.belvinard.libraryManagementSystem.service.SortService;
import com.belvinard.libraryManagementSystem.model.Book;
import com.belvinard.libraryManagementSystem.data.LibraryData;

import java.util.Scanner;

public class ConsoleHandler {

    private final BookService bookService;
    private final HistoryService historyService;
    private final SearchService searchService;
    private final SortService sortService;
    private final Scanner scanner;

    public ConsoleHandler(BookService bookService, HistoryService historyService, SearchService searchService, SortService sortService) {
        this.bookService = bookService;
        this.historyService = historyService;
        this.searchService = searchService;
        this.sortService = sortService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    searchBooks();
                    break;
                case 5:
                    sortBooks();
                    break;
                case 6:
                    showHistory();
                    break;
                case 7:
                    showRecentActivities();
                    break;
                case 8:
                    borrowBook();
                    break;
                case 9:
                    running = false;
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n----- Library Management System -----");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Update Book");
        System.out.println("4. Search Books");
        System.out.println("5. Sort Books");
        System.out.println("6. Show Borrowing History");
        System.out.println("7. Show Recent Activities");
        System.out.println("8. Borrow Book");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Book book = new Book(title, author, genre, isbn, year);
        bookService.addBook(book);
        historyService.addBorrowingHistory("Added book: " + title);
        System.out.println("Book added successfully.");
    }

    private void removeBook() {
        System.out.print("Enter the title of the book to remove: ");
        String title = scanner.nextLine();
        bookService.removeBookByTitle(title);
        System.out.println("Book removed successfully.");
    }

    private void updateBook() {
        System.out.print("Enter the ISBN of the book to update: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter updated book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter updated author: ");
        String author = scanner.nextLine();
        System.out.print("Enter updated genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter updated publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Book updatedBook = new Book(title, author, genre, isbn, year);
        bookService.updateBook(isbn, updatedBook);
        System.out.println("Book updated successfully.");
    }

    private void searchBooks() {
        System.out.println("Search by:");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. ISBN");
        System.out.print("Enter your choice: ");
        int searchChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter search query: ");
        String query = scanner.nextLine();

        switch (searchChoice) {
            case 1:
                searchService.linearSearchByTitle(query);
                break;
            case 2:
                searchService.linearSearchByAuthor(query);
                break;
            case 3:
                searchService.linearSearchByISBN(query);
                break;
            default:
                System.out.println("Invalid search choice.");
        }
    }

    private void sortBooks() {
        System.out.println("Sort by:");
        System.out.println("1. Title (Bubble Sort)");
        System.out.println("2. Title (Selection Sort)");
        System.out.println("3. Title (Quick Sort)");
        System.out.print("Enter your choice: ");
        int sortChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (sortChoice) {
            case 1:
                sortService.bubbleSortByTitle();
                break;
            case 2:
                sortService.selectionSortByTitle();
                break;
            case 3:
                sortService.quickSortByTitle();
                break;
            default:
                System.out.println("Invalid sort choice.");
        }
    }

    private void borrowBook() {
        System.out.print("Enter the title of the book to borrow: ");
        String title = scanner.nextLine();
        Book book = bookService.getBookByTitle(title);

        if (book != null) {
            // Assuming borrowing history is tracked as part of the book's borrowing history
            historyService.addBorrowingHistory("Borrowed book: " + book.getTitle());
            System.out.println("You have successfully borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Book not found. Please check the title and try again.");
        }
    }

    private void showHistory() {
        System.out.println("\nBorrowing History:");
        historyService.getHistory().forEach(System.out::println);
    }

    private void showRecentActivities() {
        System.out.println("\nRecent Activities:");
        bookService.getRecentActivities().forEach(System.out::println);
    }
}
