/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
    
/**
 *
 * @author Priyansi
 */
public class Splash {
    public static void main(String[] args){
        SplashFrame frame = new SplashFrame();
        frame.setVisible(true);
        int x = 1;
        for(int i = 1; i <=500; i+=6, x+=8)
        {
            frame.setLocation(880-(x+i)/2, 400-(i/2));
            frame.setSize(x + (i/2), i);
            try{
                Thread.sleep(10);
            }catch(Exception e){
                
            }
        }
        
        frame.setVisible(true);
    }
}

class SplashFrame extends JFrame implements Runnable {
    SplashFrame(){
        Thread t1;
        ImageIcon i1 = new ImageIcon("C:\\Users\\Priyansi\\Downloads\\icons-20201117T113155Z-001\\icons\\splash.jpg");
        Image i2 = i1.getImage().getScaledInstance(900, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        add(l1);
        
        //setBounds(300,200,900,500);
        setUndecorated(true);
        t1 = new Thread(this);
        t1.start();
    }
    
    public void run(){
        try{
            Thread.sleep(7000);
            this.setVisible(false);
            
            new Login().setVisible(true);
        }catch(Exception e){}
        
    }
}
