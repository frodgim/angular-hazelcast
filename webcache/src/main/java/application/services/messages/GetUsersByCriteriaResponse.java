package application.services.messages;

import java.util.List;

import application.base.BaseAppResponse;
import application.services.viewmodels.UserViewModel;

public class GetUsersByCriteriaResponse extends BaseAppResponse {

	private List<UserViewModel> userList;
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<UserViewModel> getUserList() {
		return userList;
	}

	public void setUserList(List<UserViewModel> userList) {
		this.userList = userList;
	}
	
	
}
