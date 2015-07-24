package datapoints;

import java.util.*;

public class AllPoints {
	
	private List<Point> allPoints = new ArrayList<Point>();

	public List<Point> getAllPoints() {
		return allPoints;
	}

	public void setAllPoints(List<Point> allPoints) {
		this.allPoints = allPoints;
	}
	
	public void addPoints(Point point){
		allPoints.add(point);
	}
	
	public void removePoint(Point point){
		allPoints.remove(point);
	}
	
}
