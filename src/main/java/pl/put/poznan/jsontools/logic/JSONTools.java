package pl.put.poznan.jsontools.logic;

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

    public String transform(){
        // of course, normally it would do something based on the transforms
        return jsonString.toUpperCase();
    }
}
