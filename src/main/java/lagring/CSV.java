package lagring;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class CSV extends FilLagringStrategy {

    public void lagre(Stage stage, int verdi) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(
                "(*.csv)","*.csv");

        File fil = fileChooser.showOpenDialog(stage);

        if (fil != null){
            this.LagreInnholdTilFil(fil, verdi);
        }
    }

}

