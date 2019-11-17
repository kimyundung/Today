package ChattingServer;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;





public class GUIServer extends JFrame{

//속성
	private JTextArea 		textArea;
	private JScrollPane 	textArea_scroll;
	private JButton 		btn_start;
	private JButton 		btn_cancle;
	
//생성자
	public GUIServer() {
		
		setTitle("Server");
		setLayout(null);
		setSize(360,418);
	//area
		textArea = new JTextArea();
		textArea.setBounds(0,0,360,300);
		textArea.setColumns(20);
		textArea.setRows(5);
		//textArea.setBorder(new LineBorder(Color.black));
		textArea.setEditable(false);
		add("Center",textArea);
	//scroll
		textArea_scroll =new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
											JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		textArea_scroll.getViewport().setView(textArea);
		textArea_scroll.setBounds(0,0,360,300);
		getContentPane().add(textArea_scroll);
	//btn_start
		btn_start = new JButton("서버 실행");
	    btn_start.setBounds(0,300,170,70);
	    btn_start.setBackground(Color.white);
	    btn_start.setFont(new Font("고딕",Font.BOLD,20));
	    add(btn_start);
	//btn_cancle
	    btn_cancle = new JButton("종료하기");
	    btn_cancle.setBounds(170,300,173,70);
	    btn_cancle.setBackground(Color.white);
	    btn_cancle.setFont(new Font("고딕",Font.BOLD,20));
	    add(btn_cancle);
	    
	    this.setVisible(true);
	}


	public JTextArea getTextArea() {
		return textArea;
	}


	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}


	public JScrollPane getTextArea_scroll() {
		return textArea_scroll;
	}


	public void setTextArea_scroll(JScrollPane textArea_scroll) {
		this.textArea_scroll = textArea_scroll;
	}


	public JButton getBtn_start() {
		return btn_start;
	}


	public void setBtn_start(JButton btn_start) {
		this.btn_start = btn_start;
	}


	public JButton getBtn_cancle() {
		return btn_cancle;
	}


	public void setBtn_cancle(JButton btn_cancle) {
		this.btn_cancle = btn_cancle;
	}
	
	
	
	
	
	
	
	
	
	
}
