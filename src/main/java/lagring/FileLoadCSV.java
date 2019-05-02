package lagring;

import javafx.stage.Stage;
import modeller.Arbeidsgiver;
import org.openjfx.ArbeidsgiverController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
}
