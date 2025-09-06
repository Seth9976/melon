package com.google.firebase;

import android.util.Log;
import com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public final class d implements BackgroundStateChangeListener {
    public static final AtomicReference a;

    static {
        d.a = new AtomicReference();
    }

    @Override  // com.google.android.gms.common.api.internal.BackgroundDetector$BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        synchronized(e.k) {
            for(Object object1: new ArrayList(e.l.values())) {
                e e0 = (e)object1;
                if(e0.e.get()) {
                    Log.d("FirebaseApp", "Notifying background state change listeners.");
                    for(Object object2: e0.i) {
                        e e1 = ((c)object2).a;
                        if(!z) {
                            ((w7.c)e1.h.get()).b();
                        }
                    }
                }
            }
        }
    }
}

