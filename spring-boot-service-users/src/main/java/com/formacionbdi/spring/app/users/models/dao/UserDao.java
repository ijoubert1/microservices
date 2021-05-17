package com.formacionbdi.spring.app.users.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.formacionbdi.spring.app.users.commons.models.entity.User;

@RepositoryRestResource(path="users")
public interface UserDao extends PagingAndSortingRepository<User, Long> {

	@RestResource(path = "find-username")
	public User findByUsername(@Param("username") String username);

	public User findByUsernameAndEmail(@Param("username") String username, @Param("email") String email);

	@Query("select u from User u where u.username=?1")
	public User customQuery(String username);

}
