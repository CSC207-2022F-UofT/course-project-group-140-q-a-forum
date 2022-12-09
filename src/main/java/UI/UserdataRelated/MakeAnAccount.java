/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.UserdataRelated;
import Presenter.GeneralPresenter;
import Presenter.RegisterPresenter;
import base.Main;
import controllers.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 *
 * @author zhaoxiling
 */
public class MakeAnAccount extends  javax.swing.JFrame {
    private final UserController userController = Main.userController;
    private String correctVerification;
    /**
     * Creates new form RegisterForm
     */
    public MakeAnAccount() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        JButton backButton = new JButton();
        JPanel jPanel1 = new JPanel();
        passWordText = new javax.swing.JTextField();
        rePassText = new javax.swing.JTextField();
        JLabel jLabel1 = new JLabel();
        emailText = new javax.swing.JTextField();
        verificationText = new javax.swing.JTextField();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel4 = new JLabel();
        userNameText = new javax.swing.JTextField();
        JLabel jLabel3 = new JLabel();
        showingSeding = new javax.swing.JLabel();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();
        JLabel jLabel8 = new JLabel();
        JLabel jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        JButton sendButton = new JButton();
        registerButton = new JButton();
        JLabel showVeriLabel = new JLabel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Set Up a Account"));


        jLabel6.setText("UserName:");

        jLabel7.setText("Password:");

        jLabel8.setText("Confirm Password:");

        jLabel9.setText("Email");

        jLabel10.setText("Verification:");

        sendButton.setText("Send Verification");
        sendButton.addActionListener(this::sendButtonActionPerformed);


        backButton.setText("Back to Login Page");
        backButton.addActionListener(this::backButtonActionPerformed);

        registerButton.setText("Register");
        registerButton.addActionListener(this::registerButtonActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel10)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(136, 136, 136)
                                                                                .addComponent(jLabel5))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(139, 139, 139)
                                                                                .addComponent(jLabel1))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(142, 142, 142)
                                                                                .addComponent(jLabel2))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(93, 93, 93)
                                                                                .addComponent(jLabel3))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(168, 168, 168)
                                                                                .addComponent(jLabel4)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jLabel9)))
                                                                .addGap(10, 10, 10)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(emailText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(verificationText, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(userNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(passWordText, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(rePassText, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(showingSeding, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(sendButton))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(265, 265, 265)
                                                .addComponent(registerButton))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(74, 74, 74)
                                                .addComponent(showVeriLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(37, 37, 37)
                                                .addComponent(jLabel2)
                                                .addGap(41, 41, 41)
                                                .addComponent(jLabel3)
                                                .addGap(41, 41, 41)
                                                .addComponent(jLabel4))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(userNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(passWordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel7))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(rePassText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel9)
                                                        .addComponent(sendButton))))
                                .addGap(9, 9, 9)
                                .addComponent(showingSeding, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(74, 74, 74))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(showVeriLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(verificationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel10))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(registerButton)
                                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(backButton)
                                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(backButton)
                                .addContainerGap(146, Short.MAX_VALUE))
        );

        pack();
        verificationText.setVisible(false);
        jLabel10.setVisible(false);
        registerButton.setVisible(false);
    }// </editor-fold>

    private void backButtonActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String email = emailText.getText();
        int resultOrCode = userController.sendEmail(email);
        switch (resultOrCode){
            case -1 ->{
                RegisterPresenter.showNonValidEmailError();
            }
            case -2 ->{
                RegisterPresenter.showVerificationError();
            }
            default -> {
                correctVerification = String.valueOf(resultOrCode);
                showingSeding.setText("Verification Send");
                verificationText.setVisible(true);
                jLabel10.setVisible(true);
                registerButton.setVisible(true);
            }
        }
    }

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        HashMap<String, String> RegInfo = new HashMap<>();
        String userName = userNameText.getText();
        RegInfo.put("Username", userName);
        String passWord = passWordText.getText();
        RegInfo.put("Password", passWord);
        String repass = rePassText.getText();
        RegInfo.put("Re-entered Password", repass);
        String email = emailText.getText();
        RegInfo.put("Email", email);
        String isAdmin = null;
        RegInfo.put("isAdmin", isAdmin);
        String verification = verificationText.getText();
        RegInfo.put("Verification", verification);
        int result = userController.registerUser(RegInfo, correctVerification);
        switch (result) {
            case 1 -> {
                RegisterPresenter.showRegisterSuccess();
                this.setVisible(false);
                LoginForm loginPage = new LoginForm();
                loginPage.setVisible(true);
            }
            case -1 -> {
                RegisterPresenter.showUserDuplicationError();
                userNameText.setText("");
                userNameText.setFocusable(true);
            }
            case -2 -> {
                RegisterPresenter.showWrongPasswordError();
                passWordText.setText("");
                passWordText.setFocusable(true);
            }
            case -3 -> {
                RegisterPresenter.showNonValidEmailError();
                emailText.setText("");
                emailText.setFocusable(true);

            }
            case -4 -> {
                RegisterPresenter.showWrongRePassError();
                rePassText.setText("");
                rePassText.setFocusable(true);
            }
            case -5 -> {
                RegisterPresenter.showVerificationError();
                verificationText.setText("");
                verificationText.setFocusable(true);
            }
            case -6 -> {
                RegisterPresenter.showEMailDuplicationError();
                emailText.setText("");
                emailText.setFocusable(true);
            }
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField emailText;
    private javax.swing.JTextField passWordText;
    private javax.swing.JTextField rePassText;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel showingSeding;
    private javax.swing.JTextField userNameText;
    private javax.swing.JTextField verificationText;
    // End of variables declaration
}
