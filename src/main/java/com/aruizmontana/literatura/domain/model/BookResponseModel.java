package com.aruizmontana.literatura.domain.model;

public class BookResponseModel extends Printable {
    private final String title;
    private final String author;
    private final String language;
    private final int downloadCount;

    public BookResponseModel(String title, String author, String language, int downloadCount) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.downloadCount = downloadCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }

    public int getDownloadCount() {
        return downloadCount;
    }
}
