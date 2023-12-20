package pl.put.poznan.jsontools.decorators;
/**
 * A general decorator class that all decorators extend
 */
public class JSONDecorator implements JSONString {
	
	private JSONString jsonString;

	/** 
	* Class constructor
	* @param toBeDecorated input JSON
	*/
	public JSONDecorator(JSONString toBeDecorated) {
		this.jsonString = toBeDecorated;
	}

	/** 
	* @return JSON in String form after transformations
	*/
	@Override
	public String getData() {
		return jsonString.getData();
	}
}
