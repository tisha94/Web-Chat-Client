package tiy.webapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Tisha868 on 5/3/16.
 */
public class WebChatClient {

    public String sendMessage(String sentMessage) {



try {

    Socket clientSocket = new Socket("localhost",8005);
    // "localhost" = connects to self
    // changed the clientSocket to connect to the server computer's IP address instead of "localhost".

    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


    // send the server a message
    out.println(sentMessage);


    }catch (Exception exception){

    }return null;

    }
}