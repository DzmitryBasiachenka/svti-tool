package com.bsdim.svtit.app.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.bsdim.svtit.app.window.video.WorkspaceWindow;

/**
 * The main window.
 * <p>
 * Date: 2018-03-03
 *
 * @author Dzmitry Basiachenka
 */
public class MainWindow extends JFrame {
    private static final String MAIN_WINDOW = "Главное окно";
    private static final String IN_PROGRESS = "In progress...";
    private static final String VIDEO_ICON_PNG = "icons/videoIcon.png";
    private static final String VIDEO_CONTROL = "<html><font size=5>Видеонаблюдение</font></html>";
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int ROWS_MAIN_PANEL = 2;
    private static final int COLS_MAIN_PANEL = 2;
    private static final int HGAP_MAIN_PANEL = 67;
    private static final int VGAP_MAIN_PANEL = 45;
    private static final int BORDER_MAIN_PANEL = 40;
    private static final int VIDEO_ICON_TEXT_GRAP = -26;

    /**
     * The constructor.
     */
    public MainWindow() {
        super(MAIN_WINDOW);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        getContentPane().add(initComponents());
        setVisible(true);
    }

    private JComponent initComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(ROWS_MAIN_PANEL, COLS_MAIN_PANEL,
                HGAP_MAIN_PANEL, VGAP_MAIN_PANEL));
        mainPanel.setBorder(new EmptyBorder(BORDER_MAIN_PANEL, BORDER_MAIN_PANEL,
                BORDER_MAIN_PANEL, BORDER_MAIN_PANEL));

        mainPanel.add(initButtonComponent(), BorderLayout.CENTER);
        mainPanel.add(new JButton(IN_PROGRESS));
        mainPanel.add(new JButton(IN_PROGRESS));
        mainPanel.add(new JButton(IN_PROGRESS));

        return mainPanel;
    }

    private JComponent initButtonComponent() {
        JButton video = new JButton(VIDEO_CONTROL);
        video.setIcon(new ImageIcon(VIDEO_ICON_PNG));
        video.setVerticalTextPosition(SwingConstants.BOTTOM);
        video.setHorizontalTextPosition(SwingConstants.CENTER);
        video.setIconTextGap(VIDEO_ICON_TEXT_GRAP);
        video.addActionListener(event -> {
            new WorkspaceWindow();
            dispose();
        });
        return video;
    }
}
