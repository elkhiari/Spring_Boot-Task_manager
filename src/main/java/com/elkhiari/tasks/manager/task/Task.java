package com.elkhiari.tasks.manager.task;

import jakarta.persistence.*;

@Entity
@Table
public class Task {

    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )

    private long id;
    private String title;
    private boolean complete;

    public Task() {
    }

    public Task(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Task(long id, String title, boolean complete) {
        this.id = id;
        this.title = title;
        this.complete = complete;
    }

    public Task(String title) {
        this.title = title;
        this.complete = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
