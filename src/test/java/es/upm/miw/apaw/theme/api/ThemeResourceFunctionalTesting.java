package es.upm.miw.apaw.theme.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.daos.memory.DaoFactoryMemory;
import es.upm.miw.apaw.theme.http.HttpException;
import es.upm.miw.apaw.theme.http.HttpMethod;
import es.upm.miw.apaw.theme.http.HttpRequest;
import es.upm.miw.apaw.theme.http.HttpService;

public class ThemeResourceFunctionalTesting {

    private HttpRequest request;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoFactoryMemory());
        request = new HttpRequest();
    }

    @Test
    public void CreateThemeTest() {
        request.setMethod(HttpMethod.POST);
        request.setPath("themes");
        request.setBody("uno");
        new HttpService().httpRequest(request);
    }

    @Test
    public void CreateThemeNameEmptyTest() {
        exception.expect(HttpException.class);
        request.setMethod(HttpMethod.POST);
        request.setPath("themes");
        request.setBody("");
        new HttpService().httpRequest(request);
    }

    @Test
    public void CreateWithoutThemeNameTest() {
        exception.expect(HttpException.class);
        request.setMethod(HttpMethod.POST);
        request.setPath("themes");
        new HttpService().httpRequest(request);
    }

    @Test
    public void themeListTest() {
        request.setMethod(HttpMethod.POST);
        request.setPath("themes");
        request.setBody("uno");
        new HttpService().httpRequest(request);
        request.setMethod(HttpMethod.GET);
        request.setBody("");
        request.setPath("themes");
        assertEquals("[{\"id\":1,\"name\":\"uno\"}]", new HttpService().httpRequest(request).getBody());
    }

    @Test
    public void themeListEmptyTest() {
        request.setMethod(HttpMethod.GET);
        request.setBody("");
        request.setPath("themes");
        new HttpService().httpRequest(request);
        assertEquals("[]", new HttpService().httpRequest(request).getBody());
    }

    @Test
    public void themeOverageTest() {
        request.setMethod(HttpMethod.POST);
        request.setPath("themes");
        request.setBody("uno");
        new HttpService().httpRequest(request);
        request.setPath("votes");
        request.setBody("1:4");
        new HttpService().httpRequest(request);
        request.setBody("1:5");
        new HttpService().httpRequest(request);
        request.setMethod(HttpMethod.GET);
        request.setPath("themes/1/overage");
        assertEquals("4.5", new HttpService().httpRequest(request).getBody());
    }

    @Test
    public void themeOverageWithoutVoteTest() {
        request.setMethod(HttpMethod.POST);
        request.setPath("themes");
        request.setBody("uno");
        new HttpService().httpRequest(request);
        request.setMethod(HttpMethod.GET);
        request.setPath("themes/1/overage");
        assertEquals("NaN", new HttpService().httpRequest(request).getBody());
    }

    @Test
    public void themeOverageThemeIdNotFoundTest() {
        exception.expect(HttpException.class);
        request.setMethod(HttpMethod.GET);
        request.setPath("themes/1/overage");
        new HttpService().httpRequest(request);
    }

}
