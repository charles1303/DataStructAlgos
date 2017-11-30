package com.datastruct.heaps;

import java.util.*;

public class HeapSiftApp {
	
	public static void main(String[] args){
		
		//ArrayList<Integer> items = new ArrayList<Integer>();
		HeapSift<Integer> hp = new HeapSift<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter next int, 'done' to stop: ");
		String line = sc.next();
		while(!line.equals("done")){
			//HeapSift<Integer> hp = new HeapSift<Integer>();
			//items.add(Integer.parseInt(line));
			hp.insert(Integer.parseInt(line));
			//hp.insert(items);
			//System.out.println("Median====="+getMedian(hp));
			System.out.println(hp);
			System.out.print("Enter next int, 'done' to stop: ");
			line = sc.next();
			
		}
		
		int i = 0;
		int median = 0;
		while(!hp.isEmpty() && i < hp.getSize()){
			int l = (2*i)+1;
			int min = hp.remove();
			System.out.println(min + " " + hp);
			i = l;
		}
		
	}
	
	public static int getMedian(HeapSift<Integer> hp){
		int cnt = -1;
		int mid = hp.getSize()/2;
		int total = hp.getSize();
		int median = 0;
		System.out.println("hp.toString()====="+hp.toString());
		System.out.println("mid====="+mid);
		while(!hp.isEmpty() && cnt <= mid){
			
			int max = hp.remove();
			System.out.println("max====="+max);
			median = max;
			//System.out.println(max + " " + hp);
			cnt++;
		}
		System.out.println("cnt====="+cnt);
		System.out.println("total % 2====="+(total % 2));
		
		if((total % 2) == 0 && !hp.isEmpty()){
			median = (median + hp.remove())/2;
		}
		return median;
	}

}
