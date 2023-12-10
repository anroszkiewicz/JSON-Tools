package pl.put.poznan.jsontools.transforms;

import com.fasterxml.jackson.databind.JsonNode;

public class Filter implements JSONTextOperation {

    private final String[] filters;

    public Filter(String[] filters){
        this.filters = filters;
    }

    public JsonNode operation(JsonNode data)
    {
        return data;
    }
}
