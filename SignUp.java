/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.travelmanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Priyansi
 */
public class SignUp extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    Choice c1;
    String query;
    SignUp(){
        setBounds(300,200,900,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        
        JLabel l1 = new JLabel("Username");
        l1.setBounds(50,20,100,25);
        l1.setFont(new Font("Tahoma",Font.BOLD, 14));
        p1.add(l1);
        
        t1 = new JTextField();
        t1.setBounds(190,20, 180, 25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t1);
        
        JLabel l2 = new JLabel("Name");
        l2.setBounds(50,60,100,25);
        l2.setFont(new Font("Tahoma",Font.BOLD, 14));
        p1.add(l2);
        
        t2 = new JTextField();
        t2.setBounds(190,60, 180, 25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t2);
        
        JLabel l3 = new JLabel("Password");
        l3.setBounds(50,100,100,25);
        l3.setFont(new Font("Tahoma",Font.BOLD, 14));
        p1.add(l3);
        
        t3 = new JTextField();
        t3.setBounds(190,100, 180, 25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);
        
        JLabel l4 = new JLabel("Security Question");
        l4.setBounds(50,140,130,25);
        l4.setFont(new Font("Tahoma",Font.BOLD, 14));
        p1.add(l4);
        
        c1 = new Choice();
        c1.add("Your lucky number ?");
        c1.add("Your favourite color ?");
        c1.add("Your nickname ?");
        c1.setBounds(190,140,220,25);
        p1.add(c1);
        
        JLabel l5 = new JLabel("Answer");
        l5.setBounds(50,180,100,25);
        l5.setFont(new Font("Tahoma",Font.BOLD, 14));
        p1.add(l5);
        
        t4 = new JTextField();
        t4.setBounds(190,180, 180, 25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);
        
        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setBounds(80, 230, 100, 30);
        p1.add(b1);
        
        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(200, 230, 100, 30);
        p1.add(b2);
        
        ImageIcon i1 = new ImageIcon("C:\\Users\\Priyansi\\Downloads\\icons-20201117T113155Z-001\\icons\\signup.png");
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(550, 50, 200, 200);
        add(l6);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String security = c1.getSelectedItem();
            String answer = t4.getText();
            
            query = "insert into account values('"+username+"','"+name+"','"+password+"','"+security+"','"+answer+"')";
            
            try{
                Conn C = new Conn();
                C.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account created successfully.");
                this.setVisible(false);
                new Login().setVisible(true);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Account NOT created.");
            }
        }
        else if(ae.getSource() == b2){
            this.setVisible(false);
            new Login().setVisible(true);
        }
        else{
    
        }
    }
    
    
    public static void main(String[] args){
        new SignUp().setVisible(true);
    }
}


