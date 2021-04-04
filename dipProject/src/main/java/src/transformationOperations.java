package src;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
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

    public static ArrayList arithmetic(BufferedImage fileImage) throws IOException {
        final byte[] image = ((DataBufferByte) fileImage.getRaster().getDataBuffer()).getData();
        int imageWidth = fileImage.getWidth();
        int imageHeight = fileImage.getHeight();
        int[][] result = new int[imageHeight][imageWidth];
        int[][] result2 = new int[imageHeight][imageWidth];
        ArrayList results = new ArrayList();

        for (int pixel = 0, row = 0, col = 0; pixel < image.length; pixel++) {
            int argb = 0;
            argb = (int) image[pixel];

            if (argb < 0) {
                argb += 256;
            }

            result[row][col] = argb;
            col++;

            if (col == imageWidth) {
                col = 0;
                row++;
            }
        }

        for (int pixel = 0, row = 0, col = 0; pixel < image.length; pixel++) {
            int argb = 0;
            argb = (int) image[pixel];

            if (argb < 0) {
                argb += 256;
            }

            result2[row][col] = argb;
            col++;

            if (col == imageWidth) {
                col = 0;
                row++;
            }
        }
        results.add(result);
        results.add(result2);
        return results;
    }

    public static void addition(BufferedImage fileImage, int result[][], int result2[][]) {
        int solution[][] = new int[fileImage.getHeight()][fileImage.getWidth()];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solution[i][j] = result[i][j] + result2[i][j];

            }
        }
    }

    public static void subtraction(BufferedImage fileImage, int result[][], int result2[][]) {
        int solution[][] = new int[fileImage.getHeight()][fileImage.getWidth()];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solution[i][j] = result[i][j] - result2[i][j];

            }
        }
    }

    public static void multiplication(BufferedImage fileImage, int result[][], int result2[][]) {
        int solution[][] = new int[fileImage.getHeight()][fileImage.getWidth()];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solution[i][j] = result[i][j] * result2[i][j];

            }
        }
    }

    public static void division(BufferedImage fileImage, int result[][], int result2[][]) {
        int solution[][] = new int[fileImage.getHeight()][fileImage.getWidth()];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solution[i][j] = result[i][j] / result2[i][j];

            }
        }
    }

}
