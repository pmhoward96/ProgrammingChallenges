import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() throws IOException {
        //Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        String blank = br.readLine();
        for(int k = 0; k < testCases; k++) {
            //System.out.print("\n");
            //System.out.println("");
            int numShuffles = Integer.parseInt(br.readLine());
            //System.out.println("NumShuffles: " + numShuffles);
            int deck[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52};


            int shuffles[][] = new int[numShuffles][52];
            int count = -1;
            //String y = br.readLine();
            StringTokenizer token = new StringTokenizer("");
            for(int i = 0; i < 52 * numShuffles; i ++) {
                if(i % 52 == 0) {
                    count++;
                }
                if(!token.hasMoreTokens()) {
                    token = new StringTokenizer(br.readLine());
                }
                shuffles[count][i%52] = Integer.parseInt(token.nextToken());
                //System.out.print(shuffles[count][i%52] + ", ");

            }
//            for(int i = 0; i < numShuffles; i++) {
//                System.out.println(i + 1 + ": ");
//                for(int h = 0; h < 52; h ++) {
//                    System.out.print(shuffles[i][h] + ", ");
//                }
//                System.out.println("");
//            }

            while(true) {
                String st = br.readLine();
                //System.out.println("St: " + st);
                if (st==null || st.equals("")){
                    break;
                }
                int s = Integer.parseInt(st);
                int newDeck[] = new int[52];
                for(int i = 0; i < 52; i++) {
                    newDeck[i] = deck[shuffles[s-1][i] - 1];
                }
                deck = newDeck;
//                for(int i = 0; i < 52; i++) {
//                    System.out.print(deck[i] + ", ");
//
//                }
//                System.out.println();

            }
            StringBuilder finalSt = new StringBuilder();
            for(int i = 0; i < 52; i++) {
                if(deck[i] == 1) finalSt.append("2 of Clubs\n");
                if(deck[i] == 2) finalSt.append("3 of Clubs\n");
                if(deck[i] == 3) finalSt.append("4 of Clubs\n");
                if(deck[i] == 4) finalSt.append("5 of Clubs\n");
                if(deck[i] == 5) finalSt.append("6 of Clubs\n");
                if(deck[i] == 6) finalSt.append("7 of Clubs\n");
                if(deck[i] == 7) finalSt.append("8 of Clubs\n");
                if(deck[i] == 8) finalSt.append("9 of Clubs\n");
                if(deck[i] == 9) finalSt.append("10 of Clubs\n");
                if(deck[i] == 10) finalSt.append("Jack of Clubs\n");
                if(deck[i] == 11) finalSt.append("Queen of Clubs\n");
                if(deck[i] == 12) finalSt.append("King of Clubs\n");
                if(deck[i] == 13) finalSt.append("Ace of Clubs\n");
                if(deck[i] == 14) finalSt.append("2 of Diamonds\n");
                if(deck[i] == 15) finalSt.append("3 of Diamonds\n");
                if(deck[i] == 16) finalSt.append("4 of Diamonds\n");
                if(deck[i] == 17) finalSt.append("5 of Diamonds\n");
                if(deck[i] == 18) finalSt.append("6 of Diamonds\n");
                if(deck[i] == 19) finalSt.append("7 of Diamonds\n");
                if(deck[i] == 20) finalSt.append("8 of Diamonds\n");
                if(deck[i] == 21) finalSt.append("9 of Diamonds\n");
                if(deck[i] == 22) finalSt.append("10 of Diamonds\n");
                if(deck[i] == 23) finalSt.append("Jack of Diamonds\n");
                if(deck[i] == 24) finalSt.append("Queen of Diamonds\n");
                if(deck[i] == 25) finalSt.append("King of Diamonds\n");
                if(deck[i] == 26) finalSt.append("Ace of Diamonds\n");
                if(deck[i] == 27) finalSt.append("2 of Hearts\n");
                if(deck[i] == 28) finalSt.append("3 of Hearts\n");
                if(deck[i] == 29) finalSt.append("4 of Hearts\n");
                if(deck[i] == 30) finalSt.append("5 of Hearts\n");
                if(deck[i] == 31) finalSt.append("6 of Hearts\n");
                if(deck[i] == 32) finalSt.append("7 of Hearts\n");
                if(deck[i] == 33) finalSt.append("8 of Hearts\n");
                if(deck[i] == 34) finalSt.append("9 of Hearts\n");
                if(deck[i] == 35) finalSt.append("10 of Hearts\n");
                if(deck[i] == 36) finalSt.append("Jack of Hearts\n");
                if(deck[i] == 37) finalSt.append("Queen of Hearts\n");
                if(deck[i] == 38) finalSt.append("King of Hearts\n");
                if(deck[i] == 39) finalSt.append("Ace of Hearts\n");
                if(deck[i] == 40) finalSt.append("2 of Spades\n");
                if(deck[i] == 41) finalSt.append("3 of Spades\n");
                if(deck[i] == 42) finalSt.append("4 of Spades\n");
                if(deck[i] == 43) finalSt.append("5 of Spades\n");
                if(deck[i] == 44) finalSt.append("6 of Spades\n");
                if(deck[i] == 45) finalSt.append("7 of Spades\n");
                if(deck[i] == 46) finalSt.append("8 of Spades\n");
                if(deck[i] == 47) finalSt.append("9 of Spades\n");
                if(deck[i] == 48) finalSt.append("10 of Spades\n");
                if(deck[i] == 49) finalSt.append("Jack of Spades\n");
                if(deck[i] == 50) finalSt.append("Queen of Spades\n");
                if(deck[i] == 51) finalSt.append("King of Spades\n");
                if(deck[i] == 52) finalSt.append("Ace of Spades\n");
            }
            if(k + 1 < testCases) {
                finalSt.append("\n");
            }
            System.out.print(finalSt.toString());
            //String blank = br.readLine();
        }
    }
}
