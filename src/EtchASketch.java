import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EtchASketch extends JFrame {

	//Setting the size of the SketchArea
	public static final int CANVAS_WIDTH = 650;
	public static final int CANVAS_HEIGHT = 400;

	private ArrayList<AddPoints> PointsArrayList = new ArrayList<AddPoints>();
	private AddPoints CurrentPoints;

	public EtchASketch() {
		SketchArea SketchArea = new SketchArea();
		SketchArea.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		
		//Creating MouseAdapter
		SketchArea.addMouseListener(new MouseAdapter() {

			//When the mouse is pressed, it adds the points to the PointsArrayList
			@Override
			public void mousePressed(MouseEvent evt) {
				CurrentPoints = new AddPoints();
				PointsArrayList.add(CurrentPoints);
				CurrentPoints.addPoint(evt.getX(), evt.getY());
			}
		});

		//The points from whatever is drawn are added to the PointsArrayList 
		SketchArea.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {
				CurrentPoints.addPoint(evt.getX(), evt.getY());
				repaint();
			}
		});

		//Clear Button stuff
		JButton ClearButton = new JButton("Clear");
		ClearButton.setPreferredSize(new Dimension(100, 20));
		SketchArea.add(ClearButton);
		
		ClearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == ClearButton)
					PointsArrayList.clear();
					repaint();
			}
		});

		pack();
		setVisible(true);
		
		setContentPane(SketchArea);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Etch-A-Sketch");	
	}

	//Keeps the drawing even after resizing window
	private class SketchArea extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (AddPoints CurrentPoints : PointsArrayList) {
				CurrentPoints.DrawPoints(g);
			}
		}
	}

	public static void main(String[] args) {
		new EtchASketch();
	}
}
