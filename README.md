# 📚 Library Management System - Model Package Overview

The `com.belvinard.libraryManagementSystem.model` package contains the core classes that represent the data and functionality of the library system. Below are the key components of this package:

## 1. Book Class 📖

The `Book` class represents a book in the library. It contains attributes that define a book, such as the title, author, ISBN, publication year, and genre.

### Key Features:
- **Attributes**:
  - `title`: The title of the book. 📖
  - `author`: The name of the author. 🧑‍🏫
  - `ISBN`: The ISBN number (validated to be a 5-digit number).
  - `publicationYear`: The year the book was published (validated to be within a valid range).
  - `genre`: The genre of the book (validated to be one of the predefined genres).

- **Methods**:
  - `setISBN`: Validates that the ISBN is a 5-digit number.
  - `setPublicationYear`: Validates that the year is within a valid range (1000 to current year).
  - `setAuthor`: Validates that the author's name contains only alphabetic characters and spaces.
  - `setTitle`: Validates that the title is at least 3 characters long and contains only valid characters.
  - `setGenre`: Validates that the genre is one of the allowed genres (e.g., Fiction, Non-Fiction, etc.).

- **Additional Features**:
  - **Linked list for managing borrow history**: Each time a book is borrowed, a new record is added.
  - Method to **add borrow records** and **retrieve the borrow history**.


## 2. BorrowHistory Class 🧾

The `BorrowHistory` class keeps track of the borrowing history for a book. It stores the name of the borrower and links to the next borrow record.

### Key Features:
- **Attributes**:
  - `borrowerName`: The name of the person who borrowed the book.
  - `next`: A reference to the next borrow record (forming a linked list).

- **Methods**:
  - **Constructor**: Validates that `borrowerName` is not null or empty and uses a regex to ensure the name contains only valid characters (letters, spaces, and hyphens).


## 📁 Package Summary 📁

- **Purpose**: This package contains the data models and core logic for representing books and their borrowing history, as well as managing the library’s book collection.

- **Structure**:
  - **Book**: Represents individual books with detailed validation on attributes.
  - **BorrowHistory**: Tracks borrowing details (borrower name, history).
  - **LibraryData**: Manages the collection of books and provides functionalities for adding, removing, updating, and retrieving books.

---

## LibraryData Package 📚

The `LibraryData` class is part of the `com.belvinard.libraryManagementSystem.data` package. It manages the library's book collection, borrowing history, and recent activities. It provides methods for adding, removing, and updating books, as well as logging actions like borrowing and book management.

### Key Features 🛠️

1. **Book Collection** 📖  
   - `bookCollection`: Stores all books in the library as a `List` (`ArrayList<Book>`).
   - **Methods**:
     - `addBook(Book book)`: Adds a new book to the collection. Ensures no duplicates by checking ISBN.
     - `removeBook(Book book)`: Removes a book from the collection based on a specific book object.
     - `getBookCollection()`: Retrieves the entire list of books in the collection.

2. **Borrowing History** 📜  
   - `borrowingHistory`: Tracks the borrowing history as a `LinkedList<String>`.
   - **Methods**:
     - `addBorrowingHistory(String historyEntry)`: Adds an entry to the borrowing history.
     - `getBorrowingHistory()`: Retrieves the complete borrowing history.

3. **Recent Activities** 📝  
   - `recentActivities`: Stores the most recent activities (like adding/removing books) in a `Stack<String>`.
   - **Methods**:
     - `addRecentActivity(String activity)`: Logs an activity (e.g., "Added book: Java Programming").
     - `getRecentActivities()`: Retrieves the log of recent activities.

4. **Book Management** 🔧  
   - **Update and Remove Books**: Methods to update or remove books based on attributes such as ISBN, title, genre, or author:
     - `updateBook(String isbn, Book updatedBook)`: Updates book details based on ISBN.
     - `removeBookByTitle(String title)`: Removes a book by title.
     - `removeBookByGenre(String genre)`: Removes a book by genre.
     - `removeBookByAuthor(String author)`: Removes a book by author.

5. **Search Books** 🔍  
   - **Find Books by Attributes**: Methods to search for books by title, genre, author, or ISBN:
     - `getBookByTitle(String title)`: Retrieves a book by its title.
     - `getBookByGenre(String genre)`: Retrieves a book by its genre.
     - `getBookByAuthor(String author)`: Retrieves a book by its author.
     - `getBookByISBN(String ISBN)`: Retrieves a book by its ISBN.

6. **Update Books by Attributes** 🖊️  
   - **Update a Book**: Allows updating of book details by title, genre, or author:
     - `updateBookByTitle(String title, Book updatedBook)`: Updates book details based on title.
     - `updateBookByGenre(String genre, Book updatedBook)`: Updates book details based on genre.
     - `updateBookByAuthor(String author, Book updatedBook)`: Updates book details based on author.

### Error Handling ⚠️
The class contains robust error handling, throwing `IllegalArgumentException` when:
- A book is null or doesn't exist in the collection.
- ISBN is empty or invalid.
- Trying to remove or update a non-existent book.
- Invalid activity or borrowing history entry.

### Example Usage 🖥️

```java
LibraryData libraryData = new LibraryData();

// Add a new book
Book book1 = new Book("Java Programming", "John Doe", "12345", 2020, "Programming");
libraryData.addBook(book1);

// Update a book
Book updatedBook = new Book("Java Programming", "John Doe", "12345", 2023, "Programming");
libraryData.updateBook("12345", updatedBook);

// Remove a book by title
libraryData.removeBookByTitle("Java Programming");

// Get all books
List<Book> books = libraryData.getAllBooks();
```

### Summary 📑

The `LibraryData` class is designed to manage books, borrowing history, and recent activities in a library system. It allows efficient addition, removal, and updating of books while ensuring that all actions are logged and any potential errors are handled gracefully.



Book book1 = new Book("Title1", "Author1", "ISBN001", 2020, "Fiction");
        Book book2 = new Book("Title2", "Author2", "ISBN002", 2021, "Non-Fiction");