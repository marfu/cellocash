/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.beans;

import com.celloCashAdmin.bean.lazyModel.LazyAgenceBancaireModel;
import com.celloCashAdmin.bean.lazyModel.LazyBanqueCelloCashModel;
import com.celloCashAdmin.bean.lazyModel.lazyCommissionTaxeModel;
import com.cellocash.model.Agence_Bancaire;
import com.cellocash.model.Banque_Cellocash;
import com.cellocash.model.Commission_Taxe;
import com.cellocash.model.Pays;
import com.cellocash.model.services.IAgenceBancaireService;
import com.cellocash.model.services.IBanqueCelloCashService;
import com.cellocash.model.services.ICommissionTaxeService;
import com.cellocash.model.services.IPaysService;
import java.io.Serializable;
import java.util.List;
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
@Named(value = "commissionTaxeBean")
@ViewScoped
public class CommissionTaxeBean implements Serializable{
     @EJB
    private IAgenceBancaireService agenceBancaireService;
    @EJB
    private ICommissionTaxeService commissionTaxeService;
    @EJB
    private IBanqueCelloCashService banqueCelloCashService;
    @EJB
    private IPaysService paysService;
    
    private Commission_Taxe commissionTaxe;
    private Agence_Bancaire agenceBancaire;
    private Banque_Cellocash banqueCellocash;
    private String codeCT ;//ct=commission_taxe
    private long idAgenceB;
    private long idBanqueCello;
       private List<Pays> listePays;
  
    private List<Agence_Bancaire> listAgenceBancaire;
    private List<Banque_Cellocash> listeBanqueCellocashs;
    private LazyDataModel<Commission_Taxe> lazyModel;
    private LazyDataModel<Agence_Bancaire> lazyModelAgenceBancaire;
    private LazyDataModel<Banque_Cellocash> lazyModelBanqueCellocashs;
    private Pays pays;

    public Commission_Taxe getCommissionTaxe() {
        return commissionTaxe;
    }

    public void setCommissionTaxe(Commission_Taxe commissionTaxe) {
        this.commissionTaxe = commissionTaxe;
    }

    public String getCodeCT() {
        return codeCT;
    }

    public void setCodeCT(String codeCT) {
        this.codeCT = codeCT;
    }

    public LazyDataModel<Commission_Taxe> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Commission_Taxe> lazyModel) {
        this.lazyModel = lazyModel;
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
     public List<Pays> getListePays() {
         listePays = paysService.getAllPays();
        return listePays;
    }

    public void setListePays(List<Pays> listePays) {
        this.listePays = listePays;
    }

    

    public List<Agence_Bancaire> getListAgenceBancaire() {
        return listAgenceBancaire;
    }

    public void setListAgenceBancaire(List<Agence_Bancaire> listAgenceBancaire) {
        this.listAgenceBancaire = listAgenceBancaire;
    }

    public List<Banque_Cellocash> getListeBanqueCellocashs() {
        return listeBanqueCellocashs;
    }

    public void setListeBanqueCellocashs(List<Banque_Cellocash> listeBanqueCellocashs) {
        this.listeBanqueCellocashs = listeBanqueCellocashs;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
     
     
      @PostConstruct
    public void init() {
 
        
        lazyModel = new lazyCommissionTaxeModel();
        //lazyModelBanqueCellocashs = new LazyBanqueCelloCashModel();
        
    }
    
    public void detail(ActionEvent actionEvent) {
        
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCommissionTaxe");

        commissionTaxe = commissionTaxeService.getDetail(Long.parseLong(id));
//        banqueCellocash=banqueCelloCashService.findById(commissionsClient.)
pays=commissionTaxe.getBanqueCellocash().getPays();
loadlistedesBanques();

        banqueCellocash=commissionTaxe.getBanqueCellocash();
        loadlistedesAgences();
     //   agenceBancaire=commissionTaxe.getAgenceBancaire();
        
        
        
        
        System.out.println("agenceBancaire"+agenceBancaire.toString());

    }
    
    public void selectlistbanque(ActionEvent actionEvent){
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idBanque");
        banqueCellocash=banqueCelloCashService.getDetail(Long.parseLong(id));
        agenceBancaire=new Agence_Bancaire();
        
        //fermer le contexte
        RequestContext contextClose = RequestContext.getCurrentInstance();
        contextClose.execute("PF('dlgBanque').hide();");
    }
    public void selectlistAgence(ActionEvent actionEvent){
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idAgence");
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
        
      //  commissionTaxe.setAgenceBancaire(agenceBancaire);
        commissionTaxe.setBanqueCellocash(banqueCellocash);
        System.out.println("aaaaaaa===="+commissionTaxe.toString());
        System.out.println("agenceBancaire===="+agenceBancaire.toString());
        System.out.println("banqueCellocash===="+banqueCellocash.toString());
        commissionTaxeService.createOrUpdate(commissionTaxe);
         RequestContext contextClose = RequestContext.getCurrentInstance();
        contextClose.execute("PF('dlg2').hide();");
//        return "success";
    }
    public void clearEntity(ActionEvent actionEvent) {

        commissionTaxe = new Commission_Taxe();
        agenceBancaire=new Agence_Bancaire();
        banqueCellocash=new Banque_Cellocash();
        pays=new Pays();
        

    }
    
    
     public void loadlistedesBanques() {

        //System.out.println("fdffdfd");
        listeBanqueCellocashs = banqueCelloCashService.findAllByPays(pays.getId());
       // System.out.println("bbbbb " + listeBanqueCellocashs.toString());
    }

    public void loadlistedesAgences() {
    
        listAgenceBancaire = agenceBancaireService.findAllByBanque(banqueCellocash.getId());
         
    }

    
    
    
     
}