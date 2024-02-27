package UserInterface.CustomerControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import UserInterface.IAStyle;

public class JPButton  extends JButton implements MouseListener {
    public JPButton(String text){
        customizeComponent(text);
    }
    public JPButton(String text, String iconPath){
        customizeComponent(text, iconPath);
    }

    public void customizeComponent(String text, String iconPath){ 
        
        setSize(30, 90);
        addMouseListener(this);
        customizeComponent(text);
        setBounds(60, 70, 100, 30); 
        
        setIcon(new ImageIcon(iconPath));
        setFont(IAStyle.FONT);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    public void customizeComponent(String text) {
        setText(text);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(IAStyle.COLOR_FONT);
        setHorizontalAlignment(IAStyle.ALIGNMENT_LEFT);
        setFont(IAStyle.FONT);
        
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setForeground(Color.BLACK);
        setCursor(IAStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(IAStyle.CURSOR_DEFAULT);
    }
}
