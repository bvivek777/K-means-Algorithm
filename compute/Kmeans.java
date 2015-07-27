package compute;

import java.io.*;
import java.util.*;
import datapoints.*;
import clusters.*;

public class Kmeans {
	
	private List<Point> centers = new ArrayList<Point>();
	AllPoints allPoints = new AllPoints();
	public int numberOfCenters;
	/*List<Cluster> clusters = new ArrayList<Cluster>();*/
	
	/* Adds the dimensions to the points using the read string
	 * it breaks the string into separate  integers each which 
	 * describes a dimension of a given point  */
	private Point assignDimentionToPoint(String a){
		Point p = new Point();
		int k=0,j=0;
		for(j=0;j<a.length();j++){
			if(a.charAt(j)==' '){
				p.addDimension(Integer.parseInt(a.substring(k, j)));
				k = j+1;
			}
		}
		p.addDimension(Integer.parseInt(a.substring(k, j)));
		return p;
	}
	
	/* This function gets the input from the given data file 
	 * and stores it in the list of allPoints ,initial centers and it also assigns the 
	 * number of clusters centers for forming a cluster*/
	public void getInput(String path)throws IOException {
		String temp;
		BufferedReader b = new BufferedReader(new FileReader(path));
		numberOfCenters = Integer.parseInt(b.readLine());
		for(int i=0;i<numberOfCenters;i++){
			centers.add(assignDimentionToPoint(b.readLine()));
		}
		while((temp=b.readLine())!=null){
			allPoints.addPoints(assignDimentionToPoint(temp));
		}
		b.close();
	}
	
	/* This function computes the Manhattan distance between the two points and 
	 * returns the integer value, takes as argument two point objects */
	private int distance(Point p1,Point p2,int distFactor){
		int dist = 0;
		for(int j = 0;j<p1.getDimensions().size();j++){
				dist += Math.pow((p1.getDimensions().get(j)-p2.getDimensions().get(j)),distFactor);
		}
		return (int)Math.pow(dist,1/distFactor);
	}
	
	private void mean(Cluster[] c){
		int temp=0;
		for(int i=0;i<numberOfCenters;i++){
			int lim = centers.get(i).getDimensions().size();
			centers.get(i).clear();
			for(int k=0;k<lim;k++){
				temp = 0;
				for(int j=0;j<c[i].getPoints().size();j++)
					temp += c[i].getPoints().get(j).getDimensions().get(k);
				centers.get(i).addDimension(temp/c[i].getPoints().size());
			}
		}
	}
	
	public Cluster[] initCluster(int n){
		Cluster[] temp = new Cluster[n];
		for(int i=0;i<n;i++){
			Cluster c = new Cluster();
			temp[i]=c;	
		}
		return temp;
	}
	private boolean check(Cluster[] a,Cluster[] b){
		for(int i=0;i<numberOfCenters;i++){
			for(int j=0; j<a[i].getPoints().size();j++){
				if(a[i].getPoints().size()!=b[i].getPoints().size())
					return true;
				for(int k=0; k<a[i].getPoints().get(j).getDimensions().size();k++){
					if(a[i].getPoints().get(j).getDimensions().get(k)==b[i].getPoints().get(j).getDimensions().get(k)){
					}
					else
						return true;
				}
			}
		}
		return false;
	}
	
	public Cluster[] kmeanCompute(int distFactor){
		
		Cluster[] cluster = new Cluster[numberOfCenters];
		Cluster[] temp = new Cluster[numberOfCenters];
		int clusterNo=0,pointNo=0,min =0;
		cluster = initCluster(numberOfCenters);
		int flag = 0;
		boolean condition = true;
		while(condition){
			for(int i=0;i<numberOfCenters;i++){
				temp[i] = cluster[i];
			}
			cluster = initCluster(numberOfCenters);
			for(int j=0;j<allPoints.getAllPoints().size();j++){
				for(int i=0;i<centers.size();i++){
					if(i==0){
						min = distance(allPoints.getAllPoints().get(j),centers.get(i),distFactor);
						clusterNo = i;
						pointNo = j;
					}
					
					if(min >= distance(allPoints.getAllPoints().get(j),centers.get(i),distFactor)){
						clusterNo = i;
						pointNo = j;
						min = distance(allPoints.getAllPoints().get(j),centers.get(i),distFactor);
					}
				}
				Point p = allPoints.getAllPoints().get(pointNo);
				cluster[clusterNo].addPoints(p);
			}
			
			System.out.println("Iteration "+(flag+1)+"\n"+"-------------");
			for(int i=0;i<numberOfCenters;i++){
				System.out.println("Cluster "+(i+1));
				cluster[i].display();
				System.out.println();
			}
			System.out.println("===========================================================\n");
			mean(cluster);
			if(flag>0)
			condition = check(temp,cluster);
			flag++;
		}
		return cluster;
	}
}
