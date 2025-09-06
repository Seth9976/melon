package com.google.android.gms.location;

import U4.x;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Class(creator = "SleepClassifyEventCreator")
public class SleepClassifyEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getTimestampSec", id = 1)
    private final int zza;
    @Field(getter = "getConfidence", id = 2)
    private final int zzb;
    @Field(getter = "getMotion", id = 3)
    private final int zzc;
    @Field(getter = "getLight", id = 4)
    private final int zzd;
    @Field(getter = "getNoise", id = 5)
    private final int zze;
    @Field(getter = "getLightDiff", id = 6)
    private final int zzf;
    @Field(getter = "getNightOrDay", id = 7)
    private final int zzg;
    @Field(getter = "getConfidenceOverwrittenByAlarmClockTrigger", id = 8)
    private final boolean zzh;
    @Field(getter = "getPresenceConfidence", id = 9)
    private final int zzi;

    static {
        SleepClassifyEvent.CREATOR = new zzao();
    }

    @ShowFirstParty
    @Constructor
    public SleepClassifyEvent(@Param(id = 1) int v, @Param(id = 2) int v1, @Param(id = 3) int v2, @Param(id = 4) int v3, @Param(id = 5) int v4, @Param(id = 6) int v5, @Param(id = 7) int v6, @Param(id = 8) boolean z, @Param(id = 9) int v7) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = v2;
        this.zzd = v3;
        this.zze = v4;
        this.zzf = v5;
        this.zzg = v6;
        this.zzh = z;
        this.zzi = v7;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof SleepClassifyEvent ? this.zza == ((SleepClassifyEvent)object0).zza && this.zzb == ((SleepClassifyEvent)object0).zzb : false;
    }

    public static List extractEvents(Intent intent0) {
        Preconditions.checkNotNull(intent0);
        if(!SleepClassifyEvent.hasEvents(intent0)) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList0 = (ArrayList)intent0.getSerializableExtra("com.google.android.location.internal.EXTRA_SLEEP_CLASSIFY_RESULT");
        if(arrayList0 == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList1 = new ArrayList(arrayList0.size());
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            byte[] arr_b = (byte[])arrayList0.get(v1);
            Preconditions.checkNotNull(arr_b);
            arrayList1.add(((SleepClassifyEvent)SafeParcelableSerializer.deserializeFromBytes(arr_b, SleepClassifyEvent.CREATOR)));
        }
        return Collections.unmodifiableList(arrayList1);
    }

    public int getConfidence() {
        return this.zzb;
    }

    public int getLight() {
        return this.zzd;
    }

    public int getMotion() {
        return this.zzc;
    }

    public long getTimestampMillis() {
        return ((long)this.zza) * 1000L;
    }

    public static boolean hasEvents(Intent intent0) {
        return intent0 == null ? false : intent0.hasExtra("com.google.android.location.internal.EXTRA_SLEEP_CLASSIFY_RESULT");
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb});
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(String.valueOf(this.zza).length() + 6 + String.valueOf(this.zzb).length() + 8 + String.valueOf(this.zzc).length() + 7 + String.valueOf(this.zzd).length());
        x.x(stringBuilder0, this.zza, " Conf:", this.zzb, " Motion:");
        stringBuilder0.append(this.zzc);
        stringBuilder0.append(" Light:");
        stringBuilder0.append(this.zzd);
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        Preconditions.checkNotNull(parcel0);
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeInt(parcel0, 2, this.getConfidence());
        SafeParcelWriter.writeInt(parcel0, 3, this.getMotion());
        SafeParcelWriter.writeInt(parcel0, 4, this.getLight());
        SafeParcelWriter.writeInt(parcel0, 5, this.zze);
        SafeParcelWriter.writeInt(parcel0, 6, this.zzf);
        SafeParcelWriter.writeInt(parcel0, 7, this.zzg);
        SafeParcelWriter.writeBoolean(parcel0, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel0, 9, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

