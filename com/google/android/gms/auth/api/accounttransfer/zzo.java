package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Indicator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Class(creator = "AccountTransferMsgCreator")
public final class zzo extends zzbz {
    public static final Parcelable.Creator CREATOR;
    @Indicator
    final Set zza;
    @VersionField(id = 1)
    final int zzb;
    private static final HashMap zzc;
    @Field(getter = "getAuthenticatorDatas", id = 2)
    private ArrayList zzd;
    @Field(getter = "getRequestType", id = 3)
    private int zze;
    @Field(getter = "getProgress", id = 4)
    private zzs zzf;

    static {
        zzo.CREATOR = new zzp();
        HashMap hashMap0 = new HashMap();
        zzo.zzc = hashMap0;
        hashMap0.put("authenticatorData", com.google.android.gms.common.server.response.FastJsonResponse.Field.forConcreteTypeArray("authenticatorData", 2, zzu.class));
        hashMap0.put("progress", com.google.android.gms.common.server.response.FastJsonResponse.Field.forConcreteType("progress", 4, zzs.class));
    }

    public zzo() {
        this.zza = new HashSet(1);
        this.zzb = 1;
    }

    @Constructor
    public zzo(@Indicator Set set0, @Param(id = 1) int v, @Param(id = 2) ArrayList arrayList0, @Param(id = 3) int v1, @Param(id = 4) zzs zzs0) {
        this.zza = set0;
        this.zzb = v;
        this.zzd = arrayList0;
        this.zze = v1;
        this.zzf = zzs0;
    }

    @Override  // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeArrayInternal(com.google.android.gms.common.server.response.FastJsonResponse.Field fastJsonResponse$Field0, String s, ArrayList arrayList0) {
        int v = fastJsonResponse$Field0.getSafeParcelableFieldId();
        if(v != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", v, arrayList0.getClass().getCanonicalName()));
        }
        this.zzd = arrayList0;
        this.zza.add(2);
    }

    @Override  // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeInternal(com.google.android.gms.common.server.response.FastJsonResponse.Field fastJsonResponse$Field0, String s, FastJsonResponse fastJsonResponse0) {
        int v = fastJsonResponse$Field0.getSafeParcelableFieldId();
        if(v != 4) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", v, fastJsonResponse0.getClass().getCanonicalName()));
        }
        this.zzf = (zzs)fastJsonResponse0;
        this.zza.add(4);
    }

    @Override  // com.google.android.gms.common.server.response.FastJsonResponse
    public final Map getFieldMappings() {
        return zzo.zzc;
    }

    @Override  // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getFieldValue(com.google.android.gms.common.server.response.FastJsonResponse.Field fastJsonResponse$Field0) {
        switch(fastJsonResponse$Field0.getSafeParcelableFieldId()) {
            case 1: {
                return this.zzb;
            }
            case 2: {
                return this.zzd;
            }
            case 4: {
                return this.zzf;
            }
            default: {
                throw new IllegalStateException("Unknown SafeParcelable id=" + fastJsonResponse$Field0.getSafeParcelableFieldId());
            }
        }
    }

    @Override  // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isFieldSet(com.google.android.gms.common.server.response.FastJsonResponse.Field fastJsonResponse$Field0) {
        return this.zza.contains(fastJsonResponse$Field0.getSafeParcelableFieldId());
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        Set set0 = this.zza;
        if(set0.contains(1)) {
            SafeParcelWriter.writeInt(parcel0, 1, this.zzb);
        }
        if(set0.contains(2)) {
            SafeParcelWriter.writeTypedList(parcel0, 2, this.zzd, true);
        }
        if(set0.contains(3)) {
            SafeParcelWriter.writeInt(parcel0, 3, this.zze);
        }
        if(set0.contains(4)) {
            SafeParcelWriter.writeParcelable(parcel0, 4, this.zzf, v, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

