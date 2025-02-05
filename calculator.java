import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator extends JFrame {
    private JButton button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_0;
    private JButton button_C, button_Minus, button_Plus, button_Divide, button_Multiply, button_Equals;
    private JTextField textScreen;
    private String currentText = "";
    private double firstNum = 0;
    private String operator = "";
    private boolean isOperatorClicked = false;

    public Kalkulator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Główny panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        textScreen = new JTextField();
        textScreen.setEditable(false);
        mainPanel.add("North", textScreen);

        // Panel z przyciskami kalkulatora
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));

        button_1 = createButton("1");
        button_2 = createButton("2");
        button_3 = createButton("3");
        button_4 = createButton("4");
        button_5 = createButton("5");
        button_6 = createButton("6");
        button_7 = createButton("7");
        button_8 = createButton("8");
        button_9 = createButton("9");
        button_0 = createButton("0");
        button_C = createButton("C");
        button_Minus = createButton("-");
        button_Plus = createButton("+");
        button_Divide = createButton("/");
        button_Multiply = createButton("*");
        button_Equals = createButton("=");

        // Dodajemy przyciski do panelu
        buttonPanel.add(button_7);
        buttonPanel.add(button_8);
        buttonPanel.add(button_9);
        buttonPanel.add(button_Divide);

        buttonPanel.add(button_4);
        buttonPanel.add(button_5);
        buttonPanel.add(button_6);
        buttonPanel.add(button_Multiply);

        buttonPanel.add(button_1);
        buttonPanel.add(button_2);
        buttonPanel.add(button_3);
        buttonPanel.add(button_Plus);

        buttonPanel.add(button_C);
        buttonPanel.add(button_0);
        buttonPanel.add(button_Equals);
        buttonPanel.add(button_Minus);

        // Dodajemy panel przycisków do głównego panelu
        mainPanel.add("Center", buttonPanel);

        // Ustawiamy zawartość okna
        setContentPane(mainPanel);
        pack();
        setVisible(true);
    }

    // Tworzymy przyciski i dodajemy akcje
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(text);
            }
        });
        return button;
    }

    // Obsługuje kliknięcie przycisku
    private void handleButtonClick(String text) {
        if (text.matches("[0-9]")) {
            // Jeśli kliknięto cyfrę, dodaj ją do tekstu
            if (isOperatorClicked) {
                currentText = "";
                isOperatorClicked = false;
            }
            currentText += text;
            textScreen.setText(currentText);
        } else if (text.equals("C")) {
            // Jeśli kliknięto C, czyść ekran
            currentText = "";
            firstNum = 0;
            operator = "";
            textScreen.setText(currentText);
        } else if (text.equals("=")) {
            // Jeśli kliknięto "=", wykonaj obliczenia
            double secondNum = Double.parseDouble(currentText);
            switch (operator) {
                case "+":
                    currentText = String.valueOf(firstNum + secondNum);
                    break;
                case "-":
                    currentText = String.valueOf(firstNum - secondNum);
                    break;
                case "*":
                    currentText = String.valueOf(firstNum * secondNum);
                    break;
                case "/":
                    if (secondNum != 0) {
                        currentText = String.valueOf(firstNum / secondNum);
                    } else {
                        currentText = "ERROR";
                    }
                    break;
            }
            textScreen.setText(currentText);
            operator = "";
        } else {
            // Jeśli kliknięto operator, zapisz pierwszą liczbę i operator
            if (!currentText.isEmpty()) {
                firstNum = Double.parseDouble(currentText);
                operator = text;
                isOperatorClicked = true;
                textScreen.setText(currentText + " " + operator);
            }
        }
    }

    public static void main(String[] args) {
        new Kalkulator(); // Uruchamiamy kalkulator
    }
}
