/*
 * Main node class.
 * @ Ranjan Dhar
 */

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;


public class Peer {
	
	
	private String ipAddress;
	private String nodeId;
	private String pingAck = "";

	//Main method
	public static void main(String[] args) throws IOException {
		Peer server = new Peer();
		GatewayHandler gateWayHandler = new GatewayHandler(server, new ServerSocket(8767));
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

