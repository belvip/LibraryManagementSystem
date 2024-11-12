package com.belvinard.libraryManagementSystem.model;

import lombok.*;

import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int publicationYear;
    private String genre;

    public Book(String number, String testBook, String testAuthor, String fiction, int i) {
    }

    // Setter with validation for ISBN format (5 characters) and publication year range
    public void setISBN(String ISBN){
        if (ISBN == null || !Pattern.matches("\\{5}", ISBN)) {
            throw new IllegalArgumentException("Invalid ISBN format. Must be 5 digits.");
        }
        this.ISBN = ISBN;
    }

    public void setPublicationYear(int publicationYear) {
        // Validate publication year (between 1000 and current year)
        int currentYear = java.time.Year.now().getValue();
        if(publicationYear < 1000 || publicationYear > currentYear){
            throw new IllegalArgumentException("Invalid publication year. It must be between 1000 and the current year.");

        }
        this.publicationYear = publicationYear;
    }

    public void setAuthor(String author) {
        // Validate author format: Only alphabetic characters and spaces allowed (can be more restrictive if needed)
        if(author == null || Pattern.matches("^[a-zA-Z]+([\\s][a-zA-Z]+)*$", author)){
            throw new IllegalArgumentException("Invalid author format. Only alphabetic characters and space are allowed.");
        }
        this.author = author;
    }

    public void setTitle(String title){
        // Validate title: Should be at least 3 characters long and not empty
        if(title == null || title.trim().isEmpty() || title.length() < 3) {
            throw new IllegalArgumentException("Invalid title. It must be at least 3 characters long and not empty.");

        }
        this.title = title;

        // Validate title format (Optional): Only alphabetic characters and spaces (e.g., "The Great Gatsby")
        if (!Pattern.matches("^[a-zA-Z0-9\\s]+$", title)) {
            throw new IllegalArgumentException("Invalid title format. Only alphabetic characters, numbers, and spaces are allowed.");
        }

        this.title = title;

    }

    public void setGenre(String genre) {
        // Validate genre: Should be one of the predefined values
        String[] allowedGenres = {"Fiction", "Non-Fiction", "Fantasy", "Science Fiction", "Biography", "History"};
        if(genre == null || !isValidGenre(genre, allowedGenres)) {
            throw new IllegalArgumentException("Invalid genre. It must be one of: Fiction, Non-Fiction, Fantasy, Science Fiction, Biography, History.");
        }
        this.genre = genre;
    }


    // Helper method to check if genre is valid
    private boolean isValidGenre(String genre, String[] allowedGenres) {
        for (String allowedGenre : allowedGenres) {
            if (allowedGenre.equalsIgnoreCase(genre)) {
                return true;
            }
        }
        return false;
    }




}
