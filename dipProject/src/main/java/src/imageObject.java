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
    private BufferedImage image2;
    private File selectedFile;

    //default
    public imageObject() {
    }

    //overload
    public imageObject(BufferedImage image, File selectedFile) {
        this.image = image;
        this.selectedFile = selectedFile;
    }

    //overload
    public imageObject(BufferedImage image, BufferedImage image2, File selectedFile) {
        this.image = image;
        this.image2 = image2;
        this.selectedFile = selectedFile;
    }

    // get && set
    public BufferedImage getImage() {
        return image;
    }

    public BufferedImage getImage2() { return image2; }

    public File getSelectedFile() {
        return selectedFile;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setImage2(BufferedImage image2) { this.image2 = image2; }

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
        transformationOperations.imageAddition(this.image, this.image2);
    }

    public void doSubtraction() throws IOException {
        transformationOperations.imageSubtraction(this.image, this.image2);
    }

    public void doMultiplication() throws IOException {
        transformationOperations.imageMultiplication(this.image, this.image2);
    }

    public void doDivision() throws IOException {
        transformationOperations.imageDivision(this.image, this.image2);
    }

}
