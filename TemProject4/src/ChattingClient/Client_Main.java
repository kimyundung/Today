package ChattingClient;



public class Client_Main {
	public static void main(String[] args) {
								// IP 와 PORT 를 넣어주세요
//								String IP = "192.168.0.46";
								String IP = "127.0.0.1";
//		int PORT = 5593;
		int PORT = 5603;
		
		GUI_Access a = new GUI_Access(IP,PORT);
		
		
		a.setVisible(true);
		System.out.println("ClientMain ok");
		
	}
}
