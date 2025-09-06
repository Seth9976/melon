package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

final class zaa implements Runnable {
    final ImageManager zaa;
    private final Uri zab;
    private final ParcelFileDescriptor zac;

    public zaa(ImageManager imageManager0, Uri uri0, ParcelFileDescriptor parcelFileDescriptor0) {
        this.zaa = imageManager0;
        super();
        this.zab = uri0;
        this.zac = parcelFileDescriptor0;
    }

    @Override
    public final void run() {
        Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can\'t be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor0 = this.zac;
        Bitmap bitmap0 = null;
        boolean z = false;
        if(parcelFileDescriptor0 != null) {
            try {
                bitmap0 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor0.getFileDescriptor());
            }
            catch(OutOfMemoryError outOfMemoryError0) {
                Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.zab, outOfMemoryError0);
                z = true;
            }
            try {
                this.zac.close();
            }
            catch(IOException iOException0) {
                Log.e("ImageManager", "closed failed", iOException0);
            }
        }
        CountDownLatch countDownLatch0 = new CountDownLatch(1);
        zac zac0 = new zac(this.zaa, this.zab, bitmap0, z, countDownLatch0);
        this.zaa.zae.post(zac0);
        try {
            countDownLatch0.await();
        }
        catch(InterruptedException unused_ex) {
            Log.w("ImageManager", "Latch interrupted while posting " + this.zab);
        }
    }
}

