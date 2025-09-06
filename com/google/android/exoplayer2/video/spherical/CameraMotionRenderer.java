package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;

public class CameraMotionRenderer extends BaseRenderer {
    private static final int SAMPLE_WINDOW_DURATION_US = 100000;
    private final DecoderInputBuffer buffer;
    private long lastTimestampUs;
    private CameraMotionListener listener;
    private long offsetUs;
    private final ParsableByteArray scratch;

    public CameraMotionRenderer() {
        super(5);
        this.buffer = new DecoderInputBuffer(1);
        this.scratch = new ParsableByteArray();
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void handleMessage(int v, Object object0) {
        if(v == 7) {
            this.listener = (CameraMotionListener)object0;
            return;
        }
        super.handleMessage(v, object0);
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.hasReadStreamToEnd();
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.resetListener();
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long v, boolean z) {
        this.resetListener();
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] arr_format, long v) {
        this.offsetUs = v;
    }

    private float[] parseMetadata(ByteBuffer byteBuffer0) {
        if(byteBuffer0.remaining() != 16) {
            return null;
        }
        byte[] arr_b = byteBuffer0.array();
        this.scratch.reset(arr_b, byteBuffer0.limit());
        int v = byteBuffer0.arrayOffset();
        this.scratch.setPosition(v + 4);
        float[] arr_f = new float[3];
        for(int v1 = 0; v1 < 3; ++v1) {
            arr_f[v1] = Float.intBitsToFloat(this.scratch.readLittleEndianInt());
        }
        return arr_f;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public void render(long v, long v1) {
        while(!this.hasReadStreamToEnd() && this.lastTimestampUs < v + 100000L) {
            this.buffer.clear();
            if(this.readSource(this.getFormatHolder(), this.buffer, false) != -4 || this.buffer.isEndOfStream()) {
                break;
            }
            this.buffer.flip();
            DecoderInputBuffer decoderInputBuffer0 = this.buffer;
            this.lastTimestampUs = decoderInputBuffer0.timeUs;
            if(this.listener != null) {
                float[] arr_f = this.parseMetadata(decoderInputBuffer0.data);
                if(arr_f != null) {
                    this.listener.onCameraMotion(this.lastTimestampUs - this.offsetUs, arr_f);
                }
            }
        }
    }

    private void resetListener() {
        this.lastTimestampUs = 0L;
        CameraMotionListener cameraMotionListener0 = this.listener;
        if(cameraMotionListener0 != null) {
            cameraMotionListener0.onCameraMotionReset();
        }
    }

    // 去混淆评级： 中等(60)
    @Override  // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format0) {
        return "application/x-camera-motion".equals(format0.sampleMimeType) ? 4 : 0;
    }
}

