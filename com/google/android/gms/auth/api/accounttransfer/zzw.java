package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.collection.g;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Indicator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.internal.auth.zzbz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Class(creator = "AuthenticatorTransferInfoCreator")
public final class zzw extends zzbz {
    public static final Parcelable.Creator CREATOR;
    @Indicator
    final Set zza;
    @VersionField(id = 1)
    final int zzb;
    private static final HashMap zzc;
    @Field(getter = "getAccountType", id = 2)
    private String zzd;
    @Field(getter = "getStatus", id = 3)
    private int zze;
    @Field(getter = "getTransferBytes", id = 4)
    private byte[] zzf;
    @Field(getter = "getPendingIntent", id = 5)
    private PendingIntent zzg;
    @Field(getter = "getDeviceMetaData", id = 6)
    private DeviceMetaData zzh;

    static {
        zzw.CREATOR = new zzx();
        HashMap hashMap0 = new HashMap();
        zzw.zzc = hashMap0;
        hashMap0.put("accountType", com.google.android.gms.common.server.response.FastJsonResponse.Field.forString("accountType", 2));
        hashMap0.put("status", com.google.android.gms.common.server.response.FastJsonResponse.Field.forInteger("status", 3));
        hashMap0.put("transferBytes", com.google.android.gms.common.server.response.FastJsonResponse.Field.forBase64("transferBytes", 4));
    }

    public zzw() {
        this.zza = new g(3);
        this.zzb = 1;
    }

    @Constructor
    public zzw(@Indicator Set set0, @Param(id = 1) int v, @Param(id = 2) String s, @Param(id = 3) int v1, @Param(id = 4) byte[] arr_b, @Param(id = 5) PendingIntent pendingIntent0, @Param(id = 6) DeviceMetaData deviceMetaData0) {
        this.zza = set0;
        this.zzb = v;
        this.zzd = s;
        this.zze = v1;
        this.zzf = arr_b;
        this.zzg = pendingIntent0;
        this.zzh = deviceMetaData0;
    }

    @Override  // com.google.android.gms.common.server.response.FastJsonResponse
    public final Map getFieldMappings() {
        return zzw.zzc;
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
            case 3: {
                return this.zze;
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

    @Override  // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setDecodedBytesInternal(com.google.android.gms.common.server.response.FastJsonResponse.Field fastJsonResponse$Field0, String s, byte[] arr_b) {
        int v = fastJsonResponse$Field0.getSafeParcelableFieldId();
        if(v != 4) {
            throw new IllegalArgumentException("Field with id=" + v + " is not known to be a byte array.");
        }
        this.zzf = arr_b;
        this.zza.add(4);
    }

    @Override  // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setIntegerInternal(com.google.android.gms.common.server.response.FastJsonResponse.Field fastJsonResponse$Field0, String s, int v) {
        int v1 = fastJsonResponse$Field0.getSafeParcelableFieldId();
        if(v1 != 3) {
            throw new IllegalArgumentException("Field with id=" + v1 + " is not known to be an int.");
        }
        this.zze = v;
        this.zza.add(3);
    }

    @Override  // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringInternal(com.google.android.gms.common.server.response.FastJsonResponse.Field fastJsonResponse$Field0, String s, String s1) {
        int v = fastJsonResponse$Field0.getSafeParcelableFieldId();
        if(v != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", v));
        }
        this.zzd = s1;
        this.zza.add(2);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        Set set0 = this.zza;
        if(set0.contains(1)) {
            SafeParcelWriter.writeInt(parcel0, 1, this.zzb);
        }
        if(set0.contains(2)) {
            SafeParcelWriter.writeString(parcel0, 2, this.zzd, true);
        }
        if(set0.contains(3)) {
            SafeParcelWriter.writeInt(parcel0, 3, this.zze);
        }
        if(set0.contains(4)) {
            SafeParcelWriter.writeByteArray(parcel0, 4, this.zzf, true);
        }
        if(set0.contains(5)) {
            SafeParcelWriter.writeParcelable(parcel0, 5, this.zzg, v, true);
        }
        if(set0.contains(6)) {
            SafeParcelWriter.writeParcelable(parcel0, 6, this.zzh, v, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

