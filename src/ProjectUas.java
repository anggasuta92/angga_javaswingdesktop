
import classes.DatabaseConnection;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.multi.MultiLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;
import userinterface.FrmLogin;
import userinterface.FrmMain;
import static userinterface.FrmMain.openForm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angga Suta Dharmawan 16101650
 */
public class ProjectUas {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WindowsClassicLookAndFeel());
            //new FrmMain().setVisible(true);
            //FrmMain.openForm(new FrmLogin(), "Selamat Datang...");
            new FrmLogin().setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ProjectUas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e){
            
        }
    }
}
