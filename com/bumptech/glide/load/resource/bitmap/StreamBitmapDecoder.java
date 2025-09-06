package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.ExceptionPassthroughInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamBitmapDecoder implements ResourceDecoder {
    static class UntrustedCallbacks implements DecodeCallbacks {
        private final RecyclableBufferedInputStream bufferedStream;
        private final ExceptionPassthroughInputStream exceptionStream;

        public UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream0, ExceptionPassthroughInputStream exceptionPassthroughInputStream0) {
            this.bufferedStream = recyclableBufferedInputStream0;
            this.exceptionStream = exceptionPassthroughInputStream0;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks
        public void onDecodeComplete(BitmapPool bitmapPool0, Bitmap bitmap0) {
            IOException iOException0 = this.exceptionStream.getException();
            if(iOException0 != null) {
                if(bitmap0 != null) {
                    bitmapPool0.put(bitmap0);
                }
                throw iOException0;
            }
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks
        public void onObtainBounds() {
            this.bufferedStream.fixMarkLimit();
        }
    }

    private final ArrayPool byteArrayPool;
    private final Downsampler downsampler;

    public StreamBitmapDecoder(Downsampler downsampler0, ArrayPool arrayPool0) {
        this.downsampler = downsampler0;
        this.byteArrayPool = arrayPool0;
    }

    public Resource decode(InputStream inputStream0, int v, int v1, Options options0) {
        boolean z;
        RecyclableBufferedInputStream recyclableBufferedInputStream0;
        if(inputStream0 instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream0 = (RecyclableBufferedInputStream)inputStream0;
            z = false;
        }
        else {
            z = true;
            recyclableBufferedInputStream0 = new RecyclableBufferedInputStream(inputStream0, this.byteArrayPool);
        }
        ExceptionPassthroughInputStream exceptionPassthroughInputStream0 = ExceptionPassthroughInputStream.obtain(recyclableBufferedInputStream0);
        MarkEnforcingInputStream markEnforcingInputStream0 = new MarkEnforcingInputStream(exceptionPassthroughInputStream0);
        UntrustedCallbacks streamBitmapDecoder$UntrustedCallbacks0 = new UntrustedCallbacks(recyclableBufferedInputStream0, exceptionPassthroughInputStream0);
        try {
            return this.downsampler.decode(markEnforcingInputStream0, v, v1, options0, streamBitmapDecoder$UntrustedCallbacks0);
        }
        finally {
            exceptionPassthroughInputStream0.release();
            if(z) {
                recyclableBufferedInputStream0.release();
            }
        }
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((InputStream)object0), v, v1, options0);
    }

    public boolean handles(InputStream inputStream0, Options options0) {
        return true;
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((InputStream)object0), options0);
    }
}

