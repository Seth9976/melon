package com.google.android.gms.auth.blockstore;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "StoreBytesDataCreator")
public class StoreBytesData extends AbstractSafeParcelable {
    public static final class Builder {
        private byte[] zza;
        private boolean zzb;
        private String zzc;

        public Builder() {
            this.zzc = "com.google.android.gms.auth.blockstore.DEFAULT_BYTES_DATA_KEY";
        }

        public StoreBytesData build() {
            return new StoreBytesData(this.zza, this.zzb, this.zzc);
        }

        public Builder setBytes(byte[] arr_b) {
            this.zza = arr_b;
            return this;
        }

        public Builder setKey(String s) {
            Preconditions.checkNotEmpty(s, "key cannot be null or empty");
            this.zzc = s;
            return this;
        }

        public Builder setShouldBackupToCloud(boolean z) {
            this.zzb = z;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getBytes", id = 1)
    private final byte[] zza;
    @Field(defaultValue = "false", getter = "shouldBackupToCloud", id = 2)
    private final boolean zzb;
    @Field(defaultValue = "com.google.android.gms.auth.blockstore.DEFAULT_BYTES_DATA_KEY", getter = "getKey", id = 3)
    private final String zzc;

    static {
        StoreBytesData.CREATOR = new zze();
    }

    @Constructor
    public StoreBytesData(@Param(id = 1) byte[] arr_b, @Param(id = 2) boolean z, @Param(id = 3) String s) {
        this.zza = arr_b;
        this.zzb = z;
        this.zzc = s;
    }

    public byte[] getBytes() {
        return this.zza;
    }

    public String getKey() {
        return this.zzc;
    }

    public boolean shouldBackupToCloud() {
        return this.zzb;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeByteArray(parcel0, 1, this.getBytes(), false);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.shouldBackupToCloud());
        SafeParcelWriter.writeString(parcel0, 3, this.getKey(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

