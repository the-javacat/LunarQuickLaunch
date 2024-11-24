package pending.javacat.LunarQuickLaunch.program;

import pending.javacat.LunarQuickLaunch.manager.ProcessManager;
import pending.javacat.LunarQuickLaunch.manager.RobotManager;
import pending.javacat.LunarQuickLaunch.manager.WindowManager;

public enum LunarQuickLaunch {
    INSTANCE;

    public void start() throws Exception {
        ProcessManager.INSTANCE.postBootStrap();
        WindowManager.INSTANCE.postBootstrap();
        RobotManager.INSTANCE.init();
    }
}
