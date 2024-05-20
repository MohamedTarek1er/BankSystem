package Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayAllEmployees extends JFrame implements ActionListener {

    JTable T;
    JButton b1;

    public DisplayAllEmployees(ArrayList<Employee> employees) {
        this.setResizable(false);
        this.setSize(1200, 600);
        this.setTitle("BANK");

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(55, 65);

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Col1");
        model.addColumn("Col2");
        model.addColumn("Col3");
        model.addColumn("Col4");
        model.addColumn("Col5");
        model.addColumn("Col6");
        model.addColumn("Col7");
        model.addColumn("Col8");
        model.addColumn("Col9");
        model.addColumn("Col10");
        model.addColumn("Col11");
        model.addColumn("Col12");

        b1 = new JButton("<<BACK");
        b1.setBounds(1050, 20, 100, 40);
        b1.addActionListener(this);
        this.add(b1);

        model.addRow(new Object[]{"FirstName", "LastName", "ID", "Email", "Password", "Phone", "Address", "COLLEGE", "year_of_G", "Total_Grade", "Position", "Salary"});

        T = new JTable(model);
        T.setFont(new Font("Serif", Font.BOLD, 15));

        T.setBounds(0, 0, 1000, 1000);
        T.setRowHeight(0, 40);
        //T.setROW(0, 55);
        this.add(T);

       Admin.ShowAllEmployees(model);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            AdminMenu s = new AdminMenu();
            this.setVisible(false);
        }
    }
}
