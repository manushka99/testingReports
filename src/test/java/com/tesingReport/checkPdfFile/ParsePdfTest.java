package com.tesingReport.checkPdfFile;

import com.tesingReport.dto.PixelDto;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParsePdfTest {
    private CheckingPdf checkingPdf = new CheckingPdf();

    private final String file = "D:\\dev\\idea\\testingReports\\src\\main\\resources\\thank2.jpg";
    private final String fileActual = "D:\\dev\\idea\\testingReports\\src\\main\\resources\\thank2.jpg";

    @Test
    public void parseJpeg() { //todo сделать нормальный тест!
//        assertEquals(checkingPdf.parseJpeg(new File(fileActual)), checkingPdf.parseJpeg(new File(file)));
    }

    @Test
    public void listEqualsTrue() throws Exception {
        List<Color> listExpected = new ArrayList();
            listExpected.add(new Color(1,1,1));
            listExpected.add(new Color(1,1,1));
            listExpected.add(new Color(1,1,1));

        List<Color> listActual = new ArrayList();
            listActual.add(new Color(1,1,1));
            listActual.add(new Color(1,1,1));
            listActual.add(new Color(1,1,1));

        assertTrue(checkingPdf.listEquals(listExpected, listActual));
    }

    @Test
    public void listEqualsFalse() throws Exception {
        List<Color> listExpected = new ArrayList();
        listExpected.add(new Color(1,1,1));
        listExpected.add(new Color(1,1,1));
        listExpected.add(new Color(1,1,1));

        List<Color> listActual = new ArrayList();
        listActual.add(new Color(2,1,1));
        listActual.add(new Color(1,1,1));
        listActual.add(new Color(1,1,1));

        assertFalse(checkingPdf.listEquals(listExpected, listActual));
    }

  /*  @Test
    public void test() throws Exception {
        List<PixelDto> pixelDtoListExpected = new ArrayList<>();
            pixelDtoListExpected.add(PixelDto.builder()
                    .x(0)
                    .y(0)
                    .color(new Color(1,1,1))
                    .build());
        pixelDtoListExpected.add(PixelDto.builder()
                .x(1)
                .y(1)
                .color(new Color(1,1,1))
                .build());

        List<PixelDto> pixelDtoListActual= new ArrayList<>();
        pixelDtoListActual.add(PixelDto.builder()
                .x(0)
                .y(0)
                .color(new Color(1,1,1))
                .build());
        pixelDtoListActual.add(PixelDto.builder()
                .x(1)
                .y(1)
                .color(new Color(1,1,1))
                .build());

        assertTrue(checkingPdf.comparePixelDtoList(pixelDtoListExpected, pixelDtoListActual));
    }

    @Test
    public void testNegative() throws Exception {
        List<PixelDto> pixelDtoListExpected = new ArrayList<>();
        pixelDtoListExpected.add(PixelDto.builder()
                .x(0)
                .y(0)
                .color(new Color(1,1,1))
                .build());
        pixelDtoListExpected.add(PixelDto.builder()
                .x(1)
                .y(1)
                .color(new Color(1,1,1))
                .build());

        List<PixelDto> pixelDtoListActual= new ArrayList<>();
        pixelDtoListActual.add(PixelDto.builder()
                .x(0)
                .y(0)
                .color(new Color(1,1,1))
                .build());
        pixelDtoListActual.add(PixelDto.builder()
                .x(1)
                .y(1)
                .color(new Color(2,1,1))
                .build());

        assertFalse(checkingPdf.comparePixelDtoList(pixelDtoListExpected, pixelDtoListActual));
    } */



}
