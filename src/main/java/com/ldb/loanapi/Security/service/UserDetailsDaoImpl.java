package com.ldb.loanapi.Security.service;

import com.ldb.loanapi.Entities.UserAttempts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Repository
public class UserDetailsDaoImpl extends JdbcDaoSupport implements UserDetailsDao {

	private static final String SQL_USERS_UPDATE_LOCKED = "UPDATE USER_LOGIN SET account_non_locked = ? WHERE user_name = ?";
	private static final String SQL_USERS_COUNT = "SELECT count(*) from USER_LOGIN WHERE user_name = ?";

	private static final String SQL_USER_ATTEMPTS_GET = "SELECT * from USER_LOGIN_ATTEMPTS WHERE user_name = ?";
	private static final String SQL_USER_ATTEMPTS_INSERT = "INSERT INTO USER_LOGIN_ATTEMPTS (user_name, attempts, last_modified) VALUES(?,?,?)";
	private static final String SQL_USER_ATTEMPTS_UPDATE_ATTEMPTS = "UPDATE USER_LOGIN_ATTEMPTS SET attempts = attempts + 1, last_modified = ? WHERE user_name = ?";
	private static final String SQL_USER_ATTEMPTS_RESET_ATTEMPTS = "UPDATE USER_LOGIN_ATTEMPTS SET attempts = 0, last_modified = null WHERE user_name = ?";

	//get value from boder.application.properties file : max.attempts
	@Value("${max.attempts}")
	private  int MAX_ATTEMPTS;

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void updateFailAttempts(String username) {

		UserAttempts user = getUserAttempts(username);

		if (user == null) {
			if (isUserExists(username)) {
				// if no record, insert a new
				getJdbcTemplate().update(SQL_USER_ATTEMPTS_INSERT, new Object[] { username, 1, new Date() });
			}
		} else {

			if (isUserExists(username)) {
				// update attempts count, +1
				getJdbcTemplate().update(SQL_USER_ATTEMPTS_UPDATE_ATTEMPTS, new Object[] { new Date(), username});
			}

			if (user.getAttempts() + 1 >= MAX_ATTEMPTS) {
				// locked user
				getJdbcTemplate().update(SQL_USERS_UPDATE_LOCKED, new Object[] { false, username });
				// throw exception
				throw new LockedException("User Account is locked!");
			}

		}

	}

	@Override
	public UserAttempts getUserAttempts(String username) {

		try {

			UserAttempts userAttempts = getJdbcTemplate().queryForObject(SQL_USER_ATTEMPTS_GET,
					new Object[] { username }, new RowMapper<UserAttempts>() {
						public UserAttempts mapRow(ResultSet rs, int rowNum) throws SQLException {

							UserAttempts user = new UserAttempts();
							user.setId(rs.getInt("id"));
							user.setUsername(rs.getString("user_name"));
							user.setAttempts(rs.getInt("attempts"));
							user.setLastModified(rs.getDate("last_modified"));

							return user;
						}

					});
			return userAttempts;

		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public void resetFailAttempts(String username) {
		getJdbcTemplate().update(SQL_USER_ATTEMPTS_RESET_ATTEMPTS, new Object[] { username });
	}

	private boolean isUserExists(String username) {

		boolean result = false;

		int count = getJdbcTemplate().queryForObject(SQL_USERS_COUNT, new Object[] { username }, Integer.class);
		if (count > 0) {
			result = true;
		}

		return result;
	}
}

