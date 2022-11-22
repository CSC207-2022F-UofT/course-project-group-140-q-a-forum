/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.PostingStuff;

import UI.MainOfShowingContents.CoursesForm;
import base.main;
import controllers.CourseController;
import controllers.PostControllers;
import entities.Course;
import entities.User;

import java.util.HashMap;

/**
 *
 * @author zhaoxiling
 */
public class MakeAPost extends javax.swing.JFrame {
    private final Course course;
    private final User user;
    private final PostControllers postControllers = main.postControllers;
    private final CourseController courseController = main.courseController;


    /**
     * Creates new form CommentsForm
     */
    public MakeAPost(Course course, User user) {
        this.course = course;
        this.user = user;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        titleText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contentTextA = new javax.swing.JTextArea();
        postButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        userButton = new javax.swing.JRadioButton();
        anoymousButton = new javax.swing.JRadioButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Post a Post"));

        jLabel1.setText("Title:");

        jLabel2.setText("Content of the post:");

        jLabel3.setText("Post the Post in:");

        nameLabel.setText("The course name");

        contentTextA.setColumns(20);
        contentTextA.setRows(5);
        jScrollPane1.setViewportView(contentTextA);

        postButton.setText("Post the post");
        postButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Post as: ");

        buttonGroup1.add(userButton);
        userButton.setText("User");
        userButton.setActionCommand("user");

        buttonGroup1.add(anoymousButton);
        anoymousButton.setText("Anonymous");
        anoymousButton.setActionCommand("anonymous");

        backButton.setText("Back to the post");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(nameLabel))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(userButton)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(anoymousButton))
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(postButton)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                                                                        .addComponent(backButton))
                                                                .addComponent(titleText, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))))
                                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(nameLabel))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(userButton)
                                        .addComponent(anoymousButton)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(postButton)
                                        .addComponent(backButton))
                                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void postButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        HashMap<String, String> PostInfo = new HashMap<String, String>();
        PostInfo.put("title", titleText.getText());
        PostInfo.put("text", contentTextA.getText());
        PostInfo.put("user", buttonGroup1.getSelection().getActionCommand());
        PostInfo.put("image", null);
        System.out.println(buttonGroup1.getSelection().getActionCommand());

    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Course[] courses = courseController.getAllCourses().toArray(new Course[0]);
        CoursesForm coursesForm = new CoursesForm(user, courses );
        coursesForm.setVisible(true);
        this.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(MakeAPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakeAPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakeAPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakeAPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Course course = new Course();
                User user = new User();
                new MakeAPost(course, user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JRadioButton anoymousButton;
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea contentTextA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton postButton;
    private javax.swing.JTextField titleText;
    private javax.swing.JRadioButton userButton;
    // End of variables declaration
}
