/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mm_messagepasser;

import javax.swing.JFrame;
import org.micromanager.MenuPlugin;
import org.micromanager.Studio;
import org.scijava.plugin.Plugin;
import org.scijava.plugin.SciJavaPlugin;

/**
 *
 * @author Sunil
 */

@Plugin(type = MenuPlugin.class)
public class msg_passer implements MenuPlugin, org.scijava.plugin.SciJavaPlugin{
    //Name for the plugin
    public static final String menuName = "Message passing tester for MM2";
    private Studio gui_;    
    public static JFrame frame_;
    
    @Override
    public String getSubMenu() {
        //Determines which plugin submenu this ends up in
        return("Acquisition Tools");
    }

    @Override
    public void onPluginSelected() {
        frame_ = new msg_passer_hostframe(gui_);
        frame_.setVisible(true);
    }

    @Override
    public void setContext(Studio studio) {
        gui_ = studio;
    }

    @Override
    public String getName() {
        return "Message passing test for MM2";
    }

    @Override
    public String getHelpText() {
        return("There is no help... o_o");
    }

    @Override
    public String getVersion() {
        return("0.0.1");
    }

    @Override
    public String getCopyright() {
        return("Copyright Imperial College London [2020]");
    }
    
}
