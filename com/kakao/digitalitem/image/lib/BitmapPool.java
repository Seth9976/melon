package com.kakao.digitalitem.image.lib;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import java.util.LinkedList;

public final class BitmapPool {
    static final class BitmapPoolHolder {
        private static final BitmapPool INSTANCE;

        static {
            BitmapPoolHolder.INSTANCE = new BitmapPool(10, Bitmap.Config.ARGB_8888, null);
        }

        public static BitmapPool access$100() {
            return BitmapPoolHolder.INSTANCE;
        }
    }

    private static final int POOL_LIMIT_SIZE = 10;
    private final Bitmap.Config bitmapConfig;
    private final int limitSize;
    private final LinkedList pool;

    private BitmapPool(int v, Bitmap.Config bitmap$Config0) {
        this.limitSize = v;
        this.bitmapConfig = bitmap$Config0;
        this.pool = new LinkedList();
    }

    public BitmapPool(int v, Bitmap.Config bitmap$Config0, com.kakao.digitalitem.image.lib.BitmapPool.1 bitmapPool$10) {
        this(v, bitmap$Config0);
    }

    public void clear() {
        synchronized(this.pool) {
            this.pool.clear();
        }
    }

    public Bitmap getBitmap(int v, int v1) {
        synchronized(this.pool) {
            for(int v3 = this.pool.size() - 1; v3 >= 0; --v3) {
                Bitmap bitmap0 = (Bitmap)this.pool.get(v3);
                if(bitmap0.getWidth() == v && bitmap0.getHeight() == v1) {
                    this.pool.remove(v3);
                    if(!bitmap0.isRecycled()) {
                        return bitmap0;
                    }
                }
            }
        }
        try {
            return Bitmap.createBitmap(v, v1, this.bitmapConfig);
        }
        catch(OutOfMemoryError unused_ex) {
            this.clear();
            SystemUtil.gc();
            return null;
        }
    }

    public static BitmapPool getInstance() {
        return BitmapPoolHolder.access$100();
    }

    public static BitmapPool newInstance(int v, Bitmap.Config bitmap$Config0) {
        if(v <= 0) {
            v = 10;
        }
        return new BitmapPool(v, bitmap$Config0);
    }

    public void returnBitmap(Bitmap bitmap0) {
        if(bitmap0 != null && !bitmap0.isRecycled()) {
            LinkedList linkedList0 = this.pool;
            synchronized(linkedList0) {
                if(this.pool.size() >= this.limitSize) {
                    this.pool.removeFirst();
                }
                this.pool.addLast(bitmap0);
            }
        }
    }

    class com.kakao.digitalitem.image.lib.BitmapPool.1 {
    }

}

