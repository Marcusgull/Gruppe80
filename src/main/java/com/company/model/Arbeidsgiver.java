package com.company.model;


public class Arbeidsgiver {
    private String adresse;
    private String bransje;
    private String email;
    private String tlf;
    
    Arbeidsgiver(String adresse, String bransje, String email, String tlf){
        this.adresse = adresse;
        this.bransje = bransje;
        this.email = email;
        this.tlf = tlf;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getBransje() {
        return bransje;
    }

    public void setBransje(String bransje) {
        this.bransje = bransje;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }
}
