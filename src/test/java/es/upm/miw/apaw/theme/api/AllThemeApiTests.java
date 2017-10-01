package es.upm.miw.apaw.theme.api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.upm.miw.apaw.theme.api.controllers.AllThemeApiControllersTests;
import es.upm.miw.apaw.theme.api.daos.memory.AllThemeApiDaosMemoryTests;
import es.upm.miw.apaw.theme.api.entities.AllThemeApiEntitiesTests;

@RunWith(Suite.class)
@SuiteClasses ({
    AllThemeApiControllersTests.class,
    AllThemeApiEntitiesTests.class,
    AllThemeApiDaosMemoryTests.class
})
public class AllThemeApiTests {

}
