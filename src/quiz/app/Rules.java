package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {

    JButton b1;
    JButton b2;
    String username;

    Rules (String username) {
        super("Instructions for Mind Fizz");
        this.setBounds(380, 50, 700, 750);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);

        this.username = username;

        JLabel l1 = new JLabel("Welcome " + username + " to Mind Fizz");
        l1.setBounds(50, 30, 700, 30);
        l1.setForeground(new Color(30, 144, 255));
        l1.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
        this.add(l1);

        JLabel l2 = new JLabel("Instructions for Quiz");
        l2.setBounds(20, 90, 600, 450);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l2.setForeground(Color.WHITE);
        l2.setText(
                        "<html>" +
                        "1. The Quiz consists of questions carefully designed to help you self-assess your knowledge in Java." +
                                "<br><br>" +
                        "2. No data will be collected on the website regarding your responses or how many times you take the quiz.<br><br>" +
                        "3. Each question in the quiz is of Multiple-Choice format. For each Question, you 15 Seconds.<br><br>" +
                        "4. Read each question carefully, and click on the button next to your response.<br><br>" +
                        "5. Each Correct Answer will give you 10 marks.<br><br>" +
                        "6. After responding to a question, click on the \"Next Question\" button at the bottom to go to the next question.<br><br>" +
                        "7. After responding to the 10th question, click on \"Submit\" on the Bottom-Right of the window to know your Score.<br><br>" +
                        "8. You can take the Quiz Any number of times.<br><br>" +
                        "<html>"
        );
        this.add(l2);

        this.b1 = new JButton("Back");
        b1.setBounds(100, 550, 100, 30);
        b1.setBackground(new Color(30, 144, 255));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        this.add(b1);

        this.b2 = new JButton("Start QUIZ");
        b2.setBounds(480, 550, 100, 30);
        b2.setBackground(new Color(30, 144, 255));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        this.add(b2);

        this.setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == b1) {
            this.setVisible(false);
            new MindFizz().setVisible(true);
        } else if (ae.getSource() == b2){
            this.setVisible(false);
            new Quiz(username).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Rules("");
    }
}
