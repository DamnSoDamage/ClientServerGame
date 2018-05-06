public class threadSend extends Thread {
    ClientConnect c = new ClientConnect();
    PlayerCursor PC = null;

    public threadSend (ClientConnect c, PlayerCursor pc){
        this.PC = pc;
        this.c = c;
    }

    public void run(){
        c.SendPlayerInfoToServer(PC);
    }

}
