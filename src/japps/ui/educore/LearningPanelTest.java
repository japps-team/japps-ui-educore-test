/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package japps.ui.educore;

import japps.ui.DesktopApp;
import japps.ui.educore.component.LearningPanel;
import japps.ui.educore.object.Const;
import japps.ui.educore.object.Learning;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;


/**
 *
 * @author Williams Lopez - JApps
 */
public class LearningPanelTest {
    
    public static void main(String[] args) throws Exception{
        DesktopApp.init("educore", new String[]{"reconfigure"});
        LearningPanel panel = new LearningPanel();
        
        Properties properties = new Properties();
        //properties.load(Files.newInputStream(Paths.get("learnings/test/learning.properties")));
        //Creating the learning data
        
        Learning learning = new Learning("test", properties);
        
        Const.LEARNING.set(learning, "Learning test", "Esta es una leccion de prueba", "Ha finalizado la leccion", 
                Paths.get("learnings/test/media/i2.jpg"), true,"Testing");
        
        InputTextPanelTest.addInputTextActivity(learning);
        DndActivityExample.addDndActivity(learning);
        InteractiveImageActivityExample.addInteractiveImageActivity(learning);
        ChooseActivityExample.addChooseActivity(learning);
        ConnectActivityExample.addConnectActivity(learning);
        MemoryActivityExample.addMemoryActivity(learning);
        ReadActivityExample.addReadActivity(learning);
        
        
        
        panel.setLearning(learning);
        
        panel.start();

        DesktopApp.start(panel);
        
        
       //properties.store(Files.newOutputStream(Paths.get("learnings/test/learning.properties")), "Test learning");
        
    }
    
    
    
    
    
    
}
