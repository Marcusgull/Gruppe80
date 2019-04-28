package lagring;

import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class FilLagringStrategy {
    abstract void lagre (Stage stage, int verdi);

    public void LagreInnholdTilFil(File fil, int verdi){
        try{
            PrintWriter printWriter = new PrintWriter(fil);
            printWriter.println(verdi);
            printWriter.close();
        }
        catch (IOException e){
            System.out.println("en error");
        }
    }
}