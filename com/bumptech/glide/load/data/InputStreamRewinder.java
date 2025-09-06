package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;

public final class InputStreamRewinder implements DataRewinder {
    public static final class Factory implements com.bumptech.glide.load.data.DataRewinder.Factory {
        private final ArrayPool byteArrayPool;

        public Factory(ArrayPool arrayPool0) {
            this.byteArrayPool = arrayPool0;
        }

        public DataRewinder build(InputStream inputStream0) {
            return new InputStreamRewinder(inputStream0, this.byteArrayPool);
        }

        @Override  // com.bumptech.glide.load.data.DataRewinder$Factory
        public DataRewinder build(Object object0) {
            return this.build(((InputStream)object0));
        }

        @Override  // com.bumptech.glide.load.data.DataRewinder$Factory
        public Class getDataClass() {
            return InputStream.class;
        }
    }

    private static final int MARK_READ_LIMIT = 0x500000;
    private final RecyclableBufferedInputStream bufferedStream;

    public InputStreamRewinder(InputStream inputStream0, ArrayPool arrayPool0) {
        RecyclableBufferedInputStream recyclableBufferedInputStream0 = new RecyclableBufferedInputStream(inputStream0, arrayPool0);
        this.bufferedStream = recyclableBufferedInputStream0;
        recyclableBufferedInputStream0.mark(0x500000);
    }

    @Override  // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
        this.bufferedStream.release();
    }

    public void fixMarkLimits() {
        this.bufferedStream.fixMarkLimit();
    }

    public InputStream rewindAndGet() {
        this.bufferedStream.reset();
        return this.bufferedStream;
    }

    @Override  // com.bumptech.glide.load.data.DataRewinder
    public Object rewindAndGet() {
        return this.rewindAndGet();
    }
}

