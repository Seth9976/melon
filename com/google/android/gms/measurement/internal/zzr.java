package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.List;

@Class(creator = "AppMetadataCreator")
@Reserved({1, 13, 17, 19, 20, 24, 33})
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(id = 34)
    public final long zzA;
    @Field(id = 35)
    public final String zzB;
    @Field(defaultValue = "", id = 36)
    public final String zzC;
    @Field(id = 37)
    public final long zzD;
    @Field(id = 38)
    public final int zzE;
    @Field(id = 2)
    public final String zza;
    @Field(id = 3)
    public final String zzb;
    @Field(id = 4)
    public final String zzc;
    @Field(id = 5)
    public final String zzd;
    @Field(id = 6)
    public final long zze;
    @Field(id = 7)
    public final long zzf;
    @Field(id = 8)
    public final String zzg;
    @Field(defaultValue = "true", id = 9)
    public final boolean zzh;
    @Field(id = 10)
    public final boolean zzi;
    @Field(defaultValueUnchecked = "Integer.MIN_VALUE", id = 11)
    public final long zzj;
    @Field(id = 12)
    public final String zzk;
    @Field(id = 14)
    public final long zzl;
    @Field(id = 15)
    public final int zzm;
    @Field(defaultValue = "true", id = 16)
    public final boolean zzn;
    @Field(id = 18)
    public final boolean zzo;
    @Field(id = 21)
    public final Boolean zzp;
    @Field(id = 22)
    public final long zzq;
    @Field(id = 23)
    public final List zzr;
    @Field(defaultValue = "", id = 25)
    public final String zzs;
    @Field(defaultValue = "", id = 26)
    public final String zzt;
    @Field(id = 27)
    public final String zzu;
    @Field(defaultValue = "false", id = 28)
    public final boolean zzv;
    @Field(id = 29)
    public final long zzw;
    @Field(defaultValue = "100", id = 30)
    public final int zzx;
    @Field(defaultValue = "", id = 0x1F)
    public final String zzy;
    @Field(id = 0x20)
    public final int zzz;

    static {
        zzr.CREATOR = new zzs();
    }

    public zzr(String s, String s1, String s2, long v, String s3, long v1, long v2, String s4, boolean z, boolean z1, String s5, long v3, int v4, boolean z2, boolean z3, Boolean boolean0, long v5, List list0, String s6, String s7, String s8, boolean z4, long v6, int v7, String s9, int v8, long v9, String s10, String s11, long v10, int v11) {
        Preconditions.checkNotEmpty(s);
        this.zza = s;
        if(TextUtils.isEmpty(s1)) {
            s1 = null;
        }
        this.zzb = s1;
        this.zzc = s2;
        this.zzj = v;
        this.zzd = s3;
        this.zze = v1;
        this.zzf = v2;
        this.zzg = s4;
        this.zzh = z;
        this.zzi = z1;
        this.zzk = s5;
        this.zzl = v3;
        this.zzm = v4;
        this.zzn = z2;
        this.zzo = z3;
        this.zzp = boolean0;
        this.zzq = v5;
        this.zzr = list0;
        this.zzs = s6;
        this.zzt = s7;
        this.zzu = s8;
        this.zzv = z4;
        this.zzw = v6;
        this.zzx = v7;
        this.zzy = s9;
        this.zzz = v8;
        this.zzA = v9;
        this.zzB = s10;
        this.zzC = s11;
        this.zzD = v10;
        this.zzE = v11;
    }

    @Constructor
    public zzr(@Param(id = 2) String s, @Param(id = 3) String s1, @Param(id = 4) String s2, @Param(id = 5) String s3, @Param(id = 6) long v, @Param(id = 7) long v1, @Param(id = 8) String s4, @Param(id = 9) boolean z, @Param(id = 10) boolean z1, @Param(id = 11) long v2, @Param(id = 12) String s5, @Param(id = 14) long v3, @Param(id = 15) int v4, @Param(id = 16) boolean z2, @Param(id = 18) boolean z3, @Param(id = 21) Boolean boolean0, @Param(id = 22) long v5, @Param(id = 23) List list0, @Param(id = 25) String s6, @Param(id = 26) String s7, @Param(id = 27) String s8, @Param(id = 28) boolean z4, @Param(id = 29) long v6, @Param(id = 30) int v7, @Param(id = 0x1F) String s9, @Param(id = 0x20) int v8, @Param(id = 34) long v9, @Param(id = 35) String s10, @Param(id = 36) String s11, @Param(id = 37) long v10, @Param(id = 38) int v11) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = s2;
        this.zzj = v2;
        this.zzd = s3;
        this.zze = v;
        this.zzf = v1;
        this.zzg = s4;
        this.zzh = z;
        this.zzi = z1;
        this.zzk = s5;
        this.zzl = v3;
        this.zzm = v4;
        this.zzn = z2;
        this.zzo = z3;
        this.zzp = boolean0;
        this.zzq = v5;
        this.zzr = list0;
        this.zzs = s6;
        this.zzt = s7;
        this.zzu = s8;
        this.zzv = z4;
        this.zzw = v6;
        this.zzx = v7;
        this.zzy = s9;
        this.zzz = v8;
        this.zzA = v9;
        this.zzB = s10;
        this.zzC = s11;
        this.zzD = v10;
        this.zzE = v11;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel0, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel0, 5, this.zzd, false);
        SafeParcelWriter.writeLong(parcel0, 6, this.zze);
        SafeParcelWriter.writeLong(parcel0, 7, this.zzf);
        SafeParcelWriter.writeString(parcel0, 8, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel0, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel0, 10, this.zzi);
        SafeParcelWriter.writeLong(parcel0, 11, this.zzj);
        SafeParcelWriter.writeString(parcel0, 12, this.zzk, false);
        SafeParcelWriter.writeLong(parcel0, 14, this.zzl);
        SafeParcelWriter.writeInt(parcel0, 15, this.zzm);
        SafeParcelWriter.writeBoolean(parcel0, 16, this.zzn);
        SafeParcelWriter.writeBoolean(parcel0, 18, this.zzo);
        SafeParcelWriter.writeBooleanObject(parcel0, 21, this.zzp, false);
        SafeParcelWriter.writeLong(parcel0, 22, this.zzq);
        SafeParcelWriter.writeStringList(parcel0, 23, this.zzr, false);
        SafeParcelWriter.writeString(parcel0, 25, this.zzs, false);
        SafeParcelWriter.writeString(parcel0, 26, this.zzt, false);
        SafeParcelWriter.writeString(parcel0, 27, this.zzu, false);
        SafeParcelWriter.writeBoolean(parcel0, 28, this.zzv);
        SafeParcelWriter.writeLong(parcel0, 29, this.zzw);
        SafeParcelWriter.writeInt(parcel0, 30, this.zzx);
        SafeParcelWriter.writeString(parcel0, 0x1F, this.zzy, false);
        SafeParcelWriter.writeInt(parcel0, 0x20, this.zzz);
        SafeParcelWriter.writeLong(parcel0, 34, this.zzA);
        SafeParcelWriter.writeString(parcel0, 35, this.zzB, false);
        SafeParcelWriter.writeString(parcel0, 36, this.zzC, false);
        SafeParcelWriter.writeLong(parcel0, 37, this.zzD);
        SafeParcelWriter.writeInt(parcel0, 38, this.zzE);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

