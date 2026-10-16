package com.esfpoi1.githubprojects.task;

import java.util.Objects;
import java.util.UUID;

public final class Task {

    private final UUID id;
    private final String title;
    private TaskStatus status;

    public Task(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be blank");
        }

        this.id = UUID.randomUUID();
        this.title = title;
        this.status = TaskStatus.TODO;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void start() {
        status = TaskStatus.IN_PROGRESS;
    }

    public void complete() {
        status = TaskStatus.DONE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Task task)) {
            return false;
        }

        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}