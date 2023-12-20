package pl.put.poznan.jsontools.decorators;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
/**
 * Class that filters out all fields out of JSON String except for those in filterParams array
 */
public class Filter extends JSONDecorator {

	private String[] filters;
	/**
	 * Recursive function that removes all fields except those in filters array.
	 * If input JsonNode is an array, then this function is called for each node that is inside this array
	 * @param jsonNode input JSON
	 * @return Result of the filtration in minified form
	 * @throws JsonMappingException Exception on server side
	 * @throws JsonProcessingException Exception that is a result of wrong input data
	 */
	private String filterNode(JsonNode jsonNode) throws JsonMappingException, JsonProcessingException
	{
		if(jsonNode.isArray())
		{
			String res="[";
			for(JsonNode singleNode:jsonNode){
				res+=filterNode(singleNode);
				res+=',';
			}
			res=res.substring(0,res.length()-1);
			res+=']';
			return res;
		}
		else
		{
			ObjectNode objectNode=(ObjectNode) new ObjectMapper().readTree(jsonNode.toString());
			objectNode=objectNode.retain(filters);
			return objectNode.toString();
		}
	}
	/** 
	* Class constructor
	* @param toBeDecorated input JSONString
	* @param filterParams array containing names of fields that should remain in JSON
	*/
	public Filter(JSONString toBeDecorated, String[] filterParams) {
		super(toBeDecorated);
		this.filters = filterParams;
	}
	/**
	 * Method that transforms JSON String into JsonNode, then calls filterNode function to filter the data
	 * @return JSON in String form that contains only the specified fields
	 */
	@Override
	public String getData() {
		String data = super.getData();
		String result;
		ObjectMapper objectMapper = new ObjectMapper();
        try {
			JsonNode jsonNode = objectMapper.readTree(data);
			result=filterNode(jsonNode);
		} 
        catch (JsonMappingException e) {
			return "ERROR: Server side error";
        }
        catch (JsonProcessingException e) {
			return "ERROR: Wrong format of input data";
        }
		return result;
	}
}
