package application.services.impl;

import static application.services.mappers.UserMapper.convertToListUserViewModel;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.base.BaseAppService;
import application.services.contracts.IUserService;
import application.services.messages.GetUsersByCriteriaResponse;
import data.repositories.impl.UserRepository;
import entities.User;
import infrastructure.caching.impl.HazelcastApplicationCacheService;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional
	public GetUsersByCriteriaResponse getUsersByCriteria(String name, String phone, String company, String iban) {
		GetUsersByCriteriaResponse response = new GetUsersByCriteriaResponse();
		try
		{
			List<User>userList = userRepository.getByCriteria(name, phone, company, iban);
			response.setUserList(convertToListUserViewModel(userList));
			response.setCount(userList.size());
			response.setValid(true);
		}
		catch(Exception e)
		{
			response.setValid(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}

}
