import java.util.*;

class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int numLocations = scan.nextInt();
        int mapNumber = 1;
        //System.out.println();
        while(numLocations != 0) {
            String[] locations = new String[numLocations];
            for(int i = 0; i < numLocations; i++) {
                locations[i] = scan.next();
            }
            int numConnections = scan.nextInt();
            Graph map = new Graph(numLocations);
            for(int i = 0; i < numConnections; i++) {
                String a = scan.next();
                String b = scan.next();
                int x = 0, y = 0;
                for(int j = 0; j < numLocations; j++) {
                    if(a.equals(locations[j])) {
                        x = j;
                    }
                    if(b.equals(locations[j])) {
                        y = j;
                    }
                }
                map.addConnection(x, y);
            }

            boolean[] cameras = map.AP();
            int numCameras = 0;
            ArrayList<String> camLocations = new ArrayList<String>();
            for(int i = 0; i < numLocations; i++) {
                if(cameras[i] == true) {
                    numCameras++;
                    camLocations.add(locations[i]);
                }
            }

            //System.out.print("City map #" + mapNumber + ": " + numCameras + " camera(s) found\n");
            //mapNumber++;
            Collections.sort(camLocations);
//            for(int i = 0; i < camLocations.size(); i++) {
//                System.out.print(camLocations.get(i) + "\n");
//            }
            //System.out.print("\n");
            if(mapNumber > 1) {
                System.out.println();
            }
            StringBuilder sb=new StringBuilder();
            sb.append("City map #");
            sb.append(mapNumber++);
            sb.append(": ");
            sb.append(numCameras);
            sb.append(" camera(s) found\n");
            for (int i=0;i<numCameras;i++) {
                sb.append(camLocations.get(i));
                sb.append('\n');
            }
            System.out.print(sb.toString());
            //System.out.println("");

            numLocations = scan.nextInt();
        }
    }
}

class Graph {
    private int numVert;
    private LinkedList<Integer> adj[];
    int time = 0;
    static final int NIL = -1;

    Graph(int n) {
        numVert = n;
        adj = new LinkedList[n];
        for(int i = 0; i < numVert; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addConnection(int i, int j) {
        adj[i].add(j);
        adj[j].add(i);
    }

    //Utility function found at https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
    void APUtil(int u, boolean visited[], int disc[],
                int low[], int parent[], boolean ap[])
    {

        // Count of children in DFS Tree
        int children = 0;

        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;

        // Go through all vertices aadjacent to this
        Iterator<Integer> i = adj[u].iterator();
        while (i.hasNext())
        {
            int v = i.next();  // v is current adjacent of u

            // If v is not visited yet, then make it a child of u
            // in DFS tree and recur for it
            if (!visited[v])
            {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap);

                // Check if the subtree rooted with v has a connection to
                // one of the ancestors of u
                low[u]  = Math.min(low[u], low[v]);

                // u is an articulation point in following cases

                // (1) u is root of DFS tree and has two or more chilren.
                if (parent[u] == NIL && children > 1)
                    ap[u] = true;

                // (2) If u is not root and low value of one of its child
                // is more than discovery value of u.
                if (parent[u] != NIL && low[v] >= disc[u])
                    ap[u] = true;
            }

            // Update low value of u for parent function calls.
            else if (v != parent[u])
                low[u]  = Math.min(low[u], disc[v]);
        }

    }
    //Articulation Point Algorithm found at https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
    boolean[] AP()
    {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[numVert];
        int disc[] = new int[numVert];
        int low[] = new int[numVert];
        int parent[] = new int[numVert];
        boolean ap[] = new boolean[numVert]; // To store articulation points

        // Initialize parent and visited, and ap(articulation point)
        // arrays
        for (int i = 0; i < numVert; i++)
        {
            parent[i] = NIL;
            visited[i] = false;
            ap[i] = false;
        }

        // Call the recursive helper function to find articulation
        // points in DFS tree rooted with vertex 'i'
        for (int i = 0; i < numVert; i++)
            if (visited[i] == false)
                APUtil(i, visited, disc, low, parent, ap);

        // Now ap[] contains articulation points, print them
        return ap;
    }
}
