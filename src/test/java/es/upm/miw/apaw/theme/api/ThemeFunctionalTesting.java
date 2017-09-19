package es.upm.miw.apaw.theme.api;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.daos.memory.DaoFactoryMemory;
import es.upm.miw.apaw.theme.http.HttpException;
import es.upm.miw.apaw.theme.http.HttpMethod;
import es.upm.miw.apaw.theme.http.HttpRequest;
import es.upm.miw.apaw.theme.http.HttpService;

public class ThemeFunctionalTesting {

    private HttpRequest request;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoFactoryMemory());
    }

    @Before
    public void before() {
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

}
