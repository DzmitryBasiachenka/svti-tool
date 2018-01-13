package com.bsdim.svtit.app.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.bsdim.svtit.app.component.MenuBar;

public class WorkspaceWindow extends JFrame {
    private static final String WORKSPACE_WINDOW = "Рабочая область";
    private static final String VIDEO_CONTROL = "Видеонаблюдение";
    private static final String EXIT_BUTTON = "Выход";
    private static final String CREATE_BUTTON = "Добавить";
    private static final String LIST_UNITS = "Список";
    private static final String INFORMATION = "Информация";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public WorkspaceWindow() {
        super(WORKSPACE_WINDOW);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setJMenuBar(new MenuBar().initMenuBarComponent());

        add(initComponents());
        setVisible(true);
    }

    private JPanel initComponents() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder(VIDEO_CONTROL));

        panel.add(initButtonComponent(), BorderLayout.SOUTH);
        panel.add(initStationComponent(), BorderLayout.WEST);
        panel.add(initInfoComponent(), BorderLayout.EAST);

        return panel;
    }

    private JPanel initButtonComponent() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 4, 1));
        buttonPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JButton create = new JButton(CREATE_BUTTON);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VideoControlWindow();
            }
        });

        JButton exit = new JButton(EXIT_BUTTON);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());
        buttonPanel.add(create);
        buttonPanel.add(exit);

        return buttonPanel;
    }

    //provisionally
    private JPanel initStationComponent() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder(LIST_UNITS));
        JTextArea station = new JTextArea(0, 20);
        station.setLineWrap(true);
        station.setEditable(true);
        panel.add(wrapForScroll(station), BorderLayout.CENTER);
        return panel;
    }

    private JPanel initInfoComponent() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder(INFORMATION));
        JTextArea info = new JTextArea(0, 48);
        info.setLineWrap(true);
        info.setEditable(true);
        panel.add(wrapForScroll(info), BorderLayout.CENTER);
        return panel;
    }

    public static JComponent wrapForScroll(JComponent component) {
        JScrollPane scrollPane = new JScrollPane(component);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        return scrollPane;
    }
}
