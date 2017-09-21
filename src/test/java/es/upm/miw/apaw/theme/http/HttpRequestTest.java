package es.upm.miw.apaw.theme.http;

import static org.junit.Assert.*;

import org.junit.Test;

public class HttpRequestTest {

    @Test
    public void testToString() {
        HttpRequest httpRequest= new HttpRequest("path", HttpMethod.GET);
        httpRequest.addQueryParam("key1", "value1");
        httpRequest.addQueryParam("key2", "value2");
        assertEquals(0,httpRequest.toString().indexOf("GET /path?key1=value1&key2=value2"));
    }

}
