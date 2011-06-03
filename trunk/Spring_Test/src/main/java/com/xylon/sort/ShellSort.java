package com.xylon.sort;
  
public class ShellSort {   
  
    public static void main(String[] args) {   
        int[] data = {9,8,7,6,5,4,3,2,1,0};   
        ShellSort shellSort = new ShellSort();   
        long begin = System.currentTimeMillis();   
        for (int i = 0 ; i < 100000000 ; i++){   
            shellSort.sort(data);   
        }   
        long end = System.currentTimeMillis();   
        System.out.println("希尔排序所用时间:"+(end-begin)/1000);   
        System.out.println(data);   
    }   
       
    public void sort(int[] data){   
        for (int i = data.length/2 ; i > 0 ; i/=2)   
            for (int j = 0 ; j < i ; j++)   
                insertSort (data,j,i);   
    }   
       
    public void insertSort(int[] data , int start , int inc){   
        for (int i = start + inc ; i < data.length ; i += inc)   
            for (int j = i ; (j >= inc) && (data[j] < data[j-inc]) ; j -= inc)   
                swap(data,j,j-inc);   
    }   
       
    public void swap(int[] data , int i , int j){   
        int temp = data[i];   
        data[i] = data[j];   
        data[j] = temp;   
    }   
       
}  

