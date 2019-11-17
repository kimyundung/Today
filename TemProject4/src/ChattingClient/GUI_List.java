package ChattingClient;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI_List extends JFrame {
//                        implements ActionListener{
   private JLabel jl_menu = new JLabel("간편메뉴");
   private JLabel jl_user = new JLabel("대화상대");
   
   private JButton jb_emoticon = new JButton(new ImageIcon("emoticon_menu.png"));
   private JButton jb_file = new JButton(new ImageIcon("file_menu.png"));
   private JButton jb_memo = new JButton(new ImageIcon("memo_menu.png"));
   private JButton jb_image = new JButton(new ImageIcon("image_menu.png"));
   
   private JLabel jl_emoticon = new JLabel("이모티콘 발송");
   private JLabel jl_file = new JLabel("파일전송");
   private JLabel jl_memo = new JLabel("메모");
   private JLabel jl_image = new JLabel("배경 선택");
   
   private JTextArea ta_users = new JTextArea();
   private JScrollPane ta_users_scroll;
   
//   JEmoticonClass emoticonGUI;


   public GUI_List() {
      
//      emoticonGUI = new JEmoticonClass(); //emoticonGUI 구현
      
      setLayout(null);
      setTitle("간편메뉴");
      setSize(300, 550);
      setResizable(false);
      this.setBackground(new Color(255, 255, 0));
//      setBackground(new Color(255,255,0));
      //setVisible(true);
      
      jl_menu.setBounds(0, 0, 350, 30);
      add(jl_menu);
      
      jl_user.setBounds(0, 330, 350, 30);
      add(jl_user);
      
      jb_emoticon.setBounds(30, 40, 96, 96);
      add(jb_emoticon);
      jb_emoticon.setBackground(Color.white);

      
      jl_emoticon.setBounds(30, 130, 100, 30);
      add(jl_emoticon);
      //jl_emoticon.setFont(new Font("굴림", Font.CENTER_BASELINE, 12));
      
      jb_file.setBounds(150, 40, 96, 96);
      add(jb_file);
      jb_file.setBackground(Color.white);
      
      jl_file.setBounds(150, 130, 100, 30);
      add(jl_file);
      
      jb_memo.setBounds(30, 180, 96, 96);
      add(jb_memo);
      jb_memo.setBackground(Color.white);
      
      jl_memo.setBounds(30, 270, 100, 30);
      add(jl_memo);
      
      jb_image.setBounds(150, 180, 96, 96);
      add(jb_image);
      jb_image.setBackground(Color.white);
      
      jl_image.setBounds(150, 270, 100, 30);
      add(jl_image);
//      jb_emoticon.addActionListener(this);
//      jb_file.addActionListener(this);
//      jb_memo.addActionListener(this);
//      jb_image.addActionListener(this);

      ta_users.setBounds(0, 360, 350, 150);
      ta_users.setForeground(Color.BLUE);
//      ta_users.setEnabled(false);
      ta_users.setEditable(false);
      add(ta_users);
      ta_users_scroll = new JScrollPane(ta_users,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    		  						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      ta_users_scroll.getViewport().setView(ta_users);
      ta_users_scroll.setBounds(0, 360, 350, 150);
      getContentPane().add(ta_users_scroll);
      
   }
   
   

   
   
   public JLabel getJl_menu() {
      return jl_menu;
   }

   public JLabel getJl_user() {
      return jl_user;
   }

   public JButton getJb_emoticon() {
      return jb_emoticon;
   }

   public JButton getJb_file() {
      return jb_file;
   }

   public JButton getJb_memo() {
      return jb_memo;
   }

   public JButton getJb_image() {
      return jb_image;
   }

   public JLabel getJl_emoticon() {
      return jl_emoticon;
   }

   public JLabel getJl_file() {
      return jl_file;
   }

   public JLabel getJl_memo() {
      return jl_memo;
   }

   public JLabel getJl_image() {
      return jl_image;
   }
   
   public JTextArea getTa_users() {
      return ta_users;
   }

   public void setTa_users(JTextArea ta_users) {
      this.ta_users = ta_users;
   }

   


}