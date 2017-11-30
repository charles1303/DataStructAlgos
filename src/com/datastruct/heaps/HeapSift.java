package com.datastruct.heaps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HeapSift<T extends Comparable<T>> {

	private ArrayList<T> items;
	
	public HeapSift(){
		items = new ArrayList<T>();
	}
	
	private void siftUp(){
		int k = items.size() - 1;
		
		while(k > 0){
			int p = (k - 1)/2;
			T item = items.get(k);
			T parent = items.get(p);
			if(item.compareTo(parent) > 0){
				items.set(p, item);
				items.set(k, parent);
				
				k = p;
			}else{
				break;
			}
		}
	}
	
	public ArrayList<T> getItems(){
		return items;
	}
	
	private void siftUp2(){
		int k = items.size() - 1;
		
		while(k > 0){
			int p = (k - 1)/2;
			T item = items.get(k);
			T parent = items.get(p);
			if(item.compareTo(parent) < 0){
				items.set(p, item);
				items.set(k, parent);
				
				k = p;
			}else{
				break;
			}
		}
	}
	
	private void siftDown(){
		int k = 0;
		int l = (2*k) + 1;
		while(l < items.size()){
			int max = l;
			int r = l + 1;
			if(r < items.size()){
				if(items.get(r).compareTo(items.get(l)) > 0){
					max++;
				}
			}
			if(items.get(k).compareTo(items.get(max)) < 0){
				T temp = items.get(k);
				items.set(k, items.get(max));
				items.set(max, temp);
				
				k = max;
				l = (2*k) + 1;
			}else{
				break;
			}
		}
	}
	
	private void siftDown2(){
		int k = 0;
		int l = (2*k) + 1;
		while(l < items.size()){
			int max = l;
			int r = l + 1;
			if(r < items.size()){
				if(items.get(r).compareTo(items.get(l)) < 0){
					max++;
				}
			}
			if(items.get(k).compareTo(items.get(max)) > 0){
				T temp = items.get(k);
				items.set(k, items.get(max));
				items.set(max, temp);
				
				k = max;
				l = (2*k) + 1;
			}else{
				break;
			}
		}
	}
	
	public void insert(T item){
		items.add(item);
		siftUp2();
	}
	
	public T remove(){
		if(items.size() <= 0) throw new NoSuchElementException();
		if(items.size() == 1) return items.remove(0);
		
		T top = items.get(0);
		items.set(0, items.remove(items.size() - 1));
		siftDown2();
		
		return top;
	}
	
	public int getSize(){
		return items.size();
	}
	public boolean isEmpty(){
		return items.isEmpty();
	}
	public String toString(){
		return items.toString();
	}
}
