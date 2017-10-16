package com.amazon.qualification;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class GolfCourse
{        
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int levelFieldTime(int numRows, int numColumns, List<List<Integer>> field)
    {
         // WRITE YOUR CODE HERE
        int time = 0;
    	int[][] matrix = new int[numRows][numColumns];
    	ArrayList<Point> treesPoints = new ArrayList<Point>();
    	treesPoints.add(new Point(0, 0, field.get(0).get(0)));
    	for(int i=0;i< numRows;i++) {
    		for(int j=0;j<numColumns;j++) {
    			
    			matrix[i][j] = field.get(i).get(j);
    			if(matrix[i][j] > 1) {
    				treesPoints.add(new Point(i,j,matrix[i][j]));
    				time = time + matrix[i][j];
    			}
    		}
    	}
    	
    	Collections.sort(treesPoints,new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				
				return o1.value-o2.value;
			}
		});
    	
    	
    	for(int i=0;i<treesPoints.size()-1;i++) {
    		Point current = treesPoints.get(i+1);
    		time = time + findDistance(matrix,treesPoints.get(i),treesPoints.get(i+1),numRows,numColumns);
    		//System.out.println("dist -- > from "+current.x+","+current.y+ " "+dist);
    		matrix[current.x][current.y] = 1;
    	}
    	
    	return time;
    }
    // METHOD SIGNATURE ENDS
    
    class Point{
    	int x,y;
    	int value;
    	
    	Point(int x,int y,int value){
    		this.x = x;
    		this.y = y;
    		this.value = value;
    	}
    	@Override
    	public int hashCode() {
    		// TODO Auto-generated method stub
    		return (new Integer(x+y)).hashCode();
    	}
    	@Override
    	public boolean equals(Object obj) {
    		// TODO Auto-generated method stub
    		if( obj instanceof Point) {
    			return this.x == ((Point)obj).x && this.y == ((Point)obj).y; 
    		}else {
    			return false;
    		}
    		
    	}
    }
    
    int findDistance(int[][] matrix, Point dest,Point start,int N,int M) {
    	 LinkedList<Point> currentPoints = new LinkedList<Point>();
    	 LinkedList<Point> nextPoints = new LinkedList<Point>();
    	currentPoints.add(start);
    	int dist = 0;
    	while(!currentPoints.isEmpty()) {
    	Point current = currentPoints.remove(0);
    	if(current.equals(dest)) {
    		return dist;
    	}else {
    		Point left = getLeftPoint(current.x,current.y,matrix,N,M);
    		Point right = getRightPoint(current.x,current.y,matrix,N,M);
    		Point top = getTopPoint(current.x,current.y,matrix,N,M);
    		Point bottom = getBottomPoint(current.x,current.y,matrix,N,M);
    		if(left != null) {
    			nextPoints.add(left);
    		}
    		if(right != null) {
    			nextPoints.add(right);
    		}
    		if(top != null) {
    			nextPoints.add(top);
    		}
    		if(bottom != null) {
    			nextPoints.add(bottom);
    		}
    		
    	}
    	if(currentPoints.size() == 0){
    		currentPoints = nextPoints;
    		nextPoints = new LinkedList<Point>();
    		dist++;
    	}
    	}
    	return dist;
    }
    
	
    public Point getLeftPoint(int x,int y,int[][] matrix,int n, int m){
		if(y<=0 || matrix[x][y-1] != 1){
			return null;
		}
		return new Point(x,y-1,matrix[x][y-1]);
	}
	
	public Point getTopPoint(int x,int y,int[][] matrix,int n, int m){
		if(x<=0 || matrix[x-1][y] != 1){
			return null;
		}
		return new Point(x-1,y,matrix[x-1][y]);
	}
	
	public Point getRightPoint(int x,int y,int[][] matrix,int n,int m){
		if(y >=m-1 || matrix[x][y+1] != 1){
			return null;
		}
		return new Point(x,y+1,matrix[x][y+1]);
	}
	
	public Point getBottomPoint(int x,int y,int[][] matrix,int n,int m){

		if(x >=n-1 || matrix[x+1][y] != 1){
			return null;
		}
		return new Point(x+1,y,matrix[x+1][y]);
	}

	List<List<Integer>> closestLocations(int totalCrates, 
            List<List<Integer>> allLocations, 
            int truckCapacity)
{

		Collections.sort(allLocations,new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				int x1 = o1.get(0);
				int y1 = o1.get(1);
				int x2 = o2.get(0);
				int y2 = o2.get(1);
				return (x1*x1 + y1*y1) - (x2*x2 + y2*y2);
			}
		});
		List<List<Integer>> solution = new ArrayList<List<Integer>>();
		for(int i=0;i<truckCapacity;i++) {
			solution.add(allLocations.get(i));
		}
		return solution;
}
}