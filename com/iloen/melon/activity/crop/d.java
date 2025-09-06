package com.iloen.melon.activity.crop;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

public final class d implements Runnable {
    public final Bitmap a;
    public final CountDownLatch b;
    public final e c;

    public d(e e0, Bitmap bitmap0, CountDownLatch countDownLatch0) {
        this.c = e0;
        this.a = bitmap0;
        this.b = countDownLatch0;
    }

    @Override
    public final void run() {
        CropImage cropImage0 = (CropImage)this.c.b;
        Bitmap bitmap0 = this.a;
        if(bitmap0 != cropImage0.mBitmap && bitmap0 != null) {
            cropImage0.mImageView.k(bitmap0);
            cropImage0.mBitmap.recycle();
            cropImage0.mBitmap = bitmap0;
        }
        if(cropImage0.mImageView.getScale() == 1.0f) {
            cropImage0.mImageView.a();
        }
        this.b.countDown();
    }
}

