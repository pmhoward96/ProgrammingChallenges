import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int digits = 1;
            int count = 1;
            while( digits % n != 0) {
                digits = (digits * 10 + 1) % n;
                count++;

            }
            System.out.print(count + "\n");

        }


    }

    boolean ones(long n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        String s = sb.toString();
        boolean ones = true;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '1') {
                ones = false;
                break;
            }
        }
        return ones;
    }
}
