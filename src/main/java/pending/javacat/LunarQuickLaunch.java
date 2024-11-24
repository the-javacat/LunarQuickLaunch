package pending.javacat;

public enum LunarQuickLaunch {
    INSTANCE;

    public void start() throws Exception {
        ProcessManager.INSTANCE.checkIfLunarClientAlreadyRunning();

        ProcessManager.INSTANCE.startLunarClient();
        WindowManager.INSTANCE.startCheckingForWindow();

        RobotManager.INSTANCE.init();

        RobotManager.INSTANCE.moveAndClick(800, 500);
        RobotManager.INSTANCE.closeWindow();
    }
}
