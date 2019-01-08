/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package japps.ui.educore;

import japps.ui.DesktopApp;
import japps.ui.educore.component.LearningPanel;
import japps.ui.educore.object.Activity;
import japps.ui.educore.object.ActivityOption;
import japps.ui.educore.object.Const;
import japps.ui.educore.object.Learning;
import japps.ui.util.Resources;
import japps.ui.util.Util;
import java.awt.Font;
import java.nio.file.Paths;
import java.util.Properties;


/**
 *
 * @author Williams Lopez - JApps
 */
public class InputTextPanelTest {
    
    public static void main(String[] args) throws Exception{
        DesktopApp.init("educore", new String[]{});
        LearningPanel panel = new LearningPanel();
        
        Properties properties = new Properties();
        //properties.load(Files.newInputStream(Paths.get("learnings/test/learning.properties")));
        //Creating the learning data
        
        Learning learning = new Learning("test", properties);
        
        Const.LEARNING.set(learning, "Learning test", "Esta es una leccion de prueba", "Ha finalizado la leccion", 
                Paths.get("learnings/test/media/i2.jpg"), true,"Testing");
        
       
        addInputTextActivity(learning);
        
        panel.setLearning(learning);
        
        panel.start();

        DesktopApp.start(panel);
        
        
       // properties.store(Files.newOutputStream(Paths.get("learnings/test/learning.properties")), "Test learning");
        
    }
    
    public static void addInputTextActivity(Learning learning){
         Activity a = learning.addNewActivity();
        Const.COMMON.activity(a, "Input text panel - activity", null, null, null, true,false);
        Const.INPUTTEXT.activity(a);
        Const.INPUTTEXT.option(a.addNewOption(), "Escribe tu nombre", "name", true,new Font("Arial", Font.PLAIN, 50));
        Const.INPUTTEXT.option(a.addNewOption(), "Como te sientes?", "feel", true, new Font("Arial", Font.PLAIN, 50));
    }
    
    
}
