package com.site.StickyBoard;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@PasswordsMatch
public class SiteUserDTO {
	@NotNull
	@NotEmpty
	private String registerUsername;
	
	@NotNull
	@NotEmpty
	private String registerPassword;
	private String registerConfirmPassword;
	
	public void setRegisterUsername(String registerUsername) {
		this.registerUsername = registerUsername;
	}
	
	public String getRegisterUsername() { 
		return registerUsername;
	}
	
	public void setRegisterPassword(String registerPassword) {
		this.registerPassword = registerPassword;
	}
	
	public String getRegisterPassword() {
		return registerPassword;
	}
	
	public void setRegisterConfirmPassword(String registerConfirmPassword) {
		this.registerConfirmPassword = registerConfirmPassword;
	}
	
	public String getRegisterConfirmPassword() {
		return registerConfirmPassword;
	}

}
