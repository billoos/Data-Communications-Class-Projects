class ShortestPath {

    private int numNodes;
    private String[] path;
    ShortestPath(int numNodes)
    {
        this.numNodes = numNodes;
        path = new String [numNodes];
        for(int i = 0; i<numNodes; i++)
        {
            path[i] = "";
        }
    }
    int minDistance(double distance[], Boolean visited[]) {
        double min = Double.MAX_VALUE;
        int min_index = -1;
        for (int i = 0; i < numNodes; i++)
            if (visited[i] == false && distance[i] <= min) {
                min = distance[i];
                min_index = i;
            }
        return min_index;
    }
    void printSolution(double distance[],int source) {
        for(int i = 0; i<path.length;i++)
        {
            for(int j = 0; j<path[i].length();j++)
            {
                if(j == 0)
                {
                    if(path[i].charAt(j)!= source)
                    {
                        Character c = path[i].charAt(j);
                        int index = c.getNumericValue(c);
                        path[i] = path[index] + path[i];
                    }
                }
            }
        }
        for(int i =0 ;i<numNodes;i++)
        {
            if(i!=source)
            {
                path[i] = path[i] + i;
            }
        }
        for(int i = 0 ; i<numNodes;i++)
        {
            if(path[i].length()!=0)
            {
                System.out.print("shortest path to node " + i + " is " );
            }
            for(int j = 0; j<path[i].length();j++)
            {
                System.out.print(path[i].charAt(j));
                if(j!= path[i].length()-1)
                {
                    System.out.print("->");
                }
            }
            if(path[i].length()!=0)
            {
                System.out.print(" with cost "+ distance[i]);
                System.out.println();
            }
        }
    }
    void dijkstra(double infoMatrix[][], int source) {
        double dist[] = new double[numNodes];
        Boolean sptSet[] = new Boolean[numNodes];
        for (int i = 0; i < numNodes; i++) {
            dist[i] = Double.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[source] = 0;
        for (int count = 0; count < numNodes - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < numNodes; v++)
                if (!sptSet[v] && infoMatrix[u][v] != 0 && dist[u] != Double.MAX_VALUE && dist[u] + infoMatrix[u][v] < dist[v])
                {
                    dist[v] = dist[u] + infoMatrix[u][v];
                    path[v] = path[v] + u;
                }
        }
        printSolution(dist,source);
    }
}

