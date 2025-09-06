package org.greenrobot.eventbus;

import java.util.logging.Level;
import org.greenrobot.eventbus.android.AndroidComponents;

public interface Logger {
    public static class Default {
        public static Logger get() {
            return AndroidComponents.areAvailable() ? AndroidComponents.get().logger : new SystemOutLogger();
        }
    }

    public static class JavaLogger implements Logger {
        protected final java.util.logging.Logger logger;

        public JavaLogger(String s) {
            this.logger = java.util.logging.Logger.getLogger(s);
        }

        @Override  // org.greenrobot.eventbus.Logger
        public void log(Level level0, String s) {
            this.logger.log(level0, s);
        }

        @Override  // org.greenrobot.eventbus.Logger
        public void log(Level level0, String s, Throwable throwable0) {
            this.logger.log(level0, s, throwable0);
        }
    }

    public static class SystemOutLogger implements Logger {
        @Override  // org.greenrobot.eventbus.Logger
        public void log(Level level0, String s) {
            System.out.println("[" + level0 + "] " + s);
        }

        @Override  // org.greenrobot.eventbus.Logger
        public void log(Level level0, String s, Throwable throwable0) {
            System.out.println("[" + level0 + "] " + s);
            throwable0.printStackTrace(System.out);
        }
    }

    void log(Level arg1, String arg2);

    void log(Level arg1, String arg2, Throwable arg3);
}

