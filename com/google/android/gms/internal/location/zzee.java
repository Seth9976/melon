package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.location.zzw;
import com.google.android.gms.location.zzz;

@Class(creator = "LocationReceiverCreator")
@Reserved({5})
public final class zzee extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getType", id = 1)
    private final int zza;
    @Field(getter = "getOldBinderReceiver", id = 2)
    private final IBinder zzb;
    @Field(getter = "getBinderReceiver", id = 3)
    private final IBinder zzc;
    @Field(getter = "getPendingIntentReceiver", id = 4)
    private final PendingIntent zzd;
    @Field(getter = "getListenerId", id = 6)
    private final String zze;

    static {
        zzee.CREATOR = new zzef();
    }

    @Constructor
    public zzee(@Param(id = 1) int v, @Param(id = 2) IBinder iBinder0, @Param(id = 3) IBinder iBinder1, @Param(id = 4) PendingIntent pendingIntent0, @Param(id = 6) String s) {
        this.zza = v;
        this.zzb = iBinder0;
        this.zzc = iBinder1;
        this.zzd = pendingIntent0;
        this.zze = s;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeIBinder(parcel0, 2, this.zzb, false);
        SafeParcelWriter.writeIBinder(parcel0, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzd, v, false);
        SafeParcelWriter.writeString(parcel0, 6, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static zzee zza(IInterface iInterface0, zzz zzz0, String s) {
        if(iInterface0 == null) {
            iInterface0 = null;
        }
        return new zzee(1, ((IBinder)iInterface0), ((IBinder)zzz0), null, s);
    }

    public static zzee zzb(IInterface iInterface0, zzw zzw0, String s) {
        if(iInterface0 == null) {
            iInterface0 = null;
        }
        return new zzee(2, ((IBinder)iInterface0), ((IBinder)zzw0), null, s);
    }

    public static zzee zzc(PendingIntent pendingIntent0) {
        return new zzee(3, null, null, pendingIntent0, null);
    }

    public static zzee zzd(com.google.android.gms.internal.location.zzz zzz0) {
        return new zzee(4, null, ((IBinder)zzz0), null, null);
    }
}

