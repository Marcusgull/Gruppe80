package modeller;

public class LedigeVikariater {
    private String Sektor;
    private String Sted;
    private Arbeidsgiver Arbeidsgiver;
    private String Jobbkategori;
    private String Varighet;
    private int Arbeidstid;
    private String Stillingstype;
    private String Kvalifikasjoner;

    public LedigeVikariater(String Sektor, String Sted, Arbeidsgiver Arbeidsgiver, String Jobbkategori, String Varighet, int Arbeidstid, String Stillingstype, String Kvalifikasjoner) {
        this.Sektor = Sektor;
        this.Sted = Sted;
        this.Arbeidsgiver = Arbeidsgiver;
        this.Jobbkategori = Jobbkategori;
        this.Varighet = Varighet;
        this.Arbeidstid = Arbeidstid;
        this.Stillingstype = Stillingstype;
        this.Kvalifikasjoner = Kvalifikasjoner;
    }

    public String getSektor() {
        return Sektor;
    }

    public void setSektor(String Sektor) {
        this.Sektor = Sektor;
    }

    public String getSted() {
        return Sted;
    }

    public void setSted(String Sted) {
        this.Sted = Sted;
    }

    public Arbeidsgiver getArbeidsgiver() {
        return Arbeidsgiver;
    }

    public void setArbeidsgiver(Arbeidsgiver Arbeidsgiver) {
        this.Arbeidsgiver = Arbeidsgiver;
    }

    public String getJobbkategori() {
        return Jobbkategori;
    }

    public void setJobbkategori(String Jobbkategori) {
        this.Jobbkategori = Jobbkategori;
    }

    public String getVarighet() {
        return Varighet;
    }

    public void setVarighet(String Varighet) {
        this.Varighet = Varighet;
    }

    public int getArbeidstid() {
        return Arbeidstid;
    }

    public void setArbeidstid(int Arbeidstid) {
        this.Arbeidstid = Arbeidstid;
    }

    public String getStillingstype() {
        return Stillingstype;
    }

    public void setStillingstype(String Stillingstype) {
        this.Stillingstype = Stillingstype;
    }

    public String getKvalifikasjoner() {
        return Kvalifikasjoner;
    }

    public void setKvalifikasjoner(String Kvalifikasjoner) {
        this.Kvalifikasjoner = Kvalifikasjoner;
    }

}
