package com.cellocash.security.dao;


import com.cellocash.security.service.entity.Role;
import java.util.List;



public interface IRoleDAO {
	
	public Role create(Role entity);

	public Role get(String entityId) ;

	public boolean remove(Role entity) ;

	public Role update(Role entity) ;

	public List<Role> getAllRoles() ;



}
