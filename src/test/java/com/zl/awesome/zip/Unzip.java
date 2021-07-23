package com.zl.awesome.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author: netposa
 * @Date: 2021/4/12 16:05
 * @Description:
 */
public class Unzip {
    private static String ZIP_FILE="D:/pic/zip/123.zip";

    private static String JPG_FILE_PATH="D:/pic/zip/";
    public static void main(String [] args) throws IOException
    {
//        File file = new File("D:/pic/zip/123.zip");//要解压的文件
//
//        File outFile = null;
//        ZipFile zipFile = new ZipFile(file);//创建压缩文件对象
//        ZipInputStream zi = null;
//
//        InputStream is = null;
//        OutputStream os = null;
//        ZipEntry entry = null ;	// 每一个压缩实体
//
//        zi = new ZipInputStream(new FileInputStream(file));// 实例化ZIpInputStream
//
//        String dir = file.getName().substring(0, file.getName().length()-3);//解压后的文件夹名和压缩文件名（不加拓展名）相同
//        //开始时间
//        long beginTime = System.currentTimeMillis();
//        while((entry=zi.getNextEntry())!=null)//得到一个压缩实体
//        {
//            System.out.println("解压缩" + entry.getName() + "文件。") ;
//            outFile = new File("F:"+ File.separator  + dir+ File.separator + entry.getName()) ;	// 定义输出的文件路径
//
//            if(!outFile.getParentFile().exists())
//            {
//                outFile.getParentFile().mkdir();
//            }
//
//            if(!outFile.exists())
//            {
//                if(outFile.isDirectory()||entry.isDirectory())
//                {
//                    outFile.mkdir();
//                }else{
//                    outFile.createNewFile();
//                }
//            }
//
//
//
//
//
//            is = zipFile.getInputStream(entry) ;	// 得到每一个实体的输入流
//
//
//            if(outFile.isDirectory())
//            {
//                continue;
//            }else
//            {
//                os = new FileOutputStream(outFile);
//                int len = 0;
//                byte [] buf = new byte[1024*10];
//                while((len = is.read(buf))!=-1)
//                {
//                    os.write(buf, 0, len);
//                }
//                is.close();
//                os.close();
//                entry.clone();
//
//
//
//            }
//
//
//
//        }
//        printInfo(beginTime);
//        zi.close();
        long beginTime = System.currentTimeMillis();
        unpack(new File(ZIP_FILE),new File(JPG_FILE_PATH));
        printInfo(beginTime);
    }



    public static void printInfo(long beginTime) {
        long endTime= System.currentTimeMillis();
        long total=endTime-beginTime;
        System.out.println("耗時："+total);
    }

    public final static void unpack(File zipFile, File rootDir) throws IOException {
        ZipFile zip = new ZipFile(zipFile);

        Enumeration entries = (Enumeration) zip.entries();

        while(entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();

            java.io.File f = new java.io.File(rootDir, entry.getName());

            if (entry.isDirectory()) { // if its a directory, create it
                continue;
            }

            if (!f.exists()) {
                f.getParentFile().mkdirs();

                f.createNewFile();

            }

            BufferedInputStream bis = new BufferedInputStream(zip.getInputStream(entry)); // get the input stream

            BufferedOutputStream bos = new BufferedOutputStream(new java.io.FileOutputStream(f));

            while (bis.available() > 0) { // write contents of 'is' to 'fos'

                bos.write(bis.read());

            }

            bos.close();

            bis.close();

        }
    }

}
