package org.greenrobot.eventbus.android;

import U4.x;
import android.util.Log;
import java.util.logging.Level;
import org.greenrobot.eventbus.Logger;

public class AndroidLogger implements Logger {
    private final String tag;

    public AndroidLogger(String s) {
        this.tag = s;
    }

    @Override  // org.greenrobot.eventbus.Logger
    public void log(Level level0, String s) {
        if(level0 != Level.OFF) {
            Log.println(this.mapLevel(level0), this.tag, s);
        }
    }

    @Override  // org.greenrobot.eventbus.Logger
    public void log(Level level0, String s, Throwable throwable0) {
        if(level0 != Level.OFF) {
            int v = this.mapLevel(level0);
            StringBuilder stringBuilder0 = x.p(s, "\n");
            stringBuilder0.append(Log.getStackTraceString(throwable0));
            Log.println(v, this.tag, stringBuilder0.toString());
        }
    }

    private int mapLevel(Level level0) {
        int v = level0.intValue();
        if(v < 800) {
            return v >= 500 ? 3 : 2;
        }
        if(v < 900) {
            return 4;
        }
        return v >= 1000 ? 6 : 5;
    }
}

