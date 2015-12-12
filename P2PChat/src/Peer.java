/*
 * Main node class.
 * @ Ranjan Dhar
 */

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;


public class Peer {
	
	
	private String ipAddress;
	private String nodeId;
	private String pingAck = "";
	private PeerUI peerUI;
	private HashMap<String, String> routingTable = new HashMap<String, String>();
	
	
	public Peer(){
		peerUI = new PeerUI(this);
		peerUI.start();
	}
	
	public void addToRouting(String nodeId, String ipAddress){
		routingTable.put(nodeId, ipAddress);
	}
	
	public void routingInfo(String joinNodeId, String joinIpAddress){
		Map<String, Serializable> routingInfo = new LinkedHashMap<String, Serializable>();
		routingInfo.put("type", "ROUTING_INFO");
		routingInfo.put("gateway_id", nodeId);
		routingInfo.put("node_id", joinNodeId);
		routingInfo.put("ip_address", ipAddress);
		//Iterate through the hash map to build routing table
		JSONArray routeTable = new JSONArray();
		Iterator<Entry<String, String>> iterator = routingTable.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, String> entry = iterator.next();
			Map<String, String> route = new LinkedHashMap<String, String>();
			route.put("node_id", entry.getKey());
			route.put("ip_address", entry.getValue());
			routeTable.add(route);
		}
		routingInfo.put("route_table", routeTable);
		//Send routing table back to joining node.
		communicate(joinIpAddress, JSONValue.toJSONString(routingInfo));
		
		
	}
	
	public void communicate(String ipAddress, String message){
		try{
			Socket socket = new Socket(ipAddress, 5949);
			DataOutputStream sendMessage = new DataOutputStream(socket.getOutputStream());
			sendMessage.writeBytes(message + "\n");
			sendMessage.close();
			socket.close();
			
		}catch(Exception e){
			System.out.println("ERROR: Could Open Socket to: " + ipAddress);
		}
	}

	//Main method
	public static void main(String[] args) throws IOException {
		Peer server = new Peer();
		GatewayHandler gateWayHandler = new GatewayHandler(server, new ServerSocket(5949));
		gateWayHandler.start();
	}
	
	//Getters & Setters
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getPingAck() {
		return pingAck;
	}

	public void setPingAck(String pingAck) {
		this.pingAck = pingAck;
	}
}

