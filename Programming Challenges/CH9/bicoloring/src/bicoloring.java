import java.util.Arrays;
import java.util.Scanner;

class Main2 {

    public static void main(String[] args) {
	// write your code here
        Main2 main = new Main2();
        main.begin();
    }
    void begin() {
        Scanner scan = new Scanner(System.in);
        int vertices = scan.nextInt();
        while(vertices != 0) {
            int[] vertColors = new int[vertices];
            Arrays.fill(vertColors, 0);
            int numEdges = scan.nextInt();
            int[][] edges = new int[numEdges][2];
            for(int i = 0; i < numEdges; i++) {
                edges[i][0] = scan.nextInt();
                edges[i][1] = scan.nextInt();
            }

//            for(int i = 0; i < numEdges; i++) {
////              for(int j = 0; j < 2; j++) {
////                    System.out.print(edges[i][j]);
////                }
////                System.out.println("");
////            }

            boolean bicolarable = bicolorable(edges, vertColors, numEdges);
            if(bicolarable) {
                System.out.print("BICOLORABLE.\n");
            }
            else {
                System.out.print("NOT BICOLORABLE.\n");
            }
            vertices = scan.nextInt();
        }
    }

    public boolean bicolorable(int[][] edges, int[] vertColors, int numEdges) {

        for(int i = 0; i < numEdges; i++) {
            //if first vert in edge blank
            if(vertColors[edges[i][0]] == 0) {
                //if second vert isnt blank
                if(vertColors[edges[i][1]] != 0) {
                    if(vertColors[edges[i][1]] == 1) {
                        vertColors[edges[i][0]] = 2;
                    }
                    else {
                        vertColors[edges[i][1]] = 1;
                    }
                }
                else {
                    vertColors[edges[i][0]] = 1;
                }
            }

            //if second vert in edge blank
            if(vertColors[edges[i][1]] == 0) {
                if(vertColors[edges[i][0]] == 1) {
                    vertColors[edges[i][1]] = 2;
                }
                else {
                    vertColors[edges[i][1]] = 1;
                }
            }

            //if neither are blank
            if(vertColors[edges[i][0]] == vertColors[edges[i][1]]) {
                return false;
            }

        }
        return true;
    }
}
