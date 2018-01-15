package com.bsdim.svtit.admin.menu;

import java.util.logging.Logger;

import com.bsdim.svtit.admin.util.InputUtil;
import com.bsdim.svtit.service.video.VideoSystemService;

public class MainMenu {
    private static final int CASE_ONE = 1;
    private static final int CASE_TWO = 2;
    private static final int CASE_THREE = 3;
    private static final int CASE_FOUR = 4;
    private static final int CASE_FIVE = 5;
    private static final int CASE_SIX = 6;
    private static final String ADD_VIDEO_SYSTEM = "Add video system";
    private static final String SEARCH_VIDEO_SYSTEM_BY_NAME = "Search video system by name";
    private static final String VIDEO_SYSTEM_NOT_FOUND = "Video system not found";
    private static final String UPDATE_VIDEO_SYSTEM = "Update video system";
    private static final String DELETE_VIDEO_SYSTEM = "Delete video system";
    private static final String DISPLAY_VIDEO_SYSTEMS = "Display all video systems";
    private static final String GOODBYE = "Goodbye";
    private static final String CHOOSE_AGAIN = "Choose again";
    private static Logger sLogger = Logger.getLogger(MainMenu.class.getName());
    private VideoSystemService service = new VideoSystemService();

    /**
     * Selects item of the main menu.
     */
    @SuppressWarnings("checkstyle:CyclomaticComplexity")
    public void selectMenu() {
        AbstractMenu userMenu = new VideoSystemMenu();

        while (true) {
            int  number = userMenu.performMenu();
            switch (number) {
                case CASE_ONE:
                    sLogger.info(ADD_VIDEO_SYSTEM);
                    service.addVideoSystem(InputUtil.createDataVideoSystem());
                    break;
               /* case CASE_TWO:
                    sLogger.info(SEARCH_VIDEO_SYSTEM_BY_NAME);
                    User user = service.findById(InputUtil.inputData(ENTER_ID));
                    if (user != null) {
                        sLogger.info(user.toString());
                    } else {
                        sLogger.info(USER_NOT_FOUND);
                    }
                    break;
                case CASE_THREE:
                    sLogger.info(UPDATE_VIDEO_SYSTEM);
                    user = service.findById(InputUtil.inputData(ENTER_ID));
                    if (user != null) {
                        service.updateUser(InputUtil.updateDataVideoSystem(user));
                    } else {
                        sLogger.info(USER_NOT_FOUND);
                    }
                    break;
                case CASE_FOUR:
                    sLogger.info(DELETE_VIDEO_SYSTEM);
                    String userId = InputUtil.inputData(ENTER_ID);
                    user = service.findById(userId);
                    if (user != null) {
                        service.deleteUser(userId);
                    } else {
                        sLogger.info(USER_NOT_FOUND);
                    }
                    break;
                case CASE_FIVE:
                    sLogger.info(DISPLAY_VIDEO_SYSTEMS);
                    List<User> users = service.getUsers();
                    for (User info : users) {
                        sLogger.info(info.toString());
                    }
                    break;*/
                case CASE_SIX:
                    sLogger.info(GOODBYE);
                    System.exit(0);
                    break;
                default:
                    sLogger.info(CHOOSE_AGAIN);
                    break;
            }
        }
    }
}
