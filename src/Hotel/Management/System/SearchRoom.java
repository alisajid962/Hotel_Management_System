package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {
    JCheckBox checkBox;
    Choice choice;
    JTable roomTable;
    JTableHeader header;
    JButton search,back;

    SearchRoom(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        add(panel);

        JLabel searchForRoom = new JLabel("Search For Room");
        searchForRoom.setBounds(350,11,186,31);
        searchForRoom.setForeground(Color.WHITE);
        searchForRoom.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(searchForRoom);


        checkBox = new JCheckBox("Only Display Available");
        checkBox.setBounds(500,70,205,23);
        checkBox.setForeground(Color.WHITE);
        checkBox.setBackground(Color.BLACK);
        panel.add(checkBox);


        choice = new Choice();
        choice.add("Single Bed");
        choice.add("Double Bed");
        choice.setBounds(200,70,120,20);
        panel.add(choice);
        roomTable = new JTable();

// Table styling
        roomTable.setBackground(Color.BLACK);
        roomTable.setForeground(Color.WHITE);
        roomTable.setGridColor(Color.GRAY);
        roomTable.setSelectionBackground(Color.DARK_GRAY);
        roomTable.setSelectionForeground(Color.WHITE);
         header = roomTable.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Tahoma", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(roomTable);
        scrollPane.setBounds(0, 187, 850, 200);
        scrollPane.getViewport().setBackground(Color.BLACK);  // this is the background behind the table
        panel.add(scrollPane);

        try{
            con c = new con();

            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            roomTable.setModel(DbUtils.resultSetToTableModel(resultSet));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        back = new JButton("Back");
        back.setBackground(new Color(30,26,26));
        back.setBounds(250,400,120,30);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        search = new JButton("Search");
        search.setBackground(new Color(30,26,26));
        search.setBounds(450,400,120,30);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        panel.add(search);







        setLayout(null);
        setUndecorated(true);
        setLocation(350,100);
        setSize(850,550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String searchQ = "select * from room where bed_type = '"+choice.getSelectedItem()+"'";
            String checkBoxQ="select * from room where availability = 'Available' And bed_type = '"+choice.getSelectedItem()+"'";
            try{
                con c = new con();
               ResultSet resultSet =c.statement.executeQuery(searchQ);
               roomTable.setModel(DbUtils.resultSetToTableModel(resultSet));

               if(checkBox.isSelected()){
                   ResultSet resultSet1 = c.statement.executeQuery(checkBoxQ);
                   roomTable.setModel(DbUtils.resultSetToTableModel(resultSet1));

               }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {

        new SearchRoom();
    }
}
