/*
 * This class represents various functionalities.
 * @ Ranjan Dhar
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;



public  class PeerWorker implements Runnable, PeerChat{

	private Socket socket;
	private Peer peer;
	
	
	public PeerWorker(Socket socket, Peer peer){
		this.socket = socket;
		this.peer = peer;
	}

	@Override
	public void init(Socket socket, int uid) {
		// TODO Auto-generated method stub
	}

	@Override
	public long joinNetwork(InetSocketAddress bootstrap_node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean leaveNetwork(long network_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void chat(String text, String[] tags) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){
				String command = "";
				while(reader.ready()){
					command = reader.readLine(); // Reads the input
					
				}
			}
		}
			 
			catch (Exception e) {
			e.printStackTrace();
		}
	
}

	
}
	

	