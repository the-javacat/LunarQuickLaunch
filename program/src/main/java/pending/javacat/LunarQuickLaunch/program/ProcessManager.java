package pending.javacat.LunarQuickLaunch.program;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static pending.javacat.LunarQuickLaunch.program.util.StringUtil.encloseString;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ProcessManager {
    INSTANCE;
    final static String LUNAR_PATH = "C:\\Users\\Blaz\\AppData\\Local\\Programs\\Lunar Client\\Lunar Client.exe";
    final String processName = "Lunar Client.exe";
    boolean running = false;

    public void checkIfLunarClientAlreadyRunning() throws Exception {
        String command = "tasklist | findstr '" + processName + "'";
        Process process = new ProcessBuilder("powershell", "&", command).start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        if (reader.lines().anyMatch(line -> line.contains(processName))) running = true;

        if(!running) {
            JOptionPane.showMessageDialog(null, "Lunar Client isn't windoeOpened!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Lunar Client isn't opened!");
        }
    }

    public void startLunarClient() throws Exception {
        new ProcessBuilder("powershell", "&", encloseString(LUNAR_PATH, "'")).start();
    }
}
