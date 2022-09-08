import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

class calculator extends JFrame implements ActionListener {
    static Frame calcFrame;
    static JTextField entryField;
    static ArrayList<String> twoValueOperators = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

    public static void main(String[] args) {
        calcFrame = new JFrame("calculator");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        calculator calc = new calculator();
        entryField = new JTextField(16);
        entryField.setEditable(false);

        JButton b0, b1, b2, b3, beq, ba, bs, bd, bm, bSqr, bSq, bTog;

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        beq = new JButton("=");
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        bSqr = new JButton("sqrt");
        bSq = new JButton("^2");
        bTog = new JButton("dec");

        JPanel calcPanel = new JPanel();

        b0.addActionListener(calc);
        b1.addActionListener(calc);
        b2.addActionListener(calc);
        b3.addActionListener(calc);
        beq.addActionListener(calc);
        ba.addActionListener(calc);
        bs.addActionListener(calc);
        bd.addActionListener(calc);
        bm.addActionListener(calc);
        bSqr.addActionListener(calc);
        bSq.addActionListener(calc);
        bTog.addActionListener(calc);

        calcPanel.add(entryField);
        calcPanel.add(b1);
        calcPanel.add(b2);
        calcPanel.add(b3);
        calcPanel.add(b0);
        calcPanel.add(ba);
        calcPanel.add(bs);
        calcPanel.add(bm);
        calcPanel.add(bd);
        calcPanel.add(bSqr);
        calcPanel.add(bSq);
        calcPanel.add(beq);
        calcPanel.add(bTog);

        calcPanel.setBackground(Color.pink);

        calcFrame.add(calcPanel);
        calcFrame.setSize(195, 200);
        calcFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        CalculatorLogic calcLogic = new CalculatorLogic();
        String currentText = entryField.getText();
        if (e.getActionCommand().equals("^2") || e.getActionCommand().equals("sqrt")) {
            if (!currentText.equals("") && !currentText.contains("+") && !currentText.contains("-") && !currentText.contains("*") && !currentText.contains("/")) {
                if (e.getActionCommand().equals("^2")) {
                    entryField.setText(calcLogic.square(currentText));
                } else {
                    entryField.setText(calcLogic.squareRoot(currentText));
                }
            }
        }
        if (e.getActionCommand().equals("=")) {
            if (!currentText.equals("")) {
                boolean hasOperator = false;
                String currentChar = "";
                for (int i = 0; i < currentText.length(); i++) {
                    currentChar = Character.toString(currentText.charAt(i));
                    if (twoValueOperators.contains(currentChar)) {
                        hasOperator = true;
                        break;
                    }
                }
                if (hasOperator) {
                    String[] numbers = currentText.split(Pattern.quote(currentChar));
                    if (numbers.length > 1) {
                        try {
                            entryField.setText(calcLogic.twoValueOperation(numbers[0], currentChar, numbers[1]));
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                }
            }
        } else {
            if (
                    (!twoValueOperators.contains(e.getActionCommand())
                            && !e.getActionCommand().equals("^2")
                            && !e.getActionCommand().equals("sqrt"))
                            ||
                            (twoValueOperators.contains(e.getActionCommand())
                                    && !currentText.contains("+")
                                    && !currentText.contains("-")
                                    && !currentText.contains("*")
                                    && !currentText.contains("/"))) {
                entryField.setText(currentText + e.getActionCommand());
            }
        }
    }
}
