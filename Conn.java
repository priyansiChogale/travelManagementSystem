/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.travelmanagementsystem;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Priyansi
 */
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
           //Class.forName("java.sql.Driver");
           Class.forName("com.mysql.jdbc.Driver");
           c = DriverManager.getConnection("jdbc:mysql://localhost/tms","root","12345678");
           s = c.createStatement();
           //JOptionPane.showMessageDialog(null,"Connection established.");
        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    /*public static void main(String[] args){
        new Conn();
    }*/
}


