import java.math.BigInteger;
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
        int testCases = scan.nextInt();
        for(int t = 0; t < testCases; t++) {
            String mainString = scan.next();
            String subString = scan.next();

            char[] ms = mainString.toCharArray();
            char[] ss = subString.toCharArray();

            BigInteger[][] occurances = new BigInteger[ms.length][ss.length];
            //Arrays.fill(occurances, null);
            for(int i = 0; i < ms.length; i++) {
                for(int j = 0; j < ss.length; j++) {
                    occurances[i][j] = null;
                }
            }
            BigInteger numOccurances = getOcurrance(occurances,0, 0, ms, ss);
            System.out.print(numOccurances.toString() + "\n");
        }
    }

    static BigInteger getOcurrance(BigInteger[][] occur, int mPos, int sPos, char[] mArray, char[]sArray) {
        if(sPos == sArray.length) {
            return BigInteger.ONE;
        }
        if(mPos == mArray.length) {
            return BigInteger.ZERO;
        }

        if(occur[mPos][sPos] == null) {
            BigInteger o = getOcurrance(occur, mPos + 1, sPos, mArray, sArray);
            if(mArray[mPos] == sArray[sPos]) {
                o = o.add(getOcurrance(occur, mPos + 1, sPos + 1, mArray, sArray));
            }
            occur[mPos][sPos] = o;
        }

        return occur[mPos][sPos];
    }
}
