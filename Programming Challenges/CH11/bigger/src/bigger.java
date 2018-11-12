import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main2 {

    public static void main(String[] args) throws IOException{
	// write your code here
        Main2 main = new Main2();
        main.begin();
    }
    class Elephant implements Comparable<Elephant>{
        public int weight;
        public int iq;
        public int id;

        Elephant(int w, int q, int i) {
            weight = w;
            iq = q;
            id = i;
        }

        @Override
        public int compareTo(Elephant e) {
            return this.weight-e.weight;
        }
    }

    void begin() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Elephant> elephantsList = new ArrayList<Elephant>();
        int count = 1;
        while(true) {
            String w = br.readLine();

            if (w.equals("") || w == null) {
                break;
            }
            StringTokenizer st = new StringTokenizer(w);
            int weight = Integer.parseInt(st.nextToken());
            //System.out.println(count);
            int iq = Integer.parseInt(st.nextToken());
            //System.out.println(count);
            Elephant temp = new Elephant(weight, iq, count);
            elephantsList.add(temp);
            count++;
        }
        //System.out.print(elephants);
        Elephant[] elephants = elephantsList.toArray(new Elephant[elephantsList.size()]);
        Arrays.sort(elephants);

        int n = elephants.length;
        int[] q = new int[n];
        q[0] = 1;

        for(int i = 1; i < n; i++) {
            q[i] = Math.max(1, q[i]);
            for(int j = 0; j < i; j++) {
                if(elephants[i].iq < elephants[j].iq && elephants[i].weight > elephants[j].weight) {
                    q[i] = Math.max(q[j] + 1, q[i]);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < q.length; i++) {
            max = Math.max(q[i], max);
        }

        int[] answer = new int[max];
        boolean first = true;
        int last = 0;
        System.out.print(max + "\n");
        for(int i = q.length -1; i >=0 && max > 0; i--) {
            if(q[i] == max) {
                if(last < elephants[i].iq || first) {
                    last = elephants[i].iq;
                    answer[--max] = elephants[i].id;
                    first = false;
                }
            }
        }

        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + "\n");
        }

    }
}
