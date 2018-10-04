package com.tesingReport.checkPdfFile;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FileSplittingIntoPixelsTest {
    private FileSplittingIntoPixels fileSplittingIntoPixels = new FileSplittingIntoPixels();

    @Test
    public void splittingImageIntoPixels() {
     fileSplittingIntoPixels.splittingImageIntoPixels(new File("D:\\dev\\idea\\testingReports\\src\\main\\resources\\thank2.jpg"));
    }
}