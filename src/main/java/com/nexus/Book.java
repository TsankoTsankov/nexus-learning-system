package com.nexus;

public class Book {
    private String title;
    private String author;
    private String filePath;
    private int totalPages;
    private int currentPage;
    private ReadingStatus status;

    // Constructor
    public Book(String title, String author, String filePath, int totalPages){
        this.title = title;
        this.author = author;
        this.filePath = filePath;
        this.totalPages = totalPages;
        this.currentPage = 0; // default to page 0 (not started reading)
        this.status = ReadingStatus.NEW; // default to NEW
    }

    // Getters -- READ-ONLY
    public String getTitle(){ return title; }
    public String getAuthor(){ return author; }
    public String getFilePath(){ return filePath; }
    public int getTotalPages(){ return totalPages; }
    public int getCurrentPage(){ return currentPage; }
    public ReadingStatus getStatus(){ return status; }

    //Setters
    public void setTitle(String title){ this.title = title; }
    public void setAuthor(String author){ this.author = author; }
    public void setFilePath(String filePath){ this.filePath = filePath; }
    public void setStatus(ReadingStatus status){ this.status = status; }

    public void setCurrentPage(int currentPage){
        if (currentPage > totalPages){
            System.out.println("Error: Page read past the end of the book.");
            this.currentPage = totalPages;
        } else if (currentPage < 0) {
            System.out.println("Error: Page cannot be negative.");
        }else {
            this.currentPage = currentPage;
        }
    }
}