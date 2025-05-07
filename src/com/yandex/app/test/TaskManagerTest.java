package com.yandex.app.test;

import com.yandex.app.model.Status;
import com.yandex.app.model.Task;
import com.yandex.app.service.history.HistoryManager;
import com.yandex.app.service.manager.Managers;
import com.yandex.app.service.manager.TaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void testTaskIdConflict() {
        TaskManager taskManager = Managers.getDefault();

        Task task1 = new Task("Задача 1", "Описание задачи 1", Status.NEW);
        Task task2 = new Task("Задача 1", "Описание задачи 1", Status.NEW);

        int id1 = taskManager.addNewTask(task1);
        int id2 = taskManager.addNewTask(task2);

        assertNotEquals(id1, id2, "Сгенерированные ID не должны конфликтовать.");
    }
    @Test
    void testTaskImmutabilityOnAdd() {
        TaskManager taskManager = Managers.getDefault();
        Task task = new Task("Задача 1", "Описание 1", Status.NEW);
        final int taskId = taskManager.addNewTask(task.copy()); // Используем метод copy

        final Task savedTask = taskManager.getTask(taskId);

        assertEquals(task.getName(), savedTask.getName(), "Имена задач должны совпадать.");
        assertEquals(task.getDescription(), savedTask.getDescription(), "Описание задач должно совпадать.");
        assertEquals(task.getStatus(), savedTask.getStatus(), "Статусы задач должны совпадать.");

        task.setName("Обновленная задача");
        task.setDescription("Обновленное описание");
        task.setStatus(Status.IN_PROGRESS);

        assertNotEquals(task.getName(), savedTask.getName(), "Имя сохранённой задачи не должно изменяться.");
        assertNotEquals(task.getDescription(), savedTask.getDescription(), "Описание сохранённой задачи не должно изменяться.");
        assertNotEquals(task.getStatus(), savedTask.getStatus(), "Статус сохранённой задачи не должен изменяться.");
    }

    @Test
    void testManagersReturnInitializedInstances() {
        TaskManager taskManager = Managers.getDefault();
        HistoryManager historyManager = Managers.getDefaultHistory();

        assertNotNull(taskManager, "TaskManager не должен быть null.");
        assertNotNull(historyManager, "HistoryManager не должен быть null.");
    }
}