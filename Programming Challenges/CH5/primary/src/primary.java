import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        // write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] ss = s.split(" ");
        int top = Integer.parseInt(ss[0]);
        int bot = Integer.parseInt(ss[1]);
        while(true) {
            if(top == 0 && bot == 0) {
                break;
            }


            int carries = 0;
            int r = 0;
            //int digitNum = 1;
            while(top != 0 || bot != 0) {


                int total = (top % 10) + (bot % 10) + r;
                if(total >= 10) {
                    carries++;

                }
                r = total / 10;
                top = top / 10;
                bot = bot / 10;



            }
            if(carries == 0) {
                System.out.print("No carry operation.\n");
            }
            else if(carries == 1) {
                System.out.print("1 carry operation.\n");
            }
            else {
                System.out.print(carries + " carry operations.\n");
            }


//            for( int i = 0; i < top.length; i++) {
//                System.out.print(top[i] + " ");
//            }
//            System.out.println("");
//
//            for(int i = 0; i < bot.length; i++) {
//                System.out.print(bot[i] + " ");
//            }
//            System.out.println("");

            s = scan.nextLine();
            ss = s.split(" ");
            top = Integer.parseInt(ss[0]);
            bot = Integer.parseInt(ss[1]);
        }

    }
}
