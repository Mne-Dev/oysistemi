import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {

    public static String path = new File("").getAbsolutePath();
    public static Font font = new Font("SansSerif", Font.BOLD, 14);

    public static String readFileAsString(String fileName) throws Exception
    {
        String data = "";
        data = new String(
                Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("Giriş Paneli");
        frame.setSize(400,300);

        JLabel label = new JLabel();
        JLabel usernamelabel = new JLabel();
        JTextField textFieldUsername = new JTextField();
        JLabel passwordlabel = new JLabel();
        JPasswordField textFieldPassword = new JPasswordField();
        JButton button = new JButton();
        JLabel resultlabel = new JLabel();

        // Konumlandırma
        label.setBounds(125,50,150,30);
        usernamelabel.setBounds(100,80,150,30);
        textFieldUsername.setBounds(100,110,200,20);
        passwordlabel.setBounds(100,140,150,30);
        textFieldPassword.setBounds(100,170,200,20);
        button.setBounds(200,200,100,30);
        resultlabel.setBounds(100,200,150,20);

        label.setText("Vatandaş Giriş Paneli");
        label.setFont(font);
        usernamelabel.setText("T.C. Kimlik Numarası");
        passwordlabel.setText("Şifre");
        button.setText("Giriş Yap");

        String Credentials = readFileAsString(path + "\\databaseforelectants");

        String[] SeperatedCredentials = Credentials.split(",");

        button.addActionListener(e -> {
            String GivenCredentials = textFieldUsername.getText() +";"+ textFieldPassword.getText();

            if(Arrays.asList(SeperatedCredentials).contains(GivenCredentials))
            {
                resultlabel.setForeground(Color.GREEN);
                resultlabel.setText("Giriş Başarılı!");
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }

                ElectionForum electionForum = new ElectionForum();
                ElectionForum.Main();
                frame.setVisible(false);
            }
            else
            {
                resultlabel.setForeground(Color.RED);
                resultlabel.setText("Giriş Başarısız!");
                try {

                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }


            }
        });

        frame.add(textFieldUsername);
        frame.add(resultlabel);
        frame.add(button);
        frame.add(textFieldPassword);
        frame.add(passwordlabel);
        frame.add(label);
        frame.add(usernamelabel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}