package es.upm.miw.apaw.theme.api;

import es.upm.miw.apaw.theme.api.resources.ThemeResource;
import es.upm.miw.apaw.theme.api.resources.VoteResource;
import es.upm.miw.apaw.theme.api.resources.exceptions.RequestInvalidException;
import es.upm.miw.apaw.theme.http.HttpRequest;
import es.upm.miw.apaw.theme.http.HttpResponse;
import es.upm.miw.apaw.theme.http.HttpStatus;

public class Dispatcher {

    private ThemeResource themeResource = new ThemeResource();

    private VoteResource voteResource = new VoteResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(ThemeResource.THEMES)) {
                response.setBody(themeResource.themeList().toString());
            } else if (request.isEqualsPath(ThemeResource.THEMES + ThemeResource.ID)) {
                response.setBody(themeResource.readTheme(Integer.valueOf(request.paths()[1])).toString());
            } else if (request.isEqualsPath(ThemeResource.THEMES + ThemeResource.ID_OVERAGE)) {
                response.setBody(themeResource.themeOverage(Integer.valueOf(request.paths()[1])).toString());
            } else if (request.isEqualsPath(ThemeResource.THEMES + ThemeResource.ID_VOTES)) {
                response.setBody(themeResource.themeVoteList(Integer.valueOf(request.paths()[1])).toString());
            } else if (request.isEqualsPath(VoteResource.VOTES)) {
                response.setBody(voteResource.voteList().toString());
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(ThemeResource.THEMES)) {
                themeResource.createTheme(request.getBody());
                response.setStatus(HttpStatus.CREATED);
            } else if (request.isEqualsPath(VoteResource.VOTES)) {
                String themeId = request.getBody().split(":")[0]; // body="themeId:vote"
                String vote = request.getBody().split(":")[1];
                voteResource.createVote(Integer.valueOf(themeId), Integer.valueOf(vote));
                response.setStatus(HttpStatus.CREATED);
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
    }

}
