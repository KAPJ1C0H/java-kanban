package com.yandex.app.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
void testTaskEqualityById() {
    Task task1 = new Task("Задача 1", "Описание задачи 1", Status.NEW);
    Task task2 = new Task("Задача 2", "Описание задачи 2", Status.NEW);

    task1.setId(1);
    task2.setId(1);

    assertEquals(task1, task2, "Задачи с одинаковым ID должны быть равны.");
}
    @Test
void testSubtaskEqualityById() {
    Subtask subtask1 = new Subtask("Подзадача 1", "Описание подзадачи 1", Status.NEW, 1);
    Subtask subtask2 = new Subtask("Подзадача 2", "Описание подзадачи 2", Status.NEW, 1);

    subtask1.setId(1);
    subtask2.setId(1);

    assertEquals(subtask1, subtask2, "Подзадачи с одинаковым ID должны быть равны.");
}

}