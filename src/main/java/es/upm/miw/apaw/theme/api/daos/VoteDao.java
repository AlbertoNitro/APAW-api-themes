package es.upm.miw.apaw.theme.api.daos;

import java.util.List;

import es.upm.miw.apaw.theme.api.entities.Vote;

public interface VoteDao extends GenericDao<Vote, Integer> {

    List<Integer> findValueByThemeId(int themeId);
}
