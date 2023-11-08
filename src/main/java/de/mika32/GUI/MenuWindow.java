package de.mika32.GUI;

import de.mika32.Constants.Colors;
import de.mika32.tools.ResourceLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;

import static de.mika32.GUI.GameWindow.*;

public class MenuWindow {
    private static final int width = 1200;
    private static final int height = 900;
    private static JLayeredPane mMLayeredPane = new JLayeredPane();
    private static JFrame mMFrame = new JFrame();
    private static JButton startButton = new JButton("Start");
    private static JButton fillLaterButton = new JButton("Options");
    private static JButton quitButton = new JButton("Quit");


    public static void loadMenu() {
        createMainWindow(mMFrame);

        addBackground();
        addButtons();
        addTitel();
        loadFrame();
    }

    private static void createMainWindow(JFrame frame) {
        frame.setTitle("Snake");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(width, height);
        frame.setResizable(false);

        try {
            InputStream imageStream = ResourceLoader.loadResource("snakeico.jpg");
            Image icon = ImageIO.read(imageStream);
            frame.setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addBackground() {
        try {
            InputStream imageStream = ResourceLoader.loadResource("backSnake.jpg");
            Image backgroundImage = ImageIO.read(imageStream);

            JPanel backgroundPanel;
            backgroundPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            };

            backgroundPanel.setBounds(0, 0, width, height);
            mMLayeredPane.add(backgroundPanel, 4);

        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    private static void addButtons() {
        int xcord = 15;
        int ycord = 275;
        int buttonDistance = 80;

        createMenuButton(startButton);
        createMenuButton(fillLaterButton);
        createMenuButton(quitButton);

        startButton.setBounds(xcord, ycord, 300, 100);
        fillLaterButton.setBounds(xcord +40, ycord + buttonDistance, 300, 100);
        quitButton.setBounds(xcord -5, ycord + buttonDistance*2, 300, 100);

        startButton.setText("Start");
        fillLaterButton.setText("Options");
        quitButton.setText("Quit");

        mMLayeredPane.add(startButton, 0);
        mMLayeredPane.add(fillLaterButton, 1);
        mMLayeredPane.add(quitButton, 2);
    }

    private static void addTitel(){
        JPanel titelPanel = new JPanel(new BorderLayout());
        JLabel titel = new JLabel("Snake");

        titel.setFont(new Font("Forte", Font.BOLD, 120));
        titel.setForeground(Colors.textGreen);

        titelPanel.setBounds(mMFrame.getWidth() /2 -290, 0, 500, 200);
        titelPanel.setOpaque(false);
        titelPanel.add(titel, BorderLayout.WEST);

        try {
            InputStream imageStream = ResourceLoader.loadResource("snakeTitel.png");
            Image icon = ImageIO.read(imageStream);
            titelPanel.add(new JLabel(new ImageIcon(icon)), BorderLayout.EAST);

        } catch (IOException e) {
            e.printStackTrace();
        }

        mMLayeredPane.add(titelPanel, 3);
    }

    private static void loadFrame() {
        mMLayeredPane.setBounds(0, 0, width, height);
        mMFrame.add(mMLayeredPane);

        mMFrame.setVisible(true);
        mMFrame.setLocationRelativeTo(null);
        mMLayeredPane.revalidate();
        mMLayeredPane.repaint();
    }

    private static void createMenuButton(JButton button) {
        button.setFont(new Font("Forte", Font.BOLD, 55));
        button.setForeground(Colors.textGreen);
        button.setFocusPainted(false);

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (button.getText().equals("Start")) {
                    mMLayeredPane.removeAll();
                    addBackground();
                    startGame(mMFrame, mMLayeredPane);
                }

                if (button.getText().equals("Options")) {
                    // Options logic
                }

                if (button.getText().equals("Quit")) {
                    System.exit(0);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(Colors.textFocus);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(Colors.textGreen);
            }
        });
    }
}
