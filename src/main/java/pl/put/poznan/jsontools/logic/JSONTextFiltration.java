package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;

public interface JSONTextFiltration {
    public JsonNode transform(JsonNode text,String filter);
}
