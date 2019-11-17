package ChattingServer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JTextArea;

public class Server_Action {

//속성
   private GUIServer       guiServer;             //GUIServer 받아오기 위함
   private int         	   PORT = 0 ;            //네트워크 동신을 위함
   private static int      pp_num=0;            //접속한 인수 체크 위함
   private ServerSocket    serverSocket;         //대기
   private Socket          socket = new Socket();   //받아서 저장
   private Vector          vc = new Vector();      //접속자 저장
   
   private static StringBuffer user_names = new StringBuffer("**대화상대**\n");
   
//생성자
   public Server_Action(GUIServer guiServer,int PORT) {
      this.PORT			=PORT;
      this.guiServer	=guiServer;      //GUIServer 저장
      this.guiServer.setVisible(true);//GUIServer 보이게

      action();   //이벤트처리
   }
   

   
   
   
   
// 이벤트처리
   
   
   public void action() {
      guiServer.getBtn_start().addActionListener(new MyAction1());
      guiServer.getBtn_cancle().addActionListener(new MyAction1());
   
   } 
				      class MyAction1 implements ActionListener{
				         @Override
				         public void actionPerformed(ActionEvent e) {
		//start 버튼 처리
				            if(e.getSource()==guiServer.getBtn_start()) {
				               
				               guiServer.getBtn_start().setEnabled(false);
				               server_start();
				               guiServer.getBtn_start().setText("서버실행중");
				               
				            }
	    //cancle 버튼 처리
				            else if(e.getSource()==guiServer.getBtn_cancle()) {
				               
				               guiServer.dispose();  //Releases all of the native screen resources 
				               System.exit(1);        //Terminates the currently running Java Virtual Machine
				               
				            }
				         }
				      } //class MyAction1-end

      
// 이벤트 - end 
      
      
      
      
      
      
// 이벤트의 메서드      
      
      //port
      private void server_start() {
         
         try {
            serverSocket = new ServerSocket(PORT);  //무한대기
            if(socket!=null) {
               connection();
            }
         } 									catch (IOException e1) {
								            // TODO Auto-generated catch block
								            // e1.printStackTrace();
								            guiServer.getTextArea().append("소켓이 이미 사용 중습니다...\n");
								         }
      }
      
      
      
      //accept
      private void connection() {     
         
         Thread th = new Thread(new Runnable() {
      //run()
            public void run() {
               while(true) {
                  try {
                     guiServer.getTextArea().append("사용자 접속 대기중...\n");
                     socket = serverSocket.accept();         
                     guiServer.getTextArea().append("사용자 접속!!!\n");
                              			//사용자가 접속 했으므로   저장해야 함
                     UserInfo user = new UserInfo(socket); //thread
                     vc.add(user);      //해당 벡터에 사용자 객체를 추가
                     user.start();      // 만든 객체의 스레드 실행
                     
                     
                     
                  } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                     guiServer.getTextArea().append("연결 이상...\n");
                     
                  }
                  
               } //while-end   
            } //run-end
         }); //thread-end
         
         th.start();
         
      } //connection()-end
      
      
			//UserInfo
				      class UserInfo extends Thread{
				         
				         private Socket 			socket;           
				         private DataInputStream 	dis;
				         private DataOutputStream 	dos;
				         private String 			nickname="";
				         
				         
				         public UserInfo(Socket socket) {   //생성자
				            this.socket=socket;
				            network();
				         }
				         
				         public void network() {
				            try {
				               
				//nickname 받기
				               dis = new DataInputStream(socket.getInputStream());
				               dos = new DataOutputStream(socket.getOutputStream());
				               nickname = dis.readUTF();
				               guiServer.getTextArea().append("<<"+nickname+">> 님이 입장 하셨습니다.\n");
				               
				            } 									catch (IOException e) {
													               // TODO Auto-generated catch block
													               // e.printStackTrace();
													               guiServer.getTextArea().append("stream 셋팅 에러...\n");
													            }
				         }

				         
				//run()         
				         public void run() {
				//user 입장   
				        	 
				        	 pp_num++;
				        	 user_names.append(nickname+"\n");
				        	 
				            // 1.인원수 추가
				            // 2.새로운 client가 입장함을 clients한테 알리기
				            // 3.채팅중인 user list에 추가하기
				            
				            for(int i=0;i<vc.size();i++) {
				               UserInfo imsi = (UserInfo) vc.elementAt(i);
				               imsi.send_Message("<<"+nickname+" 님이 입장 하심 >>\n");// 2.새로운 client가 입장함을 clients한테 알리기
				               imsi.send_Message(pp_num+"");              	      // 1.인원수 추가
				               imsi.send_Message(user_names.toString());         // 3.채팅중인 user list에 추가하기
				            }
				            while(true) {
				//들어오는 메세지 받기            	
				//메세지를 user들한테 뿌리기
				               try {
				                  String msg = dis.readUTF();
				                  guiServer.getTextArea().append("<<"+nickname+">> :" + msg);
				                  for(int i=0;i<vc.size();i++) {
				                     UserInfo imsi = (UserInfo) vc.elementAt(i);
				                     imsi.send_Message("<<"+nickname+">> :"+msg);
				                  }
				               } catch (IOException e) {
				                  // TODO Auto-generated catch block
				                  // e.printStackTrace();
				                  try {
				//user 나감 
				                     pp_num--;
				                     dos.close();
				                     dis.close();
				                         this.socket.close();
				                         vc.removeElement(this);
				                         // 1.인원수 적어짐
				                         // 2.clients 한테 퇴장했다고 알리기
				                         // 3.나간 사람이름을 빼주기
				                         guiServer.getTextArea().append("<<<<<<<<"+nickname+">>>>>>>> 님 나가심\n");
				                         int a = user_names.indexOf(nickname);
				                         int aa = a + (nickname+"\n").length();
				                         user_names.delete(a, aa);
				                         for(int i=0;i<vc.size();i++) {
				                        UserInfo imsi = (UserInfo) vc.elementAt(i);
				                            imsi.send_Message("<<<<<<<<<<<<<<<"+nickname+">>>>>>>>>>>>>>> 님 나가심 \n");  // 2.clients 한테 퇴장했다고 알리기
				                            imsi.send_Message(pp_num+"");            // 1.인원수 적어짐
				                            imsi.send_Message(user_names.toString());   // 3.나간 사람이름을 빼주기
				                         }
				                         guiServer.getTextArea().append(vc.size() + " : 현재 벡터에 담겨진 사용자 수\n");
				                         guiServer.getTextArea().append("사용자 접속 끊어짐 자원 반납 \n");
				                     break;
				                  } catch (IOException e1) {
				                     // TODO Auto-generated catch block
				                     e1.printStackTrace();
				                  }
				                      
				               }
				               
				            }   
				         }//run-end				
				         
				         
	       //send_Message()
				         public void send_Message(String str) {
					            try {
					               
					               
					               dos.writeUTF(str);
					               
					               
					               
					            } catch (IOException e) {
					               // TODO Auto-generated catch block
					               //e.printStackTrace();
					               guiServer.getTextArea().append("output message error");
					            }
					         }
				         
				         
				         
				      } //UserInfo-end
				      
      
      
      
      
   
      
      
//getter setter
      
      
   public GUIServer getGuiServer() {
      return guiServer;
   }


   public void setGuiServer(GUIServer guiServer) {
      this.guiServer = guiServer;
   }

   public ServerSocket getServerSocket() {
      return serverSocket;
   }

   public void setServerSocket(ServerSocket serverSocket) {
      this.serverSocket = serverSocket;
   }

   public Socket getSocket() {
      return socket;
   }

   public void setSocket(Socket socket) {
      this.socket = socket;
   }

   public int getPp_num() {
      return pp_num;
   }

   public void setPp_num(int pp_num) {
      this.pp_num = pp_num;
   }

   public Vector getVc() {
      return vc;
   }

   public void setVc(Vector vc) {
      this.vc = vc;
   }

}
