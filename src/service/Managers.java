package service;

import java.io.File;

public class Managers {

    public static TaskManager getDefault() {
        return new InMemoryTaskManager();
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }

    public static FileBackedTaskManager getDefaultBackedTaskManager() {
        return new FileBackedTaskManager(new File("resources\\data.csv"));
    }
}

