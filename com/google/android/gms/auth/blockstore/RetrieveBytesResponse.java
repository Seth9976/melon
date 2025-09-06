package com.google.android.gms.auth.blockstore;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Class(creator = "RetrieveBytesResponseCreator")
public class RetrieveBytesResponse extends AbstractSafeParcelable {
    @Class(creator = "BlockstoreDataCreator")
    public static class BlockstoreData extends AbstractSafeParcelable {
        public static final Parcelable.Creator CREATOR;
        @Field(getter = "getBytes", id = 1)
        private final byte[] zza;
        @Field(getter = "getKey", id = 2)
        private final String zzb;

        static {
            BlockstoreData.CREATOR = new zza();
        }

        @Constructor
        public BlockstoreData(@Param(id = 1) byte[] arr_b, @Param(id = 2) String s) {
            this.zza = arr_b;
            this.zzb = s;
        }

        @Override
        public boolean equals(Object object0) {
            if(!(object0 instanceof BlockstoreData)) {
                return false;
            }
            return this == object0 ? true : Arrays.equals(this.zza, ((BlockstoreData)object0).zza);
        }

        public byte[] getBytes() {
            return this.zza;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(new Object[]{Arrays.hashCode(this.zza)});
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel parcel0, int v) {
            int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
            SafeParcelWriter.writeByteArray(parcel0, 1, this.getBytes(), false);
            SafeParcelWriter.writeString(parcel0, 2, this.zzb, false);
            SafeParcelWriter.finishObjectHeader(parcel0, v1);
        }

        public final String zza() {
            return this.zzb;
        }
    }

    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getInternalBlockstoreDataBundle", id = 1)
    @Deprecated
    private final Bundle zza;
    @Field(getter = "getInternalBlockstoreDataList", id = 2)
    private final List zzb;
    private final Map zzc;

    static {
        RetrieveBytesResponse.CREATOR = new zzd();
    }

    @Constructor
    public RetrieveBytesResponse(@Param(id = 1) Bundle bundle0, @Param(id = 2) List list0) {
        this.zza = bundle0;
        this.zzb = list0;
        HashMap hashMap0 = new HashMap();
        for(Object object0: list0) {
            hashMap0.put(((BlockstoreData)object0).zza(), ((BlockstoreData)object0));
        }
        this.zzc = hashMap0;
    }

    public Map getBlockstoreDataMap() {
        return Collections.unmodifiableMap(this.zzc);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBundle(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeTypedList(parcel0, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

