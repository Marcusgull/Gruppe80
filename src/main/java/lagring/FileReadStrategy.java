package lagring;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class FileReadStrategy implements Serializable {
    abstract ArrayList<Object> load();

    static void readFile() throws IOException {
        List<List<String>> liste = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("lagring.csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(";");
                liste.add(Arrays.asList(values));
                System.out.println(values.toString());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Finner ikke fil");
        }
    }
}
