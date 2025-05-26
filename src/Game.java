import java.util.*;

public class Game {
    public static String maskedWord;
    public static String word;
    private static final int MISTAKES = 8;
    private static final List<Character> inputLetters = new ArrayList<>();
    private static int countLetter;
    private static int errorCount;

    public static void playGame() {
        boolean gameOver = false;

        while (!gameOver) {
            startGame();

            if (maskedWord.equals(word)) {
                System.out.printf("Вы победили! \uD83D\uDE01 Вы отгадали слово: %s\n", word);
                errorCount = 0;
                gameOver = true;
            } else if (errorCount >= MISTAKES) {
                System.out.printf("Вы проиграли! \uD83D\uDE25 Вы не смогли отгадать слово: %s\n", word);
                errorCount = 0;
                gameOver = true;
            }
        }
        inputLetters.clear();
    }

    private static void startGame() {
        System.out.printf("Загаданное слово: %s\n", maskedWord);
        System.out.println("\nВведите букву [а-я]");

        Scanner scanner = new Scanner(System.in);
        char letter = LetterValidator.validateLetterInput(scanner);
        ArrayList<Integer> indexLetters = new ArrayList<>();
        char[] lettersOfWord = word.toCharArray();
        inputLetters.add(letter);
        countLetter = Collections.frequency(inputLetters, letter);
        System.out.printf("Введенные буквы: %s\n", inputLetters);
        for (int i = 0; i < lettersOfWord.length; i++) {
            if (lettersOfWord[i] == letter) {
                indexLetters.add(i);
            }
        }
        guessesLetter(indexLetters, letter);
    }

    private static void guessesLetter(ArrayList<Integer> indexLetters, char letter) {
        if (!indexLetters.isEmpty()) {
            for (int index : indexLetters) {
                char[] masked = maskedWord.toCharArray();
                masked[index] = letter;
                maskedWord = String.valueOf(masked);
            }
        } else if (countLetter >= 2) {
            System.out.println("\nТакая буква уже была введена");
        } else {
            ConsoleGraphics.printHangman(errorCount);
            int lives = MISTAKES - errorCount - 1;
            System.out.printf("Буквы %s в слове нет! Осталось ошибиться раз: %d\n", letter, lives);
            errorCount++;
        }
    }

    public static void getRandomWord(ArrayList<String> dictionary) {
        Random random = new Random();
        int randomIndex = random.nextInt(dictionary.size());
        word = dictionary.get(randomIndex);
    }
}