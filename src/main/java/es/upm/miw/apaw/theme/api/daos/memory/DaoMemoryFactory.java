package es.upm.miw.apaw.theme.api.daos.memory;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.daos.ThemeDao;
import es.upm.miw.apaw.theme.api.daos.VoteDao;

public class DaoMemoryFactory extends DaoFactory {

    private ThemeDao themeDao;

    private VoteDao voteDao;

    @Override
    public ThemeDao getThemeDao() {
        if (themeDao == null) {
            themeDao = new ThemeDaoMemory();
        }
        return themeDao;
    }

    @Override
    public VoteDao getVoteDao() {
        if (voteDao == null) {
            voteDao = new VoteDaoMemory();
        }
        return voteDao;
    }

}
