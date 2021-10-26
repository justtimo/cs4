package com.wby.cs4.ch1.排序.child4归并排序;

import java.util.Arrays;

/**
 * @Auther: LangWeiXian
 * @Date: 2021/10/26 11:44
 * @Description:
 */
//自定向下的归并排序 : 大 -> 小
public class MergeSort {
    //归并所需要的辅助数组 :
    // 为什么不声明为merge()的局部变量?
    // 为了避免每次归并时,都创建新的数组, 即使是归并很小的数组
    // 更好地方式是把 aux[] 变为sort() 的局部变量,并将他作为参数传递给merge()
    private static Comparable[] aux;
    public static void merge(Comparable[] a ,int low, int mid, int hi){
        //将a[low ~ mid] 和 [mid+1 , hi] 归并
        int i =low;
        int j =mid+1;
        //将a[low ~ hi] 复制到 aux[low , hi]
        for (int k=low ; k<=hi ;k++) {
            aux[k]= a[k];
        }
        //归并回到a[low , hi]
        for (int k =low ; k<=hi ;k++){
            //左半边用尽, 取右半边的元素
            if (i>mid){
                a[k] = aux[j++];
            }
            //右半边用尽(取左半边的元素)
            else if ( j > hi ){
                a[k] = aux[i++];
            }
            //右半边的当前元素小于左半边的当前元素,取右半边的元素
            else if (lessOne( aux[j] , aux[i] ) ){
                a[k] = aux[j++];
            }
            //右半边的当前元素大于等于左半边的当前元素, 去左半边的元素
            else {
                a[k] = aux[i++];
            }
        }

    }


    public static Comparable[] sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort( a, 0 , a.length-1);
        return a;
    }
    public static void sort(Comparable[] a, int low , int hi){
        //将数组a[lo , hi]排序
        if (hi <= low){
            return;
        }
        int mid = low + (hi -low)/2 ;
        //将左半边排序
        sort(a , low ,mid );
        //将右半边排序
        sort( a, mid +1 , hi);
        //归并结果
        merge(a , low ,mid , hi );
    }

    public static boolean lessOne(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }
}

//自底向上的归并排序 : 小 -> 大
class MergeSortUp {
    //归并所需要的辅助数组
    private static Comparable[] aux;
    public static void merge(Comparable[] a ,int low, int mid, int hi){
        //将a[low ~ mid] 和 [mid+1 , hi] 归并
        int i =low;
        int j =mid+1;
        //将a[low ~ hi] 复制到 aux[low , hi]
        for (int k=low ; k<=hi ;k++) {
            aux[k]= a[k];
        }
        //归并回到a[low , hi]
        for (int k =low ; k<=hi ;k++){
            //左半边用尽, 取右半边的元素
            if (i>mid){
                a[k] = aux[j++];
            }
            //右半边用尽(取左半边的元素)
            else if ( j > hi ){
                a[k] = aux[i++];
            }
            //右半边的当前元素小于左半边的当前元素,取右半边的元素
            else if (lessOne( aux[j] , aux[i] ) ){
                a[k] = aux[j++];
            }
            //右半边的当前元素大于等于左半边的当前元素, 去左半边的元素
            else {
                a[k] = aux[i++];
            }
        }

    }

    //自定向下的归并排序 : 大 -> 小
    public static Comparable[] sort(Comparable[] a){
        //进行lgN 次两两归并
        int N = a.length;
        aux = new Comparable[N];
        //sz子数组大小
        for (int sz = 1 ; sz < N ; sz = sz + sz){
            // lo:子数组索引
            for (int low = 0; low < N-sz ; low += sz+sz){
                merge(a , low ,low+sz-1 ,Math.min(low+sz+sz-1 , N-1));
            }
        }
        return a;
    }

    public static boolean lessOne(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }
}

class Test{
    public static void main(String[] args) {
        Comparable[] a= new Comparable[]{3, 7, 8, 5, 9, 1, 4, 6,0,16,11,15,12,13,14,18,33,32,31,27,54};
        Comparable[] sortDown = MergeSort.sort( a );
        System.out.println("sortDwn :   "+Arrays.toString(sortDown));


        Comparable[] a1= new Comparable[]{3, 7, 8, 5, 9, 1, 4, 6,0,16,11,15,12,13,14,18,33,32,31,27,54};
        Comparable[] sortUp = MergeSortUp.sort(a1);
        System.out.println("sortUp :   "+Arrays.toString(sortUp));

    }
}
