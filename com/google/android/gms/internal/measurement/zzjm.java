package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

public final class zzjm {
    private static UserManager zza;
    private static volatile boolean zzb;

    static {
        zzjm.zzb = false;
    }

    public static boolean zza() [...] // Inlined contents

    public static boolean zzb(Context context0) {
        return !zzjm.zzd(context0);
    }

    public static boolean zzc(Context context0) {
        return zzjm.zzd(context0);
    }

    @TargetApi(24)
    private static boolean zzd(Context context0) {
        boolean z;
        if(zzjm.zzb) {
            return true;
        }
        synchronized(zzjm.class) {
            if(zzjm.zzb) {
                return true;
            }
            int v1 = 1;
            while(true) {
                z = false;
                if(zzjm.zza == null) {
                    zzjm.zza = (UserManager)context0.getSystemService(UserManager.class);
                }
                UserManager userManager0 = zzjm.zza;
                if(userManager0 == null) {
                    z = true;
                    goto label_28;
                }
                try {
                    if(!userManager0.isUserUnlocked() && userManager0.isUserRunning(Process.myUserHandle())) {
                        goto label_26;
                    }
                    break;
                }
                catch(NullPointerException nullPointerException0) {
                    Log.w("DirectBootUtils", "Failed to check if user is unlocked.", nullPointerException0);
                    zzjm.zza = null;
                    ++v1;
                }
            }
            z = true;
        label_26:
            if(z) {
                zzjm.zza = null;
            }
        label_28:
            if(z) {
                zzjm.zzb = true;
            }
            return z;
        }
    }
}

