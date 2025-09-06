package com.iloen.melon.mcache;

import A7.d;
import android.text.TextUtils;
import f9.q;
import h9.f;

public final class PropertyLoader {
    public static final String KEY_CACHE_PATH = "KEY_CACHE_PATH";
    public static final String KEY_CACHE_SIZE = "KEY_CACHE_SIZE";
    public static final String KEY_FILE_LOG_ON = "KEY_FILE_LOG_ON";
    public static final String KEY_LOG_LEVEL = "KEY_LOG_LEVEL";
    public static final String KEY_LOG_ON = "KEY_LOG_ON";
    public static final int LOG_LEVEL_DEBUG = 1;
    public static final int LOG_LEVEL_ERROR = 4;
    public static final int LOG_LEVEL_INFO = 2;
    public static final int LOG_LEVEL_VERBOSE = 0;
    public static final int LOG_LEVEL_WARN = 3;
    private static final String TAG = "PropertyLoader";

    public static void load() {
        int v1;
        long v;
        String s = System.getProperty("KEY_CACHE_SIZE");
        if(!TextUtils.isEmpty(s)) {
            try {
                v = -1L;
                v = Long.parseLong(s.replaceAll(",", ""));
            }
            catch(Exception unused_ex) {
            }
            if(v > -1L) {
                q.a = v;
            }
        }
        String s1 = System.getProperty("KEY_CACHE_PATH");
        if(!TextUtils.isEmpty(s1)) {
            q.b = s1;
        }
        if("true".equalsIgnoreCase(System.getProperty("KEY_LOG_ON"))) {
            q.c = true;
        }
        String s2 = System.getProperty("KEY_FILE_LOG_ON");
        if("true".equalsIgnoreCase(s2)) {
            q.d = true;
        }
        String s3 = System.getProperty("KEY_LOG_LEVEL");
        if(!TextUtils.isEmpty(s3)) {
            try {
                v1 = -1;
                v1 = Integer.parseInt(s3.replaceAll(",", ""));
            }
            catch(Exception unused_ex) {
            }
            if(v1 > -1) {
                q.e = v1;
            }
        }
        d.o("load() - Cache Size: ", s, ", File Log: ", s2, ", Log Level: ").append(s3);
        f.b("PropertyLoader", "load() - Cache Size: null, File Log: null, Log Level: null");
    }
}

