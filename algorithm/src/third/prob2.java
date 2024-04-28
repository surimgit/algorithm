package third;

import java.util.*;

public class prob2 {
	 public static boolean isValidBSTPostorder(List<Integer> postorder) {
	        Stack<Integer> stack = new Stack<>();
	        int rootValue = Integer.MAX_VALUE;

	        for (int i = postorder.size() - 1; i >= 0; i--) {
	            int current = postorder.get(i);
	            if (current > rootValue) {
	                return false;
	            }
	            while (!stack.isEmpty() && stack.peek() > current) {
	                rootValue = stack.pop();
	            }
	            stack.push(current);
	        }
	        return true;
	    }

	    public static int calculateBSTHeight(List<Integer> postorder) {
	        if (!isValidBSTPostorder(postorder)) {
	            return -1;
	        }
	        return calculateHeight(postorder, 0, postorder.size() - 1);
	    }

	    private static int calculateHeight(List<Integer> postorder, int start, int end) {
	        if (start > end) {
	            return 0;
	        }

	        int rootValue = postorder.get(end);
	        int splitIndex = start;

	        while (splitIndex < end && postorder.get(splitIndex) < rootValue) {
	            splitIndex++;
	        }

	        return Math.max(calculateHeight(postorder, start, splitIndex - 1),
	                calculateHeight(postorder, splitIndex, end - 1)) + 1;
	    }

	    public static void main(String[] args) {
	        List<Integer> postorder1 = Arrays.asList(2, 3, 4, 1, 8, 10, 9, 11, 7, 6);
	        List<Integer> postorder2 = Arrays.asList(2, 3, 1, 4, 8, 10, 7, 11, 9, 6);
	        List<Integer> postorder3 = Arrays.asList(1,2,3,4,5,6,7);

	        System.out.println("BST height for postorder1: " + calculateBSTHeight(postorder1));  // 출력: -1
	        System.out.println("BST height for postorder2: " + calculateBSTHeight(postorder2));  // 출력: 3
	        System.out.println("BST height for postorder3: " + calculateBSTHeight(postorder3));  // 출력: 1
	    }
}
