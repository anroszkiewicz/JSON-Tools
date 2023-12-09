package pl.put.poznan.jsontools.executable;

import com.fasterxml.jackson.databind.JsonNode;

public class Decompression implements JSONTextOperation{
    public JsonNode operation(JsonNode text){
        // decompression of the text from minificatied form
        return text;
    }
}
