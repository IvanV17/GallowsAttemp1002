public class ConsoleGraphics {

    private static final String[] hangmanStages = new String[]{"""
__________
|
|
|
|
|
==========
""", """
__________
|    |
|
|
|
|
==========
""", """
__________
|    |
|    0
|
|
|
==========
""", """
__________
|    |
|    0
|   /
|
|
==========
""", """
__________
|    |
|    0
|   /|
|
|
==========
""", """
__________
|    |
|    0
|   /|\\
|
|
==========
""", """
__________
|    |
|    0
|   /|\\
|   /
|
==========
""", """
__________
|    |
|    0
|   /|\\
|   / \\
|
==========
"""};

    public static String printHangman(int errorCount) {
        System.out.println(hangmanStages[errorCount]);
        return hangmanStages[errorCount];
    }
}