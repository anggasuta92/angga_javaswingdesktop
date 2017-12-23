/*
 * ini untuk menghandle operasi form
 */
package userinterface;

import java.awt.Dimension;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Angga Suta Dharmawan - 16101650
 */
public class FormHandler {

    public static void openForm(JInternalFrame frame, JDesktopPane desktopPane, String frmTitle){
        try{
            boolean status=false;  
            javax.swing.JInternalFrame[] children;  
            children=desktopPane.getAllFrames();
            for (JInternalFrame f:children){  
                if(f.getTitle().equalsIgnoreCase(frmTitle)){  
                    f.setSelected(true);  
                    status=true;  
                    break;
                }
            }
            
            if (status==false){
                desktopPane.add(frame);
                frame.setVisible(true);
                
                Dimension desktopSize = desktopPane.getSize();
                Dimension jLoginFrameSize = frame.getSize();
                frame.setLocation((desktopSize.width - jLoginFrameSize.width)/2, (desktopSize.height - jLoginFrameSize.height)/2);
            }
        }catch(PropertyVetoException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
