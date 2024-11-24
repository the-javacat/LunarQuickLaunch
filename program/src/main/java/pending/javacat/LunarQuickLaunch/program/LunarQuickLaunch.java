package pending.javacat.LunarQuickLaunch.program;

public enum LunarQuickLaunch {
    INSTANCE;

    public void start() throws Exception {
        ProcessManager.INSTANCE.postBootStrap();
        WindowManager.INSTANCE.postBootstrap();
        RobotManager.INSTANCE.init();
    }
}
