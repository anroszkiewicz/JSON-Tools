package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.put.poznan.jsontools.decorators.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSONTools {

    private static final Logger logger = LoggerFactory.getLogger(JSONTools.class);

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
        // test wheather text is in valid json format
		ObjectMapper objectMapper = new ObjectMapper();
        try {
			JsonNode jsonNode = objectMapper.readTree(jsonString);
        } 
        catch (JsonMappingException e) {
            logger.debug("ERROR: Object mapper failed");
			return "ERROR: Server side error";
        } 
        catch (JsonProcessingException e) {
            logger.debug("ERROR: Wrong format of input data");
			return "ERROR: Wrong format of input data";
        }

        JSONString decorator = new SimpleJSONString(jsonString);

        for (String transform: transforms) {
            switch(transform) {
                case "minify":
                    decorator = new Minification(decorator);
                    break;
                case "decompress":
                    decorator = new Decompression(decorator);
                    break;
                case "filter":
                    decorator = new Filter(decorator, filterParams);
                    break;
                case "exclude":
                    decorator = new Exclude(decorator, excludeParams);
                    break;
            }
        }
        return decorator.getData();
    }
}
