import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int numScenarios = 1;
        int numCities = scan.nextInt();
        int numEdges = scan.nextInt();
        while(numCities != 0 && numEdges != 0) {
            int[][] edges = new int[110][110];
            //Arrays.fill(edges, 0);
            for (int i = 0; i < numEdges; i++) {
                int c1  = scan.nextInt() - 1;
                int c2 = scan.nextInt() - 1;
                int P  = scan.nextInt() - 1;
                edges[c1][c2] = P;
                edges[c2][c1] = P;
            }
            int start = scan.nextInt() - 1;
            int end = scan.nextInt() - 1;
            int tourists = scan.nextInt();

            for(int k = 0; k < numCities; k++){
                for(int i = 0; i < numCities; i++){
                    for(int j = 0; j < numCities; j++){
                        edges[i][j] = Math.max(edges[i][j], Math.min(edges[i][k], edges[k][j]));
                    }
                }
            }
            System.out.print("Scenario #" + numScenarios + "\n");
            System.out.print("Minimum Number of Trips = " + ((int)Math.ceil(1.0 * tourists / edges[start][end])) + "\n\n");
            numScenarios++;

            numCities = scan.nextInt();
            numEdges = scan.nextInt();
        }
    }
}



