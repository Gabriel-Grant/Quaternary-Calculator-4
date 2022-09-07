import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class calculator extends JFrame implements ActionListener {
    static Frame f;

    static JTextField l;

    public static void main(String[] args) {
        f = new JFrame("calculator");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        calculator c = new calculator();

        l = new JTextField(16);

        l.setEditable(false);

        JButton b0, b1, b2, b3, beq, ba, bs, bd, bm, bsqr, bsq;

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

        JPanel p = new JPanel();

        b0.addActionListener(c);
        b1.addActionListener(c);
        b2.addActionListener(c);
        b3.addActionListener(c);
        beq.addActionListener(c);
        ba.addActionListener(c);
        bs.addActionListener(c);
        bd.addActionListener(c);
        bm.addActionListener(c);
        bsqr.addActionListener(c);
        bsq.addActionListener(c);

        p.add(l);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b0);
        p.add(ba);
        p.add(bs);
        p.add(bm);
        p.add(bd);
        p.add(bsqr);
        p.add(bsq);
        p.add(beq);

        p.setBackground(Color.green);

        f.add(p);

        f.setSize(180, 180);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
