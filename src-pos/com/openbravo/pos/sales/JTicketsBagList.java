//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2008 Open Sistemas de Información Internet, S.L.
//    http://www.opensistemas.com
//    http://sourceforge.net/projects/openbravopos
//
//    This program is free software; you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation; either version 2 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program; if not, write to the Free Software
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

package com.openbravo.pos.sales;


import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.ticket.TicketInfo;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author  Luis Ig. Bacas Riveiro	lbacas@opensistemas.com
 * @author  Pablo J. Urbano Santos	purbano@opensistemas.com
 */
public class JTicketsBagList extends javax.swing.JDialog {
    
    private TicketInfo m_sDialogTicket;
    
    /** Creates new form JTicketsBagList */
    private JTicketsBagList(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }
    /** Creates new form JTicketsBagList */
    private JTicketsBagList(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
    }  
    
    public TicketInfo showTicketsList(java.util.List<TicketInfo> atickets) {
        
        for (int i = 0; i < atickets.size(); i++) {
            m_jtickets.add(new JButtonTicket(atickets.get(i)));                
        }  
     
        m_sDialogTicket = null;
        setVisible(true);
        return m_sDialogTicket;
    }  
        
    public static JTicketsBagList newJDialog(JTicketsBag ticketsbag) {
        
        Window window = getWindow(ticketsbag);
        JTicketsBagList mydialog;
        if (window instanceof Frame) { 
            mydialog = new JTicketsBagList((Frame) window, true);
        } else {
            mydialog = new JTicketsBagList((Dialog) window, true);
        } 
        
        mydialog.initComponents();
        
        mydialog.jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(35, 35));
        
        return mydialog;
    }
    
    private static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window) parent;
        } else {
            return getWindow(parent.getParent());
        }
    }  

    
    
    private class JButtonTicket extends JButton {    
        private TicketInfo m_Ticket;
        
        public JButtonTicket(TicketInfo ticket){
            
            super();
            
            m_Ticket = ticket;
            setFocusPainted(false);
            setFocusable(false);
            setRequestFocusEnabled(false);
            setMargin(new Insets(8, 14, 8, 14));
            addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    
                    // Selecciono el ticket
                    m_sDialogTicket = m_Ticket;
   
                    // y oculto la ventana
                    JTicketsBagList.this.setVisible(false);
                }
            });
            
            setText(String.format("%1$-10s", ticket.getName()) + "       " + 
                    Formats.TIME.formatValue(ticket.getDate()) + "       " + 
                    String.format("%10s",ticket.printTotal()) );
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        m_jtickets = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        m_jButtonCancel = new javax.swing.JButton();

        setTitle(AppLocal.getIntString("caption.tickets")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        m_jtickets.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        m_jtickets.setLayout(new java.awt.GridLayout(0, 1, 5, 5));
        jPanel2.add(m_jtickets, java.awt.BorderLayout.NORTH);

        jScrollPane1.setViewportView(jPanel2);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("pos_messages"); // NOI18N
        jLabel1.setText(bundle.getString("Label.90minutes")); // NOI18N
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        jPanel3.add(jPanel4);

        m_jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/button_cancel.png"))); // NOI18N
        m_jButtonCancel.setText(AppLocal.getIntString("Button.Close")); // NOI18N
        m_jButtonCancel.setFocusPainted(false);
        m_jButtonCancel.setFocusable(false);
        m_jButtonCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonCancel.setRequestFocusEnabled(false);
        m_jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonCancelActionPerformed(evt);
            }
        });
        jPanel3.add(m_jButtonCancel);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-418)/2, (screenSize.height-462)/2, 418, 462);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonCancelActionPerformed

        dispose();
        
    }//GEN-LAST:event_m_jButtonCancelActionPerformed
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton m_jButtonCancel;
    private javax.swing.JPanel m_jtickets;
    // End of variables declaration//GEN-END:variables
    
}
