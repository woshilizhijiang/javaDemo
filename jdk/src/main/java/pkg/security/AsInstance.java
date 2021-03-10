package pkg.security;

public class AsInstance {
    public static void main(String[] args) {
        String password = "LIYUANXIN";
        String encrypt = DoEncrypt(password);//4742525E4A45534245
        System.out.println(encrypt);
        System.out.println(DoDecrypt(encrypt));
    }
    /***
     * 加密
     * @param str
     * @return
     */
    public static String DoEncrypt(String str)
    {
        int i;
        int tmpch;
        StringBuffer enStrBuff = new StringBuffer();
        for(i = 0;i <str.length();i++)
        {
            tmpch = (int)str.charAt(i);
            tmpch = tmpch^0x01;
            tmpch = tmpch^0x0a;
            enStrBuff.append(Integer.toHexString(tmpch));
        }
        return enStrBuff.toString().toUpperCase();
    }
    /***
     * 解密
     * @param str
     * @return
     */
    public static String DoDecrypt(String str)
    {
        int tmpch;
        String deStr = str.toLowerCase();
        StringBuffer deStrBuff = new StringBuffer();
        for (int i=0;i<deStr.length();i+=2)
        {
            String subStr  = deStr.substring(i,i+2);
            tmpch = Integer.parseInt(subStr,16);
            tmpch = tmpch^0x01;
            tmpch = tmpch^0x0a;
            deStrBuff.append((char)tmpch);
        }
        return deStrBuff.toString();
    }
}
