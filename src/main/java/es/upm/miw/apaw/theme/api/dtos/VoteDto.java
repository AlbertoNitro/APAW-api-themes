package es.upm.miw.apaw.theme.api.dtos;

import es.upm.miw.apaw.theme.api.entities.Vote;

public class VoteDto {

    private String themeName;

    private int voteValue;

    public VoteDto() {
    }

    public VoteDto(Vote vote) {
        this.themeName = vote.getTheme().getName();
        this.voteValue = vote.getValue();
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public int getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(int voteValue) {
        this.voteValue = voteValue;
    }

    @Override
    public String toString() {
        return "{\"themeName\":\"" + themeName + ",\"voteValue\":" + voteValue + "}";
    }

}
