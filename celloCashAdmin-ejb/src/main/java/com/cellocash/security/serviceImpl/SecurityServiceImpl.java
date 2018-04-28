package com.cellocash.security.serviceImpl;


import com.cellocash.security.dao.IAuthorizationDAO;
import com.cellocash.security.dao.IMySQLUserDAO;
import com.cellocash.security.dao.IRoleDAO;
import com.cellocash.security.service.ISecurityService;
import com.cellocash.security.service.entity.Authorization;
import com.cellocash.security.service.entity.Role;
import com.cellocash.security.service.entity.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;





@SuppressWarnings("serial")
@Stateless
@Local(ISecurityService.class)
public class SecurityServiceImpl implements ISecurityService, Serializable {

	private static Logger logger = Logger.getLogger(SecurityServiceImpl.class);

	@EJB
	private IRoleDAO role;

	@EJB
	private IMySQLUserDAO userDAO;

	

	@EJB
	private IAuthorizationDAO permission;
	
	

	@Override
	public User createOrUpdateUser(User u) {
		logger.log(Level.INFO, "createOrUpdateUser");
		return userDAO.createOrUpdateUser(u);
	}

	@Override
	public User getUser(String userName) {
		logger.log(Level.INFO, "getUser");
		return userDAO.getUser(userName);
	}

	@Override
	public boolean removeUser(User u) {
		logger.log(Level.INFO, "removeUser");
		return userDAO.removeUser(u);
	}

	@Override
	public List<User> getAllUsers() {
		logger.log(Level.INFO, "getAllUsers");
		return userDAO.getAllUsers();
	}

	@Override
	public User connectByIdAndPassword(String name, String password,String ipAddress) {
		try {
			
			logger.info("CONNECTBYIDANDPASSWORD = > "+name+" "+password+" "+ipAddress);
                        String encretedPassword = org.apache.commons.codec.digest.DigestUtils.md5Hex(password);
                        logger.info("encretedPassword : "+encretedPassword);
			User userMySql = userDAO.getUserByNameAndPassword(name, encretedPassword);
			if (userMySql == null) {
				logger.info("user not finded in database");
                                return null;
			} else {
				System.out.println("existe dans Mysql");
				if (!userMySql.isEnable()) {
					System.out.println("not enable");
					return null;
				} else {
					System.out.println("enable");
					userMySql.setDateDerniereConnexion(new Date(System.currentTimeMillis()));
					return userDAO.createOrUpdateUser(userMySql);
				}
			}
		}catch (Exception e) {
			return null;
		}

	}

	

	private User assignRight(User userLdap) {

            return null;
	}

	

	@Override
	public List<Role> getAllRoles() {
		return role.getAllRoles();
	}

	@Override
	public Role getRoleById(String roleID) {
		return role.get(roleID);
	}

	@Override
	public Role createRole(Role d) {
		return role.create(d);
	}

	@Override
	public void removeRole(Role d) {
		role.remove(d);

	}

	@Override
	public Role updateRole(Role d) {
		return role.update(d);
	}

	@Override
	public List<Authorization> getAllPermissions() {
		return permission.getAllPermissions();
	}

	@Override
	public Authorization getPermissionsById(long permId) {
		return permission.get(permId);
	}

	@Override
	public Authorization createPermission(Authorization d) {
		return permission.create(d);
	}

	@Override
	public boolean removePermission(Authorization d) {
		return permission.remove(d);

	}

	@Override
	public Authorization updatePermission(Authorization d) {
		return permission.update(d);
	}

	@Override
	public List<Authorization> getPermissionByTarget(String target) {
		return permission.getPermissionByTarget(target);
	}

	@Override
	public List<Authorization> getPermissionByAction(String action) {
		return permission.getPermissionByAction(action);
	}

	@Override
	public List<Authorization> getPermissionsForRole(String roleId) {
		return permission.getPermissionsForRole(roleId);
	}

}
