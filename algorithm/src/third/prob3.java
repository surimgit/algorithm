package third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class prob3 {

		
	 public static List<Integer> constructPreorder(List<Integer> postorder) {
	        if (postorder.isEmpty()) {
	            return new ArrayList<>();
	        }
	        int rootValue = postorder.get(postorder.size() - 1);
	        List<Integer> leftSubtree = new ArrayList<>();
	        List<Integer> rightSubtree = new ArrayList<>();

	        for (int i = 0; i < postorder.size() - 1; i++) {
	            int value = postorder.get(i);
	            if (value < rootValue) {
	                leftSubtree.add(value);
	            } else {
	                rightSubtree.add(value);
	            }
	        }

	        List<Integer> preorder = new ArrayList<>();
	        preorder.add(rootValue);
	        preorder.addAll(constructPreorder(leftSubtree));
	        preorder.addAll(constructPreorder(rightSubtree));
	        return preorder;
	    }
	 

	    public static void main(String[] args) {
	    	Scanner sc = new Scanner(System.in);
	    	int N = sc.nextInt();
	    	int arr[] = new int[N];
	    	List<Integer> postorder = new ArrayList<>();
	    	for(int i = 0; i < N; i++) {
	    		int a = sc.nextInt();
	    		postorder.add(a);
	    	}
	        
	        List<Integer> preorder = constructPreorder(new ArrayList<>(postorder));
	        System.out.println(preorder); 
	    }
		
	
}
