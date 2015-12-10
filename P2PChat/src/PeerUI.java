/*
 * User interface.
 * @ Ranjan Dhar
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




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