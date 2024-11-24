package pending.javacat.LunarQuickLaunch.program;

public enum LunarQuickLaunch {
    INSTANCE;

    public void start() throws Exception {
        ProcessManager.INSTANCE.checkIfLunarClientAlreadyRunning();

        ProcessManager.INSTANCE.startLunarClient();
        WindowManager.INSTANCE.startCheckingForWindow();

        RobotManager.INSTANCE.init();

        RobotManager.INSTANCE.moveAndClick(800, 460);
        RobotManager.INSTANCE.closeWindow();
    }
}
