package pl.put.poznan.jsontools.executable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



public class Minification implements JSONTextOperation
{
    public JsonNode operation(JsonNode text)
    {
        // ObjectMapper objectMapper = new ObjectMapper();
        // // JsonNode jsonNode = readJsonIntoJsonNode();
        // return objectMapper.writeValueAsString(text); 

        // String result = removeExtraWhitespaceUsingJackson(text);
        // return result;



        ObjectMapper objectMapper = new ObjectMapper();
        String json = new String();
        try 
        {
            json = objectMapper.writeValueAsString(text);
        } 
        catch (JsonProcessingException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        JsonNode jsonNode = text;
        try 
        {
            jsonNode = objectMapper.readTree(json);
        } 
        catch (JsonMappingException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        catch (JsonProcessingException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonNode;




        // ObjectMapper objectMapper = new ObjectMapper();
        // String json = new String();
        // json = objectMapper.writeValueAsString(text);
        // JsonNode jsonNode = text;
        // jsonNode = objectMapper.readTree(json);
        // return jsonNode;
    }
}