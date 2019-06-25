package Z.References;

import java.util.Scanner;

/*
 * 큰 문제를 반으로 쪼개서 해결하는 분할 정복 방식이다. 
 * 입력받은 배열을 n/2로 배열의 가장 작은 크기가 1이 될때까지 쪼갠다.
 * 쪼갠 배열 내에서 정렬을 한 뒤 합쳐서 배열의 크기가 n이 될 때까지 진행한다.
 * 시간복잡도는 O(NlogN)이며 공간복잡도는 배열 2개를 사용하기 때문에 2N개이다.
 * 시간복잡도 추가설명: 두 배열 A,B를 정렬하기 때문에 A의 크기를 N1, B의 크기를 N2라고 할 경우
 * N은 N1+N2이므로 O(N)와 같다. 
 * 분할 과정은 LogN만큼 일어나는데, 크기가 N인 배열 분할하면 한번 분할하면 2/N, 2/N 2개,
 * 그 다음 분할하면 4/N, 4/N 4/N, 4/N 4개. 즉 분할 과정은 매번 반씩 감소하므로 LogN 만큼 반복해야하한다.
 * */
public class Example3_Merge_sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		models model = new models();
		
		int range = sc.nextInt();
		while(true)
		{
			if(range % 2 != 0)
			{
				System.out.println("2의 배수 입력 ");
				range = sc.nextInt();
				break;
			}
			else if(range % 2 == 0)
			{
				break;
			}
		}
		int[] D = model.ArrayRandom(range);
		
		merge_sort(D,model);
		System.out.println("final : ");
		models.ArrayPrint(D);
		
		
			
	}
	
	 //분할 
	static void merge_sort(int[] Array, models model)
	{
		int length = Array.length;
		if(length == 1)
		{
			return;
		}
		
		int[] arrtemp1 = new int[length/2];
		int[] arrtemp2 = new int[length - length/2];
		
		for(int i = 0; i < length/2 ;i++)
		{
			arrtemp1[i] = Array[i];
		}
		for(int i = 0; i < length - length/2 ;i++)
		{
			arrtemp2[i] = Array[length/2 + i];
		}
		System.out.println("Array");
		model.ArrayPrint(Array);
		System.out.println("arrtemp1");
		model.ArrayPrint(arrtemp1);
		System.out.println("arrtemp2");
		model.ArrayPrint(arrtemp2);
		
		merge_sort(arrtemp1, model);
		merge_sort(arrtemp2, model);
		
		merge(arrtemp1, arrtemp2, Array);
		//model.ArrayPrint(Array);
		
		
	}
	
	//합병 
//	static void merge(int[] arrtemp1, int[] arrtemp2, int[] Array)
//	{
//		int parrtemp1 = 0;
//		int parrtemp2 = 0;
//		int parrArray = 0;
//		
//		while(parrArray <= Array.length)
//		{
//			if(arrtemp1.length > parrtemp1 && arrtemp2.length > parrtemp2)
//			{
//				if(arrtemp1[parrtemp1] > arrtemp2[parrtemp2])
//				{
//					Array[parrArray] = arrtemp2[parrtemp2];
//					parrArray++;
//					parrtemp2++;
//				}
//				else if(arrtemp1[parrtemp1] < arrtemp2[parrtemp2])
//				{
//					Array[parrArray] = arrtemp1[parrtemp1];
//					parrArray++;
//					parrtemp1++;
//				}
//			}
//			//1 배열이 꽉찼을 
//			else if(arrtemp1.length == parrtemp1 && arrtemp2.length > parrtemp2)
//			{
//				if(arrtemp2[parrtemp2] < arrtemp2[parrtemp2+1])
//				{
//					Array[parrArray] = arrtemp2[parrtemp2];
//					Array[parrArray+1] = arrtemp2[parrtemp2+1];
//					parrArray+=2;
//				}
//			}
//			else if(arrtemp2.length == parrtemp2 && arrtemp1.length > parrtemp1)
//			{
//				if(arrtemp1[parrtemp1] < arrtemp1[parrtemp1+1])
//				{
//					Array[parrArray] = arrtemp1[parrtemp1];
//					Array[parrArray+1] = arrtemp1[parrtemp1+1];
//					parrArray+=2;
//				}
//			}
//				
//		}
	//병합  
	public static void merge (int[] arrA, int[] arrB, int[] arrC) 
	{
        int iA = 0;
        int iB = 0;
        int iC = 0;
       
        while (iA < arrA.length) 
        {
        		if (iB < arrB.length) 
        		{
        			if ( arrA[iA] < arrB[iB]) 
        			{
        				arrC[iC] = arrA[iA];
        				iA++;
        			} 
                	else 
                	{
                		arrC[iC] = arrB[iB];
                		iB++;
                	}
        			iC++;
        		} 
        		else 
        		{
        			while (iA < arrA.length) 
        			{
        				arrC[iC] = arrA[iA];
        				iA++;
        				iC++;
        			} 	
        		}
        }
        while (iB < arrB.length) 
        {
        		arrC[iC] = arrB[iB];
        		iB++;
        		iC++;
        }
	}




	
	
}
