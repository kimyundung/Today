package ChattingClient;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class GUI_List_NotePad extends JFrame implements ActionListener{
	//구현 클래스 NotePad... 
    
	   JTextArea textArea; // 메모가 출력되는 textArea; 
	   JMenuBar menuBar;   // 메뉴바 
	   JMenu fileMenu,infoMenu; // 메뉴 
	   JMenuItem newItem,openItem,saveItem,endItem,infoItem; // 메뉴 아이템 (새로만들기,열기, 저장, 끝내기 , 정보 보기)  
	   JFileChooser chooser;  
	   
	   // 생성자 
	   public GUI_List_NotePad() {
	      NotePadGUI();
	   }
	   
	   // main ...     
//	   public static void main(String[] args) {
//	      new GUI_List_NotePad();
//	      
//	   }
	   
	   
	   // 메모장 GUI 메소드 .. 
	   public void NotePadGUI() {
	      
	      chooser = new JFileChooser();
	      
	      // 메뉴바 .. 
	      menuBar = new JMenuBar();
	      
	      // 메뉴 ("파일(F)" 이름을 가진 파일 메뉴 ) 
	      fileMenu = new JMenu("파일(F)");
	      
	      //메뉴 아이템 
	      newItem = new JMenuItem("새로 만들기 (N)");
	      openItem = new JMenuItem("열기 (O)");
	      saveItem = new JMenuItem("저장 (S)");
	      endItem  = new JMenuItem("끝내기 (X)");
	      
	      // new,open,name,save,end(메뉴아이템) -> fileMenu(메뉴) 에 넣어주기 
	      fileMenu.add(newItem);
	      fileMenu.add(openItem);
	      fileMenu.add(saveItem);
	      fileMenu.add(endItem);
	      
	      // 메뉴바에 fileMenu(메뉴) 넣어주기 
	      menuBar.add(fileMenu);
	      
	   
	      // 메뉴 ("정보(I)" 이름을 가진 정보 메뉴) 
	      infoMenu = new JMenu("정보(I)");
	      
	      // 메뉴 아이템 
	      infoItem = new JMenuItem("정보 보기");
	      
	      // info (메뉴아이템) -> infoMenu(메뉴)에 넣어주기 
	      infoMenu.add(infoItem);
	      
	      // 메뉴바에 infoMenu (메뉴) 넣어주기 
	      menuBar.add(infoMenu);
	      
	      // 메뉴바 -> 메인프레임에 넣기 
	      setJMenuBar(menuBar);
	      
	/////////////////////////////////////////////////////////////////////////////////////////      
	      
	      // 연상기호 설정  (.setMnemonic)
	      fileMenu.setMnemonic('F');         // alt + F -> 선택됨 ... 
	      infoMenu.setMnemonic('I');
	      
	      
	      // 단축키 설정하기  ( .setAccelerator)
	      newItem.setAccelerator(KeyStroke.getKeyStroke('N',Event.CTRL_MASK));
	      openItem.setAccelerator(KeyStroke.getKeyStroke('O',Event.CTRL_MASK));
	      saveItem.setAccelerator(KeyStroke.getKeyStroke('S',Event.CTRL_MASK)); 
	      endItem.setAccelerator(KeyStroke.getKeyStroke('X',Event.CTRL_MASK));
	      infoItem.setAccelerator(KeyStroke.getKeyStroke('I',Event.CTRL_MASK)); 
	      
	/////////////////////////////////////////////////////////////////////////////////////////
	      
	      // textArea 
	      textArea = new JTextArea();   
	      add("Center",textArea);                                 // 세로 스크롤바만 보이게함 ... 
	      JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);   
	      add(scroll);
	      scroll.setVisible(true);  
	      
	      // 메인프레임

	      setTitle("메모장");
	      setSize(400,600);
//	      setVisible(true);
	      
	      
	      // 메뉴아이템에대한 ( 이벤트 등록 ) ... 
	      newItem.addActionListener(this);
	      openItem.addActionListener(this);
	      saveItem.addActionListener(this);
	      endItem.addActionListener(this);
	      infoItem.addActionListener(this);
	      
	      
	   
	   }
	   

	   
	////////////////////////////////////////////////
	////////////////////////////////////////////////
	////////////////////////////////////////////////
	   
	      
	// actionPerformed ... 
	@Override 
	public void actionPerformed(ActionEvent e) {
	   // TODO Auto-generated method stub
	   // 새로만들기 액션 ... 
	   if(e.getSource() == newItem) {
	      textArea.setText("");      // 초기화 시키기 ... 
	   }
	   // 끝내기 액션 ... 
	   else if(e.getSource() ==endItem) {
	      dispose();
	      System.exit(1);
	   }
	   // 정보 액션 .. ( 정보 메뉴아이템을 눌렀을경우 메모장에대한 정보 팝업창 구현 ... ) 
	   else if(e.getSource() == infoItem) {
	      JOptionPane.showMessageDialog(infoItem, "NotePad 19/07 1.0 Version   HJW", "정보", JOptionPane.INFORMATION_MESSAGE); 
	   }
	   // 열기 .. 
	   else if(e.getSource() == openItem) {
//	      JFileChooser js = new JFileChooser();    
	      if(chooser.showOpenDialog(GUI_List_NotePad.this) ==chooser.APPROVE_OPTION) 
	      {
	         try {
	            File file = chooser.getSelectedFile();    // 파일의 경로 
	            FileReader fr = new FileReader(file); //2byte 단위로 ... 
	            int i =0;
	            textArea.setText("");   // textArea 초기화 
	            
	            while((i=fr.read())!= -1) {
	               textArea.append(String.valueOf((char)i));
	            }
	            
	         } catch (Exception e1){}
	         
	      }
	   } 
	   // 저장 .. 
	   else if(e.getSource() == saveItem) {
	      if(chooser.showSaveDialog(GUI_List_NotePad.this) == chooser.APPROVE_OPTION) {
	         try {
	            String str = textArea.getText().trim();      //trim() 앞뒤 공백제거 .. 
	            if(str.length() < 1)
	               return; 
	            File file = chooser.getSelectedFile();
	            FileWriter fw = new FileWriter(file);
	            
	            fw.write(str);
	            fw.close();
	         }catch(Exception e2) {}
	      }
	   }
	   
	}



	}