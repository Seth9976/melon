package com.google.android.exoplayer2.decoder;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SimpleOutputBuffer extends OutputBuffer {
    public ByteBuffer data;
    private final SimpleDecoder owner;

    public SimpleOutputBuffer(SimpleDecoder simpleDecoder0) {
        this.owner = simpleDecoder0;
    }

    @Override  // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        ByteBuffer byteBuffer0 = this.data;
        if(byteBuffer0 != null) {
            byteBuffer0.clear();
        }
    }

    public ByteBuffer init(long v, int v1) {
        this.timeUs = v;
        if(this.data == null || this.data.capacity() < v1) {
            this.data = ByteBuffer.allocateDirect(v1).order(ByteOrder.nativeOrder());
        }
        this.data.position(0);
        this.data.limit(v1);
        return this.data;
    }

    @Override  // com.google.android.exoplayer2.decoder.OutputBuffer
    public void release() {
        this.owner.releaseOutputBuffer(this);
    }
}

