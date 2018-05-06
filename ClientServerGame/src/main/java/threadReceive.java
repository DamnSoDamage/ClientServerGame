import java.util.List;
import java.util.concurrent.Callable;

public class threadReceive implements Callable<List<PlayerCursor>> {
    ClientConnect c= new ClientConnect();

    public void setClientConnect(ClientConnect c) {
        this.c = c;
    }

    public List<PlayerCursor> call(){
       return c.ReceivePlayersInfoFromServer();
    }
}
