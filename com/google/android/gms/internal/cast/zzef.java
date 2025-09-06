package com.google.android.gms.internal.cast;

import U4.x;
import android.hardware.display.VirtualDisplay;
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

@Deprecated
public final class zzef implements CastRemoteDisplayApi {
    private static final Logger zza;
    private final Api zzb;
    private VirtualDisplay zzc;
    private final zzen zzd;

    static {
        zzef.zza = new Logger("CastRemoteDisplayApiImpl");
    }

    public zzef(Api api0) {
        this.zzd = new zzdx(this);
        this.zzb = api0;
    }

    @Override  // com.google.android.gms.cast.CastRemoteDisplayApi
    public final PendingResult startRemoteDisplay(GoogleApiClient googleApiClient0, String s) {
        zzef.zza.d("startRemoteDisplay", new Object[0]);
        return googleApiClient0.execute(new zzdy(this, googleApiClient0, s));
    }

    @Override  // com.google.android.gms.cast.CastRemoteDisplayApi
    public final PendingResult stopRemoteDisplay(GoogleApiClient googleApiClient0) {
        zzef.zza.d("stopRemoteDisplay", new Object[0]);
        return googleApiClient0.execute(new zzdz(this, googleApiClient0));
    }

    public static VirtualDisplay zza(zzef zzef0) {
        return zzef0.zzc;
    }

    public static Logger zzb() {
        return zzef.zza;
    }

    public static zzen zzc(zzef zzef0) {
        return zzef0.zzd;
    }

    public static Api zzd(zzef zzef0) {
        return zzef0.zzb;
    }

    public static void zze(zzef zzef0, VirtualDisplay virtualDisplay0) {
        zzef0.zzc = virtualDisplay0;
    }

    public static void zzf(zzef zzef0) {
        VirtualDisplay virtualDisplay0 = zzef0.zzc;
        if(virtualDisplay0 != null) {
            if(virtualDisplay0.getDisplay() != null) {
                String s = x.e(virtualDisplay0.getDisplay().getDisplayId(), "releasing virtual display: ");
                zzef.zza.d(s, new Object[0]);
            }
            virtualDisplay0.release();
        }
        zzef0.zzc = null;
    }
}

