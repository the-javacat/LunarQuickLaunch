package pending.javacat;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

import javax.swing.*;
import java.time.Duration;

public enum WindowManager {
    INSTANCE;
    boolean windowOpened = false;

    public void startCheckingForWindow() throws InterruptedException {
        User32 user32 = User32.INSTANCE;
        char[] buffer = new char[1024];
        WinDef.HWND hwnd = user32.GetForegroundWindow();
        long targetTime = System.currentTimeMillis() + Duration.ofSeconds(30).toMillis();

        System.out.println("Monitoring for new windows...");

        while (targetTime >= System.currentTimeMillis()) {
            WinDef.HWND currentForegroundWindow = user32.GetForegroundWindow();
            if (currentForegroundWindow != null && !currentForegroundWindow.equals(hwnd)) {
                hwnd = currentForegroundWindow;
                user32.GetWindowText(hwnd, buffer, 1024);
                String windowTitle = Native.toString(buffer);
                System.out.println("New Window Detected: " + windowTitle);

                if (windowTitle.contains("Home - Lunar Client")) {
                    windowOpened = true;
                    break;
                }
            }
        }

        if (!windowOpened) {
            JOptionPane.showMessageDialog(null, "Lunar Client isn't opened!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Lunar Client wasn't opened!");
        }

        System.out.println("window opened");
        Thread.sleep(200);
    }
}
