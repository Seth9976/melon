package com.google.android.gms.auth;

import A7.d;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "AccountChangeEventCreator")
public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @VersionField(id = 1)
    final int zza;
    @Field(id = 2)
    final long zzb;
    @Field(id = 3)
    final String zzc;
    @Field(id = 4)
    final int zzd;
    @Field(id = 5)
    final int zze;
    @Field(id = 6)
    final String zzf;

    static {
        AccountChangeEvent.CREATOR = new zza();
    }

    @Constructor
    public AccountChangeEvent(@Param(id = 1) int v, @Param(id = 2) long v1, @Param(id = 3) String s, @Param(id = 4) int v2, @Param(id = 5) int v3, @Param(id = 6) String s1) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = (String)Preconditions.checkNotNull(s);
        this.zzd = v2;
        this.zze = v3;
        this.zzf = s1;
    }

    public AccountChangeEvent(long v, String s, int v1, int v2, String s1) {
        this.zza = 1;
        this.zzb = v;
        this.zzc = (String)Preconditions.checkNotNull(s);
        this.zzd = v1;
        this.zze = v2;
        this.zzf = s1;
    }

    @Override
    public boolean equals(Object object0) {
        if(!(object0 instanceof AccountChangeEvent)) {
            return false;
        }
        return object0 == this ? true : this.zza == ((AccountChangeEvent)object0).zza && this.zzb == ((AccountChangeEvent)object0).zzb && Objects.equal(this.zzc, ((AccountChangeEvent)object0).zzc) && this.zzd == ((AccountChangeEvent)object0).zzd && this.zze == ((AccountChangeEvent)object0).zze && Objects.equal(this.zzf, ((AccountChangeEvent)object0).zzf);
    }

    public String getAccountName() {
        return this.zzc;
    }

    public String getChangeData() {
        return this.zzf;
    }

    public int getChangeType() {
        return this.zzd;
    }

    public int getEventIndex() {
        return this.zze;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf});
    }

    @Override
    public String toString() {
        String s;
        switch(this.zzd) {
            case 1: {
                s = "ADDED";
                break;
            }
            case 2: {
                s = "REMOVED";
                break;
            }
            case 3: {
                s = "RENAMED_FROM";
                break;
            }
            case 4: {
                s = "RENAMED_TO";
                break;
            }
            default: {
                s = "UNKNOWN";
            }
        }
        StringBuilder stringBuilder0 = d.o("AccountChangeEvent {accountName = ", this.zzc, ", changeType = ", s, ", changeData = ");
        stringBuilder0.append(this.zzf);
        stringBuilder0.append(", eventIndex = ");
        stringBuilder0.append(this.zze);
        stringBuilder0.append("}");
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeLong(parcel0, 2, this.zzb);
        SafeParcelWriter.writeString(parcel0, 3, this.zzc, false);
        SafeParcelWriter.writeInt(parcel0, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel0, 5, this.zze);
        SafeParcelWriter.writeString(parcel0, 6, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

