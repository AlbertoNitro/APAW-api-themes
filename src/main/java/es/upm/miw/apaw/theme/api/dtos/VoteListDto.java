package es.upm.miw.apaw.theme.api.dtos;

import java.util.ArrayList;
import java.util.List;

public class VoteListDto {
	List<VoteDto> voteList = new ArrayList<>();

	public VoteListDto() {
	}
	
	public List<VoteDto> getVoteList() {
		return voteList;
	}

	public void addVoteWrapper(VoteDto voteWrapper) {
		voteList.add(voteWrapper);
	}

	@Override
	public String toString() {
		String result = "{\"voteList\":[ ";
		for (VoteDto voteWrapper : voteList) {
			result += voteWrapper.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}

}
