package com.aruizmontana.literatura.domain.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class BookModel extends Printable {
    private int id;
    private String title;
    private String[] subjects;
    private PersonModel[] authors;
    private PersonModel[] translators;
    private String[] bookshelves;
    private String[] languages;
    private boolean copyright;
    @SerializedName("media_type")
    private String mediaType;
    private Map<String, String> formats;
    @SerializedName("download_count")
    private int downloadCount;

    public BookModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public PersonModel[] getAuthors() {
        return authors;
    }

    public void setAuthors(PersonModel[] authors) {
        this.authors = authors;
    }

    public PersonModel[] getTranslators() {
        return translators;
    }

    public void setTranslators(PersonModel[] translators) {
        this.translators = translators;
    }

    public String[] getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(String[] bookshelves) {
        this.bookshelves = bookshelves;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public boolean isCopyright() {
        return copyright;
    }

    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Map<String, String> getFormats() {
        return formats;
    }

    public void setFormats(Map<String, String> formats) {
        this.formats = formats;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }
}
