package com.returnorder.AuthorizationService.model;

public class AuthenticationResponse {

	private String jwt;
	private Boolean valid;
	
	public AuthenticationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationResponse(String jwt, Boolean valid) {
		super();
		this.jwt = jwt;
		this.valid = valid;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	@Override
	public String toString() {
		return "AuthenticationResponse [jwt=" + jwt + ", valid=" + valid + "]";
	}
	
	
	
}
