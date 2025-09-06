package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;

@KeepForSdk
@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private final IBinder zza;

    static {
        BinderWrapper.CREATOR = new zzh();
    }

    @KeepForSdk
    public BinderWrapper(IBinder iBinder0) {
        this.zza = iBinder0;
    }

    public BinderWrapper(Parcel parcel0, byte[] arr_b) {
        this.zza = parcel0.readStrongBinder();
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeStrongBinder(this.zza);
    }
}

