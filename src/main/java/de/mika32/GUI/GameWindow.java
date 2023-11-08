package de.mika32.GUI;

import javax.swing.*;

public class GameWindow {
    private static JFrame mGFrame = new JFrame();
    private static JLayeredPane mGLayeredPane = new JLayeredPane();
    private static JPanel snakePanel = new JPanel();

    public static void startGame(JFrame mainWindow, JLayeredPane layeredPane) {
           mGFrame = mainWindow;
           snakePanel = new SnakePanel();
           loadFrame();
    }

    public static void loadFrame() {
        mGFrame.setVisible(true);
        mGFrame.setLocationRelativeTo(null);

        mGLayeredPane.setBounds(0, 0, 1200, 900);
        mGLayeredPane.setVisible(true);
        mGLayeredPane.setLayout(null);
        mGLayeredPane.add(snakePanel,  0);


        mGFrame.add(mGLayeredPane);
        mGFrame.revalidate();
        mGFrame.repaint();
    }

    public static void closeGame() {
        mGFrame.dispose();
    }

    public static int getHeight() {
        return mGFrame.getHeight();
    }

    public static int getWidth() {
        return mGFrame.getWidth();
    }
}
