package assignment_java_Springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import assignment_java_Springboot.model.Employee;
import assignment_java_Springboot.model.JwtRequest;
import assignment_java_Springboot.model.JwtResponse;
import assignment_java_Springboot.model.PersonalData;
import assignment_java_Springboot.service.Emp_personalDataService;
import assignment_java_Springboot.service.EmployeeService;
import assignment_java_Springboot.utility.JwtUtility;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
// This means that this class is a Controller
@EnableWebMvc
public class EmployeeController {

	@Autowired

	EmployeeService employeeService;

	@GetMapping("/")

	public String viewHomePage(Model model) {

		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		
		return "index";
	}

	@Autowired
	private JwtUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	Emp_personalDataService emp_p_service;



//	@PostMapping("/authenticate")
//	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
//
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            jwtRequest.getUsername(),
//                            jwtRequest.getPassword()
//                    )
//            );
//        } catch (BadCredentialsException ex) {
//            throw new Exception("INVALID_CREDENTIALS", ex);
//        }
//
//        final UserDetails userDetails
//                = employeeService.loadUserByUsername(jwtRequest.getUsername());
//
//        final String jwt =
//                jwtUtility.generateToken(userDetails);
//
//        return   JwtResponse.ok (new JwtRequest());
//    }
//	

	// ******************************************getAll-data-Personal***********

	@GetMapping("/list-data--p")

	public String showNewEmployeePDataForm(Model model) {
		model.addAttribute("list_p", emp_p_service.getallPersonalDatas());

		return "view_PD";
	}

	// *************Emp*********************//showNewEmployeeForm

	@GetMapping("/showNewEmployeeForm")

	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "new_employee";
	}
	// *************************************

	@GetMapping("/showNewEmployeeForm_P_data")

	public String showNewEmployeeFormFor_personal_data(Model model) {
		PersonalData personalData = new PersonalData();

		model.addAttribute("personalData", personalData);

		return "new_employee_p";
	}

	@PostMapping("/saveEmployee--P")

	public String saveEmployeeP(@ModelAttribute("personalData") PersonalData personalData) {

		emp_p_service.savePEmployee(personalData);

		return "redirect:/";
	}

//***************************
	@PostMapping("/saveEmployee")

	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

		employeeService.saveEmployee(employee);

		return "redirect:/";
	}

	// ******************************show**********


	@GetMapping("/showFormForUpdate/{id}")

	public String showUpdateForm(@PathVariable Long id, Model model) {

		Employee employee = employeeService.getEmployeeById(id);

		model.addAttribute("employee", employee);

		// shows the update_employee.html template:
		return "update_employee";
	}

	// delete the employee by id
	@GetMapping("/delete/{id}")

	public String deleteEmployeeById(@PathVariable Long id, Model model) {
		employeeService.deleteEmployeeById(id);

		return "redirect:/";
	}
}
