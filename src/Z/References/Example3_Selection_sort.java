package Z.References;

import java.util.Scanner;


/*
 * Selection sort 선택정렬 
 * 현재 위치에 들어갈 값을 찾아 정렬하는 방법 
 * 
 * 배열이 어떻게 구성되었던건에 배열 하나 전체를 진행하므로 시간복잡도는 O(n^2)
 * 공간복잡도는 배열 하나에서만 진행하므로 O(n)
 * */
public class Example3_Selection_sort {
	public static void main(String[] args) {
		models model = new models();
		
		Scanner sc = new Scanner(System.in);
		
		int value = sc.nextInt();
		
		int D[] = models.ArrayRandom(value);
		
		models.ArrayPrint(D);
		
		/* 오름차순 */
		for(int i=0;i<(D.length-1);i++)
		{
			int temp = D[i];
			for(int j=i+1;j<D.length;j++)
			{
				if(D[i] >= D[j])
				{
					temp = D[j];
					D[j] = D[i];
					D[i] = temp;
				}
			}
			
		}
		model.ArrayPrint(D);
		
		/* 내림차순 */
		for(int i=0;i<(D.length-1);i++)
		{
			int temp = D[i];
			for(int j=i+1;j<D.length;j++)
			{
				if(D[i] <= D[j])
				{
					temp = D[j];
					D[j] = D[i];
					D[i] = temp;
				}
			}
			
		}
		model.ArrayPrint(D);
		
				
	}
	

}
