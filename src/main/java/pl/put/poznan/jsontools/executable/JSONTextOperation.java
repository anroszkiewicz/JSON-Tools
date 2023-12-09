package pl.put.poznan.jsontools.executable;

import com.fasterxml.jackson.databind.JsonNode;

public interface JSONTextOperation {
    public JsonNode operation(JsonNode text);
}
