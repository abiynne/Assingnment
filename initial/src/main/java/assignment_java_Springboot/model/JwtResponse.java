package assignment_java_Springboot.model;

import org.springframework.security.authentication.AuthenticationManager;

public class JwtResponse {
	private final String jwt;
	
	public JwtResponse (String jwt)
	{
		this.jwt=jwt;
		
	}
	public String getJwt() {
		return jwt;
	}

}
