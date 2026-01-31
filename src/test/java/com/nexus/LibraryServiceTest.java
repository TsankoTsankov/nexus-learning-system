package com.nexus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.nio.file.Path;
import java.util.List;

class LibraryServiceTest {
    //AAA:
    // Arrange (Create the object exactly like you would in main)
    // Act ( for LibraryService, since it returns a value (booksFound(List), we use Type 1 - Calculator)
    // Assert ( does the method work)

    @Test
    void testFindBookInDirectory() {
        LibraryService service = new LibraryService();
        String testPath = Path.of("src/test/resources/test-library").toAbsolutePath().toString();

        List<Book> results = service.findBooksInDirectory((testPath));

        assertEquals(5, results.size(), "Should find exactly 5 PDF files");

        // implicitly check if we ignored the TXT file

        Book foundBook = results.get(0); // get the first book
        assertEquals("aBook.pdf", foundBook.getTitle());
    }

}