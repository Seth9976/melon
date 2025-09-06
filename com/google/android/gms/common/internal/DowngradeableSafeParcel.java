package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    private static final Object zza;
    private boolean zzb;

    static {
        DowngradeableSafeParcel.zza = new Object();
    }

    public DowngradeableSafeParcel() {
        this.zzb = false;
    }

    @KeepForSdk
    public static boolean canUnparcelSafely(String s) {
        synchronized(DowngradeableSafeParcel.zza) {
        }
        return true;
    }

    @KeepForSdk
    public static Integer getUnparcelClientVersion() {
        synchronized(DowngradeableSafeParcel.zza) {
        }
        return null;
    }

    @KeepForSdk
    public abstract boolean prepareForClientVersion(int arg1);

    @KeepForSdk
    public void setShouldDowngrade(boolean z) {
        this.zzb = z;
    }

    @KeepForSdk
    public boolean shouldDowngrade() {
        return this.zzb;
    }
}

