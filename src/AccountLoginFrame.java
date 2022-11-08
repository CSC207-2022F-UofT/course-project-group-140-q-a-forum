import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountLoginFrame extends JFrame implements ActionListener {
    JTextField UserName;
    JTextField PassWord;
    JButton Login;
    JButton Register;
    JButton ForgetPassword;


    AccountLoginFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JLabel username = new JLabel("User Name: ");
        username.setHorizontalTextPosition(JLabel.CENTER);
        username.setVerticalTextPosition(JLabel.TOP);

        JLabel password = new JLabel("Password: ");
        password.setHorizontalTextPosition(JLabel.CENTER);
        password.setVerticalTextPosition(JLabel.TOP);


        UserName = new JTextField();
        UserName.setPreferredSize(new Dimension(300, 30));

        PassWord = new JTextField();
        PassWord.setPreferredSize(new Dimension(300, 30));

        Login = new JButton();
        Login.setText("Login");
        Login.setFocusable(false);
        Login.addActionListener(this);

        Register = new JButton();
        Register.setText("Register");
        Register.setFocusable(false);
        Register.addActionListener(this);

        ForgetPassword = new JButton();
        ForgetPassword.setText("Forget Password?");
        ForgetPassword.setFocusable(false);
        ForgetPassword.addActionListener(this);

        JPanel user  = new JPanel();
        user.setPreferredSize(new Dimension(300, 50));
        user.add(username);
        user.add(UserName);

        JPanel pass = new JPanel();
        pass.setPreferredSize(new  Dimension(300, 50));
        pass.add(password);
        pass.add(PassWord);

        JPanel button = new JPanel();
        button.setPreferredSize(new  Dimension(300, 50));
        button.add(Login);
        button.add(Register);
        button.add(ForgetPassword);

        this.add(user);
        this.add(pass);
        this.add(button);

        this.setResizable(true);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.pack();
        this.setSize(420, 420);
        this.setTitle("Q-A Forum");
        this.setVisible(true);
    }



    //TODO: Now it is just a simple test way to do the LoginSuccess case, we need more things on it.
    public boolean LoginSuccess(){
        return UserName.getText().equals(PassWord.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == Login){
            boolean result = LoginSuccess();
            if (result){
                ThreadUI LoginSucess = new ThreadUI();
                this.setVisible(false);
            }else{
                PassWord.setText(" ");
                JOptionPane.showMessageDialog(null, "Username and Password are not matched, Please try again!",
                        "login failed", JOptionPane.INFORMATION_MESSAGE );
            }
        }

        if(e.getSource() == Register){
            RegisterUI popupregister = new RegisterUI();
        }

        if(e.getSource() == ForgetPassword){
            ResetPasswordUI popupResetPass = new ResetPasswordUI();
        }
    }

    }

