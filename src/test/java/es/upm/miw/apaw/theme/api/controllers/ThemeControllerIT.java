package es.upm.miw.apaw.theme.api.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.daos.memory.DaoMemoryFactory;

public class ThemeControllerIT {

    private ThemeController themeController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        themeController = new ThemeController();
        themeController.createTheme("tema1");
    }

    @Test
    public void testReadTheme() {
       assertEquals("tema1",themeController.readTheme(1).get().getName());
    }
    
    @Test
    public void testReadThemeNonExistId() {
       assertFalse(themeController.readTheme(2).isPresent());
    }
    
    @Test
    public void testCreateAndThemeList() {
        themeController.createTheme("tema2");
        assertEquals(2, themeController.themeList().size());
        assertEquals("tema1", themeController.themeList().get(0).getName());
    }

    @Test
    public void testThemeOverage() {
        new VoteController().createVote(1, 2);
        new VoteController().createVote(1, 3);
        assertEquals(2.5, themeController.themeOverage(1).get().doubleValue(), 10e-2);
    }

    @Test
    public void testThemeOverageIfEmpty() {
        assertEquals(Double.NaN, themeController.themeOverage(1).get().doubleValue(), 10e-2);
    }

    @Test
    public void testThemeVote() {
        new VoteController().createVote(1, 2);
        new VoteController().createVote(1, 3);
        assertEquals("tema1", themeController.themeVotes(1).get().getThemeDto().getName());
        assertArrayEquals(new Integer[] {2, 3}, themeController.themeVotes(1).get().getVoteList().toArray(new Integer[0]));
    }

}
