package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri.Builder;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
@ShowFirstParty
public class GoogleApiAvailabilityLight {
    @KeepForSdk
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @KeepForSdk
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 0;
    @KeepForSdk
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    @KeepForSdk
    static final String TRACKING_SOURCE_DIALOG = "d";
    @KeepForSdk
    static final String TRACKING_SOURCE_NOTIFICATION = "n";
    private static final GoogleApiAvailabilityLight zza;

    static {
        GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        GoogleApiAvailabilityLight.zza = new GoogleApiAvailabilityLight();
    }

    @KeepForSdk
    public void cancelAvailabilityErrorNotifications(Context context0) {
        GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context0);
    }

    @KeepForSdk
    @ShowFirstParty
    public int getApkVersion(Context context0) {
        return GooglePlayServicesUtilLight.getApkVersion(context0);
    }

    @KeepForSdk
    @ShowFirstParty
    public int getClientVersion(Context context0) {
        return GooglePlayServicesUtilLight.getClientVersion(context0);
    }

    @KeepForSdk
    @ShowFirstParty
    @Deprecated
    public Intent getErrorResolutionIntent(int v) {
        return this.getErrorResolutionIntent(null, v, null);
    }

    @KeepForSdk
    @ShowFirstParty
    public Intent getErrorResolutionIntent(Context context0, int v, String s) {
        switch(v) {
            case 1: 
            case 2: {
                if(context0 != null && DeviceProperties.isWearableWithoutPlayStore(context0)) {
                    Intent intent0 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
                    intent0.setPackage("com.google.android.wearable.app");
                    return intent0;
                }
                StringBuilder stringBuilder0 = new StringBuilder("gcore_");
                stringBuilder0.append(GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                stringBuilder0.append("-");
                if(!TextUtils.isEmpty(s)) {
                    stringBuilder0.append(s);
                }
                stringBuilder0.append("-");
                if(context0 != null) {
                    stringBuilder0.append("com.iloen.melon");
                }
                stringBuilder0.append("-");
                if(context0 != null) {
                    try {
                        stringBuilder0.append(Wrappers.packageManager(context0).getPackageInfo("com.iloen.melon", 0).versionCode);
                    }
                    catch(PackageManager.NameNotFoundException unused_ex) {
                    }
                }
                String s1 = stringBuilder0.toString();
                Intent intent1 = new Intent("android.intent.action.VIEW");
                Uri.Builder uri$Builder0 = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
                if(!TextUtils.isEmpty(s1)) {
                    uri$Builder0.appendQueryParameter("pcampaignid", s1);
                }
                intent1.setData(uri$Builder0.build());
                intent1.setPackage("com.android.vending");
                intent1.addFlags(0x80000);
                return intent1;
            }
            case 3: {
                Uri uri0 = Uri.fromParts("package", "com.google.android.gms", null);
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(uri0);
                return intent2;
            }
            default: {
                return null;
            }
        }
    }

    @KeepForSdk
    public PendingIntent getErrorResolutionPendingIntent(Context context0, int v, int v1) {
        return this.getErrorResolutionPendingIntent(context0, v, v1, null);
    }

    @KeepForSdk
    @ShowFirstParty
    public PendingIntent getErrorResolutionPendingIntent(Context context0, int v, int v1, String s) {
        Intent intent0 = this.getErrorResolutionIntent(context0, v, s);
        return intent0 == null ? null : PendingIntent.getActivity(context0, v1, intent0, 0xC000000);
    }

    @KeepForSdk
    public String getErrorString(int v) {
        return GooglePlayServicesUtilLight.getErrorString(v);
    }

    @KeepForSdk
    @ShowFirstParty
    public static GoogleApiAvailabilityLight getInstance() {
        return GoogleApiAvailabilityLight.zza;
    }

    @KeepForSdk
    @HideFirstParty
    public int isGooglePlayServicesAvailable(Context context0) {
        return this.isGooglePlayServicesAvailable(context0, GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @KeepForSdk
    public int isGooglePlayServicesAvailable(Context context0, int v) {
        int v1 = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context0, v);
        return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context0, v1) ? 18 : v1;
    }

    @KeepForSdk
    @ShowFirstParty
    public boolean isPlayServicesPossiblyUpdating(Context context0, int v) {
        return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context0, v);
    }

    @KeepForSdk
    @ShowFirstParty
    public boolean isPlayStorePossiblyUpdating(Context context0, int v) {
        return GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context0, v);
    }

    @KeepForSdk
    public boolean isUninstalledAppPossiblyUpdating(Context context0, String s) {
        return GooglePlayServicesUtilLight.zza(context0, s);
    }

    @KeepForSdk
    public boolean isUserResolvableError(int v) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(v);
    }

    @KeepForSdk
    public void verifyGooglePlayServicesIsAvailable(Context context0, int v) {
        GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context0, v);
    }
}

