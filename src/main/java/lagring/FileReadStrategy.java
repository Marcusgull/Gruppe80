package lagring;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class FileReadStrategy {
    abstract void lastOpp(Stage stage, Object obj);

    List<List<String>> records = new ArrayList<>();

}
