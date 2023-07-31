import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    private List<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.init();
    }

    private void init() {
        System.out.println("Welcome to the Library Management System!");

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    generateReport();
                    break;
                case 6:
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author: ");
        String author = scanner.nextLine();

        Book newBook = new Book(title, author);
        books.add(newBook);
        System.out.println("Book added successfully.");
    }

    private void searchBook() {
        System.out.print("Enter the book title or author: ");
        String query = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query)) {
                System.out.println("Book found:");
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Availability: " + (book.isAvailable() ? "Available" : "Not Available"));
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void borrowBook() {
        System.out.print("Enter the book title to borrow: ");
        String title = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Book is not available for borrowing.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void returnBook() {
        System.out.print("Enter the book title to return: ");
        String title = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setAvailable(true);
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void generateReport() {
        System.out.println("Library Report:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Availability: " + (book.isAvailable() ? "Available" : "Not Available"));
            System.out.println();
        }
    }
}
