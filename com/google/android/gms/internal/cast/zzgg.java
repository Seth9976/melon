package com.google.android.gms.internal.cast;

import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

final class zzgg {
    private static final Interpolator zza;
    private static final Interpolator zzb;
    private static final Interpolator zzc;

    static {
        zzgg.zza = new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);
        zzgg.zzb = new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);
        zzgg.zzc = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    }
}

