/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.security.bean;

import com.celloCashAdmin.bean.lazyModel.LazyHistoriqueConnexionModel;
import com.cellocash.model.HistoriqueConnection;
import com.cellocash.model.services.IHistoriqueConnectionService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;

import javax.inject.Named;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author marfu
 */
@Named("historiqueBean")
@ViewScoped
public class HistoriqueBean implements Serializable {

    @EJB
    private IHistoriqueConnectionService historiqueService;

    private LazyDataModel<HistoriqueConnection> lazyModel;
    private List<HistoriqueConnection> selectedListHistoriqueConnection;

    public LazyDataModel<HistoriqueConnection> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<HistoriqueConnection> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public List<HistoriqueConnection> getSelectedListHistoriqueConnection() {
        return selectedListHistoriqueConnection;
    }

    public void setSelectedListHistoriqueConnection(List<HistoriqueConnection> selectedListHistoriqueConnection) {
        this.selectedListHistoriqueConnection = selectedListHistoriqueConnection;
    }
    
    @PostConstruct
    public void init() {
       
        lazyModel = new LazyHistoriqueConnexionModel();
        System.out.println("liste banque ====================================" + lazyModel);
    }
    
    

}
