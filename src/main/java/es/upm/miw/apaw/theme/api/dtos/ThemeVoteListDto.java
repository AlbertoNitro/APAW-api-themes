package es.upm.miw.apaw.theme.api.dtos;

import java.util.List;

import es.upm.miw.apaw.theme.api.entities.Theme;

public class ThemeVoteListDto {

    private ThemeDto themeDto;

    private List<Integer> voteList;

    public ThemeVoteListDto() {
    }

    public ThemeVoteListDto(Theme theme, List<Integer> voteList) {
        themeDto = new ThemeDto(theme);
        this.voteList = voteList;
    }

    public ThemeDto getThemeDto() {
        return themeDto;
    }

    public List<Integer> getVoteList() {
        return voteList;
    }

    @Override
    public String toString() {
        return "{" + themeDto + "," + voteList + "}";
    }

}
