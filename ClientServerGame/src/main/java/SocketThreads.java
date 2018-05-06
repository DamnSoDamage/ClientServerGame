import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SocketThreads extends Thread{
    public List<PlayerCursor> Players = new ArrayList<>();
    PlayerCursor PC;
    Thread tS = new Thread();
    Thread tR = new Thread();
    ClientConnect c;
    threadSend s;
    threadReceive r = new threadReceive();

    public SocketThreads(ClientConnect c, PlayerCursor pc){
        this.c = c;
        r.setClientConnect(c);
        this.PC = pc;
        s = new threadSend(c, pc);
    }


    public void run(){

    while(true) {
        s.run();
        try{
            ExecutorService executor = Executors.newCachedThreadPool();
            Future<List<PlayerCursor>> futureCall = executor.submit(r);
            Players = futureCall.get();
            for(PlayerCursor e : Players){
                System.out.print(e.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    }




}
