package com.aruizmontana.literatura.domain.builder;

import java.util.Map;

public interface Builder {
    Builder setSearch(String search);
    Builder setLanguages(String[] languages);
    Builder setTopic(String topic);
    Builder setYearStart(int yearStart);
    Builder setYearEnd(int yearEnd);
    Map<String, String> buildFilter();
}
