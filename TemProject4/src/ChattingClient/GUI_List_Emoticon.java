package ChattingClient;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI_List_Emoticon extends JFrame{
	
   private JButton em1 = new JButton(new ImageIcon("em1.png"));
   private JButton em2 = new JButton(new ImageIcon("em2.png"));
   private JButton em3 = new JButton(new ImageIcon("em3.png"));
   private JButton em4 = new JButton(new ImageIcon("em4.png"));
   private JButton em5 = new JButton(new ImageIcon("em5.png"));
   private JButton em6 = new JButton(new ImageIcon("em6.png"));
   private JButton em7 = new JButton(new ImageIcon("em7.png"));
   private JButton em8 = new JButton(new ImageIcon("em8.png"));
   private JButton em9 = new JButton(new ImageIcon("em9.png"));
   
   
   
   public GUI_List_Emoticon() {
      
      
      setLayout(new GridLayout(3,3,30,30));
      setTitle("이모티콘 발송");
      setSize(500, 500);
//      setVisible(true);
      
//      add(em1);
//      add(em2);
//      add(em3);
//      add(em4);
//      add(em5);
//      add(em6);
//      add(em7);
//      add(em8);
//      add(em9);
      
      
      add(em1);
      em1.setBorderPainted(false);
      em1.setContentAreaFilled(false);;
      em1.setFocusPainted(false);
      //em1.setOpaque(false);
      //em1.addActionListener(this);
      add(em2);
      em2.setBorderPainted(false);
      em2.setContentAreaFilled(false);;
      em2.setFocusPainted(false);
      //em2.addActionListener(this);
      add(em3);
      em3.setBorderPainted(false);
      em3.setContentAreaFilled(false);;
      em3.setFocusPainted(false);
      //em3.addActionListener(this);
      add(em4);
      em4.setBorderPainted(false);
      em4.setContentAreaFilled(false);;
      em4.setFocusPainted(false);
      //em4.addActionListener(this);
      add(em5);
      em5.setBorderPainted(false);
      em5.setContentAreaFilled(false);;
      em5.setFocusPainted(false);
      //em5.addActionListener(this);
      add(em6);
      em6.setBorderPainted(false);
      em6.setContentAreaFilled(false);;
      em6.setFocusPainted(false);
      //em6.addActionListener(this);
      add(em7);
      em7.setBorderPainted(false);
      em7.setContentAreaFilled(false);;
      em7.setFocusPainted(false);
      //em7.addActionListener(this);
      add(em8);
      em8.setBorderPainted(false);
      em8.setContentAreaFilled(false);;
      em8.setFocusPainted(false);
      //em8.addActionListener(this);
      add(em9);
      em9.setBorderPainted(false);
      em9.setContentAreaFilled(false);;
      em9.setFocusPainted(false);
      //em9.addActionListener(this);
      
      
   }
   
   

   public JButton getEm1() {
      return em1;
   }



   public JButton getEm2() {
      return em2;
   }



   public JButton getEm3() {
      return em3;
   }



   public JButton getEm4() {
      return em4;
   }



   public JButton getEm5() {
      return em5;
   }



   public JButton getEm6() {
      return em6;
   }



   public JButton getEm7() {
      return em7;
   }



   public JButton getEm8() {
      return em8;
   }



   public JButton getEm9() {
      return em9;
   }

}