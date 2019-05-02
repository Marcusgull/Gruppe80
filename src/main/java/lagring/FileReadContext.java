package lagring;

import javafx.stage.Stage;

public class FileReadContext {
    private FileReadStrategy fileReadStrategy;

    public FileReadContext (FileReadStrategy fileReadStrategy){
        this.fileReadStrategy = fileReadStrategy;
    }

}
