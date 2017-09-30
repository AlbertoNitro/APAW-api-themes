package es.upm.miw.apaw.theme.api.resources.exceptions;

public class ThemeFieldInvalidException extends Exception {
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "Nombre del tema no encontrado";

    public ThemeFieldInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public ThemeFieldInvalidException() {
        this("");
    }

}
