package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "ConditionalUserPropertyParcelCreator")
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(id = 2)
    public String zza;
    @Field(id = 3)
    public String zzb;
    @Field(id = 4)
    public zzpk zzc;
    @Field(id = 5)
    public long zzd;
    @Field(id = 6)
    public boolean zze;
    @Field(id = 7)
    public String zzf;
    @Field(id = 8)
    public final zzbg zzg;
    @Field(id = 9)
    public long zzh;
    @Field(id = 10)
    public zzbg zzi;
    @Field(id = 11)
    public final long zzj;
    @Field(id = 12)
    public final zzbg zzk;

    static {
        zzah.CREATOR = new zzai();
    }

    public zzah(zzah zzah0) {
        Preconditions.checkNotNull(zzah0);
        this.zza = zzah0.zza;
        this.zzb = zzah0.zzb;
        this.zzc = zzah0.zzc;
        this.zzd = zzah0.zzd;
        this.zze = zzah0.zze;
        this.zzf = zzah0.zzf;
        this.zzg = zzah0.zzg;
        this.zzh = zzah0.zzh;
        this.zzi = zzah0.zzi;
        this.zzj = zzah0.zzj;
        this.zzk = zzah0.zzk;
    }

    @Constructor
    public zzah(@Param(id = 2) String s, @Param(id = 3) String s1, @Param(id = 4) zzpk zzpk0, @Param(id = 5) long v, @Param(id = 6) boolean z, @Param(id = 7) String s2, @Param(id = 8) zzbg zzbg0, @Param(id = 9) long v1, @Param(id = 10) zzbg zzbg1, @Param(id = 11) long v2, @Param(id = 12) zzbg zzbg2) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = zzpk0;
        this.zzd = v;
        this.zze = z;
        this.zzf = s2;
        this.zzg = zzbg0;
        this.zzh = v1;
        this.zzi = zzbg1;
        this.zzj = v2;
        this.zzk = zzbg2;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzc, v, false);
        SafeParcelWriter.writeLong(parcel0, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel0, 6, this.zze);
        SafeParcelWriter.writeString(parcel0, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel0, 8, this.zzg, v, false);
        SafeParcelWriter.writeLong(parcel0, 9, this.zzh);
        SafeParcelWriter.writeParcelable(parcel0, 10, this.zzi, v, false);
        SafeParcelWriter.writeLong(parcel0, 11, this.zzj);
        SafeParcelWriter.writeParcelable(parcel0, 12, this.zzk, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

