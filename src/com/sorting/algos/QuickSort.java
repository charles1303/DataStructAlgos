package com.sorting.algos;

public class QuickSort {
	
public static void main(String[] args){
        
        int[] inputArr = {4,23,11,89,77,98,45,28,65,43};
        int[] inputArr2 = quicksort(inputArr);
        for(int i:inputArr2){
            System.out.print(i);
            System.out.print(" ");
        }
    }
	
	static void quickSort(int[] arr, int from, int to){
		System.out.println("from===="+from+" value==="+arr[from]);
		System.out.println("to===="+to+" value==="+arr[to]);
		if(from >= to) return;

		int pivot = arr[from];
		int i = from;
		int j = to;

		while(i < j){
			//i++;
			while(arr[i] < pivot) i++;

			//j--;
			while(arr[j] > pivot) j--;
			
			if(i < j) swap(arr,i,j);
		}
		quickSort(arr,from,j);
		quickSort(arr,j+1,to);
	}
	
	public static int[] quicksort(int [] list) {
        quickSort(list, 0, list.length-1);
        return list;
    }
	
	public static void swap(int[] arr, int firstIndex, int secondIndex){
		int temp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = temp;
	}

}
