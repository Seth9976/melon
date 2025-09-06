package com.google.android.gms.internal.cast;

import android.content.Context;
import l4.G;
import l4.H;
import l4.Q;

public final class zzbg {
    public Q zza;
    private final Context zzb;

    public zzbg(Context context0) {
        this.zzb = context0;
    }

    public final Q zza() {
        if(this.zza == null) {
            this.zza = Q.d(this.zzb);
        }
        return this.zza;
    }

    public final void zzb(G g0, H h0, int v) {
        this.zza().a(g0, h0, 4);
    }

    public final void zzc(H h0) {
        Q q0 = this.zza();
        if(q0 != null) {
            q0.j(h0);
        }
    }
}

