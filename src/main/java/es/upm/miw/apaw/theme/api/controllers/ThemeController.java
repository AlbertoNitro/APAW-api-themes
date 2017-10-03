package es.upm.miw.apaw.theme.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.dtos.ThemeDto;
import es.upm.miw.apaw.theme.api.entities.Theme;
import es.upm.miw.apaw.theme.api.dtos.ThemeVoteListDto;

public class ThemeController {

    public List<ThemeDto> themeList() {
        List<Theme> themeList = DaoFactory.getFactory().getThemeDao().findAll();
        List<ThemeDto> themeDtoList = new ArrayList<>();
        for (Theme theme : themeList) {
            themeDtoList.add(new ThemeDto(theme));
        }
        return themeDtoList;
    }

    public void createTheme(String themeName) {
        DaoFactory.getFactory().getThemeDao().create(new Theme(themeName));
    }

    private boolean existThemeId(int themeId) {
        return DaoFactory.getFactory().getThemeDao().read(themeId) != null;
    }

    // java 8: con Optional se expresa que podría no encontrarse el valor, mejor que provocar null y mejor que provocar exception
    public Optional<Double> themeOverage(int themeId) {
        if (existThemeId(themeId)) {
            List<Integer> voteList = DaoFactory.getFactory().getVoteDao().findValueByThemeId(themeId);
            if (voteList.isEmpty()) {
                return Optional.of(Double.NaN);
            } else {
                double total = 0;
                for (Integer value : voteList) {
                    total += value;
                }
                return Optional.of(total / voteList.size());
            }
        } else {
            return Optional.empty();
        }
    }

    public Optional<ThemeVoteListDto> themeVotes(int themeId) {
        if (existThemeId(themeId)) {
            List<Integer> voteList = DaoFactory.getFactory().getVoteDao().findValueByThemeId(themeId);
            return Optional.of(new ThemeVoteListDto(DaoFactory.getFactory().getThemeDao().read(themeId), voteList));
        } else {
            return Optional.empty();
        }
    }

    public Optional<ThemeDto> readTheme(int themeId) {
       if (existThemeId(themeId)) {
            return Optional.of(new ThemeDto(DaoFactory.getFactory().getThemeDao().read(themeId)));
        } else {
            return Optional.empty();
        }
    }

}
