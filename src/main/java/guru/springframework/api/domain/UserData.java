package guru.springframework.api.domain;

import java.util.List;

public class UserData {
	private List<User> results;
	private Info info;

	public void setResults(List<User> results){
		this.results = results;
	}

	public List<User> getResults(){
		return results;
	}

	public void setInfo(Info info){
		this.info = info;
	}

	public Info getInfo(){
		return info;
	}
}