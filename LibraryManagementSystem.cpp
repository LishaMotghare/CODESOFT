#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

// Structure to represent a book
struct Book {
    std::string title;
    std::string author;
    std::string isbn;
    bool isAvailable;
};

// Structure to represent a borrower
struct Borrower {
    std::string name;
    std::string id;
};

// Structure to represent a transaction
struct Transaction {
    Book book;
    Borrower borrower;
    std::string checkoutDate;
    std::string returnDate;
};

// Function to add a book to the database
void addBook(std::vector<Book>& books) {
    Book newBook;
    std::cout << "Enter book title: ";
    std::getline(std::cin, newBook.title);
    std::cout << "Enter book author: ";
    std::getline(std::cin, newBook.author);
    std::cout << "Enter book ISBN: ";
    std::getline(std::cin, newBook.isbn);
    newBook.isAvailable = true;
    books.push_back(newBook);
}

// Function to search for a book in the database
void searchBook(const std::vector<Book>& books) {
    std::string query;
    std::cout << "Enter book title, author, or ISBN: ";
    std::getline(std::cin, query);

    for (const auto& book : books) {
        if (book.title.find(query) != std::string::npos ||
            book.author.find(query) != std::string::npos ||
            book.isbn.find(query) != std::string::npos) {
            std::cout << "Book found: " << book.title << " by " << book.author << std::endl;
            return;
        }
    }

    std::cout << "Book not found." << std::endl;
}

// Function to check out a book
void checkoutBook(std::vector<Book>& books, std::vector<Transaction>& transactions) {
    std::string isbn;
    std::cout << "Enter book ISBN: ";
    std::getline(std::cin, isbn);

    for (auto& book : books) {
        if (book.isbn == isbn && book.isAvailable) {
            book.isAvailable = false;

            Transaction newTransaction;
            newTransaction.book = book;
            std::cout << "Enter borrower name: ";
            std::getline(std::cin, newTransaction.borrower.name);
            std::cout << "Enter borrower ID: ";
            std::getline(std::cin, newTransaction.borrower.id);
            newTransaction.checkoutDate = "2024-02-20"; // Replace with current date
            transactions.push_back(newTransaction);

            std::cout << "Book checked out successfully." << std::endl;
            return;
        }
    }

    std::cout << "Book not available or not found." << std::endl;
}

// Function to return a book
void returnBook(std::vector<Book>& books, std::vector<Transaction>& transactions) {
    std::string isbn;
    std::cout << "Enter book ISBN: ";
    std::getline(std::cin, isbn);

    for (auto& book : books) {
        if (book.isbn == isbn && !book.isAvailable) {
            book.isAvailable = true;

            for (auto& transaction : transactions) {
                if (transaction.book.isbn == isbn) {
                    transaction.returnDate = "2024-02-20"; // Replace with current date
                    std::cout << "Book returned successfully." << std::endl;
                    return;
                }
            }
        }
    }

    std::cout << "Book not found or already available." << std::endl;
}

// Function to calculate fine for overdue books
void calculateFine(const std::vector<Transaction>& transactions) {
    // Replace with actual fine calculation logic
    std::cout << "Fine calculation not implemented." << std::endl;
}

int main() {
    std::vector<Book> books;
    std::vector<Transaction> transactions;

    while (true) {
        std::cout << "Library Management System" << std::endl;
        std::cout << "1. Add Book" << std::endl;
        std::cout << "2. Search Book" << std::endl;
        std::cout << "3. Checkout Book" << std::endl;
        std::cout << "4. Return Book" << std::endl;
        std::cout << "5. Calculate Fine" << std::endl;
        std::cout << "6. Exit" << std::endl;
        std::cout << "Enter your choice: ";

        int choice;
        std::cin >> choice;
        std::cin.ignore(); // Ignore newline character

        switch (choice) {
            case 1:
                addBook(books);
                break;
            case 2:
                searchBook(books);
                break;
            case 3:
                checkoutBook(books, transactions);
                break;
            case 4:
                returnBook(books, transactions);
                break;
            case 5:
                calculateFine(transactions);
                break;
            case 6:
                return 0;
            default:
                std::cout << "Invalid choice. Please try again." << std::endl;
        }
    }

    return 0;
}