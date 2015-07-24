package clusters;

import java.util.*;
import datapoints.Point;

public class Cluster {
	List<Point> points = new ArrayList<Point>();

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public void addPoints(Point point){
		points.add(point);
	}
	
	public void display(){
		for(int i =0;i<points.size();i++){
			points.get(i).display();

		}
	}
}
