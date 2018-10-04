package com.tesingReport.checkPdfFile;

import com.tesingReport.dto.ImageDto;
import com.tesingReport.dto.PixelDto;

import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.List;

public class CheckingPdf {
    private PixelsColor pixelsColor = new PixelsColor();
    private FileSplittingIntoPixels fileSplittingIntoPixels = new FileSplittingIntoPixels();

    public boolean comparePixelDtoList(ImageDto expectedImageDto, ImageDto actualImageDto) throws Exception {
        int listSize;
        boolean result = true;
        if (actualImageDto.getPixelDtoList().size() == expectedImageDto.getPixelDtoList().size()) {
            listSize = actualImageDto.getPixelDtoList().size();
        } else {
            throw new Exception("Не корректная длина листов");
        }

        for (int i = 0; i < listSize; i++) {
            if (!expectedImageDto.getPixelDtoList().get(i).getColor().equals(actualImageDto.getPixelDtoList().get(i).getColor())) {
                result = false;
                actualImageDto.getPixelDtoList().add(PixelDto.builder()
                        .x(actualImageDto.getPixelDtoList().get(i).getX())
                        .y(actualImageDto.getPixelDtoList().get(i).getY())
                        .color(pixelsColor.setRedColor())
                        .build());
            }
        }

        if (!result) {
            createNotValidImage(actualImageDto);
        }

        return result;
    }

    public void createNotValidImage(ImageDto imageDto) {
        fileSplittingIntoPixels.writeImageFile(imageDto.getPixelDtoList(), imageDto.getMaxX(), imageDto.getMaxY());
    }

    public boolean listEquals(List<Color> listExpected, List<Color> listActual) throws Exception {
        int listSize;

        if (listActual.size() == listExpected.size()) {
            listSize = listActual.size();
        } else {
            throw new Exception("Не корректная длина листов");
        }

        for (int i = 0; i < listSize; i++) {
            if (!listExpected.get(i).equals(listActual.get(i))) {
//                listExpected.set(i, setColor());
                return false;
            }
        }


        return true;
    }

    public static BufferedImage getImageFromArray(int[] pixels, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        WritableRaster raster = (WritableRaster) image.getData();
        raster.setPixels(0,0,width,height,pixels);

        return image;
    }


}
