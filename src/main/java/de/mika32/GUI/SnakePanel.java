package de.mika32.GUI;

import de.mika32.tools.pos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class SnakePanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private int delay = 100;
    private int snakeSize = 4;
    private ArrayList<pos> snakePos = new ArrayList<pos>();
    private ArrayList<pos> foodPos = new ArrayList<pos>();
    private boolean running = false;
    private int score = 0;
    private int playingFieldSize = 25;
    private int width = 1000;
    private int height = 800;



    public SnakePanel() {


        setBounds(GameWindow.getWidth() /2 - this.getWidth() - width/2, GameWindow.getHeight()/2 - this.getHeight()- height/2 , width,  height);
        setBackground(Color.BLACK);
        setVisible(true);
        setFocusable(true);
        addKeyListener(this);
        setLayout(new GridLayout(25, 25, 0, 0));


        // Erstellen Sie einen Timer mit einer Verzögerung von 100 Millisekunden
        timer = new Timer(delay, this);
        timer.start(); // Starten Sie den Timer
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Hier wird die Spiellogik aktualisiert, die Schlange bewegt, Kollisionen überprüft usw.

        // Rufen Sie die Methode zum Neuziehen des Spielfelds auf
        repaint();
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Hier wird das Spielfeld gezeichnet, einschließlich Schlange, Nahrung usw.
    }


    @Override
    public void keyPressed(KeyEvent e) {
        // Hier wird die Schlange gesteuert, wenn eine Taste gedrückt wird
        if(e.getKeyCode() == KeyEvent.VK_W) {
            // Bewege die Schlange nach oben
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            // Bewege die Schlange nach unten
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            // Bewege die Schlange nach links
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            // Bewege die Schlange nach rechts
        }
    }

    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
}

