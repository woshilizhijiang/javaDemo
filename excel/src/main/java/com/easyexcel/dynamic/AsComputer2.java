package com.easyexcel.dynamic;

import java.util.Arrays;

public class AsComputer2 {
    public static void main(String[] args){
        int[] arr = {2,4,4,8,8};
        int value = match(arr);
        System.out.println(value);
    }

    public static int match(int[] arr){
        int sum = Arrays.stream(arr).sum();
        int len = arr.length;
        int halfOfSum = sum/2;
        // 确定矩阵二维定义：第一维代表前i个物体，i可为0；第二维代表从0开始的连续容量值
        // 确定矩阵长宽，并初始化。因为矩阵第一维和第二维都是从0开始，所以要加一
        int matrix_firstDimensionLen = len + 1;
        int matrix_secondDimensionLen = halfOfSum + 1;
        int[][] matrix = new int[matrix_firstDimensionLen][matrix_secondDimensionLen];
        //初始化矩阵边界为0
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[0][i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }

        for (int i = 1; i < matrix_firstDimensionLen; i++) {
            for (int j = 1; j < matrix_secondDimensionLen; j++) {
                matrix[i][j] = matrix[i-1][j];
                if(j - arr[i-1] >= 0 && matrix[i - 1][j - arr[i-1]] + arr[i-1]  > matrix[i][j]){
                    matrix[i][j] = matrix[i - 1][j - arr[i-1]] + arr[i-1];
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("");
        }
//        return  sum - matrix[len][halfOfSum]*2;
        return  sum - matrix[len][halfOfSum];

    }
}
