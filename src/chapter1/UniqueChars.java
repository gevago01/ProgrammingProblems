package chapter1;
/**
 * Created by giannis on 10/11/2014.
 * Exercise (1.1).
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 */
public class UniqueChars {

    /**
     * Solution with extra
     * data structures
     * Time Complexity:O(n) where n is string's length
     * Space Complexity:O(m) where m is the maximum ASCII char
     *
     * @param x Input String
     */
    public static boolean isUnique(String x) {
        int[] array;
        array = new int[(int) Character.MAX_VALUE];

        for (int i = 0; i < x.length(); i++) {
            array[x.charAt(i)]++;
            if (array[x.charAt(i)] > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Solution with no extra
     * data structures
     * Time Complexity:O(n^2) where n is string's length
     * No Space
     *
     * @param x Input String
     * @return true if String is unique
     */
    public static boolean isUnique2(String x) {

        for (int i = 0; i < x.length(); i++) {
            for (int j = i + 1; j < x.length(); j++) {
                if (x.charAt(i) == x.charAt(j))
                    return false;
            }

        }
        return true;

    }

    /**
     * Solution with no extra
     * data structures
     * Time Complexity:O(n) where n is string's length
     * Space Complexity: extra 64 bits
     * We use two bit vectors (two integers), smalls for
     * small letters and capitals for capital letters.We
     * then calculate a unique index in the bit vector
     * by shifting left the value one, (int)char times.
     * This produces a unique index for each character
     *
     * @param x Input String
     * @return true if String is unique
     */
    public static boolean isUnique3(String x) {
        int smalls = 0;
        int capitals = 0;

        for (int i = 0; i < x.length(); i++) {
            int ascii_code;
            char character = x.charAt(i);

            if (Character.isLowerCase(character)) {
                //calculate ascii code for this character

                ascii_code = (int) (character - 'a');
                if ((smalls & (1 << ascii_code)) > 0) {
                    return false;
                }
                smalls = smalls | (1 << ascii_code);
            } else {
                ascii_code = (int) (character - 'A');
                if ((capitals & (1 << ascii_code)) > 0) {
                    return false;
                }
                capitals = capitals | (1 << ascii_code);
            }


        }

        return true;
    }

    public static void main(String[] args) {
        String x = "some_char";
        if (isUnique3(x)) {
            System.out.println("The string has unique characters");
        } else {
            System.out.println("The string does not contain unique characters");
        }
    }

}
