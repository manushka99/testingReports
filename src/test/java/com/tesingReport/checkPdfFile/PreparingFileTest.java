package com.tesingReport.checkPdfFile;

import org.junit.Test;

import java.io.File;
import static org.junit.Assert.*;

public class PreparingFileTest {
    private PreparingFile preparingFile = new PreparingFile();

    private final String fileName= "D:\\dev\\idea\\testingReports\\src\\test\\resources\\minimal.pdf";

    @Test
    public void pdf() {
        assertNull(preparingFile.fileToByteArray(new File(fileName)));
    }

    @Test
    public void file() {
        byte[] b = preparingFile.fileToByteArray(new File(fileName));
        assertTrue(preparingFile.byteArrayToFile(new File("D:\\dev\\idea\\testingReports\\src\\test\\resources\\test.pdf"), b));
    }
}