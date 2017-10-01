package es.upm.miw.apaw.theme.api.resources;

import java.util.List;
import java.util.Optional;

import es.upm.miw.apaw.theme.api.controllers.ThemeController;
import es.upm.miw.apaw.theme.api.dtos.ThemeDto;
import es.upm.miw.apaw.theme.api.dtos.ThemeVotesDto;
import es.upm.miw.apaw.theme.api.resources.exceptions.ThemeFieldInvalidException;
import es.upm.miw.apaw.theme.api.resources.exceptions.ThemeIdNotFoundException;

public class ThemeResource {

    public static final String THEMES = "themes";

    public static final String ID$ = "{id}";

    public static final String ID_OVERAGE$ = ID$ + "/overage";

    public static final String ID_VOTES$ = ID$ + "/votes";

    public List<ThemeDto> themeList() { // GET */themes
        return new ThemeController().themeList();
    }

    public ThemeDto readTheme(int themeId) throws ThemeIdNotFoundException { // GET */themes/{id}
        Optional<ThemeDto> optional = new ThemeController().readTheme(themeId);
        return optional.orElseThrow(() -> new ThemeIdNotFoundException(Integer.toString(themeId)));
    }

    public void createTheme(String themeName) throws ThemeFieldInvalidException { // POST **/themes body="themeName"
        this.validateField(themeName);
        new ThemeController().createTheme(themeName);
    }

    private void validateField(String field) throws ThemeFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new ThemeFieldInvalidException(field);
        }
    }

    public Double themeOverage(int themeId) throws ThemeIdNotFoundException { // GET **/themes/{id}/overage
        Optional<Double> optional = new ThemeController().themeOverage(themeId);
        return optional.orElseThrow(() -> new ThemeIdNotFoundException(Integer.toString(themeId)));
    }

    public ThemeVotesDto themeVotes(int themeId) throws ThemeIdNotFoundException { // GET **/themes/{id}/votes
        Optional<ThemeVotesDto> optional = new ThemeController().themeVotes(themeId);
        return optional.orElseThrow(() -> new ThemeIdNotFoundException(Integer.toString(themeId)));
    }
}
