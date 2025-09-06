package com.google.android.gms.location;

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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.iloen.melon.utils.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Class(creator = "SleepSegmentEventCreator")
@Reserved({1000})
public class SleepSegmentEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = null;
    public static final int STATUS_MISSING_DATA = 1;
    public static final int STATUS_NOT_DETECTED = 2;
    public static final int STATUS_SUCCESSFUL;
    @Field(getter = "getStartTimeMillis", id = 1)
    private final long zza;
    @Field(getter = "getEndTimeMillis", id = 2)
    private final long zzb;
    @Field(getter = "getStatus", id = 3)
    private final int zzc;
    @Field(getter = "getMissingDataDurationMinutes", id = 4)
    private final int zzd;
    @Field(getter = "getNinetiethPctConfidence", id = 5)
    private final int zze;

    static {
        SleepSegmentEvent.CREATOR = new zzap();
    }

    @ShowFirstParty
    @Constructor
    public SleepSegmentEvent(@Param(id = 1) long v, @Param(id = 2) long v1, @Param(id = 3) int v2, @Param(id = 4) int v3, @Param(id = 5) int v4) {
        Preconditions.checkArgument(v <= v1, "endTimeMillis must be greater than or equal to startTimeMillis");
        this.zza = v;
        this.zzb = v1;
        this.zzc = v2;
        this.zzd = v3;
        this.zze = v4;
    }

    @Override
    public boolean equals(Object object0) {
        return object0 instanceof SleepSegmentEvent && this.zza == ((SleepSegmentEvent)object0).getStartTimeMillis() && this.zzb == ((SleepSegmentEvent)object0).getEndTimeMillis() && this.zzc == ((SleepSegmentEvent)object0).getStatus() && this.zzd == ((SleepSegmentEvent)object0).zzd && this.zze == ((SleepSegmentEvent)object0).zze;
    }

    public static List extractEvents(Intent intent0) {
        Preconditions.checkNotNull(intent0);
        if(!SleepSegmentEvent.hasEvents(intent0)) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList0 = (ArrayList)intent0.getSerializableExtra("com.google.android.location.internal.EXTRA_SLEEP_SEGMENT_RESULT");
        if(arrayList0 == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList1 = new ArrayList(arrayList0.size());
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            byte[] arr_b = (byte[])arrayList0.get(v1);
            Preconditions.checkNotNull(arr_b);
            arrayList1.add(((SleepSegmentEvent)SafeParcelableSerializer.deserializeFromBytes(arr_b, SleepSegmentEvent.CREATOR)));
        }
        return Collections.unmodifiableList(arrayList1);
    }

    public long getEndTimeMillis() {
        return this.zzb;
    }

    public long getSegmentDurationMillis() {
        return this.zzb - this.zza;
    }

    public long getStartTimeMillis() {
        return this.zza;
    }

    public int getStatus() {
        return this.zzc;
    }

    public static boolean hasEvents(Intent intent0) {
        return intent0 == null ? false : intent0.hasExtra("com.google.android.location.internal.EXTRA_SLEEP_SEGMENT_RESULT");
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc});
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(String.valueOf(this.zza).length() + 24 + String.valueOf(this.zzb).length() + 9 + String.valueOf(this.zzc).length());
        a.s(this.zza, "startMillis=", ", endMillis=", stringBuilder0);
        stringBuilder0.append(this.zzb);
        stringBuilder0.append(", status=");
        stringBuilder0.append(this.zzc);
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        Preconditions.checkNotNull(parcel0);
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 1, this.getStartTimeMillis());
        SafeParcelWriter.writeLong(parcel0, 2, this.getEndTimeMillis());
        SafeParcelWriter.writeInt(parcel0, 3, this.getStatus());
        SafeParcelWriter.writeInt(parcel0, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel0, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

