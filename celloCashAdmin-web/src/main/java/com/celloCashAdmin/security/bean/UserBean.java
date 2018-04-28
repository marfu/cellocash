package com.celloCashAdmin.security.bean;


import com.cellocash.security.service.ISecurityService;
import com.cellocash.security.service.entity.Role;
import com.cellocash.security.service.entity.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DualListModel;


import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;


@Named("userBean")
@SessionScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = -4010334200813729925L;

    @EJB
    ISecurityService securityService;

    

    @SuppressWarnings("unused")
    private List<User> users;

    private User selectedUser;

    private DualListModel<Role> roles;

    private List<Role> source;
    private List<Role> target;

 

    private String oldPassword;

    private String newPassword;

    private String confirmPassword;

    //Afficher ou non le motdepasse
    private boolean enabledPassword;

    public UserBean() {
        selectedUser = new User();
        source = new ArrayList<>();
        target = new ArrayList<>();
       
        roles = new DualListModel<>(source, target);
       

    }

    //a été modifier en method ajax
    public void detailUser(ActionEvent actionEvent) {
        enabledPassword = false;
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("userId");

        if (id != null && !id.trim().equals("")) {
            System.out.println("USER ID : " + id);

            selectedUser = securityService.getUser(id);
            source.clear();
            target.clear();
            

            source = securityService.getAllRoles();
           

            if (selectedUser.getRole() != null) {
                source.remove(selectedUser.getRole());
                target.add(selectedUser.getRole());
            }
           

            roles = new DualListModel<>(source, target);
           
            // return "";
        } else {
            //  return "";
        }
    }

    public void newUser(ActionEvent actionEvent) {
        clearEntity();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(
                null,
                new FacesMessage("Creation utilisateur",
                        "veuillez saisir les informations d\u00E9finissant le nouvel utilisateur"));
    }

    private void clearEntity() {
        enabledPassword = true;
        selectedUser = new User();
        target = new ArrayList<>();
        source = securityService.getAllRoles();
       // sourcePvt = pointDeVenteService.getAllPVTActive();
        //targetPvt = new ArrayList<>();
        roles = new DualListModel<>(source, target);
        
    }

    public void saveUser() {
        if (roles.getTarget() != null && roles.getTarget().size() > 0) {
            selectedUser.setRole(roles.getTarget().get(0));
//            selectedUser.setPvt(pvts.getTarget());
            selectedUser = securityService.createOrUpdateUser(selectedUser);
            users = securityService.getAllUsers();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(
                    "Utilisateur cr\u00E9er/maj avec succ\u00E8s", "l' utilisateur "
                    + selectedUser.getUserName()
                    + " a \u00E9t\u00E9 sauvegarder/maj avec succ\u00E8s."));

            clearEntity();
        }
    }

    public void changePassword() {

        if (newPassword.equals(confirmPassword)) {

            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Modification du mot de passe effectu\u00E9 avec succ\u00E8s"));
            // this.newPassword = "";
            // this.oldPassword = "";
            //this.confirmPassword = "";

            selectedUser.setPassword(newPassword);
            selectedUser = securityService.createOrUpdateUser(selectedUser);
        } else {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "les MDP saisi ne correspondent pas"));

        }

    }

    public void changeMyPassword() {

        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Modification du mot de passe effectu\u00E9 avec succ\u00E8s"));
        //this.newPassword = "";
        this.oldPassword = org.apache.commons.codec.digest.DigestUtils.md5Hex(this.oldPassword);
        //this.confirmPassword = "";
        //selectedUser.setPassword(newPassword);
        //  selectedUser = securityService.createOrUpdateUser(selectedUser);

        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("userId");

        if (id != null && !id.trim().equals("")) {
            System.out.println("USER ID : " + id);

            selectedUser = securityService.getUser(id);
        }

        if (this.oldPassword.equals(selectedUser.getPassword())) {

            selectedUser.setPassword(this.newPassword);
            selectedUser = securityService.createOrUpdateUser(selectedUser);

            System.out.println("Password changed !");

        }

        //selectedUser = securityService.getUser(id); 
        //}
    }

    public List<Role> getSource() {
        return source;
    }

    public void setSource(List<Role> source) {
        this.source = source;
    }

    public List<Role> getTarget() {
        return target;
    }

    public void setTarget(List<Role> target) {
        this.target = target;
    }

    public DualListModel<Role> getRoles() {

        return roles;
    }

    public void setRoles(DualListModel<Role> roles) {
        this.roles = roles;
    }

    public List<User> getUsers() {
        return securityService.getAllUsers();
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

   

    

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isEnabledPassword() {
        return enabledPassword;
    }

    public void setEnabledPassword(boolean enabledPassword) {
        this.enabledPassword = enabledPassword;
    }

}
