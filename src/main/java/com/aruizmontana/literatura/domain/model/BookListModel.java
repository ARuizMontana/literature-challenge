package com.aruizmontana.literatura.domain.model;


import java.util.List;

public class BookListModel extends Printable {
    private int count;
    private String next;
    private String previous;
    private List<BookModel> results;

    public BookListModel() {}

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<BookModel> getResults() {
        return results;
    }

    public void setResults(List<BookModel> results) {
        this.results = results;
    }

}
