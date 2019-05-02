package lagring;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class FileReadStrategy {
    abstract void lastOpp();

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
