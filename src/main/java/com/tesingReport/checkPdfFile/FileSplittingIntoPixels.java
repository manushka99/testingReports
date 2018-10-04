package com.tesingReport.checkPdfFile;

import com.tesingReport.dto.ImageDto;
import com.tesingReport.dto.PixelDto;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSplittingIntoPixels {
    private PixelsColor pixels = new PixelsColor();

    public ImageDto splittingImageIntoPixels(File file) {
        try {
            List<PixelDto> pixelDtoList = new ArrayList<PixelDto>();
            BufferedImage img = ImageIO.read(file);
            int minX = img.getMinX();
            int minY = img.getMinY();
            int maxX = img.getWidth();
            int maxY = img.getHeight();

            for (int x = minX; x < maxX; x++) {
                for (int y = minY; y < maxY; y++) {
                    pixelDtoList.add(PixelDto.builder()
                            .x(x)
                            .y(y)
                            .color(pixels.getPixelColor(img, x, y))
                            .build());
                }
            }

            return ImageDto.builder()
                    .maxX(maxX)
                    .maxY(maxY)
                    .pixelDtoList(pixelDtoList)
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean writeImageFile(List<PixelDto> pixelDtoList, int maxX, int maxY) {
        try {

            BufferedImage image = new BufferedImage(maxX, maxY, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < pixelDtoList.size(); i++) {
                PixelDto pixelDto = pixelDtoList.get(i);
                image.setRGB(pixelDto.getX(), pixelDto.getY(), pixelDto.getColor().getRGB());
            }
            ImageIO.write(image, "jpg", new File("D:\\dev\\idea\\testingReports\\src\\test\\resources\\testFailed.jpg"));

        return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

}
