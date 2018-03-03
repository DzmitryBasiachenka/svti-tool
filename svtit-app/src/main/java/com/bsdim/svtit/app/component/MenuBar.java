package com.bsdim.svtit.app.component;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * The menu bar.
 * <p>
 * Date: 2018-03-03
 *
 * @author Dzmitry Basiachenka
 */
public class MenuBar {
    private static final String FILE_MENU = "Файл";
    private static final String NEW_ITEM = "Новый";
    private static final String EDIT_ITEM = "Редактировать";
    private static final String DELETE_ITEM = "Удалить";
    private static final String EXIT_ITEM = "Выход";
    private static final String HELP_MENU = "Помощь";
    private static final String ABOUT_ITEM = "О программме";

    private ActionListener createItemActionListener;
    private ActionListener editItemActionListener;
    private ActionListener deleteItemActionListener;
    private ActionListener exitItemActionListener;

    /**
     * Parametrized constructor.
     *
     * @param createActionListener the create action listener.
     * @param editActionListener the edit action listener.
     * @param deleteActionListener the delete action listener.
     * @param exitActionListener the exit action listener.
     * @return the menu bar.
     */
    public JMenuBar initMenuBarComponent(ActionListener createActionListener, ActionListener editActionListener,
                                         ActionListener deleteActionListener, ActionListener exitActionListener) {
        this.createItemActionListener = createActionListener;
        this.editItemActionListener = editActionListener;
        this.deleteItemActionListener = deleteActionListener;
        this.exitItemActionListener = exitActionListener;

        JMenuBar menuBar = new JMenuBar();

        menuBar.add(initFileMenu());
        menuBar.add(initHelpMenu());

        return menuBar;
    }

    private JMenu initFileMenu() {
        JMenu menu = new JMenu(FILE_MENU);

        JMenuItem newItem = new JMenuItem(NEW_ITEM);
        newItem.addActionListener(createItemActionListener);

        JMenuItem editItem = new JMenuItem(EDIT_ITEM);
        editItem.addActionListener(editItemActionListener);

        JMenuItem deleteItem = new JMenuItem(DELETE_ITEM);
        deleteItem.addActionListener(deleteItemActionListener);

        JMenuItem exitItem = new JMenuItem(EXIT_ITEM);
        exitItem.addActionListener(exitItemActionListener);

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
