package com.belvinard.libraryManagementSystem.service;

import com.belvinard.libraryManagementSystem.data.LibraryData;
import com.belvinard.libraryManagementSystem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final LibraryData libraryData;

    @Autowired
    public BookService(LibraryData libraryData) {
        this.libraryData = libraryData;
    }



    public void addBook(Book book) {
        libraryData.addBook(book);
    }

    /* public void removeBook(Book book) {
        libraryData.removeBook(book);
        activityService.logRemoveBookActivity(title);  // Log activity
    } */

    public void updateBook(String isbn, Book updatedBook) {
        libraryData.updateBook(isbn, updatedBook);
    }

    public void removeBookByTitle(String title) {
        libraryData.removeBookByTitle(title);

    }

    public Book getBookByTitle(String title) {
        return libraryData.getBookByTitle(title);
    }

    public Iterable<String> getRecentActivities() {
        return libraryData.getRecentActivities();
    }

    public List<Book> getAllBooks() {
        return libraryData.getAllBooks();
    }
}
