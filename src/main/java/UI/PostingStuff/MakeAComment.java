/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.PostingStuff;

import Presenter.GeneralPresenter;
import UI.MainOfShowingContents.PostForm;
import base.main;
import controllers.CourseController;
import controllers.PostController;
import entities.Course;
import entities.Post;
import entities.User;

/**
 *
 * @author zhaoxiling
 */
public class MakeAComment extends javax.swing.JFrame {
    private final User user;
    private final Course course;

    private final Post post;
    private final CourseController courseController = main.courseController;
    private final PostController postController = main.postController;

    /**
     * Creates new form MakeAComment
     */
    public MakeAComment(User user, Course course, Post post) {
        this.user = user;
        this.course = course;
        this.post = post;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel commentLabel = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        contentTextA = new javax.swing.JTextArea();
        javax.swing.JButton commentButton = new javax.swing.JButton();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JRadioButton userButton = new javax.swing.JRadioButton();
        // Variables declaration - do not modify
        javax.swing.JRadioButton anonymousButton = new javax.swing.JRadioButton();
        javax.swing.JButton backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Make a comment"));

        jLabel2.setText("Content of the comment:");

        jLabel3.setText("Make the comment in :");

        commentLabel.setText("Post or comment");

        contentTextA.setColumns(20);
        contentTextA.setRows(5);
        jScrollPane1.setViewportView(contentTextA);

        commentButton.setText("Make the comment");
        commentButton.addActionListener(this::commentButtonActionPerformed);

        jLabel5.setText("Post as: ");

        userButton.setText("User");
        userButton.addActionListener(this::userButtonActionPerformed);

        anonymousButton.setText("Anonymous");
        anonymousButton.addActionListener(evt -> {
            anonymousButtonActionPerformed(evt);
        });

        backButton.setText("Back to the page");
        backButton.addActionListener(this::backButtonActionPerformed);

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
                                                .addComponent(commentLabel))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(userButton)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(anonymousButton))
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(commentButton)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                                                                        .addComponent(backButton))
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))))
                                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(commentLabel))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(userButton)
                                        .addComponent(anonymousButton)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(commentButton)
                                        .addComponent(backButton))
                                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(98, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void userButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void anonymousButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void commentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String content = contentTextA.getText();
        int result = postController.makeComment(post, user, content);
        if(result == 1){
            PostForm postForm = new PostForm(user, course);
            postForm.setVisible(true);
            this.setVisible(false);
            GeneralPresenter.showSuccessMessage("comment");
        }
        else {
            GeneralPresenter.showEmptyEntryError();
        }
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        PostForm postForm = new PostForm(user, course);
        postForm.setVisible(true);
        this.setVisible(false);
    }


    private javax.swing.JTextArea contentTextA;
    // End of variables declaration
}
