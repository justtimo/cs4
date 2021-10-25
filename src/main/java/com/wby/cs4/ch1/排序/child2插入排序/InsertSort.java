package com.wby.cs4.ch1.排序.child2插入排序;

/**
 * @Auther: LangWeiXian
 * @Date: 2021/10/13 17:16
 * @Description: 最坏的情况下，需要N^2/2 次比较 和 N^2/2次交换 ；最好的情况下，需要N-1次比较 和 0次交换
 *  一般用插入排序 重排" 部分有序"的数组 :
 *      1. 数组中每个元素距离他们的最终位置都不愿
 *      2. 一个有序的大数组接一个小数组
 *      3. 数组中只有几个元素的位置不正确
 *  当倒置(数组中两个顺序颠倒的元素)数量很少时,插入排序可能比本章中任何算法都要快
 *
 *  优化方案:
 *      内循环中将较大的元素都向右移动而不是总是交换两个元素(访问数组的次数减半)
 */
public class InsertSort {
    public static void main(String[] args) {
        Comparable[] sort = InsertSort.sort(new Comparable[]{/*'a', 'h', 'd', 'c', 'p', 'z', 'y', 'x'*/
                3,7,8,5,9,1,4,6});
        System.out.println(sort);
    }
    public static Comparable[] sort(Comparable[] array){
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && lessOne( array[j],array[j-1]  /*a[index[j]], a[index[j-1]]*/); j--) {
                changeLocation(array,j,j-1);
            }
        }
        return array;
    }

    public static boolean lessOne(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }

    public static void changeLocation(Object[] a,int i ,int j ){
        Object obj=a[i];
        a[i]=a[j];
        a[j]= obj;
    }
}
