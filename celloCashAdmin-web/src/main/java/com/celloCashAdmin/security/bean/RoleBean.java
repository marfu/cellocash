package com.celloCashAdmin.security.bean;



import com.cellocash.security.service.ISecurityService;
import com.cellocash.security.service.entity.Authorization;
import com.cellocash.security.service.entity.Role;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DualListModel;

 
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("roleBean")
@ViewScoped
public class RoleBean implements Serializable {

	private static final long serialVersionUID = -4010334200813729925L;

	@EJB
	ISecurityService securityService;


	@SuppressWarnings("unused")
	private List<Role> roles;
	

	private Role selectedRole;

	private DualListModel<Authorization> perms;
	private List<Authorization> source;
	private List<Authorization> target;

	public RoleBean() {
		selectedRole = new Role();
		source = new ArrayList<>();
		target = new ArrayList<>();
		perms = new DualListModel<>(source, target);

	}

	public void newRole(ActionEvent actionEvent) {
		clearEntity();

	}
	
	
	public String detailRole() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("roleId");
		if (id != null && !id.trim().equals("")) {
			System.out.println("ROLE ID : "+id);
			selectedRole = securityService.getRoleById(id);
			System.out.println("SELECTED ROLE : "+selectedRole);
			source.clear();
			target.clear();

			source = securityService.getAllPermissions();
			
			if (selectedRole.getPermission() != null) {
				source.removeAll(selectedRole.getPermission());
				target.addAll(selectedRole.getPermission());
			}

			perms = new DualListModel<>(source, target);
			return "";
		} else {
			return "";
		}
	}

	private void clearEntity() {
		selectedRole = new Role();
		target = new ArrayList<>();
		source = securityService.getAllPermissions();
		perms = new DualListModel<>(source, target);
	}

	public void saveRole() {
		selectedRole.setPermission(perms.getTarget());
		selectedRole = securityService.createRole(selectedRole);
		roles = securityService.getAllRoles();
		clearEntity();
		
	}

	

	public List<Role> getRoles() {
		return securityService.getAllRoles();
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(Role selectedRole) {
		this.selectedRole = selectedRole;
	}

	public DualListModel<Authorization> getPerms() {
		return perms;
	}

	public void setPerms(DualListModel<Authorization> perms) {
		this.perms = perms;
	}

}
