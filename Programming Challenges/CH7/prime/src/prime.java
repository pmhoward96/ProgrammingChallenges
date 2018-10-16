import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();

    }


    boolean isPrime(int n) {
        if( n % 2 == 0) {
            return false;
        }
        for(int i = 3; i * i <=n; i += 2) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }


    void begin (){
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for(int i = 2; i < 10000001; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }

        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            int n = scan.nextInt();
            if(n < 8) {
                System.out.print("Impossible\n");
            }

            if(n % 2 == 0) {
                System.out.print("2 2 ");
                n = n - (2 + 2);
            }
            else {
                System.out.print("2 3 ");
                n = n - (2 + 3);
            }

            for(int i = 0; i < primes.size(); i++) {
                if(!isPrime(n - primes.get(i))) {
                    System.out.print(primes.get(i) + " " + (n - primes.get(i)) + "\n");
                }
            }




        }

    }
}
