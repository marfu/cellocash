package com.cellocash.security.service;



import com.cellocash.security.service.entity.Authorization;
import com.cellocash.security.service.entity.Role;
import com.cellocash.security.service.entity.User;
import java.util.List;



public interface ISecurityService {

    /**
     * USER METHODES *
     * @param u
     */
    public User createOrUpdateUser(User u);

    public User getUser(String userName);

    public boolean removeUser(User u);

    public List<User> getAllUsers();

    public User connectByIdAndPassword(String name, String password, String ipAddress);

    /**
     * ROLES METHODES *
     */
    public List<Role> getAllRoles();

    public Role getRoleById(String designation);

    public Role createRole(Role d);

    public void removeRole(Role d);

    public Role updateRole(Role d);

    /**
     * PERMISSIONS METHODES
     *
     * @return  *
     */
    public List<Authorization> getAllPermissions();

    public Authorization getPermissionsById(long permId);

    public Authorization createPermission(Authorization d);

    public boolean removePermission(Authorization d);

    public Authorization updatePermission(Authorization d);

    public List<Authorization> getPermissionByTarget(String target);

    public List<Authorization> getPermissionByAction(String action);

    public List<Authorization> getPermissionsForRole(String roleId);

}
