package com.google.android.exoplayer2.decoder;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class DecoderInputBuffer extends Buffer {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface BufferReplacementMode {
    }

    public static final int BUFFER_REPLACEMENT_MODE_DIRECT = 2;
    public static final int BUFFER_REPLACEMENT_MODE_DISABLED = 0;
    public static final int BUFFER_REPLACEMENT_MODE_NORMAL = 1;
    private final int bufferReplacementMode;
    public final CryptoInfo cryptoInfo;
    public ByteBuffer data;
    public ByteBuffer supplementalData;
    public long timeUs;
    public boolean waitingForKeys;

    public DecoderInputBuffer(int v) {
        this.cryptoInfo = new CryptoInfo();
        this.bufferReplacementMode = v;
    }

    @Override  // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        ByteBuffer byteBuffer0 = this.data;
        if(byteBuffer0 != null) {
            byteBuffer0.clear();
        }
        ByteBuffer byteBuffer1 = this.supplementalData;
        if(byteBuffer1 != null) {
            byteBuffer1.clear();
        }
        this.waitingForKeys = false;
    }

    private ByteBuffer createReplacementByteBuffer(int v) {
        int v1 = this.bufferReplacementMode;
        if(v1 == 1) {
            return ByteBuffer.allocate(v);
        }
        if(v1 != 2) {
            throw new IllegalStateException("Buffer too small (" + (this.data == null ? 0 : this.data.capacity()) + " < " + v + ")");
        }
        return ByteBuffer.allocateDirect(v);
    }

    @EnsuresNonNull({"data"})
    public void ensureSpaceForWrite(int v) {
        ByteBuffer byteBuffer0 = this.data;
        if(byteBuffer0 == null) {
            this.data = this.createReplacementByteBuffer(v);
            return;
        }
        int v1 = this.data.position();
        int v2 = v + v1;
        if(byteBuffer0.capacity() >= v2) {
            return;
        }
        ByteBuffer byteBuffer1 = this.createReplacementByteBuffer(v2);
        byteBuffer1.order(this.data.order());
        if(v1 > 0) {
            this.data.flip();
            byteBuffer1.put(this.data);
        }
        this.data = byteBuffer1;
    }

    public final void flip() {
        this.data.flip();
        ByteBuffer byteBuffer0 = this.supplementalData;
        if(byteBuffer0 != null) {
            byteBuffer0.flip();
        }
    }

    public final boolean isEncrypted() {
        return this.getFlag(0x40000000);
    }

    public final boolean isFlagsOnly() {
        return this.data == null && this.bufferReplacementMode == 0;
    }

    public static DecoderInputBuffer newFlagsOnlyInstance() {
        return new DecoderInputBuffer(0);
    }

    @EnsuresNonNull({"supplementalData"})
    public void resetSupplementalData(int v) {
        if(this.supplementalData != null && this.supplementalData.capacity() >= v) {
            this.supplementalData.clear();
            return;
        }
        this.supplementalData = ByteBuffer.allocate(v);
    }
}

