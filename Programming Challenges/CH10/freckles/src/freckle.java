import java.text.DecimalFormat;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for(int t = 0; t < testCases; t++) {
            int numNodes = scan.nextInt();
            double nodes[][] = new double[numNodes][2];
            double graph[][] = new double[numNodes][numNodes];
            for(int i = 0; i < numNodes; i++) {
                nodes[i][0] = scan.nextFloat();
                nodes[i][1] = scan.nextFloat();
            }

            for(int i = 0; i < numNodes; i++) {
                for(int j = 0; j < numNodes; j++) {
                    if(i == j) {
                        graph[i][j] = 0;
                    }
                    else {
                        double x1 = nodes[i][0];
                        double y1 = nodes[i][1];
                        double x2 = nodes[j][0];
                        double y2 = nodes[j][1];
                        double dis = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
                        graph[i][j] = dis;
                    }
                }
            }




            MST mst = new MST();
            mst.V = numNodes;
            double weight = mst.printMST(graph);
            DecimalFormat f = new DecimalFormat("##.00");
            if(t != 0) {
                System.out.print("\n");
            }

            if(f.format(weight).equals(".00")) {
                System.out.print("0" + f.format(weight) + "\n");
            }
            else {
                System.out.print(f.format(weight) + "\n");
            }
            //System.out.print(weight);
        }

    }


}

class MST {
    public int V;

    int minKey(double key[], boolean mstSet[]) {
        double min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int v = 0; v < V; v++) {
            if(mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    double printMST(double graph[][]) {
        int parent[] = new int[V];
        double key[] = new double[V];
        boolean mstSet[] = new boolean[V];
        for(int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for(int i = 0; i < V -1; i++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for(int v = 0; v < V; v++) {
                if(graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        double weight = 0;
        for(int i = 1; i < V; i++) {
            weight += graph[i][parent[i]];
        }
        return weight;
    }
}
