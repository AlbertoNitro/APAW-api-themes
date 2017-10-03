package es.upm.miw.apaw.theme.api.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.daos.memory.DaoMemoryFactory;

public class VoteControllerIT {

    private VoteController voteController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        voteController = new VoteController();
    }

    @Test
    public void testCreateVoteAndVoteList() {
        new ThemeController().createTheme("tema1");
        voteController.createVote(1, 1);
        voteController.createVote(1, 4);
        assertEquals(2, voteController.voteList().size());
        assertEquals("tema1", voteController.voteList().get(0).getThemeName());
        assertEquals(1, voteController.voteList().get(0).getVoteValue());
    }

    @Test
    public void testCreateVoteNonExistentId() {
        new ThemeController().createTheme("tema1");
        assertFalse(voteController.createVote(2, 1));
    }

}
