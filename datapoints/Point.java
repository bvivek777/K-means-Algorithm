package datapoints;

import java.util.*;

public class Point {
	
	private List<Integer> dimensions = new ArrayList<Integer>();
	
	public void addDimension(int value){
		dimensions.add(value);
	}

	public List<Integer> getDimensions() {
		return dimensions;
	}

	public void setDimensions(List<Integer> dimensions) {
		this.dimensions = dimensions;
	}
	
	public void display(){
		for(int i=0;i<dimensions.size();i++){
			System.out.print(dimensions.get(i));
			if(i == dimensions.size()-1)
				System.out.print("||");
			else
				System.out.print(",");
		}
	}
	
	public void clear(){
		dimensions.clear();
	}
	
	int getNoOfDimensions(){
		return dimensions.size();
	}
}
