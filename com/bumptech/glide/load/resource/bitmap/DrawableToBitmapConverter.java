package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import java.util.concurrent.locks.Lock;

final class DrawableToBitmapConverter {
    private static final BitmapPool NO_RECYCLE_BITMAP_POOL = null;
    private static final String TAG = "DrawableToBitmap";

    static {
        DrawableToBitmapConverter.NO_RECYCLE_BITMAP_POOL = new BitmapPoolAdapter() {
            @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter
            public void put(Bitmap bitmap0) {
            }
        };
    }

    public static Resource convert(BitmapPool bitmapPool0, Drawable drawable0, int v, int v1) {
        Bitmap bitmap0;
        Drawable drawable1 = drawable0.getCurrent();
        boolean z = false;
        if(drawable1 instanceof BitmapDrawable) {
            bitmap0 = ((BitmapDrawable)drawable1).getBitmap();
        }
        else if(drawable1 instanceof Animatable) {
            bitmap0 = null;
        }
        else {
            bitmap0 = DrawableToBitmapConverter.drawToBitmap(bitmapPool0, drawable1, v, v1);
            z = true;
        }
        if(!z) {
            bitmapPool0 = DrawableToBitmapConverter.NO_RECYCLE_BITMAP_POOL;
        }
        return BitmapResource.obtain(bitmap0, bitmapPool0);
    }

    private static Bitmap drawToBitmap(BitmapPool bitmapPool0, Drawable drawable0, int v, int v1) {
        if(v == 0x80000000 && drawable0.getIntrinsicWidth() <= 0) {
            if(Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable0 + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        }
        if(v1 == 0x80000000 && drawable0.getIntrinsicHeight() <= 0) {
            if(Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable0 + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
        if(drawable0.getIntrinsicWidth() > 0) {
            v = drawable0.getIntrinsicWidth();
        }
        if(drawable0.getIntrinsicHeight() > 0) {
            v1 = drawable0.getIntrinsicHeight();
        }
        Lock lock0 = TransformationUtils.getBitmapDrawableLock();
        lock0.lock();
        Bitmap bitmap0 = bitmapPool0.get(v, v1, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas0 = new Canvas(bitmap0);
            drawable0.setBounds(0, 0, v, v1);
            drawable0.draw(canvas0);
            canvas0.setBitmap(null);
            return bitmap0;
        }
        finally {
            lock0.unlock();
        }
    }
}

