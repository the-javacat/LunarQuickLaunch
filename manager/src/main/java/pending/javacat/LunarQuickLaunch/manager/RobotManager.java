package pending.javacat.LunarQuickLaunch.manager;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum RobotManager {
    INSTANCE;

    Robot robot;

    public void init() throws AWTException {
        robot = new Robot();

        moveAndClick(800, 460);
        closeWindow();
    }

    void moveAndClick(int x, int y) {
        robot.mouseMove(x, y);
        robot.delay(500);

        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
    }

    void closeWindow() {
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);
    }
}
