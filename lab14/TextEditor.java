package lab14;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

// ============================================================
//  fileedit класс — файлтай ажиллах
// ============================================================
class fileedit {

    private String filepath;  // Идэвхтэй файлын зам

    public fileedit() {
        this.filepath = "";
    }

    public fileedit(String filepath) {
        this.filepath = filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilepath() {
        return filepath;
    }

    /**
     * Файл руу өгөгдөл бичнэ.
     * @param text бичих текст
     */
    public void printfile(String text) {
        if (filepath == null || filepath.isEmpty()) {
            throw new IllegalStateException("Файлын зам тодорхойлогдоогүй байна.");
        }
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filepath), StandardCharsets.UTF_8))) {
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Файл бичих үед алдаа гарлаа: " + e.getMessage(), e);
        }
    }

    /**
     * Файлаас өгөгдөл уншина.
     * @param fname унших файлын бүрэн зам
     * @return файлын агуулга
     */
    public String readfile(String fname) {
        if (fname == null || fname.isEmpty()) {
            throw new IllegalArgumentException("Файлын нэр хоосон байна.");
        }
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fname), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл олдсонгүй: " + fname, e);
        } catch (IOException e) {
            throw new RuntimeException("Файл унших үед алдаа гарлаа: " + e.getMessage(), e);
        }
        return sb.toString();
    }
}

// ============================================================
//  TextEditor — Үндсэн GUI класс
// ============================================================
public class TextEditor extends JFrame {

    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JButton clearButton;
    private JButton saveButton;
    private JButton openButton;

    private final fileedit fileHandler;

    // ----------------------------------------------------------------
    public TextEditor() {
        fileHandler = new fileedit();
        buildUI();
        setTitle("Text Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 420);
        setMinimumSize(new Dimension(400, 320));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ----------------------------------------------------------------
    //  UI байгуулах
    // ----------------------------------------------------------------
    private void buildUI() {
        // --- Гол layout ---
        setLayout(new BorderLayout(0, 0));

        // --- Текст талбар ---
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        textArea.setTabSize(4);
        textArea.setLineWrap(false);
        textArea.setMargin(new Insets(4, 6, 4, 6));

        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        add(scrollPane, BorderLayout.CENTER);

        // --- Товчлуурын хэсэг ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 6));
        buttonPanel.setBackground(UIManager.getColor("Panel.background"));
        buttonPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY));

        clearButton = makeButton("Clear");
        saveButton  = makeButton("Save");
        openButton  = makeButton("Open");

        buttonPanel.add(clearButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(openButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // --- Listener ---
        clearButton.addActionListener(e -> clearText());
        saveButton.addActionListener(e -> saveFile());
        openButton.addActionListener(e -> openFile());
    }

    private JButton makeButton(String label) {
        JButton btn = new JButton(label);
        btn.setPreferredSize(new Dimension(80, 28));
        btn.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btn.setFocusPainted(false);
        return btn;
    }

    // ----------------------------------------------------------------
    //  Clear — текстийг цэвэрлэх
    // ----------------------------------------------------------------
    private void clearText() {
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Текстийг устгахдаа итгэлтэй байна уу?",
                "Цэвэрлэх",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (choice == JOptionPane.YES_OPTION) {
            textArea.setText("");
            setTitle("Text Editor");
            fileHandler.setFilepath("");
        }
    }

    // ----------------------------------------------------------------
    //  Save — файл хадгалах
    // ----------------------------------------------------------------
    private void saveFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Файл хадгалах");
        chooser.setFileFilter(new FileNameExtensionFilter(
                "Текст файл (*.txt, *.java, *.html)", "txt", "java", "html", "xml", "csv"));
        chooser.setAcceptAllFileFilterUsed(true);

        // Хэрэв өмнө нь нэг файл нээсэн бол тэр замыг санал болгох
        if (!fileHandler.getFilepath().isEmpty()) {
            chooser.setSelectedFile(new File(fileHandler.getFilepath()));
        }

        int result = chooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            // .txt өргөтгөл автоматаар нэмэх (хэрэв байхгүй бол)
            String path = selectedFile.getAbsolutePath();
            if (!path.contains(".")) {
                path += ".txt";
                selectedFile = new File(path);
            }

            // Файл давхцал шалгах
            if (selectedFile.exists()) {
                int overwrite = JOptionPane.showConfirmDialog(
                        this,
                        "\"" + selectedFile.getName() + "\" файл аль хэдийн байна.\nДарж бичих үү?",
                        "Файл давхцал",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
                if (overwrite != JOptionPane.YES_OPTION) return;
            }

            try {
                fileHandler.setFilepath(path);
                fileHandler.printfile(textArea.getText());
                setTitle("Text Editor — " + selectedFile.getName());
                JOptionPane.showMessageDialog(
                        this,
                        "✅ Файл амжилттай хадгалагдлаа:\n" + path,
                        "Хадгалагдлаа",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "❌ Файл хадгалах үед алдаа гарлаа:\n" + ex.getMessage(),
                        "Алдаа",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    // ----------------------------------------------------------------
    //  Open — файл нээх
    // ----------------------------------------------------------------
    private void openFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Файл нээх");
        chooser.setFileFilter(new FileNameExtensionFilter(
                "Текст файл (*.txt, *.java, *.html)", "txt", "java", "html", "xml", "csv"));
        chooser.setAcceptAllFileFilterUsed(true);

        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            // Одоогийн өөрчлөгдөөгүй текст шалгах
            if (!textArea.getText().isEmpty()) {
                int save = JOptionPane.showConfirmDialog(
                        this,
                        "Одоогийн текстийг хадгалах уу?",
                        "Анхааруулга",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (save == JOptionPane.YES_OPTION) {
                    saveFile();
                } else if (save == JOptionPane.CANCEL_OPTION) {
                    return;
                }
            }

            try {
                String content = fileHandler.readfile(selectedFile.getAbsolutePath());
                textArea.setText(content);
                textArea.setCaretPosition(0);
                fileHandler.setFilepath(selectedFile.getAbsolutePath());
                setTitle("Text Editor — " + selectedFile.getName());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "❌ Файл нээх үед алдаа гарлаа:\n" + ex.getMessage(),
                        "Алдаа",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    // ----------------------------------------------------------------
    //  main
    // ----------------------------------------------------------------
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(TextEditor::new);
    }
}