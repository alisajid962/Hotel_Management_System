package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;






public class Room extends JFrame {
    JButton back;
    JTable table;
    Room(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600,200,200,200);
        panel.add(label);


        table = new JTable();
        table.setBackground(Color.BLACK);         // table background black
        table.setForeground(Color.WHITE);         // table text white
              // optional: grid lines color

// Also make the table header black with white text:
        table.getTableHeader().setBackground(Color.BLACK);
        table.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 40, 500, 400);
        scrollPane.getViewport().setBackground(Color.BLACK);
        panel.add(scrollPane);


        try {
            con c = new con();
            String RoomInfo = "select * from  room";
            ResultSet resultSet = c.statement.executeQuery(RoomInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        back = new JButton("Back");
        back.setBounds(200,500,120,30);
        back.setBackground(new Color(30,26,26));
        back.setForeground(Color.WHITE);
       back.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               setVisible(false);
           }
       });
        panel.add(back);

        JLabel room = new JLabel("Room No.");
        room.setForeground(Color.WHITE);
        room.setBounds(12,15,80,19);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(room);

        JLabel availability = new JLabel("Availability");
        availability.setForeground(Color.WHITE);
        availability.setBounds(119,15,80,19);
        availability.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(availability);

        JLabel clean = new JLabel("Cleaning Status");
        clean.setForeground(Color.WHITE);
        clean.setBounds(210,15,150,19);
        clean.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(clean);

        JLabel price = new JLabel("Price");
        price.setForeground(Color.WHITE);
        price.setBounds(340,15,80,19);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);


        JLabel bed = new JLabel("Bed Type");
        bed.setForeground(Color.WHITE);
        bed.setBounds(417,15,150,19);
        bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(bed);




        setResizable(false);
        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(350,50);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Room();
    }
}
