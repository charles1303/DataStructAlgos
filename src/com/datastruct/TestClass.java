package com.datastruct;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;

public class TestClass {

	public static void main(String[] args){
		//create a new object and add a custom comparator that provides the "MinHeap" behaviour.
	    priorityQueueImpl();
		//orderStreamIntegers();
	    
	}
	
	private static void orderStreamIntegers(){
		SortedMap<Integer, Integer> sMap = new TreeMap<>();
		StringBuffer buffer = new StringBuffer();
		
		int[] arr = {8,9,1,2,3,9,8,5,1};
	    for(int i = 0; i < arr.length; i++){
	    	if(sMap.containsKey(arr[i])){
	    		sMap.put(arr[i], sMap.get(arr[i]) + 1);
	    	}else{
	    		sMap.put(arr[i], 1);
	    	}
	    }
	    
	    for(Map.Entry<Integer,Integer> entry : sMap.entrySet()) {
	    	  Integer key = entry.getKey();
	    	  Integer value = entry.getValue();
	    	  buffer.append(key + "-" + value);
	    	  buffer.append(",");
	    	  
	    	}
	    System.out.println(buffer.toString().substring(0, (buffer.toString().length() - 1)));
		
	}

	private static void priorityQueueImpl() {
		PriorityQueue<Integer> minheap=new PriorityQueue<Integer>(1,new Comparator<Integer>() {
	        @Override
	        public int compare(Integer o1, Integer o2) {
	            return o1-o2;
	        }
	    });
	    //add elements
	    //1 2 3 5 8 9
	    int[] arr = {8,9,1,2,3,5};
	    for(int i = 0; i < arr.length; i++){
	    	minheap.add(arr[i]);
	    }
	    //minheap.addAll(Arrays.asList(new Integer[]{8,9,1,2,3,5,}));
	    System.out.println(Arrays.toString(minheap.toArray()));
	    int arrSize = minheap.toArray().length;
	    System.out.println("arrSize : "+ arrSize);
	    System.out.println("arrSize/2 : "+ arrSize/2);
	    Integer median = 0;
	    if(arrSize % 2 == 0){
	    	median = (((Integer)minheap.toArray()[arrSize/2 - 1]) + ((Integer)minheap.toArray()[(arrSize/2 - 1) + 1]))/2;
	    }else{
	    	median = (Integer)minheap.toArray()[(arrSize/2 - 1) + 1];
	    }
	    
	    //Integer median = arrSize % 2 == 0 ? (Integer)minheap.toArray()[arrSize/2] : (Integer)minheap.toArray()[arrSize/2 + 1];
	    
	    System.out.println("median : "+ median);
	}
}
