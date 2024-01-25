package pl.put.poznan.jsontools.decorators;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class MinificationTest {

	@Test
	void testGetDataSimple(){
		JSONString string = mock(JSONString.class);
		when(string.getData()).thenReturn(new String("{\"name\": \"Darth\"}"));

		Minification minification = new Minification(string);
		String result = minification.getData();
		verify(string, times(1)).getData();
		assertEquals(new String("{\"name\":\"Darth\"}"), result);
	}

	@Test
	void testGetDataList(){
		JSONString string = mock(JSONString.class);
		when(string.getData()).thenReturn(new String("[  { \"nazwa\" : \"ananas\" }, \n{\"nazwa\": \n \"piernik\"\n}\n]"));

		Minification minification = new Minification(string);
		String result = minification.getData();
		verify(string, times(1)).getData();
		assertEquals(new String("[{\"nazwa\":\"ananas\"},{\"nazwa\":\"piernik\"}]"), result);
	}

	@Test
	void testGetDataNewLines(){
		JSONString string = mock(JSONString.class);
		when(string.getData()).thenReturn(new String("\n{\n\n\"name\" \n : \n\n\n\n\n\"Darth\"\n\n}\n"));

		Minification minification = new Minification(string);
		String result = minification.getData();
		verify(string, times(1)).getData();
		assertEquals(new String("{\"name\":\"Darth\"}"), result);
	}

	@Test
	void testGetDataPrettyWithTabs(){
		JSONString string = mock(JSONString.class);
		when(string.getData()).thenReturn(new String("{\n"
					+ "\t\"menu\": {\n"
					+ "\t\t\"id\": \"file\",\n"
					+ "\t\t\"value\": \"File\",\n"
					+ "\t\t\"popup\": {\n"
					+ "\t\t\t\"menuitem\": [\n"
					+ "\t\t\t\t{\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n"
					+ "\t\t\t\t{\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n"
					+ "\t\t\t\t{\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n"
					+ "\t\t\t]\n"
					+ "\t\t}\n"
					+ "\t}\n"
					+ "}"
					));

		Minification minification = new Minification(string);
		String result = minification.getData();
		verify(string, times(1)).getData();
		assertEquals(new String("{\"menu\":{\"id\":\"file\",\"value\":\"File\",\"popup\":{\"menuitem\":[{\"value\":\"New\",\"onclick\":\"CreateNewDoc()\"},{\"value\":\"Open\",\"onclick\":\"OpenDoc()\"},{\"value\":\"Close\",\"onclick\":\"CloseDoc()\"}]}}}"), result);
	}

	@Test
	void testGetDataPrettyWithSpaces(){
		JSONString string = mock(JSONString.class);
		when(string.getData()).thenReturn(new String("{\n"
					+ "  \"menu\": {\n"
					+ "    \"id\": \"file\",\n"
					+ "    \"value\": \"File\",\n"
					+ "    \"popup\": {\n"
					+ "      \"menuitem\": [\n"
					+ "        {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n"
					+ "        {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n"
					+ "        {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n"
					+ "      ]\n"
					+ "    }\n"
					+ "  }\n"
					+ "}"
					));

		Minification minification = new Minification(string);
		String result = minification.getData();
		verify(string, times(1)).getData();
		assertEquals(new String("{\"menu\":{\"id\":\"file\",\"value\":\"File\",\"popup\":{\"menuitem\":[{\"value\":\"New\",\"onclick\":\"CreateNewDoc()\"},{\"value\":\"Open\",\"onclick\":\"OpenDoc()\"},{\"value\":\"Close\",\"onclick\":\"CloseDoc()\"}]}}}"), result);
	}
}
