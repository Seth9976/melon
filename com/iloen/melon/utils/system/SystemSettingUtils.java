package com.iloen.melon.utils.system;

import N1.z;
import android.app.Activity;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.PowerManager;

@Deprecated(since = "2024-07-23")
public class SystemSettingUtils {
    public static final int REQUEST_CODE_BATTERY_OPTIMIZATION = 1001;

    public static boolean areNotificationsEnabled(Context context0) {
        return new z(context0).b.areNotificationsEnabled();
    }

    public static long getAvailMemoryMB(Context context0) {
        ActivityManager activityManager0 = (ActivityManager)context0.getSystemService("activity");
        ActivityManager.MemoryInfo activityManager$MemoryInfo0 = new ActivityManager.MemoryInfo();
        activityManager0.getMemoryInfo(activityManager$MemoryInfo0);
        return activityManager$MemoryInfo0.availMem / 0x100000L;
    }

    public static Intent getLaunchAppInfoIntent(String s) {
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.parse(("package:" + s)));
    }

    public static boolean isAvailableBackgroundData(Context context0) {
        switch(((ConnectivityManager)context0.getSystemService("connectivity")).getRestrictBackgroundStatus()) {
            case 1: 
            case 2: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static boolean isBackgroundRestricted(Context context0) {
        return a.v(((ActivityManager)context0.getSystemService("activity")));
    }

    public static boolean isIgnoringBatteryOptimizations(Context context0) {
        return ((PowerManager)context0.getSystemService("power")).isIgnoringBatteryOptimizations("com.iloen.melon");
    }

    public static boolean isPowerSaveMode(Context context0) {
        return ((PowerManager)context0.getSystemService("power")).isPowerSaveMode();
    }

    public static void openBatteryOptimizationsInSetting(Activity activity0) {
        if(((PowerManager)activity0.getSystemService("power")).isIgnoringBatteryOptimizations("com.iloen.melon")) {
            return;
        }
        Intent intent0 = new Intent();
        intent0.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent0.setData(Uri.parse("package:com.iloen.melon"));
        activity0.startActivityForResult(intent0, 1001);
    }
}

