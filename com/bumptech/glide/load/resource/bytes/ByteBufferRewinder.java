package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.data.DataRewinder;
import java.nio.ByteBuffer;

public class ByteBufferRewinder implements DataRewinder {
    public static class Factory implements com.bumptech.glide.load.data.DataRewinder.Factory {
        @Override  // com.bumptech.glide.load.data.DataRewinder$Factory
        public DataRewinder build(Object object0) {
            return this.build(((ByteBuffer)object0));
        }

        public DataRewinder build(ByteBuffer byteBuffer0) {
            return new ByteBufferRewinder(byteBuffer0);
        }

        @Override  // com.bumptech.glide.load.data.DataRewinder$Factory
        public Class getDataClass() {
            return ByteBuffer.class;
        }
    }

    private final ByteBuffer buffer;

    public ByteBufferRewinder(ByteBuffer byteBuffer0) {
        this.buffer = byteBuffer0;
    }

    @Override  // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
    }

    @Override  // com.bumptech.glide.load.data.DataRewinder
    public Object rewindAndGet() {
        return this.rewindAndGet();
    }

    public ByteBuffer rewindAndGet() {
        this.buffer.position(0);
        return this.buffer;
    }
}

