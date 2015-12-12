/*
 * User interface.
 * @ Ranjan Dhar
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONValue;




public class PeerUI extends Thread{
	
	private Peer peer;
	private BufferedReader reader;

	//Constructor
	public PeerUI(Peer peer){
		this.peer = peer;
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void run(){
		// join Network method
		while(true){
			menu();
		}
	}
	
	public int hashCode(String str){
		int hash = 0;
		for(int i = 0; i < str.length(); i++){
			hash = hash * 31 + str.charAt(i);
		}
		return Math.abs(hash);
	}
	
	//Allow this node to join the network.
	public void joinNetwork(){
		try {
			System.out.println("Join the network.....");
			
			 System.out.println("Enter your name");
			 int hash = hashCode(reader.readLine());
			 String nodeId = Integer.toString(hash);
			
			 /* Manual option of entering the node ID
			System.out.println("Enter Node ID:");
			String nodeId = reader.readLine();*/
			
			System.out.println("Enter Gateway IP Address (Blank for bootstrap node)");
			String gatewayIp = reader.readLine();
			Map<String, String> map = new LinkedHashMap<String, String>();
			map.put("type","JOINING_NETWORK");
			map.put("node_id", nodeId);
			map.put("ip_address", InetAddress.getLocalHost().getHostAddress().toString());
			String jsonText = JSONValue.toJSONString(map);
			// Initialization 
			peer.setIpAddress(InetAddress.getLocalHost().getHostAddress().toString());
			peer.setNodeId(nodeId);
			peer.communicate(gatewayIp, jsonText);
		}
		 catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	// Menu
	public void menu(){
		try{
			System.out.println("");
			System.out.println("Menu: Enter number");
			System.out.println("1. Send Chat Message");
			System.out.println("2. Route Table");
			System.out.println("3. Ping Node");
			System.out.println("4. Leave Network");
			String choice = reader.readLine();
			if(choice.equals("1")){
				// Should go to chat method
			}
			else if(choice.equals("2")){
                // Should go to print routing table method
			}
			else if(choice.equals("3")){
				// ping method
			}
			else if(choice.equals("4")){
				// leave method
			}
			else{
				System.out.println("Please enter a valid input");
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
}
