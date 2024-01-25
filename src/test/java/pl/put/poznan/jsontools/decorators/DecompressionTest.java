package pl.put.poznan.jsontools.decorators;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DecompressionTest {
    

    @Test
	void testGetDataSimple(){
		JSONString string = mock(JSONString.class);
		when(string.getData()).thenReturn(new String("{\"name\": \"Darth\"}"));

		Decompression decompression = new Decompression(string);
		String result = decompression.getData();
		assertEquals(new String("{\n  \"name\": \"Darth\"\n}"), result);
	}

    @Test
	void testGetDataList(){
		JSONString string = mock(JSONString.class);
		when(string.getData()).thenReturn(new String("[  { \"nazwa\" : \"ananas\" }, {\"nazwa\":  \"piernik\"}]"));

		Decompression decompression = new Decompression(string);
		String result = decompression.getData();
		assertEquals(new String("[\n  {\n    \"nazwa\": \"ananas\"\n  },\n  {\n    \"nazwa\": \"piernik\"\n  }\n]\n"), result);
	}

    @Test
	void testGetDataNewLines(){
		JSONString string = mock(JSONString.class);
		when(string.getData()).thenReturn(new String("\n{\n\n\"name\" \n : \n\n\n\n\n\"Darth\"\n\n}\n"));

		Decompression decompression = new Decompression(string);
		String result = decompression.getData();
		assertEquals(new String("{\n  \"name\": \"Darth\"\n}"), result);
	}

    @Test
	void testGetDataPrettyWithTabs(){
		JSONString string = mock(JSONString.class);
		when(string.getData()).thenReturn(new String("{\n"
													+ "\t{\n"
													+ "\t\t\"name\": \"Adam\",\n"
													+ "\t\t\"age\": \"20\"\n"
													+ "\t},\n"
													+ "\t[\n"
													+ "\t\t{\"name\": \"Bartek\", \"age\": \"21\"},\n"
													+ "\t\t{\"name\": \"Czarek\", \"age\": \"22\"},\n"
													+ "\t\t{\"name\": \"Damian\", \"age\": \"23\"}\n"
													+ "\t]\n"
													+ "}\n"
													));

        Decompression decompression = new Decompression(string);
        String result = decompression.getData();
		assertEquals(new String("{\n" + "  {\n" + "    \"name\": \"Adam\",\n" + "    \"age\": \"20\"\n" + "  },\n" + "  [\n" + "    {\n      \"name\": \"Bartek\",\n      \"age\": \"21\"\n    },\n" + "    {\n      \"name\": \"Czarek\",\n      \"age\": \"22\"\n    },\n" + "    {\n      \"name\": \"Damian\",\n      \"age\": \"23\"\n    }\n" + "  ]\n" + "}\n"), result);
	}

    @Test
	void testGetDataPrettyWithSpaces(){
		JSONString string = mock(JSONString.class);
		when(string.getData()).thenReturn(new String("{\n"
													+ " {\n"
													+ "  \"name\": \"Adam\",\n"
													+ "  \"age\": \"20\"\n"
													+ " },\n"
													+ " [\n"
													+ "  {\"name\": \"Bartek\", \"age\": \"21\"},\n"
													+ "  {\"name\": \"Czarek\", \"age\": \"22\"},\n"
													+ "  {\"name\": \"Damian\", \"age\": \"23\"}\n"
													+ " ]\n"
													+ "}\n"
													));

        Decompression decompression = new Decompression(string);
        String result = decompression.getData();
		assertEquals(new String("{\n" + "  {\n" + "    \"name\": \"Adam\",\n" + "    \"age\": \"20\"\n" + "  },\n" + "  [\n" + "    {\n      \"name\": \"Bartek\",\n      \"age\": \"21\"\n    },\n" + "    {\n      \"name\": \"Czarek\",\n      \"age\": \"22\"\n    },\n" + "    {\n      \"name\": \"Damian\",\n      \"age\": \"23\"\n    }\n" + "  ]\n" + "}\n"), result);
	}


}
