package com.sorting.algos;

public class MergeSort{

	public static void main(String a[]){
         
        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        MergeSort ms = new MergeSort();
        //ms.doSort(inputArr);
        int[] inputArr2 = ms.mergeSort(inputArr);
        for(int i:inputArr2){
            System.out.print(i);
            System.out.print(" ");
        }
    }
	
	int[] mergeSort(int[] arr){
		if(arr.length <= 1) return arr;

		int[] first = new int[arr.length/2];
		int[] second = new int[arr.length - first.length];
		System.arraycopy(arr, 0, first, 0, first.length);
		System.arraycopy(arr,first.length,second,0,second.length);

		mergeSort(first);
		mergeSort(second);

		return merge(first,second,arr);
	}

	int[] merge(int[] first, int[] second, int[] arr){
		int iFirst = 0;

		int iSecond = 0;

		int j = 0;

		while(iFirst < first.length && iSecond < second.length){
			if(first[iFirst] < second[iSecond]){
				arr[j] = first[iFirst];
				iFirst++;
			} else{
				arr[j] = second[iSecond];
				iSecond++;
			}
			j++;
		}
		System.arraycopy(first,iFirst,arr,j,first.length - iFirst);
		System.arraycopy(second,iSecond,arr,j,second.length - iSecond);
		return arr;
	}


}
