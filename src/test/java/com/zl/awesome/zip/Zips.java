package com.zl.awesome.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author: netposa
 * @Date: 2021/4/12 15:43
 * @Description:
 */
public class Zips {
    private static String ZIP_FILE="D:/pic/zip/test.zip";

    private static String JPG_FILE_PATH="D:/pic/zip/";

    private static String JPG_FILE_NAME="img";

    public static void zipFileBuffer() {
        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOut)) {
            //开始时间
            long beginTime = System.currentTimeMillis();
            for (int i = 1; i <11; i++) {
                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(JPG_FILE_PATH + i + ".jpg"))) {
                    zipOut.putNextEntry(new ZipEntry(JPG_FILE_NAME + i + ".jpg"));
                    int temp = 0;
                    while ((temp = bufferedInputStream.read()) != -1) {
                        bufferedOutputStream.write(temp);
                    }
                }
            }
            printInfo(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void printInfo(long beginTime) {
        long endTime= System.currentTimeMillis();
        long total=endTime-beginTime;
        System.out.println("耗時："+total);
    }

    public static void main(String[] args) {
        zipFileBuffer();
    }
}
