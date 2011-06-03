package com.xylon.sort;

public class InsertSort {   
  
    public static void main(String[] args){   
        int[] data = {9,8,7,6,5,4,3,2,1,0};   
        InsertSort insertSort = new InsertSort();   
        long begin = System.currentTimeMillis();   
        for (int i = 0 ; i < 100000000 ; i++){   
            insertSort.sort(data);   
        }   
        long end = System.currentTimeMillis();   
        System.out.println("插入排序所用时间:"+(end-begin)/1000);   
        System.out.println(data.toString());   
    }   
       
    public void sort(int[] data){   
        for (int i = 1 ; i < data.length ; i++)   
            for (int j = i ; (j>0) && (data[j]<data[j-1]) ; j--)   
                 swap(data,j,j-1);  
    }   
       
    public void swap(int[] data , int i , int j){   
        int temp = data[i];   
        data[i] = data[j];   
        data[j] = temp;   
    }   
  
} 
