package com.sorting.algos;

public class BubbleSort {
	
	public static void main(String a[]){
        
        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        int[] inputArr2 = bubbleSort(inputArr);
        for(int i:inputArr2){
            System.out.print(i);
            System.out.print(" ");
        }
    }
	
		
	public static int[] bubbleSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length - 1; j++){
				if(arr[j] > arr[j+1]){
					swap(j, j+1, arr);
				}
				
			}
		}
		return arr;
	}

	public static void swap(int firstIndex, int secondIndex, int[] arr){
		int temp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = temp;
	}


}
