/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.travelmanagementsystem;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Wipro
 */
public class Destination extends JFrame implements Runnable{
    Thread t1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JLabel[] label= new JLabel[]{l1,l2,l3,l4,l5,l6,l7,l8,l9,l10};
    JLabel caption;
    
    public void run(){
     
        String[] text= new String[]{"Church Of Our Lady Of Immaculate Conception","Casino Cruise","Panjim Beach","Calangute Beach","Fort Aguada","Tito's Street","Baga Beach","Bondla Wildlife Sanctuary","Dudhsagar Waterfalls","Grand Island"};
        try{
        for(int i=0; i<10;i++){
            this.label[i].setVisible(true);
            caption.setText(text[i]);
            this.label[i].add(caption);
            Thread.sleep(2800);
            this.label[i].setVisible(false);
        }
        }catch(Exception e){}
    }
    
    Destination(){
        setBounds(300,100,900,700);
        ImageIcon i1=null, i2=null ,i3=null ,i4=null,i5=null,i6=null ,i7=null,i8=null,i9=null,i10=null;
        ImageIcon[] img= new ImageIcon[]{i1, i2,i3,i4,i5,i6,i7,i8,i9,i10};
        
        Image j1=null,j2=null, j3=null,j4=null,j5=null,j6=null,j7=null,j8=null,j9=null,j10=null;
        Image[] jimg= new Image[]{j1,j2,j3,j4,j5,j6,j7,j8,j9,j10};
        
          ImageIcon i11=null, i12=null ,i13=null ,i14=null,i15=null,i16=null ,i17=null,i18=null,i19=null,i20=null;
        ImageIcon[] img2 = new ImageIcon[]{i11, i12,i13,i14,i15,i16,i17,i18,i19,i20};
        
        caption= new JLabel();
        caption.setBounds(50,550,1000,70);
        caption.setForeground(Color.WHITE);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        add(caption);
        
        for(int i=0; i<10; i++){
             img[i] = new ImageIcon("C:\\Users\\Priyansi\\Downloads\\icons-20201117T113155Z-001\\icons\\Goa"+(i+1)+".jpg");
        jimg[i] = img[i].getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        img2[i] = new ImageIcon(jimg[i]);
        this.label[i] = new JLabel(img2[i]);
        this.label[i].setBounds(0,0,900,700);
        add(this.label[i]);
        }
        t1= new Thread(this);
        t1.start();
    }
    public static void main(String[] args){
        new Destination().setVisible(true);
     
        
    }
}