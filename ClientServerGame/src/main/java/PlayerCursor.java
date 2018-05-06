
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class PlayerCursor {
    private String name;
    private Integer coords;

    public  PlayerCursor(){
        this.name = "DEFAULT NAME";
        this.coords = 0;
    }

    @JsonCreator
    public PlayerCursor(@JsonProperty("name") String name, @JsonProperty("coords") Integer coords){
        this.name = name;
        this.coords = coords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoords() {
        return coords;
    }

    public void setCoords(int coords) {
        this.coords = coords;
    }

   // public void drawPlayer (Graphics g){

        //g.fillRect(x,y,10, 10);
     //   g.setColor(Color.MAGENTA);

    //}

}
