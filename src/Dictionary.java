import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
    public static ArrayList<String> dictionary = new ArrayList<>();
    public static ArrayList<String> getDictionary() {
        File file = new File("dictionary.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                dictionary.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return dictionary;
    }
}