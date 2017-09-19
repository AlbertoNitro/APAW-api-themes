package es.upm.miw.apaw.theme.api.resources;

import es.upm.miw.apaw.theme.api.controllers.VoteController;
import es.upm.miw.apaw.theme.api.dtos.VoteListDto;
import es.upm.miw.apaw.theme.api.exceptions.InvalidVoteException;
import es.upm.miw.apaw.theme.api.exceptions.NotFoundThemeIdException;

public class VoteResource {

	// POST **/votes   body="themeId:vote"
	public void createVote(int themeId, int vote) throws InvalidVoteException, NotFoundThemeIdException {
		if (vote < 0 || vote > 10) {
			throw new InvalidVoteException("" + vote);
		}
		if (!new VoteController().createVote(themeId, vote)) {
			throw new NotFoundThemeIdException("" + themeId);
		}
	}

	// GET **/votes
	public VoteListDto voteList() {
		return new VoteController().voteList();
	}

}
