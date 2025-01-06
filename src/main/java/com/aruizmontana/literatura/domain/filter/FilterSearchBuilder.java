package com.aruizmontana.literatura.domain.filter;

import com.aruizmontana.literatura.domain.builder.Builder;

import java.util.HashMap;
import java.util.Map;

public class FilterSearchBuilder implements Builder {
    private String search;
    private String[] languages;
    private String topic;
    private int yearStart;
    private int yearEnd;

    @Override
    public Builder setSearch(String search) {
        this.search = search;
        return this;
    }

    @Override
    public Builder setLanguages(String[] languages) {
        this.languages = languages;
        return this;
    }

    @Override
    public Builder setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    @Override
    public Builder setYearStart(int yearStart) {
        this.yearStart = yearStart;
        return this;
    }

    @Override
    public Builder setYearEnd(int yearEnd) {
        this.yearEnd = yearEnd;
        return this;
    }

    @Override
    public Map<String, String> buildFilter() {
        Map<String, String> filters = new HashMap<>();
        if(search != null) {
            filters.put("search", search);
        }
        if(languages !=null && languages.length > 0) {
            filters.put("languages", String.join(",", languages));
        }
        if(topic != null) {
            filters.put("topic", topic);
        }
        if(yearStart > 0) {
            filters.put("yearStart", String.valueOf(yearStart));
        }
        if(yearEnd > 0) {
            filters.put("yearEnd", String.valueOf(yearEnd));
        }
        return filters;
    }

    @Override
    public String toString() {
        String message = "";
        if(languages !=null && languages.length > 0) {
            message  = message.concat("languages: ").concat(String.join(",", languages));
        }
        if(topic != null) {
            message  = message.concat(" - topic: ").concat(topic);
        }
        if(yearStart > 0) {
            message  = message.concat(" - año de nacimiento: ").concat(String.valueOf(yearStart));
        }
        if(yearEnd > 0) {
            message  = message.concat(" - año de muerte: ").concat(String.valueOf(yearEnd));
        }
        return message.isEmpty() ? "No se aplicaran filtros en la busqueda" : message;
    }
}
