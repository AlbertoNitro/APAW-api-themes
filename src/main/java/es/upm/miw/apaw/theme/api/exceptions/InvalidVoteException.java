package es.upm.miw.apaw.theme.api.exceptions;

public class InvalidVoteException extends Exception {
	private static final long serialVersionUID = -5173361541880534566L;

	public static final String DESCRIPTION = "El valor del voto debe estar entre 0 y 10";

	public InvalidVoteException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidVoteException() {
		this("");
	}

}
