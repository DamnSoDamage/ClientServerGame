import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.JFrame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class main {


    public static void main (String args [])
    {

        String PlayerName = "name";
        ClientConnect Connection = new ClientConnect();
        PlayerCursor ClientPlayer = new PlayerCursor();
        MultiplayerData ObjectSerialize = new MultiplayerData();
        List<PlayerCursor> Players = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Inserta tu nombre, por favor \n");
            PlayerName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Connection.Connect();
        ClientPlayer.setName(PlayerName);
        ClientPlayer.setCoords(0);
        SocketThreads ST = new SocketThreads(Connection, ClientPlayer);
        ST.run();






















































































        /*

        ObjectMapper mapper = new ObjectMapper();
        GameFrame g = new GameFrame();
        MultiplayerData s;
        ClientConnect si = new ClientConnect();
        s = new MultiplayerData();
        s.GetInfoPlayer(PlayerName, g.GetCurrentX(),g.GetCurrentY());
        String nice = s.Serialize();
        si.Connect();
        PlayerCursor Player = new PlayerCursor(PlayerName, 0);
        String jsonInString = null;
        try {
            //Convert object to JSON string and save into file directly
            jsonInString = mapper.writeValueAsString(Player);
            System.out.println(jsonInString);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        si.SendPlayerInfoToServer(jsonInString);
        String JSON = si.ReceivePlayersInfoFromServer();
        PlayerCursor[] Players = null;
        try{
            Players = mapper.readValue(JSON, PlayerCursor[].class);
        } catch (JsonGenerationException e) {
        e.printStackTrace();
    } catch (JsonMappingException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    for(PlayerCursor e : Players) {
        System.out.println(e.getName());
    }
        System.exit(0);



        JFrame f = new JFrame();
        GameFrame si = new GameFrame();
        f.add(si);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 400);
        f.setVisible(true);

*/

    }


}
