package pl.put.poznan.jsontools.decorators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;

public class FilterTest {
    @Test
    void testGetDataSimple(){
        JSONString string = mock(JSONString.class);
        String[] filterParams={"name"};
		when(string.getData()).thenReturn(new String("{\"name\": \"Darth\",\"papryka\": \"zielona\"}"));
        
        Filter filter=new Filter(string, filterParams);
		String result = filter.getData();
		assertEquals(new String("{\"name\":\"Darth\"}"), result);
        verify(string,times(1)).getData();
    }
    
    @Test
    void testGetDataNoResult(){
        JSONString string = mock(JSONString.class);
        String[] filterParams={"noexist"};
		when(string.getData()).thenReturn(new String("{\"name\": \"Darth\",\"papryka\": \"zielona\"}"));
        
        Filter filter=new Filter(string, filterParams);
		String result = filter.getData();
		assertEquals(new String("{}"), result);
    }

    @Test
    void testGetDataArray(){
        JSONString string = mock(JSONString.class);
        String[] filterParams={"name"};
		when(string.getData()).thenReturn(new String("[{\"name\":\"Darth\",\"A\":\"a\"},{\"name\":\"Ken\",\"A\":\"b\"}]"));
        
        Filter filter=new Filter(string, filterParams);
		String result = filter.getData();
		assertEquals(new String("[{\"name\":\"Darth\"},{\"name\":\"Ken\"}]"), result);
    }

    @Test
    void testGetDataNested(){
        JSONString string = mock(JSONString.class);
        String[] filterParams={"A"};
		when(string.getData()).thenReturn(new String("{\"name\": [{\"A\":\"a\"},{\"A\":\"b\"}]}"));
        
        Filter filter=new Filter(string, filterParams);
		String result = filter.getData();
		assertEquals(new String("{}"), result);
    }

    @Test
    void testGetDataMultiParams(){
        JSONString string = mock(JSONString.class);
        String[] filterParams={"A","B"};
		when(string.getData()).thenReturn(new String("{\"A\":\"a\",\"B\":\"b\",\"C\":\"c\"}"));
        
        Filter filter=new Filter(string, filterParams);
		String result = filter.getData();
		assertEquals(new String("{\"A\":\"a\",\"B\":\"b\"}"), result);
    }
}