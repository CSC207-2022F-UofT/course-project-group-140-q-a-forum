/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.PostingStuff;

import UI.MainOfShowingContents.CommentsForm;
import UI.MainOfShowingContents.CoursesForm;
import UI.MainOfShowingContents.PostForm;
import base.main;
import controllers.CourseController;
import controllers.PostController;
import controllers.ReportController;
import entities.Comment;
import entities.Course;
import entities.Post;
import entities.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author zhaoxiling
 */
public class MakeAReport extends javax.swing.JFrame {

    private final User user;
    private final Course course;
    private final Post post;
    private final Comment comment;
    private final int reportType;
    private final CourseController courseController = main.courseController;
    private final ReportController reportController = main.reportController;



    public MakeAReport(User user) {
        this.user = user;
        this.post = null;
        this.course = null;
        this.comment = null;
        this.reportType = 0;
        initComponents();
    }

    public MakeAReport(User user, Course course) {
        this.user = user;
        this.course= course;
        this.post = null;
        this.comment = null;
        this.reportType = 2;
        initComponents();
    }

    public MakeAReport(User user, Course course, Post post){
        this.user = user;
        this.course= course;
        this.post = post;
        this.comment = null;
        this.reportType = 1;
        initComponents();
    }

//    public MakeAReport(User user, Course course, Post post, Comment comment){
//        this.user = user;
//        this.course= course;
//        this.post = post;
//        this.comment = comment;
//        this.reportType = "Comment";
//        initComponents();
//    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        titleText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reasonText = new javax.swing.JTextArea();
        reportButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        userButton = new javax.swing.JRadioButton();
        anonymousButton = new javax.swing.JRadioButton();
        backButton = new javax.swing.JButton();
        typeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Make a Report"));

        jLabel1.setText("Title:");

        jLabel2.setText("Reason for the report");

        jLabel3.setText("Make the report for:");


        if (this.reportType == 0) {
            titleLabel.setText("user");
            typeLabel.setText("User");
        }
        if (this.reportType == 1) {
            titleLabel.setText(this.post.getTopic());
            typeLabel.setText("Post");
        }
        if (this.reportType == 2) {
            titleLabel.setText(this.course.getName());
            typeLabel.setText("Course");
        }

        reasonText.setColumns(20);
        reasonText.setRows(5);
        jScrollPane1.setViewportView(reasonText);

        reportButton.setText("Report ");
        reportButton.addActionListener(this::reportButtonActionPerformed);

        jLabel5.setText("Post as: ");

        userButton.setText("User");
        userButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userButtonActionPerformed(evt);
            }
        });

        anonymousButton.setText("Anonymous");
        anonymousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anonymousButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back to the page");
        backButton.addActionListener(this::backButtonActionPerformed);

        typeLabel.setText("(" + this.reportType + ")");

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
                                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(typeLabel))
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
                                                                .addComponent(anonymousButton))
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(reportButton)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(backButton)
                                                                        .addGap(35, 35, 35))
                                                                .addComponent(titleText, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)))))
                                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel3)
                                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(typeLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                                        .addComponent(anonymousButton)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(reportButton)
                                        .addComponent(backButton))
                                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt){
        HashMap<String, Object> reportInfo = new HashMap<>();
        reportInfo.put("Username", user.getUsername());
        reportInfo.put("Type", reportType);
        reportInfo.put("Content", reasonText.getText());
        int result = reportController.createAReport(reportInfo);
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.reportType == 0) {
            CommentsForm commentsForm = new CommentsForm(this.user, this.course, this.post);
            commentsForm.setVisible(true);
            this.setVisible(false);
        }
        if (this.reportType == 1) {
            PostForm postForm = new PostForm(this.user,this.course);
            postForm.setVisible(true);
            this.setVisible(false);
        }
        if (this.reportType == 2) {
            ArrayList<Course> courses = courseController.getAllCourses();
            CoursesForm coursesForm = new CoursesForm(this.user, courses);
            coursesForm.setVisible(true);
            this.setVisible(false);
        }

    }

    private void userButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void anonymousButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    // Variables declaration - do not modify
    private javax.swing.JRadioButton anonymousButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea reasonText;
    private javax.swing.JButton reportButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleText;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JRadioButton userButton;
    // End of variables declaration
}
