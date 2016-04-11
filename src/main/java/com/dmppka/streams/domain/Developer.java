package com.dmppka.streams.domain;

import java.util.List;

public class Developer {

    private final String name;
    private final List<ProgrammingLanguage> languages;

    public Developer(String name, List<ProgrammingLanguage> languages) {
        this.name = name;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public List<ProgrammingLanguage> getLanguages() {
        return languages;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                '}';
    }
}
