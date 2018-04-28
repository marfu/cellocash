/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Sms_Operation_Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODE_SMS_FK", referencedColumnName = "CODE_SMS")
    private Sms_Operation SmsOperation;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODE_OPERATION_FK", referencedColumnName = "CODE_OPERATION")
    private OperationCelloCash operationCellocash;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sms_Operation getSmsOperation() {
        return SmsOperation;
    }

    public void setSmsOperation(Sms_Operation SmsOperation) {
        this.SmsOperation = SmsOperation;
    }

    public OperationCelloCash getOperationCellocash() {
        return operationCellocash;
    }

    public void setOperationCellocash(OperationCelloCash operationCellocash) {
        this.operationCellocash = operationCellocash;
    }

   
    
}
