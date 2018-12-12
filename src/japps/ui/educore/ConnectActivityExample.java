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
import java.nio.file.Path;
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

        
        Const.COMMON.activity(activity, "Figuras geométricas (Actividad de Conexión)","Una las imagenes de arriba con su correspondiente de abajo", "¡Felicidades! habeis completado la actividad de conexión de figuras geométricas", Paths.get("res/activities/test/media/great.png"), true);
        Const.CONNECT.activity(activity, 150, 150,true);
        
        Path dir = Paths.get("res/activities/test/media/geometric-figures");
        
        ActivityOption  o1 = activity.addNewOption(),
                        o2 = activity.addNewOption(),
                        o3 = activity.addNewOption(),
                        o4 = activity.addNewOption(),
                        o5 = activity.addNewOption(),
                        o6 = activity.addNewOption(),
                        o7 = activity.addNewOption(),
                        o8 = activity.addNewOption();
        
        Const.CONNECT.option(o1, dir.resolve("triangulo.png"),   "El triángulo es una figura geométrica de tres lados", true, o5.getId());
        Const.CONNECT.option(o2, dir.resolve("cuadrado.png"),    "El cuadrado es una figura geométrica de cuatro lados de igual tamaño", true, o6.getId());
        Const.CONNECT.option(o3, dir.resolve("circulo.png"),     "Un círculo es el lugar geométrico de los puntos del plano cuya distancia a otro punto fijo, llamado centro, es menor o igual que una cantidad constante, llamada radio.", true, o7.getId());
        Const.CONNECT.option(o4, dir.resolve("rectangulo.png"),  "Un rectángulo es un paralelogramo cuyos cuatro lados forman ángulos rectos entre sí. Los lados opuestos tienen la misma longitud.", true, o8.getId());
        Const.CONNECT.option(o5, dir.resolve("triangulo-2.jpg"), "Texto 1", true, null);
        Const.CONNECT.option(o6, dir.resolve("cuadrado-2.jpg"),  "texto 2", true, null);
        Const.CONNECT.option(o7, dir.resolve("circulo-2.png"),   "texto 3", true, null);
        Const.CONNECT.option(o8, dir.resolve("rectangulo-2.png"),"texto 4   ", true, null);
        return activity;
    }
    
}
