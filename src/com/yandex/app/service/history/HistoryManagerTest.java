package com.yandex.app.service.history;

import com.yandex.app.model.Status;
import com.yandex.app.model.Task;
import com.yandex.app.service.manager.Managers;
import com.yandex.app.service.manager.TaskManager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoryManagerTest {
    @Test
    void testHistoryManagerSavesPreviousTaskVersion() {
        TaskManager taskManager = Managers.getDefault();
        HistoryManager historyManager = Managers.getDefaultHistory();

        Task task = new Task("Задача 1", "Описание 1", Status.NEW);
        task.setId(1);

        historyManager.add(task.copy());

        task.setName("Обновленная задача");
        task.setDescription("Обновленное описание");
        taskManager.updateTask(task);

        historyManager.add(task.copy());

        List<Task> history = historyManager.getHistory();

        assertEquals(2, history.size(), "История должна содержать две версии задачи.");
        assertEquals("Задача 1", history.get(0).getName(), "Первый элемент истории должен быть оригинальной задачей.");
        assertEquals("Обновленная задача", history.get(1).getName(), "Второй элемент истории должен быть обновленной задачей.");
    }



    @Test
    void testManagersReturnInitializedInstances() {
        TaskManager taskManager = Managers.getDefault();
        HistoryManager historyManager = Managers.getDefaultHistory();

        assertNotNull(taskManager, "TaskManager не должен быть null.");
        assertNotNull(historyManager, "HistoryManager не должен быть null.");
    }
}