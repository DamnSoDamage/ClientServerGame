import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.org.objectweb.asm.TypeReference;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


public class ClientConnect {
    private Socket PlayerClient = null;
    private BufferedReader DataFromServer = null;
    private BufferedWriter DataFromClient = null;
    private String IP = "127.0.0.1";
    private int port = 10000;


    public void Connect() {
        try {
            PlayerClient = new Socket(IP, port);
            DataFromServer = new BufferedReader(new InputStreamReader(PlayerClient.getInputStream()));
            DataFromClient = new BufferedWriter(new OutputStreamWriter(PlayerClient.getOutputStream()));
        } catch (ConnectException e) {
            System.err.print("Server is not up");
            System.exit(0);
        } catch (Exception e) {
            System.err.print("Error: " + e);
        }
    }



    public void SendPlayerInfoToServer(PlayerCursor c) {

        ObjectMapper Mapper = new ObjectMapper();
        String PlayerString = null;
        try{
            PlayerString = Mapper.writeValueAsString(c);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
                DataFromClient.write(PlayerString);
                DataFromClient.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (PlayerClient.isClosed()) {
                System.out.print("CLOSED SOCKET");
                System.exit(0);
            }
    }

    public List<PlayerCursor> ReceivePlayersInfoFromServer() {
        String Response = null;
        ObjectMapper Mapper = new ObjectMapper();
        List<PlayerCursor> Players = new ArrayList<>();
        try {
            Response = DataFromServer.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            Players = Mapper.readValue(Response, Mapper.getTypeFactory().constructCollectionType(List.class, PlayerCursor.class));
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Players;

    }
}
