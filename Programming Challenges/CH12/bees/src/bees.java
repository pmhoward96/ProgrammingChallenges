import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        int Max = 1000000;
        int[][] moves = new int[5][2];
        moves[0][0] = 0; moves[0][1] = 1;
        moves[1][0] = -1; moves[1][1] = 0;
        moves[2][0] = 0; moves[2][1] = -1;
        moves[3][0] = 1; moves[3][1] = -1;
        moves[4][0] = 1; moves[4][1] = 0;

        int[][] majaMapCoords = new int[Max + 1][2];
        int n;

        for(int num = 2, next = 1; num <= Max; ++next) {
            for(int i = 0; i < 5 && num <= Max; ++i) {
                if(i == 1) {
                    for (int j = 0; j < next - 1 && num <= Max; ++j, ++num) {
                        majaMapCoords [num][0] = majaMapCoords [num - 1][0] - 1;
                        majaMapCoords [num][1] = majaMapCoords [num - 1][1] + 1;
                    }
                }
                for (int j = 0; j < next && num <= Max; ++j, ++num) {
                    majaMapCoords [num][0] = majaMapCoords [num - 1][0] + moves[i][0];
                    majaMapCoords [num][1] = majaMapCoords [num - 1][1] + moves[i][1];
                }
            }
        }
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            n = scan.nextInt();
            System.out.print(majaMapCoords[n][0] + " " + majaMapCoords[n][1] + "\n");

        }
    }
}
