package es.upm.miw.apaw.theme.api.daos.memory;

import java.util.HashMap;

import es.upm.miw.apaw.theme.api.daos.ThemeDao;
import es.upm.miw.apaw.theme.api.entities.Theme;

public class ThemeDaoMemory extends GenericDaoMemory<Theme> implements ThemeDao {

    public ThemeDaoMemory() {
        this.setMap(new HashMap<Integer, Theme>());
    }

    @Override
    protected Integer getId(Theme entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Theme entity, Integer id) {
        entity.setId(id);

    }

}
