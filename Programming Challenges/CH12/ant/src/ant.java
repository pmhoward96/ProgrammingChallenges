import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	Main main = new Main();
	main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        while (N != 0) {
            int nearestSquare = (int)Math.ceil(Math.sqrt(N));
            //System.out.println(nearestSquare);
            int previousSquare = (nearestSquare-1) * (nearestSquare-1);

            if(nearestSquare % 2 == 1) {
                int x = nearestSquare;
                int up = Math.min(N - previousSquare, nearestSquare);
                int y = up;
                int left = 0;
                if(N - previousSquare > up) {
                    left = N - previousSquare - up;
                }
                x = x - left;
                System.out.print(x + " " + y + "\n");
            }
            else {
                int x = 0;
                int y = nearestSquare;
                int right = Math.min(N - previousSquare, nearestSquare);
                x = x + right;
                int down = 0;
                if(N - previousSquare > right) {
                    down = N - previousSquare - right;
                }
                y = y - down;
                System.out.print(x + " " + y + "\n");
            }




            N = scan.nextInt();
        }
    }
}
