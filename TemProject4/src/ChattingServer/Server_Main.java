package ChattingServer;






public class Server_Main {
	
	

	public static void main(String[] args) {
		
		int PORT = 5604;
		
		GUIServer guiServer = new GUIServer();
		new Server_Action(guiServer,PORT);
		
		
		
	}

}
