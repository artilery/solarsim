
package com.innoprenez.apps.solarsyssim.view;


/**
 *
 * @author zinhle
 */
public class AddBodyDialog{} /*extends javax.swing.JDialog {
    private ArrayList<CelestialBody> bodies;
    private CelestialBody body;
    
    private static final int PLANET=0;
    private static final int STAR=1;
    private static final int MOON=2;
    private static final int COMET=3;
    
    public AddBodyDialog(java.awt.Frame parent, boolean modal,ArrayList<CelestialBody> bodies) {
        super(parent, modal);
        this.bodies=bodies;
        setTitle("Create Celestial Body");
        initComponents();
        parentCombo.setModel(new DefaultComboBoxModel(this.bodies.toArray()));
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodyTypeLabel = new javax.swing.JLabel();
        celestialBodyCombo = new javax.swing.JComboBox();
        bodyNameLabel = new javax.swing.JLabel();
        celestialBodyNameField = new javax.swing.JTextField();
        bodyParentLabel = new javax.swing.JLabel();
        parentCombo = new javax.swing.JComboBox();
        orbitalDistanceLabel = new javax.swing.JLabel();
        orbitalDistanceField = new javax.swing.JTextField();
        doneButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bodyTypeLabel.setText("Select Celestial Body Type:");

        celestialBodyCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Planet", "Star", "Moon", "Comet" }));

        bodyNameLabel.setText("Celestial Body Name:");

        bodyParentLabel.setText("Celestial Body Parent:");

        parentCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));

        orbitalDistanceLabel.setText("Orbital distance:");

        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bodyTypeLabel)
                    .addComponent(bodyNameLabel)
                    .addComponent(bodyParentLabel)
                    .addComponent(orbitalDistanceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(celestialBodyCombo, 0, 194, Short.MAX_VALUE)
                    .addComponent(celestialBodyNameField)
                    .addComponent(parentCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orbitalDistanceField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(doneButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bodyTypeLabel)
                    .addComponent(celestialBodyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bodyNameLabel)
                    .addComponent(celestialBodyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bodyParentLabel)
                    .addComponent(parentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orbitalDistanceLabel)
                    .addComponent(orbitalDistanceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doneButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        int bodyType=celestialBodyCombo.getSelectedIndex();
        int parentIndex=0;
        switch(bodyType){
            case PLANET:
                body=new Planet();
                body.setName(celestialBodyNameField.getText());
                body.setOrbitDistance(Double.parseDouble(orbitalDistanceField.getText()));
                body.move(1);
                body.setSpeed(0.01);
                parentIndex=parentCombo.getSelectedIndex();
                body.setParent(bodies.get(parentIndex));
                break;
            case STAR:
                body=new Star();
                body.setName(celestialBodyNameField.getText());
                body.setOrbitDistance(Double.parseDouble(orbitalDistanceField.getText()));
                body.move(1);
                body.setSpeed(0.01);
                parentIndex=parentCombo.getSelectedIndex();
                body.setParent(bodies.get(parentIndex));
                break;
            case MOON:
                body=new Moon();
                body.setName(celestialBodyNameField.getText());
                body.setOrbitDistance(Double.parseDouble(orbitalDistanceField.getText()));
                body.move(1);
                body.setSpeed(0.05);
                parentIndex=parentCombo.getSelectedIndex();
                body.setParent(bodies.get(parentIndex));
                break;
            case COMET:
                body=new Comet();
                body.setName(celestialBodyNameField.getText());
                body.setOrbitDistance(Double.parseDouble(orbitalDistanceField.getText()));
                body.move(1);
                body.setSpeed(0.03);
                parentIndex=parentCombo.getSelectedIndex();
                body.setParent(bodies.get(parentIndex));
                break;
        }
        bodies.add(body);
        dispose();
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        body=null;
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed
    public CelestialBody getCelestialBody(){
        return body;
    }*/
   
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AddBodyDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AddBodyDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AddBodyDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AddBodyDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                AddBodyDialog dialog = new AddBodyDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
   /* private javax.swing.JLabel bodyNameLabel;
    private javax.swing.JLabel bodyParentLabel;
    private javax.swing.JLabel bodyTypeLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox celestialBodyCombo;
    private javax.swing.JTextField celestialBodyNameField;
    private javax.swing.JButton doneButton;
    private javax.swing.JTextField orbitalDistanceField;
    private javax.swing.JLabel orbitalDistanceLabel;
    private javax.swing.JComboBox parentCombo;*/
    // End of variables declaration//GEN-END:variables//
//}
