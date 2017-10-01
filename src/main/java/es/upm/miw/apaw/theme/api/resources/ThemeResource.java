package es.upm.miw.apaw.theme.api.resources;

import java.util.List;
import java.util.Optional;

import es.upm.miw.apaw.theme.api.controllers.ThemeController;
import es.upm.miw.apaw.theme.api.dtos.ThemeDto;
import es.upm.miw.apaw.theme.api.dtos.ThemeVoteListDto;
import es.upm.miw.apaw.theme.api.resources.exceptions.ThemeFieldInvalidException;
import es.upm.miw.apaw.theme.api.resources.exceptions.ThemeIdNotFoundException;

public class ThemeResource {

    public static final String THEMES = "themes";

    public static final String ID = "/{id}";

    public static final String ID_OVERAGE = ID + "/overage";

    public static final String ID_VOTES = ID + "/votes";

    public List<ThemeDto> themeList() {
        return new ThemeController().themeList();
    }

    public ThemeDto readTheme(int themeId) throws ThemeIdNotFoundException {
        Optional<ThemeDto> optional = new ThemeController().readTheme(themeId);
        return optional.orElseThrow(() -> new ThemeIdNotFoundException(Integer.toString(themeId)));
    }

    public void createTheme(String themeName) throws ThemeFieldInvalidException {
        this.validateField(themeName);
        new ThemeController().createTheme(themeName);
    }

    public Double themeOverage(int themeId) throws ThemeIdNotFoundException {
        Optional<Double> optional = new ThemeController().themeOverage(themeId);
        return optional.orElseThrow(() -> new ThemeIdNotFoundException(Integer.toString(themeId)));
    }

    public ThemeVoteListDto themeVoteList(int themeId) throws ThemeIdNotFoundException {
        Optional<ThemeVoteListDto> optional = new ThemeController().themeVotes(themeId);
        return optional.orElseThrow(() -> new ThemeIdNotFoundException(Integer.toString(themeId)));
    }

    private void validateField(String field) throws ThemeFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new ThemeFieldInvalidException(field);
        }
    }

}
