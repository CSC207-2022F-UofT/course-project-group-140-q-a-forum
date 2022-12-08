package UI.UserdataRelated;

import Presenter.GeneralPresenter;
import UI.MainOfShowingContents.CoursesForm;
import UI.MainOfShowingContents.PostForm;
import UI.MainOfShowingContents.ReportForm;
import UI.PostingStuff.MakeAReport;
import base.main;
import controllers.CourseController;
import controllers.UserController;
import entities.Course;
import entities.Post;
import entities.User;

import javax.swing.*;
import java.util.ArrayList;



/**
 *
 * @author zhaoxiling
 */
public class ProfilePage extends javax.swing.JFrame {
    private final User user;
    private final User viewUser;
    private final Course course;
    private final Post post;
    private final CourseController courseController =main.courseController;
    private final UserController userController = main.userController;

    /**
     * Creates new form ProfilePage
     */
    public ProfilePage(User user, User viewUser, Course course) {
        this.user = user;
        this.viewUser = viewUser;
        this.course = course;
        this.post = null;
        initComponents();
    }
    public ProfilePage(User user, User viewUser, Course course, Post post){
        this.user = user;
        this.viewUser = viewUser;
        this.course = course;
        this.post = post;
        initComponents();
    }

    private void initComponents() {
        reportButton = new JButton();
        javax.swing.JFormattedTextField jFormattedTextField1 = new javax.swing.JFormattedTextField();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        javax.swing.JLabel reputationTitle = new javax.swing.JLabel();
        changeButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();
        userLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        reputationLabel = new javax.swing.JLabel();
        editUserButton = new javax.swing.JButton();
        // Variables declaration - do not modify
        javax.swing.JButton backButton = new javax.swing.JButton();
        changeUserNameText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        totalLikeLabel = new javax.swing.JLabel();
        showReportPanel = new javax.swing.JPanel();
        showReportButton = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Profile Page"));

        jLabel6.setText("UserName:");

        jLabel7.setText("Password:");

        jLabel8.setText("Email:");

        reputationTitle.setText("Reputation:");

        changeButton.setText("Change Password");
        changeButton.addActionListener(this::changeButtonActionPerformed);

        doneButton.setText("Done");
        doneButton.addActionListener(this::doneButtonActionPerformed);

        // userLabel.setText("Username");
        userLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

       // passLabel.setText("Username");
        passLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        // emailLabel.setText("Email");
        emailLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        // reputationLabel.setText("Reputation Level");
        reputationLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        editUserButton.setText("Edit");
        editUserButton.addActionListener(this::editUserButtonActionPerformed);

        backButton.setText("Back to Upper-Level");
        backButton.addActionListener(this::backButtonActionPerformed);

        jLabel1.setText("Type in the UserName want to change:");

        jLabel2.setText("Total Like Received:");

        totalLikeLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        reportButton.setText("report this user");
        reportButton.addActionListener(this::reportButtonActionPerformed);

        showReportButton.setText("Show All Report(Admin Only )");
        showReportButton.addActionListener(this::showReportButtonActionPerformed);

        javax.swing.GroupLayout showReportPanelLayout = new javax.swing.GroupLayout(showReportPanel);
        showReportPanel.setLayout(showReportPanelLayout);
        showReportPanelLayout.setHorizontalGroup(
                showReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showReportPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(showReportButton)
                                .addContainerGap())
        );
        showReportPanelLayout.setVerticalGroup(
                showReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showReportPanelLayout.createSequentialGroup()
                                .addGap(0, 77, Short.MAX_VALUE)
                                .addComponent(showReportButton))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backButton)
                                .addGap(116, 116, 116)
                                .addComponent(showReportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reportButton)
                                .addGap(245, 245, 245))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(reputationTitle)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(editUserButton))
                                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(changeUserNameText, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(passLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(changeButton)
                                                        .addComponent(doneButton)))
                                        .addComponent(totalLikeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(reputationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(333, 333, 333))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(userLabel)
                                        .addComponent(editUserButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(changeUserNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(doneButton))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passLabel)
                                        .addComponent(jLabel7)
                                        .addComponent(changeButton))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(emailLabel))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(totalLikeLabel))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(reputationTitle)
                                        .addComponent(reputationLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(backButton)
                                                .addComponent(reportButton))
                                        .addComponent(showReportPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
       initialPanel();
    }
    private void setSelfInitial() {
        userLabel.setText(this.viewUser.getUsername());
        passLabel.setText(this.viewUser.getPassword());
        emailLabel.setText(this.viewUser.getEmail());
        totalLikeLabel.setText(String.valueOf(this.viewUser.getLikeNumber()));
        reputationLabel.setText(this.viewUser.getReputation());
        changeUserNameText.setVisible(false);
        jLabel1.setVisible(false);
        doneButton.setVisible(false);
        showReportPanel.setVisible(false);
    }

    public void initialPanel(){
        if(this.user.equals(viewUser)){
            setSelfInitial();
            setPassVisible(true);
            reportButton.setVisible(false);
            if(this.user.isAdmin()){
                showReportPanel.setVisible(true);
            }
        }
        else {
            setSelfInitial();
            setPassVisible(false);
            editUserButton.setVisible(false);
        }
    }
    private void editUserButtonActionPerformed(java.awt.event.ActionEvent evt) {
       setChangeUserVisible(true);
    }

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm(this.user, this.viewUser, this.course);
        changePasswordForm.setVisible(true);
        this.setVisible(false);
    }

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String changeUserName = changeUserNameText.getText();
        int result = userController.resetUsername(user, changeUserName);

        if (result == -1){
            GeneralPresenter.showDuplicationError("username");
            changeUserNameText.setText("");
            changeUserNameText.setFocusable(true);
        } else if (result == -2) {
            GeneralPresenter.showEmptyEntryError();
            changeUserNameText.setText("");
            changeUserNameText.setFocusable(true);
        }else {
            GeneralPresenter.showSuccessMessage("reset username");
            setChangeUserVisible(false);
            ProfilePage profilePage = new ProfilePage(this.user, this.viewUser, this.course);
            profilePage.setVisible(true);
            this.setVisible(false);
        }
    }


    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(this.post==null){
            ArrayList<Course> courses = courseController.getAllCourses();
            CoursesForm coursesForm  = new CoursesForm(user, courses);
            coursesForm.setVisible(true);
        }else {
            PostForm postForm = new PostForm(this.user, this.course);
            postForm.setVisible(true);
        }

        this.setVisible(false);
    }

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {
        MakeAReport makeAReport = new MakeAReport(this.user, this.viewUser);
        makeAReport.setVisible(true);
        this.setVisible(false);
    }



    private void showReportButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ReportForm reportForm = new ReportForm(this.user, this.viewUser, this.course);
        reportForm.setVisible(true);
        this.setVisible(false);
    }


    public void setPassVisible(boolean result){
        jLabel7.setVisible(result);
        passLabel.setVisible(result);
        changeButton.setVisible(result);
    }

    public void setChangeUserVisible(boolean result){
        jLabel1.setVisible(result);
        changeUserNameText.setVisible(result);
        doneButton.setVisible(result);
    }
    private javax.swing.JButton reportButton;
    private javax.swing.JTextField changeUserNameText;
    private javax.swing.JButton editUserButton;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton changeButton;
    private javax.swing.JButton doneButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel reputationLabel;
    private javax.swing.JButton showReportButton;
    private javax.swing.JPanel showReportPanel;
    private javax.swing.JLabel totalLikeLabel;
    private javax.swing.JLabel userLabel;
    // End of variables declaration
}
