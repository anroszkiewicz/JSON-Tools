package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;

public interface JSONTextOperation {
    public JsonNode transform(JsonNode text);
}
