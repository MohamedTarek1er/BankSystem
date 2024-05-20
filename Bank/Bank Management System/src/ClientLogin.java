package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.Main.clients;

public class ClientLogin extends JFrame implements ActionListener {

    JLabel text = new JLabel("WELCOME TO BANK");
    static JTextField t1;
    JTextField t2, t3;
    JButton b1, b2, b3, b4;
    JLabel jj = new JLabel("success");
    JOptionPane G;
    static String LogedName = "";
    Client cc = new Client();
    static int Acc_num = 0;

    public ClientLogin() {

        this.setResizable(false);
        this.setSize(800, 500);
        this.setTitle("BANK");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(225, 100);

        JLabel f = new JLabel();
        f.setIcon(new ImageIcon("D:\\banking.png"));
        this.setLayout(null);

        text.setFont(new Font("osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        this.add(text);

        f.setBounds(70, 10, 100, 100);

        JLabel mail = new JLabel("ID:");
        mail.setFont(new Font("Raleway", Font.BOLD, 28));
        mail.setBounds(250, 142, 500, 40);
        this.add(mail);

        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Raleway", Font.BOLD, 28));
        email.setBounds(210, 212, 400, 40);
        this.add(email);

        JLabel pass = new JLabel("PASSWORD:");
        pass.setFont(new Font("Raleway", Font.BOLD, 28));
        pass.setBounds(120, 282, 400, 40);
        this.add(pass);

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JPasswordField();

        t1.setBounds(300, 150, 250, 30);
        t2.setBounds(300, 220, 250, 30);
        t3.setBounds(300, 290, 250, 30);

        this.add(t1);
        this.add(t2);
        this.add(t3);

        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.white);
        b1.setForeground(Color.BLUE);
        b1.setBounds(300, 360, 100, 30);
        b1.addActionListener(this);
        this.add(b1);

        b2 = new JButton("CLEAR");
        b2.setBackground(Color.white);
        b2.setForeground(Color.BLUE);
        b2.setBounds(430, 360, 100, 30);
        b2.addActionListener(this);
        this.add(b2);

        b4 = new JButton("BACK ");
        b4.setBackground(Color.white);
        b4.setForeground(Color.BLUE);
        b4.setBounds(560, 360, 100, 30);
        b4.addActionListener(this);
        this.add(b4);

        jj.setBounds(540, 200, 100, 30);
        jj.setBackground(Color.red);
        jj.setFont(new Font("Raleway", Font.BOLD, 28));
        jj.setBounds(600, 50, 500, 40);
        jj.setForeground(Color.green);
        this.add(jj);
        jj.setVisible(false);

        G = new JOptionPane();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            if (Manager.CheckClientLogIn(t1, t2, t3, Acc_num, LogedName)) {
                this.setVisible(false);
                ClientMenu s = new ClientMenu();
            }

        }
        if (e.getSource() == b4) {
            Menu m = new Menu();
            this.setVisible(false);

        }
        if (e.getSource() == b2) {
            t1.setText("");
            t2.setText("");

        }

    }

    public static String logedID() {

        return t1.getText();

    }
    static String s;
    static int d;

    public static String rLogedname(String c) {
        LogedName = c;
        s = LogedName;
        return LogedName;
    }

    public static String Logedname() {

        return s;
    }

    public static int rAcc_Num(int f) {
        Acc_num = f;
        d = f;
        return Acc_num;

    }

    public static int Acc_Num() {

        return d;
    }
}
