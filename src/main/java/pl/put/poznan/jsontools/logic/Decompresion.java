package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;

public class Decompresion implements JSONTextOperation{
    public JsonNode transform(JsonNode text){
        // decompression of the text from minificatied form
        return text;
    }
}
