package pl.put.poznan.jsontools.transforms;

import com.fasterxml.jackson.databind.JsonNode;

public class Exclude implements JSONTextOperation {

    private final String[] filters;

    public Exclude(String[] filters){
        this.filters = filters;
    }

    public JsonNode operation(JsonNode data)
    {
        return data;
    }
}