package src;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ellen, Marcus
 */
public class transformationOperations {

    int C = 48;

    public static void powerLawTransform(BufferedImage fileImage) throws IOException {
        int imageWidth = fileImage.getWidth();
        int imageHeight = fileImage.getHeight();
        double gamma = 0.3D;

        for (int i = 0; i < imageWidth; ++i) {
            for (int j = 0; j < imageHeight; ++j) {
                int pixel = fileImage.getRGB(i, j);
                int r = pixel >> 16 & 255;
                pixel = (int) (48.0D * Math.pow((double) r, gamma));
                pixel = 805306368 | (pixel & 255) << 16 | (pixel & 255) << 8 | pixel & 255;
                fileImage.setRGB(i, j, pixel);
            }
        }
    }

    public static void imageNegative(BufferedImage fileImage) throws IOException {
        int imageWidth = fileImage.getWidth();
        int imageHeight = fileImage.getHeight();

        for (int j = 0; j < imageHeight; ++j) {
            for (int i = 0; i < imageWidth; ++i) {
                int pixel = fileImage.getRGB(i, j);
                int r = pixel >> 16 & 255;
                pixel = 255 - r;
                pixel = (pixel & 255) << 16 | (pixel & 255) << 8 | pixel & 255;
                fileImage.setRGB(i, j, pixel);
            }
        }
    }

    public static void logTransformation(BufferedImage fileImage) throws IOException {
        int[] logTable;
        logTable = new int[256];

        for (int i = 0; i < 256; ++i) {
            logTable[i] = (int) (46.0D * Math.log((double) (i + 1)));
        }

        int width = fileImage.getWidth();
        int height = fileImage.getHeight();

        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                int pixel = fileImage.getRGB(i, j);
                int r = pixel >> 16 & 255;
                pixel = (0 | (logTable[r] & 255) << 16 | logTable[r] & 255) << 8 | logTable[r] & 255;
                fileImage.setRGB(i, j, pixel);
            }
        }
    }

    public static void imageSubtraction(BufferedImage fileImage, BufferedImage fileImage2) throws IOException {
        int imageWidth = fileImage.getWidth();
        int imageHeight = fileImage.getHeight();

        for(int j = 0; j < imageHeight; ++j) {
            for(int i = 0; i < imageWidth; ++i) {
                int pixel = fileImage.getRGB(i, j);
                int pixel2 = fileImage2.getRGB(i, j);
                int r = pixel >> 16 & 255;
                int r2 = pixel2 >> 16 & 255;
                int min = 2147483647;
                int max = -2147483648;
                pixel = r2 - r;
                pixel = (pixel - min) / (max - min) - 255;
                pixel = -16777216 | (pixel & 255) << 16 | (pixel & 255) << 8 | pixel & 255;
                fileImage.setRGB(i, j, pixel);
            }
        }
    }

    public static void imageAddition(BufferedImage fileImage, BufferedImage fileImage2) throws IOException {
        int imageWidth = fileImage.getWidth();
        int imageHeight = fileImage.getHeight();

        for(int j = 0; j < imageHeight; ++j) {
            for(int i = 0; i < imageWidth; ++i) {
                int pixel = fileImage.getRGB(i, j);
                int pixel2 = fileImage2.getRGB(i, j);
                int r = pixel >> 16 & 255;
                int r2 = pixel2 >> 16 & 255;
                pixel = r2 + r + 255;
                pixel = -16777216 | (pixel & 255) << 16 | (pixel & 255) << 8 | pixel & 255;
                fileImage.setRGB(i, j, pixel);
            }
        }
    }

    public static void imageMultiplication(BufferedImage fileImage, BufferedImage fileImage2) throws IOException {
        int imageWidth = fileImage.getWidth();
        int imageHeight = fileImage.getHeight();

        for(int j = 0; j < imageHeight; ++j) {
            for (int i = 0; i < imageWidth; ++i) {
                int pixel = fileImage.getRGB(i, j);
                int pixel2 = fileImage2.getRGB(i, j);
                int r = pixel >> 16 & 255;
                int r2 = pixel2 >> 16 & 255;
                pixel = r2 * r * 255;
                pixel = -16777216 | (pixel & 255) << 16 | (pixel & 255) << 8 | pixel & 255;
                fileImage.setRGB(i, j, pixel);
            }
        }
    }

    public static void imageDivision(BufferedImage fileImage, BufferedImage fileImage2) throws IOException {
        int imageWidth = fileImage.getWidth();
        int imageHeight = fileImage.getHeight();

        for (int j = 0; j < imageHeight; ++j) {
            for (int i = 0; i < imageWidth; ++i) {
                int pixel = fileImage.getRGB(i, j);
                int pixel2 = fileImage2.getRGB(i, j);
                int r = pixel >> 16 & 255;
                pixel = r;
                int r2 = pixel2 >> 16 & 255;
                if (r > 0 && r2 > 0) {
                    pixel = r2 / r * 255;
                }

                pixel = -16777216 | (pixel & 255) << 16 | (pixel & 255) << 8 | pixel & 255;
                fileImage.setRGB(i, j, pixel);
            }
        }
    }
}
