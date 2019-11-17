package ChattingClient;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;

public class Client_Action {

//속성
	
	
	private String 				IP;
	private int					PORT;
	private String 		 		nickname;
	private Socket				socket;
	private DataInputStream 	dis;
	private DataOutputStream 	dos;
	private GUI_Chatting		cgui = new GUI_Chatting();
	private GUI_List			lgui = new GUI_List();
	private GUI_List_Emoticon	egui = new GUI_List_Emoticon();
	private GUI_List_NotePad 	ngui = new GUI_List_NotePad();
	private GUI_List_Back		bgui = new GUI_List_Back();
	Document 	doc = cgui.getView().getDocument();
	
	
//생성자
	
	
	public Client_Action(String IP, int PORT, String nickname) {
		
		this.IP			= IP;
		this.PORT		= PORT;
		this.nickname	= nickname;
		
		cgui.setTitle(nickname+" 님의 채팅방");
				
		network();				//서버 접속    
		chattingGUIaction();  	//액션이벤트 처리
		
		
	}

	

	
	
//이벤트 처리
	
	public void chattingGUIaction() {	
		
		cgui.getBtn_find().addActionListener(new MyAction3()); //1
		cgui.getBtn_list().addActionListener(new MyAction3()); //2
		cgui.getBtn_send().addActionListener(new MyAction3()); //3
		cgui.getBada().addActionListener(new MyAction3());	   //4
		cgui.getBada().addMouseListener(new MyAction3());
		cgui.getTf_search().addActionListener(new MyAction3());//5
		
					
		lgui.getJb_emoticon().addActionListener(new MyAction3());//6
		lgui.getJb_memo().addActionListener(new MyAction3());	//8
		lgui.getJb_image().addActionListener(new MyAction3());	//9
		
		bgui.getJb_image1().addActionListener(new MyAction3());	//10
		bgui.getJb_image2().addActionListener(new MyAction3());	//10
		bgui.getJb_image3().addActionListener(new MyAction3());	//10
		bgui.getJb_image4().addActionListener(new MyAction3());	//10
	
		egui.getEm1().addActionListener(new MyAction3());//7
		egui.getEm2().addActionListener(new MyAction3());//7
		egui.getEm3().addActionListener(new MyAction3());//7
		egui.getEm4().addActionListener(new MyAction3());//7
		egui.getEm5().addActionListener(new MyAction3());//7
		egui.getEm6().addActionListener(new MyAction3());//7
		egui.getEm7().addActionListener(new MyAction3());//7
		egui.getEm8().addActionListener(new MyAction3());//7
		egui.getEm9().addActionListener(new MyAction3());//7
	}
	
	//MyAction3
	
			class MyAction3 implements ActionListener,MouseListener{
				@Override
				public void actionPerformed(ActionEvent e) {
					// 1
					//cgui.getBtn_find()
					//검색 창 생성   
					if(e.getSource()==cgui.getBtn_find()) {
						cgui.getNum().setVisible(false);
						cgui.getTf_search().setVisible(true);
						
						try {
							DataOutputStream file_dos = new DataOutputStream(new FileOutputStream("chattingview"));
							int length = cgui.getView().getText().length() ;
//							System.out.println(length);
							//cgui.getView().getText().length()
							byte[] byteBae = new byte[length];
							byteBae = cgui.getView().getText().getBytes();
							file_dos.write(byteBae);
							cgui.getTf_search().setFocusable(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
					//2
					//cgui.getBtn_list()
					//추가기능 창 보이게
					if(e.getSource()==cgui.getBtn_list()) {
						
						lgui.setVisible(true);
						
					}
					
					//3=4
					//cgui.getBtn_send()
					//메세지   server 전송	view의   오른쪽에 출력
					if(e.getSource()==cgui.getBtn_send()) {
						try {
							
							sendMessage(cgui.getBada().getText()+"\n");
							cgui.getBada().setText("");
							cgui.getBada().requestFocus();
							
											} catch (BadLocationException e1) {
												// TODO Auto-generated catch block
												// e1.printStackTrace();
												System.out.println("메제시 server 전송 에러");
						}
						
					}
					
					
					//4=3
					//cgui.getBada()
					//메세지  sever  전송      view의   오른쪽에 출력
					if(e.getSource()==cgui.getBada()) {
						try {
							
							sendMessage(cgui.getBada().getText()+"\n");
							cgui.getBada().setText("");
							cgui.getBada().requestFocus();
							
											} catch (BadLocationException e1) {
												// TODO Auto-generated catch block
												// e1.printStackTrace();
												System.out.println("메제시 server 전송 에러");
						}
					}
					
					//5
					//cgui.getTf_search()
					//검색어   highlight
					if(e.getSource()==cgui.getTf_search()) {
						
						String viewwords="";
						int start_index=0;
						int end_index=0;
						Highlighter highlighter = cgui.getView().getHighlighter();
						HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
						Object highlightTag;
				
						String searchwords = cgui.getTf_search().getText();
						
						File file1 = new File("chattingview");
						FileInputStream fis;
						
						try {
							
							fis = new FileInputStream(file1);
							DataInputStream file_dis = new DataInputStream(fis);
							byte[] byteBae = new byte[(int)file1.length()]; // 바이트배열 잡기
							file_dis.readFully(byteBae);
							//파일을 바이트베열에 저장
							viewwords = new String(byteBae);			//바이트를 String으로 전환
							String[] viewwordss = viewwords.split("\n");
//							for(int i =0;i<viewwordss.length;i++) {
//								System.out.print(i+":"+viewwordss[i]);
//							}
							viewwords = "";
							for(int i =0;i<viewwordss.length;i++) {
								viewwords += viewwordss[i];
							}
//							System.out.println(viewwords);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException eeee) {
							// TODO Auto-generated catch block
							eeee.printStackTrace();
						}
						
						// index 번호 얻기
						int i =0;
						ArrayList startindexlist = new ArrayList();
						while(i==0 && searchwords.length()!=0) {
//							System.out.println("while문");
							//System.out.println(viewwords);
							if(viewwords.indexOf(searchwords,end_index)>=0) {
								//System.out.println("111111");
								start_index = viewwords.indexOf(searchwords,end_index);	// viewwords에서 검색어를 찾아 척글자의 index번호 알아내기
								end_index = start_index + searchwords.length();
								System.out.println("start_index:"+start_index);
								startindexlist.add(start_index);//start_index를 배열에 저장					
			
							}else {    // 다찾으면 while문 종료
								i=1;
								start_index=0;
								end_index=0;
							}
//							System.out.println(i);
//							System.out.println("-----");
						} //while-end
							
					// paint 하기
						highlighter.removeAllHighlights();
						for(int j=0;j<startindexlist.size();j++) {
							int start = (int) startindexlist.get(j);
							int end = start+searchwords.length();
							
							try {
								highlightTag = highlighter.addHighlight(start,end,painter);
								
								//JOptionPane.showMessageDialog(null, new JScrollPane(tf2.getView()));
							} catch (BadLocationException ee) {
								// TODO Auto-generated catch block
								ee.printStackTrace();
							}
						} //for-end
						startindexlist.clear();
//						System.out.println("clear()호출됨");
						
					}
					
					
					//6
					//lgui.getJb_emoticon()
					//emoticon 창 보이게
					if(e.getSource()==lgui.getJb_emoticon()) {
						
						egui.setVisible(true);
						
					}
					
					
					//7
					//egui.getEm1()
					//이모티톤을 클릭시 textpane에 나오게
					if(e.getSource()==egui.getEm1()) {
						String em = "em1.png";
						emoticon(em);
					}
					if(e.getSource()==egui.getEm2()) {
						String em = "em2.png";
						emoticon(em);
					}
					if(e.getSource()==egui.getEm3()) {
						String em = "em3.png";
						emoticon(em);
					}
					if(e.getSource()==egui.getEm4()) {
						String em = "em4.png";
						emoticon(em);
					}
					if(e.getSource()==egui.getEm5()) {
						String em = "em5.png";
						emoticon(em);
					}
					if(e.getSource()==egui.getEm6()) {
						String em = "em6.png";
						emoticon(em);
					}
					if(e.getSource()==egui.getEm7()) {
						String em = "em7.png";
						emoticon(em);
					}
					if(e.getSource()==egui.getEm8()) {
						String em = "em8.png";
						emoticon(em);
					}
					if(e.getSource()==egui.getEm9()) {
						String em = "em9.png";
						emoticon(em);
					}
					
					
					//8
					//lgui.getJb_memo()
					//메모장 창 보이게
					if(e.getSource()==lgui.getJb_memo()) {
						ngui.setVisible(true);
					}
					
					//9
					//lgui.getJb_image()
					//Back 창 보이게
					if(e.getSource()==lgui.getJb_image()) {
						
						bgui.setVisible(true);
						
					}
					
					
					
					//10
					//bgui.getJb_image1() ...
					// background 사진 선택
					if(e.getSource()==bgui.getJb_image1()) {
						
						cgui.setImg_string("image1.png");
						bgui.setVisible(false);
						lgui.setVisible(false);
						cgui.repaint();
						
						
						
					}
					
					if(e.getSource()==bgui.getJb_image2()) {
						
						cgui.setImg_string("image2.png");
						bgui.setVisible(false);
						lgui.setVisible(false);
						cgui.repaint();
						
						
						
					}
					
					if(e.getSource()==bgui.getJb_image3()) {
						
						cgui.setImg_string("image3.png");
						bgui.setVisible(false);
						lgui.setVisible(false);
						cgui.repaint();
						
						
						
					}
					
					if(e.getSource()==bgui.getJb_image4()) {
						
						cgui.setImg_string("image4.png");
						bgui.setVisible(false);
						lgui.setVisible(false);
						cgui.repaint();
						
						
						
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
				}
				
				public void emoticon(String em) {
					egui.setVisible(false);
					lgui.setVisible(false);
					try {
						sendMessage(em);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					if(arg0.getSource()==cgui.getBada()) {
						//textfield를 클릭시 검색창 없어지게
						cgui.getTf_search().setVisible(false);
						cgui.getNum().setVisible(true);
						//검색후 입력창 클릭시, 표시된 검색어 없어지게
						Highlighter highlighter  = cgui.getView().getHighlighter();
						highlighter.removeAllHighlights();
					}
		
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {}

				@Override
				public void mouseExited(MouseEvent arg0) {}

				@Override
				public void mousePressed(MouseEvent arg0) {

					if(arg0.getSource()==cgui.getBada()) {
						//textfield를 클릭시 검색창 없어지게
						cgui.getTf_search().setVisible(false);
						cgui.getNum().setVisible(true);
						//검색후 입력창 클릭시, 표시된 검색어 없어지게
						//Highlighter highlighter  = cgui.getView().getHighlighter();
						//highlighter.removeAllHighlights();
					}
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {}
			} //MyAction3-end
//이벤트-end
	


//network() 서버 접속
			
			public void network() {
				try {
					socket = new Socket(IP,PORT);
					if(socket!=null) {				//전화 받았는지?   받으면 원통 호출
						stream1();	
						System.out.println("socket ok");
					}
												
				} 							catch (IOException e) {
												// TODO Auto-generated catch block
												// e.printStackTrace();
												System.out.println("Socket  에러 \n");
											} catch (BadLocationException e) {
												// TODO Auto-generated catch block
												System.out.println("Socket 보내지 못함 + BadLocationException");
											}
			} 
			
			
			//원통만들고      메세지server보내기 호출      메세지sever로받기 호출
			public void stream1() throws BadLocationException{   
				try {
					
					dis = new DataInputStream(socket.getInputStream());
					dos = new DataOutputStream(socket.getOutputStream());
					sendMessage(nickname);
					ReadMessage readmessage = new ReadMessage(); //thread
					readmessage.start();
					
										} catch (IOException e) {
											// TODO Auto-generated catch block
											// e.printStackTrace();
											System.out.println("stream error");
				}

				
			}
		///////////////////////////////////////////////////////////////////////////////			
		//sendMessage()
			public void sendMessage(String str) throws BadLocationException {
				try {
					dos.writeUTF(str);
										} catch (IOException e) {
											// TODO Auto-generated catch block
											// e.printStackTrace();
											doc.insertString(doc.getLength(), "sever로 메세지 전솧 error", null);
											sendMessage( "sever로 메세지 전솧 error");
											System.exit(1);
											
											
				}
			}
		///////////////////////////////////////////////////////////////////////////////
		//ReadMessage
			class ReadMessage extends Thread{
				public void run() {
					while(true) {
						try {
						String msg = dis.readUTF();
//						System.out.println(":::::::"+msg);
						try {
							cgui.setSu(Integer.parseInt(msg));
//							System.out.println(cgui.getSu());
							cgui.getNum().setText("채팅 인원수"+cgui.getSu());
						}catch(Exception e) {
							

							int aaa;
							
							if((aaa = msg.indexOf("*대화상대"))>=0) {
								
								lgui.getTa_users().setText(msg);
							
							}else {  
							
								// 이모티콘 출력
								String[] s = msg.split("[<|>|:| |~|-]+");
								
								
								if(s[2].equals("em1.png")) {
									emoticon2(s[1],s[2]);
								}else if(s[2].equals("em2.png")){
									emoticon2(s[1],s[2]);
								}else if(s[2].equals("em3.png")){
									emoticon2(s[1],s[2]);
								}else if(s[2].equals("em4.png")){
									emoticon2(s[1],s[2]);
								}else if(s[2].equals("em5.png")){
									emoticon2(s[1],s[2]);
								}else if(s[2].equals("em6.png")){
									emoticon2(s[1],s[2]);
								}else if(s[2].equals("em7.png")){
									emoticon2(s[1],s[2]);
								}else if(s[2].equals("em8.png")){
									emoticon2(s[1],s[2]);
								}else if(s[2].equals("em9.png")){
									emoticon2(s[1],s[2]);
								}else{    
									// 대화내용 출력
									doc.insertString(doc.getLength(), msg, null);
								}
							}
						
						}
											} catch (IOException | BadLocationException e) {
												// TODO Auto-generated catch block
												// e.printStackTrace();
												System.out.println("메세지 받기 error");
												try {
													dis.close();
													dos.close();
													socket.close();
													break; //에러 발생하면 while문 죵료
												} catch (IOException e1) {
													// TODO Auto-generated catch block
													//e1.printStackTrace();
												}
												
						
						}
					}
				}
				public void emoticon2(String name,String img) {
//					System.out.println(doc.getLength());
//					System.out.println(cgui.getView().getCaretPosition());
					
					try {
						doc.insertString(doc.getLength(), "<<"+name+">> :", null);
						cgui.getView().setCaretPosition(doc.getLength());
						cgui.getView().insertIcon(new ImageIcon(img));
						doc.insertString(doc.getLength(), System.getProperty("line.separator"), null);
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
//					}
				}
			}
			}
				
//network()-end			
			
			

			
			
			
	
//getter setter
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getIP() {
		return IP;
	}
	public int getPORT() {
		return PORT;
	}
	public GUI_Chatting getCgui() {
		return cgui;
	}
	
	
	

			
}
