package com.iloen.melon.utils.system;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.iloen.melon.utils.log.LogU;
import k8.Y;

public class GooglePlayServiceUtils {
    public static int getClientGooglePlayServicesVersion(Context context0) {
        return GoogleApiAvailability.getInstance().getClientVersion(context0);
    }

    public static String getGooglePlayServicesVersionForLog(Context context0) {
        return Y.h(GooglePlayServiceUtils.getInstalledGooglePlayServicesVersion(context0), GooglePlayServiceUtils.getClientGooglePlayServicesVersion(context0), "installedGooglePlayServices: ", ", clientGooglePlayServices: ");
    }

    public static int getInstalledGooglePlayServicesVersion(Context context0) {
        return GoogleApiAvailability.getInstance().getApkVersion(context0);
    }

    public static boolean isEnable(Context context0) {
        GoogleApiAvailability googleApiAvailability0 = GoogleApiAvailability.getInstance();
        if(googleApiAvailability0 == null) {
            LogU.d("GooglePlayServiceUtils", "GooglePlayService is not available");
            return false;
        }
        if(googleApiAvailability0.isGooglePlayServicesAvailable(context0) == 0) {
            LogU.d("GooglePlayServiceUtils", "GooglePlayService is available");
            return true;
        }
        LogU.d("GooglePlayServiceUtils", "GooglePlayService is not available");
        return false;
    }
}

