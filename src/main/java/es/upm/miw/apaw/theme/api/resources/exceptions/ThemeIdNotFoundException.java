package es.upm.miw.apaw.theme.api.resources.exceptions;

public class ThemeIdNotFoundException extends Exception {
    private static final long serialVersionUID = -3893110892899234744L;

    public static final String DESCRIPTION = "El id del tema no existe";

    public ThemeIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public ThemeIdNotFoundException() {
        this("");
    }
}
