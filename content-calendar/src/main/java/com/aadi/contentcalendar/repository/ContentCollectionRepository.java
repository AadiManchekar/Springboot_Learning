package com.aadi.contentcalendar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aadi.contentcalendar.model.Content;

public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findById(Integer id) {
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

}
