package pl.put.poznan.jsontools.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import pl.put.poznan.jsontools.logic.JSONTools;

import java.util.Arrays;

@RestController
@RequestMapping("/")
public class JSONToolsController {

    private static final Logger logger = LoggerFactory.getLogger(JSONToolsController.class);

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public String get(@RequestParam(value="transforms", defaultValue="minify") String[] transforms, 
                        @RequestParam(value="filterparams", defaultValue="") String[] filterParams,
                        @RequestParam(value="excludeparams", defaultValue="") String[] excludeParams,
                        @RequestBody String jsonString) {

        // log the parameters
        logger.info("Read the following JSON:");
        logger.info(jsonString);
        logger.debug(Arrays.toString(transforms));
        logger.debug(Arrays.toString(filterParams));
        logger.debug(Arrays.toString(excludeParams));

        // pass query parameters to class responsible for logic
        JSONTools jsontools = new JSONTools(jsonString,transforms,filterParams,excludeParams);
        // return result
        logger.info("Completed transformations and returned result");
        return jsontools.transform();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String post(@RequestParam(value="transforms", defaultValue="minify") String[] transforms, 
                        @RequestParam(value="filterparams", defaultValue="") String[] filterParams,
                        @RequestParam(value="excludeparams", defaultValue="") String[] excludeParams,
                        @RequestBody String jsonString) {

        // log the parameters
        logger.info("Read the following JSON:");
        logger.info(jsonString);
        logger.debug(Arrays.toString(transforms));
        logger.debug(Arrays.toString(filterParams));
        logger.debug(Arrays.toString(excludeParams));

        // pass query parameters to class responsible for logic
        JSONTools jsontools = new JSONTools(jsonString,transforms,filterParams,excludeParams);
        // return result
        logger.info("Completed transformations and returned result");
        return jsontools.transform();
    }
}


