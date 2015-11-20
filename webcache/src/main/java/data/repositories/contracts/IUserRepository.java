package data.repositories.contracts;

import java.util.List;

import entities.User;


public interface IUserRepository {

	public List<User> getByCriteria(String name, String phone, String company, String iban);
}
