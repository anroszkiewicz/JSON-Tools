package pl.put.poznan.jsontools.decorators;

public class SimpleJSONString implements JSONString {
	
	private String jsonString;

	public SimpleJSONString(String data) {
		this.jsonString = data;
	}

	@Override
	public String getData(){
		return jsonString;
	}
}
