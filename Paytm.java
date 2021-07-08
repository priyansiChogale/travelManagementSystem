/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.travelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Priyansi
 */
public class Paytm extends JFrame implements ActionListener{
    
    Paytm()
    {
       JEditorPane j = new JEditorPane();
       j.setEditable(false);
       
       try{
         j.setPage("https://paytm.com/credit-card-bill-payment");  
       }catch(Exception e){
            j.setContentType("text/html");
            j.setText("<html>Could not load, Error 404</html>");
       }
       
       JScrollPane js = new JScrollPane(j);
       getContentPane().add(js);
       
       JButton b1 = new JButton("Back");
       b1.setBounds(610, 20, 80, 40);
       b1.addActionListener(this);
       j.add(b1);
       
       setBounds(640, 200, 800, 600);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        this.setVisible(false);
        new Payment().setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new Paytm().setVisible(true);
    }
}
