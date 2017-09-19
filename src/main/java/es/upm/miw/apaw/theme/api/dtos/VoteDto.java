package es.upm.miw.apaw.theme.api.dtos;

public class VoteDto {
	private String themeName;
	private int voteValue;

	public VoteDto() {
	}

	public VoteDto(String themeName, int voteValue) {
		this.themeName = themeName;
		this.voteValue = voteValue;
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
