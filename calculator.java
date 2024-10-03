import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
 import java.awt.GridLayout;

public class Kalkulator extends JFrame{
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton button_4;
    private JButton button_5;
    private JButton button_6;
    private JButton button_7;
    private JButton button_8;
    private JButton button_9;
    private JButton button_0;
    private JButton button_C;
    private JButton button_Minus;
    private JButton button_Plus;
    private JButton button_Divide;
    private JButton button_Multiply;
    private JTextField textScreen;
    public Kalkulator(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout());//tworzymy główny panel
        textScreen = new JTextField();
        manePanel.add("North", textScreen);


        JPanel buttonPanel = new JPanel(new GridLayout(6, 4));
        buttonPanel.add(new JLable());
        buttonPanel.add(new JLable());
        buttonPanel.add(new JLable());
        buttonPanel.add(button_C);
        buttonPanel.add(button_7);
        buttonPanel.add(button_8);
        buttonPanel.add(button_9);
        buttonPanel.add(button_Minus);
        buttonPanel.add(button_4);
        buttonPanel.add(button_5);
        buttonPanel.add(button_6);
        buttonPanel.add(button_Plus);
        buttonPanel.add(button_1);
        buttonPanel.add(button_2);
        buttonPanel.add(button_3);
        buttonPanel.add(button_Multiply);
        buttonPanel.add(new JLable());
        buttonPanel.add(button_0);
        buttonPanel.add(new JLable());
        buttonPanel.add(button_Divide);



        setContentPane(mainPanel); // wstawiamy panel
        pack();
        setVisible(true); // wyświetla okienko paneli na ekranie
    }
    public static void main(String[] args){

    }
}
