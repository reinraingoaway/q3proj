package Yes;

/**
 *
 * @author Li Rein
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AutomationsMenu implements ActionListener{
    JFrame frame;
    JButton automation1;
    JButton automation2;
    JButton automation3;
    JButton exit;
    ImageIcon background = new ImageIcon("Images/background.png");
    
    MyStyle ms;
    
     
public AutomationsMenu(){
    frame = new JFrame();
    automation1 = new JButton("1st Automation");
    automation2 = new JButton("2nd Automation");
    automation3 = new JButton("3rd Automation");
    exit = new JButton("EXIT");
    background = new ImageIcon(background.getImage().getScaledInstance(560, 420, Image.SCALE_DEFAULT));
    frame.setContentPane(new JLabel(background));
    }

public void actionPerformed(ActionEvent e) {
       if(e.getSource() == automation1){
         frame.dispose();
         Automation1 x = new Automation1();
         x.setFrame();
       }
           if(e.getSource() == automation2){
         frame.dispose();
         Automation2 y = new Automation2();
         y.setFrame();
       }
           if(e.getSource() == automation3){
         frame.dispose();
         Automation3 z = new Automation3();
         z.setFrame();
       }   
           if(e.getSource() == exit){
         frame.dispose();
         MainMenu a = new MainMenu();
         a.setFrame();
       }  
 }
public void setFrame(){
    
    
    frame.setLayout(new GraphPaperLayout(new Dimension(25, 25)));
    
    
    
    frame.add(automation1, new Rectangle(10, 5, 7, 4));
    frame.add(automation2, new Rectangle(10, 9, 7, 4));
    frame.add(automation3, new Rectangle(10, 13, 7, 4));
    frame.add(exit, new Rectangle(10, 17, 7, 4));
    

    
    frame.setVisible(true);
    frame.setSize(560, 420);
    frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    automation1.addActionListener((ActionListener) this);
    automation2.addActionListener((ActionListener) this);
    automation3.addActionListener((ActionListener) this);
    exit.addActionListener((ActionListener) this);
    
    }

 public static void main(String[] args) {
         AutomationsMenu run=new AutomationsMenu();
        run.setFrame();
    }
}