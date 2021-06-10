public class AlgTT {
    public static void main(String[] args) {
        //二进制字节码：最高位符号位 1表示负数，0表示正数
        System.out.println(-1L << 5);
        System.out.println(-1L ^ (-1L << 5)); //异或
    }
}
