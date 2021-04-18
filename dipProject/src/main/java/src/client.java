package src;

import java.awt.image.BufferedImage;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Ellen & Marcus
 */
public class client extends javax.swing.JFrame {

    //initialized variables
    File selectedFile = null;
    ImageIcon labelIcon;

    BufferedImage readImage = null;
    BufferedImage readImage2 = null;

    imageObject selectedImage = null;
    imageObject selectedImage2 = null;

    /**
     * Creates new form client
     */
    public client() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guiPanel = new javax.swing.JPanel();
        processButton = new javax.swing.JButton();
        selectButton = new javax.swing.JButton();
        transformField = new javax.swing.JTextField();
        transformScroll = new javax.swing.JScrollPane();
        transformArea = new javax.swing.JTextArea();
        imagePanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 500));

        guiPanel.setBackground(new java.awt.Color(0, 0, 0));

        processButton.setBackground(new java.awt.Color(0, 0, 0));
        processButton.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        processButton.setForeground(new java.awt.Color(0, 255, 204));
        processButton.setText("Process");
        processButton.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 255, 204)));
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        selectButton.setBackground(new java.awt.Color(0, 0, 0));
        selectButton.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        selectButton.setForeground(new java.awt.Color(0, 255, 204));
        selectButton.setText("Select File");
        selectButton.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 1, new java.awt.Color(0, 255, 204)));
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        transformField.setBackground(new java.awt.Color(0, 0, 0));
        transformField.setFont(new java.awt.Font("DialogInput", 1, 11)); // NOI18N
        transformField.setForeground(new java.awt.Color(0, 255, 204));
        transformField.setText(" Transformation Type?");
        transformField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 204)));

        transformArea.setEditable(false);
        transformArea.setBackground(new java.awt.Color(0, 0, 0));
        transformArea.setColumns(20);
        transformArea.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        transformArea.setForeground(new java.awt.Color(0, 255, 204));
        transformArea.setRows(5);
        transformArea.setText("Transformations:\n\n > Addition\n > Subtraction\n > Multiplication\n > Division\n > Negative\n > Power-Law\n > Log");
        transformArea.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        transformScroll.setViewportView(transformArea);

        imagePanel.setBackground(new java.awt.Color(102, 102, 102));

        imageLabel.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        imageLabel.setForeground(new java.awt.Color(0, 255, 204));
        imageLabel.setText("Image Appears Here....");

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
                imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
                imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout guiPanelLayout = new javax.swing.GroupLayout(guiPanel);
        guiPanel.setLayout(guiPanelLayout);
        guiPanelLayout.setHorizontalGroup(
                guiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(guiPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(guiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(guiPanelLayout.createSequentialGroup()
                                                .addComponent(selectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(guiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(transformScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                        .addComponent(transformField))
                                .addContainerGap())
        );
        guiPanelLayout.setVerticalGroup(
                guiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, guiPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(guiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(transformScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                        .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(guiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(selectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(transformField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(guiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(guiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Allows a user to select up to two image files via input
     * and then display the primary image to the interface
     * Creates buffered images and a JLabel to the GUI
     */
    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed

        String imageCount = JOptionPane.showInputDialog("How Many Images?: ");

        //select image file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }

        //file to buffered image
        try {
            readImage = ImageIO.read(selectedFile);
        } catch (IOException ex) {
            System.out.println("Error");
        }


        if (Integer.parseInt(imageCount) == 2) {
            result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            }
        }

        //file to buffered image
        try {
            readImage2 = ImageIO.read(selectedFile);
        } catch (IOException ex) {
            System.out.println("Error");
        }

        //put buffered image into image area GUI
        labelIcon = new ImageIcon(readImage);
        imageLabel.setIcon(labelIcon);
        imageLabel.setText("");

        //create imageObject
        selectedImage = new imageObject(readImage, readImage2, selectedFile);
    }//GEN-LAST:event_selectButtonActionPerformed

    /**
     * Processes a desired transformation or edit to the selected image file once
     * the user enters which operation they want to perform to the
     * transformation text field and click the process button
     *
     * @param evt
     */
    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed

        String userInput = transformField.getText();

        if (userInput.equalsIgnoreCase("Addition")) {
            try {
                selectedImage.doAddition();
            } catch (IOException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageLabel.setIcon(null);
            labelIcon = new ImageIcon(selectedImage.getImage());
            imageLabel.setIcon(labelIcon);
        }
        if (userInput.equalsIgnoreCase("Subtraction")) {
            try {
                selectedImage.doSubtraction();
            } catch (IOException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageLabel.setIcon(null);
            labelIcon = new ImageIcon(selectedImage.getImage());
            imageLabel.setIcon(labelIcon);

        }
        if (userInput.equalsIgnoreCase("Multiplication")) {
            try {
                selectedImage.doMultiplication();
            } catch (IOException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageLabel.setIcon(null);
            labelIcon = new ImageIcon(selectedImage.getImage());
            imageLabel.setIcon(labelIcon);

        }
        if (userInput.equalsIgnoreCase("Division")) {
            try {
                selectedImage.doDivision();
            } catch (IOException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageLabel.setIcon(null);
            labelIcon = new ImageIcon(selectedImage.getImage());
            imageLabel.setIcon(labelIcon);

        }
        if (userInput.equalsIgnoreCase("Negative")) {
            try {
                selectedImage.makeImageNegative();
            } catch (IOException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageLabel.setIcon(null);
            labelIcon = new ImageIcon(selectedImage.getImage());
            imageLabel.setIcon(labelIcon);

        }
        if (userInput.equalsIgnoreCase("Power-Law")) {
            try {
                selectedImage.doPowerLawTransform();
            } catch (IOException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageLabel.setIcon(null);
            labelIcon = new ImageIcon(selectedImage.getImage());
            imageLabel.setIcon(labelIcon);
        }
        if (userInput.equalsIgnoreCase("Log")) {
            try {
                selectedImage.doLogTransform();
            } catch (IOException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageLabel.setIcon(null);
            labelIcon = new ImageIcon(selectedImage.getImage());
            imageLabel.setIcon(labelIcon);
        }
    }//GEN-LAST:event_processButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel guiPanel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton processButton;
    private javax.swing.JButton selectButton;
    private javax.swing.JTextArea transformArea;
    private javax.swing.JTextField transformField;
    private javax.swing.JScrollPane transformScroll;
    // End of variables declaration//GEN-END:variables
}

//image processing methods / new class

//unage object class
