package com.esfpoi1.githubprojects.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskTest {

    @Test
    void shouldCreateTaskWithTodoStatus() {
        Task task = new Task("Implement GitHub Projects spike");

        assertNotNull(task.getId());
        assertEquals("Implement GitHub Projects spike", task.getTitle());
        assertEquals(TaskStatus.TODO, task.getStatus());
    }

    @Test
    void shouldStartTask() {
        Task task = new Task("Implement domain model");

        task.start();

        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
    }

    @Test
    void shouldCompleteTask() {
        Task task = new Task("Implement domain model");

        task.complete();

        assertEquals(TaskStatus.DONE, task.getStatus());
    }

    @Test
    void shouldRejectNullTitle() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task(null)
        );
    }

    @Test
    void shouldRejectEmptyTitle() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task("")
        );
    }

    @Test
    void shouldRejectBlankTitle() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task("   ")
        );
    }
}