import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.begin();
    }

    void begin() throws IOException, NoSuchElementException{
        try {
            int fieldCount = 0;
            //Read Input
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

            String string;
            while ((string = r.readLine()) != null) {
                fieldCount++;
                StringTokenizer t = new StringTokenizer(string);
                int row = Integer.parseInt(t.nextToken());
                int col = Integer.parseInt(t.nextToken());
                //System.out.println(row + " " + col);
                if (col == 0 || row == 0) {
                    break;
                }

                char[][] board = new char[row][col];
                for (int i = 0; i < row; i++) {
                    string = r.readLine();
                    char[] ch = string.toCharArray();
                    for (int j = 0; j < col; j++) {
                        board[i][j] = ch[j];
                    }
                }
                if (fieldCount != 1) {
                    System.out.print("\n");
                }

                System.out.print("Field #" + fieldCount + ":" + "\n");
                for (int i = 0; i < row; i++) {
                    String rowStr = "";
                    for (int j = 0; j < col; j++) {
                        int mineCount = 0;
                        if (board[i][j] == '*') {
                            rowStr = rowStr + '*';
                        } else {
                            int rowUpper = Math.max(0, i - 1);
                            int colLeft = Math.max(0, j - 1);
                            int rowLower = Math.min(row, i + 2);
                            int colRight = Math.min(col, j + 2);

                            for (int k = rowUpper; k < rowLower; k++) {
                                for (int l = colLeft; l < colRight; l++) {


                                    if (board[k][l] == '*') {
                                        mineCount++;

                                    }
                                }
                            }
                            rowStr = rowStr + Integer.toString(mineCount);
                        }

                    }

                    System.out.print(rowStr + "\n");
                }

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
