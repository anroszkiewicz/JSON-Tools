package pl.put.poznan.jsontools.executable;

import com.fasterxml.jackson.databind.JsonNode;

public class Exclude implements JSONTextOperation {

    private final String[] filters;

    public Exclude(String[] filters){
        this.filters = filters;
    }

    public JsonNode operation(JsonNode text)
    {
        return text;
    }
}