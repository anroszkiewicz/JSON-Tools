package pl.put.poznan.jsontools.decorators;

public class Minification extends JSONDecorator {

	public Minification(JSONString toBeDecorated) {
		super(toBeDecorated);
	}

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
