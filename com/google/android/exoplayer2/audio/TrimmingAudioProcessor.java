package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

final class TrimmingAudioProcessor extends BaseAudioProcessor {
    private static final int OUTPUT_ENCODING = 2;
    private byte[] endBuffer;
    private int endBufferSize;
    private int pendingTrimStartBytes;
    private boolean reconfigurationPending;
    private int trimEndFrames;
    private int trimStartFrames;
    private long trimmedFrameCount;

    public TrimmingAudioProcessor() {
        this.endBuffer = Util.EMPTY_BYTE_ARRAY;
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public ByteBuffer getOutput() {
        if(super.isEnded()) {
            int v = this.endBufferSize;
            if(v > 0) {
                this.replaceOutputBuffer(v).put(this.endBuffer, 0, this.endBufferSize).flip();
                this.endBufferSize = 0;
            }
        }
        return super.getOutput();
    }

    public long getTrimmedFrameCount() {
        return this.trimmedFrameCount;
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public boolean isEnded() {
        return super.isEnded() && this.endBufferSize == 0;
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioFormat onConfigure(AudioFormat audioProcessor$AudioFormat0) {
        if(audioProcessor$AudioFormat0.encoding != 2) {
            throw new UnhandledAudioFormatException(audioProcessor$AudioFormat0);
        }
        this.reconfigurationPending = true;
        return this.trimStartFrames != 0 || this.trimEndFrames != 0 ? audioProcessor$AudioFormat0 : AudioFormat.NOT_SET;
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        if(this.reconfigurationPending) {
            this.reconfigurationPending = false;
            int v = this.inputAudioFormat.bytesPerFrame;
            this.endBuffer = new byte[this.trimEndFrames * v];
            this.pendingTrimStartBytes = this.trimStartFrames * v;
        }
        this.endBufferSize = 0;
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onQueueEndOfStream() {
        if(this.reconfigurationPending) {
            int v = this.endBufferSize;
            if(v > 0) {
                this.trimmedFrameCount += (long)(v / this.inputAudioFormat.bytesPerFrame);
            }
            this.endBufferSize = 0;
        }
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        this.endBuffer = Util.EMPTY_BYTE_ARRAY;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.position();
        int v1 = byteBuffer0.limit();
        int v2 = v1 - v;
        if(v2 != 0) {
            int v3 = Math.min(v2, this.pendingTrimStartBytes);
            this.trimmedFrameCount += (long)(v3 / this.inputAudioFormat.bytesPerFrame);
            this.pendingTrimStartBytes -= v3;
            byteBuffer0.position(v + v3);
            if(this.pendingTrimStartBytes <= 0) {
                int v4 = v2 - v3;
                int v5 = this.endBufferSize + v4 - this.endBuffer.length;
                ByteBuffer byteBuffer1 = this.replaceOutputBuffer(v5);
                int v6 = Util.constrainValue(v5, 0, this.endBufferSize);
                byteBuffer1.put(this.endBuffer, 0, v6);
                int v7 = Util.constrainValue(v5 - v6, 0, v4);
                byteBuffer0.limit(byteBuffer0.position() + v7);
                byteBuffer1.put(byteBuffer0);
                byteBuffer0.limit(v1);
                int v8 = v4 - v7;
                int v9 = this.endBufferSize - v6;
                this.endBufferSize = v9;
                System.arraycopy(this.endBuffer, v6, this.endBuffer, 0, v9);
                byteBuffer0.get(this.endBuffer, this.endBufferSize, v8);
                this.endBufferSize += v8;
                byteBuffer1.flip();
            }
        }
    }

    public void resetTrimmedFrameCount() {
        this.trimmedFrameCount = 0L;
    }

    public void setTrimFrameCount(int v, int v1) {
        this.trimStartFrames = v;
        this.trimEndFrames = v1;
    }
}

