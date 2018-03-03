package com.bsdim.svtit.app;

import com.bsdim.svtit.app.window.MainWindow;

/**
 * The app starter.
 * <p>
 * Date: 2018-03-03
 *
 * @author Dzmitry Basiachenka
 */
public final class AppStarter {
    private AppStarter() {}

    /**
     * It is a point of input to the app.
     *
     * @param args the string array.
     */
    public static void main(String[] args) {
        new MainWindow();
    }
}
