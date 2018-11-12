import java.util.*;

class Main {

     public static void main(String[] args) {
         Main main = new Main();
         main.begin();
     }

     void begin() {
         Scanner scan = new Scanner(System.in);
         String s = scan.nextLine();

         ArrayList<Elephants> eles = new ArrayList<>();
         int idCount = 1;
         while(!s.equals("") && s != null) {
             StringTokenizer st = new StringTokenizer(s);
             int weight = Integer.parseInt(st.nextToken());
             int iq = Integer.parseInt(st.nextToken());
             Elephants e = new Elephants();
             e.weight  = weight;
             e.iq = iq;
             e.id = idCount;
             idCount++;
             eles.add(e);
             s = scan.nextLine();
         }

         int[][] weights = new int[eles.size()][2];
         int[][] iqs = new int[eles.size()][2];

         for(int i = 0; i < eles.size(); i++) {
             weights[i][0] = eles.get(i).weight;
             iqs[i][0] = eles.get(i).iq;
             weights[i][1] = eles.get(i).id;
             iqs[i][1] = eles.get(i).id;
         }
         System.out.print("Hi");

         Arrays.sort(weights, new Comparator<int[]>() {
             @Override
             public int compare(int[] t1, int[] t2) {
                 return Integer.compare(t1[0], t2[0]);
             }
         });
         Arrays.sort(iqs, new Comparator<int[]>() {
             @Override
             public int compare(int[] t1, int[] t2) {
                 return Integer.compare(t1[0], t2[0]);
             }
         });

         System.out.print("Hi");
     }

     class Elephants {
         public int weight;
         public int iq;
         public int id;
     }
}
