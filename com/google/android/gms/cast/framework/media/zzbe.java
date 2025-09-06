package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.internal.zzaq;
import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzbe implements zzat {
    final zzbg zza;

    public zzbe(zzbg zzbg0) {
        this.zza = zzbg0;
        super();
    }

    @Override  // com.google.android.gms.cast.internal.zzat
    public final void zza(String s, long v, int v1, Object object0, long v2, long v3) {
        MediaError mediaError0 = null;
        zzaq zzaq0 = object0 instanceof zzaq ? ((zzaq)object0) : null;
        try {
            zzbg zzbg0 = this.zza;
            Status status0 = new Status(v1);
            JSONObject jSONObject0 = zzaq0 == null ? null : zzaq0.zza;
            if(zzaq0 != null) {
                mediaError0 = zzaq0.zzb;
            }
            zzbg0.setResult(new zzbh(status0, jSONObject0, mediaError0));
        }
        catch(IllegalStateException illegalStateException0) {
            RemoteMediaClient.zza.e(illegalStateException0, "Result already set when calling onRequestCompleted", new Object[0]);
        }
        for(Object object1: this.zza.zzg.zzj) {
            ((Callback)object1).zza(s, v, v1, v2, v3);
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzat
    public final void zzb(String s, long v, long v1, long v2) {
        try {
            Status status0 = new Status(2103);
            zzbf zzbf0 = new zzbf(this.zza, status0);
            this.zza.setResult(zzbf0);
        }
        catch(IllegalStateException illegalStateException0) {
            RemoteMediaClient.zza.e(illegalStateException0, "Result already set when calling onRequestReplaced", new Object[0]);
        }
        for(Object object0: this.zza.zzg.zzj) {
            ((Callback)object0).zza(s, v, 2103, v1, v2);
        }
    }
}

