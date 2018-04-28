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
 * @author manukey
 */
@Entity
public class Banque_Cellocash implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "IDENTIFIANT_BANQUE")
    private Long id;

     @Column(name = "CODE_BANQUE",length = 5)
     private String code;
     @Column(name = "NOM_DE_LA_BANQUE")
     private String nom;
     @Column(name = "PREFIXE_COMPTE_ORDINAIRE")
     private int prefixeCpteOrdinaire;
    
     @Column(name = "PREFIXE_COMPTE_EPARGNE")
     private int prefixeCpteneEparg;
    
    
    @ManyToOne
    @JoinColumn(name = "IDENTIFIANT_PAYS_FK", referencedColumnName = "IDENTIFIANT_PAYS")
    private Pays pays;
    
    
    
    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrefixeCpteOrdinaire() {
        return prefixeCpteOrdinaire;
    }

    public void setPrefixeCpteOrdinaire(int prefixeCpteOrdinaire) {
        this.prefixeCpteOrdinaire = prefixeCpteOrdinaire;
    }

    public int getPrefixeCpteneEparg() {
        return prefixeCpteneEparg;
    }

    public void setPrefixeCpteneEparg(int prefixeCpteneEparg) {
        this.prefixeCpteneEparg = prefixeCpteneEparg;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
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
        if (!(object instanceof Banque_Cellocash)) {
            return false;
        }
        Banque_Cellocash other = (Banque_Cellocash) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Banque_Cellocash{" + "id=" + id + ", code=" + code + ", nom=" + nom + ", prefixeCpteOrdinaire=" + prefixeCpteOrdinaire + ", prefixeCpteneEparg=" + prefixeCpteneEparg + '}';
    }

   
    
}
