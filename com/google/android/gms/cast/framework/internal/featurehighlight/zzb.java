package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

final class zzb extends GestureDetector.SimpleOnGestureListener {
    final View zza;
    final zzg zzb;

    public zzb(zzh zzh0, View view0, boolean z, zzg zzg0) {
        this.zza = view0;
        this.zzb = zzg0;
        super();
    }

    @Override  // android.view.GestureDetector$SimpleOnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent0) {
        View view0 = this.zza;
        if(view0.getParent() != null) {
            view0.performClick();
        }
        this.zzb.zzb();
        return true;
    }
}

