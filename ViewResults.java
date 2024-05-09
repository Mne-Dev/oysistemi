import javax.swing.*;
import java.awt.*;

public class ViewResults {

    public static Font font = new Font("SansSerif", Font.PLAIN, 20);

    public static float res1 = areyousure.result1;
    public static float res2 = areyousure.result2;
    public static float res3 = areyousure.result3;
    public static float sum = res1 + res2 + res3;

    public static float ratio(int a)
    {
        float result = 0;

        switch (a)
        {
            case 1:
                result = res1/sum;
                break;
            case 2:
                result = res2/sum;
                break;
            case 3:
                result = res3/sum;
                break;
        }

        return result;
    }

    public static void Main()
    {
        JFrame ResultFrame = new JFrame("Sonuçlar");
        ResultFrame.setSize(800,540);


        JPanel panelfirstParty = new JPanel();
        JPanel panelsecondParty = new JPanel();
        JPanel panelthirdParty = new JPanel();

        JLabel labelfirstParty = new JLabel("Cumhuriyet Halk Partisi: Özgür Özel " + (int)res1 + " oy");
        JLabel labelsecondParty = new JLabel("İyi Parti: Meral Akşener " + (int)res2 + " oy");
        JLabel labelthirdParty = new JLabel("Ak Parti: Recep Tayyip Erdoğan " + (int)res3 + " oy");

        JPanel panelForcolor1 = new JPanel();
        JPanel panelForcolor2 = new JPanel();
        JPanel panelForcolor3 = new JPanel();

        labelfirstParty.setFont(font);
        labelsecondParty.setFont(font);
        labelthirdParty.setFont(font);

        panelfirstParty.setBounds(50,70,700, 90);
        panelsecondParty.setBounds(50,220,700,90);
        panelthirdParty.setBounds(50,370,700,90);

        labelfirstParty.setBounds(70,60,460,70);
        labelsecondParty.setBounds(70, 210, 460,70);
        labelthirdParty.setBounds(70, 360, 460, 70);

        panelForcolor1.setBounds(50,70, (int) (ratio(1)*((long) panelfirstParty.getWidth())),90);
        panelForcolor2.setBounds(50,220,(int) (ratio(2)*((long) panelsecondParty.getWidth())), 90);
        panelForcolor3.setBounds(50,370,(int) (ratio(3)*((long) panelthirdParty.getWidth())), 90);

        panelfirstParty.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelsecondParty.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelthirdParty.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panelForcolor1.setBackground(new Color(255, 0, 0, 111));
        panelForcolor2.setBackground(new Color(0,255,255,111));
        panelForcolor3.setBackground(new Color(255,165,0,111));


        ResultFrame.add(panelForcolor1);
        ResultFrame.add(panelForcolor2);
        ResultFrame.add(panelForcolor3);
        ResultFrame.add(labelfirstParty);
        ResultFrame.add(labelsecondParty);
        ResultFrame.add(labelthirdParty);
        ResultFrame.add(panelfirstParty);
        ResultFrame.add(panelsecondParty);
        ResultFrame.add(panelthirdParty);
        ResultFrame.setLayout(null);
        ResultFrame.setVisible(true);
    }
}
