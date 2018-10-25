import java.util.Arrays;
import java.util.Scanner;

class Main {

     public static void main(String[] args) {
         Main main = new Main();
         main.begin();

     }

     void begin() {
         Scanner scan = new Scanner(System.in);
         int testCases = scan.nextInt();
         for(int l = 0; l < testCases; l++){
             int numFreckles = scan.nextInt();
             float[][] freckles = new float[numFreckles][2];
             for(int i = 0; i < numFreckles; i++) {
                 freckles[i][0] = scan.nextFloat();
                 freckles[i][1] = scan.nextFloat();
             }
             float[][] distances = new float[numFreckles][numFreckles];

             for(int i = 0; i < numFreckles; i++){
                 float totDistance = 0;
                 for(int j = 0; j < numFreckles; j++) {
                     if (i != j) {
                         float x1 = freckles[i][0];
                         float x2 = freckles[j][0];
                         float y1 = freckles[i][1];
                         float y2 = freckles[j][1];
                         distances[i][j] = (float) Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
                     }
                 }

             }

             float minTotal = prim(distances, numFreckles);
             System.out.print(round2(minTotal, 2) + "\n\n");

//             for(int i = 0; i < numFreckles; i++) {
//                 System.out.print("\nFreckle Number " + i + " ");
//                 for(int j = 0; j < numFreckles; j++) {
//                     System.out.print(distances[i][j] + ",");
//                 }
//             }





         }
     }
    public static float round2(float number, int scale) {
        int pow = 10;
        for (int i = 1; i < scale; i++)
            pow *= 10;
        float tmp = number * pow;
        return ( (float) ( (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) ) ) / pow;
    }

     float prim(float graph[][], int numFreckles) {
         int[] parent = new int[numFreckles];
         float[] key = new float[numFreckles];

         boolean mstSet[] = new boolean[numFreckles];
         for(int i = 0; i < numFreckles; i++) {
             key[i] = Integer.MAX_VALUE;
             mstSet[i] = false;
         }

         key[0] = 0;
         parent[0] = -1;

         for(int i = 0; i < numFreckles - 1; i++) {
             int u = minKey(key, mstSet, numFreckles);
             mstSet[u] = true;

             for(int j = 0; j < numFreckles; j++) {
                 if(graph[i][j] != 0 && mstSet[j] == false && graph[i][j] < key[j] ) {
                     parent[j] = i;
                     key[j] = graph[i][j];
                 }
             }
         }
         float minTotal = 0;
         for(int i = 1; i < numFreckles; i++) {
             minTotal = minTotal + graph[i][parent[i]];
         }

         return minTotal;
     }

     int minKey(float key[], boolean mstSet[], int numFreckles) {
         float min = Integer.MAX_VALUE;
         int minPos = -1;
         for(int i = 0; i < numFreckles; i++){
             if(mstSet[i] == false && key[i] < min) {
                 min = key[i];
                 minPos = i;
             }
         }
         return minPos;
     }
}
