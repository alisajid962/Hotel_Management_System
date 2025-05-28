package Hotel.Management.System;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame {
    JTable table;
    JButton back;
    CustomerInfo(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        add(panel);


        table = new JTable();
        table.setBounds(10,40,800,450);
        table.setBackground(Color.BLACK);
        table.setForeground(Color.WHITE);
        JTableHeader header =  table.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10,40,800,450);
        scrollPane.getViewport().setBackground(Color.BLACK);
        panel.add(scrollPane);

        back = new JButton("Back");
        back.setBounds(350,500,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(new Color (30,26,26));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(back);


        try{
            con c = new con();
            String q = "select * from customerInfo";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        setLayout(null);
        setUndecorated(true);
        setLocation(350,100);
        setResizable(false);
        setSize(850,550);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CustomerInfo();
    }
}
