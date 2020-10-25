package com.pss.demo.util;

import java.util.Arrays;

public class Constant {

    public static final String MODIFY = "modify";
    public static final String DETAIL = "detail";
    public static final String LIST = "list";
    public static final String DEL = "delete";
    public static final String ADD = "add";
    public static final String LOGIN = "login";

    public static void main(String[] args) {
        int[] array = {1,2,3,4,56,77,9,88};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("===============================");

        //  int min = 0,int max = 0
        for (int min = 0, max = array.length -1;min < max; min++,max--){
            int temp = array[min];
            array[min] = array[max];
            array[max] = temp;
        }
        //String s = Arrays.toString(array);
        System.out.println(Arrays.toString(array));

    }

}
