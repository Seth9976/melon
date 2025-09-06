package com.iloen.melon.utils.system;

import A8.K;
import R8.q;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Build;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import e1.u;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import va.e0;
import va.o;

public class EnvironmentUtils {
    public static class Info {
        public static final int APP_VERSION = 1003;
        public static final int DEVICE_MODEL = 1001;
        public static final int DEVICE_TYPE = 1000;
        public static final int DRM_TYPE = 1005;
        public static final int LOGIN_STATUS = 1006;
        public static final int MEMBER_KEY = 1007;
        public static final int OS_VERSION = 1002;
        public static final int TELEPHONY_SERVICE = 1004;

    }

    @Retention(RetentionPolicy.SOURCE)
    @interface InfoType {
    }

    public static final K a;
    public static final K b;
    public static final HashMap c;

    static {
        EnvironmentUtils.a = K.b;
        EnvironmentUtils.b = K.c;
        EnvironmentUtils.c = new HashMap();
    }

    public static String a(Context context0, int v) {
        switch(v) {
            case 1000: {
                return "DEVICE_TYPE: " + MelonAppBase.instance.getDeviceData().c.a;
            }
            case 1001: {
                return "DEVICE_MODEL: " + Build.MODEL;
            }
            case 1002: {
                return "OS_VERSION: " + Build.VERSION.RELEASE;
            }
            case 1003: {
                return "APP_VERSION: " + AppUtils.getVersionName(context0);
            }
            case 1004: {
                return MelonAppBase.instance.getDeviceData().j() ? "TELEPHONY_SERVICE: 0" : "TELEPHONY_SERVICE: 1";
            }
            case 1005: {
                return "DRM_TYPE: " + ((int)q.a.c());
            }
            case 1006: {
                return "IS_LOGIN: " + ((e0)o.a()).m();
            }
            case 1007: {
                return "MEMBER_KEY: " + u.v(((e0)o.a()).j());
            }
            default: {
                return "Unknown type";
            }
        }
    }

    public static String getEnvironmentInfo(Context context0) {
        return EnvironmentUtils.getEnvironmentInfo(context0, new int[]{1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007});
    }

    public static String getEnvironmentInfo(Context context0, String s, int[] arr_v) {
        String s2;
        if(TextUtils.isEmpty(s)) {
            s = "\r\n";
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < arr_v.length; ++v) {
            int v1 = arr_v[v];
            if(stringBuilder0.length() > 0) {
                stringBuilder0.append(s);
            }
            if(v1 == 1006 || v1 == 1007) {
                s2 = EnvironmentUtils.a(context0, v1);
            }
            else {
                HashMap hashMap0 = EnvironmentUtils.c;
                String s1 = (String)hashMap0.get(String.valueOf(v1));
                if(TextUtils.isEmpty(s1)) {
                    s2 = EnvironmentUtils.a(context0, v1);
                    hashMap0.put(String.valueOf(v1), s2);
                }
                else {
                    s2 = s1;
                }
            }
            stringBuilder0.append(s2);
        }
        return stringBuilder0.toString();
    }

    public static String getEnvironmentInfo(Context context0, int[] arr_v) {
        return EnvironmentUtils.getEnvironmentInfo(context0, "\r\n", arr_v);
    }
}

