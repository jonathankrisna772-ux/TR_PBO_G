package main;

import view.login_mahasiswa;

public class main {
    public static void main(String[] args) {
        // Optional: Make the window look like Windows/Mac instead of old Java
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // START THE APP
        java.awt.EventQueue.invokeLater(() -> {
            new login_mahasiswa().setVisible(true);
        });
    } 
}
