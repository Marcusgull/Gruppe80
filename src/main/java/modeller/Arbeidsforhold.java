
package modeller;

public class Arbeidsforhold {
    private Jobbsoker vikar;
    private LedigeVikariater vikariatet;

    public Arbeidsforhold(Jobbsoker vikar, LedigeVikariater vikariatet) {
        this.vikar = vikar;
        this.vikariatet = vikariatet;
    }
    
    public Jobbsoker getVikar() {
        return vikar;
    }

    public LedigeVikariater getVikariatet() {
        return vikariatet;
    }
}
