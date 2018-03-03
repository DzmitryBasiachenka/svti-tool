package com.bsdim.svtit.admin.menu;

import java.util.Scanner;

/**
 * Work with displaying menu.
 * <p>
 * Date: 2018-03-03
 *
 * @author Dzmitry Basiachenka
 */
public abstract class AbstractMenu {
    private static Scanner sScanner = new Scanner(System.in);

    /**
     * Performs the menu.
     *
     * @return the menu item
     */
    public int performMenu() {
        showMenu();
        return getValue();
    }

    /**
     * Shows the menu.
     */
    protected abstract void showMenu();

    protected int getValue() {
        return sScanner.nextInt();
    }
}
