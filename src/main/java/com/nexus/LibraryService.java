package com.nexus;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    public List<Book> findBooksInDirectory(String directoryPath) {
        List<Book> booksFound = new ArrayList<>();

        Path dir = Paths.get(directoryPath);

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.pdf")){
            for (Path entry : stream){
                String filename = entry.getFileName().toString();
                String fullPath = entry.toAbsolutePath().toString();

                Book newBook = new Book(filename, "Unknown", fullPath, 0);
                booksFound.add(newBook);

                //for debuging
                System.out.println("Found: " + filename);

            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
        return booksFound;
    }
}
