package com.belvinard.libraryManagementSystem;

import com.belvinard.libraryManagementSystem.console.ConsoleHandler;
import com.belvinard.libraryManagementSystem.service.BookService;
import com.belvinard.libraryManagementSystem.service.HistoryService;
import com.belvinard.libraryManagementSystem.service.SearchService;
import com.belvinard.libraryManagementSystem.service.SortService;
import com.belvinard.libraryManagementSystem.data.LibraryData;

public class LibraryManagementSystemApplication {

    public static void main(String[] args) {
        LibraryData libraryData = new LibraryData();
        BookService bookService = new BookService(libraryData);
        HistoryService historyService = new HistoryService(libraryData);
        SearchService searchService = new SearchService(libraryData);
        SortService sortService = new SortService(libraryData);

        ConsoleHandler consoleHandler = new ConsoleHandler(bookService, historyService, searchService, sortService);
        consoleHandler.start();
    }
}
