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
import java.nio.file.Path;
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
        Const.COMMON.activity(activity, "Choose activity panel",null, "¡Felicidades! habeis completado la actividad de seleccion", 
                Paths.get("learnings/test/media/great.png"), true,true);
        Const.CHOOSE.activity(activity,2, 4, 150, 150,true);
                
        Path dir = Paths.get("learnings/test/media/traffic-signals");
        Const.CHOOSE.option(activity.addNewOption(), "Curva (with image)", dir.resolve("signal-curva.png"), dir.resolve("curva.jpg"), Media.IMAGE, null, false);
        Const.CHOOSE.option(activity.addNewOption(), "Cruce (with image)", dir.resolve("signal-cruce.png"), dir.resolve("cruce.jpg"), Media.IMAGE, null, false);
        Const.CHOOSE.option(activity.addNewOption(), "Camino sinuoso (with video)", dir.resolve("signal-curves.png"),dir.resolve("curves.mp4"), Media.VIDEO, null, false); 
        Const.CHOOSE.option(activity.addNewOption(), "Trabajadores en el camino (with sound)", dir.resolve("signal-trabajadores.png"), dir.resolve("trabajo.mp3"), Media.SOUND, null,false);
        
        Const.CHOOSE.option(activity.addNewOption(), "Paso peatonal (with text speech)", dir.resolve("signal5.png"),       null, 0, "Indica un camino con constante paso peatonal o un cruce peatonal en específico.", true);
        Const.CHOOSE.option(activity.addNewOption(), "Zona de derrumbes (with text speech)", dir.resolve("signal6.png"),   null, 0, "Advierte sobre una zona en la cual pueden ocurrir derrumbes.", true);
        Const.CHOOSE.option(activity.addNewOption(), "Ganado  (with text speech)", dir.resolve("signal7.png"),             null, 0, "Indica la posibilidad de encontrar ganado en el camino.", true);
        Const.CHOOSE.option(activity.addNewOption(), "Pendiente peligrosa (with text speech)", dir.resolve("signal8.png"), null, 0, "Advierte sobre un camino en descenso en el cual habrá que frenar constantemente.", true);
        
        return activity;
    }
    
}
