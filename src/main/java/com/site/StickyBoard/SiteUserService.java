package com.site.StickyBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SiteUserService {
	@Autowired
	public SiteUserRepository repository;
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Transactional
	public SiteUser registerUser(SiteUserDTO siteUserDTO) throws Exception {
		if(repository.existsByUsername(siteUserDTO.getRegisterUsername())) {
			throw new Exception("Username already in use.");
		}
		SiteUser siteUser = new SiteUser();
		siteUser.setUsername(siteUserDTO.getRegisterUsername());
		siteUser.setPassword(passwordEncoder.encode(siteUserDTO.getRegisterPassword()));
		siteUser.setEnabled(true);
		siteUser.setPermissions(0);
		return repository.save(siteUser);
	}
	
	public SiteUser getByUsername(String username) {
		return repository.getByUsername(username);
	}
	
	public List<SiteUser> getAllUsers() {
		return repository.findAll();
	}
}
