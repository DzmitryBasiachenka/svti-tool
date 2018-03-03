package com.bsdim.svtit.admin;

import com.bsdim.svtit.admin.menu.MainMenu;

/**
 * The admin starter.
 * <p>
 * Date: 2018-03-03
 *
 * @author Dzmitry Basiachenka
 */
public final class AdminStarter {
    private AdminStarter() {}

    /**
     * It is a point of input to the admin.
     *
     * @param args the string array.
     */
    public static void main(String[] args) {
        new MainMenu().selectMenu();
    }
}
