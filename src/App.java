import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import views.MainForm;
import views.frmLogin;

public class App {

    public static void main(String[] args) {
        
        try {
                    UIManager.setLookAndFeel(new NimbusLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
//        MainForm productos = new MainForm();
//       frmLogin

        frmLogin login=new  frmLogin();
         login.setVisible(true);
        
    }

}
