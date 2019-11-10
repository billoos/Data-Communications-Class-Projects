import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LinkState {


    public static void main(String[] args) throws FileNotFoundException {
        String fileName;
        int idSourceNode;
        int numNodes;
        int a,b;
        double c;

        fileName = args[0];
        idSourceNode = Integer.parseInt(args[1]);

        FileReader file = new FileReader(fileName);
        Scanner sc = new Scanner(file);
        numNodes = sc.nextInt();

        double infoMatrix[][] = new double[numNodes][numNodes];


        while(sc.hasNext()) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextDouble();
            infoMatrix[a][b] = c;
            infoMatrix[b][a] = c;
        }
        ShortestPath t = new ShortestPath(numNodes);
        t.dijkstra(infoMatrix,idSourceNode);


    }
}
