package com.nexus.db;

import com.nexus.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {
    public void save(Book book) {
        String sql = """
                INSERT OR IGNORE INTO books (title, author, file_path, total_pages, current_page, status)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        try (Connection conn = DatabaseManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getFilePath());
            pstmt.setInt(4, book.getTotalPages());
            pstmt.setInt(5, book.getCurrentPage());
            pstmt.setString(6, book.getStatus().toString());

            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error saving book: " + e.getMessage());
        }
    }
    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DatabaseManager.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String path = rs.getString("file_path");
                int totalPages = rs.getInt("total_pages");

                Book book = new Book(title, author, path, totalPages);
                books.add(book);
            }
        }catch (SQLException e){
            System.out.println("Error loading books: " + e.getMessage());
        }
        return books;
    }
}
