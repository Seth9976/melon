package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@KeepForSdk
@ShowFirstParty
public class GooglePlayServicesUtilLight {
    @KeepForSdk
    static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
    @KeepForSdk
    static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 0x9B6D;
    @KeepForSdk
    public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
    @KeepForSdk
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @KeepForSdk
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    @KeepForSdk
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    @KeepForSdk
    public static final String GOOGLE_SERVICES_FRAMEWORK_PACKAGE = "com.google.android.gsf";
    @KeepForSdk
    @Deprecated
    static final AtomicBoolean sCanceledAvailabilityNotification = null;
    public static boolean zza = false;
    public static boolean zzb = false;
    private static final AtomicBoolean zzc;

    static {
        GooglePlayServicesUtilLight.sCanceledAvailabilityNotification = new AtomicBoolean();
        GooglePlayServicesUtilLight.zzc = new AtomicBoolean();
    }

    @KeepForSdk
    @Deprecated
    public static void cancelAvailabilityErrorNotifications(Context context0) {
        if(GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.getAndSet(true)) {
            return;
        }
        else {
            try {
                NotificationManager notificationManager0 = (NotificationManager)context0.getSystemService("notification");
                if(notificationManager0 != null) {
                    notificationManager0.cancel(10436);
                }
                return;
            }
            catch(SecurityException securityException0) {
            }
        }
        Log.d("GooglePlayServicesUtil", "Suppressing Security Exception %s in cancelAvailabilityErrorNotifications.", securityException0);
    }

    @KeepForSdk
    @ShowFirstParty
    public static void enableUsingApkIndependentContext() {
        GooglePlayServicesUtilLight.zzc.set(true);
    }

    @KeepForSdk
    @Deprecated
    public static void ensurePlayServicesAvailable(Context context0, int v) {
        int v1 = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context0, v);
        if(v1 != 0) {
            Intent intent0 = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(context0, v1, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + v1);
            if(intent0 != null) {
                throw new GooglePlayServicesRepairableException(v1, "Google Play Services not available", intent0);
            }
            throw new GooglePlayServicesNotAvailableException(v1);
        }
        return;
    }

    @KeepForSdk
    @ShowFirstParty
    @Deprecated
    public static int getApkVersion(Context context0) {
        try {
            return context0.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @KeepForSdk
    @ShowFirstParty
    @Deprecated
    public static int getClientVersion(Context context0) {
        Preconditions.checkState(true);
        return ClientLibraryUtils.getClientVersion(context0, "com.iloen.melon");
    }

    @KeepForSdk
    @Deprecated
    public static PendingIntent getErrorPendingIntent(int v, Context context0, int v1) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context0, v, v1);
    }

    @KeepForSdk
    @Deprecated
    public static String getErrorString(int v) {
        return ConnectionResult.zza(v);
    }

    @KeepForSdk
    @ShowFirstParty
    @Deprecated
    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int v) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, v, null);
    }

    @KeepForSdk
    public static Context getRemoteContext(Context context0) {
        try {
            return context0.createPackageContext("com.google.android.gms", 3);
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return null;
        }
    }

    @KeepForSdk
    public static Resources getRemoteResource(Context context0) {
        try {
            return context0.getPackageManager().getResourcesForApplication("com.google.android.gms");
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return null;
        }
    }

    @KeepForSdk
    @ShowFirstParty
    public static boolean honorsDebugCertificates(Context context0) {
        if(!GooglePlayServicesUtilLight.zzb) {
            try {
                PackageInfo packageInfo0 = Wrappers.packageManager(context0).getPackageInfo("com.google.android.gms", (Build.VERSION.SDK_INT < 28 ? 0x40 : 0x8000040));
                GoogleSignatureVerifier.getInstance(context0);
                GooglePlayServicesUtilLight.zza = packageInfo0 == null || GoogleSignatureVerifier.zza(packageInfo0, false) || !GoogleSignatureVerifier.zza(packageInfo0, true) ? false : true;
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", packageManager$NameNotFoundException0);
            }
            finally {
                GooglePlayServicesUtilLight.zzb = true;
            }
        }
        return GooglePlayServicesUtilLight.zza || !DeviceProperties.isUserBuild();
    }

    @KeepForSdk
    @HideFirstParty
    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context0) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context0, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @KeepForSdk
    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context0, int v) {
        PackageInfo packageInfo1;
        PackageInfo packageInfo0;
        try {
            context0.getResources().getString(string.common_google_play_services_unknown_issue);
        }
        catch(Throwable unused_ex) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if(!GooglePlayServicesUtilLight.zzc.get()) {
            int v1 = zzae.zzb(context0);
            if(v1 == 0) {
                throw new GooglePlayServicesMissingManifestValueException();
            }
            if(v1 != GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                throw new GooglePlayServicesIncorrectManifestValueException(v1);
            }
        }
        boolean z = !DeviceProperties.isWearableWithoutPlayStore(context0) && !DeviceProperties.zzd(context0);
        Preconditions.checkArgument(v >= 0);
        PackageManager packageManager0 = context0.getPackageManager();
        if(z) {
            try {
                packageInfo0 = packageManager0.getPackageInfo("com.android.vending", (Build.VERSION.SDK_INT < 28 ? 0x2040 : 0x8002040));
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
                Log.w("GooglePlayServicesUtil", "com.iloen.melon requires the Google Play Store, but it is missing.");
                return 9;
            }
        }
        else {
            packageInfo0 = null;
        }
        try {
            packageInfo1 = packageManager0.getPackageInfo("com.google.android.gms", (Build.VERSION.SDK_INT < 28 ? 0x40 : 0x8000040));
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            Log.w("GooglePlayServicesUtil", "com.iloen.melon requires Google Play services, but they are missing.");
            return 1;
        }
        GoogleSignatureVerifier.getInstance(context0);
        if(!GoogleSignatureVerifier.zza(packageInfo1, true)) {
            Log.w("GooglePlayServicesUtil", "com.iloen.melon requires Google Play services, but their signature is invalid.");
            return 9;
        }
        if(z) {
            Preconditions.checkNotNull(packageInfo0);
            if(!GoogleSignatureVerifier.zza(packageInfo0, true)) {
                Log.w("GooglePlayServicesUtil", "com.iloen.melon requires Google Play Store, but its signature is invalid.");
                return 9;
            }
        }
        if(z && packageInfo0 != null && !packageInfo0.signatures[0].equals(packageInfo1.signatures[0])) {
            Log.w("GooglePlayServicesUtil", "com.iloen.melon requires Google Play Store, but its signature doesn\'t match that of Google Play services.");
            return 9;
        }
        if(zzb.zza(packageInfo1.versionCode) < zzb.zza(v)) {
            Log.w("GooglePlayServicesUtil", "Google Play services out of date for com.iloen.melon.  Requires " + v + " but found " + packageInfo1.versionCode);
            return 2;
        }
        ApplicationInfo applicationInfo0 = packageInfo1.applicationInfo;
        if(applicationInfo0 == null) {
            try {
                return packageManager0.getApplicationInfo("com.google.android.gms", 0).enabled ? 0 : 3;
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                Log.wtf("GooglePlayServicesUtil", "com.iloen.melon requires Google Play services, but they\'re missing when getting application info.", packageManager$NameNotFoundException0);
                return 1;
            }
        }
        return applicationInfo0.enabled ? 0 : 3;
    }

    @KeepForSdk
    @Deprecated
    public static boolean isGooglePlayServicesUid(Context context0, int v) {
        return UidVerifier.isGooglePlayServicesUid(context0, v);
    }

    @KeepForSdk
    @ShowFirstParty
    @Deprecated
    public static boolean isPlayServicesPossiblyUpdating(Context context0, int v) {
        switch(v) {
            case 1: {
                return GooglePlayServicesUtilLight.zza(context0, "com.google.android.gms");
            }
            case 18: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    @KeepForSdk
    @ShowFirstParty
    @Deprecated
    public static boolean isPlayStorePossiblyUpdating(Context context0, int v) {
        return v == 9 ? GooglePlayServicesUtilLight.zza(context0, "com.android.vending") : false;
    }

    @TargetApi(18)
    @KeepForSdk
    public static boolean isRestrictedUserProfile(Context context0) {
        Object object0 = context0.getSystemService("user");
        Preconditions.checkNotNull(object0);
        Bundle bundle0 = ((UserManager)object0).getApplicationRestrictions("com.iloen.melon");
        return bundle0 != null && "true".equals(bundle0.getString("restricted_profile"));
    }

    @KeepForSdk
    @ShowFirstParty
    @Deprecated
    public static boolean isSidewinderDevice(Context context0) {
        return DeviceProperties.isSidewinder(context0);
    }

    @KeepForSdk
    @Deprecated
    public static boolean isUserRecoverableError(int v) {
        return v == 1 || v == 2 || v == 3 || v == 9;
    }

    @TargetApi(19)
    @KeepForSdk
    @Deprecated
    public static boolean uidHasPackageName(Context context0, int v, String s) {
        return UidVerifier.uidHasPackageName(context0, v, s);
    }

    @TargetApi(21)
    public static boolean zza(Context context0, String s) {
        boolean z = s.equals("com.google.android.gms");
        try {
            List list0 = context0.getPackageManager().getPackageInstaller().getAllSessions();
        }
        catch(Exception unused_ex) {
            return false;
        }
        for(Object object0: list0) {
            if(s.equals(((PackageInstaller.SessionInfo)object0).getAppPackageName())) {
                return true;
            }
            if(false) {
                break;
            }
        }
        PackageManager packageManager0 = context0.getPackageManager();
        try {
            ApplicationInfo applicationInfo0 = packageManager0.getApplicationInfo(s, 0x2000);
            if(z) {
                return applicationInfo0.enabled;
            }
            if(applicationInfo0.enabled && !GooglePlayServicesUtilLight.isRestrictedUserProfile(context0)) {
                return true;
            }
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        return false;
    }
}

