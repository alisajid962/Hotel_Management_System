package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class pickUp extends JFrame {
    Choice c;
    pickUp(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        add(panel);

        JLabel pus = new JLabel("Pick Up Service");
        pus.setBounds(90,11,200,20);
        pus.setForeground(Color.WHITE);
        pus.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(pus);

        JLabel toc = new JLabel("Type of Car");
        toc.setBounds(32,97,89,14);
        toc.setForeground(Color.WHITE);
        toc.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(toc);

        c = new Choice();
        c.setBounds(123,94,150,25);
        panel.add(c);
        try{
            con C = new con();
            ResultSet resultSet = C.statement.executeQuery("select * from driver");
            while (resultSet.next()){
                c.add(resultSet.getString("carname"));

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JTable table = new JTable();
        table.setBounds(0,150,800,250);
        table.setBackground(Color.BLACK);
        table.setForeground(Color.WHITE);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setFont(new Font("Tahoma",Font.BOLD,14));
        header.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,150,800,250);
        scrollPane.getViewport().setBackground(Color.BLACK);
        panel.add(scrollPane);
        try{
            con C1 = new con();
            String q = "select * from driver";
            ResultSet resultSet = C1.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));




        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        JButton display = new JButton("Display");
        display.setBounds(200,450,120,30);
        display.setBackground(new Color(30,26,26));
        display.setForeground(Color.WHITE);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    con c2 = new con();
                   String q = "select * from driver where carname='"+c.getSelectedItem()+"'";
                   ResultSet resultSet = c2.statement.executeQuery(q);
                   table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(40,450,120,30);
        back.setBackground(new Color(30,26,26));
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setLayout(null);
        setUndecorated(true);
        setResizable(false);
        setLocation(350,100);
        setSize(850,550);
        setVisible(true);
    }
    public static void main(String[] args) {
        new pickUp();
    }
}
