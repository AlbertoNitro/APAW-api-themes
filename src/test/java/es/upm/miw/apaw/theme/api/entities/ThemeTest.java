package es.upm.miw.apaw.theme.api.entities;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ThemeTest {

    @Test
    public void testGetDate() {
        assertNotNull(new Theme("tema1").getDate());
        fail();
    }

}
