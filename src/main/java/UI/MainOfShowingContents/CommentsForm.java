/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.MainOfShowingContents;

import Presenter.GeneralPresenter;
import UI.PostingStuff.MakeAComment;
import UI.PostingStuff.MakeAReport;
import base.main;
import controllers.CourseController;
import controllers.PostController;
import entities.Comment;
import entities.Course;
import entities.Post;
import entities.User;

/**
 *
 * @author zhaoxiling
 */
public class CommentsForm extends javax.swing.JFrame {
    private final User user;
    private final Course course;

    private final Post post;
    private Comment viewComment = null;
    private final CourseController courseController = main.courseController;
    private final PostController postController = main.postController;

    /**
     * Creates new form CommentsForm
     */
    public CommentsForm(User user, Course course, Post post) {
        this.user = user;
        this.course = course;
        this.post = post;
        initComponents();
    }

    private void initComponents() {

        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel showingPostTitleLabel = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        javax.swing.JButton gobackButton = new javax.swing.JButton();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel usernameLabel = new javax.swing.JLabel();
        javax.swing.JPanel jPanel18 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel27 = new javax.swing.JLabel();
        showingUserLabel16 = new javax.swing.JLabel();
        showContentLabel16 = new javax.swing.JLabel();
        javax.swing.JButton commentButton11 = new javax.swing.JButton();
        javax.swing.JLabel jLabel28 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Comment on:");

        showingPostTitleLabel.setText(post.getTopic());

        jList2.setBorder(javax.swing.BorderFactory.createTitledBorder("List of All Comments"));
        jList2.setModel(new javax.swing.AbstractListModel() {
           final int commentsSize  = postController.getAllCommentFromPost(post).size();
           final String[] strings = getCommentArray(commentsSize);

//            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }

        });
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
                                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                                        jList2MouseClicked();
                                    }
                                });
        jScrollPane1.setViewportView(jList2);

        gobackButton.setText("Back to Post");
        gobackButton.addActionListener(this::gobackButtonActionPerformed);


        jLabel3.setText("User:");

        usernameLabel.setText(user.getUsername());

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Comments Description"));

        jLabel27.setText("Author:");

        showingUserLabel16.setText("Username");

        showContentLabel16.setText("Content of the comment");

        commentButton11.setText("Comment on this comment");
        commentButton11.addActionListener(this::commentButton11commentButtonActionPerformed);


        jLabel28.setText("Content:");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel18Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(commentButton11)
                                                .addGap(58, 58, 58)
                                        )
                                        .addGroup(jPanel18Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel27)
                                                        .addComponent(jLabel28))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(showContentLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(showingUserLabel16))))
                                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel27)
                                        .addComponent(showingUserLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel28)
                                        .addComponent(showContentLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(commentButton11)
                                      )
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(gobackButton))
                                                .addContainerGap(29, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(showingPostTitleLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(usernameLabel)
                                                .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(showingPostTitleLabel)
                                        .addComponent(jLabel3)
                                        .addComponent(usernameLabel))
                                .addGap(9, 9, 9)
                                .addComponent(gobackButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                                .addContainerGap(185, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void commentButton11commentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.viewComment == null) {
            GeneralPresenter.showNotSelectError("Post");
        } else {
            MakeAComment makeAComment = new MakeAComment(user, course, this.viewComment);
            makeAComment.setVisible(true);
            this.setVisible(false);
        }

    }


    private void gobackButtonActionPerformed(java.awt.event.ActionEvent evt) {
        PostForm postForm = new PostForm(user, course);
        postForm.setVisible(true);
        this.setVisible(false);
    }

    private void jList2MouseClicked() {
        int chosenCommentIndex = jList2.getSelectedIndex();
        if (chosenCommentIndex == - 1){
            GeneralPresenter.showNotSelectError("Comment");
        }
        else {
            Comment selectComment = post.getComments().get(chosenCommentIndex);
            this.viewComment = selectComment;
            changePanel(selectComment);
        }
    }

    private void changePanel(Comment comment){
       showingUserLabel16.setText(comment.getPostedBy().getUsername());
       showContentLabel16.setText(comment.getTexts());

    }

    private String[] getCommentArray(int commentSize){
        String[] comments = new String[commentSize];
        for(int i = 0; i < commentSize; i ++){
            comments[i] = "Comment " + i;
        }
        return comments;
    }

    private javax.swing.JList jList2;
    private javax.swing.JLabel showContentLabel16;
    private javax.swing.JLabel showingUserLabel16;

    // End of variables declaration
}



