package application.services.mappers;

import java.util.ArrayList;
import java.util.List;

import application.services.viewmodels.UserViewModel;
import entities.User;

public class UserMapper {

	public static UserViewModel convertToUserViewModel(User user) {
		UserViewModel viewModel = new UserViewModel();
		viewModel.setName(user.getName());
		viewModel.setIban(user.getIban());
		viewModel.setCompany(user.getCompany());
		viewModel.setPhone(user.getPhone());
		return viewModel;
	}
	
	public static List<UserViewModel> convertToListUserViewModel(List<User> userList)
	{
		List<UserViewModel> listViewModels = new ArrayList<UserViewModel>(); 
		for (User user : userList) {
			listViewModels.add(convertToUserViewModel(user));
		}
		
		return listViewModels;
	}
}
