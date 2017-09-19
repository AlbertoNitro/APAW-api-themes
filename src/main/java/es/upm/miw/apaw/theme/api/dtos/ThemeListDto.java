package es.upm.miw.apaw.theme.api.dtos;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.apaw.theme.api.entities.Theme;

public class ThemeListDto {
	List<ThemeDto> themeDtoList;

	
	public ThemeListDto() {
		themeDtoList = new ArrayList<>();
	}
	
	public ThemeListDto(List<Theme> themeList) {
        themeList = new ArrayList<>();
        for (Theme theme : themeList) {
            themeDtoList.add(new ThemeDto(theme));
        }
	    
	}

	public List<ThemeDto> getThemeList() {
		return themeDtoList;
	}

	public void addThemeDto(ThemeDto themeDto){
		themeDtoList.add(themeDto);
	}
	

	@Override
	public String toString() {
		String result = "{\"themeList\":[ ";
		for (ThemeDto themeWrapper : themeDtoList) {
			result += themeWrapper.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}
}
