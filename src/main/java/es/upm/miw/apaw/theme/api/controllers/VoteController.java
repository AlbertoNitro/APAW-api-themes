package es.upm.miw.apaw.theme.api.controllers;

import java.util.List;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.dtos.VoteListDto;
import es.upm.miw.apaw.theme.api.dtos.VoteDto;
import es.upm.miw.apaw.theme.api.entities.Theme;
import es.upm.miw.apaw.theme.api.entities.Vote;

public class VoteController {

	public boolean createVote(int themeId, int vote) {
		Theme theme = DaoFactory.getFactory().getThemeDao().read(themeId);
		if (theme != null) {
			DaoFactory.getFactory().getVoteDao().create(new Vote(vote, theme));
			return true;
		} else {
			return false;
		}
	}

	public VoteListDto voteList() {
		List<Vote> votes = DaoFactory.getFactory().getVoteDao().findAll();
		VoteListDto voteListWrapper = new VoteListDto();
		for (Vote vote : votes) {
			voteListWrapper.addVoteWrapper(new VoteDto(vote.getTheme().getName(),vote.getValue()));
		}
		return voteListWrapper;
	}

}
