package es.upm.miw.apaw.theme.client;

import es.upm.miw.apaw.theme.api.Dispatcher;
import es.upm.miw.apaw.theme.http.HttpRequest;
import es.upm.miw.apaw.theme.http.HttpResponse;

public class Server {
    private Dispatcher dispatcher = new Dispatcher();

    public HttpResponse submit(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        switch (request.getMethod()) {
        case POST:
            dispatcher.doPost(request, response);
            break;
        case GET:
            dispatcher.doGet(request, response);
            break;
        case PUT:
            dispatcher.doPut(request, response);
            break;
        case PATCH:
            dispatcher.doPatch(request, response);
            break;
        case DELETE:
            dispatcher.doDelete(request, response);
            break;
        default:
        }
        return response;
    }

}
