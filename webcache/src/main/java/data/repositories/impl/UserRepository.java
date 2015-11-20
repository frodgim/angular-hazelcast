package data.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import data.repositories.contracts.IUserRepository;
import entities.User;

@Repository(value = "UserRepository")
public class UserRepository implements IUserRepository {

	@PersistenceContext
	private EntityManager em;

	public List<User> getByCriteria(String name, String phone, String company, String iban) {

		String queryString = "select u from User u where 1=1 ";
		if(name != null)
		{
			queryString += " and name = :name ";
		}
		if(phone != null)
		{
			queryString += " and phone = :phone ";
		}
		
		if(company != null)
		{
			queryString += " and company = :company ";
		}
		
		if(iban != null)
		{
			queryString += " and iban = :iban ";
		}

		
		Query query = em.createQuery(queryString,User.class);
		
		if(name != null)
		{
			query.setParameter("name", name);
		}
		if(phone != null)
		{
			query.setParameter("phone", phone);
		}
		
		if(company != null)
		{
			query.setParameter("company", company);
		}
		
		if(iban != null)
		{
			query.setParameter("iban", iban);
		}
		
		
		return query.getResultList();
	}

}
