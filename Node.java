

public class Node {
	
	double fitness;
	int[] path;
	
	public Node(int length) {
		path = new int[length];
	}
	
	public void copy(int [] toCopy) {
		for(int i = 0; i < toCopy.length; i++) {
			path[i] = toCopy[i];
		}
	}
	
	public void mutate() {
		double mutRate = HW_4_Main.getMutationRate();
		if(HW_4_Main.getRandom() <= mutRate) {
			int pos1 = (int) (HW_4_Main.getRandom() * path.length);
			int pos2 = (int) (HW_4_Main.getRandom() * path.length);
			
			while (pos1 == pos2) {
				pos2 = (int) (HW_4_Main.getRandom() * path.length);
			}
			
			int temp = path[pos1];
			path[pos1] = path[pos2];
			path[pos2] = temp;
		}
		calcFitness();
	}
	
	public void calcFitness() {
		fitness = 0;
		for(int i = 1; i < path.length; i++) {
			fitness += HW_4_Main.getData(path[i - 1], path[i]);
		}
	}
	
	public void setPathPos(int pos, int value) {
		path[pos] = value;
	}
	
	public void shuffel() {
		int pos1, pos2, temp;
		
		for(int i = 0; i < path.length; i++) {
			pos1 = (int) (HW_4_Main.getRandom() * path.length);
			pos2 = (int) (HW_4_Main.getRandom() * path.length);
			temp = path[pos1];
			path[pos1] = path[pos2];
			path[pos2] = temp;
		}
		calcFitness();
	}
}
