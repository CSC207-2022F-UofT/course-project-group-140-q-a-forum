package UI.UserdataRelated;

import Presenter.GeneralPresenter;
import UI.MainOfShowingContents.CoursesForm;
import base.main;
import controllers.CourseController;
import controllers.UserController;
import entities.Course;
import entities.User;

import java.util.ArrayList;



/**
 *
 * @author zhaoxiling
 */
public class ProfilePage extends javax.swing.JFrame {
    private final User user;
    private final CourseController courseController =main.courseController;
    private final UserController userController = main.userController;

    /**
     * Creates new form ProfilePage
     */
    public ProfilePage(User user) {
        this.user = user;
        initComponents();
    }

    private void initComponents() {

        javax.swing.JFormattedTextField jFormattedTextField1 = new javax.swing.JFormattedTextField();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        javax.swing.JLabel reputationTitle = new javax.swing.JLabel();
        javax.swing.JButton changeButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();
        userLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        reputationLabel = new javax.swing.JLabel();
        javax.swing.JButton editUserButton = new javax.swing.JButton();
        // Variables declaration - do not modify
        javax.swing.JButton backButton = new javax.swing.JButton();
        changeUserNameText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        totalLikeLabel = new javax.swing.JLabel();

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

        setInitial();

        editUserButton.setText("Edit");
        editUserButton.addActionListener(this::editUserButtonActionPerformed);

        backButton.setText("Back to Upper-Level");
        backButton.addActionListener(this::backButtonActionPerformed);

        jLabel1.setText("Type in the UserName want to change:");

        jLabel2.setText("Total Like Received:");

        totalLikeLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                        .addComponent(reputationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(totalLikeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(reputationTitle)
                                        .addComponent(reputationLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                                .addComponent(backButton)
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
    }// </editor-fold>


    private void editUserButtonActionPerformed(java.awt.event.ActionEvent evt) {
        jLabel1.setVisible(true);
        changeUserNameText.setVisible(true);
        doneButton.setVisible(true);
    }

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        ChangePasswordForm changePasswordForm = new ChangePasswordForm(user);
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
            System.out.println("success");
            GeneralPresenter.showSuccessMessage("reset username");
            this.setVisible(false);
            ProfilePage profilePage = new ProfilePage(user);
            profilePage.setVisible(true);
        }
    }


    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<Course> courses = courseController.getAllCourses();
        CoursesForm coursesForm  = new CoursesForm(user, courses);
        coursesForm.setVisible(true);
        this.setVisible(false);
    }

    private void setInitial() {
        userLabel.setText(user.getUsername());
        passLabel.setText(user.getPassword());
        emailLabel.setText(user.getEmail());
        totalLikeLabel.setText(String.valueOf(user.getLikeNumber()));
        reputationLabel.setText(user.getReputation());
        changeUserNameText.setVisible(false);
        jLabel1.setVisible(false);
        doneButton.setVisible(false);
        System.out.println(user.getLikeNumber());
        System.out.println(user.getReputation());
    }


    private javax.swing.JTextField changeUserNameText;
    private javax.swing.JButton doneButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel reputationLabel;
    private javax.swing.JLabel totalLikeLabel;
    private javax.swing.JLabel userLabel;
    // End of variables declaration
}
