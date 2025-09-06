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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Class(creator = "RetrieveBytesRequestCreator")
public class RetrieveBytesRequest extends AbstractSafeParcelable {
    public static final class Builder {
        private List zza;
        private boolean zzb;

        public Builder() {
            this.zza = new ArrayList();
            this.zzb = false;
        }

        public RetrieveBytesRequest build() {
            return new RetrieveBytesRequest(this.zza, this.zzb);
        }

        public Builder setKeys(List list0) {
            Preconditions.checkNotNull(list0, "Keys cannot be set to null");
            this.zza = list0;
            return this;
        }

        public Builder setRetrieveAll(boolean z) {
            this.zzb = z;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getKeys", id = 1)
    private final List zza;
    @Field(defaultValue = "false", getter = "getRetrieveAll", id = 2)
    private final boolean zzb;

    static {
        RetrieveBytesRequest.CREATOR = new zzc();
    }

    @Constructor
    public RetrieveBytesRequest(@Param(id = 1) List list0, @Param(id = 2) boolean z) {
        boolean z1 = true;
        super();
        if(z) {
            if(list0 != null && !list0.isEmpty()) {
                z1 = false;
            }
            Preconditions.checkState(z1, "retrieveAll was set to true but other constraint(s) was also provided: keys");
        }
        this.zzb = z;
        this.zza = new ArrayList();
        if(list0 != null) {
            for(Object object0: list0) {
                Preconditions.checkNotEmpty(((String)object0), "Element in keys cannot be null or empty");
                this.zza.add(((String)object0));
            }
        }
    }

    public List getKeys() {
        return Collections.unmodifiableList(this.zza);
    }

    public boolean getRetrieveAll() {
        return this.zzb;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeStringList(parcel0, 1, this.getKeys(), false);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.getRetrieveAll());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

