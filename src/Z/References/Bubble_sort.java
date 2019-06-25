package Z.References;

import java.util.Scanner;

/*
 *Bubble sort 버블 정렬 
 * 연속된 두 개의 인덱스를 기준으로 한다.
 * n+1인덱스부터 시작하며 현재 인덱스와 이전 인덱스를 세트로 비교한다.
 * 비교 후 그 다음인덱스로 진행한다.
 * 특징은 두 개의 인덱를 하나의 세트로 묶어 마지막 인덱스까지 비교하는 것이다.
 * 시간복잡도는 전체를 비교하므로 O(n^2)
 * 공간복잡도는 배열 하나를 사용하므로 O(n)
 * */

public class Bubble_sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		models model = new models();
		
		int range = sc.nextInt();
		int[] D = model.ArrayRandom(range);
		model.ArrayPrint(D);
		
		for(int i=D.length;i>0;i--)
		{
			for(int j=1;j<i;j++)
			{
				if(D[j] < D[j-1])
				{
					int temp = D[j];
					D[j] = D[j-1];
					D[j-1] = temp;
					model.ArrayPrint(D);
					
				}
			}
		}
		System.out.println("final Array");
		model.ArrayPrint(D);
	}
}
