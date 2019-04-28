
package modeller;

public class Jobbsoker {
    private String fnavn;
    private String enavn;
    private String tlf;
    private String email;
    private int alder;
    private String jobbKat;
    private String erfaring;
    private String lønnKrav;
    private String ref;

    public Jobbsoker(String fnavn, String enavn, String tlf, String email, int alder, String jobbKat, String erfaring, String lønnKrav, String ref) {
        this.fnavn = fnavn;
        this.enavn = enavn;
        this.tlf = tlf;
        this.email = email;
        this.alder = alder;
        this.jobbKat = jobbKat;
        this.erfaring = erfaring;
        this.lønnKrav = lønnKrav;
        this.ref = ref;
    }

    public String getFnavn() {
        return fnavn;
    }

    public void setFnavn(String fnavn) {
        this.fnavn = fnavn;
    }

    public String getEnavn() {
        return enavn;
    }

    public void setEnavn(String enavn) {
        this.enavn = enavn;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public String getJobbKat() {
        return jobbKat;
    }

    public void setJobbKat(String jobbKat) {
        this.jobbKat = jobbKat;
    }

    public String getErfaring() {
        return erfaring;
    }

    public void setErfaring(String erfaring) {
        this.erfaring = erfaring;
    }

    public String getLønnKrav() {
        return lønnKrav;
    }

    public void setLønnKrav(String lønnKrav) {
        this.lønnKrav = lønnKrav;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
