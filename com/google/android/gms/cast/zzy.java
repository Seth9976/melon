package com.google.android.gms.cast;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.cast.zzeg;
import com.google.android.gms.internal.cast.zzel;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzy implements RemoteCall {
    public final CastRemoteDisplayClient zza;
    public final int zzb;
    public final PendingIntent zzc;
    public final CastDevice zzd;
    public final String zze;
    public final zzak zzf;

    public zzy(CastRemoteDisplayClient castRemoteDisplayClient0, int v, zzak zzak0, PendingIntent pendingIntent0, CastDevice castDevice0, String s) {
        this.zza = castRemoteDisplayClient0;
        this.zzb = v;
        this.zzf = zzak0;
        this.zzc = pendingIntent0;
        this.zzd = castDevice0;
        this.zze = s;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("configuration", this.zzb);
        zzab zzab0 = new zzab(this.zza, ((TaskCompletionSource)object1), ((zzeg)object0), this.zzf);
        ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(((zzeg)object0).getContext()).build();
        IInterface iInterface0 = ((zzeg)object0).getService();
        String s = this.zzd.getDeviceId();
        ApiMetadata apiMetadata0 = ApiMetadata.fromComplianceOptions(complianceOptions0);
        ((zzel)iInterface0).zzh(zzab0, this.zzc, s, this.zze, bundle0, apiMetadata0);
    }
}

