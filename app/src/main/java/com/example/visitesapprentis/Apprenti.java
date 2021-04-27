package com.example.visitesapprentis;

import java.util.Date;

public class Apprenti {

    private String nomApp;
    private String prenomApp;
    private String adresseApp;
    private String telApp;
    private Date dateDebutApp;
    private String laClasse;
    private String mailApp;

    public Apprenti(String nom, String prenom, String adresse, String tel, Date dateDebut, String uneclasse, String mail){
        this.nomApp = nom;
        this.prenomApp = prenom;
        this.adresseApp = adresse;
        this.telApp = tel;
        this.dateDebutApp = dateDebut;
        this.laClasse = uneclasse;
        this.mailApp = mail;
    }

    public String getNomApp() {
        return nomApp;
    }

    public void setNomApp(String nomApp) {
        this.nomApp = nomApp;
    }

    public String getPrenomApp() {
        return prenomApp;
    }

    public void setPrenomApp(String prenomApp) {
        this.prenomApp = prenomApp;
    }

    public String getAdresseApp() {
        return adresseApp;
    }

    public void setAdresseApp(String adresseApp) {
        this.adresseApp = adresseApp;
    }

    public String getTelApp() {
        return telApp;
    }

    public void setTelApp(String telApp) {
        this.telApp = telApp;
    }

    public Date getDateDebutApp() {
        return dateDebutApp;
    }

    public void setDateDebutApp(Date dateDebutApp) {
        this.dateDebutApp = dateDebutApp;
    }

    public String getLaClasse() {
        return laClasse;
    }

    public void setLaClasse(String laClasse) {
        this.laClasse = laClasse;
    }

    public String getMailApp() {
        return mailApp;
    }

    public void setMailApp(String mailApp) {
        this.mailApp = mailApp;
    }
}
