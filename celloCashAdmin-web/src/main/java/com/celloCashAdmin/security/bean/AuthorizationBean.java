package com.celloCashAdmin.security.bean;



import com.cellocash.security.service.ISecurityService;
import com.cellocash.security.service.entity.Authorization;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;


import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("AutorizationBean")
@ViewScoped
public class AuthorizationBean implements Serializable {

	private static final long serialVersionUID = -4010334200813729925L;

	@EJB
	ISecurityService securityService;

	@SuppressWarnings("unused")
	private List<Authorization> perms;

	private Authorization selectedPerm;

	public AuthorizationBean() {
		selectedPerm = new Authorization();
	}

	public String detailPerm() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("permId");
		if (id != null && !id.trim().equals("")) {
			System.out.println("PERM ID : "+id);
			selectedPerm = securityService.getPermissionsById(Long.parseLong(id));
			return "";
		} else {
			return "";
		}
	}
	
	
	public void newPerm(ActionEvent actionEvent) {
		selectedPerm = new Authorization();
	}

	public void savePerm() {

		selectedPerm = securityService.createPermission(selectedPerm);
		perms = securityService.getAllPermissions();
		selectedPerm = new Authorization();
		
	}

	public List<Authorization> getPerms() {
		return securityService.getAllPermissions();
	}

	public void setPerms(List<Authorization> perms) {
		this.perms = perms;
	}

	public Authorization getSelectedPerm() {
		return selectedPerm;
	}

	public void setSelectedPerm(Authorization selectedPerm) {
		this.selectedPerm = selectedPerm;
	}

	
	

}