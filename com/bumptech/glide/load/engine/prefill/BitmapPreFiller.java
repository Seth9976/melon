package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap.Config;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.Util;
import java.util.HashMap;

public final class BitmapPreFiller {
    private final BitmapPool bitmapPool;
    private BitmapPreFillRunner current;
    private final DecodeFormat defaultFormat;
    private final MemoryCache memoryCache;

    public BitmapPreFiller(MemoryCache memoryCache0, BitmapPool bitmapPool0, DecodeFormat decodeFormat0) {
        this.memoryCache = memoryCache0;
        this.bitmapPool = bitmapPool0;
        this.defaultFormat = decodeFormat0;
    }

    public PreFillQueue generateAllocationOrder(PreFillType[] arr_preFillType) {
        long v = this.memoryCache.getMaxSize();
        long v1 = this.memoryCache.getCurrentSize();
        long v2 = this.bitmapPool.getMaxSize();
        int v5 = 0;
        for(int v4 = 0; v4 < arr_preFillType.length; ++v4) {
            v5 += arr_preFillType[v4].getWeight();
        }
        HashMap hashMap0 = new HashMap();
        for(int v3 = 0; v3 < arr_preFillType.length; ++v3) {
            PreFillType preFillType0 = arr_preFillType[v3];
            hashMap0.put(preFillType0, ((int)(Math.round(((float)preFillType0.getWeight()) * (((float)(v2 + (v - v1))) / ((float)v5))) / BitmapPreFiller.getSizeInBytes(preFillType0))));
        }
        return new PreFillQueue(hashMap0);
    }

    private static int getSizeInBytes(PreFillType preFillType0) {
        return Util.getBitmapByteSize(preFillType0.getWidth(), preFillType0.getHeight(), preFillType0.getConfig());
    }

    public void preFill(Builder[] arr_preFillType$Builder) {
        BitmapPreFillRunner bitmapPreFillRunner0 = this.current;
        if(bitmapPreFillRunner0 != null) {
            bitmapPreFillRunner0.cancel();
        }
        PreFillType[] arr_preFillType = new PreFillType[arr_preFillType$Builder.length];
        for(int v = 0; v < arr_preFillType$Builder.length; ++v) {
            Builder preFillType$Builder0 = arr_preFillType$Builder[v];
            if(preFillType$Builder0.getConfig() == null) {
                preFillType$Builder0.setConfig((this.defaultFormat == DecodeFormat.PREFER_ARGB_8888 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565));
            }
            arr_preFillType[v] = preFillType$Builder0.build();
        }
        PreFillQueue preFillQueue0 = this.generateAllocationOrder(arr_preFillType);
        BitmapPreFillRunner bitmapPreFillRunner1 = new BitmapPreFillRunner(this.bitmapPool, this.memoryCache, preFillQueue0);
        this.current = bitmapPreFillRunner1;
        Util.postOnUiThread(bitmapPreFillRunner1);
    }
}

