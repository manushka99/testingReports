package com.tesingReport.IntegrationTest;

import com.tesingReport.checkPdfFile.CheckingPdf;
import com.tesingReport.checkPdfFile.FileSplittingIntoPixels;
import com.tesingReport.dto.ImageDto;
import org.junit.Test;

import java.io.File;

public class IntegrationTests {
    private FileSplittingIntoPixels fileSplittingIntoPixels = new FileSplittingIntoPixels();
    private CheckingPdf checkingPdf = new CheckingPdf();

    private final String filePathExpected = "D:\\dev\\idea\\testingReports\\src\\test\\resources\\thank1.jpg";
    private final String filePathActual = "D:\\dev\\idea\\testingReports\\src\\test\\resources\\thank1.jpg";


    @Test
    public void compareImages() throws Exception {
        ImageDto expectedFile = fileSplittingIntoPixels.splittingImageIntoPixels(new File(filePathExpected));
        ImageDto actualFile = fileSplittingIntoPixels.splittingImageIntoPixels(new File(filePathActual));

        checkingPdf.comparePixelDtoList(expectedFile, actualFile);

    }

}
