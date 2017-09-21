package es.upm.miw.apaw.theme;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    ThemeResourceFunctionalTesting.class, 
    VoteResourceFunctionalTesting.class
})
public class AllThemeFunctionalTestings {

}
