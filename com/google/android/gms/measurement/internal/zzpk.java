package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "UserAttributeParcelCreator")
public final class zzpk extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(id = 1)
    public final int zza;
    @Field(id = 2)
    public final String zzb;
    @Field(id = 3)
    public final long zzc;
    @Field(id = 4)
    public final Long zzd;
    @Field(id = 6)
    public final String zze;
    @Field(id = 7)
    public final String zzf;
    @Field(id = 8)
    public final Double zzg;

    static {
        zzpk.CREATOR = new zzpl();
    }

    @Constructor
    public zzpk(@Param(id = 1) int v, @Param(id = 2) String s, @Param(id = 3) long v1, @Param(id = 4) Long long0, @Param(id = 5) Float float0, @Param(id = 6) String s1, @Param(id = 7) String s2, @Param(id = 8) Double double0) {
        this.zza = v;
        this.zzb = s;
        this.zzc = v1;
        this.zzd = long0;
        if(v == 1) {
            double0 = float0 == null ? null : float0.doubleValue();
        }
        this.zzg = double0;
        this.zze = s1;
        this.zzf = s2;
    }

    public zzpk(zzpm zzpm0) {
        this(zzpm0.zzc, zzpm0.zzd, zzpm0.zze, zzpm0.zzb);
    }

    public zzpk(String s, long v, Object object0, String s1) {
        Preconditions.checkNotEmpty(s);
        this.zza = 2;
        this.zzb = s;
        this.zzc = v;
        this.zzf = s1;
        if(object0 == null) {
            this.zzd = null;
            this.zzg = null;
            this.zze = null;
            return;
        }
        if(object0 instanceof Long) {
            this.zzd = (Long)object0;
            this.zzg = null;
            this.zze = null;
            return;
        }
        if(object0 instanceof String) {
            this.zzd = null;
            this.zzg = null;
            this.zze = (String)object0;
            return;
        }
        if(!(object0 instanceof Double)) {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
        this.zzd = null;
        this.zzg = (Double)object0;
        this.zze = null;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        zzpl.zza(this, parcel0, v);
    }

    public final Object zza() {
        Long long0 = this.zzd;
        if(long0 != null) {
            return long0;
        }
        Double double0 = this.zzg;
        if(double0 != null) {
            return double0;
        }
        String s = this.zze;
        return s != null ? s : null;
    }
}

