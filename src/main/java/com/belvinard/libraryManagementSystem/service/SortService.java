package com.belvinard.libraryManagementSystem.service;

import com.belvinard.libraryManagementSystem.data.LibraryData;
import com.belvinard.libraryManagementSystem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortService {

    private final LibraryData libraryData;

    @Autowired
    public SortService(LibraryData libraryData) {
        this.libraryData = libraryData;
    }

    // Bubble Sort
    public void bubbleSortByTitle() {
        List<Book> books = libraryData.getBookCollection();
        for (int i = 0; i < books.size() - 1; i++) {
            for (int j = 0; j < books.size() - 1 - i; j++) {
                if (books.get(j).getTitle().compareTo(books.get(j + 1).getTitle()) > 0) {
                    // Swap
                    Book temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
    }

    // Selection Sort
    public void selectionSortByTitle() {
        List<Book> books = libraryData.getBookCollection();
        for (int i = 0; i < books.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < books.size(); j++) {
                if (books.get(j).getTitle().compareTo(books.get(minIndex).getTitle()) < 0) {
                    minIndex = j;
                }
            }
            // Swap
            Book temp = books.get(minIndex);
            books.set(minIndex, books.get(i));
            books.set(i, temp);
        }
    }

    // QuickSort method to sort books by title
    public void quickSortByTitle(List<Book> books, int low, int high) {
        if (low < high) {
            // Find pivot element such that books[low..high] is sorted
            int pi = partition(books, low, high);

            // Recursively sort elements before and after partition
            quickSortByTitle(books, low, pi - 1);
            quickSortByTitle(books, pi + 1, high);
        }
    }

    // Partition method to help with the sorting
    private int partition(List<Book> books, int low, int high) {
        return 0;
    }

    public void quickSortByTitle() {
    }
}
