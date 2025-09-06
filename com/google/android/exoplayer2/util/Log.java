package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.net.UnknownHostException;

public final class Log {
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_OFF = 0x7FFFFFFF;
    public static final int LOG_LEVEL_WARNING = 2;
    private static int logLevel = 0;
    private static boolean logStackTraces = true;

    private static String appendThrowableString(String s, Throwable throwable0) {
        String s1 = Log.getThrowableString(throwable0);
        return TextUtils.isEmpty(s1) ? s : s + "\n  " + s1.replace("\n", "\n  ") + '\n';
    }

    public static void d(String s, String s1) {
        if(Log.logLevel == 0) {
            android.util.Log.d(s, s1);
        }
    }

    public static void d(String s, String s1, Throwable throwable0) {
        Log.d(s, Log.appendThrowableString(s1, throwable0));
    }

    public static void e(String s, String s1) {
        if(Log.logLevel <= 3) {
            android.util.Log.e(s, s1);
        }
    }

    public static void e(String s, String s1, Throwable throwable0) {
        Log.e(s, Log.appendThrowableString(s1, throwable0));
    }

    public static int getLogLevel() {
        return Log.logLevel;
    }

    public boolean getLogStackTraces() {
        return Log.logStackTraces;
    }

    public static String getThrowableString(Throwable throwable0) {
        if(throwable0 == null) {
            return null;
        }
        if(Log.isCausedByUnknownHostException(throwable0)) {
            return "UnknownHostException (no network)";
        }
        return Log.logStackTraces ? android.util.Log.getStackTraceString(throwable0).trim().replace("\t", "    ") : throwable0.getMessage();
    }

    public static void i(String s, String s1) {
        if(Log.logLevel <= 1) {
            android.util.Log.i(s, s1);
        }
    }

    public static void i(String s, String s1, Throwable throwable0) {
        Log.i(s, Log.appendThrowableString(s1, throwable0));
    }

    private static boolean isCausedByUnknownHostException(Throwable throwable0) {
        while(throwable0 != null) {
            if(throwable0 instanceof UnknownHostException) {
                return true;
            }
            throwable0 = throwable0.getCause();
        }
        return false;
    }

    public static void setLogLevel(int v) {
        Log.logLevel = v;
    }

    public static void setLogStackTraces(boolean z) {
        Log.logStackTraces = z;
    }

    public static void w(String s, String s1) {
        if(Log.logLevel <= 2) {
            android.util.Log.w(s, s1);
        }
    }

    public static void w(String s, String s1, Throwable throwable0) {
        Log.w(s, Log.appendThrowableString(s1, throwable0));
    }
}

