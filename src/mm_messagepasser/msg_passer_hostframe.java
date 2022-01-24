/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mm_messagepasser;

import com.google.common.eventbus.Subscribe;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mmcorej.CMMCore;
import mmcorej.DeviceDetectionStatus;
import org.micromanager.Studio;
import org.micromanager.events.PropertiesChangedEvent;
import org.micromanager.display.DisplayWindow;
import org.micromanager.events.ExposureChangedEvent;
import org.micromanager.events.PropertyChangedEvent;
import org.micromanager.events.PropertiesChangedEvent;
import org.micromanager.events.XYStagePositionChangedEvent;

/**
 *
 * @author Sunil
 */
public class msg_passer_hostframe extends javax.swing.JFrame {
    static msg_passer_hostframe frame_;
    public static Studio gui_ = null;
    public CMMCore core_ = null;
    /**
     * Creates new form msg_passer_hostframe
     */
    public msg_passer_hostframe(Studio gui) {
        frame_ = this;
        gui_ = gui;
        core_ = gui_.getCMMCore();
        
        gui_.events().registerForEvents(this);
        frame_.setTitle("Message passing test for Micro-manager 2");  
        frame_.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame_.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (true == confirmQuit()){
                    frame_.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                } else {
                    frame_.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });  
        
        initComponents();
        
        msg_display_panel1.set_parent(frame_);
        msg_set_panel1.set_parent(frame_);        
        msg_set_panel1.update_dev_list();        
    }
    
    public String dp_json_escaper(String input){
        String output = input.replace(",", "x2c");
        return output;
        //return input;
    }
    
    public String dp_json_restorer(String input){
        String output = input.replace("\\x2c",",");
        return output;
    }    

    @Subscribe
    public void prop_change(PropertyChangedEvent event){
        if(event.getProperty().equalsIgnoreCase("Messager_dev")){
            msg_display_panel1.setmsg(event.getValue());
        }
    }
    
    private boolean confirmQuit() {
        int n = JOptionPane.showConfirmDialog(frame_,
                "Quit: are you sure?", "Quit", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            return true;
        }
            return false;
    }        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msg_set_panel1 = new mm_messagepasser.msg_set_panel();
        msg_display_panel1 = new mm_messagepasser.msg_display_panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Message that was set:");

        jLabel2.setText("Message you want to send:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(msg_display_panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(msg_set_panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msg_display_panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msg_set_panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(msg_passer_hostframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(msg_passer_hostframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(msg_passer_hostframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(msg_passer_hostframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new msg_passer_hostframe(gui_).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private mm_messagepasser.msg_display_panel msg_display_panel1;
    private mm_messagepasser.msg_set_panel msg_set_panel1;
    // End of variables declaration//GEN-END:variables
}
