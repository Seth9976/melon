package com.kakao.tiara;

import android.util.Log;

class Logger {
    private static boolean isEnabled = false;
    private static int loggingLevel = 3;

    public static void debug(String s, String s1, Object[] arr_object) {
        Logger.print(3, s, s1, arr_object);
    }

    public static void error(String s, String s1, Object[] arr_object) {
        Logger.print(6, s, s1, arr_object);
    }

    public static void info(String s, String s1, Object[] arr_object) {
        Logger.print(4, s, s1, arr_object);
    }

    public static boolean isEnabled() {
        return Logger.isEnabled;
    }

    private static boolean isLoggable(int v) {
        return Logger.isEnabled && v >= Logger.loggingLevel;
    }

    private static void print(int v, String s, String s1, Object[] arr_object) {
        if(Logger.isLoggable(v)) {
            String s2 = String.format(s1, arr_object);
            switch(v) {
                case 2: {
                    Log.v(s, s2);
                    break;
                }
                case 3: {
                    Log.d(s, s2);
                    return;
                }
                case 4: {
                    Log.i(s, s2);
                    return;
                }
                case 5: {
                    Log.w(s, s2);
                    return;
                }
                case 6: {
                    Log.e(s, s2);
                }
            }
        }
    }

    public static void setEnabled(boolean z) {
        Logger.isEnabled = z;
    }

    public static void setLoggingLevel(int v) {
        Logger.loggingLevel = v;
    }

    public static void verbose(String s, String s1, Object[] arr_object) {
        Logger.print(2, s, s1, arr_object);
    }

    public static void warn(String s, String s1, Object[] arr_object) {
        Logger.print(5, s, s1, arr_object);
    }
}

