/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.beans;

import com.celloCashAdmin.bean.lazyModel.LazyAgenceBancaireModel;
import com.celloCashAdmin.bean.lazyModel.LazyBanqueCelloCashModel;
import com.celloCashAdmin.bean.lazyModel.lazyCommissionClientModel;
import com.cellocash.model.Agence_Bancaire;
import com.cellocash.model.Banque_Cellocash;
import com.cellocash.model.Commissions_Client;
import com.cellocash.model.Pays;
import com.cellocash.model.services.IAgenceBancaireService;
import com.cellocash.model.services.IBanqueCelloCashService;
import com.cellocash.model.services.ICommissionClientService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author manukey
 */
@Named(value = "commissionClientBean")
@ViewScoped
public class CommissionClientBean implements Serializable{
     @EJB
    private IAgenceBancaireService agenceBancaireService;
    @EJB
    private ICommissionClientService commissionClientService;
    @EJB
    private IBanqueCelloCashService banqueCelloCashService;
    
    private Commissions_Client commissionsClient;
    private Agence_Bancaire agenceBancaire;
    private Banque_Cellocash banqueCellocash;
    private String codeCC ;//cc=commission_client
    private long idAgenceB;
    private long idBanqueCello;
    private LazyDataModel<Commissions_Client> lazyModel;
    private LazyDataModel<Agence_Bancaire> lazyModelAgenceBancaire;
    private LazyDataModel<Banque_Cellocash> lazyModelBanqueCellocashs;

    public ICommissionClientService getCommissionClientService() {
        return commissionClientService;
    }

    public void setCommissionClientService(ICommissionClientService commissionClientService) {
        this.commissionClientService = commissionClientService;
    }

    public Commissions_Client getCommissionsClient() {
        return commissionsClient;
    }

    public void setCommissionsClient(Commissions_Client commissionsClient) {
        this.commissionsClient = commissionsClient;
    }

    public String getCodeCC() {
        return codeCC;
    }

    public void setCodeCC(String codeCC) {
        this.codeCC = codeCC;
    }

    public long getIdAgenceB() {
        return idAgenceB;
    }

    public void setIdAgenceB(long idAgenceB) {
        this.idAgenceB = idAgenceB;
    }

    public long getIdBanqueCello() {
        return idBanqueCello;
    }

    public void setIdBanqueCello(long idBanqueCello) {
        this.idBanqueCello = idBanqueCello;
    }

    public LazyDataModel<Commissions_Client> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Commissions_Client> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public Agence_Bancaire getAgenceBancaire() {
        return agenceBancaire;
    }

    public void setAgenceBancaire(Agence_Bancaire agenceBancaire) {
        this.agenceBancaire = agenceBancaire;
    }

    public Banque_Cellocash getBanqueCellocash() {
        return banqueCellocash;
    }

    public void setBanqueCellocash(Banque_Cellocash banqueCellocash) {
        this.banqueCellocash = banqueCellocash;
    }

    public LazyDataModel<Agence_Bancaire> getLazyModelAgenceBancaire() {
        return lazyModelAgenceBancaire;
    }

    public void setLazyModelAgenceBancaire(LazyDataModel<Agence_Bancaire> lazyModelAgenceBancaire) {
        this.lazyModelAgenceBancaire = lazyModelAgenceBancaire;
    }

    public LazyDataModel<Banque_Cellocash> getLazyModelBanqueCellocashs() {
        return lazyModelBanqueCellocashs;
    }

    public void setLazyModelBanqueCellocashs(LazyDataModel<Banque_Cellocash> lazyModelBanqueCellocashs) {
        this.lazyModelBanqueCellocashs = lazyModelBanqueCellocashs;
    }
     
     
     
      @PostConstruct
    public void init() {
 
        
        lazyModel = new lazyCommissionClientModel();
        lazyModelBanqueCellocashs = new LazyBanqueCelloCashModel();
        
    }
    
    public void detail(ActionEvent actionEvent) {
        
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCommissionClient");

        commissionsClient = commissionClientService.getDetail(Long.parseLong(id));
//        banqueCellocash=banqueCelloCashService.findById(commissionsClient.)
        banqueCellocash=commissionsClient.getBanqueCellocash();
        agenceBancaire=commissionsClient.getAgenceBancaire();

    }
    
    public void selectlistbanque(ActionEvent actionEvent){
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idBanque");
        //banqueCellocash=banqueCelloCashService.findById(Long.parseLong(id));
        banqueCellocash=banqueCelloCashService.getDetail(Long.parseLong(id));
        agenceBancaire=new Agence_Bancaire();
        
        //fermer le contexte
        RequestContext contextClose = RequestContext.getCurrentInstance();
        contextClose.execute("PF('dlgBanque').hide();");
    }
    public void selectlistAgence(ActionEvent actionEvent){
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idAgence");
        //agenceBancaire=agenceBancaireService.findbyId(Long.parseLong(id));
        agenceBancaire=agenceBancaireService.getDetail(Long.parseLong(id));
         RequestContext contextClose = RequestContext.getCurrentInstance();
        contextClose.execute("PF('dlgAgence').hide();");
        
        
        //fermer le contexte
    }
    public void detailListAgence(ActionEvent actionEvent){
        if(banqueCellocash.getId()!=null){
             lazyModelAgenceBancaire = new LazyAgenceBancaireModel(banqueCellocash.getId());
        }
       
        
    }
    public void detailListBanque(ActionEvent actionEvent){
        System.out.println("manukey");
        lazyModelBanqueCellocashs = new LazyBanqueCelloCashModel();
         System.out.println("don"+lazyModelBanqueCellocashs.getRowCount());
        
    }
    
    public void createOrUpdate(){
        
        commissionsClient.setAgenceBancaire(agenceBancaire);
        commissionsClient.setBanqueCellocash(banqueCellocash);
        System.out.println("aaaaaaa===="+commissionsClient.toString());
        System.out.println("agenceBancaire===="+agenceBancaire.toString());
        System.out.println("banqueCellocash===="+banqueCellocash.toString());
        commissionClientService.createOrUpdate(commissionsClient);
         RequestContext contextClose = RequestContext.getCurrentInstance();
        contextClose.execute("PF('dlg2').hide();");
//        return "success";
    }
    public void clearEntity(ActionEvent actionEvent) {

        commissionsClient = new Commissions_Client();
        agenceBancaire=new Agence_Bancaire();
        banqueCellocash=new Banque_Cellocash();
        

    }
     
}
