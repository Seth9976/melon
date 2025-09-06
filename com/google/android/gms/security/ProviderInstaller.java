package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.common.zzh;
import com.google.android.gms.internal.common.zzi;
import com.google.android.gms.internal.common.zzj;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public interface ProviderInstallListener {
        void onProviderInstallFailed(int arg1, Intent arg2);

        void onProviderInstalled();
    }

    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final GoogleApiAvailabilityLight zza;
    private static final Object zzb;
    private static Method zzc;
    private static boolean zzd;

    static {
        ProviderInstaller.zza = GoogleApiAvailabilityLight.getInstance();
        ProviderInstaller.zzb = new Object();
        ProviderInstaller.zzc = null;
        ProviderInstaller.zzd = false;
    }

    public static void installIfNeeded(Context context0) {
        Context context2;
        Context context1 = null;
        Preconditions.checkNotNull(context0, "Context must not be null");
        ProviderInstaller.zza.verifyGooglePlayServicesIsAvailable(context0, 11925000);
        long v = SystemClock.uptimeMillis();
        synchronized(ProviderInstaller.zzb) {
            if(!ProviderInstaller.zzd) {
                try {
                    context2 = DynamiteModule.load(context0, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.providerinstaller.dynamite").getModuleContext();
                }
                catch(LoadingException dynamiteModule$LoadingException0) {
                    Log.w("ProviderInstaller", "Failed to load providerinstaller module: " + dynamiteModule$LoadingException0.getMessage());
                    context2 = null;
                }
                if(context2 != null) {
                    ProviderInstaller.zzb(context2, context0, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
                    return;
                }
            }
            boolean z = ProviderInstaller.zzd;
            Context context3 = GooglePlayServicesUtilLight.getRemoteContext(context0);
            if(context3 != null) {
                ProviderInstaller.zzd = true;
                if(!z) {
                    try {
                        long v2 = SystemClock.uptimeMillis();
                        zzj.zzb("com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats2", context3.getClassLoader(), new zzi[]{zzi.zzb(Context.class, context0), zzh.zza(v), zzh.zza(v2)});
                    }
                    catch(Exception exception0) {
                        Log.w("ProviderInstaller", "Failed to report request stats: " + exception0.toString());
                    }
                }
                context1 = context3;
            }
            if(context1 != null) {
                ProviderInstaller.zzb(context1, context0, "com.google.android.gms.common.security.ProviderInstallerImpl");
                return;
            }
            Log.e("ProviderInstaller", "Failed to get remote context");
        }
        throw new GooglePlayServicesNotAvailableException(8);
    }

    public static void installIfNeededAsync(Context context0, ProviderInstallListener providerInstaller$ProviderInstallListener0) {
        Preconditions.checkNotNull(context0, "Context must not be null");
        Preconditions.checkNotNull(providerInstaller$ProviderInstallListener0, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(context0, providerInstaller$ProviderInstallListener0).execute(new Void[0]);
    }

    private static void zzb(Context context0, Context context1, String s) {
        try {
            if(ProviderInstaller.zzc == null) {
                ProviderInstaller.zzc = context0.getClassLoader().loadClass(s).getMethod("insertProvider", Context.class);
            }
            ProviderInstaller.zzc.invoke(null, context0);
        }
        catch(Exception exception0) {
            Throwable throwable0 = exception0.getCause();
            if(Log.isLoggable("ProviderInstaller", 6)) {
                Log.e("ProviderInstaller", "Failed to install provider: " + (throwable0 == null ? exception0.toString() : throwable0.toString()));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }
}

