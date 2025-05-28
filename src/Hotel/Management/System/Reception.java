package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception(){
        JPanel  panel= new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,0,1238,820);
        panel.setBackground(Color.BLACK);
        add(panel);


        JPanel  panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,0,270,820);
        panel1.setBackground(Color.BLACK);
        add(panel1);


        ImageIcon panelimg = new ImageIcon(ClassLoader.getSystemResource("icon/ccc.gif"));
        JLabel label11 = new JLabel(panelimg);
        label11.setBounds(315,100,500,500);
        panel. add(label11);




        ImageIcon panel1img = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        JLabel label = new JLabel(panel1img);
        label.setBounds(-100,350,500,500);
        panel1. add(label);

        JButton btnNCF = new JButton("New Customer Form");
        btnNCF.setBounds(30,30,200,30);
        btnNCF.setBackground(new Color(30,26,26));
        btnNCF.setForeground(Color.WHITE);
        panel1.add(btnNCF);
        btnNCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   new NewCustomer();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JButton btnRoom = new JButton("Room");
        btnRoom.setBounds(30,70,200,30);
        btnRoom.setBackground(new Color(30,26,26));
        btnRoom.setForeground(Color.WHITE);
        panel1.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                     new Room();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        JButton btnDepartment = new JButton("Department");
        btnDepartment.setBounds(30,110,200,30);
        btnDepartment.setBackground(new Color(30,26,26));
        btnDepartment.setForeground(Color.WHITE);
        panel1.add(btnDepartment);
        btnDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Department();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JButton btnAEI = new JButton("All Employee Info");
        btnAEI.setBounds(30,150,200,30);
        btnAEI.setBackground(new Color(30,26,26));
        btnAEI.setForeground(Color.WHITE);
        panel1.add(btnAEI);
        btnAEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new AllEmployeeInfo();

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        JButton btnCI = new JButton("Customer Info");
        btnCI.setBounds(30,190,200,30);
        btnCI.setBackground(new Color(30,26,26));
        btnCI.setForeground(Color.WHITE);
        panel1.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new CustomerInfo();

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        JButton btnMI = new JButton("Manager Info");
        btnMI.setBounds(30,230,200,30);
        btnMI.setBackground(new Color(30,26,26));
        btnMI.setForeground(Color.WHITE);
        panel1.add(btnMI);
        btnMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    new ManagerInfo();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



        JButton btnCO = new JButton("Check out");
        btnCO.setBounds(30,270,200,30);
        btnCO.setBackground(new Color(30,26,26));
        btnCO.setForeground(Color.WHITE);
        panel1.add(btnCO);
        btnCO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        JButton btnUC = new JButton("Update Check-In Details");
        btnUC.setBounds(30,310,200,30);
        btnUC.setBackground(new Color(30,26,26));
        btnUC.setForeground(Color.WHITE);
        panel1.add(btnUC);
        btnUC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JButton btnURS = new JButton("Update Room Status");
        btnURS.setBounds(30,350,200,30);
        btnURS.setBackground(new Color(30,26,26));
        btnURS.setForeground(Color.WHITE);
        panel1.add(btnURS);
        btnURS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });





        JButton btnPUS = new JButton("Pick up Service");
        btnPUS.setBounds(30,390,200,30);
        btnPUS.setBackground(new Color(30,26,26));
        btnPUS.setForeground(Color.WHITE);
        panel1.add(btnPUS);
        btnPUS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



        JButton btnSR = new JButton("Search Room");
        btnSR.setBounds(30,430,200,30);
        btnSR.setBackground(new Color(30,26,26));
        btnSR.setForeground(Color.WHITE);
        panel1.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    new SearchRoom();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }});



        JButton back= new JButton("Back");
        back.setBounds(30,650,100,30);
        back.setBackground(new Color(30,26,26));
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Dashboard();
                    setVisible(false);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });







        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setSize(1950,1090);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Reception();
    }
}
