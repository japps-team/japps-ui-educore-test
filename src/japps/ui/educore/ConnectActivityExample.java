/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package japps.ui.educore;

import japps.ui.DesktopApp;
import japps.ui.educore.component.ConnectActivityPanel;
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
public class ConnectActivityExample {
    
    public static void main(String[] args) {
        DesktopApp.init("test", args);
        ConnectActivityPanel panel = new ConnectActivityPanel();
        Properties properties = new Properties();
        Learning learning = new Learning("connect", properties);
        
        panel.setActivity(addConnectActivity(learning));
        
        SwingUtilities.invokeLater(()->{panel.start();});
        
        DesktopApp.start(panel);
    }
    
    
    public static Activity addConnectActivity(Learning learning){
        Activity activity = learning.addNewActivity();
        ActivityOption o1 = activity.addNewOption();
        ActivityOption o2 = activity.addNewOption();
        ActivityOption o3 = activity.addNewOption();
        ActivityOption o4 = activity.addNewOption();
        ActivityOption o5 = activity.addNewOption();
        ActivityOption o6 = activity.addNewOption();
        ActivityOption o7 = activity.addNewOption();
        ActivityOption o8 = activity.addNewOption();
        
        Const.COMMON.activity(activity, "Connect activity panel", "¡Felicidades! habeis completado la actividad de conexión", Paths.get("res/activities/test/media/great.png"), true);
        Const.CONNECT.activity(activity, 300, 150);
        Const.CONNECT.option(o1, Paths.get("res/activities/test/media/1.jpg"), "Texto opción 1", true, o5.getId());
        Const.CONNECT.option(o2, Paths.get("res/activities/test/media/2.jpg"), "Texto opción 2", true, o6.getId());
        Const.CONNECT.option(o3, Paths.get("res/activities/test/media/3.jpg"), "Texto opción 3", true, o7.getId());
        Const.CONNECT.option(o4, Paths.get("res/activities/test/media/4.jpg"), "Texto opción 4", true, o8.getId());
        Const.CONNECT.option(o5, Paths.get("res/activities/test/media/1.jpg"), "Texto opción 1", true, null);
        Const.CONNECT.option(o6, Paths.get("res/activities/test/media/2.jpg"), "Texto opción 2", true, null);
        Const.CONNECT.option(o7, Paths.get("res/activities/test/media/3.jpg"), "Texto opción 3", true, null);
        Const.CONNECT.option(o8, Paths.get("res/activities/test/media/4.jpg"), "Texto opción 4", true, null);
        return activity;
    }
    
}
