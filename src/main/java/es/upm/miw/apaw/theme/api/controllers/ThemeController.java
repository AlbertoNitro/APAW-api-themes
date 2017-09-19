package es.upm.miw.apaw.theme.api.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.dtos.OverageDto;
import es.upm.miw.apaw.theme.api.dtos.ThemeDto;
import es.upm.miw.apaw.theme.api.entities.Theme;


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

	public OverageDto themeOverage(int themeId) {
		if (DaoFactory.getFactory().getThemeDao().read(themeId) == null) {
			return null;
		}
		List<Integer> voteValues = DaoFactory.getFactory().getVoteDao().findValueByThemeId(themeId);
		double total = 0;
		for (Integer value : voteValues) {
			total += value;
		}
		return new OverageDto(total / voteValues.size());
	}

}
