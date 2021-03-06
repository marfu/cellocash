package com.celloCashAdmin.security.bean;



import com.cellocash.model.HistoriqueConnection;
import com.cellocash.model.services.IHistoriqueConnectionService;
import com.cellocash.security.service.ISecurityService;
import com.cellocash.security.service.entity.Authorization;
import com.cellocash.security.service.entity.User;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;




import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

import org.primefaces.context.RequestContext;


@ManagedBean(name = "securityBean")
@SessionScoped
@SuppressWarnings("unused")
public class SecurityBean implements Serializable {

    private static final long serialVersionUID = -4010334200813729925L;

    private static final Logger log = Logger.getLogger(SecurityBean.class);

    @EJB
    ISecurityService securityService;
    @EJB
    IHistoriqueConnectionService historiqueConnectionService;

   

    //@EJB
   // private IUtilService utilService;

    private User userTemp;

   

    private boolean logged;

    private String ipAdresse;

    private String remoteName;

    private String name;

    private String password;

    private static int alerte = 100;
    
    private HashMap<String, Boolean> listPermissions = new HashMap<>();

    public SecurityBean() {
        userTemp = new User();
       
    }


    public boolean hasPermission(String content, String action) {
//        if (userTemp != null && userTemp.getRole() != null) {
//            return securityService.getPermissionsForRole(userTemp.getRole().getDesignation()).stream().anyMatch((p) -> (p.getTarget().equals(content) && p.getAction().equals(action)));
//        }
        return false;
    }
    
     public boolean hasPermission(String content) {
         if(listPermissions.containsKey(content)){
             return true;
         }else{
             return false;
         }
    }

    public void showMessage() {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life", "Echoes in eternity."));
    }

    public String login() {
        log.info("LOGIN METHOD CALLED");
        User temp = securityService.connectByIdAndPassword(name, password, getIpAdresse());
      
        
        
        if (temp != null) {
            setLogged(true);
            setUserTemp(temp);
         
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", name);
            
            List<Authorization> perms = temp.getRole().getPermission();
            if(!perms.isEmpty()){
             //   perms.stream().forEach((p) -> {
               //     listPermissions.put(p.getName(), true);
             //   });
            }
            setAlerte(temp.getAlerte());
            //log.info(listPermissions.toString());
            addInfoMessage("Bienvenue " + getUserName() + " , adresse IP : " + getIpAdresse() + " , ordinateur : " + getRemoteName() );
            HistoriqueConnection u=new HistoriqueConnection();
            
            
            HttpServletRequest request = (HttpServletRequest) (FacesContext.getCurrentInstance().getExternalContext().getRequest());
            request.getRemoteAddr();
            
            
            u.setBrowser(request.getHeader("User-Agent"));
            u.setUsername(getUserName());
            u.setIpAdress( getIpAdresse());
            
            historiqueConnectionService.createOrUpdate(u);
            
            
            //infoNewVersion();
            return "success-login";
        } else {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Utilisateur  " + name + " , inconnu ou mot de passe incorrects. veuillez contactez la hotline "));
            return "failure-login";
        }
    }

    public String changePassword() {
        return "changePassword";
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        if (session == null) {
            return "disconnect-login";
        } else {
            session.invalidate();
            userTemp = null;
          
            logged = false;
            return "disconnect-login";
        }
    }

    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERREUR", msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, facesMsg);
    }

    public static void addWarningMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, "AVERTISSEMENT", msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, facesMsg);
    }

    public static void addInfoMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFORMATION", msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, facesMsg);
    }

    public static void addExceptionMessage() {
        addErrorMessage("Une erreur est survenue , merci de prevenir la hotline");
    }

    public static void addExceptionMessage(Exception e) {
        addErrorMessage("Une erreur est survenue , merci de prevenir la hotline");
        e.printStackTrace();
    }

    public String getVerifyLogin() {
        try {
            if (!logged) {
                addErrorMessage("Vous n'avez pas le droit d' acceder a cette page.");
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("/GPV3000Web/pages/home.jsf");
                return "";
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    

    public String getUserName() {
        return getUserTemp().getUserName();
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public User getUserTemp() {
        return userTemp;
    }

    public void setUserTemp(User userTemp) {
        this.userTemp = userTemp;
    }

    

    public String getIpAdresse() {
        HttpServletRequest request = (HttpServletRequest) (FacesContext.getCurrentInstance().getExternalContext().getRequest());
        return request.getRemoteAddr();
    }

    public void setIpAdresse(String ipAdresse) {
        this.ipAdresse = ipAdresse;
    }

    public String getRemoteName() {
        HttpServletRequest request = (HttpServletRequest) (FacesContext.getCurrentInstance().getExternalContext().getRequest());
        return request.getRemoteHost();
    }

    public void setRemoteName(String remoteName) {
        this.remoteName = remoteName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getAlerte() {
        return alerte;
    }

    public void setAlerte(int alerte) {
        SecurityBean.alerte = alerte;
    }

    public HashMap<String, Boolean> getListPermissions() {
        return listPermissions;
    }

    public void setListPermissions(HashMap<String, Boolean> listPermissions) {
        this.listPermissions = listPermissions;
    }

}
