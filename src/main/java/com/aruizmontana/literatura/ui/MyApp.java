package com.aruizmontana.literatura.ui;

import com.aruizmontana.literatura.domain.filter.FilterSearchBuilder;
import com.aruizmontana.literatura.domain.repository.AuthorRepository;
import com.aruizmontana.literatura.domain.repository.BookRepository;
import com.aruizmontana.literatura.ui.utils.CustomConsole;
import com.aruizmontana.literatura.ui.utils.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


@Component
public class MyApp {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CustomConsole console;
    private final Map<Integer, String> available;

    @Autowired
    public MyApp(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        console = new CustomConsole();
        available =  Map.of(1, "es", 2, "en", 3, "fr", 4, "pt");
    }

    public void runApplication() {
        boolean flag = true;
        FilterSearchBuilder filterOptions = new FilterSearchBuilder();
        while (flag) {
            console.clean();
            console.print(Menu.MENU_OPTIONS);
            int option = console.readInt();
            switch (option) {
                case 1:
                    console.print(Menu.SEARCH_PARAMS_FILTER);
                    console.print(filterOptions.toString());
                    console.print(Menu.SEARCH_FILTER);
                    String title = console.readLine();
                    filterOptions.setSearch(title);
                    console.print(Menu.LOADING_TITLE);
                    console.print(bookRepository.getBookListBySearch(filterOptions.buildFilter()));
                    break;
                case 2:
                    console.print(Menu.LOADING_TITLE);
                    console.print(bookRepository.getBookLocalList());
                    break;
                case 3:
                    console.print(Menu.LOADING_TITLE);
                    console.print(authorRepository.getAuthorLocalList());
                    break;

                case 4:
                    console.print(Menu.YEAR_FILTER);
                    int year = console.readInt();
                    console.print(Menu.LOADING_TITLE);
                    console.print(authorRepository.getAuthorAliveLocalList(year));
                    break;

                case 5:
                    console.print(Menu.SEARCH_ID_FILTER);
                    String ids = getBookIds();
                    console.print(Menu.LOADING_TITLE);
                    console.print(bookRepository.getBookListById(ids));
                    break;
                case 7:
                    filterOptions = otherParameters(filterOptions);
                    break;
                case 6:
                    console.print(Menu.LANGUAGE_FILTER);
                    String language = getOnlyLanguagesAvailable();
                    console.print(Menu.LOADING_TITLE);
                    var results = bookRepository.getBookLocalListByLanguage(language);
                    console.print(results);
                    if(results.isSuccess()) {
                        console.print(String.format(Menu.LANGUAGE_COUNT_FILTER,language, results.success().size()));
                    }
                    break;
                case 8:
                    console.print(Menu.LOADING_TITLE);
                    console.print(bookRepository.getBookList());
                    break;
                case 9:
                    flag = false;
                    break;
                default:
                    console.print(Menu.CHOOSE_VALID_OPTION_TITLE);
                    break;
            }
            console.print(Menu.PRESS_ANY_KEY_TITLE);
            console.readLine();
        }
    }

    private String getBookIds() {
        List<Integer> ids = new ArrayList<>();

        while (true) {
            console.clean();
            console.print(Menu.REQUEST_ID_TITLE);
            int option = console.readInt();
            if (option == 0 && ids.isEmpty()) {
                console.print(Menu.ID_VALIDATION_TITLE);
                console.print(Menu.PRESS_ANY_KEY_TITLE);
                console.readLine();
            } else if (option == 0) {
                break;
            } else {
                ids.add(option);
            }

        }
        return String.join(",", ids.stream().map(Object::toString).toList());
    }

    private FilterSearchBuilder otherParameters(FilterSearchBuilder older) {
        FilterSearchBuilder filterOptions = older;
        boolean flag = true;
        while (flag) {
            console.clean();
            console.print(Menu.SUB_MENU_OPTIONS);
            int option = console.readInt();
            switch (option) {
                case 1 -> {
                    var selectedLanguages = getLanguagesAvailable();
                    if (selectedLanguages.length > 0) {
                        filterOptions.setLanguages(selectedLanguages);
                    }
                }
                case 2 -> {
                    console.clean();
                    console.print(Menu.TOPIC_TITLE);
                    var topic = console.readLine();
                    if (topic != null && !topic.trim().isEmpty()) {
                        filterOptions.setTopic(topic);
                    }
                }
                case 3 -> {
                    var start = getYear(Menu.SEARCH_BIRTH_FILTER);
                    var end = getYear(Menu.SEARCH_DEATH_FILTER);
                    filterOptions.setYearStart(start);
                    filterOptions.setYearEnd(end);
                }
                case 4 -> {
                    filterOptions = new FilterSearchBuilder();
                    console.print(Menu.CLEANING_TITLE);
                }
                default -> flag = false;
            }
        }
        return filterOptions;
    }

    private String[] getLanguagesAvailable() {
        HashSet<String> languages = new HashSet<>();
        while (true) {
            console.clean();
            console.print(Menu.LANGUAGES_SELECTED_TITLE);
            console.print(languages.toString());
            console.print(Menu.LANGUAGES_TITLE);
            int option = console.readInt();
            if (option == 0 && languages.isEmpty()) {
                console.print(Menu.LANGUAGE_VALIDATION_TITLE);
                console.print(Menu.PRESS_ANY_KEY_TITLE);
                console.readLine();
            } else if (option ==0 ) {
                break;
            } else if (option == 5) {
                languages.clear();
            } else {
                languages.add(available.get(option));
            }
        }
        return languages.toArray(new String[0]);
    }

    private String getOnlyLanguagesAvailable() {
        while (true) {
            console.clean();
            console.print(Menu.ONLY_LANGUAGES_TITLE);
            int option = console.readInt();
            if (option < 1 || option > available.size()) {
                console.print(Menu.LANGUAGE_VALIDATION_TITLE);
                console.print(Menu.PRESS_ANY_KEY_TITLE);
                console.readLine();
            } else {
                 return available.get(option);
            }
        }
    }

    private int getYear(String title) {
        int year = 0;
        while (true) {
            console.clean();
            console.print(title);
            int option = console.readInt();
            if (option < -500 || option > 2024) {
                console.print(String.format(Menu.YEAR_VALIDATION_TITLE, -500, 2024));
                console.print(Menu.PRESS_ANY_KEY_TITLE);
                console.readLine();
                continue;
            }
            year = option;
            break;
        }
        return year;
    }
}
