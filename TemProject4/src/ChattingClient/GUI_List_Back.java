package ChattingClient;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

class GUI_List_Back extends JFrame {
	//static int image;
	//TcpFrameClass tcpframeclass = new TcpFrameClass();
	
	
	private JButton jb_image1 = new JButton(new ImageIcon("image1.png"));
	private JButton jb_image2 = new JButton(new ImageIcon("image2.png"));
	private JButton jb_image3 = new JButton(new ImageIcon("image3.png"));
	private JButton jb_image4 = new JButton(new ImageIcon("image4.png"));

	
	public GUI_List_Back() {
		
		
		setLayout(null);
		setTitle("배경 선택");
		setSize(300, 400);
		//setVisible(true);
		setResizable(false);
		
		jb_image1.setBounds(30, 30, 100, 100);
		add(jb_image1);
		jb_image1.setBackground(Color.white);
		//jb_image1.addActionListener(this);
		
		jb_image2.setBounds(150, 30, 100, 100);
		add(jb_image2);
		jb_image2.setBackground(Color.white);
		//jb_image2.addActionListener(this);
		
		jb_image3.setBounds(30, 180, 100, 100);
		add(jb_image3);
		jb_image3.setBackground(Color.white);
		//jb_image3.addActionListener(this);
		
		jb_image4.setBounds(150, 180, 100, 100);
		add(jb_image4);
		jb_image4.setBackground(Color.white);
		//jb_image4.addActionListener(this);
		
		

		
		
	}


	public JButton getJb_image1() {
		return jb_image1;
	}


	public JButton getJb_image2() {
		return jb_image2;
	}


	public JButton getJb_image3() {
		return jb_image3;
	}


	public JButton getJb_image4() {
		return jb_image4;
	}
	


/*	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb_image1) {
			//image = 1;
			
		}
		
		if(e.getSource()==jb_image2) {
			//image = 2;
		}
		
		if(e.getSource()==jb_image3) {
			//image = 3;
		}
		
		if(e.getSource()==jb_image4) {
			//image = 4;
		}
		
		
	
	}*/
	
	
	
	
}