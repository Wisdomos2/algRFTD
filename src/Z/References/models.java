package Z.References;

import java.util.Random;

public class models {
	
	/* 배열에 중복되지않은 난수 생성함수 */
	public static int[] ArrayRandom(int range)
	{
		int[] Array = new int[range];
		Random rn = new Random();
		
		/* 배열을 0으로 초기화 */
		for(int i=0;i<Array.length;i++)
		{
			Array[i] = 0;
		}

		/* 배열에 중복되지않은 난수값 생성 */
		for(int i=0;i<range;i++)
		{
			int rnvalue = rn.nextInt(range)+1;
			for(int j=0;j<=i;)
			{
				if(Array[j] == rnvalue)
				{
					rnvalue = rn.nextInt(range)+1;
					j=0;
				}
				else if(Array[j] != rnvalue)
				{
					if(Array[j] == 0)
					{
						Array[j] = rnvalue;
					}
					j++;
				}
			}
		}
		return Array;
	}

	/* 배열에 들어있는 값 순서대로 모두 출력함수 */
	public static void ArrayPrint(int[] Array)
	{
		for(int i=0;i<Array.length;i++)
		{
			System.out.print(Array[i] + " ");
		}
		System.out.println("");
	}

	public static int[] SwapIndex(int[] Array, int indexA, int indexB)
	{
		int temp = Array[indexA];
		Array[indexA] = Array[indexB];
		Array[indexB] = temp;
		
		return Array;
	}

}
