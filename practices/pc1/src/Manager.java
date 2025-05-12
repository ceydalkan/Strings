import java.util.Scanner;

public class Manager {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        takeWordsUntillStop();
        printThirdLetters();
        String str1 = "(a (b (c)) d)";
        String str2 = "(a (b (c (d (e) f) g) h) (i (j (k) l) m) n)";
        String str3 = "(a (b (c) d)";
        String str4 = "(a ))b ((c) d";
        System.out.println(str1 + " " + areParanthesesValid(str1));
        System.out.println(str2 + " " + areParanthesesValid(str2));
        System.out.println(str3 + " " + areParanthesesValid(str3));
        System.out.println(str4 + " " + areParanthesesValid(str4));
        System.out.println(areTheyAnagram());
    }

    // a program that takes a word from the user untill the users type stop
    public static void takeWordsUntillStop() {
        System.out.print("welcome, please enter a word: ");
        String wordTaken = s.next();
        while (!wordTaken.equals("stop")) {
            System.out.print(": ");
            wordTaken = s.next();

            if (wordTaken.equals("stop"))
                System.out.println("stopped");
        }
    }

    // a program that continually prints the third letters in given string
    public static void printThirdLetters() {
        System.out.print("enter a sentence with , between the words: ");
        String sentence = s.next();
        String[] words;
        words = sentence.split(",");

        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]);
            System.out.println(" : " + words[i].charAt(2));
        }
    }

    // a program that prints true if the parantheses are invalid, otherwise false
    public static boolean areParanthesesValid(String string) {
        int openParantheses = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(')
                openParantheses++;

            else if (string.charAt(i) == ')') {
                if (openParantheses == 0)
                    return false;

                openParantheses--;
            }
        }

        if (openParantheses == 0)
            return true;
        else
            return false;
    }

    // a program that takes two strings from the user and checks whether they are
    // anagram or not
    public static boolean areTheyAnagram() {
        System.out.print("please enter two words with , between them: ");
        String wordsTaken = s.next();
        String[] words = wordsTaken.split(",");

        boolean doCharsMatch = false;
        for (int i = 0; i < words[0].length(); i++) {
            for (int j = 0; j < words[1].length(); j++) {
                if (words[0].charAt(i) == words[1].charAt(j))
                    doCharsMatch = true;
            }

            if (doCharsMatch == false)
                return false;
        }

        boolean doCharsMatch2 = false;
        for (int i = 0; i < words[1].length(); i++) {
            for (int j = 0; j < words[0].length(); j++) {
                if (words[1].charAt(i) == words[0].charAt(j))
                    doCharsMatch2 = true;
            }

            if (doCharsMatch2 == false)
                return false;
        }

        return true;
    }
}
