package com.yandex.app.test;

import com.yandex.app.model.Status;
import com.yandex.app.model.Subtask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {
    @Test
    void testSubtaskCannotBeItsOwnEpic() {
        Subtask subtask = new Subtask("Subtask 1", "Description 1", Status.NEW, 1);
        subtask.setId(2);

        assertNotEquals(subtask.getId(), subtask.getEpicId(), "Subtask cannot be its own epic.");
    }
}
