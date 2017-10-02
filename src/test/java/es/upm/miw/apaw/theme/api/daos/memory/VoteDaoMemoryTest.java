package es.upm.miw.apaw.theme.api.daos.memory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.entities.Theme;
import es.upm.miw.apaw.theme.api.entities.Vote;

public class VoteDaoMemoryTest {

    private Theme theme;

    private Vote vote;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        theme = new Theme("tema1");
        vote = new Vote(3, theme);
        DaoFactory.getFactory().getVoteDao().create(vote);

    }

    @Test
    public void testFindValueByThemeId() {
        assertEquals(1, DaoFactory.getFactory().getVoteDao().findValueByThemeId(theme.getId()).size());
        assertEquals(3, DaoFactory.getFactory().getVoteDao().findValueByThemeId(theme.getId()).get(0).intValue());
    }

    @Test
    public void testCreatedRead() {
        assertEquals(3, DaoFactory.getFactory().getVoteDao().read(vote.getId()).getValue());
    }

    @Test
    public void testUpdate() {
        vote.setValue(2);
        DaoFactory.getFactory().getVoteDao().update(vote);
        assertEquals(2, DaoFactory.getFactory().getVoteDao().read(vote.getId()).getValue());
    }

    @Test
    public void testDeleteById() {
        DaoFactory.getFactory().getVoteDao().deleteById(vote.getId());
        assertNull(DaoFactory.getFactory().getVoteDao().read(vote.getId()));
    }

    @Test
    public void testFindAll() {
        DaoFactory.getFactory().getVoteDao().create(new Vote(4, theme));
        assertEquals(2, DaoFactory.getFactory().getVoteDao().findAll().size());
    }

}
