package es.upm.miw.apaw.theme.api.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
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

    public List<VoteDto> voteList() {
        List<VoteDto> voteDtoList = new ArrayList<>();
        List<Vote> votes = DaoFactory.getFactory().getVoteDao().findAll();
        for (Vote vote : votes) {
            voteDtoList.add(new VoteDto(vote));
        }
        return voteDtoList;
    }

}
