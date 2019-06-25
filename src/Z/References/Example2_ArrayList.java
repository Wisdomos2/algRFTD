package Z.References;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Example2_ArrayList {
	public static void main(String[] args) {
		boolean TF;
		
		//선언 
		ArrayList<String> list = new ArrayList<String>();
		
		//추가  
		TF = list.add("junseo");
	
		//있는지 없는지 
		TF = list.contains("junseo");
		
		//인덱스 값 가져오기 
		String GET = list.get(0);
		
		//비었는지 안비었는지 
		TF = list.isEmpty();
		
		//인덱스 값 지우기 
		list.remove(0);
		
		list.add("1");
		//인덱스 값 세팅하기 
		list.set(0, "new value");
		
		//ArrayList를 비움  
		list.clear();
		
		list.add("one");
		list.add("two");
		String[] arr = (String[])list.toArray();
		
		for(String a : arr)
		{
			System.out.println(a);
		}
		
		
		
		
	}

}
