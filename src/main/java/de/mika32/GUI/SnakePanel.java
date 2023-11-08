package de.mika32.GUI;

import de.mika32.Constants.Colors;
import de.mika32.Constants.MoveDir;
import de.mika32.tools.Pos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SnakePanel extends JPanel implements ActionListener {
    private Timer timer;
    private int delay = 250;
    private int snakeSize = 4;
    private ArrayList<Pos> snakePos = new ArrayList<>();
    private ArrayList<Pos> foodPos = new ArrayList<>();
    private boolean running = false;
    private int score = 0;
    private int playingFieldSize = 25;
    private int width = 1000;
    private int height = 800;
    private int gridSizeX = width/playingFieldSize;
    private int gridSizeY = height/playingFieldSize;



    public SnakePanel() {
        setBounds(GameWindow.getWidth() /2 - this.getWidth() - width/2, GameWindow.getHeight()/2 - this.getHeight()- height/2 , width,  height);
        setVisible(true);
        setLayout(null);
        setFocusable(true);
        requestFocus();
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                System.out.println("Test");

                if(e.getKeyCode() == KeyEvent.VK_W) {
                    Snake.setDirection(MoveDir.UP);
                    System.out.println("Schlange nach oben");
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    Snake.setDirection(MoveDir.DOWN);
                    System.out.println("Schlange nach unten");
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    Snake.setDirection(MoveDir.LEFT);
                    System.out.println("Schlange nach links");
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    Snake.setDirection(MoveDir.RIGHT);
                    System.out.println("Schlange nach rechts");
                }
            }
        });

        Snake.addPartCords(new Pos(1,5));
        Snake.addPartCords(new Pos(2,5));
        Snake.addPartCords(new Pos(3,5));
        Snake.addPartCords(new Pos(4,5));


        // Erstellen Sie einen Timer mit einer Verzögerung von 100 Millisekunden
        timer = new Timer(delay, this);
        timer.start();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // Hier wird die Spiellogik aktualisiert, die Schlange bewegt, Kollisionen überprüft usw.
        ArrayList<Pos> snakePos = Snake.getPos();
        Pos first = snakePos.get(snakePos.size() - 1);
        Pos second = new Pos(first.getX(), first.getY());


        switch (Snake.getDirection()){
            case UP:{
                first.setY(first.getY() - 1);
                break;
            }

            case DOWN:{
                first.setY(first.getY() + 1);
                break;
            }

            case LEFT:{
                first.setX(first.getX() - 1);
                break;
            }

            case RIGHT:{
                first.setX(first.getX() + 1);
                break;
            }
        }

        snakePos.set(snakePos.size() - 1, second);
        snakePos.add(snakePos.size(), first);

        for(Pos p : snakePos){
            Pos p1 = new Pos(p.getX(), p.getY());

            if(snakePos.indexOf(p) == 4){
                break;
            }

            Pos before1 = new Pos(snakePos.get(snakePos.indexOf(p) + 1).getX(), snakePos.get(snakePos.indexOf(p) + 1).getY());
            p1.setX(before1.getX());
            p1.setY(before1.getY());

            snakePos.set(snakePos.indexOf(p), p1);
        }

        snakePos.remove(snakePos.size()-1);

        // Rufen Sie die Methode zum Neuziehen des Spielfelds auf
        repaint();
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Hier wird das Spielfeld gezeichnet, einschließlich Schlange, Nahrung usw.

        for (int i = 0, d = 0; i < 25; i++) {
            if(d % 2 == 0) {
                if (i % 2 == 0) {
                    g.setColor(Colors.darkField);
                } else {
                    g.setColor(Colors.lightField);
                }
            }

            if(d % 2 == 1) {
                if (i % 2 == 0) {
                    g.setColor(Colors.lightField);
                } else {
                    g.setColor(Colors.darkField);
                }
            }

            g.fillRect(i * gridSizeX, d * gridSizeY, gridSizeX, gridSizeY);

            if(i == 24){
                if(d < 24){
                    i = -1;
                }
                d++;
            }
        }

        g.setColor(Color.MAGENTA);
        for (Pos p: Snake.getPos()) {
            int x = p.getX() * gridSizeX;
            int y = p.getY() * gridSizeY;

            g.fillRect(x, y, gridSizeX, gridSizeY);
        }


    }

    /*
    public void keyPressed(KeyEvent e) {
        // Hier wird die Schlange gesteuert, wenn eine Taste gedrückt wird
        System.out.println("Test");

        if(e.getKeyCode() == KeyEvent.VK_W) {
            Snake.setDirection(MoveDir.UP);
            System.out.println("Schlange nach oben");
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            Snake.setDirection(MoveDir.DOWN);
            System.out.println("Schlange nach unten");
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            Snake.setDirection(MoveDir.LEFT);
            System.out.println("Schlange nach links");
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            Snake.setDirection(MoveDir.RIGHT);
            System.out.println("Schlange nach rechts");
        }
    }*/

}

