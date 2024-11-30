package com.miniCompiler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoundedStud extends JPanel {

    private boolean hovered = false; // Tracks hover state
    private String buttonText; // Text displayed on the button

    public RoundedStud(String buttonText) {
        this.buttonText = buttonText;
        setPreferredSize(new Dimension(300, 35)); // Fixed size
        setOpaque(false); // Make panel transparent
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isEnabled()) {
                    fireActionPerformed(); // Trigger action listeners
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (isEnabled()) {
                    hovered = true; // Change hover state
                    repaint(); // Repaint on hover
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (isEnabled()) {
                    hovered = false; // Reset hover state
                    repaint(); // Repaint on exit
                }
            }
        });
    }

    public String getButtonText() {
        return buttonText;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        // Apply anti-aliasing for smooth edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the rounded background
        if (isEnabled()) {
            if (hovered) {
                g2d.setColor(Color.decode("#0A7075")); // Hover color
            } else {
                g2d.setColor(Color.decode("#032F30")); // Default color
            }
        } else {
            g2d.setColor(Color.GRAY); // Disabled color
        }
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        // Draw the button text
        g2d.setColor(Color.WHITE); // Text color
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(buttonText);
        int textHeight = fm.getHeight();
        int x = (getWidth() - textWidth) / 2; // Center horizontally
        int y = (getHeight() - textHeight) / 2 + fm.getAscent(); // Center vertically
        g2d.drawString(buttonText, x, y);

        g2d.dispose(); // Dispose graphics context
    }

    // disable
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setCursor(enabled ? Cursor.getPredefinedCursor(Cursor.HAND_CURSOR) : Cursor.getDefaultCursor());
    }

    public void addActionListener(ActionListener listener) {
        listenerList.add(ActionListener.class, listener);
    }

    public void removeActionListener(ActionListener listener) {
        listenerList.remove(ActionListener.class, listener);
    }

    protected void fireActionPerformed() {
        Object[] listeners = listenerList.getListenerList();
        ActionEvent e = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, buttonText);
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ActionListener.class) {
                ((ActionListener) listeners[i + 1]).actionPerformed(e);
            }
        }
    }
}
