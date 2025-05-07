package com.yandex.app.service.manager;

import com.yandex.app.model.Epic;
import com.yandex.app.model.Status;
import com.yandex.app.model.Subtask;
import com.yandex.app.model.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {
    @Test
    void testInMemoryTaskManagerAddAndFindTasks() {
        TaskManager taskManager = new InMemoryTaskManager();
        Task task = new Task("Задача 1", "Описание 1", Status.NEW);

        final int taskId = taskManager.addNewTask(task);

        Task foundTask = taskManager.getTask(taskId);

        assertNotNull(foundTask, "Подзадача должна быть найдена.");
        assertEquals(task.getName(), foundTask.getName(), "Имена задач должны совпадать.");
        assertEquals(task.getDescription(), foundTask.getDescription(), "Описание задач должно совпадать.");
        assertEquals(task.getStatus(), foundTask.getStatus(), "Статусы задач должны совпадать.");
    }

}