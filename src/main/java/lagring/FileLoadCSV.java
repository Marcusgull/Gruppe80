package lagring;

import javafx.stage.Stage;
import modeller.Arbeidsgiver;
import modeller.Jobbsoker;
import modeller.LedigeVikariater;
import org.openjfx.ArbeidsgiverController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileLoadCSV extends FileReadStrategy {

    @Override
    public void lastOpp() {
        try {
            FileReader fr = new FileReader("src/lagring.csv");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                String[] deler = line.split(";");
                if(deler[0].equals("Arbeidsgiver")){
                    Arbeidsgiver a = new Arbeidsgiver();
                    a.Adresse.setValue(deler[1]);
                    a.Bransje.setValue(deler[2]);
                    a.Email.setValue(deler[3]);
                    a.Tlf.setValue(deler[4]);
                    FileSaveStrategy.objList.add(a);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Object> load(){
        ArrayList<Object> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("src/lagring.csv");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                String[] deler = line.split(";");
                if(deler[0].equals("Arbeidsgiver")){
                    Arbeidsgiver a = new Arbeidsgiver();
                    a.Adresse.setValue(deler[1]);
                    a.Bransje.setValue(deler[2]);
                    a.Email.setValue(deler[3]);
                    a.Tlf.setValue(deler[4]);
                    list.add(a);
                }else if(deler[0].equals("Jobbsøker")){
                    Jobbsoker j = new Jobbsoker();
                    j.enavn.setValue(deler[1]);
                    j.fnavn.setValue(deler[2]);
                    j.tlf.setValue(deler[3]);
                    j.email.setValue(deler[4]);
                    j.alder.setValue(deler[5]);
                    j.jobbKat.setValue(deler[6]);
                    j.lonnsKrav.setValue(deler[7]);
                    j.erfaring.setValue(deler[8]);
                    j.ref.setValue(deler[9]);
                    list.add(j);
                }else if(deler[0].equals("Ledige Vikariater")){
                    System.out.println("WUT");
                    LedigeVikariater lv = new LedigeVikariater();
                    lv.Sektor.setValue(deler[1]);
                    lv.Sted.setValue(deler[2]);
                    lv.Arbeidsgiver.setValue(deler[3]);
                    lv.Jobbkategori.setValue(deler[4]);
                    lv.Varighet.setValue(deler[5]);
                    lv.Arbeidstid.setValue(deler[6]);
                    lv.Stillingstype.setValue(deler[7]);
                    lv.Kvalifikasjoner.setValue(deler[8]);
                    list.add(lv);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
