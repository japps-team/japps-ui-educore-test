/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package japps.ui.educore;

import japps.ui.DesktopApp;
import japps.ui.component.Media;
import japps.ui.educore.component.InteractiveImageActivityPanel;
import japps.ui.educore.object.Activity;
import japps.ui.educore.object.Const;
import japps.ui.educore.object.Learning;
import japps.ui.util.Util;
import java.nio.file.Paths;
import java.util.Properties;

/**
 *
 * @author Williams Lopez - JApps
 */
public class InteractiveImageActivityExample {
    
    public static void main(String[] args) {
        DesktopApp.init("test", new String[]{"reconfigure"});
        InteractiveImageActivityPanel panel = new InteractiveImageActivityPanel();
        Learning learning = new Learning("educore", new Properties());
        panel.setActivity(addInteractiveImageActivity(learning));
        DesktopApp.start(panel);
    }
    
    
    public static Activity addInteractiveImageActivity(Learning learning){
        Activity activity = learning.addNewActivity();
        
        Const.COMMON.activity(activity, "Actividad de imagen interactiva",null, "Haz finalizado la actividad de imagen interactiva", null, true);
        Const.INTERACTIVE_IMAGE.activity(activity, Paths.get("res/activities/test/media/i3.jpg"));
        
        
        Const.INTERACTIVE_IMAGE.option(activity.addNewOption(), "Cabeza","Esta es la cabeza", Paths.get("res/activities/test/media/cabeza.jpg"), Media.IMAGE, true,  5, 20);
        Const.INTERACTIVE_IMAGE.option(activity.addNewOption(), "Brazo","Este es el brazo izquierdo", Paths.get("res/activities/test/media/brazo.jpg"), Media.IMAGE, true,   15, 12);
        Const.INTERACTIVE_IMAGE.option(activity.addNewOption(), "Brazo","Este es el brazo derecho", Paths.get("res/activities/test/media/brazo.jpg"), Media.IMAGE, true,   15, 27);
        Const.INTERACTIVE_IMAGE.option(activity.addNewOption(), "Pierna","Esta es la pierna izquierda", Paths.get("res/activities/test/media/pierna.jpg"), Media.IMAGE, true,  30, 16);
        Const.INTERACTIVE_IMAGE.option(activity.addNewOption(), "Pierna","Pierna derecha", Paths.get("res/activities/test/media/pierna.jpg"), Media.IMAGE, true,  30, 23);

        return activity;
    }
    
}
