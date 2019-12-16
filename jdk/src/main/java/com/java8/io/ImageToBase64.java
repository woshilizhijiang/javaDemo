package com.java8.io;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class ImageToBase64 {

    public static String getImageStr(){
        String imageFile = "/Users/lzj11/Documents/人脸能力.jpeg";
        InputStream in = null;
        byte[] data = null;

        try {
            in = new FileInputStream(imageFile);
            data = new byte[in.available()];
            in.read();
            in.close();
        }catch (IOException e){
        }
        BASE64Encoder encoder = new BASE64Encoder();
        String aa = encoder.encode(data);
        System.out.println(aa);
        return aa;
    }

    public static boolean GenerateImage(String imgStr,String photoname)
    {
        //对字节数组字符串进行Base64解码并生成图片
        //图像数据为空
        if (imgStr == null)
            return false;


        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {
                    //调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
//            String imagePath= Config.getUploadPhysicalPath();
//            //System.currentTimeMillis()
//            //新生成的图片
//            String imgFilePath = imagePath+photoname;
//            OutputStream out = new FileOutputStream(imgFilePath);
//            out.write(b);
//            out.flush();
//            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static void main(String[] args) {
        ImageToBase64.getImageStr();
    }
}
