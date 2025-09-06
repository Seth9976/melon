package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule;
import com.iloen.melon.utils.a;
import java.security.MessageDigest;

final class zzo {
    static final zzm zza;
    static final zzm zzb;
    static final zzm zzc;
    static final zzm zzd;
    static final zzm zze;
    static final zzm zzf;
    static volatile zzad zzg;
    public static final int zzh;
    private static final Object zzi;
    private static Context zzj;

    static {
        zzo.zza = new zzd(new byte[]{0x30, (byte)0x82, 5, -56, 0x30, (byte)0x82, 3, -80, (byte)0xA0, 3, 2, 1, 2, 2, 20, 0x7F, -94, 102, -6, -89, 0x70, (byte)0x85, 120, 98, (byte)0xB1});
        zzo.zzb = new zze(new byte[]{0x30, (byte)0x82, 6, 4, 0x30, (byte)0x82, 3, -20, (byte)0xA0, 3, 2, 1, 2, 2, 20, 81, -43, -37, 4, -9, 88, -25, 66, (byte)0x86, 60});
        zzo.zzc = new zzf(new byte[]{0x30, (byte)0x82, 5, -56, 0x30, (byte)0x82, 3, -80, (byte)0xA0, 3, 2, 1, 2, 2, 20, 16, (byte)0x8A, 101, 8, 0x73, -7, 0x2F, (byte)0x8E, 81, -19});
        zzo.zzd = new zzg(new byte[]{0x30, (byte)0x82, 6, 4, 0x30, (byte)0x82, 3, -20, (byte)0xA0, 3, 2, 1, 2, 2, 20, 3, -93, -78, -83, -41, (byte)0xE1, 0x72, -54, 107, -20});
        zzo.zze = new zzh(new byte[]{0x30, (byte)0x82, 4, 67, 0x30, (byte)0x82, 3, 43, (byte)0xA0, 3, 2, 1, 2, 2, 9, 0, -62, (byte)0xE0, (byte)0x87, 70, 100, 74, 0x30, (byte)0x8D, 0x30});
        zzo.zzf = new zzi(new byte[]{0x30, (byte)0x82, 4, -88, 0x30, (byte)0x82, 3, (byte)0x90, (byte)0xA0, 3, 2, 1, 2, 2, 9, 0, -43, (byte)0x85, -72, 108, 0x7D, -45, 78, -11, 0x30});
        zzo.zzi = new Object();
    }

    public static void zza(Context context0) {
        synchronized(zzo.class) {
            if(zzo.zzj == null) {
                if(context0 != null) {
                    zzo.zzj = context0.getApplicationContext();
                    return;
                }
                return;
            }
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        }
    }

    public static void zzb() {
        if(zzo.zzg != null) {
            return;
        }
        Preconditions.checkNotNull(zzo.zzj);
        synchronized(zzo.zzi) {
            if(zzo.zzg == null) {
                zzo.zzg = zzac.zzb(DynamiteModule.load(zzo.zzj, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
            }
        }
    }

    public static zzy zzc(zzw zzw0) {
        zzr zzr0;
        zzy zzy0;
        StrictMode.ThreadPolicy strictMode$ThreadPolicy0 = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(zzo.zzj);
            try {
                zzo.zzb();
            }
            catch(LoadingException dynamiteModule$LoadingException0) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", dynamiteModule$LoadingException0);
                return zzy.zzd(("module init: " + dynamiteModule$LoadingException0.getMessage()), dynamiteModule$LoadingException0);
            }
            Preconditions.checkNotNull(zzo.zzj);
            zzp zzp0 = zzw0.zzb(zzo.zzj);
            try {
                zzr0 = zzw0.zza() ? zzo.zzg.zzf(zzp0) : zzo.zzg.zzh(zzp0);
            }
            catch(RemoteException remoteException0) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", remoteException0);
                return zzy.zzd("module call", remoteException0);
            }
            if(zzr0.zza()) {
                zzy0 = zzy.zzf(zzr0.zze(), zzr0.zzc());
            }
            else {
                String s = zzr0.zzb();
                PackageManager.NameNotFoundException packageManager$NameNotFoundException0 = zzr0.zzd() == 4 ? new PackageManager.NameNotFoundException() : null;
                if(s == null) {
                    s = "error checking package certificate";
                }
                zzy0 = zzy.zzg(zzr0.zze(), zzr0.zzd(), s, packageManager$NameNotFoundException0);
            }
            return zzy0;
        }
        finally {
            StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
        }
    }

    @Deprecated
    public static zzy zzd(String s, zzj zzj0, boolean z, boolean z1) {
        StrictMode.ThreadPolicy strictMode$ThreadPolicy0 = StrictMode.allowThreadDiskReads();
        try {
            return zzo.zzf(s, zzj0, z, z1);
        }
        finally {
            StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
        }
    }

    // 检测为 Lambda 实现
    public static String zze(boolean z, String s, zzj zzj0) [...]

    @Deprecated
    private static zzy zzf(String s, zzj zzj0, boolean z, boolean z1) {
        try {
            zzo.zzb();
        }
        catch(LoadingException dynamiteModule$LoadingException0) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", dynamiteModule$LoadingException0);
            return zzy.zzd(("module init: " + dynamiteModule$LoadingException0.getMessage()), dynamiteModule$LoadingException0);
        }
        Preconditions.checkNotNull(zzo.zzj);
        zzt zzt0 = new zzt(s, zzj0, z, z1);
        try {
            if(zzo.zzg.zze(zzt0, ObjectWrapper.wrap(zzo.zzj.getPackageManager()))) {
                return zzy.zzb();
            }
        }
        catch(RemoteException remoteException0) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", remoteException0);
            return zzy.zzd("module call", remoteException0);
        }
        return new zzx(() -> {
            String s1 = z || !zzo.zzf(s, zzj0, true, false).zza ? "not allowed" : "debug cert rejected";
            MessageDigest messageDigest0 = AndroidUtilsLight.zza("SHA-256");
            Preconditions.checkNotNull(messageDigest0);
            StringBuilder stringBuilder0 = a.o(s1, ": pkg=", s, ", sha256=", Hex.bytesToStringLowercase(messageDigest0.digest(zzj0.zzc())));
            stringBuilder0.append(", atk=");
            stringBuilder0.append(z);
            stringBuilder0.append(", ver=12451000.false");
            return stringBuilder0.toString();
        }, null);
    }
}

