package assignment_java_Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assignment_java_Springboot.model.PersonalData;
@Repository
public interface personalRpo extends JpaRepository<PersonalData, Integer> {

	

	


	
	

}
