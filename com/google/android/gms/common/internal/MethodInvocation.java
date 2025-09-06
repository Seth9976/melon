package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdk
@Class(creator = "MethodInvocationCreator")
public class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getMethodKey", id = 1)
    private final int zaa;
    @Field(getter = "getResultStatusCode", id = 2)
    private final int zab;
    @Field(getter = "getConnectionResultStatusCode", id = 3)
    private final int zac;
    @Field(getter = "getStartTimeMillis", id = 4)
    private final long zad;
    @Field(getter = "getEndTimeMillis", id = 5)
    private final long zae;
    @Field(getter = "getCallingModuleId", id = 6)
    private final String zaf;
    @Field(getter = "getCallingEntryPoint", id = 7)
    private final String zag;
    @Field(defaultValue = "0", getter = "getServiceId", id = 8)
    private final int zah;
    @Field(defaultValue = "-1", getter = "getLatencyMillis", id = 9)
    private final int zai;

    static {
        MethodInvocation.CREATOR = new zan();
    }

    @KeepForSdk
    @Deprecated
    public MethodInvocation(int v, int v1, int v2, long v3, long v4, String s, String s1, int v5) {
        this(v, v1, v2, v3, v4, s, s1, v5, -1);
    }

    @Constructor
    public MethodInvocation(@Param(id = 1) int v, @Param(id = 2) int v1, @Param(id = 3) int v2, @Param(id = 4) long v3, @Param(id = 5) long v4, @Param(id = 6) String s, @Param(id = 7) String s1, @Param(id = 8) int v5, @Param(id = 9) int v6) {
        this.zaa = v;
        this.zab = v1;
        this.zac = v2;
        this.zad = v3;
        this.zae = v4;
        this.zaf = s;
        this.zag = s1;
        this.zah = v5;
        this.zai = v6;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zaa);
        SafeParcelWriter.writeInt(parcel0, 2, this.zab);
        SafeParcelWriter.writeInt(parcel0, 3, this.zac);
        SafeParcelWriter.writeLong(parcel0, 4, this.zad);
        SafeParcelWriter.writeLong(parcel0, 5, this.zae);
        SafeParcelWriter.writeString(parcel0, 6, this.zaf, false);
        SafeParcelWriter.writeString(parcel0, 7, this.zag, false);
        SafeParcelWriter.writeInt(parcel0, 8, this.zah);
        SafeParcelWriter.writeInt(parcel0, 9, this.zai);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

