package web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import application.services.contracts.IUserService;
import application.services.messages.GetUsersByCriteriaResponse;
import application.services.viewmodels.UserViewModel;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("UserService")
    private IUserService userService;
	
	@ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public GetUsersByCriteriaResponse getUsers(@RequestParam(value = "name", required = false) String name, 
    							@RequestParam(value = "phone", required = false) String phone, 
    							@RequestParam(value = "company", required = false) String company, 
    							@RequestParam(value = "iban", required = false) String iban) {

		GetUsersByCriteriaResponse response = userService.getUsersByCriteria(name, phone, company, iban);
		return response;
		
    }
}
