package es.upm.miw.apaw.theme.http;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpService {

    public HttpResponse httpRequest(HttpRequest request) {
        Logger logger = LogManager.getLogger(this.getClass().getName());
        logger.info(request.toString());
        HttpResponse response = new Server().request(request);
        logger.info(response);
        logger.info("---------------------------------------ooo----------------------------------------");
        if (response.getStatus().isError()) {
            throw new HttpException(response.getStatus().toString());
        }
        return response;
    }
}
