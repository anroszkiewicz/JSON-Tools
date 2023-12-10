package pl.put.poznan.jsontools.transforms;

import com.fasterxml.jackson.databind.JsonNode;

public class Minification implements JSONTextOperation{
    public JsonNode operation(JsonNode data){
        // transform text into minificated form
        return data;
    }
}
