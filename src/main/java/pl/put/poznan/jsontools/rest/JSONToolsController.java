package pl.put.poznan.jsontools.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.put.poznan.jsontools.logic.JSONTools;

import java.util.Arrays;


@RestController
@RequestMapping("/{text}")
public class JSONToolsController {

    public JsonNode data;
    private static final Logger logger = LoggerFactory.getLogger(JSONToolsController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));
        //if text is a string, it needs to be transformed into JsonNode
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            data=objectMapper.readTree(text);
        }
        catch(Throwable e){}
        // perform the transformation, you should run your logic here, below is just a silly example
        JSONTools jsontools = new JSONTools(transforms);
        return jsontools.transform(data).toString();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text,
                      @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            data=objectMapper.readTree(text);
        }
        catch(Throwable e){}
        // perform the transformation, you should run your logic here, below is just a silly example
        JSONTools jsontools = new JSONTools(transforms);
        return jsontools.transform(data).toString();
    }



}


