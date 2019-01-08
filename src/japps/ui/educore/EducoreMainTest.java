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
import japps.ui.util.FileUtils;
import japps.ui.util.Resources;
import japps.ui.util.Util;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 *
 * @author Williams Lopez - JApps
 */
public class EducoreMainTest {
    
    public static void main(String[] args) throws IOException{
        /*
        DesktopApp.init("educore", new String[]{"reconfigure"});
        
        createLearningTest("test1", "Learning Test 1", "Testing 1", Paths.get("learnings","test","media","geometric-figures","triangulo.png"));
        createLearningTest("test2", "Learning Test 2", "Testing 1", Paths.get("learnings","test","media","geometric-figures","cuadrado.png"));
        createLearningTest("test3", "Learning Test 3", "Testing 1", Paths.get("learnings","test","media","geometric-figures","circulo.png"));
        createLearningTest("test4", "Learning Test 4", "Testing 1", Paths.get("learnings","test","media","geometric-figures","rectangulo.png"));
        createLearningTest("test5", "Learning Test 5", "Testing 1", Paths.get("learnings","test","media","geometric-figures","circulo-2.png"));
        createLearningTest("test6", "Learning Test 6", "Testing 1", Paths.get("learnings","test","media","geometric-figures","cuadrado-2.jpg"));
        createLearningTest("test7", "Learning Test 7", "Testing 1", Paths.get("learnings","test","media","geometric-figures","rectangulo-2.png"));
        createLearningTest("test8", "Learning Test 8", "Testing 4", Paths.get("learnings","test","media","geometric-figures","triangulo-2.jpg"));
        createLearningTest("test9", "Learning Test 9", "Testing 4", Paths.get("learnings","test","media","geometric-figures","triangulo.png"));
        
        FileUtils.copy(Paths.get("learnings").toAbsolutePath(), Resources.getUserAppPath());
        */
        EducoreMain.main(new String[]{"reconfigure"});
        
    }
    
    
    private static void createLearningTest(String name, String title, String topic, Path thumbnail) throws IOException{
        Properties properties = new Properties();        
        Learning learning = new Learning(name, properties);
        Const.LEARNING.set(learning, title, "Esta es una leccion de prueba", "Ha finalizado la leccion", 
                thumbnail, true,topic);
        InputTextPanelTest.addInputTextActivity(learning);
        DndActivityExample.addDndActivity(learning);
        InteractiveImageActivityExample.addInteractiveImageActivity(learning);
        ChooseActivityExample.addChooseActivity(learning);
        ConnectActivityExample.addConnectActivity(learning);
        MemoryActivityExample.addMemoryActivity(learning);
        ReadActivityExample.addReadActivity(learning);
        Path p = Files.createDirectories(Paths.get("learnings",name));
        properties.store(Files.newOutputStream(p.resolve("learning.properties")), "Test learning");
    }
    
}
