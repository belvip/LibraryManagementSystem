package com.belvinard.libraryManagementSystem.service;

import com.belvinard.libraryManagementSystem.data.LibraryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    private final LibraryData libraryData;

    @Autowired
    public HistoryService(LibraryData libraryData) {
        this.libraryData = libraryData;
    }

    public void addBorrowingHistory(String historyEntry) {
        libraryData.addBorrowingHistory(historyEntry);
    }

    public void addRecentActivity(String activity) {
        libraryData.addRecentActivity(activity);
    }

    // Get the entire borrowing history
    public Iterable<String> getHistory() {
        return libraryData.getBorrowingHistory();
    }

}
