import java.util.*;

public class RiverSizes {

	public static List<Integer> riverSizes(int[][] matrix) {
    int n=matrix.length;
    int m=matrix[0].length;
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    LinkedList<AbstractMap.SimpleEntry<Integer, Integer>> visited = new LinkedList<>();
    LinkedList<LinkedList<AbstractMap.SimpleEntry<Integer, Integer>>> connectedComponents = new LinkedList<>();
    for (int i=0;i<n;i++) {
    	for (int j=0;j<m;j++) {

    		if (matrix[i][j]==1 && !visited.contains(new AbstractMap.SimpleEntry<Integer,Integer>(i,j))) {
    			LinkedList<AbstractMap.SimpleEntry<Integer, Integer>> visitedNodes = new LinkedList<>();
    			LinkedList <AbstractMap.SimpleEntry<Integer, Integer>> toVisit = new LinkedList<>(
    				Arrays.asList(new AbstractMap.SimpleEntry<>(i,j))
    			);
    			while (toVisit.size()>0) {
    				AbstractMap.SimpleEntry<Integer, Integer> currNode = toVisit.pop();
    				visitedNodes.add(currNode);
            visited.add(currNode);
    				for (int dirIndex=0;dirIndex<directions.length;dirIndex++) {
  						if (currNode.getKey()+directions[dirIndex][0]>=0 &&
  							currNode.getKey()+directions[dirIndex][0]<n &&
  						  currNode.getValue()+directions[dirIndex][1]>=0 &&
  						  currNode.getValue()+directions[dirIndex][1]<m) {
                int in = currNode.getKey()+directions[dirIndex][0];
                int jn = currNode.getValue()+directions[dirIndex][1];
  							if (matrix[in][jn]==1) {
                  AbstractMap.SimpleEntry<Integer, Integer> currNeighbor = new AbstractMap.SimpleEntry<>(
                    in,jn
                  );
                  if (!visitedNodes.contains(currNeighbor) && !toVisit.contains(currNeighbor)) {
                    toVisit.push(currNeighbor);
                  };
  							}
  						}
    				}
    			}
          connectedComponents.push(visitedNodes);
    		}
    	}
    }
    ArrayList riverSizes = new ArrayList<Integer>();
    for (int river=0;river<connectedComponents.size();river++) {
      riverSizes.add(connectedComponents.get(river).size());
    }
    return riverSizes;
  }

	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1}
		};
		System.out.println(riverSizes(matrix));
	}	
}