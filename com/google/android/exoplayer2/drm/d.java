package com.google.android.exoplayer2.drm;

import Bb.e;
import android.media.MediaDrm.OnEventListener;
import android.media.MediaDrm;
import k3.c;
import k3.v;

public final class d implements MediaDrm.OnEventListener {
    public final int a;
    public final Object b;
    public final Object c;

    public d(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // android.media.MediaDrm$OnEventListener
    public final void onEvent(MediaDrm mediaDrm0, byte[] arr_b, int v, int v1, byte[] arr_b1) {
        if(this.a != 0) {
            ((v)this.b).getClass();
            e e0 = ((c)this.c).a.x;
            e0.getClass();
            e0.obtainMessage(v, arr_b).sendToTarget();
            return;
        }
        ((FrameworkMediaDrm)this.b).lambda$setOnEventListener$1(((OnEventListener)this.c), mediaDrm0, arr_b, v, v1, arr_b1);
    }
}

