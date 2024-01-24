package pl.put.poznan.jsontools.decorators;
/**
 * Class that performs decompression on a given minified JSON. 
 * Indentation, new lines and spaces are added to ensure readability.
 */
public class Decompression extends JSONDecorator {

	/** 
	* Class constructor
	* @param toBeDecorated input JSONString
	*/
	public Decompression(JSONString toBeDecorated) {
		super(new Minification(toBeDecorated));
	}

	/**
	 * Method that performs decompression.
	 * Parses the given JSON character by character.
	 * Indentation and new lines are added after brackets.
	 * Each field in JSON is displayed in a new line.
	 * Spaces are added after colons.
	 * @return String containing JSON in decompressed form
	*/
	@Override
	public String getData() {

		String data = super.getData();
		String deco = new String(); // result of decompression
		int tabs = 0; // counts indentation
		boolean first_simple_sign = false; // checks if a character appears for the first time

		for (int i = 0; i < data.length(); i++) {
			char sign = data.charAt(i); // current character

			if (sign == '[' || sign == '{') {
				for (int j = 0; j < tabs; j++) // indentation
					deco = deco.concat("  ");
				deco = deco.concat(Character.toString(sign)); // add character at the end
				deco = deco.concat(Character.toString('\n')); // adds enter at the end
				tabs = tabs + 1; // regulate indentation
				first_simple_sign = true;
			} 
			else if (sign == '}') {
				if (i+1 < data.length() && data.charAt(i + 1) == ',') {
					deco = deco.concat(Character.toString('\n'));
					tabs = tabs - 1;
					for (int j = 0; j < tabs; j++)
						deco = deco.concat("  ");
					deco = deco.concat(Character.toString(sign));
				} 
				else if (data.charAt(i - 1) != ']') {
					deco = deco.concat(Character.toString('\n'));
					tabs = tabs - 1;
					for (int j = 0; j < tabs; j++)
						deco = deco.concat("  ");
					deco = deco.concat(Character.toString(sign));
				}
				else {
					for (int j = 0; j < tabs; j++)
						deco = deco.concat("  ");
					deco = deco.concat(Character.toString(sign));
					deco = deco.concat(Character.toString('\n'));
					tabs = tabs - 1;
					first_simple_sign = true;
				}
				if(i+1 < data.length() && data.charAt(i + 1) == ']'){
					deco = deco.concat(Character.toString('\n'));
					tabs = tabs - 1;
				}
			} 
			else if (sign == ']') {
				if (i+1 < data.length() && data.charAt(i + 1) == ',') {
					for (int j = 0; j < tabs; j++)
						deco = deco.concat("  ");
					deco = deco.concat(Character.toString(sign));
				} 
				else {
					for (int j = 0; j < tabs; j++)
						deco = deco.concat("  ");
					deco = deco.concat(Character.toString(sign));
					deco = deco.concat(Character.toString('\n'));
					tabs = tabs - 1;
					first_simple_sign = true;
				}
			} 
			else if (sign == ',') {
				deco = deco.concat(Character.toString(sign));
				deco = deco.concat(Character.toString('\n'));
				first_simple_sign = true;
			} 
			else {
				if (first_simple_sign == true)
					for (int j = 0; j < tabs; j++)
						deco = deco.concat("  ");
				deco = deco.concat(Character.toString(sign));
				if (sign == ':') // space after :
					deco = deco.concat(Character.toString(' '));
				first_simple_sign = false;
			}
		}

		return deco;
	}
}
