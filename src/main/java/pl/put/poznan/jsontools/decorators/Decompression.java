package pl.put.poznan.jsontools.decorators;

public class Decompression extends JSONDecorator {

	public Decompression(JSONString toBeDecorated) {
		super(new Minification(toBeDecorated));
	}

	@Override
	public String getData() {

		String data = super.getData();
		String deco = new String(); // string bedacy wynikiem dekompresji
		int tabs = 0; // zliczanie wciec
		boolean first_simple_sign = false; // sprawdzanie czy normalny znak pojawil sie pierwszy raz zeby dzialaly wciecia

		for (int i = 0; i < data.length(); i++) {
			char sign = data.charAt(i); // obecnie rozpatrywany znak

			if (sign == '[' || sign == '{') {
				for (int j = 0; j < tabs; j++) // wciecia
					deco = deco.concat("  ");
				deco = deco.concat(Character.toString(sign)); // dodaje znak na koniec deco
				deco = deco.concat(Character.toString('\n')); // dodaje enter na koniec deco
				tabs = tabs + 1; // regulacja wciec
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
				if (sign == ':') // spacja po dwokropku
					deco = deco.concat(Character.toString(' '));
				first_simple_sign = false;
			}
		}

		return deco;
	}
}
