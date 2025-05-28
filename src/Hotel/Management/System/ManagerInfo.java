package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInfo extends JFrame {
    ManagerInfo(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setForeground(Color.WHITE);
        table.setBackground(Color.BLACK);
        panel.add(table);
        table.getTableHeader().setBackground(Color.BLACK);
        table.getTableHeader().setForeground(Color.WHITE);

        try{
            con c = new con();
            String q = "select * from employee where job ='manager' ";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        JButton back = new JButton("Back");
        back.setBounds(350,500,120,30);
        back.setBackground(new Color(30,26,26));
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        JLabel name = new JLabel("Name");
        name.setBounds(35,11,70,19);
        name.setBackground(Color.BLACK);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(160,11,70,19);
        age.setBackground(Color.BLACK);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(age);


        JLabel gender = new JLabel("Gender");
        gender.setBounds(290,11,70,19);
        gender.setBackground(Color.BLACK);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);

        JLabel role = new JLabel("Role");
        role.setBounds(410,11,70,19);
        role.setBackground(Color.BLACK);
        role.setForeground(Color.WHITE);
        role.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(role);

        JLabel phone = new JLabel("Phone No");
        phone.setBounds(630,11,70,19);
        phone.setBackground(Color.BLACK);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(phone);

        JLabel salary= new JLabel("Salary");
        salary.setBounds(510,11,70,19);
        salary.setBackground(Color.BLACK);
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(salary);



        JLabel email = new JLabel("Email");
        email.setBounds(750,11,70,19);
        email.setBackground(Color.BLACK);
        email.setForeground(Color.WHITE);
        email.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(email);


        JLabel cnic = new JLabel("Cnic");
        cnic.setBounds(890,11,70,19);
        cnic.setBackground(Color.BLACK);
        cnic.setForeground(Color.WHITE);
        cnic.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(cnic);



        setLayout(null);
        setUndecorated(true);
        setResizable(false);
        setSize(1000,600);
        setLocation(285,70);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ManagerInfo();
    }
}
