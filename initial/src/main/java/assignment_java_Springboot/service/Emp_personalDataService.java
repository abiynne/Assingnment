package assignment_java_Springboot.service;

import java.util.ArrayList;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import assignment_java_Springboot.model.PersonalData;
import assignment_java_Springboot.repository.personalRpo;

@Service
public class Emp_personalDataService implements UserDetailsService {

	@Autowired
	personalRpo personalRpo;

	public List<PersonalData> getallPersonalDatas() {
		return personalRpo.findAll();
	}
	
	
	public void savePEmployee(PersonalData pemp) {

		personalRpo.save(pemp);
	}
	
	public List<PersonalData>getPersolalData(){
		return personalRpo.findAll();
	}

	
	
	public PersonalData getPersonalDataBYID(Integer id) {
		PersonalData pemp=personalRpo.getById(id);
		if(pemp==null) {
			throw new RuntimeException("employe not found");
		}
		return pemp;
		
	}
	public String deletePempByID(Integer id) {
		PersonalData pemp=personalRpo.getById(id);
		if (pemp == null) {
			throw new RuntimeException("Employee not found");
		}
		personalRpo.deleteById(id);
		 return "Deleted: " +pemp.getName();
	
		 
	}
	
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return new User("admin", "password", new ArrayList<>());
	}

}
