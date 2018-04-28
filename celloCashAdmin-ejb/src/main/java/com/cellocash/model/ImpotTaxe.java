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
public class ImpotTaxe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDENTIFIANT_IMPOT_TAXE")
    private Long id;
    @Column(name = "CODE_IMPOT_TAXE")
    private String code;
    @Column(name = "DESIGNATION_IMPOT_TAXE", length = 200)
    private String designation;
    
      @ManyToOne
    @JoinColumn(name = "IDENTIFIANT_TYPE_IMPOT_TAXE_FK", referencedColumnName = "IDENTIFIANT_TYPE_IMPOT_TAXE")
    private TypeImpotTaxe typeImpotTaxe;
    
 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

 

    public TypeImpotTaxe getTypeImpotTaxe() {
        return typeImpotTaxe;
    }

    public void setTypeImpotTaxe(TypeImpotTaxe typeImpotTaxe) {
        this.typeImpotTaxe = typeImpotTaxe;
    }
    
    

  
}