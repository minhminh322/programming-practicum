/*
 * TCSS 305
 * Assignment 4 - SnapShop
 */

package gui;
import filters.EdgeDetectFilter;
import filters.Filter;
import filters.FlipHorizontalFilter;
import filters.FlipVerticalFilter;
import filters.GrayscaleFilter;
import filters.SharpenFilter;
import filters.SoftenFilter;
import image.PixelImage;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * SnapShop GUI class.
 * 
 * @author Minh Phan
 * @version November 3rd, 2018
 */
public class SnapShopGUI {
    
    //instance fields
    /**
     * The frame of GUI.
     */
    private final JFrame myFrame = new JFrame();
    
    /**
     * Panel for the filter buttons.
     */
    private final JPanel myFiltersPanel = new JPanel();
    
    /**
     * Panel for the option buttons.
     */
    private final JPanel myOptionPanel = new JPanel();
    
    /**
     * Label for the image.
     */
    private final JLabel myImageLabel = new JLabel();
    
   /**
    * JFileChooser.
    */
    private final JFileChooser myChooser = new JFileChooser(); 
    
    /**
     * The default directory.
     */
    private File myFile = new File(".");
    
    /**
     * Display image.
     */
    private PixelImage myImage;
      
    /**
     * Array for filter list.
     */
    private Filter[] myFilterList;
    
    /**
     * ArrayList for filter button.
     */
    private List<JButton> myFilterButton;
    
    /**
     * Array for option button.
     */
    private final JButton[] myOptionButton;
 
    
    /**
     * GUI interface constructor.
     */
    public SnapShopGUI() {
        
        super();
        
        myFilterList = new Filter[] {new EdgeDetectFilter(), new EdgeDetectFilter()
                        , new FlipHorizontalFilter(), new FlipVerticalFilter()
                        , new GrayscaleFilter(), new SharpenFilter(), new SoftenFilter()};
        
        myOptionButton = new JButton[] {new JButton("Open..."), new JButton("Save As...")
                        , new JButton("Close Image")};
        
        myFilterButton = new ArrayList<>();  
        
        createFilterButton();
        
        createOptionButton();

        
        

    }
      
    /**
     * Display the GUI on the screen. 
     */
    public void start() {
        
        myFrame.setTitle("TCSS 305 - Assignment 4");
        
        myFrame.add(myFiltersPanel, BorderLayout.CENTER);
        
        myFrame.add(myOptionPanel, BorderLayout.SOUTH);
        
        myFrame.add(myImageLabel, BorderLayout.NORTH);
        
        myImageLabel.setHorizontalAlignment(JLabel.CENTER);
        
        myImageLabel.setVerticalAlignment(JLabel.CENTER);
        
        // set the close operation.
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // set resize of the frame.
        myFrame.setResizable(true);
        
        // center the frame on the screen.
        myFrame.setLocationRelativeTo(null);
        
        myFrame.pack();
       
        myFrame.setVisible(true);     
        
        
        
        
    }
  
    /**
     * Add filter buttons into panel method.
     */
    public void createFilterButton() {

        for (int i = 0; i < myFilterList.length; i++) {

            myFiltersPanel.add(createFilterButton(myFilterList[i]));
        }

    }
    
    /**
     * Assign filters into their button.
     * @param theFilter filter for a button
     * @return a button with assigned filter.
     */
    private JButton createFilterButton(final Filter theFilter) {
        final JButton filterButton = new JButton(theFilter.getDescription());
        
        /**
         * Create an ActionListener using inner class.
         * @author Minh Phan
         *
         */
        class MyActionListener implements ActionListener {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                theFilter.filter(myImage);
                myImageLabel.setIcon(new ImageIcon(myImage));
                myFrame.pack();
            }

        }

        myFilterButton.add(filterButton);
        filterButton.addActionListener(new MyActionListener());
        filterButton.setEnabled(false);
        
        return filterButton;

    }

    /**
     * Create and add option buttons into panel.
     */
    public void createOptionButton() {
        final JButton[] optionButtons = new JButton[myOptionButton.length];

        for (int i = 0; i < optionButtons.length; i++) {

            myOptionPanel.add(myOptionButton[i]);
        }

        listenerButton();
        
        myOptionButton[1].setEnabled(false);
        
        myOptionButton[2].setEnabled(false);

    }

    /**
     * Assign ActionLisner into option buttons. 
     */
    public void listenerButton() {
        myOptionButton[0].addActionListener(event -> openImage());
        myOptionButton[1].addActionListener(event -> saveImage());
        myOptionButton[2].addActionListener(event -> closeImage());

    }

    /**
     * open image method for open button.
     */
    public void openImage() {

        myChooser.setCurrentDirectory(myFile);

        final int result = myChooser.showOpenDialog(myFrame);

        if (result == JFileChooser.APPROVE_OPTION) {
            
            myFile = myChooser.getCurrentDirectory();
            
            try {

                myImage = PixelImage.load(myChooser.getSelectedFile());

                myImageLabel.setIcon(new ImageIcon(myImage));

                myOptionButton[1].setEnabled(true);

                myOptionButton[2].setEnabled(true);

                for (JButton i : myFilterButton) {
                    i.setEnabled(true);
                }

                myFrame.pack();

            } catch (final IOException e) {
                final String message = "The selected file did not contain an image!";

                JOptionPane.showMessageDialog(myFrame, message, "Error!",
                                              JOptionPane.ERROR_MESSAGE);
            }

        }

    }
    
    /**
     * save image method for save button.
     */
    public void saveImage() {
        myChooser.setCurrentDirectory(myFile);

        final int result = myChooser.showSaveDialog(myFrame);

        if (result == JFileChooser.APPROVE_OPTION) {
            
            try {
                myImage.save(myChooser.getSelectedFile());

            } catch (final IOException e) {

            }

        }
    }

    /**
     * close image method for close button.
     */
    public void closeImage() {
        myImageLabel.setIcon(new ImageIcon());

        myOptionButton[1].setEnabled(false);

        myOptionButton[2].setEnabled(false);

        for (JButton i : myFilterButton) {
            i.setEnabled(false);
        }
        
        myFrame.pack();
    }

}