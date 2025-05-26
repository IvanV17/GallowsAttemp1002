import java.util.*;

public class Hangman extends Game {
    private static final String START = "д";
    private static final String END = "н";

    public static void main(String[] args) {
        Dictionary.getDictionary();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("\nХотите сыграть? Если да, введите букву %s, если нет, введите букву %s \n", START, END);
            String playerCommand = scanner.nextLine().toLowerCase();
            getRandomWord(Dictionary.dictionary);
            maskedWord = "*".repeat(word.length());
            if (playerCommand.equals(START)) {
                playGame();
            } else if (playerCommand.equals(END)) {
                System.out.println("Сыграем в другой раз!");
                break;
            }
        }
    }
}