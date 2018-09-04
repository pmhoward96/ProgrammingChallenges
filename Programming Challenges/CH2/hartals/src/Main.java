import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() throws IOException {
        //BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        System.out.println(t);
        for(int i = 0; i < t; i++) {
            //n = number of days in simulation
            int n = Integer.parseInt(scan.nextLine());
            System.out.println("N: " + n);
            //p = number of political parties
            int p = Integer.parseInt(scan.nextLine());
            System.out.println("P: " + p);
            //hp = hartal parameter
            int hp[] = new int[p];
            System.out.print("HP: ");
            for(int j = 0; j < p; j++) {
                String temp = scan.nextLine();
                System.out.print(temp);
                hp[i] = Integer.parseInt(temp, 10);
                System.out.print(hp[j] + " ");
            }
            int days = 0;
            for(int j = 1; j <= n; j++) {
                for(int k = 0; k < p; k++) {
                    if(j % hp[k] == 0) {
                        days++;
                    }
                    if(j % 7 == 0 || j % 7 == 6) {
                        days--;
                    }
                }
            }

            System.out.print(days + "\n");


        }
    }
}
