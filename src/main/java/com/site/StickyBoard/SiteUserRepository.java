package com.site.StickyBoard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser, Integer> {
	
	public boolean existsByUsername(String username);
	public SiteUser getByUsername(String username);

}
