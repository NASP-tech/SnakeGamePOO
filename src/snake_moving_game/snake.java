package snake_moving_game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class snake {

    JPanel p1, p2;
    JButton[] lb = new JButton[200];
    JButton boundsfood;
    JTextArea t;
    int x = 1000, y = 500, gu = 2, directionx = 1, directiony = 0, speed = 100, difference = 0, oldx, oldy, score = 0;

    int[] lbx = new int[600];
    int[] lby = new int[600];

    Point[] lbp = new Point[600];
    Point bfp = new Point();

    Thread myt;

    boolean food = false, run1 = false, runr = true, runu = true, rund = true, boundsflag = true;

    Random r = new Random();

    JMenuBar mymbar;
    JMenu game, help, level;

    public void initializeValues() {
        gu = 3;
        lbx[0] = 200;
        lby[0] = 300;
        directionx = 10;
        directiony = 0;
        score = 0;
        food = false;
        run1 = false;
        runr = true;
        runu = true;
        rund = true;
        boundsflag = true;
        
    }
    snake(){
        super("snake");
        setSize(1000, 590);
        //create menubar with function
        createbar();
        //initialize all variable
        initializeValues();
        p1 = new JPanel();
        p2 = new JPanel();
        //t will view the score
        t = new JTextArea("Score==>"+score);
        t.setEnabled(false);
        t.setBackground(Color.BLACK);
        //snake have to eat boundsfood to grow up
        boundsfood = new JButton();
        boundsfood.setEnabled(false);
        //will make first snake
        createFirstSnake();
        p1.setLayout(null);
        p2.setLayout(new GridLayout(0,1));
        p1.setBounds(0, 0, x, y);
        p1.setBackground(Color.blue);
        p2.setBounds(0, y, x, 30);
        p2.setBackground(Color.RED);
        
        p2.add(t);
        
        getContentPane().setLayout(null);        
        getContentPane().add(p1);
        getContentPane().add(p2);
        show();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(this);
        //Start thread 
        myt = new Thread(this);
        myt.start(); // go to run() method
        
    }
    
    public void createFirstSnake(){
        //initally the snake has small lenght 3
        for (int i = 0; i < 3; i++){
            lb[i] = new JButton("lb" + i);
            lb[i].setEnabled(false);
            p1.add(lb[i]);
            lb[i].setBounds(lbx[i], lby[i], 10, 10);
            lbx[i+1] = lbx[i] - 10;            
            lby[i+1]=lby[i];            
            
        }
    }

    public void createbar(){
        mymbar = new JMenuBar();
        game = new JMenu("GAME");
        JMenuItem newgame = new JMenuItem("New Game");
        JMenuItem exit = new JMenuItem("Exit");
        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        game.add(newgame);
        game.addSeparator();
        game.add(exit);
        mymbar.add(game);
        level=new JMenu("Level");
        help = new JMenu("Help");
        JMenuItem creator = new JMenuItem("Creator");
        JMenuItem instruction = new JMenuItem("Instruction");
        creator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(p2, "Name" + ":Nat Sol");
            }
        });
        
        help.add(creator);
        help.add(instruction);
        mymbar.add(help);
        setJMenuBar(mymbar);
    }
    
    void reset(){
        initializeValues();
        p1.removeAll();
        
    }
    
    private Object getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void createFirstSnake() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
