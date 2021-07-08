/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewPackage extends JFrame implements ActionListener{
    JButton b1;
    JLabel l11,l12,l13,l14,l15,l16,l17;
    public ViewPackage(String username){
        setBounds(380,200,900,420);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("VIEW PACKAGE DETAILS");
        heading.setBounds(75,0,300,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading);
        
        ImageIcon i1 = new ImageIcon("C:\\Users\\Priyansi\\Downloads\\icons-20201117T113155Z-001\\icons\\bookedDetails.jpg");
        Image i2 = i1.getImage().getScaledInstance(450, 420, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(450, 0, 450, 420);
        add(l10);
        
        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(30, 50, 150, 25);
        add(l1);
        
        l11 = new JLabel();
        l11.setBounds(200, 50, 150, 25);
        add(l11);
        
        JLabel l2 = new JLabel("Package : ");
        l2.setBounds(30, 90, 150, 25);
        add(l2);
        
        l12 = new JLabel();
        l12.setBounds(200, 90, 150, 25);
        add(l12);
        
        JLabel l3 = new JLabel("Total persons : ");
        l3.setBounds(30, 130, 150, 25);
        add(l3);
        
        l13 = new JLabel();
        l13.setBounds(200, 130, 150, 25);
        add(l13);
        
        JLabel l4 = new JLabel("ID : ");
        l4.setBounds(30, 170, 150, 25);
        add(l4);
        
        l14 = new JLabel();
        l14.setBounds(200, 170, 150, 25);
        add(l14);
        
        JLabel l5 = new JLabel("Number : ");
        l5.setBounds(30, 210, 150, 25);
        add(l5);
        
        l15 = new JLabel();
        l15.setBounds(200, 210, 150, 25);
        add(l15);
        
        JLabel l6 = new JLabel("Phone : ");
        l6.setBounds(30, 250, 150, 25);
        add(l6);
        
        l16 = new JLabel();
        l16.setBounds(200, 250, 150, 25);
        add(l16);
        
        JLabel l7 = new JLabel("Price : ");
        l7.setBounds(30, 290, 150, 25);
        add(l7);
        
        l17 = new JLabel();
        l17.setBounds(200, 290, 150, 25);
        add(l17);
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(180, 330, 100, 25);
        b1.addActionListener(this);
        add(b1);
        
        try{
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from bookPackage where username = '"+username+"'");
           while(rs.next())
           {
               l11.setText(rs.getString(1));
               l12.setText(rs.getString(2));
               l13.setText(rs.getString(3));
               l14.setText(rs.getString(4));
               l15.setText(rs.getString(5));
               l16.setText(rs.getString(6));
               l17.setText(rs.getString(7));
           }
       }catch(Exception e)
       {
           
       }
    }
    
    
    
    public void actionPerformed(ActionEvent ae)
       {
           if(ae.getSource() == b1)
           {
               this.setVisible(false);
           }
       }
    
    public static void main(String args[])
    {
        new ViewPackage("").setVisible(true);
    }
}
