import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int autoID = scan.nextInt();
            int numCells = scan.nextInt();
            String target = scan.next();
            //System.out.println(autoID + " " + numCells + " " + target);

            int[][][] key = automaton(autoID);
            //System.out.print("For Debug");

            int[] targetArray = getTarget(target);
            //System.out.print("For Debug");

            boolean reachable = isntEden(key, targetArray);
            if(reachable) {
                System.out.print("REACHABLE\n");
            }
            else {
                System.out.print("GARDEN OF EDEN\n");
            }
        }


    }

    public static int[][][] automaton(int id) {
        int[][][] key = new int[2][2][2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < 2; k++) {
                    key[i][j][k] = id % 2;
                    id = id / 2;
                }
            }
        }
        return key;
    }

    //https://stackoverflow.com/questions/8033550/convert-integer-to-array-of-digits
    //Found this function here
    public int[] getTarget(String target) {
        int targetArray[] =new int [target.length()];
        for(int i = 0; i < target.length(); i++) {
            targetArray[i] = target.charAt(i) - '0';
        }
        return targetArray;
    }

    public boolean candidacy(int[][][] key, int mid, int rule) {
        for(int i = 0; i < 2; i++) {
            for(int k = 0; k < 2; k++) {
                if(key[i][mid][k] == rule) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking(int[][][] key, int[] targetArray, int[] reach, int begin, int end) {
        if(begin == reach.length - 1) {
            if(key[reach[begin - 1]][reach[begin]][reach[0]] == targetArray[begin] && reach[begin] == end) {
                return true;
            }
            else {
                return false;
            }
        }

        for(int i = 0; i < 2; i++) {
            if(key[reach[begin - 1]][reach[begin]][i] == targetArray[begin]) {
                reach[begin + 1] = i;
                if(backTracking(key, targetArray, reach, begin + 1, end)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isntEden(int[][][] key, int[] targetArray) {
        int[] reach = new int[targetArray.length];

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++) {
                    if(key[i][j][k] == targetArray[0] && candidacy(key, i, targetArray[targetArray.length - 1])) {
                        reach[reach.length - 1] = i;
                        reach[0] = j;
                        reach[1] = k;
                        if(backTracking(key, targetArray, reach, 1, i)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }



}
