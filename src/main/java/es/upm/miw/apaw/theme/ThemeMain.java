package es.upm.miw.apaw.theme;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.daos.memory.DaoFactoryMemory;
import es.upm.miw.apaw.theme.http.HttpMethod;
import es.upm.miw.apaw.theme.http.HttpRequest;
import es.upm.miw.apaw.theme.http.HttpResponse;
import es.upm.miw.apaw.theme.http.Server;

public class ThemeMain {

    private Server server = new Server();

    private HttpRequest request = new HttpRequest();

    public void help() {
        Logger logger = LogManager.getLogger(this.getClass().getName());
        logger.info("GET **/themes");
        logger.info("POST **/themes   body=\"themeName\"");
        logger.info("GET **/themes/{id}/overage");
        logger.info("POST **/votes   body=\"themeId:vote\"");
        logger.info("GET **/votes");
        logger.info("---------------------------------------ooo----------------------------------------");
    }

    public void demo() {
        request.setMethod(HttpMethod.POST);
        request.setPath("themes");
        request.setBody("uno");
        this.request();
        request.setBody("dos");
        this.request();
        request.setPath("votes");
        request.setBody("1:4");
        this.request();
        request.setBody("1:5");
        this.request();
        request.setBody("2:5");
        this.request();
        request.setBody("2:6");
        this.request();
        request.setMethod(HttpMethod.GET);
        request.setPath("votes");
        request.clearQueryParams();
        request.setBody("");
        this.request();
        request.setPath("themes");
        this.request();
        request.setPath("themes/1/overage");
        this.request();
        request.setPath("themes/2/overage");
        this.request();
        // Exceptions
        request.setPath("noValid");
        this.request();
        request.setPath("themes/x/overage");
        this.request();
        request.setPath("themes/99/overage");
        this.request();
        request.setMethod(HttpMethod.POST);
        request.setPath("votes");
        request.setBody("99:4");
        this.request();
    }
    
    public void themeList() {
        request.setMethod(HttpMethod.POST);
        request.setPath("themes");
        request.setBody("uno");
        this.request();
        request.setBody("dos");
        this.request();
        request.setMethod(HttpMethod.GET);
        request.setBody("");        
        request.setPath("themes");
        this.request();
    }

    public void overage() {
        request.setMethod(HttpMethod.POST);
        request.setPath("themes");
        request.setBody("uno");
        this.request();
        request.setPath("votes");
        request.setBody("1:4");
        this.request();
        request.setBody("1:5");
        this.request();
        request.setMethod(HttpMethod.GET);
        request.setPath("themes/1/overage");
        this.request();
    }


    public void request() {
        Logger logger = LogManager.getLogger(this.getClass().getName());
        logger.info(request.toString());
        HttpResponse response = server.request(request);
        logger.info(response);
        logger.info("---------------------------------------ooo----------------------------------------");
    }

    public static void main(String[] args) {
        DaoFactory.setFactory(new DaoFactoryMemory());
        ThemeMain main = new ThemeMain();
        main.help();
        //main.demo(); 
        //main.themeList();
        main.overage();
    }
}
