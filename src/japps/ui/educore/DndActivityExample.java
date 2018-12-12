/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package japps.ui.educore;

import japps.ui.DesktopApp;
import japps.ui.educore.component.ActivityPanel;
import japps.ui.educore.component.ChooseActivityPanel;
import japps.ui.educore.component.DnDActivityPanel;
import japps.ui.educore.object.Activity;
import japps.ui.educore.object.Const;
import japps.ui.educore.object.Learning;
import java.nio.file.Paths;
import java.util.Properties;
import javax.swing.SwingUtilities;

/**
 *
 * @author Williams Lopez - JApps
 */
public class DndActivityExample {
    
    public static void main(String[] args){
        DesktopApp.init("educore", new String[]{"reconfigure"});
        
        Properties props = new Properties();
        Learning learning = new Learning("dnd",props);       
        ActivityPanel panel = new DnDActivityPanel();
        panel.setActivity(addDndActivity(learning));
        SwingUtilities.invokeLater(()->{panel.start();});
        DesktopApp.start(panel);
    }
    
    
    public static Activity addDndActivity(Learning learning){
        Activity activity = learning.addNewActivity();
        
        Const.COMMON.activity(activity, "DragAndDrop activity panel", "¡Felicidades! habeis completado la actividad de DragAndDrop", 
                Paths.get("res/activities/test/media/great.png"), true);
        
        Const.DND.activity(activity, 2, 2,300,300);
        
        Const.DND.option(activity.addNewOption(), "Opcion 1", "Texto de la opcion 1", true, 0, 0, Paths.get("res/activities/test/media/1.jpg"));
        Const.DND.option(activity.addNewOption(), "Opcion 2", "Texto de la opcion 2", true, 0, 1, Paths.get("res/activities/test/media/2.jpg"));
        Const.DND.option(activity.addNewOption(), "Opcion 3", "Texto de la opcion 3", true, 1, 0, Paths.get("res/activities/test/media/3.jpg"));
        Const.DND.option(activity.addNewOption(), "Opcion 4", "Texto de la opcion 4", true, 1, 1, Paths.get("res/activities/test/media/4.jpg"));
        
        return activity;
    }
}
