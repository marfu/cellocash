/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.beans;

import com.celloCashAdmin.bean.lazyModel.LazyBanqueCelloCashModel;
import com.cellocash.model.Banque_Cellocash;
import com.cellocash.model.services.IBanqueCelloCashService;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author marfu
 */
@Named(value = "banqueCelloCashBean")
@ViewScoped
public class BanqueCelloCashBean implements Serializable {

    @EJB
    private IBanqueCelloCashService banqueCelloCashService;

    private LazyDataModel<Banque_Cellocash> lazyModel;
    private Banque_Cellocash selectedBanqueCellocash;
    private Banque_Cellocash banqueCelloCash;
    
    private List<Banque_Cellocash> selectedListBanqueCellocash;
    private List<Banque_Cellocash> allBanqueCelloCash;

    public List<Banque_Cellocash> getAllBanqueCelloCash() {
       return banqueCelloCashService.getAll();
       // return allBanqueCelloCash;
    }

    public void setAllBanqueCelloCash(List<Banque_Cellocash> allBanqueCelloCash) {
        this.allBanqueCelloCash = allBanqueCelloCash;
    }
    
    
    
    

    public Banque_Cellocash getSelectedBanqueCellocash() {
        return selectedBanqueCellocash;
    }

    public void setSelectedBanqueCellocash(Banque_Cellocash selectedBanqueCellocash) {
        this.selectedBanqueCellocash = selectedBanqueCellocash;
    }

    public Banque_Cellocash getBanqueCelloCash() {
        return banqueCelloCash;
    }

    public void setBanqueCelloCash(Banque_Cellocash banqueCelloCash) {
        this.banqueCelloCash = banqueCelloCash;
    }

    public LazyDataModel<Banque_Cellocash> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Banque_Cellocash> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    
    

    public List<Banque_Cellocash> getSelectedListBanqueCellocash() {
        return selectedListBanqueCellocash;
    }

    public void setSelectedListBanqueCellocash(List<Banque_Cellocash> selectedListBanqueCellocash) {
        this.selectedListBanqueCellocash = selectedListBanqueCellocash;
    }
    
    
    
    

    @PostConstruct
    public void init() {
        System.out.println("Liste Banque cello cash ");

        //return listImei;
        lazyModel = new LazyBanqueCelloCashModel();
        System.out.println("liste banque ====================================" + lazyModel);
    }

    public void newItem(ActionEvent actionEvent) {
        clearEntity();
       // FacesContext context = FacesContext.getCurrentInstance();
     //   context.addMessage(
      //          null,
     //           new FacesMessage("Creation utilisateur",
          //              "veuillez saisir les informations d\u00E9finissant le nouvel utilisateur"));
    }

    private void clearEntity() {

        selectedBanqueCellocash = new Banque_Cellocash();

        // sourcePvt = pointDeVenteService.getAllPVTActive();
        //targetPvt = new ArrayList<>();
    }

    public void save() {


        selectedBanqueCellocash = banqueCelloCashService.createOrUpdate(selectedBanqueCellocash);
        lazyModel = new LazyBanqueCelloCashModel();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(
                "Banque cr\u00E9er/maj avec succ\u00E8s", "la banque "
                + selectedBanqueCellocash.getNom()
                + " a \u00E9t\u00E9 sauvegarder/maj avec succ\u00E8s."));

        RequestContext contextClose = RequestContext.getCurrentInstance();
        contextClose.execute("PF('dlg2').hide();");

    }

    public void detail(ActionEvent actionEvent) {
        System.out.println("detail banque ====================================");
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idBanque");

        selectedBanqueCellocash = banqueCelloCashService.getDetail(Long.parseLong(id));

    }

}
