package by.teachmeskills.calculator.view.menu;

import java.util.Scanner;

public interface Menu extends AutoCloseable {
    Scanner KEYBOARD = new Scanner(System.in);

    void show();

    default String getKeyboardInput() {
        return KEYBOARD.nextLine();
    }

    default String getKeyboardInput(String item) {
        return KEYBOARD.nextLine();
    }

    @Override
    default void close() {
        KEYBOARD.close();
    }
}