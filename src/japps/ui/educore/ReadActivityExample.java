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
        
        Const.COMMON.activity(activity, "Read Activity Example",null, "Felicidades has terminado la actividad de lectura", null, true,false);
        Const.READ.activity(activity);
        
        Const.READ.option(activity.addNewOption(), null, 0, 
                            "<font color='red'>Actividad de lectura</font>.\n<br/><br/>" +
                            "La actividad de lectura está diseñada para que el usuario lea, escuche y vea un contenido en secuencia, ahora está viendo una pantalla en la que no hay contenido multimedia, únicamente hay texto y se configuró para que EDUCORE lea dicho texto" ,
                20000, Font.decode("Arial-BOLD-50"), true, true, false);
        
        Const.READ.option(activity.addNewOption(), Paths.get("learnings/test/media/i2.jpg"), 
                Media.IMAGE, "La actividad de lectura permite agregar una secuencia de contenido multimedia que puede ser video, sonido, imágenes o texto, de forma intercalada. En este momento se está mostrando una imagen y texto, a continuación se mostrará un video.", 
                20000, Font.decode("Arial-BOLD-35"), true, true, true);
        
        Const.READ.option(activity.addNewOption(), Paths.get("learnings/test/media/video.mp4"), 
                Media.VIDEO, null, 
                10000, Font.decode("Arial-BOLD-50"), true, false, true);
        
        Const.READ.option(activity.addNewOption(), Paths.get("learnings/test/media/m.mp3"), 
                Media.SOUND, "Este es un ejemplo de un sonido en la actividad, usted puede ver el avance de la actividad en la parte superior.", 
                15000, Font.decode("Arial-BOLD-50"), true, true, true);
        
        
        return activity;
    }
    
}
