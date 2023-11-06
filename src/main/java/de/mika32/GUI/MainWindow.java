package de.mika32.GUI;

import de.mika32.Constants.Colors;
import de.mika32.tools.ResourceLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;

public class MainWindow {
    private static final int width = 1200;
    private static final int height = 900;
    private static JLayeredPane mMLayeredPane = new JLayeredPane();
    private static JFrame mMFrame = new JFrame();
    private static JButton startButton = new JButton("Start");
    private static JButton fillLaterButton = new JButton("Options");
    private static JButton quitButton = new JButton("Quit");


    public static void loadMenu() {
        createMainWindow(mMFrame);

        addButtons();
        addBackground();
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
            System.out.println("Bildpfad: " + imageStream);
            frame.setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addBackground() {
        try {
            InputStream imageStream = ResourceLoader.loadResource("backSnake.jpg");
            Image backgroundImage = ImageIO.read(imageStream);
            System.out.println("Bildpfad: " + imageStream);
            JPanel backgroundPanel = new JPanel();

            mMLayeredPane.add(new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }, 0);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    private static void addButtons() {
        createMenuButton(startButton);
        createMenuButton(fillLaterButton);
        createMenuButton(quitButton);

        startButton.setBounds(450, 300, 300, 100);
        fillLaterButton.setBounds(450, 450, 300, 100);
        quitButton.setBounds(450, 600, 300, 100);

        startButton.setText("Start");
        fillLaterButton.setText("Options");
        quitButton.setText("Quit");

        mMLayeredPane.add(startButton, 1);
        mMLayeredPane.add(fillLaterButton, 1);
        mMLayeredPane.add(quitButton, 1);
    }

    private static void loadFrame() {
        mMLayeredPane.setBounds(0, 0, width, height);
        mMFrame.add(mMLayeredPane);
        mMFrame.setVisible(true);
        mMFrame.setLocationRelativeTo(null);
        mMFrame.revalidate();
        mMFrame.repaint();
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
                    // Start logic
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
