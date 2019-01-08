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
import java.nio.file.Path;
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
        
        Const.COMMON.activity(activity, "Fases de la luna (Drag and drop activity)",
                "<html>Hola {name}.\n<br/>Coloca las fases de la luna en órden.\n<br/>"
                        + "Si aparece un punto rojo la posición es incorrecta.\n<br/>"
                        + "Si aparece uno verde la posición sí es la correcta.\n</html>", 
                "¡Felicidades {name}! habeis completado la actividad de fases de la luna", 
                Paths.get("learnings/test/media/great.png"), true,false);
        
        Const.DND.activity(activity, 2, 4,250,250);
        
        Path dir = Paths.get("learnings/test/media/luna/");
        

        Const.DND.option(activity.addNewOption(), "Luna nueva",           "Luna nueva",           true, 0, 0, dir.resolve("nueva.png"));
        Const.DND.option(activity.addNewOption(), "Luna nueva visible",   "Luna nueva visible",   true, 0, 1, dir.resolve("nueva-visible.png"));
        Const.DND.option(activity.addNewOption(), "Cuarto creciente",     "Cuarto creciente",     true, 0, 2, dir.resolve("cuarto-creciente.png"));
        Const.DND.option(activity.addNewOption(), "Gibosa creciente",     "Gibosa creciente",     true, 0, 3, dir.resolve("gibosa-creciente.png"));
        Const.DND.option(activity.addNewOption(), "Luna llena",           "Luna llena",           true, 1, 0, dir.resolve("llena.png"));
        Const.DND.option(activity.addNewOption(), "Luna gibosa menguante","Luna gibosa menguante",true, 1, 1, dir.resolve("gibosa-menguante.png"));
        Const.DND.option(activity.addNewOption(), "Cuarto menguante",     "Cuarto menguante",     true, 1, 2, dir.resolve("cuarto-menguante.png"));
        Const.DND.option(activity.addNewOption(), "Luna menguante",       "Luna menguante",       true, 1, 3, dir.resolve("menguante.png"));
        
        return activity;
    }
}
