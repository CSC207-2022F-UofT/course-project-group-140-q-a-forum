package UI.UserdataRelated;
import UI.MainOfShowingContents.CoursesForm;
import base.Main;
import controllers.CourseController;
import controllers.UserController;

import Presenter.LoginPresenter;
import entities.Course;
import entities.User;

import java.util.ArrayList;

/**
 *
 * @author zhaoxiling
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */

    private final UserController userController =  Main.userController;
    private final CourseController courseController = Main.courseController;
    public LoginForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        passText = new javax.swing.JPasswordField();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        // Variables declaration - do not modify
        javax.swing.JButton loginButton = new javax.swing.JButton();
        javax.swing.JButton registerButton = new javax.swing.JButton();
        javax.swing.JButton forgetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));

        jLabel1.setText("UserName:");

        jLabel2.setText("Password:");

        loginButton.setText("Login");
        loginButton.addActionListener(this::LoginButtonActionPerformed);

        registerButton.setText("Register");
        registerButton.addActionListener(this::RegisterButtonActionPerformed);

        forgetButton.setText("Forget Password?");
        forgetButton.addActionListener(this::forgetButtonActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(usernameText)
                                        .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(loginButton)
                                .addGap(37, 37, 37)
                                .addComponent(registerButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(forgetButton)
                                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginButton)
                                        .addComponent(registerButton)
                                        .addComponent(forgetButton))
                                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(214, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(213, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String username = usernameText.getText();
        String password = new String(passText.getPassword());
        int result = userController.loginUser(username, password);
        if(result == 1){
            this.setVisible(false);
            User user = userController.getUser(username);
            ArrayList<Course> courses = courseController.getAllCourses();
            CoursesForm coursesForm = new CoursesForm(user, courses);
            coursesForm.setVisible(true);
            this.setVisible(false);
        }
        else if(result == -2){
           LoginPresenter.showPasswordNotMatch();
        }
        else{
            LoginPresenter.showUserNotExists();
        }
    }

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        MakeAnAccount RegPage = new MakeAnAccount();
        RegPage.setVisible(true);
        this.setVisible(false);
    }

    private void forgetButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        ForgetPassword forgetPassword = new ForgetPassword();
        forgetPassword.setVisible(true);
        this.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new LoginForm().setVisible(true));
    }

    private javax.swing.JPasswordField passText;
    private javax.swing.JTextField usernameText;
    // End of variables declaration
}
