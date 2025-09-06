package com.iloen.melon.utils.time;

import A7.d;
import com.iloen.melon.utils.log.LogU;
import java.util.HashMap;

public class LapTimer {
    public static final String AddAndPlay = "AddAndPlay";
    public static final String PlayState = "PlayState";
    public static final String Streaming = "Streaming";
    public static final HashMap a;

    static {
        LapTimer.a = new HashMap();
    }

    public static LapTime get(String s) {
        return (LapTime)LapTimer.a.get(s);
    }

    public static LapTime lap(String s, String s1) {
        return LapTimer.lap(s, s1, System.currentTimeMillis());
    }

    public static LapTime lap(String s, String s1, long v) {
        LapTime lapTime0 = (LapTime)LapTimer.a.get(s);
        if(lapTime0 != null) {
            lapTime0.lap(v);
            LogU.d("LapTimer", "[" + s + "] elapse (" + s1 + "): " + lapTime0);
            return lapTime0;
        }
        return LapTimer.start(s, s1, v);
    }

    public static void remove(String s) {
        LapTimer.a.remove(s);
    }

    public static LapTime start(String s) {
        return LapTimer.start(s, null, System.currentTimeMillis());
    }

    public static LapTime start(String s, long v) {
        return LapTimer.start(s, null, v);
    }

    public static LapTime start(String s, String s1) {
        return LapTimer.start(s, s1, System.currentTimeMillis());
    }

    public static LapTime start(String s, String s1, long v) {
        if(s1 == null) {
            LogU.v("LapTimer", "[" + s + "] started at " + v);
        }
        else {
            StringBuilder stringBuilder0 = d.o("[", s, "] started (", s1, ") at ");
            stringBuilder0.append(v);
            LogU.v("LapTimer", stringBuilder0.toString());
        }
        LapTime lapTime0 = new LapTime(s, v);
        LapTimer.a.put(s, lapTime0);
        return lapTime0;
    }

    public static LapTime stop(String s) {
        return LapTimer.stop(s, System.currentTimeMillis());
    }

    public static LapTime stop(String s, long v) {
        LapTime lapTime0 = (LapTime)LapTimer.a.remove(s);
        if(lapTime0 != null) {
            lapTime0.lap(v);
            LogU.i("LapTimer", "[" + s + "] finished: " + lapTime0);
            return lapTime0;
        }
        return null;
    }
}

