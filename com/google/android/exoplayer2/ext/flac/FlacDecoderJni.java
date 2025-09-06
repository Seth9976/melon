package com.google.android.exoplayer2.ext.flac;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import java.io.IOException;
import java.nio.ByteBuffer;

final class FlacDecoderJni {
    public static final class FlacFrameDecodeException extends Exception {
        public final int errorCode;

        public FlacFrameDecodeException(String s, int v) {
            super(s);
            this.errorCode = v;
        }
    }

    private static final int TEMP_BUFFER_SIZE = 0x2000;
    private ByteBuffer byteBufferData;
    private boolean endOfExtractorInput;
    private ExtractorInput extractorInput;
    private final long nativeDecoderContext;
    private byte[] tempBuffer;

    public FlacDecoderJni() {
        if(!FlacLibrary.isAvailable()) {
            throw new FlacDecoderException("Failed to load decoder native libraries.");
        }
        long v = this.flacInit();
        this.nativeDecoderContext = v;
        if(v == 0L) {
            throw new FlacDecoderException("Failed to initialize decoder");
        }
    }

    public void clearData() {
        this.byteBufferData = null;
        this.extractorInput = null;
    }

    public void decodeSample(ByteBuffer byteBuffer0) {
        int v;
        byteBuffer0.clear();
        if(byteBuffer0.isDirect()) {
            v = this.flacDecodeToBuffer(this.nativeDecoderContext, byteBuffer0);
        }
        else {
            byte[] arr_b = byteBuffer0.array();
            v = this.flacDecodeToArray(this.nativeDecoderContext, arr_b);
        }
        if(v < 0) {
            if(!this.isDecoderAtEndOfInput()) {
                throw new FlacFrameDecodeException("Cannot decode FLAC frame", v);
            }
            byteBuffer0.limit(0);
            return;
        }
        byteBuffer0.limit(v);
    }

    public void decodeSampleWithBacktrackPosition(ByteBuffer byteBuffer0, long v) {
        try {
            this.decodeSample(byteBuffer0);
        }
        catch(IOException iOException0) {
            if(v >= 0L) {
                this.reset(v);
                ExtractorInput extractorInput0 = this.extractorInput;
                if(extractorInput0 != null) {
                    extractorInput0.setRetryPosition(v, iOException0);
                }
            }
            throw iOException0;
        }
    }

    public FlacStreamMetadata decodeStreamMetadata() {
        FlacStreamMetadata flacStreamMetadata0 = this.flacDecodeMetadata(this.nativeDecoderContext);
        if(flacStreamMetadata0 == null) {
            throw new ParserException("Failed to decode stream metadata");
        }
        return flacStreamMetadata0;
    }

    private native FlacStreamMetadata flacDecodeMetadata(long arg1) {
    }

    private native int flacDecodeToArray(long arg1, byte[] arg2) {
    }

    private native int flacDecodeToBuffer(long arg1, ByteBuffer arg2) {
    }

    private native void flacFlush(long arg1) {
    }

    private native long flacGetDecodePosition(long arg1) {
    }

    private native long flacGetLastFrameFirstSampleIndex(long arg1) {
    }

    private native long flacGetLastFrameTimestamp(long arg1) {
    }

    private native long flacGetNextFrameFirstSampleIndex(long arg1) {
    }

    private native boolean flacGetSeekPoints(long arg1, long arg2, long[] arg3) {
    }

    private native String flacGetStateString(long arg1) {
    }

    private native long flacInit() {
    }

    private native boolean flacIsDecoderAtEndOfStream(long arg1) {
    }

    private native void flacRelease(long arg1) {
    }

    private native void flacReset(long arg1, long arg2) {
    }

    public void flush() {
        this.flacFlush(this.nativeDecoderContext);
    }

    public long getDecodePosition() {
        return this.flacGetDecodePosition(this.nativeDecoderContext);
    }

    public long getLastFrameFirstSampleIndex() {
        return this.flacGetLastFrameFirstSampleIndex(this.nativeDecoderContext);
    }

    public long getLastFrameTimestamp() {
        return this.flacGetLastFrameTimestamp(this.nativeDecoderContext);
    }

    public long getNextFrameFirstSampleIndex() {
        return this.flacGetNextFrameFirstSampleIndex(this.nativeDecoderContext);
    }

    public SeekPoints getSeekPoints(long v) {
        long[] arr_v = new long[4];
        if(!this.flacGetSeekPoints(this.nativeDecoderContext, v, arr_v)) {
            return null;
        }
        SeekPoint seekPoint0 = new SeekPoint(arr_v[0], arr_v[1]);
        return arr_v[2] == arr_v[0] ? new SeekPoints(seekPoint0, seekPoint0) : new SeekPoints(seekPoint0, new SeekPoint(arr_v[2], arr_v[3]));
    }

    public String getStateString() {
        return this.flacGetStateString(this.nativeDecoderContext);
    }

    public boolean isDecoderAtEndOfInput() {
        return this.flacIsDecoderAtEndOfStream(this.nativeDecoderContext);
    }

    public boolean isEndOfData() {
        ByteBuffer byteBuffer0 = this.byteBufferData;
        if(byteBuffer0 != null) {
            return byteBuffer0.remaining() == 0;
        }
        return this.extractorInput == null ? true : this.endOfExtractorInput;
    }

    public int read(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.remaining();
        ByteBuffer byteBuffer1 = this.byteBufferData;
        if(byteBuffer1 != null) {
            int v1 = Math.min(v, byteBuffer1.remaining());
            int v2 = this.byteBufferData.limit();
            this.byteBufferData.limit(this.byteBufferData.position() + v1);
            byteBuffer0.put(this.byteBufferData);
            this.byteBufferData.limit(v2);
            return v1;
        }
        ExtractorInput extractorInput0 = this.extractorInput;
        if(extractorInput0 != null) {
            byte[] arr_b = this.tempBuffer;
            int v3 = Math.min(v, 0x2000);
            int v4 = this.readFromExtractorInput(extractorInput0, arr_b, 0, v3);
            if(v4 < 4) {
                v4 += this.readFromExtractorInput(extractorInput0, arr_b, v4, v3 - v4);
            }
            byteBuffer0.put(arr_b, 0, v4);
            return v4;
        }
        return -1;
    }

    private int readFromExtractorInput(ExtractorInput extractorInput0, byte[] arr_b, int v, int v1) {
        int v2 = extractorInput0.read(arr_b, v, v1);
        if(v2 == -1) {
            this.endOfExtractorInput = true;
            return 0;
        }
        return v2;
    }

    public void release() {
        this.flacRelease(this.nativeDecoderContext);
    }

    public void reset(long v) {
        this.flacReset(this.nativeDecoderContext, v);
    }

    public void setData(ExtractorInput extractorInput0) {
        this.byteBufferData = null;
        this.extractorInput = extractorInput0;
        this.endOfExtractorInput = false;
        if(this.tempBuffer == null) {
            this.tempBuffer = new byte[0x2000];
        }
    }

    public void setData(ByteBuffer byteBuffer0) {
        this.byteBufferData = byteBuffer0;
        this.extractorInput = null;
    }
}

