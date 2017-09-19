package es.upm.miw.apaw.theme.api.exceptions;

public class InvalidThemeFieldException extends Exception {
	private static final long serialVersionUID = -642045799876625537L;
	public static final String DESCRIPTION = "Nombre del tema no encontrado";

	public InvalidThemeFieldException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidThemeFieldException() {
		this("");
	}

}
