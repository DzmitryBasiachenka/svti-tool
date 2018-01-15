package com.bsdim.svtit.admin.menu;

import java.util.logging.Logger;

public class VideoSystemMenu extends AbstractMenu {
    private static final String SELECT_ITEM = "Select a menu item";
    private static final String ADD_VIDEO_SYSTEM = "1)Add video system";
    private static final String SEARCH_VIDEO_SYSTEM_BY_NAME = "2)Search video system by name";
    private static final String UPDATE_VIDEO_SYSTEM = "3)Update video system";
    private static final String DELETE_VIDEO_SYSTEM = "4)Delete video system";
    private static final String DISPLAY_VIDEO_SYSTEMS = "5)Display all video systems";
    private static final String EXIT_FROM_MENU = "6)Exit";
    private static Logger sLogger = Logger.getLogger(VideoSystemMenu.class.getName());
    @Override
    protected void showMenu() {
        sLogger.info("\n");
        sLogger.info(SELECT_ITEM);
        sLogger.info(ADD_VIDEO_SYSTEM);
        sLogger.info(SEARCH_VIDEO_SYSTEM_BY_NAME);
        sLogger.info(UPDATE_VIDEO_SYSTEM);
        sLogger.info(DELETE_VIDEO_SYSTEM);
        sLogger.info(DISPLAY_VIDEO_SYSTEMS);
        sLogger.info(EXIT_FROM_MENU);
    }
}
