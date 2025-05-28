package Hotel.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class con {
    Connection connection;
    Statement statement;
    public con(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelMS","root","9016c520Ali@@@");
            statement= connection.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }}

