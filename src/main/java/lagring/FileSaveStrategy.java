package lagring;

import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class FileSaveStrategy {
    abstract void lagre (Stage stage, Object obj);

    public void LagreInnholdTilFil(File fil, Object obj){
        try{
            PrintWriter printWriter = new PrintWriter(fil);
            printWriter.println(obj);
            printWriter.close();
        }
        catch (IOException e){
            System.out.println("en error");
        }
    }
}