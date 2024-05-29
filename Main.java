package Yes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    JFrame frame;
    JButton start_button;
    JLabel background1;

    public Main() {
        frame = new JFrame("Main");
        start_button = new JButton("SIMULAN ANG LARO");

        // Background
        ImageIcon backgroundImage = new ImageIcon("src/Background_Assets/background1.png");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        background1 = new JLabel(backgroundImage);
        background1.setBounds(0, 0, screenWidth, screenHeight);
        frame.setContentPane(background1);

        // Setting image for button
        
        // Button
        int buttonX = 9;
        int buttonY = 17;
        int buttonWidth = 8;
        int buttonHeight = 2;
        start_button.setBounds(buttonX * 32, buttonY * 32, buttonWidth * 32, buttonHeight * 32);
        
        //Button, 2nd frame, logic
        start_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openSecondFrame(); 
            }
        });
        frame.add(start_button);
    }

    public void setFrame() {
        //frame related
        frame.setLayout(new GraphPaperLayout(new Dimension(26, 20)));
        frame.setSize(832, 640);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    //open second frame
    public void openSecondFrame() {
        frame.dispose(); // close current frame
        SecondFrame secondFrame = new SecondFrame();
        secondFrame.showFrame();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setFrame();
    }
}

class SecondFrame {
    JFrame frame;
    JLabel background;
    JButton second_button;
    int clickCount = 0;

    public SecondFrame() {
        frame = new JFrame("Nilalaman");
        frame.setLayout(null);
        frame.setSize(832, 640);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null); //stuff middle

        // background image
        background = new JLabel();
        background.setIcon(new ImageIcon("src/Background_Assets/background1.png"));
        background.setBounds(0, 0, 832, 640);
        frame.add(background);

        // button
        second_button = new JButton("Susunod");
        second_button.setBounds(352, 544, 128, 64); 
        second_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackground();
            }
        });
        frame.add(second_button);
    }

    public void showFrame() {
        frame.setVisible(true);
    }

     private void changeBackground() {
        clickCount++; //mouseclick
        if (clickCount <= 9) { //after reach 9, change to another GUI
            String imagePath = "src/Background_Assets/scene" + clickCount + ".png";
            background.setIcon(new ImageIcon(imagePath));
        } else {
            frame.dispose(); // close current frame
            ThirdFrame thirdFrame = new ThirdFrame(); //third frame
        }
    }

    public static void main(String[] args) {
        SecondFrame sf = new SecondFrame();
        sf.showFrame();
    }
}

    class ThirdFrame {
        JFrame frame;
        
        //buttons
        JButton first_choice;
        JButton second_choice;
        JButton third_choice;
        JButton fourth_choice;
        
        //background
        JLabel background;
        JLabel question;
        
        //hpbar
        JProgressBar leftHPbar;
        JProgressBar rightHPbar;
        
        //game
        String[] questions;
        String[][] choices;
        
        //logic
        int[] correct_answers;
        int question_index;
        int leftHP;
        int rightHP;
        
        JToggleButton help;

        public ThirdFrame() {
            //list of questions
            questions = new String[] {
                "Ano ang formula para sa sukat ng isang bilog gamit ang radius (r)?",
                "Kung ang radius ng isang bilog ay 5 units, ano ang sukat nito?",
                "Ano ang sukat ng isang bilog kung ang diameter nito ay 12 units?",
                "Sa isang bilog, kung ang sukat ng bilog ay 16π units², ano ang haba ng radius nito?",
                "Kung ang sukat ng isang bilog ay 100π units², ano ang haba ng diameter nito?",
                "Ang sukat ng isang bilog ay 36π units². Ano ang haba ng radius nito?",
                "Kung ang sukat ng isang bilog ay 49π units², ano ang haba ng diameter nito?",
                "Kung ang haba ng radius ng isang bilog ay 10 units, ano ang sukat nito?",
                "Ano ang sukat ng bilog na nakapaloob sa isang parisukat kung ang haba ng isang gilid nito ay 8 units?",
                "Kung ang sukat ng isang bilog na nakapaloob sa isang parisukat ay 25 units², ano ang haba ng radius nito?"
            };

            //list of answers
            choices = new String[][] {
                {"A=πr^2", "A=2πr", "A=πr", "A=2r"}, // Choices for question 1
                {"10π units²", "25π units²", "15 units²", "50 units²"}, // Choices for question 2
                {"24π units²", "144 units²", "6π units²", "72 units²"}, // Choices for question 3
                {"2 units", "4 units", "8 units", "16 units"}, // so on so forth
                {"20 units", "10 units", "25 units", "5 units"}, 
                {"6 units", "12 units", "18 units", "3 units"}, 
                {"14 units", "7 units", "21 units", "28 units"}, 
                {"5π units²", "50π units²", "20 units²", "100π units²"}, 
                {"32π units²", "16 units²", "64π units²", "64 units²"}, 
                {"2.5 units", "5 units", "10 units", "25 units"}
            };

            correct_answers = new int[] {0, 1, 0, 1, 0, 0, 0, 3, 1, 0}; //correct answers
            question_index = 0;
            leftHP = 50; //Andres health
            rightHP = 50; //Kastila health
            
            //frame
            frame = new JFrame("Laban");
            frame.setSize(832, 640);
            frame.setLayout(new GraphPaperLayout(new Dimension(26,20)));
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            //healp feature button
            help = new JToggleButton("?");
            help.setBounds(0, 0, 50, 50);
            help.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (help.isSelected()) {
                        // display message
                        JOptionPane.showMessageDialog(null, "Press the buttons to answer the questions. Each correct answer decreases the opponent's health bar.");
                        help.setSelected(false);
                    }
                }
            });
            frame.add(help);

            question = new JLabel(questions[question_index]);
            question.setHorizontalAlignment(SwingConstants.CENTER);
            question.setForeground(Color.WHITE);
            frame.add(question, new Rectangle(0, 16, 26, 2));

            first_choice = new JButton(choices[question_index][0]);
            second_choice = new JButton(choices[question_index][1]);
            third_choice = new JButton(choices[question_index][2]);
            fourth_choice = new JButton(choices[question_index][3]);

            first_choice.addActionListener(new ChoiceListener());
            second_choice.addActionListener(new ChoiceListener());
            third_choice.addActionListener(new ChoiceListener());
            fourth_choice.addActionListener(new ChoiceListener());

            
            //background
            background = new JLabel();
            background.setIcon(new ImageIcon("src/Background_Assets/background3.png"));
            background.setBounds(0, 0, 832, 640);
            
            //button placements
            frame.add(first_choice, new Rectangle(5, 18, 4, 2));
            frame.add(second_choice, new Rectangle(9, 18, 4, 2));
            frame.add(third_choice, new Rectangle(13, 18, 4, 2));
            frame.add(fourth_choice, new Rectangle(17, 18, 4, 2));

            
            //left hp bar
            leftHPbar = new JProgressBar(0, 50);
            leftHPbar.setValue(leftHP);
            leftHPbar.setStringPainted(true);
            leftHPbar.setString("HP: " + leftHP);
            leftHPbar.setForeground(Color.RED);
            frame.add(leftHPbar, new Rectangle(1, 3, 5, 1));
            
            //right hp bar
            rightHPbar = new JProgressBar(0, 50);
            rightHPbar.setValue(rightHP);
            rightHPbar.setStringPainted(true);
            rightHPbar.setString("HP: " + rightHP);
            rightHPbar.setForeground(Color.RED);
            rightHPbar.setStringPainted(true);
            frame.add(rightHPbar, new Rectangle(20, 3, 5, 1));

            frame.add(background);
            frame.setVisible(true);
        }

        //3rd frame logic
        private class ChoiceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String choice = button.getText();
            if (choice.equals(choices[question_index][correct_answers[question_index]])) {
                //correct answer, decrease Kastila health
                rightHP -= 10;
            } else {
                //incorrect answer, decrease Andres health
                leftHP -= 10;
            }
            //update health bars
            leftHPbar.setValue(leftHP);
            leftHPbar.setString("HP: " + leftHP);
            rightHPbar.setValue(rightHP);
            rightHPbar.setString("HP: " + rightHP);
            // check if player hp is 0
            if (leftHP <= 0) {
                int option = JOptionPane.showOptionDialog(null, "Natalo si Andres Bonifacio! Nanalo ang mga Kastila!", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Exit", "Restart"}, "Exit");
                if (option == JOptionPane.YES_OPTION) {
                    frame.dispose();
                } else {
                    resetGame();
                }
            } else if (rightHP <= 0) {
                int option = JOptionPane.showOptionDialog(null, "Natalo ang mga Kastila! Nanalo si Andres Bonifacio!", "Congratulations", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Exit", "Restart"}, "Exit");
                if (option == JOptionPane.YES_OPTION) {
                    frame.dispose();
                } else {
                    resetGame();
                }
            } else {
                //+1, next question
                question_index++;
                if (question_index < questions.length) {
                    //update the question and choices
                    question.setText(questions[question_index]);
                    first_choice.setText(choices[question_index][0]);
                    second_choice.setText(choices[question_index][1]);
                    third_choice.setText(choices[question_index][2]);
                    fourth_choice.setText(choices[question_index][3]);
                } else {
                    frame.dispose();
                }
            }
        }

        // reset game
        private void resetGame() {
            question_index = 0;
            leftHP = 50;
            rightHP = 50;
            leftHPbar.setValue(leftHP);
            leftHPbar.setString("HP: " + leftHP);
            rightHPbar.setValue(rightHP);
            rightHPbar.setString("HP: " + rightHP);
            question.setText(questions[question_index]);
            first_choice.setText(choices[question_index][0]);
            second_choice.setText(choices[question_index][1]);
            third_choice.setText(choices[question_index][2]);
            fourth_choice.setText(choices[question_index][3]);
        }
    }
}