package com.belvinard.libraryManagementSystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowHistory {
    private String borrowerName;
    private BorrowHistory next;

    // Constructor with validation for borrowerName using regex
    public BorrowHistory(String borrowerName) {
        if (borrowerName == null || borrowerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Borrower name must not be null or empty.");
        }

        // Regex to allow only alphabetic characters, spaces, and hyphens (for compound names)
        if (!borrowerName.matches("^[A-Za-z]+([\\s-][A-Za-z]+)*$")) {
            throw new IllegalArgumentException("Invalid borrower name. Only alphabetic characters, spaces, and hyphens are allowed.");
        }

        this.borrowerName = borrowerName;
    }
}
