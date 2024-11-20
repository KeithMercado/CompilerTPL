package com.miniCompiler;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

public class DisplayCompiler extends JFrame {

    public DisplayCompiler() {
        initComponents();
    }

    private void initComponents() {
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

        for (String buttonText : buttons) {
            RoundedStud buttonPanel = new RoundedStud(buttonText);

            buttonPanel.addActionListener(e -> {
                // Handle button click here
                System.out.println(buttonText + " clicked");
                // add specific actions
                if ("Open File".equals(buttonText)) {
                    // Handle Open File action
                } else if ("Lexical Analysis".equals(buttonText)) {
                    // Handle Lexical Analysis action
                } else if ("Syntax Analysis".equals(buttonText)) {
                    // Handle Syntax Analysis action
                } else if ("Semantic Analysis".equals(buttonText)) {
                    // Handle Semantic Analysis action
                } else if ("Clear".equals(buttonText)) {
                    // Handle Clear action
                }
            });

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

        outputScrollPane.setPreferredSize(new Dimension(0, 400));

        // Result Panel (below the output area)
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
        CurvedTextField resultField = new CurvedTextField();
        resultField.setBackground(Color.decode("#C0C0C0")); 
        resultField.setForeground(Color.BLACK);
        resultField.setFont(new Font("Arial", Font.PLAIN, 14));
        resultField.setEditable(false); 
        resultField.setAlignmentX(Component.LEFT_ALIGNMENT); 
        resultPanel.add(resultField);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DisplayCompiler app = new DisplayCompiler();
            app.setVisible(true);
        });
    }
}
