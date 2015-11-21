package data.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import data.repositories.contracts.IUserRepository;
import entities.User;

@Repository
public class UserRepository{

	@PersistenceContext
	private EntityManager em;

	public List<User> getByCriteria(String name, String phone, String company, String iban) {

		String queryString = "select u from User u where 1=1 ";
		if(name != null)
		{
			queryString += " and name like :name ";
		}
		if(phone != null)
		{
			queryString += " and phone like :phone ";
		}
		
		if(company != null)
		{
			queryString += " and company like :company ";
		}
		
		if(iban != null)
		{
			queryString += " and iban like :iban ";
		}

		
		Query query = em.createQuery(queryString,User.class);
		
		if(name != null)
		{
			query.setParameter("name", "%" + name + "%");
		}
		if(phone != null)
		{
			query.setParameter("phone", "%" + phone+ "%");
		}
		
		if(company != null)
		{
			query.setParameter("company", "%" + company + "%");
		}
		
		if(iban != null)
		{
			query.setParameter("iban", "%" + iban + "%");
		}
		
		
		return query.getResultList();
	}

}
