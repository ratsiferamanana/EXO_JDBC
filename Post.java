package org.StudentPortail;

import java.time.LocalDate;
import java.util.List;

public class Post {
    private String id;
    private LocalDate creationDate;
    private String description;
    private User author;
    private List<Field> fields;
    public Post(String id, LocalDate creationDate, String description, User author) {
        this.id = id;
        this.creationDate = creationDate;
        this.description = description;
        this.author = author;


    }
}
