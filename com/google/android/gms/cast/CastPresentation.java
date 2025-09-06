package com.google.android.gms.cast;

import android.app.Presentation;
import android.content.Context;
import android.view.Display;
import android.view.Window;

@Deprecated
public abstract class CastPresentation extends Presentation {
    public CastPresentation(Context context0, Display display0) {
        super(context0, display0);
        this.zza();
    }

    public CastPresentation(Context context0, Display display0, int v) {
        super(context0, display0, v);
        this.zza();
    }

    private final void zza() {
        Window window0 = this.getWindow();
        if(window0 != null) {
            window0.setType(2030);
            window0.addFlags(0x10000000);
            window0.addFlags(0x1000000);
            window0.addFlags(0x400);
        }
    }
}

