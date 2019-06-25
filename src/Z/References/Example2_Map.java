package Z.References;

import java.util.*;

public class Example2_Map {
	
	/*
	 * Hash VS Map
	 * Hash 랜덤 
	 * Map 순서 
	 * 순서는 당연 랜덤으로 생성하는게 빠름 
	 * */
	public static void main(String[] args) {
		Hashmap_test();
		System.out.println("------------------");
		Treemap_test();
	}
	
	static void Hashmap_test()
	{
		//HaspMap은 Key값에 null을 허용함 
		HashMap<String,Integer> hasp = new HashMap<String,Integer>();
		hasp.put("one", new Integer(10));
		hasp.put("two", new Integer(20));
		
		Iterator it =  hasp.keySet().iterator();
		Object obj;
		while(it.hasNext())
		{
			obj = it.next();
			System.out.println(obj + " : " + hasp.get(obj));
		}
		
		//functions
		//있는지 없는지 해당 키 
		hasp.containsKey("one");
		//복제 
		HashMap<String,Integer> ee = (HashMap<String, Integer>) hasp.clone();
		
		
		
		
	}
	
	static void Treemap_test()
	{
		//TreeMap은 Key값에 null, 중복을 허용하지 않음
		TreeMap<String, Integer> tp = new TreeMap<String, Integer>();
		tp.put("a", new Integer(100));
		tp.put("b", new Integer(200));
		
		
		Iterator it =  tp.keySet().iterator();
		Object obj;
		while(it.hasNext())
		{
			obj = it.next();
			System.out.println(obj+ " : " + tp.get(obj));
		}
		
	}
}
