package es.upm.miw.apaw.theme.api.resources;

import java.util.List;

import es.upm.miw.apaw.theme.api.controllers.ThemeController;
import es.upm.miw.apaw.theme.api.dtos.OverageDto;
import es.upm.miw.apaw.theme.api.dtos.ThemeDto;
import es.upm.miw.apaw.theme.api.exceptions.InvalidThemeFieldException;
import es.upm.miw.apaw.theme.api.exceptions.NotFoundThemeIdException;

public class ThemeResource {

    // GET **/themes
    public List<ThemeDto> themeList() {
        return new ThemeController().themeList();
    }

    // POST **/themes body="themeName"
    public void createTheme(String themeName) throws InvalidThemeFieldException {
        this.validateField(themeName);
        new ThemeController().createTheme(themeName);
    }

    private void validateField(String field) throws InvalidThemeFieldException {
        if (field == null || field.isEmpty()) {
            throw new InvalidThemeFieldException(field);
        }
    }

    // GET **themes/{id}/overage
    public OverageDto themeOverage(int themeId) throws NotFoundThemeIdException {
        OverageDto overageWrapper = new ThemeController().themeOverage(themeId);
        if (overageWrapper == null) {
            throw new NotFoundThemeIdException("" + themeId);
        } else {
            return overageWrapper;
        }
    }

}
