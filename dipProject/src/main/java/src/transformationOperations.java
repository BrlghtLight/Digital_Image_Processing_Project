package src;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Ellen, Marcus
 */
public class transformationOperations {

    /**
     * Applies a power law transformation to the provided Buffered Image
     * Uses image dimensions, c-value, and gamma to produce a new edited image values
     *
     * @param fileImage
     * @throws IOException
     */
    public static void powerLawTransform(BufferedImage fileImage) throws IOException {
        int imageWidth = fileImage.getWidth();
        int imageHeight = fileImage.getHeight();
        int c = Integer.parseInt(JOptionPane.showInputDialog("C Value?: "));

        double gamma = Double.parseDouble(JOptionPane.showInputDialog("Gamma Value?: "));


        for (int i = 0; i < imageWidth; ++i) {
            for (int j = 0; j < imageHeight; ++j) {
                int pixel = fileImage.getRGB(i, j);
                int r = pixel >> 16 & 255;
                pixel = (int) (c * Math.pow((double) r, gamma));
                pixel = 805306368 | (pixel & 255) << 16 | (pixel & 255) << 8 | pixel & 255;
                fileImage.setRGB(i, j, pixel);
            }
        }
    }

    /**
     * Takes the image object's BufferedImage data member and applies
     * a negative image transformation, only utilizing the length and width of the photo
     * The image has its color values adjusted
     *
     * @param fileImage
     * @throws IOException
     */
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

    /**
     * The image object's BufferedImage data member is passed to the logTransfarmation
     * and the log transformation is performed on it
     * A log table is initialized and a c value is obtained from the user using JOptionPane
     *
     * @param fileImage
     * @throws IOException
     */
    public static void logTransformation(BufferedImage fileImage) throws IOException {
        int[] logTable;
        int c = Integer.parseInt(JOptionPane.showInputDialog("C Value?: "));

        logTable = new int[256];

        for (int i = 0; i < 256; ++i) {
            logTable[i] = (c * (int) (Math.log((double) (i + 1))));
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

    /**
     * Arithmetic Operations are passed two separate BufferedImages from two different
     * Image Objects.  The primary (first) image's dimensions are used and the operation
     * is applied to that first image passed.
     *
     * @param fileImage
     * @param fileImage2
     * @throws IOException
     */
    public static void imageSubtraction(BufferedImage fileImage, BufferedImage fileImage2) throws IOException {
        int imageWidth = fileImage.getWidth();
        int imageHeight = fileImage.getHeight();

        for (int j = 0; j < imageHeight; ++j) {
            for (int i = 0; i < imageWidth; ++i) {
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

    /**
     * Arithmetic Operations are passed two separate BufferedImages from two different
     * Image Objects.  The primary (first) image's dimensions are used and the operation
     * is applied to that first image passed.
     *
     * @param fileImage
     * @param fileImage2
     * @throws IOException
     */
    public static void imageAddition(BufferedImage fileImage, BufferedImage fileImage2) throws IOException {
        int imageWidth = fileImage.getWidth();
        int imageHeight = fileImage.getHeight();

        for (int j = 0; j < imageHeight; ++j) {
            for (int i = 0; i < imageWidth; ++i) {
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

    /**
     * Arithmetic Operations are passed two separate BufferedImages from two different
     * Image Objects.  The primary (first) image's dimensions are used and the operation
     * is applied to that first image passed.
     *
     * @param fileImage
     * @param fileImage2
     * @throws IOException
     */
    public static void imageMultiplication(BufferedImage fileImage, BufferedImage fileImage2) throws IOException {
        int imageWidth = fileImage.getWidth();
        int imageHeight = fileImage.getHeight();

        for (int j = 0; j < imageHeight; ++j) {
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

    /**
     * Arithmetic Operations are passed two separate BufferedImages from two different
     * Image Objects.  The primary (first) image's dimensions are used and the operation
     * is applied to that first image passed.
     *
     * @param fileImage
     * @param fileImage2
     * @throws IOException
     */
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
