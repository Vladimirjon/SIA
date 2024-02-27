// package UserInterface;

// import java.awt.Color;
// import java.awt.Cursor;
// import java.awt.Font;
// import java.net.URL;

// import javax.swing.BorderFactory;
// import javax.swing.JOptionPane;
// import javax.swing.SwingConstants;
// import javax.swing.border.CompoundBorder;
// import javax.swing.border.EmptyBorder;
// import javax.swing.border.LineBorder;
// public abstract class IAStyle {
//     public static final Color COLOR_FONT = new Color(200, 100, 50); //(218, 8, 40)
//     public static final Color COLOR_FONT_LIGHT = new Color(100, 100, 100);
//     public static final Color COLOR_CURSOR = Color.black;
//     public static final Color COLOR_BORDER = Color.lightGray;
//     public static final Font  FONT         = new Font("JetBrains Mono", Font.PLAIN, 14);
//     public static final Font  FONT_BOLD    = new Font("JetBrains Mono", Font.BOLD | Font.PLAIN, 14);
//     public static final Font  FONT_SMALL   = new Font("JetBrains Mono", Font.PLAIN| Font.PLAIN, 10);

//     public static final int ALIGNMENT_LEFT  = SwingConstants.LEFT;
//     public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
//     public static final int ALIGNMENT_CENTER= SwingConstants.CENTER;

//     public static final Cursor CURSOR_HAND    = new Cursor(Cursor.HAND_CURSOR);
//     public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

//     public static final URL URL_MAIN  = IAStyle.class.getResource("/UserInterface/Resource/Img/plantita.png");
//     public static final URL URL_LOGO  = IAStyle.class.getResource("/UserInterface/Resource/Img/CRLogo.png");
//     public static final URL URL_SPLASH= IAStyle.class.getResource("/UserInterface/Resource/Img/DinoInicio.jpg");

//     public static final CompoundBorder createBorderRect(){
//         return BorderFactory.createCompoundBorder(  new LineBorder(Color.lightGray),
//                                                     new EmptyBorder(5, 5, 5, 5));
//     }

//     public static final void showMsg(String msg){
//         JOptionPane.showMessageDialog(null, msg, "😏 CodeRex", JOptionPane.INFORMATION_MESSAGE);
//     }
//     public static final void showMsgError(String msg){
//         JOptionPane.showMessageDialog(null, msg, "💀 CodeRex", JOptionPane.OK_OPTION);
//     }

//     public static final boolean showConfirmYesNo(String msg){
//         return (JOptionPane.showConfirmDialog(null, msg, "😞 CodeRex", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
//     }
// }

package UserInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class IAStyle {
    public static final Color COLOR_FONT = new Color(50, 205, 50); // Light Green
    public static final Color COLOR_FONT_LIGHT = new Color(100, 100, 100);
    public static final Color COLOR_CURSOR = Color.green;
    public static final Color COLOR_BORDER = new Color(34, 139, 34);
    public static final Font FONT = new Font("Arial", Font.PLAIN, 14);
    public static final Font FONT_BOLD = new Font("Arial", Font.BOLD | Font.PLAIN, 14);
    public static final Font FONT_SMALL = new Font("Arial", Font.PLAIN | Font.PLAIN, 10);

    public static final int ALIGNMENT_LEFT = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER = SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    public static final URL URL_MAIN = IAStyle.class.getResource("/UserInterface/Resource/Img/plantita.png");
    public static final URL URL_LOGO = IAStyle.class.getResource("/UserInterface/Resource/Img/CRLogo.png");
    public static final URL URL_SPLASH = IAStyle.class.getResource("/UserInterface/Resource/Img/DinoInicio.jpg");

    public static final CompoundBorder createBorderRect() {
        return BorderFactory.createCompoundBorder(new LineBorder(new Color(144, 238, 144)), new EmptyBorder(5, 5, 5, 5)); // Tranquil Green
    }

    public static final void showMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg, "😏 CodeRex", JOptionPane.INFORMATION_MESSAGE);
    }

    public static final void showMsgError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "💀 CodeRex", JOptionPane.OK_OPTION);
    }

    public static final boolean showConfirmYesNo(String msg) {
        return (JOptionPane.showConfirmDialog(null, msg, "😞 CodeRex", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
}