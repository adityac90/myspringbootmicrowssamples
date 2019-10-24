import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        char[] chars = input.toCharArray();
        int i = removeSpaces(chars);
        String output = String.valueOf(chars).substring(0, i);
        System.out.println(output);

    }

    static int removeSpaces(char[] s) {
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != ' ') {
                s[count++] = s[i];
            }
        }
        return count;
    }
}


