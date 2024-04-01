package group;

import java.util.ArrayList;
import java.util.List;

public class Ex105 {
//	초기 상태: 두 개의 빈 집합과 모든 정수가 포함된 리스트가 주어집니다.
//	각 단계에서는 리스트에서 하나의 정수를 선택하여 두 집합 중 하나에 추가합니다.
//	모든 정수를 선택할 때까지 이 과정을 반복합니다.
//	선택할 때마다 두 집합의 합이 동일한지 확인합니다. 만약 동일하다면 분할 가능한 경우가 있습니다.

	 private static boolean partition(int[] nums, List<Integer> set1, List<Integer> set2, int index) {
	        if (index == nums.length) {	
	            // 모든 정수가 분배되었을 때, 두 집합의 합이 같은지 확인
	            return sum(set1) == sum(set2);
	        } else {
	            // 현재 정수를 첫 번째 집합에 추가하는 경우
	            set1.add(nums[index]);
	            System.out.println(set1);
	            System.out.println(set2);
	            if (partition(nums, set1, set2, index + 1)) {
	                return true;
	            }
	            // 현재 정수를 첫 번째 집합에서 제거하고 두 번째 집합에 추가하는 경우
	            set1.remove(set1.size() - 1);
	            set2.add(nums[index]);
	            if (partition(nums, set1, set2, index + 1)) {
	                return true;
	            }
	            // 현재 정수를 두 번째 집합에서 제거하는 경우
	            set2.remove(set2.size() - 1);
	            return false;
	        }
	    }
	    
	    private static int sum(List<Integer> list) {
	        int sum = 0;
	        for (int num : list) {
	            sum += num;
	        }
	        return sum;
	    }
	    
	    public static void main(String[] args) {
	        int[] nums = { 2, 3, 10, 2, 7 };
	        List<Integer> set1 = new ArrayList<>();
	        List<Integer> set2 = new ArrayList<>();
	        if (partition(nums, set1, set2, 0)) {
	            System.out.println("Possible partition found:");
	            System.out.println("Set 1: " + set1);
	            System.out.println("Set 2: " + set2);
	        } else {
	            System.out.println("No partition found.");
	        }
	    }
}