package com.kakao.tiara.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.kakao.tiara.TiaraSettings;
import java.util.Locale;
import java.util.TimeZone;

class Env {
    private String app_version;
    private String carrier;
    private String language;
    private String model;
    private String network_state;
    private String os;
    private String os_version;
    private String screen;
    private String tz;

    public static Env from(Context context0, TiaraSettings tiaraSettings0) {
        Env env0 = new Env();
        env0.app_version = tiaraSettings0.getAppVersion();
        env0.os = "android";
        env0.os_version = Build.VERSION.RELEASE;
        env0.model = Build.MODEL;
        env0.language = Locale.getDefault().getLanguage();
        int v = (TimeZone.getDefault().getRawOffset() + 1) / 3600000;
        env0.tz = v < 0 ? "8" : "+" + v;
        TelephonyManager telephonyManager0 = (TelephonyManager)context0.getSystemService("phone");
        if(telephonyManager0 != null) {
            env0.carrier = telephonyManager0.getNetworkOperator();
        }
        ConnectivityManager connectivityManager0 = (ConnectivityManager)context0.getSystemService("connectivity");
        if(connectivityManager0 != null) {
            NetworkInfo networkInfo0 = connectivityManager0.getActiveNetworkInfo();
            if(networkInfo0 == null || !networkInfo0.isConnected()) {
                env0.network_state = "offline";
            }
            else if(!TextUtils.isEmpty(networkInfo0.getTypeName())) {
                env0.network_state = networkInfo0.getTypeName().toLowerCase();
            }
        }
        DisplayMetrics displayMetrics0 = context0.getResources().getDisplayMetrics();
        env0.screen = displayMetrics0.widthPixels + "x" + displayMetrics0.heightPixels;
        return env0;
    }
}

