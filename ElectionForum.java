import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ElectionForum
{

    public static areyousure CheckDecision = new areyousure();

    public static void Main()
    {
        JFrame window = new JFrame("Seçim Ekranı");
        window.setSize(800,540);

        JButton buttonFirstParty = new JButton();
        JButton buttonSecondParty = new JButton();
        JButton buttonThirdParty = new JButton();

        buttonFirstParty.setText("Oy ver");
        buttonSecondParty.setText("Oy ver");
        buttonThirdParty.setText("Oy ver");

        buttonFirstParty.setBounds(50,70,100,50);
        buttonSecondParty.setBounds(50,220,100,50);
        buttonThirdParty.setBounds(50,370,100,50);

        JPanel firstPartyRect = new JPanel();
        JPanel secondPartyRect = new JPanel();
        JPanel thirdPartyRect = new JPanel();

        firstPartyRect.setBounds(200,50,500,90);
        secondPartyRect.setBounds(200,200,500,90);
        thirdPartyRect.setBounds(200,350,500,90);

        firstPartyRect.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        secondPartyRect.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        thirdPartyRect.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        JLabel firstPartyLabel = new JLabel();
        JLabel secondPartyLabel = new JLabel();
        JLabel thirdPartyLabel = new JLabel();

        firstPartyLabel.setBounds(220,60,460,70);
        secondPartyLabel.setBounds(220, 210, 460, 70);
        thirdPartyLabel.setBounds(220, 360, 460,70);

        firstPartyLabel.setText("Cumhuriyet Halk Partisi: Özgür Özel");
        secondPartyLabel.setText("İyi Parti: Meral Akşener");
        thirdPartyLabel.setText("Ak Parti: Recep Tayyip Erdoğan");

        firstPartyLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        secondPartyLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        thirdPartyLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        JButton buttonViewResults = new JButton("Sonuçları Göster");
        buttonViewResults.setBounds(300,450,200,30);

        buttonViewResults.addActionListener(e -> {
            ViewResults.Main();
        });

        buttonFirstParty.addActionListener(e -> {
            try {
                CheckDecision.DoChecks(1);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        buttonSecondParty.addActionListener(e -> {
            try {
                CheckDecision.DoChecks(2);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        buttonThirdParty.addActionListener(e -> {
            try {
                CheckDecision.DoChecks(3);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        window.add(buttonViewResults);
        window.add(firstPartyLabel);
        window.add(secondPartyLabel);
        window.add(thirdPartyLabel);
        window.add(firstPartyRect);
        window.add(secondPartyRect);
        window.add(thirdPartyRect);
        window.add(buttonFirstParty);
        window.add(buttonSecondParty);
        window.add(buttonThirdParty);
        window.setLayout(null);
        window.setVisible(true);
    }
}
