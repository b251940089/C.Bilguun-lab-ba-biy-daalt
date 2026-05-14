package lab12;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::buildAndShowGUI);
    }

    private static void buildAndShowGUI() {

        calculator calc = new calculator();

        /* ═══ Frame ════════════════════════════════════════════════ */
        JFrame frame = new JFrame("Тооны машин");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 360);          // 350:180 харьцаа × 2
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        /* ═══ Өнгө / Фонт ══════════════════════════════════════════ */
        Color bgColor    = new Color(210, 215, 225);
        Color fieldBg    = new Color(240, 242, 245);
        Color btnBg      = new Color(220, 224, 232);
        Color resultBg   = new Color(200, 205, 215);
        Font  labelFont  = new Font("SansSerif", Font.PLAIN, 22);
        Font  fieldFont  = new Font("SansSerif", Font.PLAIN, 26);
        Font  btnFont    = new Font("SansSerif", Font.PLAIN, 32);
        Font  resultFont = new Font("SansSerif", Font.PLAIN, 26);

        /* ═══ Үндсэн самбар ════════════════════════════════════════ */
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(bgColor);
        root.setBorder(new EmptyBorder(20, 20, 10, 20));

        /* ═══ Оролтын хэсэг ════════════════════════════════════════ */
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 20, 6));
        inputPanel.setBackground(bgColor);

        JLabel lbl1 = new JLabel("Нэгдүгээр операнд");
        JLabel lbl2 = new JLabel("Хоёрдугаар операнд");
        lbl1.setFont(labelFont);
        lbl2.setFont(labelFont);

        JTextField field1 = styledField("15.7", fieldFont, fieldBg);
        JTextField field2 = styledField("9.3",  fieldFont, fieldBg);

        inputPanel.add(lbl1);   inputPanel.add(lbl2);
        inputPanel.add(field1); inputPanel.add(field2);

        /* ═══ Үр дүнгийн самбар ════════════════════════════════════ */
        JLabel resultLabel = new JLabel("Хариу: ");
        resultLabel.setFont(resultFont);
        resultLabel.setBorder(new EmptyBorder(8, 12, 8, 12));

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBackground(resultBg);
        resultPanel.setBorder(new CompoundBorder(
                new LineBorder(new Color(170, 175, 185), 1),
                new EmptyBorder(6, 6, 6, 6)));
        resultPanel.add(resultLabel, BorderLayout.CENTER);

        /* ═══ Товчнуудын хэсэг ═════════════════════════════════════ */
        JPanel btnPanel = new JPanel(new GridLayout(1, 4, 12, 0));
        btnPanel.setBackground(bgColor);
        btnPanel.setBorder(new EmptyBorder(14, 0, 10, 0));

        String[][] ops = {{"+","+"},{"-","-"},{"*","*"},{"÷","/"}};

        for (String[] pair : ops) {
            JButton btn = new JButton(pair[0]);
            btn.setFont(btnFont);
            btn.setBackground(btnBg);
            btn.setFocusPainted(false);
            btn.setBorder(new CompoundBorder(
                    new LineBorder(new Color(190, 195, 205), 1, true),
                    new EmptyBorder(10, 0, 10, 0)));
            final String opKey = pair[1];
            btn.addActionListener(e -> {
                try {
                    double a = Double.parseDouble(field1.getText().trim());
                    double b = Double.parseDouble(field2.getText().trim());
                    resultLabel.setText("Хариу: " + calc.calculate(a, b, opKey));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Хариу: Тоо оруулна уу!");
                } catch (ArithmeticException | IllegalArgumentException ex) {
                    resultLabel.setText("Хариу: Алдаа — " + ex.getMessage());
                }
            });
            btnPanel.add(btn);
        }

        /* ═══ Нэгтгэнэ ══════════════════════════════════════════════ */
        root.add(inputPanel,  BorderLayout.NORTH);
        root.add(btnPanel,    BorderLayout.CENTER);
        root.add(resultPanel, BorderLayout.SOUTH);

        frame.setContentPane(root);
        frame.setVisible(true);
    }

    private static JTextField styledField(String text, Font font, Color bg) {
        JTextField f = new JTextField(text);
        f.setFont(font);
        f.setBackground(bg);
        f.setBorder(new CompoundBorder(
                new LineBorder(new Color(180, 185, 195), 1, true),
                new EmptyBorder(6, 12, 6, 12)));
        return f;
    }
}