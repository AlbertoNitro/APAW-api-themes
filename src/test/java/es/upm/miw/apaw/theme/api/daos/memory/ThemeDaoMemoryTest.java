package es.upm.miw.apaw.theme.api.daos.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.entities.Theme;

public class ThemeDaoMemoryTest {

    private Theme theme;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        theme = new Theme("tema1");
        DaoFactory.getFactory().getThemeDao().create(theme);
    }

    @Test
    public void testReadTheme() {
        assertEquals("tema1", DaoFactory.getFactory().getThemeDao().read(1).getName());
    }
    
    @Test
    public void testReadNonExistId() {
        assertNull(DaoFactory.getFactory().getThemeDao().read(2));
    }

}
