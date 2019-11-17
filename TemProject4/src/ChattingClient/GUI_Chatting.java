package ChattingClient;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class GUI_Chatting extends JFrame{
   
//속성
   
   private int       	su = 0;
   private String       chat;
   
   
   private String       img_string ;
   private Image		img ;
   
   
   private JLabel       num = new JLabel();
   private JButton      btn_find = new JButton(new ImageIcon("btn_find.png"));
   private JButton      btn_list = new JButton(new ImageIcon("btn_list.png"));
   private JButton      btn_send = new JButton("전송");
   private JTextField   bada = new JTextField();
   private JTextField   tf_search = new JTextField();


   private JScrollPane1  view_scroll;  
   private JTextPane    view ;
   
   
   
   
   
   
   class JScrollPane1 extends JScrollPane{

	  public JScrollPane1()
	   {
           this.setOpaque(false);
          //view.paintComponent();
        }
	  public void getpaint(String img_string) {
		  
		 
		  
	  }
	  
      public void paintComponent(Graphics g) {
    	 img = new ImageIcon(getImg_string()).getImage();
         g.drawImage(img,0,0,null);
//         super.printComponent(g);
//         System.out.println(getImg_string());
         

      }

	   
   }
   

   
   
   
   
   
//생성자
   
   public GUI_Chatting () {
	   
	  setImg_string("image1.png");
 	  
      
      this.setLayout(null);
//      this.setTitle("채팅창");
      this.setSize(500,800);
      this.setLocation(370,0);
   
      num.setBounds(0, 0, 100, 40);
      this.add(num);
      
      tf_search.setBounds(0, 0, 400, 40);
      this.add(tf_search);
      tf_search.setVisible(false);
//////////////////////////////////////////////////////////////////////////////
      
      
      //JTextPane
      view = new JTextPane();
//      view = new JTextPane1(img_string);
      view.setBounds(0, 0, 484, 665);
      view.setForeground(Color.BLACK);
      view.setFont(new Font("굴림",Font.BOLD,13));
      view.setOpaque(false);
      // 배경 사진 넣는 코드
      view.setBackground(Color.WHITE);
      
      
//////////////////////////////////////////////////////////////////////////////
      
      
      
      /*view_scroll = new JScrollPane(view,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                              JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);*/
      view_scroll = new JScrollPane1();
      view_scroll.getViewport().setView(view);
      view_scroll.setBounds(0, 40, 484, 665);
      
      view_scroll.getViewport().setOpaque(false);
      view_scroll.setOpaque(false);
      
      getContentPane().add(view_scroll);

      //view_scroll.setVisible(true);  
      //view_scroll.setViewportView(view);
      
      
      
///////////////////////////////////////////////////////////////////////////////////
      
      view.setEditable(false);
//      view.setEnabled(false);
      
      
      bada.setBounds(0, 710, 400, 50);
      add(bada);
      bada.setColumns(10);
      
      //찾기 버튼
      btn_find.setBounds(400, 0, 41, 40);
      add(btn_find);
      btn_find.setBorderPainted(true);
      btn_find.setContentAreaFilled(false);;
      btn_find.setFocusPainted(false);
      //btn_find.setBackground(new Color(234, 234, 234));
      btn_find.setBackground(Color.white);
      
      //추가기능 버튼
      btn_list.setBounds(441, 0, 41, 40);
      add(btn_list);
      btn_list.setBorderPainted(true);
      btn_list.setContentAreaFilled(false);;
      btn_list.setFocusPainted(false);
      //btn_list.setBackground(new Color(234, 234, 234));
      btn_list.setBackground(Color.white);
      
      //전송버튼
      btn_send.setBounds(400, 710, 85, 50);
      btn_send.setBackground(Color.white);
      add(btn_send);
      
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
//getter setter

   public int getSu() {
      return su;
   }

   public void setSu(int su) {
      this.su = su;
   }

   public String getChat() {
      return chat;
   }

   public void setChat(String chat) {
      this.chat = chat;
   }

   public JLabel getNum() {
      return num;
   }

   public void setNum(JLabel num) {
      this.num = num;
   }

   public JButton getBtn_find() {
      return btn_find;
   }

   public void setBtn_find(JButton btn_find) {
      this.btn_find = btn_find;
   }

   public JButton getBtn_list() {
      return btn_list;
   }

   public void setBtn_list(JButton btn_list) {
      this.btn_list = btn_list;
   }

//   public String getImg_string() {
//      return img_string;
//   }
//
//   public void setImg_string(String img_string) {
//      this.img_string = img_string;
//   }

   public JTextPane getView() {
      return view;
   }

   public void setView(JTextPane view) {
      this.view = view;
   }



   public JTextField getBada() {
      return bada;
   }

   public void setBada(JTextField bada) {
      this.bada = bada;
   }

   public JButton getBtn_send() {
      return btn_send;
   }

   public void setBtn_send(JButton btn_send) {
      this.btn_send = btn_send;
   }

   public JTextField getTf_search() {
      return tf_search;
   }

   public void setTf_search(JTextField tf_search) {
      this.tf_search = tf_search;
   }

public String getImg_string() {
	return img_string;
}

public void setImg_string(String img_string) {
	this.img_string = img_string;
}

}























