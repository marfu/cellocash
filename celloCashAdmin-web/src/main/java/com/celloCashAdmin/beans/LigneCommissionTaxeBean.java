/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.beans;

import com.celloCashAdmin.bean.lazyModel.LazyAgenceBancaireModel;
import com.celloCashAdmin.bean.lazyModel.LazyBanqueCelloCashModel;
import com.celloCashAdmin.bean.lazyModel.lazyCommissionTaxeModel;
import com.celloCashAdmin.bean.lazyModel.lazyLigneCommissionTaxeModel;
import com.cellocash.model.Agence_Bancaire;
import com.cellocash.model.Banque_Cellocash;
import com.cellocash.model.Commission_Taxe;
import com.cellocash.model.ImpotTaxe;
import com.cellocash.model.Ligne_Commission_Taxe;
import com.cellocash.model.OperationCelloCash;
import com.cellocash.model.Pays;
import com.cellocash.model.TypeImpotTaxe;
import com.cellocash.model.services.IAgenceBancaireService;
import com.cellocash.model.services.IBanqueCelloCashService;
import com.cellocash.model.services.ICommissionTaxeService;
import com.cellocash.model.services.IImpotTaxeService;
import com.cellocash.model.services.ILigneCommissionTaxeService;
import com.cellocash.model.services.IOperationCelloCashService;
import com.cellocash.model.services.IPaysService;
import com.cellocash.model.services.ITypeImpotTaxeService;
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
@Named(value = "ligneCommissionTaxeBean")
@ViewScoped
public class LigneCommissionTaxeBean implements Serializable {

    @EJB
    private IAgenceBancaireService agenceBancaireService;
    @EJB
    private ILigneCommissionTaxeService ligneCommissionTaxeService;
    @EJB
    private ICommissionTaxeService commissionTaxeService;
    @EJB
    private IBanqueCelloCashService banqueCelloCashService;
    @EJB
    private IPaysService paysService;
    @EJB
    private IImpotTaxeService impotTaxeService;
    @EJB
    private ITypeImpotTaxeService typeImpotTaxeService;
    @EJB
    private IOperationCelloCashService operationCelloCashService;

    private Ligne_Commission_Taxe ligneCommissionTaxe;
    private Commission_Taxe commissionTaxe;
    private Agence_Bancaire agenceBancaire;
    private Banque_Cellocash banqueCellocash;
    private OperationCelloCash operationCellocash;


    private List<Pays> listePays;
    private List<TypeImpotTaxe> listeTypeImpotTaxe;
    private List<ImpotTaxe> listeImpotTaxe;

    private List<Commission_Taxe> listCommissionTaxe;
    private List<OperationCelloCash> listOperationCellocash;
    private List<Agence_Bancaire> listAgenceBancaire;
    private List<Banque_Cellocash> listeBanqueCellocashs;
    private LazyDataModel<Ligne_Commission_Taxe> lazyModel;

    private Pays pays;
    private ImpotTaxe importTaxe;
    private TypeImpotTaxe typeImportTaxe;

    public Commission_Taxe getCommissionTaxe() {
        return commissionTaxe;
    }

    public void setCommissionTaxe(Commission_Taxe commissionTaxe) {
        this.commissionTaxe = commissionTaxe;
    }

   

    public LazyDataModel<Ligne_Commission_Taxe> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Ligne_Commission_Taxe> lazyModel) {
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

    public Ligne_Commission_Taxe getLigneCommissionTaxe() {
        return ligneCommissionTaxe;
    }

    public void setLigneCommissionTaxe(Ligne_Commission_Taxe ligneCommissionTaxe) {
        this.ligneCommissionTaxe = ligneCommissionTaxe;
    }

    public List<ImpotTaxe> getListeImpotTaxe() {
        return listeImpotTaxe;
    }

    public void setListeImpotTaxe(List<ImpotTaxe> listeImpotTaxe) {
        this.listeImpotTaxe = listeImpotTaxe;
    }

    public ImpotTaxe getImportTaxe() {
        return importTaxe;
    }

    public void setImportTaxe(ImpotTaxe importTaxe) {
        this.importTaxe = importTaxe;
    }

    public OperationCelloCash getOperationCellocash() {
        return operationCellocash;
    }

    public void setOperationCellocash(OperationCelloCash operationCellocash) {
        this.operationCellocash = operationCellocash;
    }

    public List<OperationCelloCash> getListOperationCellocash() {
        return listOperationCellocash;
    }

    public void setListOperationCellocash(List<OperationCelloCash> listOperationCellocash) {
        this.listOperationCellocash = listOperationCellocash;
    }

    public List<Commission_Taxe> getListCommissionTaxe() {
        return listCommissionTaxe;
    }

    public void setListCommissionTaxe(List<Commission_Taxe> listCommissionTaxe) {
        this.listCommissionTaxe = listCommissionTaxe;
    }

    public List<TypeImpotTaxe> getListeTypeImpotTaxe() {
        listeTypeImpotTaxe=typeImpotTaxeService.getAllType();
        return listeTypeImpotTaxe;
    }

    public void setListeTypeImpotTaxe(List<TypeImpotTaxe> listeTypeImpotTaxe) {
        this.listeTypeImpotTaxe = listeTypeImpotTaxe;
    }

    public TypeImpotTaxe getTypeImportTaxe() {
        return typeImportTaxe;
    }

    public void setTypeImportTaxe(TypeImpotTaxe typeImportTaxe) {
        this.typeImportTaxe = typeImportTaxe;
    }

    
    
    
    
    @PostConstruct
    public void init() {

        lazyModel = new lazyLigneCommissionTaxeModel();
        //lazyModelBanqueCellocashs = new LazyBanqueCelloCashModel();

    }

    public void detail(ActionEvent actionEvent) {

        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idligneCommissionTaxe");

        ligneCommissionTaxe = ligneCommissionTaxeService.getDetail(Long.parseLong(id));
        banqueCellocash=ligneCommissionTaxe.getCommissionTaxe().getBanqueCellocash();
        commissionTaxe=ligneCommissionTaxe.getCommissionTaxe();
        importTaxe=ligneCommissionTaxe.getImpotTaxe();
        typeImportTaxe=importTaxe.getTypeImpotTaxe();
        
        pays = banqueCellocash.getPays();
        loadlistedesBanques();
        loadlistedesCommissions();
        loadlistedesImpot();
        loadlistedesAgences();
//        agenceBancaire = commissionTaxe.getAgenceBancaire();

        System.out.println("agenceBancaire" + agenceBancaire.toString());

    }

//    public void selectlistbanque(ActionEvent actionEvent) {


    public void createOrUpdate() {

        ligneCommissionTaxe.setCommissionTaxe(commissionTaxe);
        ligneCommissionTaxe.setOperationCellocah(operationCellocash);
        ligneCommissionTaxe.setImpotTaxe(importTaxe);
       
        ligneCommissionTaxeService.createOrUpdate(ligneCommissionTaxe);
        RequestContext contextClose = RequestContext.getCurrentInstance();
        contextClose.execute("PF('dlg2').hide();");

System.out.println("manukey");
//        return "success";
    }

    public void clearEntity(ActionEvent actionEvent) {

        
        commissionTaxe = new Commission_Taxe();
        agenceBancaire = new Agence_Bancaire();
        banqueCellocash = new Banque_Cellocash();
        pays = new Pays();
        typeImportTaxe = new TypeImpotTaxe ();
        importTaxe=new ImpotTaxe();
        ligneCommissionTaxe=new Ligne_Commission_Taxe();

    }

    public void loadlistedesBanques() {

        //System.out.println("fdffdfd");
        listeBanqueCellocashs = banqueCelloCashService.findAllByPays(pays.getId());
        // System.out.println("bbbbb " + listeBanqueCellocashs.toString());
    }

    public void loadlistedesAgences() {

        listAgenceBancaire = agenceBancaireService.findAllByBanque(banqueCellocash.getId());
        System.out.println("listAgenceBancaire"+listAgenceBancaire.size());
        

    }
    public void loadlistedesImpot() {

        listeImpotTaxe = impotTaxeService.getAllImpotTaxeByTypeImpot(typeImportTaxe.getId());
        System.out.println("listeImpotTaxe"+listeImpotTaxe.size());
        

    }
    
    public void loadlistedesCommissions() {
      //  System.out.println("fdffdfd");
//        listCommissionTaxe = commissionTaxeService.findAllBanqueCello(banqueCellocash.getId());
        listCommissionTaxe = commissionTaxeService.findAllBanqueCello(banqueCellocash.getId());
  // System.out.println("bbbbb " + listCommissionClient.toString());
    }
   

}