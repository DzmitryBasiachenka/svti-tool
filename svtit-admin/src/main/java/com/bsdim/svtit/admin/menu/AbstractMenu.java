package com.bsdim.svtit.admin.menu;

import java.util.Scanner;

public abstract class AbstractMenu {
    private static Scanner sScanner = new Scanner(System.in);

    public int performMenu() {
        showMenu();
        return getValue();
    }

    protected abstract void showMenu();

    protected int getValue() {
        return sScanner.nextInt();
    }
}
