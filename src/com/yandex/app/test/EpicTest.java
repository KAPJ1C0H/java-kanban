package com.yandex.app.test;

import com.yandex.app.model.Epic;
import com.yandex.app.model.Status;
import com.yandex.app.model.Subtask;
import com.yandex.app.service.manager.Managers;
import com.yandex.app.service.manager.TaskManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EpicTest {

    private final TaskManager taskManager = Managers.getDefault();

    @Test
    void testEpicCannotAddItselfAsSubtask() {
        // Создаем эпик
        Epic epic = new Epic("Эпик 1", "Описание эпика 1");
        final int epicId = taskManager.addNewEpic(epic);

        // Создаем подзадачу с тем же ID, что и у эпика
        Subtask subtask = new Subtask("Подзадача", "Описание подзадачи", Status.NEW, epicId);
        subtask.setId(epicId); // Устанавливаем ID подзадачи равным ID эпика

        // Проверяем, что выбрасывается IllegalArgumentException
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            taskManager.addNewSubtask(subtask);
        });

        assertEquals("Эпик не может быть подзадачей самого себя.", exception.getMessage());
    }
}