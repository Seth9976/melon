package com.iloen.melon.mcache.error;

import com.iloen.melon.mcache.util.MCacheLogListener;
import f9.q;
import h9.f;

public abstract class ErrorBase extends MCacheError {
    private static final int LOG_MAX = 5;
    private static ErrorFileLog errorFileLog;
    private final Object lock;

    public ErrorBase(String s, String s1) {
        super(s1);
        this.lock = new Object();
        this.writeToListener();
    }

    public ErrorBase(String s, String s1, boolean z) {
        super(s1);
        this.lock = new Object();
        if(z) {
            this.writeToListener();
        }
    }

    public abstract String getCallerTag();

    public static String getLogClassFormat(String s, String s1) {
        return s + "$" + s1;
    }

    @Deprecated
    private void writeToFile() {
        try {
            Object object0 = this.lock;
            synchronized(object0) {
                if(ErrorBase.errorFileLog == null) {
                    ErrorBase.errorFileLog = new ErrorFileLog(q.b + "/log", "mcache.dev", ".txt", true, 5);
                }
            }
            ErrorBase.errorFileLog.write("[MCACHE-" + this.getCallerTag() + "] - ", this.getMessage());
        }
        catch(Exception unused_ex) {
        }
    }

    private void writeToListener() {
        String s = "[MCACHE-" + this.getCallerTag() + "] - ";
        String s1 = this.getMessage();
        MCacheLogListener mCacheLogListener0 = (MCacheLogListener)f.b.b;
        if(mCacheLogListener0 != null) {
            mCacheLogListener0.onErrorLog(s, s1, this);
        }
    }
}

