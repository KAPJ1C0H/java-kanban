package com.yandex.app.test;

import com.yandex.app.model.Epic;
import com.yandex.app.model.Status;
import com.yandex.app.model.Subtask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {
    @Test
    void testEpicCannotAddItselfAsSubtask() {
        Epic epic = new Epic("Эпик 1", "Описание эпика 1");
        epic.setId(1);

        Subtask subtask = new Subtask("Подзадача 1", "Описание подзадачи 1", Status.NEW, 2);
        subtask.setId(2);

        assertThrows(IllegalArgumentException.class, () -> {
            epic.addSubtask(new Subtask("Подзадача 1", "Описание подзадачи 1", Status.NEW, epic.getId()));
        });

        epic.addSubtask(subtask);
        assertEquals(1, epic.getSubtasks().size(), "Подзадача должна быть добавлена.");
    }
}
