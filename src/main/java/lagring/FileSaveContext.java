package lagring;

import javafx.stage.Stage;

public class FileSaveContext {
    private FileSaveStrategy fileSaveStrategy;

    public FileSaveContext (FileSaveStrategy fileSaveStrategy){
        this.fileSaveStrategy = fileSaveStrategy;
    }

    public void lagreTilFil (Stage stage, Object obj){
        fileSaveStrategy.lagre(stage, obj);
    }
}
