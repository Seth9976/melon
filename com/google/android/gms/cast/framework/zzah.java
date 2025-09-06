package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;
import java.util.Map;

public final class zzah extends zza implements zzaj {
    public zzah(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.cast.framework.ICastContext");
    }

    @Override  // com.google.android.gms.cast.framework.zzaj
    public final Bundle zze() {
        Parcel parcel0 = this.zzb(1, this.zza());
        Bundle bundle0 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
        parcel0.recycle();
        return bundle0;
    }

    @Override  // com.google.android.gms.cast.framework.zzaj
    public final zzaq zzf() {
        zzaq zzaq0;
        Parcel parcel0 = this.zzb(6, this.zza());
        IBinder iBinder0 = parcel0.readStrongBinder();
        if(iBinder0 == null) {
            zzaq0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.cast.framework.IDiscoveryManager");
            zzaq0 = iInterface0 instanceof zzaq ? ((zzaq)iInterface0) : new zzap(iBinder0);
        }
        parcel0.recycle();
        return zzaq0;
    }

    @Override  // com.google.android.gms.cast.framework.zzaj
    public final zzay zzg() {
        zzay zzay0;
        Parcel parcel0 = this.zzb(5, this.zza());
        IBinder iBinder0 = parcel0.readStrongBinder();
        if(iBinder0 == null) {
            zzay0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.cast.framework.ISessionManager");
            zzay0 = iInterface0 instanceof zzay ? ((zzay)iInterface0) : new zzax(iBinder0);
        }
        parcel0.recycle();
        return zzay0;
    }

    @Override  // com.google.android.gms.cast.framework.zzaj
    public final void zzh(zzae zzae0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, zzae0);
        this.zzc(3, parcel0);
    }

    @Override  // com.google.android.gms.cast.framework.zzaj
    public final void zzi(String s, Map map0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeMap(map0);
        this.zzc(11, parcel0);
    }
}

