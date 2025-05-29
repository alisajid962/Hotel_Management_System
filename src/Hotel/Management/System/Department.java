package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame {
    JButton back;
    Department(){
       JPanel panel = new JPanel();
       panel.setBackground(Color.BLACK);
       panel.setBounds(5,5,690,490);
       panel.setLayout(null);
       add(panel);


       JTable table = new JTable();
       table.setBounds(0,40,700,350);
       table.setBackground(Color.BLACK);
       table.setForeground(Color.WHITE);
       panel.add(table);

       try{
           con c = new con();
           String departmentInfo = "select * from department";
           ResultSet resultSet= c.statement.executeQuery(departmentInfo);
           table.setModel(DbUtils.resultSetToTableModel(resultSet));


       } catch (Exception e) {
           throw new RuntimeException(e);
       }
       back = new JButton("Back");
       back.setBounds(275,410,120,30);
       back.setBackground(new Color(30,26,26));
       back.setForeground(Color.WHITE);
       panel.add(back);
       back.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               setVisible(false);
           }
       });

       JLabel lable1 = new JLabel("Departments");
        lable1.setBounds(130,11,105,20);
        lable1.setForeground(Color.WHITE);
        lable1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lable1);


        JLabel lable2 = new JLabel("Budget");
        lable2.setBounds(431,11,105,20);
        lable2.setForeground(Color.WHITE);
        lable2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lable2);





        setLocation(350,50);
        setResizable(false);
        setUndecorated(true);
        setLayout(null);
        setSize(700,500);
        setVisible(true);


    }
    public static void main(String[] args) {
        new Department();
    }
}
