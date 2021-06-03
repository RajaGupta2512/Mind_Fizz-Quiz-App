package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    JButton next, submit;
    public static int count = 0;
    public static int timer = 15;
    public static int score = 0;
    public static Boolean ans_given = false;
    JLabel qno, question;
    String q[][] = new String[10][5];
    String pa[][] =  new String[10][1];  //Person's Answer - pa
    String ca[][] = new String[10][2];  //Correct Answer
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup options;

    String username;

    Quiz (String username) {
        super("Mind Fizz");
        this.getContentPane().setBackground(Color.BLACK);
        this.setBounds(50, 0, 1440, 1200);
        this.setLayout(null);

        this.username = username;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz/app/icons/quiz.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1440, 392);
        this.add(l1);

        this.qno = new JLabel("");
        qno.setBounds(100, 450, 40, 30);
        qno.setForeground(Color.WHITE);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.add(qno);

        this.question = new JLabel("");
        question.setBounds(150, 450, 900, 30);
        question.setForeground(Color.WHITE);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.add(question);

        q[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        q[0][1] = "JVM";
        q[0][2] = "JDB";
        q[0][3] = "JDK";
        q[0][4] = "JRE";

        q[1][0] = "What is the return type of the hashCode() method in the Object class?";
        q[1][1] = "int";
        q[1][2] = "Object";
        q[1][3] = "long";
        q[1][4] = "void";

        q[2][0] = "Which package contains the Random class?";
        q[2][1] = "java.util package";
        q[2][2] = "java.lang package";
        q[2][3] = "java.awt package";
        q[2][4] = "java.io package";

        q[3][0] = "An interface with no fields or methods is known as?";
        q[3][1] = "Runnable Interface";
        q[3][2] = "Abstract Interface";
        q[3][3] = "Marker Interface";
        q[3][4] = "CharSequence Interface";

        q[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        q[4][1] = "Stack";
        q[4][2] = "String memory";
        q[4][3] = "Random storage space";
        q[4][4] = "Heap memory";

        q[5][0] = "Which of the following is a marker interface?";
        q[5][1] = "Runnable interface";
        q[5][2] = "Remote interface";
        q[5][3] = "Readable interface";
        q[5][4] = "Result interface";

        q[6][0] = "Which keyword is used for accessing the features of a package?";
        q[6][1] = "import";
        q[6][2] = "package";
        q[6][3] = "extends";
        q[6][4] = "export";

        q[7][0] = "In java, jar stands for?";
        q[7][1] = "Java Archive Runner";
        q[7][2] = "Java Archive";
        q[7][3] = "Java Application Resource";
        q[7][4] = "Java Application Runner";

        q[8][0] = "Which of the following is a mutable class in java?";
        q[8][1] = "java.lang.StringBuilder";
        q[8][2] = "java.lang.Short";
        q[8][3] = "java.lang.Byte";
        q[8][4] = "java.lang.String";

        q[9][0] = "Which of the following option leads to the portability and security of Java?";
        q[9][1] = "Bytecode is executed by JVM";
        q[9][2] = "The applet makes the Java code secure and portable";
        q[9][3] = "Use of exception handling";
        q[9][4] = "Dynamic binding between objects";

        ca[0][1] = "JDB";
        ca[1][1] = "int";
        ca[2][1] = "java.util package";
        ca[3][1] = "Marker Interface";
        ca[4][1] = "Heap memory";
        ca[5][1] = "Remote interface";
        ca[6][1] = "import";
        ca[7][1] = "Java Archive";
        ca[8][1] = "java.lang.StringBuilder";
        ca[9][1] = "Bytecode is executed by JVM";

        this.opt1 = new JRadioButton("");
        opt1.setBounds(170, 520, 700, 30);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt1.setBackground(Color.BLACK);
        opt1.setForeground(Color.WHITE);
        this.add(opt1);

        this.opt2 = new JRadioButton("");
        opt2.setBounds(170, 560, 700, 30);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt2.setBackground(Color.BLACK);
        opt2.setForeground(Color.WHITE);
        this.add(opt2);

        this.opt3 = new JRadioButton("");
        opt3.setBounds(170, 600, 700, 30);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt3.setBackground(Color.BLACK);
        opt3.setForeground(Color.WHITE);
        this.add(opt3);

        this.opt4 = new JRadioButton("");
        opt4.setBounds(170, 640, 700, 30);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt4.setBackground(Color.BLACK);
        opt4.setForeground(Color.WHITE);
        this.add(opt4);

        this.options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

        this.next = new JButton("Next ->");
        next.setBounds(900, 720, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        this.add(next);

        this.submit = new JButton("Submit");
        submit.setBounds(1200, 720, 200, 40);
        submit.setEnabled(false);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        this.add(submit);

        start(0);
    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            ans_given = true;

            if (options.getSelection() == null) {
                pa[count][0] = "";
            } else {
                pa[count][0] = options.getSelection().getActionCommand();
            }
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        } else {
            if (options.getSelection() == null) {
                pa[count][0] = "";
            } else {
                pa[count][0] = options.getSelection().getActionCommand();
            }

            for (int i = 0; i < pa.length; i++) {
                if (pa[1][0].equals(ca[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            this.setVisible(false);
            new Score(username, score).setVisible(true);
        }
    }

    public void paint (Graphics g) {
        super.paint(g);
        String time = "Time Left : " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Time's UP!!!", 1100, 500);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given) {
            ans_given = false;
            timer = 15;  //If Answer is Given
        }

        if (timer < 0) {
            timer =  15;   //When Time's Up but User hasn't answered

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                if (options.getSelection() == null) {
                    pa[count][0] = "";
                } else {
                    pa[count][0] = options.getSelection().getActionCommand();
                }

                for (int i = 0; i < pa.length; i++) {
                    if (pa[1][0].equals(ca[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                this.setVisible(false);
                new Score(username, score).setVisible(true);
            } else {
                if (options.getSelection() == null) {
                    pa[count][0] = "";
                } else {
                    pa[count][0] = options.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }

    public void start (int count) {
        qno.setText("" + (count+1) + ". ");
        question.setText(q[count][0]);

        opt1.setLabel(q[count][1]);
        opt1.setActionCommand(q[count][1]);

        opt2.setLabel(q[count][2]);
        opt2.setActionCommand(q[count][2]);

        opt3.setLabel(q[count][3]);
        opt3.setActionCommand(q[count][3]);

        opt4.setLabel(q[count][4]);
        opt4.setActionCommand(q[count][4]);

        options.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("").setVisible(true);
    }
}
