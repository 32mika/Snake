package de.mika32;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageLoadingTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Bildanzeige Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        try {
            // Laden des Icon-Bildes
            InputStream iconStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("snakeico.jpg");
            Image icon = ImageIO.read(iconStream);

            // Laden des Hintergrundbildes
            InputStream backgroundStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("backSnake.jpg");
            Image background = ImageIO.read(backgroundStream);

            // JLabel zur Anzeige des Icons
            JLabel iconLabel = new JLabel(new ImageIcon(icon));
            frame.getContentPane().add(iconLabel, BorderLayout.NORTH);

            // JLabel zur Anzeige des Hintergrundbildes
            JLabel backgroundLabel = new JLabel(new ImageIcon(background));
            frame.getContentPane().add(backgroundLabel, BorderLayout.CENTER);

        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
    }
}

