/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.beans;

import com.celloCashAdmin.bean.lazyModel.LazyCommissionLigneBusinessModel;
import com.cellocash.model.Banque_Cellocash;

import com.cellocash.model.Commission_Ligne_Business;
import com.cellocash.model.dto.CommissionBusinessDTO;

import com.cellocash.model.services.ICommissionLigneBusinessService;
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
@Named(value = "commissionLigneBusinessBean")
@ViewScoped
public class CommissionLigneBusinessBean implements Serializable {

    @EJB
    private ICommissionLigneBusinessService commissionLigneBusinessService;
    

    private LazyDataModel<CommissionBusinessDTO> lazyModel;
    private Commission_Ligne_Business selectedComissionBusiness;
    private List<Banque_Cellocash> listBanque;
    private Long idPays;

    public List<Banque_Cellocash> getListBanque() {
        return listBanque;
    }

    public void setListBanque(List<Banque_Cellocash> listBanque) {
        this.listBanque = listBanque;
    }

   

   

    public Long getIdPays() {
        return idPays;
    }

    public void setIdPays(Long idPays) {
        this.idPays = idPays;
    }

    public Commission_Ligne_Business getSelectedComissionBusiness() {
        return selectedComissionBusiness;
    }

    public void setSelectedComissionBusiness(Commission_Ligne_Business selectedComissionBusiness) {
        this.selectedComissionBusiness = selectedComissionBusiness;
    }

    public LazyDataModel<CommissionBusinessDTO> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<CommissionBusinessDTO> lazyModel) {
        this.lazyModel = lazyModel;
    }

    @PostConstruct
    public void init() {
        System.out.println("Liste Banque cello cash ");
        selectedComissionBusiness = new Commission_Ligne_Business();
        //return listImei;
        
        lazyModel = new LazyCommissionLigneBusinessModel();
        System.out.println("liste banque ====================================" + lazyModel);
    }

    public void changePays() {
        //listBanque = departementService.findByRegion(codeRegion);
    }

    public void newItem(ActionEvent actionEvent) {
        System.out.println("Clear");
        clearEntity();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(
                null,
                new FacesMessage("Ajout d'une commission business"));
    }

    private void clearEntity() {

        selectedComissionBusiness = new Commission_Ligne_Business();

        // sourcePvt = pointDeVenteService.getAllPVTActive();
        //targetPvt = new ArrayList<>();
    }

    public void save() {
        System.out.println("==================================== Insert agence bancaire" + selectedComissionBusiness.toString());

        //Banque_Cellocash banqueCelloCash = banqueCelloCashService.getDetail(Long.valueOf(id));
        //selectedAgenceBancaire.setBanqueCellocash(banqueCelloCash);
        selectedComissionBusiness = commissionLigneBusinessService.createOrUpdate(selectedComissionBusiness);
        //lazyModel = new LazyAgenceBancaireModel();
        clearEntity();

        RequestContext contextClose = RequestContext.getCurrentInstance();
        contextClose.execute("PF('dlg2').hide();");

    }

    public void detail(ActionEvent actionEvent) {
        System.out.println("detail banque ====================================");
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCommissionBusiness");

        selectedComissionBusiness = commissionLigneBusinessService.getDetail(Long.parseLong(id));

    }
}
