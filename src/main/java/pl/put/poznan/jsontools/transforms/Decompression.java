package pl.put.poznan.jsontools.transforms;

import com.fasterxml.jackson.databind.JsonNode;

public class Decompression implements JSONTextOperation{
    public JsonNode operation(JsonNode data){
        // decompression of the text from minificatied form
        return data;
    }
}
