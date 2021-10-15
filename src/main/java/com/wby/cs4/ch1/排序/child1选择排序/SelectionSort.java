package com.wby.cs4.ch1.排序.child1选择排序;

/**
 * @Auther: LangWeiXian
 * @Date: 2021/10/8 16:41
 * @Description: 选择排序
 *  运行时间与输入无关,因为总要扫描一遍数组.
 (  数据移动次数最少： N次交换
 */
public class SelectionSort {
    public static void main(String[] args) {
        Comparable[] sort = SelectionSort.sort(new Comparable[]{'a', 'h', 'd', 'c', 'p', 'z', 'y', 'x'});
        System.out.println(sort);
    }

    public static Comparable[] sort(Comparable[] array){
        int lenght= array.length;
        for (int i = 0; i < lenght; i++) {
            int min=i;
            for (int j = i+1; j < lenght; j++) {
                if (lessOne(array[j],array[i])){
                    min=j;
                }
            }
            chageLocation(array,i,min);
        }
        return array;
    }
    public static boolean lessOne(Comparable first,Comparable second){
        return first.compareTo(second)<0;
    }
    public static void chageLocation(Object[] v,int i,int j){
        Object a=v[i];
        v[i]=v[j];
        v[j]=a;
    }
}
