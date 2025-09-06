package com.google.android.gms.internal.cast;

import M6.B;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import e.k;
import l4.L;
import l4.O;
import w1.j;

public final class zzbb implements L {
    private static final Logger zza;
    private final zzbn zzb;
    private final Handler zzc;

    static {
        zzbb.zza = new Logger("MediaRouterOPTListener");
    }

    public zzbb(zzbn zzbn0) {
        this.zzb = (zzbn)Preconditions.checkNotNull(zzbn0);
        this.zzc = new zzet(Looper.getMainLooper());
    }

    @Override  // l4.L
    public final B onPrepareTransfer(O o0, O o1) {
        zzbb.zza.d("Prepare transfer from Route(%s) to Route(%s)", new Object[]{o0, o1});
        return k.q((j j0) -> {
            zzba zzba0 = () -> zzbb0.zzb.zzk(o0, o1, j0);
            return Boolean.valueOf(this.zzc.post(zzba0));
        });
    }

    // 检测为 Lambda 实现
    public static Object zza(zzbb zzbb0, O o0, O o1, j j0) [...]

    // 检测为 Lambda 实现
    public static void zzb(zzbb zzbb0, O o0, O o1, j j0) [...]
}

