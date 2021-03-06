package xml.agent.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xml.agent.model.security.Authority;
import xml.agent.repository.AuthorityRepository;

@RestController
public class AuthorityController {

	@Autowired
	private AuthorityRepository authorityRepo;
	
	@RequestMapping(value = "/authority", method = RequestMethod.GET)
	public List<Authority> getAuthorities() {
		ArrayList ret = new ArrayList();
		authorityRepo.findAll().forEach(ret::add);
		return ret;
	}
}
