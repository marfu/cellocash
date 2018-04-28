/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author marfu
 */
@Entity
public class Grossiste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NUMERO_TELEPHONE")
    private String numeroTelephone;
    
    @Column(name = "NOM_DISTRIBUTEUR")
    private String nomDistributeur;
    
    @Column(name = "NOM_GESTIONNAIRE")
    private String nomGestionnaire;
    
    @Column(name = "ADRESSE")
    private String adresse;
    
    @Column(name = "PHOTO_RCCM1")
    private String photoRccm1;
    @Column(name = "PHOTO_RCCM2")
    private String photoRccm2;

    @ManyToOne
    @JoinColumn(name = "IDENTIFIANT_BANQUE_FK", referencedColumnName = "IDENTIFIANT_AGENCE")
    private Agence_Bancaire agenceBancaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grossiste)) {
            return false;
        }
        Grossiste other = (Grossiste) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cellocash.model.Grossiste[ id=" + id + " ]";
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getNomDistributeur() {
        return nomDistributeur;
    }

    public void setNomDistributeur(String nomDistributeur) {
        this.nomDistributeur = nomDistributeur;
    }

    public String getNomGestionnaire() {
        return nomGestionnaire;
    }

    public void setNomGestionnaire(String nomGestionnaire) {
        this.nomGestionnaire = nomGestionnaire;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhotoRccm1() {
        return photoRccm1;
    }

    public void setPhotoRccm1(String photoRccm1) {
        this.photoRccm1 = photoRccm1;
    }

    public String getPhotoRccm2() {
        return photoRccm2;
    }

    public void setPhotoRccm2(String photoRccm2) {
        this.photoRccm2 = photoRccm2;
    }

    public Agence_Bancaire getAgenceBancaire() {
        return agenceBancaire;
    }

    public void setAgenceBancaire(Agence_Bancaire agenceBancaire) {
        this.agenceBancaire = agenceBancaire;
    }

}
