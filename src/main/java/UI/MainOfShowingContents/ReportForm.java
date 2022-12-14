/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.MainOfShowingContents;
import Presenter.GeneralPresenter;
import UI.UserdataRelated.ProfilePage;
import entities.*;
import base.*;

import java.util.ArrayList;

/**
 *
 * @author zhaoxiling
 */
public class ReportForm extends javax.swing.JFrame {
    private final User user;
    private final User viewUser;
    private Report viewReport;
    private final Course course;




    /**
     * Creates new form ReportForm
     */
    public ReportForm(User user, User viewUser, Course course) {
        this.user = user;
        this.viewUser = viewUser;
        this.course = course;
        initComponents();
    }


    private void initComponents() {

        javax.swing.JPanel jPanel7 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        contentLabel = new javax.swing.JLabel();
        javax.swing.JButton resolveButton = new javax.swing.JButton();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        jList2 = new javax.swing.JList();
        // Variables declaration - do not modify
        javax.swing.JButton backButton = new javax.swing.JButton();
        typeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Report Description"));

        jLabel8.setText("Report on:");

        titleLabel.setText("Report Type");

        contentLabel.setText("Report Content");

        resolveButton.setText("resolve this report");
        resolveButton.addActionListener(this::resolveButtonActionPerformed);

        jLabel2.setText("Report Content:");
        typeLabel.setText("Type");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(resolveButton)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addComponent(titleLabel)
                                                                .addGap(136, 136, 136)
                                                                .addComponent(typeLabel))
                                                        .addComponent(contentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(titleLabel)
                                        .addComponent(typeLabel))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(contentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(resolveButton)
                                .addContainerGap(39, Short.MAX_VALUE))
        );

        jList2.setBorder(javax.swing.BorderFactory.createTitledBorder("List of All Reports"));
        jList2.setModel(new javax.swing.AbstractListModel() {
            final int size = Main.reportController.getAllReport().size();
            final String[] strings = getReportArray(size);
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });

        backButton.setText("Back to Profile Page");
        backButton.addActionListener(this::backButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(backButton)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jList2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(33, Short.MAX_VALUE)
                                .addComponent(backButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jList2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41))
        );

        pack();
    }
    private void resolveButtonActionPerformed(java.awt.event.ActionEvent evt) {
       if(this.viewReport==null){
           GeneralPresenter.showNotSelectError("Report");
       }else{
        Main.reportController.removeAReport(viewReport);
        GeneralPresenter.showSuccessMessage("Report resolution");
        ReportForm reportForm = new ReportForm(this.user, this.viewUser, this.course);
        reportForm.setVisible(true);
        this.setVisible(false);
        }
    }

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {
        int chosenReportIndex = jList2.getSelectedIndex();
        if (chosenReportIndex == - 1){
            GeneralPresenter.showNotSelectError("Report");
        }
        else {
            ArrayList<Report> reports = Main.reportController.getAllReport();
            Report selectReport = reports.get(chosenReportIndex);
            this.viewReport = selectReport;
            changePanel(selectReport);
        }
    }

    private void changePanel(Report report){
        titleLabel.setText(report.getAttachedTo());
        typeLabel.setText(report.getReportType());
        contentLabel.setText("<html>"+report.getContent()+"</html>");
    }


    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ProfilePage profilePage = new ProfilePage(this.user,this.viewUser);
        profilePage.setVisible(true);
        this.setVisible(false);
    }

    private String[] getReportArray(int reportSize){
        String[] comments = new String[reportSize];
        for(int i = 0; i < reportSize; i ++){
            comments[i] = "Report " + i;
        }
        return comments;
    }

    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel contentLabel;
    private javax.swing.JList jList2;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration
}
