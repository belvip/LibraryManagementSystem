package com.belvinard.libraryManagementSystem.service;

import com.belvinard.libraryManagementSystem.data.LibraryData;

public class ActivityService {
    private LibraryData libraryData;

    // Constructor: Initialize the library data
    public ActivityService(LibraryData libraryData) {
        this.libraryData = libraryData;
    }

    // Log an activity (this method is used by other services to log actions)
    public void logActivity(String activity) {
        libraryData.addRecentActivity(activity);
    }

    // Example: Log the activity when a book is added
    public void logAddBookActivity(String bookTitle) {
        String activity = "Added a new book: " + bookTitle;
        logActivity(activity);
    }

    // Example: Log the activity when a book is removed
    public void logRemoveBookActivity(String bookTitle) {
        String activity = "Removed a book: " + bookTitle;
        logActivity(activity);
    }

    // Example: Log the activity when a book is borrowed
    public void logBorrowBookActivity(String bookTitle, String borrowerName) {
        String activity = "Book '" + bookTitle + "' borrowed by " + borrowerName;
        logActivity(activity);
    }

    // Example: Log the activity when a book is returned
    public void logReturnBookActivity(String bookTitle, String borrowerName) {
        String activity = "Book '" + bookTitle + "' returned by " + borrowerName;
        logActivity(activity);
    }

    // Retrieve the recent activities
    public void printRecentActivities() {
        System.out.println("Recent Activities:");
        for (String activity : libraryData.getRecentActivities()) {
            System.out.println(activity);
        }
    }
}
