/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.uemg.autopecas.view;

/**
 *
 * @author gustavo
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopPanePrincipal = new javax.swing.JDesktopPane();
        MenuBarPrincipal = new javax.swing.JMenuBar();
        MenuCadastro = new javax.swing.JMenu();
        MenuItemCliente = new javax.swing.JMenuItem();
        MenuPedido = new javax.swing.JMenu();
        MenuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GRACH Sistemas");

        DesktopPanePrincipal.setBackground(new java.awt.Color(180, 231, 211));

        javax.swing.GroupLayout DesktopPanePrincipalLayout = new javax.swing.GroupLayout(DesktopPanePrincipal);
        DesktopPanePrincipal.setLayout(DesktopPanePrincipalLayout);
        DesktopPanePrincipalLayout.setHorizontalGroup(
            DesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
        );
        DesktopPanePrincipalLayout.setVerticalGroup(
            DesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        MenuBarPrincipal.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        MenuCadastro.setText("Cadastro");
        MenuCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroActionPerformed(evt);
            }
        });

        MenuItemCliente.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        MenuItemCliente.setText("Cliente");
        MenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemClienteActionPerformed(evt);
            }
        });
        MenuCadastro.add(MenuItemCliente);

        MenuBarPrincipal.add(MenuCadastro);

        MenuPedido.setText("Pedido");
        MenuBarPrincipal.add(MenuPedido);

        MenuSobre.setText("Sobre");
        MenuBarPrincipal.add(MenuSobre);

        setJMenuBar(MenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPanePrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPanePrincipal)
        );

        setSize(new java.awt.Dimension(800, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemClienteActionPerformed
        // TODO add your handling code here:
        ClienteView cliente = new ClienteView();
        DesktopPanePrincipal.add(cliente);
        cliente.setVisible(true);
    }//GEN-LAST:event_MenuItemClienteActionPerformed

    private void MenuCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuCadastroActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPanePrincipal;
    private javax.swing.JMenuBar MenuBarPrincipal;
    private javax.swing.JMenu MenuCadastro;
    private javax.swing.JMenuItem MenuItemCliente;
    private javax.swing.JMenu MenuPedido;
    private javax.swing.JMenu MenuSobre;
    // End of variables declaration//GEN-END:variables
}
