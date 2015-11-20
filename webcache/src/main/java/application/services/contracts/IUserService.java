package application.services.contracts;

import application.services.messages.GetUsersByCriteriaResponse;

public interface IUserService {

	public GetUsersByCriteriaResponse getUsersByCriteria(String name, String phone, String company, String iban);

}
