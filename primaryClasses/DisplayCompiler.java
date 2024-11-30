package com.miniCompiler;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayCompiler extends JFrame {
    String contents = "none";
    List<String> tokens = new ArrayList<>();
    List<String> fileCode = new ArrayList<>();

    // Instances of separated analysis classes
    LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
    SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer();
    SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();

    private int currentStep = 0; // 0 = Open File, 1 = Lexical Analysis, etc.
    private RoundedStud[] buttonPanels = new RoundedStud[5];

    public DisplayCompiler() {
        initComponents();
    }

    private void initComponents() {
        JTextArea outputAreaText = new JTextArea();
        CurvedTextField resultField = new CurvedTextField();

        setTitle("Mini Compiler");
        setSize(new Dimension(1280, 720)); // Set window size to 1280x720
        setLocationRelativeTo(null); // Center the window
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.decode("#031716"));
        setContentPane(mainPanel);

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.decode("#031716"));
        headerPanel.setPreferredSize(new Dimension(1280, 60));
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel headerLabel = new JLabel("Mini Compiler");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.decode("#031716"));
        footerPanel.setPreferredSize(new Dimension(1280, 60));
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel footerLabel = new JLabel("© 2024 Mini Compiler | Bulatao, Daanoy, Mercado");
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        // Left Sidebar Panel
        JPanel sidebar = new JPanel(new GridLayout(5, 1, 20, 20));
        sidebar.setBackground(Color.decode("#031716"));
        sidebar.setPreferredSize(new Dimension(250, 0));
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        mainPanel.add(sidebar, BorderLayout.WEST);

        String[] buttons = {"Open File", "Lexical Analysis", "Syntax Analysis", "Semantic Analysis", "Clear"};

        for (int i = 0; i < buttons.length; i++) {
            String buttonText = buttons[i];
            RoundedStud buttonPanel = new RoundedStud(buttonText);

            if (i != currentStep) {
                buttonPanel.setEnabled(false); 
            }

            final int index = i; 

            buttonPanel.addActionListener(e -> {
                if (index == 0) {
                    // Open File button clicked
                    fileCode = openFile();
                    contents = convertListToString(fileCode);
                    outputAreaText.setText(contents);
                } else if (index == 1) {
                    // Lexical Analysis button clicked
                    tokens = lexicalAnalyzer.analyze(fileCode);
                    displayTokens(tokens, resultField);
                } else if (index == 2) {
                    // Syntax Analysis button clicked
                    boolean isValidSyntax = syntaxAnalyzer.analyze(tokens);
                    displaySyntaxResult(isValidSyntax, resultField);
                } else if (index == 3) {
                    // Semantic Analysis button clicked
                    String semanticResult = semanticAnalyzer.analyze(fileCode);
                    displaySemanticResult(semanticResult, resultField);
                } else if (index == 4) {
                    // Clear button clicked
                    clearFields(outputAreaText, resultField);
                }

                buttonPanels[index].setEnabled(false); 
                if (index + 1 < buttons.length) {
                    buttonPanels[index + 1].setEnabled(true); 
                }
            });

            buttonPanels[i] = buttonPanel; // Store button panel in the array
            sidebar.add(buttonPanel);
        }

        // Center Panel for Output Display and Result
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.decode("#031716"));
        centerPanel.setLayout(new BorderLayout());
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Output Area
        JTextArea outputArea = new JTextArea();
        outputArea.setBackground(Color.decode("#C0C0C0"));
        outputArea.setForeground(Color.WHITE);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputArea.setEditable(false);

        // JScrollPane for Output Area
        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        outputScrollPane.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 20));
        outputScrollPane.setBackground(Color.decode("#031716"));
        centerPanel.add(outputScrollPane, BorderLayout.CENTER);

        outputScrollPane.setViewportView(outputAreaText);

        // Result Panel
        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(Color.decode("#031716"));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 22, 20));
        resultPanel.setPreferredSize(new Dimension(0, 100));
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        centerPanel.add(resultPanel, BorderLayout.SOUTH);

        // Result Label
        JLabel resultLabel = new JLabel("Result");
        resultLabel.setFont(new Font("Monospaced", Font.BOLD, 12));
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        resultPanel.add(resultLabel);

        // Result Field
        resultField.setBackground(Color.decode("#C0C0C0"));
        resultField.setForeground(Color.BLACK);
        resultField.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultField.setEditable(false);
        resultField.setAlignmentX(Component.LEFT_ALIGNMENT);
        resultPanel.add(resultField);
    }

    private void clearFields(JTextArea outputAreaText, JTextField resultField) {
        contents = "none";
        tokens = new ArrayList<>();
        fileCode = new ArrayList<>();
        outputAreaText.setText("");
        resultField.setText("");
    }

    private void displayTokens(List<String> tokens, JTextField resultField) {
        StringBuilder mergedTokens = new StringBuilder();
        for (String token : tokens) {
            mergedTokens.append(token).append("\n");
        }
        resultField.setText("Lexical Analysis Successful!");
        JOptionPane.showMessageDialog(null, mergedTokens.toString(), "Lexical Tokens", JOptionPane.INFORMATION_MESSAGE);
    }

    private void displaySyntaxResult(boolean isValid, JTextField resultField) {
        if (isValid) {
            resultField.setText("Syntax Analysis Successful!");
        } else {
            resultField.setText("Syntax Error!");
            JOptionPane.showMessageDialog(null, "A Syntax Error has occurred!", "Syntax Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displaySemanticResult(String result, JTextField resultField) {
        resultField.setText(result);
        if ("Semantically Incorrect!".equals(result)) {
            JOptionPane.showMessageDialog(null, "A Semantic Error has occurred!", "Semantic Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private List<String> openFile() {
        JFileChooser chooseFile = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Java & Text Files", "java", "txt");
        chooseFile.setFileFilter(filter);

        int result = chooseFile.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooseFile.getSelectedFile();
            return readFile(selectedFile);
        }
        return new ArrayList<>();
    }

    private List<String> readFile(File file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private String convertListToString(List<String> list) {
        return String.join("\n", list);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DisplayCompiler app = new DisplayCompiler();
            app.setVisible(true);
        });
    }
}
