package com.google.android.gms.cast;

import android.util.Log;
import com.google.android.gms.cast.internal.zzaq;
import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzdl implements zzat {
    final zzdn zza;

    public zzdl(zzdn zzdn0) {
        this.zza = zzdn0;
        super();
    }

    @Override  // com.google.android.gms.cast.internal.zzat
    public final void zza(String s, long v, int v1, Object object0, long v2, long v3) {
        JSONObject jSONObject0 = null;
        zzaq zzaq0 = object0 instanceof zzaq ? ((zzaq)object0) : null;
        try {
            zzdn zzdn0 = this.zza;
            Status status0 = new Status(v1);
            if(zzaq0 != null) {
                jSONObject0 = zzaq0.zza;
            }
            zzdn0.setResult(new zzdo(status0, jSONObject0));
            return;
        }
        catch(IllegalStateException illegalStateException0) {
        }
        Log.e("RemoteMediaPlayer", "Result already set when calling onRequestCompleted", illegalStateException0);
    }

    @Override  // com.google.android.gms.cast.internal.zzat
    public final void zzb(String s, long v, long v1, long v2) {
        try {
            Status status0 = new Status(2103);
            zzdm zzdm0 = new zzdm(this.zza, status0);
            this.zza.setResult(zzdm0);
        }
        catch(IllegalStateException illegalStateException0) {
            Log.e("RemoteMediaPlayer", "Result already set when calling onRequestReplaced", illegalStateException0);
        }
    }
}

