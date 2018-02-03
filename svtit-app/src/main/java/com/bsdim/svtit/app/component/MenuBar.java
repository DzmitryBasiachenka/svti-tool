package com.bsdim.svtit.app.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.bsdim.svtit.app.window.EditorWindow;
import com.bsdim.svtit.app.window.VideoSystemWindow;

public class MenuBar {
    private static final String FILE_MENU = "Файл";
    private static final String NEW_ITEM = "Новый";
    private static final String EDIT_ITEM = "Редактировать";
    private static final String DELETE_ITEM = "Удалить";
    private static final String EXIT_ITEM = "Выход";
    private static final String HELP_MENU = "Помощь";
    private static final String ABOUT_ITEM = "О программме";

    public JMenuBar initMenuBarComponent() {
        JMenuBar menuBar = new JMenuBar();

        menuBar.add(initFileMenu());
        menuBar.add(initHelpMenu());

        return menuBar;
    }

    private JMenu initFileMenu() {
        JMenu menu = new JMenu(FILE_MENU);

        JMenuItem newItem = new JMenuItem(NEW_ITEM);
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VideoSystemWindow();
            }
        });

        JMenuItem editItem = new JMenuItem(EDIT_ITEM);
        editItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditorWindow();
            }
        });
        JMenuItem deleteItem = new JMenuItem(DELETE_ITEM);
        JMenuItem exitItem = new JMenuItem(EXIT_ITEM);

        exitItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(newItem);
        menu.add(editItem);
        menu.add(deleteItem);
        menu.add(exitItem);

        return menu;
    }

    private JMenu initHelpMenu() {
        JMenu menu = new JMenu(HELP_MENU);
        JMenuItem itemAbout = new JMenuItem(ABOUT_ITEM);
        menu.add(itemAbout);
        return menu;
    }
}
