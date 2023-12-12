package pl.put.poznan.jsontools.logic;

import pl.put.poznan.jsontools.decorators.*;

public class JSONTools {

    private String jsonString;
    private final String[] transforms;
    private final String[] filterParams;
    private final String[] excludeParams;

    public JSONTools(String jsonString, String[] transforms, String[] filterParams, String[] excludeParams){
        this.jsonString = jsonString;
        this.transforms = transforms;
        this.filterParams = filterParams;
        this.excludeParams = excludeParams;
    }

    public String transform() {

		// test wheather text is in valid json format

		JSONString decorator = new SimpleJSONString(jsonString);

		for (String transform: transforms) {
			switch(transform) {
				case "minify":
					decorator = new Minification(decorator);
					break;
				case "decompress":
					decorator = new Decompression(decorator);
					break;
				case "filter":
					decorator = new Filter(decorator, filterParams);
					break;
				case "exclude":
					decorator = new Exclude(decorator, excludeParams);
					break;
			}
		}
        return decorator.getData();
    }
}
