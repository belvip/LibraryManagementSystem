package com.belvinard.libraryManagementSystem.data;

import com.belvinard.libraryManagementSystem.model.Book;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LibraryData {
    private ArrayList<Book> bookCollection = new ArrayList<>();  // Collection of books
    private LinkedList<String> borrowingHistory = new LinkedList<>();  // Borrowing history for each book
    private Stack<String> recentActivities = new Stack<>();  // Recent activity log


    // Remove a book from the collection
    public void removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Cannot remove a null book.");
        }
        if (!bookCollection.contains(book)) {
            throw new IllegalArgumentException("Book not found in the collection.");
        }
        bookCollection.remove(book);
        recentActivities.push("Removed book: " + book.getTitle());
    }

    // Update an existing book in the collection based on ISBN
    public void updateBook(String isbn, Book updatedBook) {
        if (updatedBook == null) {
            throw new IllegalArgumentException("Updated book cannot be null.");
        }
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN must not be null or empty.");
        }

        for (int i = 0; i < bookCollection.size(); i++) {
            Book currentBook = bookCollection.get(i);
            if (currentBook.getISBN().equals(isbn)) {
                // Update book details
                bookCollection.set(i, updatedBook);
                recentActivities.push("Updated book: " + updatedBook.getTitle());
                return;  // Exit after updating
            }
        }
        throw new IllegalArgumentException("Book with ISBN " + isbn + " not found.");
    }

    // Get the entire book collection
    public ArrayList<Book> getBookCollection() {
        return bookCollection;
    }

    // Add borrowing record to history
    public void addBorrowingHistory(String historyEntry) {
        if (historyEntry == null || historyEntry.trim().isEmpty()) {
            throw new IllegalArgumentException("Borrow history entry must not be null or empty.");
        }
        borrowingHistory.add(historyEntry);
    }

    // Get borrowing history
    public LinkedList<String> getBorrowingHistory() {
        return borrowingHistory;
    }

    // Log recent activities
    public void addRecentActivity(String activity) {
        if (activity == null || activity.trim().isEmpty()) {
            throw new IllegalArgumentException("Activity must not be null or empty.");
        }
        recentActivities.push(activity);
    }

    // Get recent activities log
    public Stack<String> getRecentActivities() {
        return recentActivities;
    }

    public void addBook(Book book) {
        // Check if the book already exists (by ISBN)
        if (getBookByISBN(book.getISBN()) != null) {
            throw new IllegalArgumentException("Book with ISBN " + book.getISBN() + " already exists.");
        }
        bookCollection.add(book);
    }

    // Remove a book by title, genre, or author
    public void removeBookByTitle(String title) {
        Book book = getBookByTitle(title);
        if (book == null) {
            throw new IllegalArgumentException("No book found with title: " + title);
        }
        bookCollection.remove(book);
    }

    public void removeBookByGenre(String genre) {
        Book book = getBookByGenre(genre);
        if (book == null) {
            throw new IllegalArgumentException("No book found with genre: " + genre);
        }
        bookCollection.remove(book);
    }

    public void removeBookByAuthor(String author) {
        Book book = getBookByAuthor(author);
        if (book == null) {
            throw new IllegalArgumentException("No book found by author: " + author);
        }
        bookCollection.remove(book);
    }

    // Update a book's details by title, genre, or author
    public void updateBookByTitle(String title, Book updatedBook) {
        Book existingBook = getBookByTitle(title);
        if (existingBook == null) {
            throw new IllegalArgumentException("No book found with title: " + title);
        }

        // Check if the new ISBN already exists in the collection
        for (Book book : bookCollection) {
            if (book.getISBN().equals(updatedBook.getISBN()) && !book.getISBN().equals(existingBook.getISBN())) {
                throw new IllegalArgumentException("ISBN " + updatedBook.getISBN() + " already exists for another book.");
            }
        }

        // Update the book's details
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPublicationYear(updatedBook.getPublicationYear());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setISBN(updatedBook.getISBN());
    }

    public void updateBookByGenre(String genre, Book updatedBook) {
        Book existingBook = getBookByGenre(genre);
        if (existingBook == null) {
            throw new IllegalArgumentException("No book found with genre: " + genre);
        }

        // Check if the new ISBN already exists in the collection
        for (Book book : bookCollection) {
            if (book.getISBN().equals(updatedBook.getISBN()) && !book.getISBN().equals(existingBook.getISBN())) {
                throw new IllegalArgumentException("ISBN " + updatedBook.getISBN() + " already exists for another book.");
            }
        }

        // Update the book's details
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPublicationYear(updatedBook.getPublicationYear());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setISBN(updatedBook.getISBN());
    }

    public void updateBookByAuthor(String author, Book updatedBook) {
        Book existingBook = getBookByAuthor(author);
        if (existingBook == null) {
            throw new IllegalArgumentException("No book found by author: " + author);
        }

        // Check if the new ISBN already exists in the collection
        for (Book book : bookCollection) {
            if (book.getISBN().equals(updatedBook.getISBN()) && !book.getISBN().equals(existingBook.getISBN())) {
                throw new IllegalArgumentException("ISBN " + updatedBook.getISBN() + " already exists for another book.");
            }
        }

        // Update the book's details
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPublicationYear(updatedBook.getPublicationYear());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setISBN(updatedBook.getISBN());
    }

    // Get a book by its title
    public Book getBookByTitle(String title) {
        for (Book book : bookCollection) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Get a book by its genre
    public Book getBookByGenre(String genre) {
        for (Book book : bookCollection) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                return book;
            }
        }
        return null;
    }

    // Get a book by its author
    public Book getBookByAuthor(String author) {
        for (Book book : bookCollection) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }

    // Get a book by its ISBN
    public Book getBookByISBN(String ISBN) {
        for (Book book : bookCollection) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    // Get all books in the collection
    public List<Book> getAllBooks() {
        return bookCollection;
    }
}
