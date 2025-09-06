package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import java.nio.ByteBuffer;

public class VideoDecoderOutputBuffer extends OutputBuffer {
    public interface Owner {
        void releaseOutputBuffer(VideoDecoderOutputBuffer arg1);
    }

    public static final int COLORSPACE_BT2020 = 3;
    public static final int COLORSPACE_BT601 = 1;
    public static final int COLORSPACE_BT709 = 2;
    public static final int COLORSPACE_UNKNOWN;
    public ColorInfo colorInfo;
    public int colorspace;
    public ByteBuffer data;
    public int decoderPrivate;
    public int height;
    public int mode;
    private final Owner owner;
    public ByteBuffer supplementalData;
    public int width;
    public ByteBuffer[] yuvPlanes;
    public int[] yuvStrides;

    public VideoDecoderOutputBuffer(Owner videoDecoderOutputBuffer$Owner0) {
        this.owner = videoDecoderOutputBuffer$Owner0;
    }

    public void init(long v, int v1, ByteBuffer byteBuffer0) {
        this.timeUs = v;
        this.mode = v1;
        if(byteBuffer0 != null && byteBuffer0.hasRemaining()) {
            this.addFlag(0x10000000);
            int v2 = byteBuffer0.limit();
            if(this.supplementalData == null || this.supplementalData.capacity() < v2) {
                this.supplementalData = ByteBuffer.allocate(v2);
            }
            else {
                this.supplementalData.clear();
            }
            this.supplementalData.put(byteBuffer0);
            this.supplementalData.flip();
            byteBuffer0.position(0);
            return;
        }
        this.supplementalData = null;
    }

    public void initForPrivateFrame(int v, int v1) {
        this.width = v;
        this.height = v1;
    }

    public boolean initForYuvFrame(int v, int v1, int v2, int v3, int v4) {
        this.width = v;
        this.height = v1;
        this.colorspace = v4;
        int v5 = (int)((((long)v1) + 1L) / 2L);
        if(VideoDecoderOutputBuffer.isSafeToMultiply(v2, v1) && VideoDecoderOutputBuffer.isSafeToMultiply(v3, v5)) {
            int v6 = v1 * v2;
            int v7 = v5 * v3;
            int v8 = v7 * 2 + v6;
            if(VideoDecoderOutputBuffer.isSafeToMultiply(v7, 2) && v8 >= v6) {
                if(this.data == null || this.data.capacity() < v8) {
                    this.data = ByteBuffer.allocateDirect(v8);
                }
                else {
                    this.data.position(0);
                    this.data.limit(v8);
                }
                if(this.yuvPlanes == null) {
                    this.yuvPlanes = new ByteBuffer[3];
                }
                ByteBuffer byteBuffer0 = this.data;
                ByteBuffer[] arr_byteBuffer = this.yuvPlanes;
                ByteBuffer byteBuffer1 = byteBuffer0.slice();
                arr_byteBuffer[0] = byteBuffer1;
                byteBuffer1.limit(v6);
                byteBuffer0.position(v6);
                ByteBuffer byteBuffer2 = byteBuffer0.slice();
                arr_byteBuffer[1] = byteBuffer2;
                byteBuffer2.limit(v7);
                byteBuffer0.position(v6 + v7);
                ByteBuffer byteBuffer3 = byteBuffer0.slice();
                arr_byteBuffer[2] = byteBuffer3;
                byteBuffer3.limit(v7);
                if(this.yuvStrides == null) {
                    this.yuvStrides = new int[3];
                }
                int[] arr_v = this.yuvStrides;
                arr_v[0] = v2;
                arr_v[1] = v3;
                arr_v[2] = v3;
                return true;
            }
        }
        return false;
    }

    private static boolean isSafeToMultiply(int v, int v1) {
        return v >= 0 && v1 >= 0 && (v1 <= 0 || v < 0x7FFFFFFF / v1);
    }

    @Override  // com.google.android.exoplayer2.decoder.OutputBuffer
    public void release() {
        this.owner.releaseOutputBuffer(this);
    }
}

