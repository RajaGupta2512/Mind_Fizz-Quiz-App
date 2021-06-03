package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.CookieHandler;

public class Score extends JFrame implements ActionListener {

    Score (String username, int score) {
        super("Scores");
        this.setBounds(600, 150, 750, 550);
        this.getContentPane().setBackground(Color.WHITE);
        this.setForeground(Color.WHITE);
        this.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz/app/icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 200, 300, 250);
        this.add(l1);

        JLabel l2 = new JLabel("ThankYou " + username + " for Playing Mind Fizz");
        l2.setBounds(45, 30, 700, 30);
        l2.setFont(new Font("RALEWAY", Font.PLAIN, 26));
        l2.setForeground(new Color(199, 21, 133));
        this.add(l2);

        JLabel l3 = new JLabel("Your Score : " + score);
        l3.setBounds(350, 200, 300, 30);
        l3.setFont(new Font("Jokerman", Font.PLAIN, 26));
        this.add(l3);

        JButton b = new JButton("Play Again");
        b.setBounds(400, 270, 120, 30);
        b.setBackground(Color.BLUE);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);
        this.add(b);

        this.setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {
        this.setVisible(false);
        new MindFizz().setVisible(true);
    }

    public static void main(String[] args)
    {
        new Score("", 0).setVisible(true);
    }
}
