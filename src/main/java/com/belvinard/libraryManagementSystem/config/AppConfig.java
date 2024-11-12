package com.belvinard.libraryManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.belvinard.libraryManagementSystem.data.LibraryData;
import com.belvinard.libraryManagementSystem.service.BookService;
import com.belvinard.libraryManagementSystem.service.HistoryService;
import com.belvinard.libraryManagementSystem.service.SearchService;
import com.belvinard.libraryManagementSystem.service.SortService;

@Configuration
@ComponentScan(basePackages = "com.belvinard.libraryManagementSystem")
public class AppConfig {

    // Define beans for all services if not using @Component
    @Bean
    public LibraryData libraryData() {
        return new LibraryData();
    }

    @Bean
    public BookService bookService() {
        return new BookService(libraryData());
    }

    @Bean
    public HistoryService historyService() {
        return new HistoryService(libraryData());
    }

    @Bean
    public SearchService searchService() {
        return new SearchService(libraryData());
    }

    @Bean
    public SortService sortService() {
        return new SortService(libraryData());
    }
}
