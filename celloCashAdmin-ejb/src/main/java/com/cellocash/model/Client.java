/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author manukey
 */
@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENT", length = 5)
    private Long id;
    @Column(name = "NUMERO_DE_TELEPHONE", length = 15)
    private String numeroTelepone;
    @Column(name = "NOM_CLIENT", length = 20)
    private String nom;
    @Column(name = "PRENOM_CLIENT", length = 50)
    private String prenom;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_PIECE")
    private TypePieceEnum typePiece;
    @Column(name = "NUMERO_DE_LA_PIECE", length = 20)
    private String numeroPiece;
    @Column(name = "DATE_ETABLISSEMENT")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateEtablissement;
    @Column(name = "PROFESSION", length = 40)
    private String profession;
    @Column(name = "ADRESSE_EMAIL")
    private String adresseEmail;
    @Column(name = "DATE_DE_NAISSANCE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateNaissance;
    @Column(name = "VILLE", length = 50)
    private String ville;

    @Column(name = "QUARTIER", length = 50)
    private String quartier;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIE_CLIENT")
    private CategorieClientEnum caetgorieCLient;

    @Column(name = "LANGUE_IVR")
    private String langueIVR;

    @Column(name = "VIREMENT_DE_SALAIRE")
    private boolean virementSalaire;

    @Column(name = "LANGUE_WEB")
    private String langueWeb;

    @Column(name = "PHOTO_IDENTITE")
    private String photoIdentite;
    @Column(name = "PIECE_IDENTITE_RECTO")
    private String pieceIdentiteRecto;
    @Column(name = "PIECE_IDENTITE_VERSO")
    private String pieceIdentiteVerso;
    @Column(name = "NUMERO_DE_COMPTE_ORDINANIRE", length = 12)
    private String numeroCpteOrdinaire;
    @Column(name = "NUMERO_DE_COMPTE_EPARGNE", length = 12)
    private String numeroCpteEpargne;
    @Enumerated(EnumType.STRING)
    @Column(name = "CIVILITE")
    private CiviliteEnum civilite;
    @Enumerated(EnumType.STRING)
    @Column(name = "SITUATION_MATRIMONIALE")
    private SituationMatriEnum situationMatrimoniale;
    @Column(name = "PAGEFACEBOOK")
    private String pageFacebook;

    

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getNumeroTelepone() {
        return numeroTelepone;
    }

    public void setNumeroTelepone(String numeroTelepone) {
        this.numeroTelepone = numeroTelepone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public TypePieceEnum getTypePiece() {
        return typePiece;
    }

    public void setTypePiece(TypePieceEnum typePiece) {
        this.typePiece = typePiece;
    }

    public String getNumeroPiece() {
        return numeroPiece;
    }

    public void setNumeroPiece(String numeroPiece) {
        this.numeroPiece = numeroPiece;
    }

    public Date getDateEtablissement() {
        return dateEtablissement;
    }

    public void setDateEtablissement(Date dateEtablissement) {
        this.dateEtablissement = dateEtablissement;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAdresseEmail() {
        return adresseEmail;
    }

    public void setAdresseEmail(String adresseEmail) {
        this.adresseEmail = adresseEmail;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public CategorieClientEnum getCaetgorieCLient() {
        return caetgorieCLient;
    }

    public void setCaetgorieCLient(CategorieClientEnum caetgorieCLient) {
        this.caetgorieCLient = caetgorieCLient;
    }

    public String getLangueIVR() {
        return langueIVR;
    }

    public void setLangueIVR(String langueIVR) {
        this.langueIVR = langueIVR;
    }

    public boolean isVirementSalaire() {
        return virementSalaire;
    }

    public void setVirementSalaire(boolean virementSalaire) {
        this.virementSalaire = virementSalaire;
    }

    public String getLangueWeb() {
        return langueWeb;
    }

    public void setLangueWeb(String langueWeb) {
        this.langueWeb = langueWeb;
    }

    public String getPhotoIdentite() {
        return photoIdentite;
    }

    public void setPhotoIdentite(String photoIdentite) {
        this.photoIdentite = photoIdentite;
    }

    public String getPieceIdentiteRecto() {
        return pieceIdentiteRecto;
    }

    public void setPieceIdentiteRecto(String pieceIdentiteRecto) {
        this.pieceIdentiteRecto = pieceIdentiteRecto;
    }

    public String getPieceIdentiteVerso() {
        return pieceIdentiteVerso;
    }

    public void setPieceIdentiteVerso(String pieceIdentiteVerso) {
        this.pieceIdentiteVerso = pieceIdentiteVerso;
    }

    public String getNumeroCpteOrdinaire() {
        return numeroCpteOrdinaire;
    }

    public void setNumeroCpteOrdinaire(String numeroCpteOrdinaire) {
        this.numeroCpteOrdinaire = numeroCpteOrdinaire;
    }

    public String getNumeroCpteEpargne() {
        return numeroCpteEpargne;
    }

    public void setNumeroCpteEpargne(String numeroCpteEpargne) {
        this.numeroCpteEpargne = numeroCpteEpargne;
    }

    public CiviliteEnum getCivilite() {
        return civilite;
    }

    public void setCivilite(CiviliteEnum civilite) {
        this.civilite = civilite;
    }

    public SituationMatriEnum getSituationMatrimoniale() {
        return situationMatrimoniale;
    }

    public void setSituationMatrimoniale(SituationMatriEnum situationMatrimoniale) {
        this.situationMatrimoniale = situationMatrimoniale;
    }

    public String getPageFacebook() {
        return pageFacebook;
    }

    public void setPageFacebook(String pageFacebook) {
        this.pageFacebook = pageFacebook;
    }

}
