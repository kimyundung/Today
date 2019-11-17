package ChattingClient;



public class Client_Main {
	public static void main(String[] args) {
								// IP 客 PORT 甫 持绢林技夸
//								String IP = "192.168.0.46";
								String IP = "127.0.0.1";
//		int PORT = 5593;
		int PORT = 5603;
		
		GUI_Access a = new GUI_Access(IP,PORT);
		
		
		a.setVisible(true);
		System.out.println("ClientMain ok");
		
	}
}
