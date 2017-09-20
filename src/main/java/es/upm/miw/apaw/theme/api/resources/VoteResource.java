package es.upm.miw.apaw.theme.api.resources;

import java.util.List;

import es.upm.miw.apaw.theme.api.controllers.VoteController;
import es.upm.miw.apaw.theme.api.dtos.VoteDto;
import es.upm.miw.apaw.theme.api.resources.exceptions.ThemeIdNotFoundException;
import es.upm.miw.apaw.theme.api.resources.exceptions.VoteInvalidException;

public class VoteResource {

    // POST **/votes body="themeId:vote"
    public void createVote(int themeId, int vote) throws VoteInvalidException, ThemeIdNotFoundException {
        if (vote < 0 || vote > 10) {
            throw new VoteInvalidException("" + vote);
        }
        if (!new VoteController().createVote(themeId, vote)) {
            throw new ThemeIdNotFoundException("" + themeId);
        }
    }

    // GET **/votes
    public List<VoteDto> voteList() {
        return new VoteController().voteList();
    }

}
