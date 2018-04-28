/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.beans;

import com.cellocash.model.OperationCelloCash;

import com.cellocash.model.services.IOperationCelloCashService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author marfu
 */
@Named(value = "operationCelloCashBean")
@ViewScoped
public class OperationCelloCashBean  implements Serializable{
    
    @EJB
    private IOperationCelloCashService operationCelloCashService;
    
    private List<OperationCelloCash>listOperationCellocash;

    public List<OperationCelloCash> getListOperationCellocash() {
        return listOperationCellocash=operationCelloCashService.getAll();
    }

    public void setListOperationCellocash(List<OperationCelloCash> listOperationCellocash) {
        this.listOperationCellocash = listOperationCellocash;
    }
    
    
    
}
