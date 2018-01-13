package com.bsdim.svtit.app.window;

import javax.swing.JFrame;

public class EditorWindow extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    public EditorWindow() {
        super("Редактор");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
