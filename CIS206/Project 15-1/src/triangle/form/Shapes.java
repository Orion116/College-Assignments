/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangle.form;

import Jcomp.ui.GUITextField;
import java.awt.*;
import java.text.NumberFormat;
import triangle.cal.LongestSide;

/**
 *
 * @author Joshw
 */
public class Shapes extends javax.swing.JFrame
{

    /**
     * Creates new form Shapes
     */
    public Shapes()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        lblSideA = new javax.swing.JLabel();
        txtSideA = new javax.swing.JTextField();
        txtSideB = new javax.swing.JTextField();
        lblSideB = new javax.swing.JLabel();
        lblSideC = new javax.swing.JLabel();
        txtSideC = new javax.swing.JTextField();
        btnCalculate = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shapes");
        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(51, 51, 51));

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 204)));

        lblSideA.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblSideA.setText("Side A:");

        txtSideA.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtSideA.setToolTipText("Enter a Double");

        txtSideB.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtSideB.setToolTipText("Enter a Double");

        lblSideB.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblSideB.setText("Side B:");

        lblSideC.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblSideC.setText("Side C:");

        txtSideC.setEditable(false);
        txtSideC.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtSideC.setFocusable(false);

        btnCalculate.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnCalculate.setText("Calculate");
        btnCalculate.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCalculateActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCalculate)
                        .addGap(21, 21, 21)
                        .addComponent(btnExit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSideA)
                            .addComponent(lblSideB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSideA)
                            .addComponent(txtSideB, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSideC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSideC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSideA)
                    .addComponent(txtSideA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSideB)
                    .addComponent(txtSideB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSideC)
                    .addComponent(txtSideC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalculate)
                    .addComponent(btnExit))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCalculateActionPerformed
    {//GEN-HEADEREND:event_btnCalculateActionPerformed
        calculate();
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnExitActionPerformed
    {//GEN-HEADEREND:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main( String args[] )
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Shapes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Shapes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Shapes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Shapes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                Shapes shape = new Shapes();
                shape.setVisible(true);
                shape.setLocationRelativeTo(null);
                shape.setBackground(Color.DARK_GRAY);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnExit;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSideA;
    private javax.swing.JLabel lblSideB;
    private javax.swing.JLabel lblSideC;
    private javax.swing.JTextField txtSideA;
    private javax.swing.JTextField txtSideB;
    private javax.swing.JTextField txtSideC;
    // End of variables declaration//GEN-END:variables

    private void calculate()
    {
        final int COLUMNS = 10;
        String toolTips = "Enter a Double";
        
        GUITextField GUIsideA = new GUITextField(txtSideA, COLUMNS,
                                                 true, toolTips);
        GUITextField GUIsideB = new GUITextField(txtSideB, COLUMNS,
                                                 true, toolTips);
        
        double sideA = GUIsideA.getTextField(this.txtSideA, "Field \"A\" Must");
        double sideB = GUIsideB.getTextField(this.txtSideB, "Field \"B\" Must");
        double sideC = LongestSide.calculateLongestSide(sideA, sideB);
        
        NumberFormat number = NumberFormat.getNumberInstance();
        number.setMaximumFractionDigits(2);
        
        this.txtSideC.setText(number.format(sideC));
    }
}