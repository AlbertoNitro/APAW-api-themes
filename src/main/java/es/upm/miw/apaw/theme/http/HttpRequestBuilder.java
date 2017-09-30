package es.upm.miw.apaw.theme.http;

public class HttpRequestBuilder {

    private HttpRequest httpRequest;

    public HttpRequestBuilder() {
        httpRequest = new HttpRequest();
    }

    public HttpRequestBuilder method(HttpMethod method) {
        httpRequest.setMethod(method);
        return this;
    }

    public HttpRequestBuilder path(String path) {
        if (!httpRequest.getPath().isEmpty()) {
            path = "/" + path;
        }
        httpRequest.setPath(httpRequest.getPath() + path);
        return this;
    }

    public HttpRequestBuilder expandPath(String value) {
        httpRequest.expandPath(value);
        return this;
    }

    public HttpRequestBuilder param(String key, String value) {
        httpRequest.addQueryParam(key, value);
        return this;
    }
    
    public HttpRequestBuilder headerParam(String key, String value) {
        httpRequest.addHeaderParam(key, value);
        return this;
    }
    
    public HttpRequestBuilder body(String body) {
        httpRequest.setBody(body);
        return this;
    }
    
    public HttpRequest build() {
        return httpRequest;
    }


}
