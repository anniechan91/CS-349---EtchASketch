import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class AddPoints {
	//List of x-coordinates
	private List<Integer> xList; 
	//List of y-coordinates
	private List<Integer> yList; 

	//Constructor
	public AddPoints() {
		xList = new ArrayList<Integer>();
		yList = new ArrayList<Integer>();
	}

	//Adds a point
	public void addPoint(int x, int y) {
		xList.add(x);
		yList.add(y);
	}

	//Draws the lines using the points
	public void DrawPoints(Graphics g) { 
		for (int i = 0; i < xList.size() - 1; ++i) {
			g.drawLine((int) xList.get(i), (int) yList.get(i), (int) xList.get(i + 1), (int) yList.get(i + 1));
		}
	}
}
