import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    JTextField UserName;
    JTextField PassWord;
    JTextField Re_PassWord;
    JTextField Email;
    JTextField Verification;

    JButton Send;
    JButton Register;
    RegisterFrame(){

            this.setTitle("Q-A Forum Register");
            this.setSize(600, 500);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel username = new JLabel("UserName: ");
            UserName = new JTextField();
            UserName.setPreferredSize(new Dimension(300,30));
            JPanel user = new JPanel();
            user.setLayout(new FlowLayout());
            user.setPreferredSize(new Dimension(500, 30));
            user.add(username);
            user.add(UserName);

            JLabel password = new JLabel("PassWord: ");
            PassWord = new JTextField();
            PassWord.setPreferredSize(new Dimension(300,30));
            JPanel pass = new JPanel();
            pass.setLayout(new FlowLayout());
            pass.setPreferredSize(new Dimension(500, 30));
            pass.add(password);
            pass.add(PassWord);



            JLabel Repassowrd = new JLabel("Re-enter Password: ");
            Re_PassWord = new JTextField();
            Re_PassWord.setPreferredSize(new Dimension(300,30));
            JPanel repass = new JPanel();
            repass.setLayout(new FlowLayout());
            repass.setPreferredSize(new Dimension(550, 30));
            repass.add(Repassowrd);
            repass.add(Re_PassWord);

            JLabel email = new JLabel("         Email: ");
            Email = new JTextField();
            Email.setPreferredSize(new Dimension(300,30));
            JPanel ema = new JPanel();
            ema.setLayout(new FlowLayout());
            ema.setPreferredSize(new Dimension(500, 30));
            ema.add(email);
            ema.add(Email);

            JLabel verifacte = new JLabel("Verification:");
            Verification = new JTextField();
            Verification.setPreferredSize(new Dimension(300,30));
            JPanel veri = new JPanel();
            veri.setLayout(new FlowLayout());
            veri.setPreferredSize(new Dimension(500, 30));
            veri.add(verifacte);
            veri.add(Verification);


            Send = new JButton();
            Send.setText("Send Verification Code to Email");
            Send.setFocusable(false);

            Register = new JButton();
            Register.setText("Register");
            Register.setFocusable(false);

            JPanel button1 = new JPanel();
            button1.setLayout(new FlowLayout());
            button1.setPreferredSize(new Dimension(500, 40));
            button1.add(Send);

            JPanel button2 = new JPanel();
            button2.setLayout(new FlowLayout());
            button2.setPreferredSize(new Dimension(500, 80));
            button2.add(Register);



            this.add(user);
            this.add(pass);
            this.add(repass);
            this.add(ema);
            this.add(veri);
            this.add(button1);
            this.add(button2);
            this.setLayout(new FlowLayout(FlowLayout.TRAILING));
            this.setVisible(true);


        }
    }

