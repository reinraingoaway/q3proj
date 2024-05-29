/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Yes;

/**
 *
 * @author Li Rein
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MainMenu implements ActionListener{
    JFrame frame;
    JButton automation;
    JButton game;
    JButton exit;
    ImageIcon background = new ImageIcon("Images/background.png");
    
    MyStyle ms;
    
     
public MainMenu(){
    frame = new JFrame();
    automation = new JButton("AUTOMATION");
    game = new JButton("GAME");
    exit = new JButton("EXIT");
    background = new ImageIcon(background.getImage().getScaledInstance(560, 420, Image.SCALE_DEFAULT));
    frame.setContentPane(new JLabel(background));
    }

public void actionPerformed(ActionEvent e) {
       if(e.getSource() == game){
         frame.dispose();
         Main x = new Main();
         x.setFrame();
       }
           if(e.getSource() == automation){
         frame.dispose();
         AutomationsMenu y = new AutomationsMenu();
         y.setFrame();
       }
           if(e.getSource() == exit){
         frame.dispose();
       }         
 }
public void setFrame(){
    
    
    frame.setLayout(new GraphPaperLayout(new Dimension(25, 25)));
    
    
    
    frame.add(automation, new Rectangle(10, 7, 7, 4));
    frame.add(game, new Rectangle(10, 12, 7, 4));
    frame.add(exit, new Rectangle(10, 17, 7, 4));
    

    
    frame.setVisible(true);
    frame.setSize(560, 420);
    frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    automation.addActionListener((ActionListener) this);
    game.addActionListener((ActionListener) this);
    exit.addActionListener((ActionListener) this);
    
    
    }

 public static void main(String[] args) {
         MainMenu run=new MainMenu();
        run.setFrame();
    }
}

   



