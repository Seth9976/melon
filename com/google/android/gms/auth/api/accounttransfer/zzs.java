package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.collection.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Class(creator = "AccountTransferProgressCreator")
public final class zzs extends zzbz {
    public static final Parcelable.Creator CREATOR;
    @VersionField(id = 1)
    final int zza;
    private static final f zzb;
    @Field(getter = "getRegisteredAccountTypes", id = 2)
    private List zzc;
    @Field(getter = "getInProgressAccountTypes", id = 3)
    private List zzd;
    @Field(getter = "getSuccessAccountTypes", id = 4)
    private List zze;
    @Field(getter = "getFailedAccountTypes", id = 5)
    private List zzf;
    @Field(getter = "getEscrowedAccountTypes", id = 6)
    private List zzg;

    static {
        zzs.CREATOR = new zzt();
        f f0 = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        zzs.zzb = f0;
        f0.put("registered", com.google.android.gms.common.server.response.FastJsonResponse.Field.forStrings("registered", 2));
        f0.put("in_progress", com.google.android.gms.common.server.response.FastJsonResponse.Field.forStrings("in_progress", 3));
        f0.put("success", com.google.android.gms.common.server.response.FastJsonResponse.Field.forStrings("success", 4));
        f0.put("failed", com.google.android.gms.common.server.response.FastJsonResponse.Field.forStrings("failed", 5));
        f0.put("escrowed", com.google.android.gms.common.server.response.FastJsonResponse.Field.forStrings("escrowed", 6));
    }

    public zzs() {
        this.zza = 1;
    }

    @Constructor
    public zzs(@Param(id = 1) int v, @Param(id = 2) List list0, @Param(id = 3) List list1, @Param(id = 4) List list2, @Param(id = 5) List list3, @Param(id = 6) List list4) {
        this.zza = v;
        this.zzc = list0;
        this.zzd = list1;
        this.zze = list2;
        this.zzf = list3;
        this.zzg = list4;
    }

    @Override  // com.google.android.gms.common.server.response.FastJsonResponse
    public final Map getFieldMappings() {
        return zzs.zzb;
    }

    @Override  // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getFieldValue(com.google.android.gms.common.server.response.FastJsonResponse.Field fastJsonResponse$Field0) {
        switch(fastJsonResponse$Field0.getSafeParcelableFieldId()) {
            case 1: {
                return this.zza;
            }
            case 2: {
                return this.zzc;
            }
            case 3: {
                return this.zzd;
            }
            case 4: {
                return this.zze;
            }
            case 5: {
                return this.zzf;
            }
            case 6: {
                return this.zzg;
            }
            default: {
                throw new IllegalStateException("Unknown SafeParcelable id=" + fastJsonResponse$Field0.getSafeParcelableFieldId());
            }
        }
    }

    @Override  // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isFieldSet(com.google.android.gms.common.server.response.FastJsonResponse.Field fastJsonResponse$Field0) {
        return true;
    }

    @Override  // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringsInternal(com.google.android.gms.common.server.response.FastJsonResponse.Field fastJsonResponse$Field0, String s, ArrayList arrayList0) {
        int v = fastJsonResponse$Field0.getSafeParcelableFieldId();
        switch(v) {
            case 2: {
                this.zzc = arrayList0;
                return;
            }
            case 3: {
                this.zzd = arrayList0;
                return;
            }
            case 4: {
                this.zze = arrayList0;
                return;
            }
            case 5: {
                this.zzf = arrayList0;
                return;
            }
            case 6: {
                this.zzg = arrayList0;
                return;
            }
            default: {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", v));
            }
        }
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeStringList(parcel0, 2, this.zzc, false);
        SafeParcelWriter.writeStringList(parcel0, 3, this.zzd, false);
        SafeParcelWriter.writeStringList(parcel0, 4, this.zze, false);
        SafeParcelWriter.writeStringList(parcel0, 5, this.zzf, false);
        SafeParcelWriter.writeStringList(parcel0, 6, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

