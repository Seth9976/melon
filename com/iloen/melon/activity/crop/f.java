package com.iloen.melon.activity.crop;

import android.graphics.Bitmap;
import android.view.KeyEvent.Callback;

public final class f implements Runnable {
    public final int a;
    public final Object b;
    public final KeyEvent.Callback c;

    public f(KeyEvent.Callback keyEvent$Callback0, Object object0, int v) {
        this.a = v;
        this.c = keyEvent$Callback0;
        this.b = object0;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                ((CropImage)this.c).saveOutput(((Bitmap)this.b));
                return;
            }
            case 1: {
                ((CropImage)this.c).mImageView.k(null);
                ((Bitmap)this.b).recycle();
                return;
            }
            default: {
                ((ImageViewTouchBase)this.c).e(((b)this.b));
            }
        }
    }
}

