package lab13;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Нягт тооцоолох программ (Density Calculator)
 * Томьёо: p = m / V
 * Масс болон эзлэхүүнийг оруулж, нягтыг тооцоолно.
 */
public class DensityCalculator extends JFrame {

    // ---- Оролтын талбарууд ----
    private JTextField massField;
    private JTextField volumeField;
    private JTextField densityField;

    // ---- Нэгжийн сонголтууд ----
    private JComboBox<String> massUnitBox;
    private JComboBox<String> volumeUnitBox;
    private JComboBox<String> densityUnitBox;
    private JComboBox<String> sigFigBox;

    // ---- Товчлуурууд ----
    private JButton calculateButton;
    private JButton clearButton;

    // ---- Үр дүн ----
    private JTextArea answerArea;

    // ---- Нэгжүүд ----
    private static final String[] MASS_UNITS   = {"g", "kg", "lb", "oz"};
    private static final String[] VOLUME_UNITS = {"cm³", "m³", "mL", "L", "ft³"};
    private static final String[] DENSITY_UNITS = {"g/cm³", "g/mL", "kg/m³", "lb/ft³", "kg/cm³"};
    private static final String[] SIG_FIGS     = {"auto", "1", "2", "3", "4", "5", "6"};

    // ---- Масс хөрвүүлэлт (грамм руу) ----
    private static double toGrams(double value, String unit) {
        switch (unit) {
            case "g":   return value;
            case "kg":  return value * 1000.0;
            case "lb":  return value * 453.592;
            case "oz":  return value * 28.3495;
            default:    return value;
        }
    }

    // ---- Эзлэхүүн хөрвүүлэлт (cm³ руу) ----
    private static double toCm3(double value, String unit) {
        switch (unit) {
            case "cm³": return value;
            case "m³":  return value * 1_000_000.0;
            case "mL":  return value;           // 1 mL = 1 cm³
            case "L":   return value * 1000.0;
            case "ft³": return value * 28316.8;
            default:    return value;
        }
    }

    // ---- Нягт хөрвүүлэлт (g/cm³-аас) ----
    private static double fromGPerCm3(double density, String unit) {
        switch (unit) {
            case "g/cm³":  return density;
            case "g/mL":   return density;
            case "kg/m³":  return density * 1000.0;
            case "lb/ft³": return density * 62.428;
            case "kg/cm³": return density / 1000.0;
            default:       return density;
        }
    }

    // ---- Конструктор ----
    public DensityCalculator() {
        setTitle("Density Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        buildUI();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ================================================================
    //  UI байгуулах
    // ================================================================
    private void buildUI() {
        // Гол контейнер
        JPanel root = new JPanel();
        root.setLayout(new BorderLayout(10, 10));
        root.setBackground(new Color(210, 225, 240));
        root.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        // ---- Гарчиг ----
        JLabel title = new JLabel("Density Calculator", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        title.setForeground(new Color(30, 60, 100));
        title.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(160, 185, 210), 1, true),
                BorderFactory.createEmptyBorder(8, 0, 8, 0)));
        title.setOpaque(true);
        title.setBackground(new Color(220, 232, 245));
        root.add(title, BorderLayout.NORTH);

        // ---- Томьёо ----
        JLabel formula = new JLabel("<html><i>p</i> = <sup>m</sup>&frasl;<sub>V</sub></html>", SwingConstants.CENTER);
        formula.setFont(new Font("Serif", Font.ITALIC, 28));
        formula.setForeground(new Color(30, 60, 100));
        formula.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // ---- Талбарын хэсэг ----
        JPanel fieldsPanel = buildFieldsPanel();

        // ---- Дунд хэсэг: томьёо + талбарууд ----
        JPanel center = new JPanel(new BorderLayout(0, 5));
        center.setOpaque(false);
        center.add(formula, BorderLayout.NORTH);
        center.add(fieldsPanel, BorderLayout.CENTER);
        root.add(center, BorderLayout.CENTER);

        // ---- Доод хэсэг: хариулт ----
        JPanel bottom = buildBottomPanel();
        root.add(bottom, BorderLayout.SOUTH);

        setContentPane(root);
    }

    // ---- Оролтын талбарын хэсэг ----
    private JPanel buildFieldsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 8, 6, 8);
        c.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("SansSerif", Font.PLAIN, 15);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 14);

        // ---- НЯГТ мөр ----
        c.gridx = 0; c.gridy = 0; c.weightx = 0;
        panel.add(makeLabel("density  p =", labelFont), c);

        densityField = new JTextField("calculated density", 18);
        densityField.setEditable(false);
        densityField.setFont(fieldFont);
        densityField.setBackground(new Color(230, 238, 248));
        densityField.setForeground(Color.GRAY);
        densityField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 200, 220)),
                BorderFactory.createEmptyBorder(4, 6, 4, 6)));
        c.gridx = 1; c.weightx = 1;
        panel.add(densityField, c);

        JLabel lockIcon = new JLabel("🔒");
        c.gridx = 2; c.weightx = 0;
        panel.add(lockIcon, c);

        JLabel unitsLabel = makeLabel("units", labelFont);
        c.gridx = 3;
        panel.add(unitsLabel, c);

        densityUnitBox = new JComboBox<>(DENSITY_UNITS);
        styleCombo(densityUnitBox);
        c.gridx = 4;
        panel.add(densityUnitBox, c);

        // ---- МАСС мөр ----
        c.gridx = 0; c.gridy = 1; c.weightx = 0;
        panel.add(makeLabel("mass  m =", labelFont), c);

        massField = new JTextField();
        massField.setFont(fieldFont);
        massField.setToolTipText("Массын утгыг оруулна уу");
        styleField(massField);
        c.gridx = 1; c.weightx = 1;
        panel.add(massField, c);

        massUnitBox = new JComboBox<>(MASS_UNITS);
        styleCombo(massUnitBox);
        c.gridx = 2; c.gridwidth = 3; c.weightx = 0;
        panel.add(massUnitBox, c);

        // ---- ЭЗЛЭХҮҮН мөр ----
        c.gridwidth = 1;
        c.gridx = 0; c.gridy = 2; c.weightx = 0;
        panel.add(makeLabel("volume  V =", labelFont), c);

        volumeField = new JTextField();
        volumeField.setFont(fieldFont);
        volumeField.setToolTipText("Эзлэхүүний утгыг оруулна уу");
        styleField(volumeField);
        c.gridx = 1; c.weightx = 1;
        panel.add(volumeField, c);

        volumeUnitBox = new JComboBox<>(VOLUME_UNITS);
        styleCombo(volumeUnitBox);
        c.gridx = 2; c.gridwidth = 3; c.weightx = 0;
        panel.add(volumeUnitBox, c);

        // ---- Sig Figures мөр ----
        c.gridwidth = 1;
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2; c.anchor = GridBagConstraints.EAST;
        panel.add(makeLabel("Significant Figures", labelFont), c);

        sigFigBox = new JComboBox<>(SIG_FIGS);
        styleCombo(sigFigBox);
        c.gridx = 2; c.gridwidth = 3; c.anchor = GridBagConstraints.WEST;
        panel.add(sigFigBox, c);

        // ---- Товчлуурын мөр ----
        c.gridwidth = 1; c.anchor = GridBagConstraints.CENTER;
        clearButton = new JButton("Clear");
        styleButton(clearButton, new Color(200, 215, 230), new Color(30, 60, 100));
        c.gridx = 0; c.gridy = 4; c.gridwidth = 2; c.fill = GridBagConstraints.NONE;
        panel.add(clearButton, c);

        calculateButton = new JButton("Calculate");
        styleButton(calculateButton, new Color(30, 80, 150), Color.WHITE);
        c.gridx = 3; c.gridwidth = 2;
        panel.add(calculateButton, c);

        // ---- Listener-үүд ----
        calculateButton.addActionListener(e -> calculate());
        clearButton.addActionListener(e -> clearAll());

        return panel;
    }

    // ---- Хариултын хэсэг ----
    private JPanel buildBottomPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(160, 185, 210)),
                BorderFactory.createEmptyBorder(8, 10, 8, 10)));

        answerArea = new JTextArea(3, 40);
        answerArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        answerArea.setEditable(false);
        answerArea.setBackground(Color.WHITE);
        answerArea.setLineWrap(true);
        answerArea.setWrapStyleWord(true);
        answerArea.setText("Answer:");

        panel.add(new JScrollPane(answerArea), BorderLayout.CENTER);
        return panel;
    }

    // ================================================================
    //  Тооцоолох логик
    // ================================================================
    private void calculate() {
        try {
            // --- Масс уншлага ---
            String massText = massField.getText().trim();
            if (massText.isEmpty()) {
                throw new IllegalArgumentException("Массын утгыг оруулна уу!");
            }
            double massValue = Double.parseDouble(massText);   // NumberFormatException боломжтой

            // --- Эзлэхүүн уншлага ---
            String volText = volumeField.getText().trim();
            if (volText.isEmpty()) {
                throw new IllegalArgumentException("Эзлэхүүний утгыг оруулна уу!");
            }
            double volValue = Double.parseDouble(volText);     // NumberFormatException боломжтой

            // --- Утгын хүрээ шалгах ---
            if (massValue < 0) {
                throw new IllegalArgumentException("Масс сөрөг байж болохгүй!");
            }
            if (volValue < 0) {
                throw new IllegalArgumentException("Эзлэхүүн сөрөг байж болохгүй!");
            }
            if (volValue == 0) {
                throw new ArithmeticException("Эзлэхүүн тэгээр хуваах боломжгүй (V = 0)!");
            }

            // --- Нэгж хөрвүүлэлт ---
            String massUnit   = (String) massUnitBox.getSelectedItem();
            String volUnit    = (String) volumeUnitBox.getSelectedItem();
            String densUnit   = (String) densityUnitBox.getSelectedItem();

            double massG  = toGrams(massValue, massUnit);
            double volCm3 = toCm3(volValue, volUnit);

            // --- Нягт = масс / эзлэхүүн (g/cm³) ---
            double densityGcm3 = massG / volCm3;

            // --- Гаралтын нэгж рүү хөрвүүлэх ---
            double result = fromGPerCm3(densityGcm3, densUnit);

            // --- Тоон нарийвчлал ---
            String sigStr = (String) sigFigBox.getSelectedItem();
            String formatted;
            if ("auto".equals(sigStr)) {
                formatted = String.format("%.6g", result);
            } else {
                int sig = Integer.parseInt(sigStr);
                formatted = String.format("%." + sig + "g", result);
            }

            // --- Үр дүнг харуулах ---
            densityField.setText(formatted + " " + densUnit);
            densityField.setForeground(new Color(30, 60, 100));

            answerArea.setText(
                    "Answer:\n" +
                    "  p = m / V\n" +
                    "  p = " + massValue + " " + massUnit +
                    " / " + volValue + " " + volUnit + "\n" +
                    "  p ≈ " + formatted + " " + densUnit
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "⚠  Оролтын алдаа!\n\nМасс болон эзлэхүүн нь тоо байх ёстой.\n" +
                    "Тэмдэгт эсвэл хоосон утга оруулсан байна.",
                    "Оролтын алдаа",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "⚠  Математикийн алдаа!\n\n" + ex.getMessage(),
                    "Тэгд хуваах алдаа",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "⚠  Утгын алдаа!\n\n" + ex.getMessage(),
                    "Буруу утга",
                    JOptionPane.WARNING_MESSAGE
            );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "⚠  Тодорхойгүй алдаа гарлаа:\n" + ex.getMessage(),
                    "Алдаа",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // ================================================================
    //  Цэвэрлэх
    // ================================================================
    private void clearAll() {
        massField.setText("");
        volumeField.setText("");
        densityField.setText("calculated density");
        densityField.setForeground(Color.GRAY);
        answerArea.setText("Answer:");
        massUnitBox.setSelectedIndex(0);
        volumeUnitBox.setSelectedIndex(0);
        densityUnitBox.setSelectedIndex(0);
        sigFigBox.setSelectedIndex(0);
    }

    // ================================================================
    //  Туслах арга (style)
    // ================================================================
    private JLabel makeLabel(String text, Font font) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(font);
        lbl.setForeground(new Color(40, 70, 110));
        return lbl;
    }

    private void styleField(JTextField field) {
        field.setFont(new Font("SansSerif", Font.PLAIN, 14));
        field.setBackground(Color.WHITE);
        field.setForeground(new Color(30, 60, 100));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(160, 185, 210)),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)));
    }

    private void styleCombo(JComboBox<String> box) {
        box.setFont(new Font("SansSerif", Font.PLAIN, 13));
        box.setBackground(Color.WHITE);
        box.setForeground(new Color(30, 60, 100));
    }

    private void styleButton(JButton btn, Color bg, Color fg) {
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(120, 155, 195), 1, true),
                BorderFactory.createEmptyBorder(7, 20, 7, 20)));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    // ================================================================
    //  main
    // ================================================================
    public static void main(String[] args) {
        // Look-and-Feel системийнхийг ашиглах
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(DensityCalculator::new);
    }
}