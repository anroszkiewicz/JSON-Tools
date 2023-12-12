package pl.put.poznan.jsontools.transforms;

import com.fasterxml.jackson.databind.JsonNode;

public interface JSONTextOperation {
    public JsonNode operation(JsonNode data);
}
