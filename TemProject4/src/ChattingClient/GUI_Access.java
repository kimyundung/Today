package ChattingClient;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class GUI_Access extends JFrame{
	
//속성
	private String 		IP;
	private int 		PORT;
	private String 		nickname;
	
	private JTextField 	tf_name = new JTextField();
	private JButton 	btn_kaja = new JButton(" kaja로 가자 ");
	private JButton 	btn_cancle = new JButton("취소");
	
//생성자
	public GUI_Access(String IP,int PORT) {
		this.IP=IP;
		this.PORT=PORT;
		
		initAccessGUI();	// access화면 구현
		startChatting();	// 버튼 클릭시 chatting 화면으로 가는 기능
	}
	
	//initAccessGUI()
	public void initAccessGUI() {
		setLayout(null);
		setTitle("kaja 채팅");
		setSize(360, 200);
		setVisible(true);
		
		tf_name.setBounds(20, 30, 310, 30);
		add(tf_name);
		
		
		btn_kaja.setBounds(38, 80, 130, 40);
		add(btn_kaja);
		btn_kaja.setBackground(Color.white);
		
		btn_cancle.setBounds(178, 80, 130, 40);
		add(btn_cancle);
		btn_cancle.setBackground(Color.white);
	}
	
	//startChatting()
	public void startChatting() {
		btn_kaja.addActionListener(new MyAction2() );
		btn_cancle.addActionListener(new MyAction2());
		tf_name.addMouseListener(new MyAction2());
		tf_name.addActionListener(new MyAction2());   // enter 실행
	}
	
	class MyAction2 implements ActionListener,MouseListener{
		@Override
		public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==tf_name) {
					if(tf_name.getText().equals("")) {
			               JOptionPane.showMessageDialog(null, "닉네임을 입력해주세요","닉네임 알림", JOptionPane.INFORMATION_MESSAGE);
			               tf_name.requestFocus();
			            } 
			            else {
			            nickname = tf_name.getText();
			            setVisible(false);
			            new Client_Action(IP,PORT,nickname);
			            }
					
					
				}
				if(e.getSource()==btn_kaja) {			
					if(tf_name.getText().equals("")) {
			               JOptionPane.showMessageDialog(null, "닉네임을 입력해주세요","닉네임 알림", JOptionPane.INFORMATION_MESSAGE);
			               tf_name.requestFocus();
			            } 
			            else {
			            nickname = tf_name.getText();
			            setVisible(false);
			            new Client_Action(IP,PORT,nickname);
			            }
					
					
				}
				if(e.getSource()==btn_cancle) {
					System.exit(1);
				}
				
				
			}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			tf_name.setText("");
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		}
	

}
