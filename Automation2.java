package Yes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Automation2 implements ActionListener{
   JFrame frame;
   JTextField areainput;
   JLabel inputlabel;
   JLabel result;
   JButton calculate;
   JButton solution;
   JButton concepts;
    
    public Automation2(){
       frame = new JFrame("Automation 1");
       areainput = new JTextField();
       inputlabel = new JLabel("Ilagay ang area ng iyong bilog: ");
       inputlabel.setFont(inputlabel.getFont().deriveFont(14f));
       calculate = new JButton("Kalkulahin");
       solution = new JButton("Solusyon");
       result = new JLabel("Radius ng Bilog: ");
       result.setFont(result.getFont().deriveFont(14f));
       concepts = new JButton("Konsepto");
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
       String input = e.getActionCommand();
       if(input.equals(calculate.getActionCommand())){
           float A = Float.parseFloat(areainput.getText());
           float r = (float) (A/(2*Math.PI));
           result.setText("Radius of the circle: " + r);
       }
       if(input.equals(solution.getActionCommand())){
           float A = Float.parseFloat(areainput.getText());
           float r = (float) (A/(2*Math.PI));
           String resultMessage = "r = A/2π  \nr = " + A + "/2π\nRadius  ng Bilog= " + r + "";
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
        frame.setSize(750, 500);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        
        frame.add(inputlabel, new Rectangle(4,4,5,2));
        frame.add(areainput, new Rectangle(9,4,2,2));
        frame.add(calculate, new Rectangle(4,7,4,1));
        calculate.addActionListener(this);
        frame.add(result, new Rectangle(6,9,5,1));
        frame.add(solution, new Rectangle(8,7,3,1));
        solution.addActionListener(this);
        frame.add(concepts, new Rectangle(6,11,3,1));
        concepts.addActionListener(this);
    }

    public static void main(String[] args) {
        Automation2 a= new Automation2();
        a.setFrame();
    }
}
