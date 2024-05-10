import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionnaire {
    static List<String> dictionary = new ArrayList<>();
    static String fileName = "C:/Users/DELL/IdeaProjects/PasswordCracker/src/dictionnaire.txt";

    public static List<String> Chargerdictionnaire() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                dictionary.add(line);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return dictionary;
    }
}
