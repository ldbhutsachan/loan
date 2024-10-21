package com.ldb.loanapi.Security.service;

import com.ldb.loanapi.Entities.UserAttempts;

public interface UserDetailsDao {

	void updateFailAttempts(String username);
	void resetFailAttempts(String username);
	UserAttempts getUserAttempts(String username);
	
}
