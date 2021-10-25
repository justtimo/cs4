package com.wby.cs4.ch1.排序.child3希尔快速排序;

import java.util.Arrays;

/**
 * @Auther: LangWeiXian
 * @Date: 2021/10/25 18:41
 * @Description: 希尔排序
 *  核心思想为: 使数组中任意间隔为h的元素都是有序的.
 *  这样的数组被称为h有序数组,即,一个h有序数组 就是h个互相独立的有序数组编制在一起组成的数组
 *
 *  实现希尔排序的一个方法是对于每个h ,用插入排序将h个子数组独立的排序 .
 *  但因为子数组相互独立, 所以更简单的方法是在h-子数组中 将每个元素交换到比他大的元素之前去(将比他大的元素向右移动一格)
 *  只需要在插入排序的代码中将移动元素的距离由1 改为 h 即可. 这样,希尔排序实现就转换为了一个类似插入排序但使用不同增量的过程.
 *
 */
public class ShellSort {
    public static  Comparable[] sort(Comparable[] a){
        //将a[]按照升序排列
        int N=a.length;
        int h=1;
        while (h<N/3){
            h=3*h+1; //1,4,13,40,121,364
        }
        while (h>=1){
            //将数组变为h有序
            for (int i=h; i < N; i++){
                //将a[i]插入到a[i-h],a[i-2h],a[i-3h]..中
                for (int j = i; j >=h && lessOne(a[j],a[j-h]); j-=h){
                    changeLocation(a,j,j-h);
                }
            }
            h=h/3;
        }
        return a;
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
class Test{
    public static void main(String[] args) {
        Comparable[] sort = ShellSort.sort(new Comparable[]{/*'a', 'h', 'd', 'c', 'p', 'z', 'y', 'x'*/
                3, 7, 8, 5, 9, 1, 4, 6,0,16,11,15,12,13,14,18,33,32,31,27,54});
        System.out.println(Arrays.toString(sort));

    }
}
