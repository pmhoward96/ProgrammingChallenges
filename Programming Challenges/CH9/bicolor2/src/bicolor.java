import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.begin();
    }

    void begin() {
        Scanner scan = new Scanner(System.in);
        int numVert = scan.nextInt();
        while(numVert != 0) {
            int numEdges = scan.nextInt();
            Node[] nodes = new Node[numVert];
            for(int i = 0; i < numVert; i++) {
                Node temp = new Node();
                temp.setColor("blank");
                nodes[i] = temp;
            }

            for(int i = 0; i < numEdges; i++) {
                int s = scan.nextInt();
                int d = scan.nextInt();
                nodes[s].addConnection(d);
                nodes[d].addConnection(s);
            }

            if(bicolarable(nodes)) {
                System.out.print("BICOLORABLE.\n");
            }
            else {
                System.out.print("NOT BICOLORABLE.\n");
            }







            numVert = scan.nextInt();
        }
    }

    public boolean bicolarable(Node[] nodes) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        Node current = nodes[0];
        current.setColor("black");
        int count = 0;

        while(!stack.isEmpty()) {

            current = nodes[stack.pop()];
//            if(current.getColor() == "blank") {
//                current.setColor("black");
//            }
            for(int i = 0; i < current.getNumConnections(); i++) {
                count++;
                if(nodes[current.getConnections().get(i)].getColor() == current.getColor()) {

                    //System.out.println(count);
                    return false;

                }
                if(nodes[current.getConnections().get(i)].getColor() == "blank") {
                    if(current.getColor() == "black") {
                        nodes[current.getConnections().get(i)].setColor("red");
                    }
                    else {
                        nodes[current.getConnections().get(i)].setColor("black");
                    }
                    stack.push(current.getConnections().get(i));
                }
            }
        }
        return true;

    }

    class Node{
        String color = "";
        ArrayList<Integer> connections = new ArrayList<Integer>(200);
        int numConnections = 0;
        void setColor(String c) {
            color = c;
        }
        String getColor() {
            return color;
        }

        void addConnection(int i) {
            connections.add(i);
            numConnections++;
        }

        ArrayList<Integer> getConnections() {
            return connections;
        }

        int getNumConnections() {
            return numConnections;
        }
    }
}
