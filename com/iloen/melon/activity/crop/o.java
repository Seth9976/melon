package com.iloen.melon.activity.crop;

import android.app.ProgressDialog;
import android.os.Handler;

public final class o implements m, Runnable {
    public final CropImage a;
    public final ProgressDialog b;
    public final Runnable c;
    public final Handler d;
    public final e e;

    public o(CropImage cropImage0, Runnable runnable0, ProgressDialog progressDialog0, Handler handler0) {
        this.e = new e(this, 2);
        this.a = cropImage0;
        this.b = progressDialog0;
        this.c = runnable0;
        cropImage0.addLifeCycleListener(this);
        this.d = handler0;
    }

    @Override
    public final void run() {
        try {
            this.c.run();
        }
        finally {
            this.d.post(this.e);
        }
    }
}

