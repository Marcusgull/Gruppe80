package lagring;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileSaveJOBJ extends FileSaveStrategy {

    public void lagre(Stage stage, Object obj) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(
                "(*.jobj)","*.jobj");

        File fil = fileChooser.showOpenDialog(stage);

        if (fil != null){
            this.LagreInnholdTilFil(fil, obj);
        }
    }

}
