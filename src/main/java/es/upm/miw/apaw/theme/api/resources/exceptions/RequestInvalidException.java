package es.upm.miw.apaw.theme.api.resources.exceptions;

public class RequestInvalidException extends Exception {
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "Petición no implementada";

    public RequestInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public RequestInvalidException() {
        this("");
    }

}
