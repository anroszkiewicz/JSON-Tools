package pl.put.poznan.jsontools.decorators;

public class Exclude extends JSONDecorator {
	
	private String[] filters;

	public Exclude(JSONString toBeDecorated, String[] excludeParams) {
		super(toBeDecorated);
		this.filters = excludeParams;
	}

	@Override
	public String getData() {
		// implement exclude here
		return super.getData();
	}
}
