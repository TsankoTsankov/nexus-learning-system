package com.nexus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void testBookCreationDefaults(){
        Book book = new Book("The Hobbit", "Tolkein", "path/hobbit.pdf", 300);

        assertEquals("The Hobbit", book.getTitle());
        assertEquals(0, book.getCurrentPage(), "New book should start at page 0");
        assertEquals(ReadingStatus.NEW,book.getStatus(), "New book should be status NEW");
    }
    @Test
    void testSetCurrentPageValidation(){
        Book book = new Book("Test Book", "Author", "path", 100);

        // scenario 1 = valid page
        book.setCurrentPage(50);
        assertEquals(50, book.getCurrentPage());

        // scenario 2 = negative page (should be handled or ignored)
        book.setCurrentPage(-10);
        assertEquals(50, book.getCurrentPage(), "Should not allow negative pages");

        // scenario 3 = page > totalPages (should cap at total)
        book.setCurrentPage(999);
        assertEquals(100, book.getCurrentPage(), "Should cap at total pages");
    }
}