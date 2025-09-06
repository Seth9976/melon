package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.measurement.internal.zzht;
import java.util.Objects;

final class zzdr extends zzeq {
    final Context zza;
    final Bundle zzb;
    final zzfb zzc;

    public zzdr(zzfb zzfb0, Context context0, Bundle bundle0) {
        this.zza = context0;
        this.zzb = bundle0;
        Objects.requireNonNull(zzfb0);
        this.zzc = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        try {
            Context context0 = this.zza;
            Preconditions.checkNotNull(context0);
            String s = zzht.zza(context0);
            Preconditions.checkNotNull(context0);
            Resources resources0 = context0.getResources();
            if(TextUtils.isEmpty(s)) {
                s = zzht.zza(context0);
            }
            Boolean boolean0 = zzht.zzc("google_analytics_force_disable_updates", resources0, s);
            zzfb zzfb0 = this.zzc;
            zzfb0.zzR(zzfb0.zzc(context0, boolean0 == null || !boolean0.booleanValue()));
            if(zzfb0.zzQ() == null) {
                Log.w(zzfb0.zzO(), "Failed to connect to measurement client.");
                return;
            }
            int v = DynamiteModule.getLocalVersion(context0, "com.google.android.gms.measurement.dynamite");
            int v1 = DynamiteModule.getRemoteVersion(context0, "com.google.android.gms.measurement.dynamite");
            boolean z = Boolean.TRUE.equals(boolean0) || v1 < v;
            String s1 = zzht.zza(context0);
            zzdd zzdd0 = new zzdd(130000L, ((long)Math.max(v, v1)), z, this.zzb, s1);
            ((zzcr)Preconditions.checkNotNull(zzfb0.zzQ())).initialize(ObjectWrapper.wrap(context0), zzdd0, this.zzh);
            return;
        }
        catch(Exception exception0) {
        }
        this.zzc.zzN(exception0, true, false);
    }
}

