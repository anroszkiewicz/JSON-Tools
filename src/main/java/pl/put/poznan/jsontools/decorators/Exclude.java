package pl.put.poznan.jsontools.decorators;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
/**
 * Class that filters out all fields out of JSON String included in excludeParams array
 */
public class Exclude extends JSONDecorator {

	private String[] filters;

	/**
	 * Recursive function that removes all fields included in filters array.
	 * If input JsonNode is an array, then this function is called for each node that is inside this array
	 * @param jsonNode input JSON
	 * @return Result of the filtration in minified form
	 * @throws JsonMappingException Exception on server side
	 * @throws JsonProcessingException Exception that is a result of wrong input data
	 */
	private String excludeNode(JsonNode jsonNode) throws JsonMappingException, JsonProcessingException
	{
		if(jsonNode.isArray())
		{
			String res="[";
			for(JsonNode singleNode:jsonNode){
				res+=excludeNode(singleNode);
				res+=',';
			}
			res=res.substring(0,res.length()-1);
			res+=']';
			return res;
		}
		else
		{
			ObjectNode objectNode=(ObjectNode) new ObjectMapper().readTree(jsonNode.toString());
			for(String filter: filters){
				objectNode=objectNode.without(filter);
			}
			return objectNode.toString();
		}
	}
	/** 
	* Class constructor
	*/
	public Exclude(JSONString toBeDecorated, String[] excludeParams) {
		super(toBeDecorated);
		this.filters = excludeParams;
	}
	/**
	 * Method that transforms JSON String into JsonNode, then calls excludeNode function to filter the data
	 */
	@Override
	public String getData() {
		String data = super.getData();
		String res="";
		ObjectMapper objectMapper = new ObjectMapper();
        try {
			JsonNode jsonNode = objectMapper.readTree(data);
			res=excludeNode(jsonNode);
        } 
        catch (JsonMappingException e) {
			return "ERROR: Server side error";
        }
        catch (JsonProcessingException e) {
			return "ERROR: Wrong format of input data";
        }
		return res;
	}
}
