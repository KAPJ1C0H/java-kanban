package com.yandex.app.service.history;

import com.yandex.app.model.Task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private final List<Task> history = new ArrayList<>();

    @Override
    public void add(Task task) {
        history.add(task.copy()); // Добавляем копию задачи в историю
        if (history.size() > 10) {
            history.remove(0); // Удаляем самую старую версию, если больше 10
        }
    }

    @Override
    public List<Task> getHistory() {
        return new ArrayList<>(history);
    }
}