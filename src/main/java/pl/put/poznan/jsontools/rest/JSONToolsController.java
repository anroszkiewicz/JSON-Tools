package pl.put.poznan.jsontools.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.put.poznan.jsontools.logic.*;

import java.util.Arrays;


@RestController
@RequestMapping("/{text}")
public class JSONToolsController {

    private static final Logger logger = LoggerFactory.getLogger(JSONToolsController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public JsonNode get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));
        try{
        JsonNode data=objectMapper.readTree(text);
        }
        catch(Throwable e){}
        // perform the transformation, you should run your logic here, below is just a silly example
        Minification jsontools = new Minification();
        return jsontools.transform(data);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public JsonNode post(@PathVariable String text,
                      @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));
        try{
        JsonNode data=objectMapper.readTree(text);
        }
        catch(Throwable e){}
        // perform the transformation, you should run your logic here, below is just a silly example
        Minification jsontools = new Minification();
        return jsontools.transform(data);
    }



}


