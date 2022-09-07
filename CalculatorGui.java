import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class calculator extends JFrame implements ActionListener {
    static Frame calcFrame;
    static JTextField entryField;

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

        JButton b0, b1, b2, b3, beq, ba, bs, bd, bm, bsqr, bsq, btog;

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        beq = new JButton("=");
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        bsqr = new JButton("sqrt(x)");
        bsq = new JButton("x^2");
        btog = new JButton("dec");

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
        bsqr.addActionListener(calc);
        bsq.addActionListener(calc);
        btog.addActionListener(calc);

        calcPanel.add(entryField);
        calcPanel.add(b1);
        calcPanel.add(b2);
        calcPanel.add(b3);
        calcPanel.add(b0);
        calcPanel.add(ba);
        calcPanel.add(bs);
        calcPanel.add(bm);
        calcPanel.add(bd);
        calcPanel.add(bsqr);
        calcPanel.add(bsq);
        calcPanel.add(beq);
        calcPanel.add(btog);

        calcPanel.setBackground(Color.pink);

        calcFrame.add(calcPanel);
        calcFrame.setSize(195, 200);
        calcFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
