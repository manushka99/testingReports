package com.tesingReport.checkPdfFile;

import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.zip.InflaterInputStream;

public class PreparingFile {

    public byte[] fileToByteArray(File file) {
        try {
            return FileUtils.readFileToByteArray(file);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean byteArrayToFile(File file, byte[] bytes) {
        try {

            FileUtils.writeByteArrayToFile(file, bytes);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean byteArrayToFile(byte[] byteArray, String filePath, String fileName) {
        try {
            FileOutputStream file = new FileOutputStream(filePath + "\\" + fileName + ".jpg");
            ByteArrayInputStream input = new ByteArrayInputStream(byteArray);
            BufferedImage bi = ImageIO.read(input);
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(byteArray));


            ImageIO.write(ImageIO.read(new ByteArrayInputStream(byteArray)), "jpg", file);


            return true;


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }




}
