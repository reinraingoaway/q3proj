package Yes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Automation3 implements ActionListener{
   JFrame frame;
   JTextField perimeter;
   JLabel inputlabel;
   JLabel result;
   JButton calculate;
   JButton solution;
   JButton concepts;
    
    public Automation3(){
       frame = new JFrame("Automation 1");
       perimeter = new JTextField();
       inputlabel = new JLabel("Perimeter ng parisukat: ");
       inputlabel.setFont(inputlabel.getFont().deriveFont(14f));
       calculate = new JButton("Kalkulahin");
       solution = new JButton("Solusyon");
       result = new JLabel("Area ng Bilog: ");
       result.setFont(result.getFont().deriveFont(14f));
       concepts = new JButton("Mga Konsepto");
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
       String input = e.getActionCommand();
       if(input.equals(calculate.getActionCommand())){
           float P = Float.parseFloat(perimeter.getText());
           float s = (float) (P/4);
           float A = (float) (s*Math.PI);
           result.setText("Area ng Bilog: " + A);
       }
       if(input.equals(solution.getActionCommand())){
           float P = Float.parseFloat(perimeter.getText());
           float s = (float) (P/4);
           float A = (float) (s*Math.PI);
           String resultMessage = "s = P/4 \ns = " + P + "/4\ns = "+s+"\nAng gilid ng parisukat ay katumbas ng diameter ng bilog.\nA = πd\n A = π("+ s +")\nArea ng bilog = "+ A;
           JOptionPane.showMessageDialog(null, resultMessage, "Solusyon", JOptionPane.INFORMATION_MESSAGE);
       }
       if (input.equals(concepts.getActionCommand())){
           String mathconcepts = "Ang bilog ay isang sirdong hugis, dalawang-dimensional na hugis hubog na hugis.\n\nAng radius ng isang bilog ay isang segment ng linya na nag-uugnay sa gitna ng bilog sa anumang punto sa circumference nito.\n\nAng diameter ng isang bilog ay isang segment ng linya na dumadaan sa gitna ng bilog at may mga endpoint sa circumference ng bilog.";
           JOptionPane.showMessageDialog(null, mathconcepts, "Konsepto sa Math", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void setFrame(){
        frame.setLayout(new GraphPaperLayout(new Dimension(15, 15)) {});
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        
        frame.add(inputlabel, new Rectangle(4,4,5,2));
        frame.add(perimeter, new Rectangle(9,4,2,2));
        frame.add(calculate, new Rectangle(4,7,4,1));
        calculate.addActionListener(this);
        frame.add(result, new Rectangle(6,9,5,1));
        frame.add(solution, new Rectangle(8,7,3,1));
        solution.addActionListener(this);
        frame.add(concepts, new Rectangle(6,11,3,1));
        concepts.addActionListener(this);
    }

    public static void main(String[] args) {
        Automation3 a= new Automation3();
        a.setFrame();
    }
}
