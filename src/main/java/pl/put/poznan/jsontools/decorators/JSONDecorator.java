package pl.put.poznan.jsontools.decorators;

public class JSONDecorator implements JSONString {
	
	private JSONString jsonString;

	public JSONDecorator(JSONString toBeDecorated) {
		this.jsonString = toBeDecorated;
	}

	@Override
	public String getData() {
		return jsonString.getData();
	}
}
