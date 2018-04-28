package com.cellocash.security.dao;

import com.cellocash.security.service.entity.Authorization;
import java.util.List;



public interface IAuthorizationDAO {
	
	public Authorization create(Authorization entity);
	
	public Authorization get(long entityId) ;

	public boolean remove(Authorization entity) ;

	public Authorization update(Authorization entity) ;

	public List<Authorization> getAllPermissions() ;

	public List<Authorization> getPermissionByTarget(String target) ;

	public List<Authorization> getPermissionByAction(String action) ;

	public List<Authorization> getPermissionsForRole(String roleId) ;


}
