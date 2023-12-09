package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;

public class Exclude implements JSONTextFiltration {
    public JsonNode transform(JsonNode text,String filter)
    {
        return text;
    }
}