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
public class Login extends JFrame implements ActionListener{
    JButton b1,b2,b3;
    JTextField t1;
    JPasswordField t2;
    Login(){
        setLayout(null);
        setVisible(true);
        setBounds(300,200,900,400);
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon("C:\\Users\\Priyansi\\Downloads\\icons-20201117T113155Z-001\\icons\\login.png");
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(100, 120, 200, 200);
        p1.add(l1);
        
        JPanel p2 = new JPanel();
        p2.setBounds(400, 0, 450, 400);
        p2.setLayout(null);
        add(p2);
        
        JLabel l2 = new JLabel("Username");
        l2.setBounds(80,30,100,30);
        l2.setFont(new Font("SAN SERIF",Font.PLAIN, 20));
        p2.add(l2);
        
        t1 = new JTextField();
        t1.setBounds(80,70, 250, 30);
        p2.add(t1);
        
        JLabel l3 = new JLabel("Password");
        l3.setBounds(80,110,100,30);
        l3.setFont(new Font("SAN SERIF",Font.PLAIN, 20));
        p2.add(l3);
        
        t2 = new JPasswordField();
        t2.setBounds(80,150, 250, 30);
        p2.add(t2);
        
        b1 = new JButton("Login");
        b1.setBounds(80, 200, 100, 30);
        b1.addActionListener(this);
        p2.add(b1);
        
        b2 = new JButton("Sign Up");
        b2.setBounds(220, 200, 100, 30);
        b2.addActionListener(this);
        p2.add(b2);
        
        b3 = new JButton("Forgot Password");
        b3.setBounds(130, 250, 150, 30);
        b3.addActionListener(this);
        p2.add(b3);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                String username = t1.getText();
                String password = t2.getText();
                String sql = "select * from account where username = '"+username+"' AND password = '"+password+"'";
                Conn C = new Conn();
                ResultSet rs = C.s.executeQuery(sql);
                if(rs.next())
                {
                    this.setVisible(false);
                    new Loading(username).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }
            }
            catch(Exception e){}
        }
        else if(ae.getSource() == b2){
            this.setVisible(false);
            new SignUp().setVisible(true);
            }
        else{
            this.setVisible(false);
            new ForgotPwd().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
