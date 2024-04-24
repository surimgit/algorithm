package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class prob4 {
	public static void main(String[] args) {
		Point[] points = {
			new Point(2, 3),
			new Point(12, 6),
			new Point(4, 5),	
			new Point(6, 1),
			new Point(7, 10),
			new Point(9, 10),
			new Point(14, 9),
			new Point(16, 16),
			new Point(1, 13),
			new Point(17, 4)
		};
		
		System.out.println(realMin(points)); 
		
		
	}
	
	public static double closePair(Point[] points) {
		int len = points.length;
		Arrays.sort(points, (p1, p2) -> Integer.compare(p1.x, p2.x));
		
		
		double leftMinDis = Double.MAX_VALUE;
		for(int i = 0; i < len/2 - 1; i++ ) {
			for(int j = i + 1; j < len/2; j++) {
				leftMinDis = Math.min(leftMinDis, distance(points[i], points[j]));
			}
		}
		double rightMinDis = Double.MAX_VALUE;
		for(int i = len/2; i < len - 1; i++ ) {
			for(int j = i + 1; j < len; j++) {
				rightMinDis = Math.min(rightMinDis, distance(points[i], points[j]));
			}
		}
		
		double minDis = 0;
		if(leftMinDis < rightMinDis)
			minDis = leftMinDis;
		else minDis = rightMinDis;
		
		return minDis;
		
	}
	
	public static double distance(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}
	
	public static double realMin(Point[] points) {
		double minDis = closePair(points);
		int len = points.length;
		int mid = len / 2;
		
		ArrayList<Point> newPoint = new ArrayList<>();
		for(int i = 0; i < len; i++) {
			if(Math.abs(points[i].x - points[mid].x) < minDis) {
				newPoint.add(points[i]);
			}
		}
		
		newPoint.sort(Comparator.comparingDouble(p -> p.y));
		for(int i = 0; i < newPoint.size() - 1; i++) {
			for(int j = 1; j < newPoint.size(); j++) {
				 if (newPoint.get(j).y - newPoint.get(i).y < minDis) {
					 minDis = Math.min(minDis, distance(newPoint.get(i), newPoint.get(j)));
		         }
			}
		}
		
		return minDis;
	}
}

class Point{
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}