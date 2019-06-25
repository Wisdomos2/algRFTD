package Z.References;

import java.util.Scanner;


/*
 * Insertion Sort 선택정렬
 * 현재 인덱스 위치에서 그 이하 아래 인덱스들과 비교하여 자리를 찾아서 삽입한다.
 * 최악의 경우(역으로 정렬되어있을 경우) 복잡도는 O(n^2)이다. 
 * 정렬되어있는 경우는 O(n)이다. 
 * */
public class Example3_Insertion_sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		models model = new models();
		
		int range = sc.nextInt();
		int D[] = model.ArrayRandom(range);
		model.ArrayPrint(D);
		
		for(int i=0; i<D.length-1;i++)
		{
			int key = D[i+1];
			for(int j=i;j>=0;j--)
			{
				if(key < D[j])
				{
					int temp = D[j+1];
					D[j+1] = D[j];
					D[j] = temp;
					model.ArrayPrint(D);
					
				}
			}
		}
		System.out.println("final Array");
		model.ArrayPrint(D);
	}
}
