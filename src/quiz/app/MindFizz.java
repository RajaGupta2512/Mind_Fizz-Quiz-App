package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MindFizz extends JFrame implements ActionListener {

    JTextField t;
    JButton b1;
    JButton b2;

    MindFizz() {
        super("Mind Fizz");
        this.setBounds(150, 100, 1200, 540);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz/app/icons/login.jpeg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 600, 500);
        this.add(l1);

        JLabel l2 = new JLabel("Mind Fizz");
        l2.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        l2.setForeground(new Color(30, 144, 254));
        l2.setBounds(800, 60, 300, 45);
        this.add(l2);

        JLabel l3 = new JLabel("Enter Your Name");
        l3.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        l3.setForeground(new Color(30, 144, 254));
        l3.setBounds(815, 150, 300, 20);
        this.add(l3);

        this.t = new JTextField();
        t.setBounds(735, 200, 300, 25);
        t.setFont(new Font("Times New Roman", Font.BOLD, 20));
        this.add(t);

        this.b1 = new JButton("Rules");
        b1.setBounds(735, 270, 120, 30);
        b1.setBackground(new Color(30, 144, 254));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        this.add(b1);

        this.b2 = new JButton("Exit");
        b2.setBounds(915, 270, 120, 30);
        b2.setBackground(new Color(30, 144, 254));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        this.add(b2);

        this.setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == b1) {
            String name = t.getText();
            this.setVisible(false);
            new Rules(name);
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new MindFizz();
    }
}
