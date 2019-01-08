/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package japps.ui.educore;

import japps.ui.DesktopApp;
import japps.ui.educore.component.MemoryActivityPanel;
import japps.ui.educore.object.Activity;
import japps.ui.educore.object.ActivityOption;
import japps.ui.educore.object.Const;
import japps.ui.educore.object.Learning;
import java.nio.file.Paths;
import java.util.Properties;
import javax.swing.SwingUtilities;

/**
 *
 * @author Williams Lopez - JApps
 */
public class MemoryActivityExample {
    
    public static void main(String[] args) {
        DesktopApp.init("test", args);
        MemoryActivityPanel panel = new MemoryActivityPanel();
        Properties properties = new Properties();
        Learning learning = new Learning("memory", properties);
        

        panel.setActivity(addMemoryActivity(learning));
        SwingUtilities.invokeLater(()->{panel.start();});
        DesktopApp.start(panel);   
    }
    
    public static Activity addMemoryActivity(Learning learning){
        Activity activity = learning.addNewActivity();
        ActivityOption o1 = activity.addNewOption();
        ActivityOption o2 = activity.addNewOption();
        ActivityOption o3 = activity.addNewOption();
        ActivityOption o4 = activity.addNewOption();
        
        Const.COMMON.activity(activity, "Memory activity panel",null, "¡Felicidades! habeis completado la actividad de memoria", 
                Paths.get("learnings/test/media/great.png"), true,false);
        Const.MEMORY.activity(activity, 2, 4, 300, 300, Paths.get("learnings/test/media/i2.jpg"));
        
        Const.MEMORY.option(o1, Paths.get("learnings/test/media/1.jpg"), "Texto opción 1", true);
        Const.MEMORY.option(o2, Paths.get("learnings/test/media/2.jpg"), "Texto opción 2", true);
        Const.MEMORY.option(o3, Paths.get("learnings/test/media/3.jpg"), "Texto opción 3", true);
        Const.MEMORY.option(o4, Paths.get("learnings/test/media/4.jpg"), "Texto opción 4", true);
        return activity;
    }
    
}
