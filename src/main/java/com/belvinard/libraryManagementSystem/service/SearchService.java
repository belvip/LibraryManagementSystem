package com.belvinard.libraryManagementSystem.service;

import com.belvinard.libraryManagementSystem.data.LibraryData;
import com.belvinard.libraryManagementSystem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final LibraryData libraryData;

    @Autowired
    public SearchService(LibraryData libraryData) {
        this.libraryData = libraryData;
    }

    // Linear Search
    public Book linearSearchByTitle(String title) {
        for (Book book : libraryData.getBookCollection()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book linearSearchByAuthor(List<Book> books, String authorQuery) {
        for (Book book : books) {
            if (book.getAuthor() != null && book.getAuthor().equalsIgnoreCase(authorQuery)) {
                return book;  // Book found
            }
        }
        return null;  // No book found
    }

    /* public Book linearSearchByAuthor(String author) {
        for (Book book : libraryData.getBookCollection()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    } */

    public Book linearSearchByISBN(String isbn) {
        for (Book book : libraryData.getBookCollection()) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search (assumes the list is sorted)
    public Book binarySearchByTitle(String title) {
        List<Book> books = libraryData.getBookCollection();
        int left = 0, right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books.get(mid).getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public Book binarySearchByAuthor(String author) {
        List<Book> books = libraryData.getBookCollection();
        int left = 0, right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books.get(mid).getAuthor().compareToIgnoreCase(author);

            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public Book binarySearchByISBN(String isbn) {
        List<Book> books = libraryData.getBookCollection();
        int left = 0, right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books.get(mid).getISBN().compareTo(isbn);

            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }


}
