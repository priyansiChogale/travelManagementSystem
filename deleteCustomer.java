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
/**
 *
 * @author Priyansi
 */
public class deleteCustomer extends JFrame implements ActionListener{
    
    JButton b1,b2;
    String username;
    deleteCustomer(String user)
    {
        this.username = user;
        setBounds(700, 250, 850, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("DELETE CUSTOMER DETAILS");
        heading.setBounds(50,0,300,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading);
        
        setBounds(450, 190, 850, 585);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(30, 50, 150, 25);
        add(l1);
        
        JLabel l11 = new JLabel();
        l11.setBounds(200, 50, 150, 25);
        add(l11);
        
        JLabel l2 = new JLabel("ID : ");
        l2.setBounds(30, 90, 150, 25);
        add(l2);
        
        JLabel l12 = new JLabel();
        l12.setBounds(200, 90, 150, 25);
        add(l12);
        
        JLabel l3 = new JLabel("Number : ");
        l3.setBounds(30, 130, 150, 25);
        add(l3);
        
        JLabel l13 = new JLabel();
        l13.setBounds(200, 130, 150, 25);
        add(l13);
        
        JLabel l4 = new JLabel("Name : ");
        l4.setBounds(30, 170, 150, 25);
        add(l4);
        
        JLabel l14 = new JLabel();
        l14.setBounds(200, 170, 150, 25);
        add(l14);
        
        JLabel l5 = new JLabel("Gender : ");
        l5.setBounds(30, 210, 150, 25);
        add(l5);
        
        JLabel l15 = new JLabel();
        l15.setBounds(200, 210, 150, 25);
        add(l15);
        
        JLabel l6 = new JLabel("Country : ");
        l6.setBounds(30, 250, 150, 25);
        add(l6);
        
        JLabel l16 = new JLabel();
        l16.setBounds(200, 250, 150, 25);
        add(l16);
        
        JLabel l7 = new JLabel("Address : ");
        l7.setBounds(30, 290, 150, 25);
        add(l7);
        
        JLabel l17 = new JLabel();
        l17.setBounds(200, 290, 150, 25);
        add(l17);
        
         JLabel l8 = new JLabel("Phone : ");
        l8.setBounds(30, 330, 150, 25);
        add(l8);
        
        JLabel l18 = new JLabel();
        l18.setBounds(200, 330, 150, 25);
        add(l18);
        
        JLabel l9 = new JLabel("E-mail id : ");
        l9.setBounds(30, 370, 150, 25);
        add(l9);
        
        JLabel l19 = new JLabel();
        l19.setBounds(200, 370, 200, 25);
        add(l19);
        
        b1 = new JButton("Delete");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(70, 430, 100, 25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(220, 430, 100, 25);
        b2.addActionListener(this);
        add(b2);
        
       ImageIcon i1 = new ImageIcon("C:\\Users\\Priyansi\\Downloads\\icons-20201117T113155Z-001\\icons\\delete.png");
       Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel l10 = new JLabel(i3);
       l10.setBounds(400, 100, 450, 300);
       add(l10);
       //System.out.println(username);
       
       try{
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'"); 
           while(rs.next())
           {
               l11.setText(rs.getString("username"));
               l13.setText(rs.getString("number"));
               l14.setText(rs.getString("name"));
               l16.setText(rs.getString("country"));
               l17.setText(rs.getString("address"));
               l18.setText(rs.getString("phone"));
               l19.setText(rs.getString("email"));
               l12.setText(rs.getString("id"));
               l15.setText(rs.getString("gender"));
               
           }
       }catch(Exception e)
       {
           
       }
          
    }
    public void actionPerformed(ActionEvent ae)
       {
           if(ae.getSource() == b1){
           try{
               Conn c = new Conn();
               c.s.executeUpdate("delete from account where username = '"+username+"'");
               c.s.executeUpdate("delete from bookHotel where username = '"+username+"'");
               c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
               c.s.executeUpdate("delete from customer where username = '"+username+"'");
            
               JOptionPane.showMessageDialog(null, "Customer Details deleted successfully");
               System.exit(0);
           }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
           }else if(ae.getSource() == b2)
           {
               this.setVisible(false);
           }
       }
    
    public static void main(String[] args)
    {
        new deleteCustomer("").setVisible(true);
    }
}
