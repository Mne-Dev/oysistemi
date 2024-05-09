import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class areyousure {

    public static String readFileAsString(String fileName) throws Exception
    {
        String data = "";
        data = new String(
                Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static int result1;
    public static int result2;
    public static int result3;



    static
    {
        try
        {
            result1 = Integer.parseInt(readFileAsString(Main.path + "\\result1"));
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    static
    {
        try
        {
            result2 = Integer.parseInt(readFileAsString(Main.path + "\\result2"));
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    static
    {
        try
        {
            result3 = Integer.parseInt(readFileAsString(Main.path + "\\result3"));
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    public static void renewResults() throws Exception {

    }
    void DoWindow(int b) {
        JFrame checkFrame = new JFrame("Emin misiniz?");
        checkFrame.setSize(300,300);

        JLabel Text = new JLabel("Emin misiniz?");
        Text.setBounds(50,50,200,30);
        Text.setFont(new Font("SansSerif", Font.PLAIN, 30));

        JButton buttonyes = new JButton("Evet");
        JButton buttonno = new JButton("Hayır");
        buttonyes.setBounds(50,200,75,30);
        buttonno.setBounds(175,200,75,30);

        JButton buttonexit = new JButton("Çıkış");
        buttonexit.setBounds(100,200,100,30);

        checkFrame.add(buttonexit);
        buttonexit.setVisible(false);

        buttonexit.addActionListener(e -> {
            checkFrame.dispose();
        });

        switch (b)
        {
            case 1:
                buttonyes.addActionListener(e -> {
                    result1 += 1;
                    try {
                        Files.writeString(Path.of(Main.path + "\\result1"), String.valueOf(result1));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    Text.setText("Teşekkürler");
                    buttonyes.setVisible(false);
                    buttonno.setVisible(false);
                    buttonexit.setVisible(true);

                });
                buttonno.addActionListener(e -> {
                    checkFrame.dispose();
                });
                break;
            case 2:
                buttonyes.addActionListener(e -> {
                    result2 += 1;
                    try {
                        Files.writeString(Path.of(Main.path + "\\result2"), String.valueOf(result2));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    Text.setText("Teşekkürler");
                    buttonyes.setVisible(false);
                    buttonno.setVisible(false);
                    buttonexit.setVisible(true);

                });
                buttonno.addActionListener(e -> {
                    checkFrame.dispose();
                });
                break;
            case 3:
                buttonyes.addActionListener(e -> {
                    result3 += 1;
                    try {
                        Files.writeString(Path.of(Main.path + "\\result3"), String.valueOf(result3));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    Text.setText("Teşekkürler");
                    buttonyes.setVisible(false);
                    buttonno.setVisible(false);
                    buttonexit.setVisible(true);

                });
                buttonno.addActionListener(e -> {
                    checkFrame.dispose();
                });
                break;
        }

        checkFrame.add(buttonno);
        checkFrame.add(buttonyes);
        checkFrame.add(Text);
        checkFrame.setLayout(null);
        checkFrame.setVisible(true);
    }

    void DoChecks(int a) throws IOException {
        switch (a)
        {
            case 1:
                DoWindow(1);
                break;

            case 2:
                DoWindow(2);
                break;

            case 3:
                DoWindow(3);
                break;
        }
    }
}
