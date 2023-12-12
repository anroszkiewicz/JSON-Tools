package pl.put.poznan.jsontools.logic;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.put.poznan.jsontools.transforms.*;

public class JSONTools {

    private String jsonString;
    private final String[] transforms;
    private final String[] filterParams;
    private final String[] excludeParams;

    public JSONTools(String jsonString, String[] transforms, String[] filterParams, String[] excludeParams){
        this.jsonString = jsonString;
        this.transforms = transforms;
        this.filterParams = filterParams;
        this.excludeParams = excludeParams;
    }

    public String transform() {
        // of course, normally it would do something based on the transforms
        return jsonString.toUpperCase();
    }
}
