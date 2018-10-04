package com.tesingReport.checkPdfFile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PixelsColor {

    public Color setRedColor() {
        return new Color(200,0,0);
    }


    public Color getPixelColor(BufferedImage bi, int x, int y) {
        Object colorData = bi.getRaster().getDataElements(x, y, null);//данные о пикселе
        int argb = bi.getColorModel().getRGB(colorData);//преобразование данных в цветовое значение
        return new Color(argb, true);
    }

}
