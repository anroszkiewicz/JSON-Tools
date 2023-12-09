package pl.put.poznan.jsontools.logic;
import com.fasterxml.jackson.databind.JsonNode;

import pl.put.poznan.jsontools.executable.*;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class JSONTools {

    private final String[] transforms;

    public JSONTools(String[] transforms){
        this.transforms = transforms;
    }

    public JsonNode transform(JsonNode text){
        // of course, normally it would do something based on the transforms
        Minification minification=new Minification();
        text = minification.operation(text);
        return text;
    }
}
