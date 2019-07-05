package X.Prgmers;

import java.util.Arrays;

public class PhoneKetmon_Prgmers {
	public static void main(String[] args) {
		
		int arr1[] = {3,1,2,3};
		int arr2[] = {3,3,3,2,2,4};
		int arr3[] = {3,3,3,2,2,2};
		
		System.out.println(solution(arr1));
		System.out.println(solution(arr2));
		System.out.println(solution(arr3));
		
		return;
		
	}
	
    static public int solution(int[] nums) {
        int answer = 0;
        int max = nums.length/2;
        
        for(int i=0;i<nums.length-1;i++) {
        	for(int j=i+1;j<nums.length;j++) {
        		if(nums[i] == nums[j]) {
        			nums[j] = -1;
        		}
        	}
        }
        Arrays.sort(nums);
        for(int a : nums) {
        	if(a != -1) {
        		answer++;
        	}
        }
        if(answer > max) {
        	answer = max;
        }
        
        return answer;
    }
}
