package com.google.android.gms.common.stats;

import A7.d;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import b3.Z;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.List;
import javax.annotation.Nullable;

@KeepForSdk
@Class(creator = "WakeLockEventCreator")
@Deprecated
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator CREATOR;
    @VersionField(id = 1)
    final int zza;
    @Field(getter = "getTimeMillis", id = 2)
    private final long zzb;
    @Field(getter = "getEventType", id = 11)
    private final int zzc;
    @Field(getter = "getWakeLockName", id = 4)
    private final String zzd;
    @Field(getter = "getSecondaryWakeLockName", id = 10)
    private final String zze;
    @Field(getter = "getCodePackage", id = 17)
    private final String zzf;
    @Field(getter = "getWakeLockType", id = 5)
    private final int zzg;
    @Field(getter = "getCallingPackages", id = 6)
    @Nullable
    private final List zzh;
    @Field(getter = "getEventKey", id = 12)
    private final String zzi;
    @Field(getter = "getElapsedRealtime", id = 8)
    private final long zzj;
    @Field(getter = "getDeviceState", id = 14)
    private final int zzk;
    @Field(getter = "getHostPackage", id = 13)
    private final String zzl;
    @Field(getter = "getBeginPowerPercentage", id = 15)
    private final float zzm;
    @Field(getter = "getTimeout", id = 16)
    private final long zzn;
    @Field(getter = "getAcquiredWithTimeout", id = 18)
    private final boolean zzo;

    static {
        WakeLockEvent.CREATOR = new zza();
    }

    @Constructor
    public WakeLockEvent(@Param(id = 1) int v, @Param(id = 2) long v1, @Param(id = 11) int v2, @Param(id = 4) String s, @Param(id = 5) int v3, @Param(id = 6) @Nullable List list0, @Param(id = 12) String s1, @Param(id = 8) long v4, @Param(id = 14) int v5, @Param(id = 10) String s2, @Param(id = 13) String s3, @Param(id = 15) float f, @Param(id = 16) long v6, @Param(id = 17) String s4, @Param(id = 18) boolean z) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = v2;
        this.zzd = s;
        this.zze = s2;
        this.zzf = s4;
        this.zzg = v3;
        this.zzh = list0;
        this.zzi = s1;
        this.zzj = v4;
        this.zzk = v5;
        this.zzl = s3;
        this.zzm = f;
        this.zzn = v6;
        this.zzo = z;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeLong(parcel0, 2, this.zzb);
        SafeParcelWriter.writeString(parcel0, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel0, 5, this.zzg);
        SafeParcelWriter.writeStringList(parcel0, 6, this.zzh, false);
        SafeParcelWriter.writeLong(parcel0, 8, this.zzj);
        SafeParcelWriter.writeString(parcel0, 10, this.zze, false);
        SafeParcelWriter.writeInt(parcel0, 11, this.zzc);
        SafeParcelWriter.writeString(parcel0, 12, this.zzi, false);
        SafeParcelWriter.writeString(parcel0, 13, this.zzl, false);
        SafeParcelWriter.writeInt(parcel0, 14, this.zzk);
        SafeParcelWriter.writeFloat(parcel0, 15, this.zzm);
        SafeParcelWriter.writeLong(parcel0, 16, this.zzn);
        SafeParcelWriter.writeString(parcel0, 17, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel0, 18, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Override  // com.google.android.gms.common.stats.StatsEvent
    public final long zza() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.common.stats.StatsEvent
    public final int zzb() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.common.stats.StatsEvent
    public final String zzc() {
        String s = "";
        String s1 = this.zzh == null ? "" : TextUtils.join(",", this.zzh);
        int v = this.zzk;
        String s2 = this.zze;
        String s3 = this.zzl;
        float f = this.zzm;
        String s4 = this.zzf;
        int v1 = this.zzg;
        String s5 = this.zzd;
        boolean z = this.zzo;
        int v2 = String.valueOf(s5).length();
        int v3 = String.valueOf(v1).length();
        int v4 = String.valueOf(s1).length();
        int v5 = String.valueOf(v).length();
        if(s2 == null) {
            s2 = "";
        }
        int v6 = Z.d(v2 + v3 + v4 + v5 + 5, 1, s2);
        if(s3 == null) {
            s3 = "";
        }
        int v7 = Z.d(v6, 1, s3);
        int v8 = String.valueOf(f).length();
        if(s4 != null) {
            s = s4;
        }
        StringBuilder stringBuilder0 = new StringBuilder(Z.d(v8 + v7 + 1, 1, s) + String.valueOf(z).length());
        stringBuilder0.append("\t");
        stringBuilder0.append(s5);
        stringBuilder0.append("\t");
        stringBuilder0.append(v1);
        stringBuilder0.append("\t");
        stringBuilder0.append(s1);
        stringBuilder0.append("\t");
        stringBuilder0.append(v);
        d.u(stringBuilder0, "\t", s2, "\t", s3);
        stringBuilder0.append("\t");
        stringBuilder0.append(f);
        stringBuilder0.append("\t");
        stringBuilder0.append(s);
        stringBuilder0.append("\t");
        stringBuilder0.append(z);
        return stringBuilder0.toString();
    }
}

