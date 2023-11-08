package de.mika32;

import de.mika32.GUI.GameWindow;
import de.mika32.GUI.MenuWindow;

import javax.swing.*;


public class Main {
    static JFrame mainFrame = new JFrame();

    public static void main(String[] args) {
        System.out.println("Starting Game...");

        MenuWindow.loadMenu();
        //GameWindow.loadFrame();

    }
}