package de.mika32.GUI;

import de.mika32.Constants.Colors;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class MainWindow {
    private static int width = 1200;
    private static int height = 900;
    private static JPanel mMPanel = new JPanel();
    private static JFrame mMFrame = new JFrame();
    private static JButton startButton = new JButton();
    private static JButton fillLaterButton = new JButton();
    private static JButton quitButton = new JButton();
    private static GridBagConstraints gbc = new GridBagConstraints();

    public static void loadMenu(){
        mMFrame = createMainWindow(mMFrame);
        mMPanel = createMainPanel(mMPanel);

        addBackground();
        addPanelContent();
        finalLoadFrame();
    }

    private static void addBackground(){
        try {
            Image backgroundImage = ImageIO.read(new File("C:/Users/Mika/IdeaProjects/Snake/src/main/resources/backSnake.jpg"));
            mMFrame.setContentPane(new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        mMFrame.revalidate();
    }

    private static void addPanelContent(){
        int buttonWidth = 50;
        int buttonHeight = 10;

        startButton.setText("Start");
        fillLaterButton.setText("Options");
        quitButton.setText(" Quit ");

        startButton = createMenuButton(startButton);
        fillLaterButton = createMenuButton(fillLaterButton);
        quitButton = createMenuButton(quitButton);

        gbc.ipadx = buttonWidth; // Breite des Buttons
        gbc.ipady = buttonHeight;

        mMPanel.add(startButton, gbc);

        gbc.ipadx = buttonWidth;
        gbc.gridy++;
        mMPanel.add(fillLaterButton, gbc);

        gbc.ipadx= buttonWidth;
        gbc.gridy++;
        mMPanel.add(quitButton, gbc);
    }

    private static void finalLoadFrame(){
        mMFrame.add(mMPanel);
        mMFrame.revalidate(); // Wichtig, um die Anzeige zu aktualisieren
    }

    private static JFrame createMainWindow(JFrame frame){
        Image Icon = Toolkit.getDefaultToolkit().getImage("C:/Users/Mika/IdeaProjects/Snake/src/main/resources/snakeIco.jpg");

        frame.setTitle("Snake");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setIconImage(Icon);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new GridBagLayout());

        return frame;
    }

    private static JPanel createMainPanel(JPanel panel){
        panel.setLayout(new GridBagLayout());

        //panel.setOpaque(false);
        panel.setBackground(Color.BLACK);
        panel.setSize(200, 300);
        panel.setFocusable(false);


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 85, 0, 85);
        gbc.anchor = GridBagConstraints.CENTER;


        return panel;
    }


    private static JButton createMenuButton(JButton button){
        button.setOpaque(false);
        button.setBorderPainted(false); // Hintergrund des Rahmens deaktivieren
        button.setContentAreaFilled(false); // Darstellung des Inhalts deaktivieren


        button.setFont(new Font("Forte", Font.BOLD, 55));
        button.setForeground(Colors.textGreen);
        button.setFocusable(false);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(button.getText().equals("Start")){
                    //Starten
                }

                if(button.getText().equals(" Quit ")){
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

        return button;
    }
}
