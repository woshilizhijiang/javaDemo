package mycom.utils.datastructureandalgorithm.dynamicprogramming;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 20013649 on 2020/6/23.
 *
 *
 F(n,w) = 0    (n<=1, w<p[0]);
 F(n,w) = g[0]     (n==1, w>=p[0]);
 F(n,w) = F(n-1,w)    (n>1, w<p[n-1])
 F(n,w) = max(F(n-1,w),  F(n-1,w-p[n-1])+g[n-1])    (n>1, w>=p[n-1])

 */
public class Golden {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args){
        int N=7;
        int W=10;
        int[] G={400,500,200,300,350,340,600};
        int[] P={5,5,3,4,3,3,5};

        int maxValue = Golden.getGolden(N,W,G,P);

        System.out.println("maxValue ： " + maxValue);
        System.out.println("Execution times : " + count.get());
    }

    /**
     * 动态规划三概念
     *          1.最优子结构
     *              将5和10带入
     *              F(5,10) = MAX(F(4,10),F(4,10-P[4])+G[4])
     *          2.边界
     *              W N P G对应值
     *          3.状态转移公式
     *              F(N,W) = MAX(F(N-1,W),F(N-1,W-P[N-1])+G[N-1])
     * @param W  工人数
     * @param N  金矿数量
     * @param P  金矿用工量P[]
     * @param G  金矿容量[]
     * @return
     */
    public static int getGolden( int N, int W, int[] G, int[] P){
        int[] preResult=new int[W];
        int[] result=new int[W];
        //边界设定
        for(int j=0;j<W;++j){
            preResult[j] = j+1 < P[0] ? 0 : G[0];
        }
        for(int i=1;i<N;++i){
            for(int j=0;j<W;++j) {
                if (j + 1 < P[i]){ //要用j+1判断，因为我们j是从0开始的，如果要用j请从1开始计数
                    result[j] = preResult[j];
                }else {
                    if (j + 1 - P[i] == 0) {
                        result[j] = Math.max(preResult[j], G[i]);
                    } else {
                        result[j] = Math.max(preResult[j], preResult[j - P[i]] + G[i]);
                    }
                }
            }
            //Java在这里不能用原文中的preResult=result;否则会导致preResult和result指向同一个数组的内存空间
            preResult=result.clone();
        }
        return result[W-1];
    }
}
