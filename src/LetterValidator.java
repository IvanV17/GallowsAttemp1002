import java.util.Scanner;

public class LetterValidator {

    public static char validateLetterInput(Scanner scanner) {
        while (true) {
            String line = scanner.nextLine().toLowerCase();

            if (line.isEmpty()) {
                System.out.println("Ввод не может быть пустым");
            } else if (line.length() > 1) {
                System.out.println("Недопустимый ввод. Введите одну букву [а-я]");
            } else {
                char letter = line.charAt(0);
                if (letter >= 'а' && letter <= 'я' || letter == 'ё') {
                    return letter;
                }
                System.out.println("Недопустимый ввод. Введите букву [а-я]");
            }
        }
    }
}