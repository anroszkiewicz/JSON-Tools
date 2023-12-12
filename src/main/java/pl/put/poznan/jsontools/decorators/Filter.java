package pl.put.poznan.jsontools.decorators;

public class Filter extends JSONDecorator {
	
	private String[] filters;

	public Filter(JSONString toBeDecorated, String[] filterParams) {
		super(toBeDecorated);
		this.filters = filterParams;
	}

	@Override
	public String getData() {
		// implement filter here
		return super.getData();
	}
}
