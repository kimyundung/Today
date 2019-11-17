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

//�Ӽ�
   private GUIServer       guiServer;             //GUIServer �޾ƿ��� ����
   private int         	   PORT = 0 ;            //��Ʈ��ũ ������ ����
   private static int      pp_num=0;            //������ �μ� üũ ����
   private ServerSocket    serverSocket;         //���
   private Socket          socket = new Socket();   //�޾Ƽ� ����
   private Vector          vc = new Vector();      //������ ����
   
   private static StringBuffer user_names = new StringBuffer("**��ȭ���**\n");
   
//������
   public Server_Action(GUIServer guiServer,int PORT) {
      this.PORT			=PORT;
      this.guiServer	=guiServer;      //GUIServer ����
      this.guiServer.setVisible(true);//GUIServer ���̰�

      action();   //�̺�Ʈó��
   }
   

   
   
   
   
// �̺�Ʈó��
   
   
   public void action() {
      guiServer.getBtn_start().addActionListener(new MyAction1());
      guiServer.getBtn_cancle().addActionListener(new MyAction1());
   
   } 
				      class MyAction1 implements ActionListener{
				         @Override
				         public void actionPerformed(ActionEvent e) {
		//start ��ư ó��
				            if(e.getSource()==guiServer.getBtn_start()) {
				               
				               guiServer.getBtn_start().setEnabled(false);
				               server_start();
				               guiServer.getBtn_start().setText("����������");
				               
				            }
	    //cancle ��ư ó��
				            else if(e.getSource()==guiServer.getBtn_cancle()) {
				               
				               guiServer.dispose();  //Releases all of the native screen resources 
				               System.exit(1);        //Terminates the currently running Java Virtual Machine
				               
				            }
				         }
				      } //class MyAction1-end

      
// �̺�Ʈ - end 
      
      
      
      
      
      
// �̺�Ʈ�� �޼���      
      
      //port
      private void server_start() {
         
         try {
            serverSocket = new ServerSocket(PORT);  //���Ѵ��
            if(socket!=null) {
               connection();
            }
         } 									catch (IOException e1) {
								            // TODO Auto-generated catch block
								            // e1.printStackTrace();
								            guiServer.getTextArea().append("������ �̹� ��� �߽��ϴ�...\n");
								         }
      }
      
      
      
      //accept
      private void connection() {     
         
         Thread th = new Thread(new Runnable() {
      //run()
            public void run() {
               while(true) {
                  try {
                     guiServer.getTextArea().append("����� ���� �����...\n");
                     socket = serverSocket.accept();         
                     guiServer.getTextArea().append("����� ����!!!\n");
                              			//����ڰ� ���� �����Ƿ�   �����ؾ� ��
                     UserInfo user = new UserInfo(socket); //thread
                     vc.add(user);      //�ش� ���Ϳ� ����� ��ü�� �߰�
                     user.start();      // ���� ��ü�� ������ ����
                     
                     
                     
                  } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                     guiServer.getTextArea().append("���� �̻�...\n");
                     
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
				         
				         
				         public UserInfo(Socket socket) {   //������
				            this.socket=socket;
				            network();
				         }
				         
				         public void network() {
				            try {
				               
				//nickname �ޱ�
				               dis = new DataInputStream(socket.getInputStream());
				               dos = new DataOutputStream(socket.getOutputStream());
				               nickname = dis.readUTF();
				               guiServer.getTextArea().append("<<"+nickname+">> ���� ���� �ϼ̽��ϴ�.\n");
				               
				            } 									catch (IOException e) {
													               // TODO Auto-generated catch block
													               // e.printStackTrace();
													               guiServer.getTextArea().append("stream ���� ����...\n");
													            }
				         }

				         
				//run()         
				         public void run() {
				//user ����   
				        	 
				        	 pp_num++;
				        	 user_names.append(nickname+"\n");
				        	 
				            // 1.�ο��� �߰�
				            // 2.���ο� client�� �������� clients���� �˸���
				            // 3.ä������ user list�� �߰��ϱ�
				            
				            for(int i=0;i<vc.size();i++) {
				               UserInfo imsi = (UserInfo) vc.elementAt(i);
				               imsi.send_Message("<<"+nickname+" ���� ���� �Ͻ� >>\n");// 2.���ο� client�� �������� clients���� �˸���
				               imsi.send_Message(pp_num+"");              	      // 1.�ο��� �߰�
				               imsi.send_Message(user_names.toString());         // 3.ä������ user list�� �߰��ϱ�
				            }
				            while(true) {
				//������ �޼��� �ޱ�            	
				//�޼����� user������ �Ѹ���
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
				//user ���� 
				                     pp_num--;
				                     dos.close();
				                     dis.close();
				                         this.socket.close();
				                         vc.removeElement(this);
				                         // 1.�ο��� ������
				                         // 2.clients ���� �����ߴٰ� �˸���
				                         // 3.���� ����̸��� ���ֱ�
				                         guiServer.getTextArea().append("<<<<<<<<"+nickname+">>>>>>>> �� ������\n");
				                         int a = user_names.indexOf(nickname);
				                         int aa = a + (nickname+"\n").length();
				                         user_names.delete(a, aa);
				                         for(int i=0;i<vc.size();i++) {
				                        UserInfo imsi = (UserInfo) vc.elementAt(i);
				                            imsi.send_Message("<<<<<<<<<<<<<<<"+nickname+">>>>>>>>>>>>>>> �� ������ \n");  // 2.clients ���� �����ߴٰ� �˸���
				                            imsi.send_Message(pp_num+"");            // 1.�ο��� ������
				                            imsi.send_Message(user_names.toString());   // 3.���� ����̸��� ���ֱ�
				                         }
				                         guiServer.getTextArea().append(vc.size() + " : ���� ���Ϳ� ����� ����� ��\n");
				                         guiServer.getTextArea().append("����� ���� ������ �ڿ� �ݳ� \n");
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
