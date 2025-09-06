package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@KeepForSdk
@ShowFirstParty
public class AndroidUtilsLight {
    public static final int zza = 0;
    private static volatile int zzb = -1;
    private static volatile zza zzc;
    private static final Object zzd;

    static {
        AndroidUtilsLight.zzd = new Object();
    }

    @KeepForSdk
    @Deprecated
    public static byte[] getPackageCertificateHashBytes(Context context0, String s) {
        PackageInfo packageInfo0 = Wrappers.packageManager(context0).getPackageInfo(s, 0x40);
        if(packageInfo0.signatures != null && packageInfo0.signatures.length == 1) {
            MessageDigest messageDigest0 = AndroidUtilsLight.zza("SHA1");
            return messageDigest0 == null ? null : messageDigest0.digest(packageInfo0.signatures[0].toByteArray());
        }
        return null;
    }

    public static MessageDigest zza(String s) {
        for(int v = 0; v < 2; ++v) {
            try {
                MessageDigest messageDigest0 = MessageDigest.getInstance(s);
                if(messageDigest0 != null) {
                    return messageDigest0;
                }
            }
            catch(NoSuchAlgorithmException unused_ex) {
            }
        }
        return null;
    }
}

