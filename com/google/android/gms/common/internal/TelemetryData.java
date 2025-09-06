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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

@KeepForSdk
@Class(creator = "TelemetryDataCreator")
public class TelemetryData extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getTelemetryConfigVersion", id = 1)
    private final int zaa;
    @Field(getter = "getMethodInvocations", id = 2)
    @Nullable
    private List zab;

    static {
        TelemetryData.CREATOR = new zaab();
    }

    @Constructor
    public TelemetryData(@Param(id = 1) int v, @Param(id = 2) @Nullable List list0) {
        this.zaa = v;
        this.zab = list0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zaa);
        SafeParcelWriter.writeTypedList(parcel0, 2, this.zab, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final int zaa() {
        return this.zaa;
    }

    public final List zab() {
        return this.zab;
    }

    public final void zac(MethodInvocation methodInvocation0) {
        if(this.zab == null) {
            this.zab = new ArrayList();
        }
        this.zab.add(methodInvocation0);
    }
}

