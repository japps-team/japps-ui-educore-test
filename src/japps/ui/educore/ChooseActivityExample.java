/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package japps.ui.educore;

import japps.ui.DesktopApp;
import japps.ui.component.Media;
import japps.ui.educore.component.ActivityPanel;
import japps.ui.educore.component.ChooseActivityPanel;
import japps.ui.educore.component.ReadActivityPanel;
import japps.ui.educore.object.Activity;
import japps.ui.educore.object.ActivityOption;
import static japps.ui.educore.object.ActivityOption.*;
import japps.ui.educore.object.Const;
import japps.ui.educore.object.Learning;
import java.nio.file.Paths;
import java.util.Properties;
import javax.swing.SwingUtilities;

/**
 *
 * @author Williams Lopez - JApps
 */
public class ChooseActivityExample {
    
    public static void main(String[] args){
        DesktopApp.init("educore", new String[]{"reconfigure"});
        
        Properties props = new Properties();
        Learning learning = new Learning("choose",props);
        addChooseActivity(learning);        
        ActivityPanel panel = new ChooseActivityPanel();
        panel.setActivity(addChooseActivity(learning));
        SwingUtilities.invokeLater(()->{panel.start();});
        DesktopApp.start(panel);
    }
    
    
    public static Activity addChooseActivity(Learning learning){
        Activity activity = learning.addNewActivity();
        Const.COMMON.activity(activity, "Choose activity panel", "¡Felicidades! habeis completado la actividad de seleccion", 
                Paths.get("res/activities/test/media/great.png"), true);
        Const.CHOOSE.activity(activity,2, 2, 300, 250);
        
        ActivityOption option1 = activity.addNewOption();
        ActivityOption option2 = activity.addNewOption();
        ActivityOption option3 = activity.addNewOption();
        ActivityOption option4 = activity.addNewOption();
        
        Const.CHOOSE.option(option1, "This is the option number one", Paths.get("res/activities/test/media/1.jpg"), 
                Paths.get("res/activities/test/media/i2.jpg"), Media.IMAGE, null, false);

        Const.CHOOSE.option(option2, "This is the option number two", Paths.get("res/activities/test/media/2.jpg"), 
                Paths.get("res/activities/test/media/video.mp4"), Media.VIDEO, null, false);
        
        Const.CHOOSE.option(option3, "This is the option number three", Paths.get("res/activities/test/media/3.jpg"), 
                Paths.get("res/activities/test/media/m.mp3"), Media.SOUND, null, false);
        
        Const.CHOOSE.option(option4, "This is the option number four", Paths.get("res/activities/test/media/4.jpg"), 
                null, 0, "his is the text of option number four", true);
        return activity;
    }
    
}
