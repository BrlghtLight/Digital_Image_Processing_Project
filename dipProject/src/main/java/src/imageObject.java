package src;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ellen, Marcus
 */
public class imageObject {

    private BufferedImage image;
    private File selectedFile;

    //default
    public imageObject() {
    }

    //overload
    public imageObject(BufferedImage image, File selectedFile) {
        this.image = image;
        this.selectedFile = selectedFile;
    }

    // get && set
    public BufferedImage getImage() {
        return image;
    }

    public File getSelectedFile() {
        return selectedFile;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }

    //toString()
    @Override
    public String toString() {
        return "Image Object:"
                + "\nImage: " + image
                + "\nSelected File: " + selectedFile;
    }

    public void doPowerLawTransform() throws IOException {
        transformationOperations.powerLawTransform(this.image);
    }

    public void makeImageNegative() throws IOException {
        transformationOperations.imageNegative(this.image);
    }

    public void doLogTransform() throws IOException {
        transformationOperations.logTransformation(this.image);
    }

    public void doAddition() throws IOException {
        ArrayList results = transformationOperations.arithmetic(this.image);
        int[][] result = (int[][]) results.get(0);
        int[][] result2 = (int[][]) results.get(1);
        transformationOperations.addition(this.image, result, result2);
    }

    public void doSubtraction() throws IOException {
        ArrayList results = transformationOperations.arithmetic(this.image);
        int[][] result = (int[][]) results.get(0);
        int[][] result2 = (int[][]) results.get(1);
        transformationOperations.subtraction(this.image, result, result2);
    }

    public void doMultiplication() throws IOException {
        ArrayList results = transformationOperations.arithmetic(this.image);
        int[][] result = (int[][]) results.get(0);
        int[][] result2 = (int[][]) results.get(1);
        transformationOperations.multiplication(this.image, result, result2);
    }

    public void doDivision() throws IOException {
        ArrayList results = transformationOperations.arithmetic(this.image);
        int[][] result = (int[][]) results.get(0);
        int[][] result2 = (int[][]) results.get(1);
        transformationOperations.division(this.image, result, result2);
    }

}
