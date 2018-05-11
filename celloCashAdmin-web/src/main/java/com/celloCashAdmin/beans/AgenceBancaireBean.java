/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.beans;

import com.celloCashAdmin.bean.lazyModel.LazyAgenceBancaireModel;
import com.cellocash.model.Agence_Bancaire;
import com.cellocash.model.Banque_Cellocash;

import com.cellocash.model.Pays;
import com.cellocash.model.Type_Agence_Bancaire;
import com.cellocash.model.services.IAgenceBancaireService;
import com.cellocash.model.services.IBanqueCelloCashService;
import com.cellocash.model.services.ICommissionBusinessService;
import com.cellocash.model.services.IPaysService;
import com.cellocash.model.services.ITypeAgenceBancaireService;
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
@Named(value = "agenceBancaireBean")
@ViewScoped
public class AgenceBancaireBean implements Serializable {

    @EJB
    private IAgenceBancaireService agenceBancaireService;
    @EJB
    private IPaysService paysService;
    @EJB
    private ITypeAgenceBancaireService typeAgenceBancaireService;

    @EJB
    private IBanqueCelloCashService banqueCelloCashService;

    private LazyDataModel<Agence_Bancaire> lazyModel;
    private Agence_Bancaire selectedAgenceBancaire;
    private Agence_Bancaire agenceBancaire;
    private List<Pays> listePays;
    private List<Type_Agence_Bancaire> listeTypeAgenceBancaire;
    private String id;
    private Long idPays;

    private List<Agence_Bancaire> listeAgenceBancaire;

    
    
    public Long getIdPays() {
        return idPays;
    }

    public void setIdPays(Long idPays) {
        this.idPays = idPays;
    }
    
    
    

    public List<Pays> getListePays() {

        return listePays = paysService.getAllPays();
    }

    public void setListePays(List<Pays> listePays) {
        this.listePays = listePays;
    }

    public List<Type_Agence_Bancaire> getListeTypeAgenceBancaire() {

        return listeTypeAgenceBancaire = typeAgenceBancaireService.getAllTypeAgenceBancaire();
    }

    public void setListeTypeAgenceBancaire(List<Type_Agence_Bancaire> listeTypeAgenceBancaire) {
        this.listeTypeAgenceBancaire = listeTypeAgenceBancaire;
    }

    public LazyDataModel<Agence_Bancaire> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Agence_Bancaire> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public Agence_Bancaire getSelectedAgenceBancaire() {
        return selectedAgenceBancaire;
    }

    public void setSelectedAgenceBancaire(Agence_Bancaire selectedAgenceBancaire) {
        this.selectedAgenceBancaire = selectedAgenceBancaire;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Agence_Bancaire> getListeAgenceBancaire() {
        
        return listeAgenceBancaire=agenceBancaireService.findAll();
    }

    public void setListeAgenceBancaire(List<Agence_Bancaire> listeAgenceBancaire) {
        this.listeAgenceBancaire = listeAgenceBancaire;
    }

    
    
    
    
    @PostConstruct
    public void init() {
        System.out.println("Liste agence bancaire par banque cello cash ");
        System.out.println("called");
        selectedAgenceBancaire = new Agence_Bancaire();
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        if (id != null && !id.trim().equals("")) {
            System.out.println("id===========" + id);
            // long ids = Long.valueOf(id);
            //listImei = imeiService.listAllByTypeLIst(ids);
        } else {
            System.out.println("==========id===========" + id);
        }
        //return listImei;
        //lazyModel = new LazyAgenceBancaireModel(Long.valueOf(id));
        lazyModel = new LazyAgenceBancaireModel();
        System.out.println("liste agence bancaire ====================================" + lazyModel);
    }

    public void newItem(ActionEvent actionEvent) {
        System.out.println("Clear");
        clearEntity();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(
                null,
                new FacesMessage("Creation d'une agence bancaire",
                        "veuillez saisir les informations d\u00E9finissant le nouvel utilisateur"));
    }

    private void clearEntity() {

        selectedAgenceBancaire = new Agence_Bancaire();

        // sourcePvt = pointDeVenteService.getAllPVTActive();
        //targetPvt = new ArrayList<>();
    }

    public void save() {
        System.out.println("==================================== Insert agence bancaire" + selectedAgenceBancaire.toString());

        //Banque_Cellocash banqueCelloCash = banqueCelloCashService.getDetail(Long.valueOf(id));
        //selectedAgenceBancaire.setBanqueCellocash(banqueCelloCash);
        selectedAgenceBancaire = agenceBancaireService.createOrUpdate(selectedAgenceBancaire);
        //lazyModel = new LazyAgenceBancaireModel();
        clearEntity();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(
                "Banque cr\u00E9er/maj avec succ\u00E8s", "la banque "
                + selectedAgenceBancaire.getDesignation()
                + " a \u00E9t\u00E9 sauvegarder/maj avec succ\u00E8s."));

        RequestContext contextClose = RequestContext.getCurrentInstance();
        contextClose.execute("PF('dlg2').hide();");

    }

    public void detail(ActionEvent actionEvent) {
        System.out.println("detail banque ====================================");
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idAgenceBancaire");

        selectedAgenceBancaire = agenceBancaireService.getDetail(Long.parseLong(id));

    }
    
      public void selectBanque() {
        Banque_Cellocash banque = banqueCelloCashService.getDetail(selectedAgenceBancaire.getBanqueCellocash().getId());
        //codeRegion = null;

        selectedAgenceBancaire.setPrefixeCpteOrdinaire(banque.getPrefixeCpteOrdinaire());
        selectedAgenceBancaire.setPrefixeCpteneEparg(banque.getPrefixeCpteneEparg());
        
    }
}
