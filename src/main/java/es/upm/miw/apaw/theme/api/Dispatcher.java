package es.upm.miw.apaw.theme.api;

import es.upm.miw.apaw.theme.api.resources.ThemeResource;
import es.upm.miw.apaw.theme.api.resources.VoteResource;
import es.upm.miw.apaw.theme.api.resources.exceptions.RequestInvalidException;
import es.upm.miw.apaw.theme.api.resources.exceptions.ThemeFieldInvalidException;
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
        if (ThemeResource.THEMES.equals(request.getPath())) {
            response.setBody(themeResource.themeList().toString());
        } else if (ThemeResource.THEMES.equals(request.paths()[0]) && ThemeResource.THEMES_ID_ID_OVERAGE.equals(request.paths()[2])) {
            try {
                response.setBody(themeResource.themeOverage(Integer.valueOf(request.paths()[1])).toString());
            } catch (Exception e) {
                responseError(response, e);
            }
        } else if (ThemeResource.THEMES.equals(request.paths()[0]) && ThemeResource.THEMES_ID_ID_VOTE.equals(request.paths()[2])) {
            try {
                response.setBody(themeResource.themeVote(Integer.valueOf(request.paths()[1])).toString());
            } catch (Exception e) {
                responseError(response, e);
            }
        } else if (VoteResource.VOTES.equals(request.getPath())) {
            response.setBody(voteResource.voteList().toString());
        } else {
            responseError(response, new RequestInvalidException(request.getPath()));
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        switch (request.getPath()) {
        case ThemeResource.THEMES:
            // Injectar parámetros...
            try {
                themeResource.createTheme(request.getBody());
                response.setStatus(HttpStatus.CREATED);
            } catch (ThemeFieldInvalidException e) {
                this.responseError(response, e);
            }
            break;
        // body="themeId:vote"
        case VoteResource.VOTES:
            String themeId = request.getBody().split(":")[0];
            String vote = request.getBody().split(":")[1];
            try {
                voteResource.createVote(Integer.valueOf(themeId), Integer.valueOf(vote));
                response.setStatus(HttpStatus.CREATED);
            } catch (Exception e) {
                responseError(response, e);
            }
            break;
        default:
            responseError(response, new RequestInvalidException(request.getPath()));
            break;
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
