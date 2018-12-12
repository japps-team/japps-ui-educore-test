/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package japps.ui.educore;

import japps.ui.DesktopApp;
import japps.ui.component.Media;
import japps.ui.educore.component.ActivityPanel;
import japps.ui.educore.component.ReadActivityPanel;
import japps.ui.educore.object.Activity;
import japps.ui.educore.object.ActivityOption;
import japps.ui.educore.object.Const;
import java.util.Properties;
import javax.swing.SwingUtilities;
import static japps.ui.util.Resources.*;
import japps.ui.educore.object.Learning;
import java.awt.Font;
import java.nio.file.Paths;

/**
 *
 * @author Williams Lopez - JApps
 */
public class ReadActivityExample {
    
    public static void main(String[] args) {
        DesktopApp.init("educore", new String[]{"reconfigure"});
        
        Properties props = new Properties();
        
        Learning learning = new Learning("read",props);
        
        ActivityPanel panel = new ReadActivityPanel();
        panel.setActivity(addReadActivity(learning));
        SwingUtilities.invokeLater(()->{panel.start();});
        DesktopApp.start(panel);
    }
    
    public static Activity addReadActivity(Learning learning){
        Activity activity = learning.addNewActivity();
        ActivityOption option1 = activity.addNewOption();
        ActivityOption option2 = activity.addNewOption();
        ActivityOption option3 = activity.addNewOption();
        ActivityOption option4 = activity.addNewOption();
        //ActivityOption option4 = new ActivityOption();
        
        Const.COMMON.activity(activity, "Read Activity Example", "Felicidades has terminado la actividad de lectura", null, true);
        Const.READ.activity(activity);
        
        Const.READ.option(option1, Paths.get("res/activities/test/media/i2.jpg"), 
                Media.IMAGE, "Este es el texto de la opción 1 de la actividad de prueba", 
                10000, Font.decode("Arial-BOLD-50"), true, true, true);
        
        Const.READ.option(option2, Paths.get("res/activities/test/media/video.mp4"), 
                Media.VIDEO, null, 
                10000, Font.decode("Arial-BOLD-50"), true, false, true);
        
        Const.READ.option(option3, Paths.get("res/activities/test/media/m.mp3"), 
                Media.SOUND, "Este es un ejemplo de sonido en una actividad", 
                10000, Font.decode("Arial-BOLD-50"), true, true, true);
        
        Const.READ.option(option4, null, 
                Media.VIDEO, "Este es un texto de prueba, Este es un texto de prueba, Este es un texto de prueba, Este es un texto de prueba, Este es un texto de prueba.", 
                10000, Font.decode("Arial-BOLD-50"), true, true, false);
        return activity;
    }
    
}
