import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class MultiplayerData {

    public String Serialize(PlayerCursor p){

        ObjectMapper Mapper = new ObjectMapper();
        String PlayerString = null;
        try{
            PlayerString = Mapper.writeValueAsString(p);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return PlayerString;
    }



}
