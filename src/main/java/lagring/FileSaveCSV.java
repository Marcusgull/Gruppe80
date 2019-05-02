package lagring;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class FileSaveCSV extends FileSaveStrategy {

    public void lagre(Stage stage, Object obj) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(
                "(*.csv)","*.csv");
        fileChooser.setInitialDirectory(new File("src"));

        File fil = fileChooser.showOpenDialog(stage);

        if (fil != null){
            this.LagreInnholdTilFil(fil);
        }
    }

}

