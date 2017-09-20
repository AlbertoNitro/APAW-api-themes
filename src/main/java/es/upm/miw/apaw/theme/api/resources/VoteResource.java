package es.upm.miw.apaw.theme.api.resources;

import es.upm.miw.apaw.theme.api.controllers.VoteController;
import es.upm.miw.apaw.theme.api.dtos.VoteListDto;
import es.upm.miw.apaw.theme.api.exceptions.VoteInvalidException;
import es.upm.miw.apaw.theme.api.exceptions.ThemeIdNotFoundException;

public class VoteResource {

	// POST **/votes   body="themeId:vote"
	public void createVote(int themeId, int vote) throws VoteInvalidException, ThemeIdNotFoundException {
		if (vote < 0 || vote > 10) {
			throw new VoteInvalidException("" + vote);
		}
		if (!new VoteController().createVote(themeId, vote)) {
			throw new ThemeIdNotFoundException("" + themeId);
		}
	}

	// GET **/votes
	public VoteListDto voteList() {
		return new VoteController().voteList();
	}

}
