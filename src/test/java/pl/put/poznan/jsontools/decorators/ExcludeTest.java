package pl.put.poznan.jsontools.decorators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class ExcludeTest {
    @Test
    void testGetDataSimple(){
        JSONString string = mock(JSONString.class);
        String[] excluStrings={"papryka"};
		when(string.getData()).thenReturn(new String("{\"name\": \"Darth\",\"papryka\": \"zielona\"}"));
        
        Exclude exclude=new Exclude(string, excluStrings);
		String result = exclude.getData();
		assertEquals(new String("{\"name\":\"Darth\"}"), result);
        verify(string,times(1)).getData();
    }

    @Test
    void testGetDataNoExclude(){
        JSONString string = mock(JSONString.class);
        String[] excluStrings={"noexist"};
		when(string.getData()).thenReturn(new String("{\"name\": \"Darth\",\"papryka\": \"zielona\"}"));
        
        Exclude exclude=new Exclude(string, excluStrings);
		String result = exclude.getData();
		assertEquals(new String("{\"name\":\"Darth\",\"papryka\":\"zielona\"}"), result);
    }

    @Test
    void testGetDataArray(){
        JSONString string = mock(JSONString.class);
        String[] excluStrings={"A"};
		when(string.getData()).thenReturn(new String("[{\"name\":\"Darth\",\"A\":\"a\"},{\"name\":\"Ken\",\"A\":\"b\"}]"));
        
        Exclude exclude=new Exclude(string, excluStrings);
		String result = exclude.getData();
		assertEquals(new String("[{\"name\":\"Darth\"},{\"name\":\"Ken\"}]"), result);
    }

    @Test
    void testGetDataNested(){
        JSONString string = mock(JSONString.class);
        String[] excluStrings={"A"};
		when(string.getData()).thenReturn(new String("{\"name\": [{\"A\":\"a\"},{\"A\":\"b\"}]}"));
        
        Exclude exclude=new Exclude(string, excluStrings);
		String result = exclude.getData();
		assertEquals(new String("{\"name\":[{\"A\":\"a\"},{\"A\":\"b\"}]}"), result);
    }

    @Test
    void testGetDataMultiParams(){
        JSONString string = mock(JSONString.class);
        String[] excluStrings={"A","B"};
		when(string.getData()).thenReturn(new String("{\"A\":\"a\",\"B\":\"b\",\"C\":\"c\"}"));
        
        Exclude exclude=new Exclude(string, excluStrings);
		String result = exclude.getData();
		assertEquals(new String("{\"C\":\"c\"}"), result);
    }
}
