package pl.put.poznan.jsontools.logic;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.put.poznan.jsontools.transforms.*;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class JSONTools {

    private final String[] transforms;
    public JsonNode data;

    public JSONTools(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text){
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            data=objectMapper.readTree(text);
            Minification minification=new Minification();
            text = minification.operation(data).toString();
        }
        catch(Throwable e){
            System.out.println(e);
        }
        // of course, normally it would do something based on the transforms
        return text;
    }
}
