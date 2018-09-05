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
                    if(shuffles[s - 1][i] != (i + 1)) {
                        for(int l = 0; l < 52; l++) {
                            if(shuffles[s -1][l] == (i + 1)) {
                                newDeck[i] = deck[l];
                                break;
                            }
                        }
                    }
                    else {
                        newDeck[i] = deck[i];
                    }
                }
                deck = newDeck;
//                for(int i = 0; i < 52; i++) {
//                    System.out.print(deck[i] + ", ");
//
//                }
//                System.out.println();

            }

            for(int i = 0; i < 52; i++) {
                if(deck[i] == 1) System.out.print("2 of Clubs\n");
                if(deck[i] == 2) System.out.print("3 of Clubs\n");
                if(deck[i] == 3) System.out.print("4 of Clubs\n");
                if(deck[i] == 4) System.out.print("5 of Clubs\n");
                if(deck[i] == 5) System.out.print("6 of Clubs\n");
                if(deck[i] == 6) System.out.print("7 of Clubs\n");
                if(deck[i] == 7) System.out.print("8 of Clubs\n");
                if(deck[i] == 8) System.out.print("9 of Clubs\n");
                if(deck[i] == 9) System.out.print("10 of Clubs\n");
                if(deck[i] == 10) System.out.print("Jack of Clubs\n");
                if(deck[i] == 11) System.out.print("Queen of Clubs\n");
                if(deck[i] == 12) System.out.print("King of Clubs\n");
                if(deck[i] == 13) System.out.print("Ace of Clubs\n");
                if(deck[i] == 14) System.out.print("2 of Diamonds\n");
                if(deck[i] == 15) System.out.print("3 of Diamonds\n");
                if(deck[i] == 16) System.out.print("4 of Diamonds\n");
                if(deck[i] == 17) System.out.print("5 of Diamonds\n");
                if(deck[i] == 18) System.out.print("6 of Diamonds\n");
                if(deck[i] == 19) System.out.print("7 of Diamonds\n");
                if(deck[i] == 20) System.out.print("8 of Diamonds\n");
                if(deck[i] == 21) System.out.print("9 of Diamonds\n");
                if(deck[i] == 22) System.out.print("10 of Diamonds\n");
                if(deck[i] == 23) System.out.print("Jack of Diamonds\n");
                if(deck[i] == 24) System.out.print("Queen of Diamonds\n");
                if(deck[i] == 25) System.out.print("King of Diamonds\n");
                if(deck[i] == 26) System.out.print("Ace of Diamonds\n");
                if(deck[i] == 27) System.out.print("2 of Hearts\n");
                if(deck[i] == 28) System.out.print("3 of Hearts\n");
                if(deck[i] == 29) System.out.print("4 of Hearts\n");
                if(deck[i] == 30) System.out.print("5 of Hearts\n");
                if(deck[i] == 31) System.out.print("6 of Hearts\n");
                if(deck[i] == 32) System.out.print("7 of Hearts\n");
                if(deck[i] == 33) System.out.print("8 of Hearts\n");
                if(deck[i] == 34) System.out.print("9 of Hearts\n");
                if(deck[i] == 35) System.out.print("10 of Hearts\n");
                if(deck[i] == 36) System.out.print("Jack of Hearts\n");
                if(deck[i] == 37) System.out.print("Queen of Hearts\n");
                if(deck[i] == 38) System.out.print("King of Hearts\n");
                if(deck[i] == 39) System.out.print("Ace of Hearts\n");
                if(deck[i] == 40) System.out.print("2 of Spades\n");
                if(deck[i] == 41) System.out.print("3 of Spades\n");
                if(deck[i] == 42) System.out.print("4 of Spades\n");
                if(deck[i] == 43) System.out.print("5 of Spades\n");
                if(deck[i] == 44) System.out.print("6 of Spades\n");
                if(deck[i] == 45) System.out.print("7 of Spades\n");
                if(deck[i] == 46) System.out.print("8 of Spades\n");
                if(deck[i] == 47) System.out.print("9 of Spades\n");
                if(deck[i] == 48) System.out.print("10 of Spades\n");
                if(deck[i] == 49) System.out.print("Jack of Spades\n");
                if(deck[i] == 50) System.out.print("Queen of Spades\n");
                if(deck[i] == 51) System.out.print("King of Spades\n");
                if(deck[i] == 52) System.out.print("Ace of Spades\n");
            }
            System.out.print("\n");
            //String blank = br.readLine();
        }
    }
}
