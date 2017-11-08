package GraphAPI;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		if (o1.getDistance() < o2.getDistance()) {
			return 1;
		}else if (o1.getDistance() > o2.getDistance()){
			return -1;
		}else{
			return 0;
		}
	}

}
