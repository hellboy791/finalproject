package by.stepanenko.notebook.utils;

public final class IDGenerator {

    private IDGenerator(){}

    private static int nextID = 0;

    public static int getNextId() {
        return nextID++;
    }
}
