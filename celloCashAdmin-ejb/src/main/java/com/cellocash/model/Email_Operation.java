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

/**
 *
 * @author manukey
 */
@Entity
public class Email_Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDENTIFIANT_EMAIL", length = 5)
    private Long id;

    @Column(name = "OBJET_EMAIL", length = 50)
    private String objet;
    @Column(name = "CORPS_EMAIL")
    private String corps;
    @Column(name = "SIGNATURE_EMAIL")
    private String signature;
    @Column(name = "DESTINATION")
    private boolean destination;

    public Long getId() {
        return id;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public boolean isDestination() {
        return destination;
    }

    public void setDestination(boolean destination) {
        this.destination = destination;
    }
    
    
    
}
