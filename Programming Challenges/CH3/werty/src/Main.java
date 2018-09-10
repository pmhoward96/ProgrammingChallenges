import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin () {
        char[] base = {'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=',
                       'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\',
                       'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\'',
                       'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/'};
        int baseCount = base.length;
//        for(int i = 0; i < baseCount; i++) {
//            System.out.println(base[i]);
//        }

        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()) {
            String temp = s.nextLine();
            char[] code = temp.toCharArray();
            for(int i = 0; i < code.length; i++) {
                if(code[i] == ' ' ){
                    System.out.print(" ");
                }
                else {
                    for(int j = 0; j < baseCount; j++) {
                        if(code[i] == base[j]) {
                            System.out.print(base[j - 1]);
                        }
                    }
                }
            }
            System.out.print("\n");

        }

    }
}
