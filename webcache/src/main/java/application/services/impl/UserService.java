package application.services.impl;

import static application.services.mappers.UserMapper.convertToListUserViewModel;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import application.base.BaseAppService;
import application.services.contracts.IUserService;
import application.services.messages.GetUsersByCriteriaResponse;
import data.repositories.contracts.IUserRepository;
import entities.User;
import infrastructure.caching.contracts.IApplicationCacheService;

@Service(value="UserService")
public class UserService extends BaseAppService implements IUserService{

	public static final String USER_CACHE_KEY = "user.cache.key";
	
	
	@Autowired
	@Qualifier("UserRepository")
	private IUserRepository userRepository;
	
	@Autowired
	@Qualifier("ApplicationCacheService")
	private IApplicationCacheService cacheService;
	
	@Transactional
	public GetUsersByCriteriaResponse getUsersByCriteria(String name, String phone, String company, String iban) {
		GetUsersByCriteriaResponse response = new GetUsersByCriteriaResponse();
		try
		{
			List<User> userList = getUsersFromCache();
			if(userList == null)
			{
				userList = userRepository.getByCriteria(name, phone, company, iban);
				saveUsersIntoCache(userList);
			}
			
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

	private void saveUsersIntoCache(List<User> userList) {
		cacheService.put(USER_CACHE_KEY, userList);
	}

	private List<User> getUsersFromCache() {
		return cacheService.get(USER_CACHE_KEY);
	}
}
