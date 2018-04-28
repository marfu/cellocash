/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.beans;

import com.celloCashAdmin.bean.lazyModel.lazyLigneCommissionClientModel;
import com.cellocash.model.Agence_Bancaire;
import com.cellocash.model.Banque_Cellocash;
import com.cellocash.model.Commissions_Client;
import com.cellocash.model.Ligne_Commission_Client;
import com.cellocash.model.OperationCelloCash;

import com.cellocash.model.Pays;
import com.cellocash.model.services.IAgenceBancaireService;
import com.cellocash.model.services.IBanqueCelloCashService;
import com.cellocash.model.services.ICommissionClientService;
import com.cellocash.model.services.ILigneCommissionClientService;
import com.cellocash.model.services.IOperationCelloCashService;
import com.cellocash.model.services.IPaysService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author manukey
 */
@Named(value = "ligneCommissionclientBean")
@ViewScoped
public class LigneCommissionClientBean implements Serializable {

    @EJB
    private IAgenceBancaireService agenceBancaireService;
    @EJB
    private IPaysService paysService;
    @EJB
    private ICommissionClientService commissionClientService;
    @EJB
    private IBanqueCelloCashService banqueCelloCashService;
    @EJB
    private IOperationCelloCashService operationCelloCashService;
    @EJB
    private ILigneCommissionClientService ligneCommissionClientService;

    private Agence_Bancaire agenceBancaire;
    private Banque_Cellocash banqueCellocash;
    private Commissions_Client commissionsClient;
    private Pays pays;
    private Ligne_Commission_Client lcc=new Ligne_Commission_Client();
    private OperationCelloCash operationCellocash;
    private List<Pays> listePays;
    private List<Commissions_Client> listCommissionClient;
    private List<Agence_Bancaire> listAgenceBancaire;
    private List<Banque_Cellocash> listeBanqueCellocashs;
    private List<OperationCelloCash> listeOperationCellocash;
    private List<Ligne_Commission_Client> listeLigneCommissionClients;
    private LazyDataModel<Ligne_Commission_Client> lazyModel;

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

    public Commissions_Client getCommissionsClient() {
        return commissionsClient;
    }

    public void setCommissionsClient(Commissions_Client commissionsClient) {
        this.commissionsClient = commissionsClient;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Ligne_Commission_Client getLcc() {
        return lcc;
    }

    public void setLcc(Ligne_Commission_Client lcc) {
        this.lcc = lcc;
    }

    public OperationCelloCash getOperationCellocash() {
        return operationCellocash;
    }

    public void setOperationCellocash(OperationCelloCash operationCellocash) {
        this.operationCellocash = operationCellocash;
    }

    public List<Pays> getListePays() {
        listePays = paysService.getAllPays();
        return listePays;
    }

    public void setListePays(List<Pays> listePays) {
        this.listePays = listePays;
    }

    public List<Commissions_Client> getListCommissionClient() {
        return listCommissionClient;
    }

    public void setListCommissionClient(List<Commissions_Client> listCommissionClient) {
        this.listCommissionClient = listCommissionClient;
    }

    public List<Banque_Cellocash> getListeBanqueCellocashs() {
        return listeBanqueCellocashs;
    }

    public void setListeBanqueCellocashs(List<Banque_Cellocash> listeBanqueCellocashs) {
        this.listeBanqueCellocashs = listeBanqueCellocashs;
    }

    public List<OperationCelloCash> getListeOperationCellocash() {
        //listeOperationCellocash = operationCelloCashService.findAll();
        return listeOperationCellocash;
    }

    public void setListeOperationCellocash(List<OperationCelloCash> listeOperationCellocash) {
        this.listeOperationCellocash = listeOperationCellocash;
    }

    public List<Agence_Bancaire> getListAgenceBancaire() {
        return listAgenceBancaire;
    }

    public void setListAgenceBancaire(List<Agence_Bancaire> listAgenceBancaire) {
        this.listAgenceBancaire = listAgenceBancaire;
    }

    public List<Ligne_Commission_Client> getListeLigneCommissionClients() {
        return listeLigneCommissionClients;
    }

    public void setListeLigneCommissionClients(List<Ligne_Commission_Client> listeLigneCommissionClients) {
        this.listeLigneCommissionClients = listeLigneCommissionClients;
    }

    public LazyDataModel<Ligne_Commission_Client> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Ligne_Commission_Client> lazyModel) {
        this.lazyModel = lazyModel;
    }

    @PostConstruct
    public void init() {

        lazyModel = new lazyLigneCommissionClientModel();

    }

    public void loadlistedesBanques() {

        //System.out.println("fdffdfd");
      //  listeBanqueCellocashs = banqueCelloCashService.findAllByPays(pays.getId());
       // System.out.println("bbbbb " + listeBanqueCellocashs.toString());
    }

    public void loadlistedesAgences() {
    
      //  listAgenceBancaire = agenceBancaireService.findAllByBanque(banqueCellocash.getId());
         
    }

    public void loadlistedesCommissions() {
      //  System.out.println("fdffdfd");
        listCommissionClient = commissionClientService.findAllBanqueCelloAndAgenceBancaire(banqueCellocash.getId(), agenceBancaire.getId());
  // System.out.println("bbbbb " + listCommissionClient.toString());
    }
    public void loadtest() {
      //  System.out.println("fdffdfd");
      lcc.setOperationCellocah(operationCellocash);
        System.out.println("lcc "+lcc.toString());
  // System.out.println("bbbbb " + listCommissionClient.toString());
    }

    public void search() {

        listeLigneCommissionClients = ligneCommissionClientService.findAllbyCommissionClientAndOperation(commissionsClient.getId(), operationCellocash.getId());
    }

    public void clearEntity(ActionEvent actionEvent) {

        lcc = new Ligne_Commission_Client();
        agenceBancaire = new Agence_Bancaire();
        banqueCellocash = new Banque_Cellocash();
        commissionsClient = new Commissions_Client();

    }
    
    public void createOrUpdate(ActionEvent actionEvent){
//        System.out.println("bbbcccc "+lcc.toString());
        System.out.println("bbbcccc ");
//        ligneCommissionClientService.createOrUpdate(lcc);
//        lcc=new Ligne_Commission_Client();
//        RequestContext contextClose = RequestContext.getCurrentInstance();
//        contextClose.execute("PF('dlg2').hide();");
    }

    
    
    public void test(){
         System.out.println("vvvvvvvv ");
    }
}
