package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;

public class Filter implements JSONTextFiltration{
    public JsonNode transform(JsonNode text,String filter)
    {
        return text;
    }
}
