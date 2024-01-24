package pl.put.poznan.jsontools.decorators;
/**
 * Class that performs minification on a given JSON. 
 * Unnecessary characters (spaces and new lines) are removed.
 */
public class Minification extends JSONDecorator {

	/** 
	* Class constructor
	* @param toBeDecorated input JSONString
	*/
	public Minification(JSONString toBeDecorated) {
		super(toBeDecorated);
	}

	/**
	 * Method that performs minification.
	 * Parses the given JSON character by character.
	 * Removes all spaces and new line characters.
	 * @return String containing JSON in minified form
	*/
	@Override
	public String getData() {

		String data = super.getData();
		String mini = new String();
		boolean inQuotes = false;
		boolean escapeMode = false;

		for (int i = 0; i < data.length(); i++) {
			char sign = data.charAt(i);
			if (escapeMode == true) {
				mini = mini.concat(Character.toString(sign));
				escapeMode = false;
			} 
			else if (sign == '"') {
				inQuotes = !inQuotes;
				mini = mini.concat(Character.toString(sign));
			} 
			else if (sign == '\\') {
				escapeMode = true;
				mini = mini.concat(Character.toString(sign));
			} 
			else if (inQuotes == false && (sign == ' ' || sign == '\n' || sign =='\t'))
				continue;
			else
				mini = mini.concat(Character.toString(sign));
		}

		return mini;
	}
}
