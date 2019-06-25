package Z.References;

import java.util.Scanner;


/*
 * Quick sort 빠른 정렬 
 * 분할/정복을 한번에 진행하는 개
 * 
 * pivot point 를 사용한다.
 * 기본개념은 pivot을 중심으로 left < pivot , pivot < right 구조로 만들어야한다.
 * left 는 pivot보다 큰 값을 찾을 때가지 오른쪽으로 이동하고,
 * right는 pivot보다 작은 값을 찾을 때까지 왼쪽으로 이동한다. 
 * 둘 다 찾았다면 left/right를 교환한다. 교환 후에도 계속이동한다. 
 * left/right가 하나의 인덱스에서 만난다면, left와 pivot의 값을 바꿔준뒤 pivot은 그 자리를 확정 지음.
 * 
 * 
 * 
 * 시간 복잡도 O(NlogN), 최악의경우(모두 정렬되어있는 경우) O(n^2)
 * */
public class Example3_Quick_sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		models model = new models();
		
		int range = sc.nextInt();
		int[] D = model.ArrayRandom(range);
		model.ArrayPrint(D);
		quick_sort(D,0,D.length-1,model);
		System.out.println("final : ");
		model.ArrayPrint(D);
		
	}
	
	public static void quick_sort(int[] Array, int left, int right, models model)
	{
		// 만나지 않았으면 
		if(left < right)
		{
			int pivotindex = partition(Array, left, right, model);
			quick_sort(Array, left, pivotindex - 1, model);
			model.ArrayPrint(Array);
			quick_sort(Array, pivotindex + 1, right, model);
			model.ArrayPrint(Array);
		}
	}
	
	public static int partition(int[] Array, int left, int right, models model)
	{
		//left+right인 이유는 확정지은 인덱스가 있을 수 있고 그 인덱스는 제외함으로.
		int pivot = Array[(left+right) / 2];
		System.out.println("Pivot : " + pivot);
		
		while(left < right)
		{
			while(Array[left] < pivot && left < right)
			{
				left++;
			}
			while(Array[right] > pivot && right > left)
			{
				right--;
			}
			if(left < right)
			{
				Array = models.SwapIndex(Array, left, right);
			}
		}
		
		return left;
	}

}
