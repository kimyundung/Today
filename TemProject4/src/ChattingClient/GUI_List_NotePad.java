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
	//���� Ŭ���� NotePad... 
    
	   JTextArea textArea; // �޸� ��µǴ� textArea; 
	   JMenuBar menuBar;   // �޴��� 
	   JMenu fileMenu,infoMenu; // �޴� 
	   JMenuItem newItem,openItem,saveItem,endItem,infoItem; // �޴� ������ (���θ����,����, ����, ������ , ���� ����)  
	   JFileChooser chooser;  
	   
	   // ������ 
	   public GUI_List_NotePad() {
	      NotePadGUI();
	   }
	   
	   // main ...     
//	   public static void main(String[] args) {
//	      new GUI_List_NotePad();
//	      
//	   }
	   
	   
	   // �޸��� GUI �޼ҵ� .. 
	   public void NotePadGUI() {
	      
	      chooser = new JFileChooser();
	      
	      // �޴��� .. 
	      menuBar = new JMenuBar();
	      
	      // �޴� ("����(F)" �̸��� ���� ���� �޴� ) 
	      fileMenu = new JMenu("����(F)");
	      
	      //�޴� ������ 
	      newItem = new JMenuItem("���� ����� (N)");
	      openItem = new JMenuItem("���� (O)");
	      saveItem = new JMenuItem("���� (S)");
	      endItem  = new JMenuItem("������ (X)");
	      
	      // new,open,name,save,end(�޴�������) -> fileMenu(�޴�) �� �־��ֱ� 
	      fileMenu.add(newItem);
	      fileMenu.add(openItem);
	      fileMenu.add(saveItem);
	      fileMenu.add(endItem);
	      
	      // �޴��ٿ� fileMenu(�޴�) �־��ֱ� 
	      menuBar.add(fileMenu);
	      
	   
	      // �޴� ("����(I)" �̸��� ���� ���� �޴�) 
	      infoMenu = new JMenu("����(I)");
	      
	      // �޴� ������ 
	      infoItem = new JMenuItem("���� ����");
	      
	      // info (�޴�������) -> infoMenu(�޴�)�� �־��ֱ� 
	      infoMenu.add(infoItem);
	      
	      // �޴��ٿ� infoMenu (�޴�) �־��ֱ� 
	      menuBar.add(infoMenu);
	      
	      // �޴��� -> ���������ӿ� �ֱ� 
	      setJMenuBar(menuBar);
	      
	/////////////////////////////////////////////////////////////////////////////////////////      
	      
	      // �����ȣ ����  (.setMnemonic)
	      fileMenu.setMnemonic('F');         // alt + F -> ���õ� ... 
	      infoMenu.setMnemonic('I');
	      
	      
	      // ����Ű �����ϱ�  ( .setAccelerator)
	      newItem.setAccelerator(KeyStroke.getKeyStroke('N',Event.CTRL_MASK));
	      openItem.setAccelerator(KeyStroke.getKeyStroke('O',Event.CTRL_MASK));
	      saveItem.setAccelerator(KeyStroke.getKeyStroke('S',Event.CTRL_MASK)); 
	      endItem.setAccelerator(KeyStroke.getKeyStroke('X',Event.CTRL_MASK));
	      infoItem.setAccelerator(KeyStroke.getKeyStroke('I',Event.CTRL_MASK)); 
	      
	/////////////////////////////////////////////////////////////////////////////////////////
	      
	      // textArea 
	      textArea = new JTextArea();   
	      add("Center",textArea);                                 // ���� ��ũ�ѹٸ� ���̰��� ... 
	      JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);   
	      add(scroll);
	      scroll.setVisible(true);  
	      
	      // ����������

	      setTitle("�޸���");
	      setSize(400,600);
//	      setVisible(true);
	      
	      
	      // �޴������ۿ����� ( �̺�Ʈ ��� ) ... 
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
	   // ���θ���� �׼� ... 
	   if(e.getSource() == newItem) {
	      textArea.setText("");      // �ʱ�ȭ ��Ű�� ... 
	   }
	   // ������ �׼� ... 
	   else if(e.getSource() ==endItem) {
	      dispose();
	      System.exit(1);
	   }
	   // ���� �׼� .. ( ���� �޴��������� ��������� �޸��忡���� ���� �˾�â ���� ... ) 
	   else if(e.getSource() == infoItem) {
	      JOptionPane.showMessageDialog(infoItem, "NotePad 19/07 1.0 Version   HJW", "����", JOptionPane.INFORMATION_MESSAGE); 
	   }
	   // ���� .. 
	   else if(e.getSource() == openItem) {
//	      JFileChooser js = new JFileChooser();    
	      if(chooser.showOpenDialog(GUI_List_NotePad.this) ==chooser.APPROVE_OPTION) 
	      {
	         try {
	            File file = chooser.getSelectedFile();    // ������ ��� 
	            FileReader fr = new FileReader(file); //2byte ������ ... 
	            int i =0;
	            textArea.setText("");   // textArea �ʱ�ȭ 
	            
	            while((i=fr.read())!= -1) {
	               textArea.append(String.valueOf((char)i));
	            }
	            
	         } catch (Exception e1){}
	         
	      }
	   } 
	   // ���� .. 
	   else if(e.getSource() == saveItem) {
	      if(chooser.showSaveDialog(GUI_List_NotePad.this) == chooser.APPROVE_OPTION) {
	         try {
	            String str = textArea.getText().trim();      //trim() �յ� �������� .. 
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