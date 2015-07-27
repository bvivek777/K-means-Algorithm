package main;
import java.io.*;
import compute.*;
public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Kmeans kmean = new Kmeans();
		kmean.getInput(args[0]);
    	kmean.kmeanCompute(2);
	}

}
