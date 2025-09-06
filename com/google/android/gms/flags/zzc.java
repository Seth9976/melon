package com.google.android.gms.flags;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.flags.zza;

public final class zzc extends zza implements zze {
    public zzc(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.flags.IFlagProvider");
    }

    @Override  // com.google.android.gms.flags.zze
    public final boolean getBooleanFlagValue(String s, boolean z, int v) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        com.google.android.gms.internal.flags.zzc.zza(parcel0, z);
        parcel0.writeInt(v);
        Parcel parcel1 = this.zzb(2, parcel0);
        boolean z1 = com.google.android.gms.internal.flags.zzc.zzc(parcel1);
        parcel1.recycle();
        return z1;
    }

    @Override  // com.google.android.gms.flags.zze
    public final int getIntFlagValue(String s, int v, int v1) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeInt(v);
        parcel0.writeInt(v1);
        Parcel parcel1 = this.zzb(3, parcel0);
        int v2 = parcel1.readInt();
        parcel1.recycle();
        return v2;
    }

    @Override  // com.google.android.gms.flags.zze
    public final long getLongFlagValue(String s, long v, int v1) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeLong(v);
        parcel0.writeInt(v1);
        Parcel parcel1 = this.zzb(4, parcel0);
        long v2 = parcel1.readLong();
        parcel1.recycle();
        return v2;
    }

    @Override  // com.google.android.gms.flags.zze
    public final String getStringFlagValue(String s, String s1, int v) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeInt(v);
        Parcel parcel1 = this.zzb(5, parcel0);
        String s2 = parcel1.readString();
        parcel1.recycle();
        return s2;
    }

    @Override  // com.google.android.gms.flags.zze
    public final void init(IObjectWrapper iObjectWrapper0) {
        Parcel parcel0 = this.zza();
        com.google.android.gms.internal.flags.zzc.zzb(parcel0, iObjectWrapper0);
        this.zzc(1, parcel0);
    }
}

