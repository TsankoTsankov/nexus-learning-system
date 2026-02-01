package com.nexus;

import java.util.List;
import java.util.Scanner;

public class NexusApp {
    public static void main(String[] args) {
        com.nexus.db.DatabaseManager.initializeDatabase();

        Scanner scanner = new Scanner(System.in);
        LibraryService libraryService = new LibraryService();

        System.out.println("===================================");
        System.out.println("     Nexus: The Knowledge Core     ");
        System.out.println("===================================");

        System.out.println("Enter the PATH to the folder to be scanned: ");
        String pathInput = scanner.nextLine();

        if (pathInput.isBlank()){
            System.out.println("Error: Please provide apath. Exiting...");
            return;
        }
        System.out.println("Scanning '" + pathInput + "'...");
        List<Book> books = libraryService.findBooksInDirectory(pathInput);
        System.out.println("Found " + books.size() +" PDF files");

        System.out.println("\n--- Verifying Database Content ---");
        com.nexus.db.BookDAO bookDAO = new com.nexus.db.BookDAO();
        List<Book> dbBooks = bookDAO.getAllBooks();

        System.out.println("Database contains " + dbBooks.size() + " books:");
        for (Book b :dbBooks) {
            System.out.println(" [DB] " + b.getTitle());
        }
        System.out.println("===================================");
    }
}
