/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.travelmanagementsystem;

/**
 *
 * @author Priyansi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class ForgotPwd extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    ForgotPwd(){
      setBounds(300,200,1000,400);
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      
      JPanel p= new JPanel();
      p.setBounds(0,0,600,400);
      p.setLayout(null);
      add(p);
      
      JLabel l1=new JLabel("Username");
      l1.setBounds(40,30,80, 30);
      l1.setFont(new Font("Tahoma",Font.BOLD,14));
      p.add(l1);
      
      t1= new JTextField();
      t1.setBounds(240,30,200,30);
      t1.setBorder(BorderFactory.createEmptyBorder());
      p.add(t1);
      
      b1= new JButton("Search");
      b1.setBackground(Color.GRAY);
      b1.setForeground(Color.WHITE);
      b1.setBounds(470, 30,100,30);
     b1.addActionListener(this);
      p.add(b1);
      
      JLabel l2=new JLabel("Name");
      l2.setBounds(40,80,80, 30);
      l2.setFont(new Font("Tahoma",Font.BOLD,14));
      p.add(l2);
      
       t2= new JTextField();
      t2.setBounds(240,80,200,30);
      t2.setBorder(BorderFactory.createEmptyBorder());
      t2.setEditable(false);
      p.add(t2);
      
      JLabel l3=new JLabel("Your Security Question");
      l3.setBounds(40,130,180, 30);
      l3.setFont(new Font("Tahoma",Font.BOLD,14));
      p.add(l3);
      
       t3= new JTextField();
      t3.setBounds(240,130,200,30);
      t3.setBorder(BorderFactory.createEmptyBorder());
      t3.setEditable(false);
      p.add(t3);
      
      
      JLabel l4=new JLabel("Answer");
      l4.setBounds(40,180,80, 30);
      l4.setFont(new Font("Tahoma",Font.BOLD,14));
      p.add(l4);
      
       t4= new JTextField();
      t4.setBounds(240,180,200,30);
      t4.setBorder(BorderFactory.createEmptyBorder());
      p.add(t4);
      
      b2= new JButton("Retrieve");
      b2.setBackground(Color.GRAY);
      b2.setForeground(Color.WHITE);
      b2.setBounds(470, 180,100,30);
     b2.addActionListener(this);
      p.add(b2);
      
     JLabel l5=new JLabel("Password");
      l5.setBounds(40,230,80, 30);
      l5.setFont(new Font("Tahoma",Font.BOLD,14));
      p.add(l5);
      
       t5= new JTextField();
      t5.setBounds(240,230,200,30);
      t5.setBorder(BorderFactory.createEmptyBorder());
      t5.setEditable(false);
      p.add(t5);
      
      b3= new JButton("Back");
      b3.setBackground(Color.GRAY);
      b3.setForeground(Color.WHITE);
      b3.setBounds(130,280,100,30);
      b3.addActionListener(this);
      p.add(b3);
      
      ImageIcon i1 = new ImageIcon("C:\\Users\\Priyansi\\Downloads\\icons-20201117T113155Z-001\\icons\\forgotpassword.jpg");
      Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel l6 = new JLabel(i3);
      l6.setBounds(700, 70, 200, 200);
      add(l6);
        
      
     setVisible(true);
     
    }
    public void actionPerformed (ActionEvent ae)
    {
        Conn c=new Conn();
        
        if(ae.getSource()==b1)
        {
            try{
            String sql="select * from account where username= '"+t1.getText()+"'";
            ResultSet rs= c.s.executeQuery(sql);
            
            if(rs.next()){
                t2.setText(rs.getString("name"));
                t3.setText(rs.getString("security"));
            }else{JOptionPane.showMessageDialog(null, "Invalid username");}
            }catch(Exception e){}
        }
        else if(ae.getSource()==b2)
        {
            try{
                String sql="select * from account where answer= '"+t4.getText()+"' AND username= '"+t1.getText()+"'";
                ResultSet rs=c.s.executeQuery(sql);
                if(rs.next()){
                    t5.setText(rs.getString("password"));
                }else{JOptionPane.showMessageDialog(null, "Wrong Answer ! Please try again");}
            }catch(Exception e){}
        }
         else if(ae.getSource() == b3)
     {
          this.setVisible(false);
        new Login().setVisible(true);
        
     }
    }
    public static void main(String[] args){
        new ForgotPwd().setVisible(true);
    }
}
