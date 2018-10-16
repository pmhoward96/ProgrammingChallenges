import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for(int k = 0; k < testCases; k++) {
            long n = Long.parseLong(scan.nextLine());
            int iterations = 0;
            while(true) {
                iterations++;
                long sum = n + reverseLong(n);
                if(palindrome(sum)) {
                    n = sum;
                    break;
                }
                n = sum;
            }
            System.out.print(iterations + " " + n + "\n");


        }
    }
    long reverseLong(long n) {
            StringBuilder sb = new StringBuilder("");
            sb.append(n);
            String s = sb.toString();
            StringBuilder ReversedN = new StringBuilder("");
            for(int i = s.length() - 1; i >=0; i--) {
                ReversedN.append(s.charAt(i));
            }
            long reversed = Long.parseLong(ReversedN.toString());
            return reversed;
        }

        boolean palindrome(long n) {
            StringBuilder s = new StringBuilder();
            StringBuilder rs = new StringBuilder();
            s.append(n);
            rs.append(reverseLong(n));
        if(s.toString().equals(rs.toString())) {
            return true;
        }
        else {
            return false;
        }
    }
}
