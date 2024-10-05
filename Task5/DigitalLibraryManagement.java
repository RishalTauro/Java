
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Model for Book
class Book {

    int id;
    String title;
    boolean isIssued;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    public void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("Book issued: " + title);
        } else {
            System.out.println("Book is already issued.");
        }
    }

    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println("Book returned: " + title);
        } else {
            System.out.println("This book was not issued.");
        }
    }
}

// Admin Module
class Admin {

    List<Book> books;

    public Admin() {
        books = new ArrayList<>();
    }

    // Add a new book
    public void addBook(int id, String title) {
        books.add(new Book(id, title));
        System.out.println("New book added: " + title);
    }

    // Remove a book by ID
    public void removeBook(int id) {
        books.removeIf(book -> book.id == id);
        System.out.println("Book removed.");
    }

    // View all books
    public void viewAllBooks() {
        for (Book book : books) {
            System.out.println("ID: " + book.id + " | Title: " + book.title + " | Issued: " + book.isIssued);
        }
    }
}

// User Module
class User {

    Admin admin;

    public User(Admin admin) {
        this.admin = admin;
    }

    // Search a book by title
    public void searchBook(String title) {
        for (Book book : admin.books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + title);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Issue a book
    public void issueBook(int id) {
        for (Book book : admin.books) {
            if (book.id == id) {
                book.issueBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Return a book
    public void returnBook(int id) {
        for (Book book : admin.books) {
            if (book.id == id) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

// Main class to run the program
public class DigitalLibraryManagement {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        }
        Admin admin = new Admin();
        User user = new User(admin);

        // Admin actions
        admin.addBook(1, "Data Science 101");
        admin.addBook(2, "Java Programming");

        // User actions
        user.searchBook("Java Programming");
        user.issueBook(2);
        user.returnBook(2);
    }
}
