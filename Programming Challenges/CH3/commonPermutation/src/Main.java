import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Main main = new Main();
	    main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        //System.out.print("\n");
        while(scan.hasNextLine()) {
            String a = scan.nextLine();
            String b = scan.nextLine();
            //if(a.length() != 0 || b.length() != 0) {
                //System.out.print("Not Blank Lines\n");
                char[] aArray = a.toCharArray();
                char[] bArray = b.toCharArray();

                Arrays.sort(aArray);
                Arrays.sort(bArray);

                int[] aInt = new int[26];
                int[] bInt = new int[26];

                for(int i = 0; i < aArray.length; i++) {
                    aInt[aArray[i] - 97] = aInt[aArray[i] - 97] + 1;
                }
                for(int i = 0; i < bArray.length; i++) {
                    bInt[bArray[i] - 97] = bInt[bArray[i] - 97] + 1;
                }
                StringBuilder sb = new StringBuilder();

                for(int i = 0; i < 26; i++) {
                    int min = Math.min(aInt[i], bInt[i]);
                    for(int j = 0; j < min; j++) {
                        char out = (char) (97 + i);
                        sb.append(out);
                    }
                }
                sb.append("\n");
                System.out.print(sb.toString());


            //}
//            else{
//                //System.out.print("BLANK LINE\n");
//            }



        }
    }
}
