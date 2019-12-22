
package controller;

import static model.PropertyChangeEnabledRaceControls.PROPERTY_MAP;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_TIME;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.Message;
import model.Race;

/**
 * Swing Timer Panel class.
 * 
 * @author minhphan
 * @version Fall 2018
 *
 */
public class RaceDOS extends JPanel implements PropertyChangeListener {
    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = 8385732728740430466L;

    /** The number of rows in the text area. */
    private static final int TEXT_AREA_ROWS = 10;

    /** The number of columns in the text area. */
    private static final int TEXT_AREA_COLS = 50;

    /** Label for the timer. */
    private static JTextArea myDos;
    
    /** Race Object. */
    private Race myRace = new Race();
    


    /**
     * Construct a Time Panel.
     */
    public RaceDOS() {
        super();

        myDos = new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLS);

        setupComponents();     
            
    }
    

    /**
     * Setup components methods.
     */
    private void setupComponents() {

        final JScrollPane scrollPane =
                        new JScrollPane(myDos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        myDos.setEditable(false);
        add(scrollPane);
        
    }
    
    /**
     * Set Text field empty.
     */
    public void setEmpty() {
        myDos.setText(null);
    }


    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (PROPERTY_TIME.equals(theEvent.getPropertyName())) {
            final List<Message> value = myRace.getMap().get(theEvent.getNewValue());
            for (Message v : value) {
                myDos.append(v + "\n");
            }
//            
//           myDos.append(myRace.getMap().get(theEvent.getNewValue()) + "\n");
           
         
        }
        if (PROPERTY_MAP.equals(theEvent.getPropertyName())) {

            myRace = (Race) theEvent.getNewValue();

        }
    }

}
