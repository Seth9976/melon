package com.google.android.gms.common.api.internal;

import U4.x;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.zau;

final class zabc extends zau {
    final zabe zaa;

    public zabc(zabe zabe0, Looper looper0) {
        this.zaa = zabe0;
        super(looper0);
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        int v = message0.what;
        switch(v) {
            case 1: {
                zabe.zaj(this.zaa);
                return;
            }
            case 2: {
                zabe.zai(this.zaa);
                return;
            }
            default: {
                x.u(v, "Unknown message id: ", "GoogleApiClientImpl");
            }
        }
    }
}

