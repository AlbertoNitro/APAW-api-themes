package es.upm.miw.apaw.theme;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.daos.memory.DaoFactoryMemory;
import es.upm.miw.apaw.theme.http.HttpClientService;
import es.upm.miw.apaw.theme.http.HttpException;
import es.upm.miw.apaw.theme.http.HttpMethod;
import es.upm.miw.apaw.theme.http.HttpRequest;

public class VoteResourceFunctionalTesting {

    private HttpRequest request;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoFactoryMemory());
        request = new HttpRequest();
    }

    public void createVotes() {
        request.setMethod(HttpMethod.POST);
        request.setPath("themes");
        request.setBody("uno");
        new HttpClientService().httpRequest(request);
        request.setPath("votes");
        request.setBody("1:4");
        new HttpClientService().httpRequest(request);
        request.setBody("1:5");
        new HttpClientService().httpRequest(request);        
    }
    
    @Test
    public void testCreateVote() {
        this.createVotes();
    }
    
    @Test
    public void testCreateVoteVoteInvalidException() {
        exception.expect(HttpException.class);
        request.setMethod(HttpMethod.POST);
        request.setPath("themes");
        request.setBody("uno");
        new HttpClientService().httpRequest(request);
        request.setPath("votes");
        request.setBody("1:-1");
        new HttpClientService().httpRequest(request);
        request.setBody("1:x");
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testCreateThemeIdNotFoundException() {
        exception.expect(HttpException.class);
        request.setMethod(HttpMethod.POST);
        request.setPath("votes");
        request.setBody("1:1");
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testVoteList() {
        this.createVotes();
        request.setMethod(HttpMethod.GET);
        request.setBody("");
        new HttpClientService().httpRequest(request);
        assertEquals("[{\"themeName\":\"uno,\"voteValue\":4}, {\"themeName\":\"uno,\"voteValue\":5}]", new HttpClientService().httpRequest(request).getBody());
    }

}
