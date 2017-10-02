package es.upm.miw.apaw.theme;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.theme.api.resources.ThemeResource;
import es.upm.miw.apaw.theme.api.resources.VoteResource;
import es.upm.miw.apaw.theme.http.HttpClientService;
import es.upm.miw.apaw.theme.http.HttpException;
import es.upm.miw.apaw.theme.http.HttpMethod;
import es.upm.miw.apaw.theme.http.HttpRequest;
import es.upm.miw.apaw.theme.http.HttpRequestBuilder;

public class ThemeResourceFunctionalTesting {

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private void createTheme() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ThemeResource.THEMES).body("uno").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateTheme() {
        this.createTheme();
    }

    @Test(expected = HttpException.class)
    public void testCreateThemeNameEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ThemeResource.THEMES).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateWithoutThemeName() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ThemeResource.THEMES).build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testReadTheme() {
        this.createTheme();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).path(ThemeResource.ID)
                .expandPath("1").build();
        assertEquals("{\"id\":1,\"name\":\"uno\"}", new HttpClientService().httpRequest(request).getBody());

    }

    @Test
    public void testThemeList() {
        this.createTheme();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).build();
        assertEquals("[{\"id\":1,\"name\":\"uno\"}]", new HttpClientService().httpRequest(request).getBody());
    }

    @Test
    public void testThemeListEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).build();
        assertEquals("[]", new HttpClientService().httpRequest(request).getBody());
    }

    @Test
    public void testThemeOverage() {
        this.createTheme();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(VoteResource.VOTES).body("1:4").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(VoteResource.VOTES).body("1:5").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).path(ThemeResource.ID_OVERAGE).expandPath("1")
                .build();
        assertEquals("4.5", new HttpClientService().httpRequest(request).getBody());
    }

    @Test
    public void testThemeOverageWithoutVote() {
        this.createTheme();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).path(ThemeResource.ID_OVERAGE)
                .expandPath("1").build();
        assertEquals("NaN", new HttpClientService().httpRequest(request).getBody());
    }

    @Test(expected = HttpException.class)
    public void testThemeOverageThemeIdNotFound() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).path(ThemeResource.ID_OVERAGE)
                .expandPath("1").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testThemeVotes() {
        this.createTheme();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(VoteResource.VOTES).body("1:4").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(VoteResource.VOTES).body("1:5").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).path(ThemeResource.ID_VOTES).expandPath("1")
                .build();
        assertEquals("{{\"id\":1,\"name\":\"uno\"},[4, 5]}", new HttpClientService().httpRequest(request).getBody());
    }

    @Test(expected = HttpException.class)
    public void testThemeVoteThemeIdNotFound() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).path(ThemeResource.ID_OVERAGE)
                .expandPath("1").build();
        new HttpClientService().httpRequest(request);
    }

}
