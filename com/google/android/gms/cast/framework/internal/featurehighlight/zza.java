package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class zza extends GestureDetector.SimpleOnGestureListener {
    final zzh zza;

    public zza(zzh zzh0) {
        this.zza = zzh0;
        super();
    }

    @Override  // android.view.GestureDetector$SimpleOnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent0) {
        zzh zzh0 = this.zza;
        float f = motionEvent0.getX();
        float f1 = motionEvent0.getY();
        if(zzh.zzc(zzh0) != null && (!zzh.zzm(zzh0, f, f1) || !zzh.zze(zzh0).zzg(f, f1))) {
            zzh.zzc(zzh0).zza();
        }
        return true;
    }
}

