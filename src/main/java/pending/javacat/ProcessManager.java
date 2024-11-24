package pending.javacat;

import pending.javacat.util.StringManager;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public enum ProcessManager {
    INSTANCE;
    private final String LUNAR_PATH = "C:\\Users\\Blaz\\AppData\\Local\\Programs\\Lunar Client\\Lunar Client.exe";
    private Process process = null;
    private final String processName = "Lunar Client.exe";
    private final String command = "tasklist | findstr '" + processName + "'";
    boolean running = false;

    public void checkIfLunarClientAlreadyRunning() throws Exception {
        process = new ProcessBuilder("powershell", "&", command).start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        if (reader.lines().anyMatch(line -> line.contains(processName))) running = true;

        if(!running) {
            JOptionPane.showMessageDialog(null, "Lunar Client isn't windoeOpened!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Lunar Client isn't opened!");
        }
    }

    public void startLunarClient() throws Exception {
        new ProcessBuilder("powershell", "&", StringManager.INSTANCE.encloseString(LUNAR_PATH, "'")).start();
    }
}
