package com.cellocash.security.service.entity;

import com.cellocash.model.Agence_Bancaire;
import com.cellocash.model.Banque_Cellocash;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import org.apache.commons.codec.digest.DigestUtils;

@Entity
@Table(name = "USER")
public class User implements Serializable {

    private static final long serialVersionUID = 7199807568018597880L;

    @Id
//	@NotNull
    @Column(unique = true, name = "NOM_UTILISATEUR_PK")
    private String userName;

//	@Email
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SI_ACTIF")
    private boolean enable;

    @Column(name = "FIRST_CONNEXION")
    private boolean firstConnection;
    
    @Column(name = "ALERTE_SI_NB", columnDefinition = "bigint(11) default 100")
    private int alerte = 100;

    @ManyToOne
    private Role role;

    @Column(name = "NOM_DE_FAMILLE")
    private String familyName;

    @Column(name = "PRENOM")
    private String firstName;

    @Column(name = "MOT_DE_PASSE")
    private String password;

    @Column(name = "MATRICULE")
    private String matricule;

//	@NotNull
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation = new Date();

    @Column(name = "DATE_DERNIERE_CONNEXION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDerniereConnexion;

    @ManyToOne(optional = true)
    @JoinColumn(name = "IDENTIFIANT_BANQUE_FK", referencedColumnName = "IDENTIFIANT_BANQUE")
    private Banque_Cellocash banqueCellocash;

    @ManyToOne(optional = true)
    @JoinColumn(name = "TYPE_AGENCE_BANCAIRE_FK", referencedColumnName = "IDENTIFIANT_AGENCE")
    private Agence_Bancaire agenceBancaire;

    public User() {
    }

    @Override
    public int hashCode() {
        return getUserName().hashCode();
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateDerniereConnexion() {
        return dateDerniereConnexion;
    }

    public void setDateDerniereConnexion(Date dateDerniereConnexion) {
        this.dateDerniereConnexion = dateDerniereConnexion;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (getUserName() == null) {
            if (other.getUserName() != null) {
                return false;
            }
        } else if (!getUserName().equals(other.getUserName())) {
            return false;
        }
        return true;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = DigestUtils.md5Hex(password);
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public boolean hasRole(String role) {
        if (getRole() == null) {
            return false;
        } else if (getRole().getDesignation().equals(role)) {
            return true;
        }

        return false;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getAlerte() {
        return alerte;
    }

    public void setAlerte(int alerte) {
        this.alerte = alerte;
    }

    public Banque_Cellocash getBanqueCellocash() {
        return banqueCellocash;
    }

    public void setBanqueCellocash(Banque_Cellocash banqueCellocash) {
        this.banqueCellocash = banqueCellocash;
    }

    public Agence_Bancaire getAgenceBancaire() {
        return agenceBancaire;
    }

    public void setAgenceBancaire(Agence_Bancaire agenceBancaire) {
        this.agenceBancaire = agenceBancaire;
    }

    public boolean isFirstConnection() {
        return firstConnection;
    }

    public void setFirstConnection(boolean firstConnection) {
        this.firstConnection = firstConnection;
    }

}
