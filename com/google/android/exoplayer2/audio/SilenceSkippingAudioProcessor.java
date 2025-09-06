package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class SilenceSkippingAudioProcessor extends BaseAudioProcessor {
    public static final long DEFAULT_MINIMUM_SILENCE_DURATION_US = 150000L;
    public static final long DEFAULT_PADDING_SILENCE_US = 20000L;
    public static final short DEFAULT_SILENCE_THRESHOLD_LEVEL = 0x400;
    private static final int STATE_MAYBE_SILENT = 1;
    private static final int STATE_NOISY = 0;
    private static final int STATE_SILENT = 2;
    private int bytesPerFrame;
    private boolean enabled;
    private boolean hasOutputNoise;
    private byte[] maybeSilenceBuffer;
    private int maybeSilenceBufferSize;
    private final long minimumSilenceDurationUs;
    private byte[] paddingBuffer;
    private final long paddingSilenceUs;
    private int paddingSize;
    private final short silenceThresholdLevel;
    private long skippedFrames;
    private int state;

    public SilenceSkippingAudioProcessor() {
        this(150000L, 20000L, 0x400);
    }

    public SilenceSkippingAudioProcessor(long v, long v1, short v2) {
        Assertions.checkArgument(v1 <= v);
        this.minimumSilenceDurationUs = v;
        this.paddingSilenceUs = v1;
        this.silenceThresholdLevel = v2;
        this.maybeSilenceBuffer = Util.EMPTY_BYTE_ARRAY;
        this.paddingBuffer = Util.EMPTY_BYTE_ARRAY;
    }

    private int durationUsToFrames(long v) {
        return (int)(v * ((long)this.inputAudioFormat.sampleRate) / 1000000L);
    }

    private int findNoiseLimit(ByteBuffer byteBuffer0) {
        Assertions.checkArgument(byteBuffer0.order() == ByteOrder.LITTLE_ENDIAN);
        for(int v = byteBuffer0.limit() - 2; v >= byteBuffer0.position(); v -= 2) {
            if(Math.abs(byteBuffer0.getShort(v)) > this.silenceThresholdLevel) {
                return v / this.bytesPerFrame * this.bytesPerFrame + this.bytesPerFrame;
            }
        }
        return byteBuffer0.position();
    }

    private int findNoisePosition(ByteBuffer byteBuffer0) {
        Assertions.checkArgument(byteBuffer0.order() == ByteOrder.LITTLE_ENDIAN);
        for(int v = byteBuffer0.position(); v < byteBuffer0.limit(); v += 2) {
            if(Math.abs(byteBuffer0.getShort(v)) > this.silenceThresholdLevel) {
                return v / this.bytesPerFrame * this.bytesPerFrame;
            }
        }
        return byteBuffer0.limit();
    }

    public long getSkippedFrames() {
        return this.skippedFrames;
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public boolean isActive() {
        return this.enabled;
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioFormat onConfigure(AudioFormat audioProcessor$AudioFormat0) {
        if(audioProcessor$AudioFormat0.encoding != 2) {
            throw new UnhandledAudioFormatException(audioProcessor$AudioFormat0);
        }
        return this.enabled ? audioProcessor$AudioFormat0 : AudioFormat.NOT_SET;
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        if(this.enabled) {
            this.bytesPerFrame = this.inputAudioFormat.bytesPerFrame;
            int v = this.durationUsToFrames(this.minimumSilenceDurationUs) * this.bytesPerFrame;
            if(this.maybeSilenceBuffer.length != v) {
                this.maybeSilenceBuffer = new byte[v];
            }
            int v1 = this.durationUsToFrames(this.paddingSilenceUs) * this.bytesPerFrame;
            this.paddingSize = v1;
            if(this.paddingBuffer.length != v1) {
                this.paddingBuffer = new byte[v1];
            }
        }
        this.state = 0;
        this.skippedFrames = 0L;
        this.maybeSilenceBufferSize = 0;
        this.hasOutputNoise = false;
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onQueueEndOfStream() {
        int v = this.maybeSilenceBufferSize;
        if(v > 0) {
            this.output(this.maybeSilenceBuffer, v);
        }
        if(!this.hasOutputNoise) {
            this.skippedFrames += (long)(this.paddingSize / this.bytesPerFrame);
        }
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        this.enabled = false;
        this.paddingSize = 0;
        this.maybeSilenceBuffer = Util.EMPTY_BYTE_ARRAY;
        this.paddingBuffer = Util.EMPTY_BYTE_ARRAY;
    }

    private void output(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.remaining();
        this.replaceOutputBuffer(v).put(byteBuffer0).flip();
        if(v > 0) {
            this.hasOutputNoise = true;
        }
    }

    private void output(byte[] arr_b, int v) {
        this.replaceOutputBuffer(v).put(arr_b, 0, v).flip();
        if(v > 0) {
            this.hasOutputNoise = true;
        }
    }

    private void processMaybeSilence(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.limit();
        int v1 = this.findNoisePosition(byteBuffer0);
        int v2 = v1 - byteBuffer0.position();
        byte[] arr_b = this.maybeSilenceBuffer;
        int v3 = this.maybeSilenceBufferSize;
        int v4 = arr_b.length - v3;
        if(v1 < v && v2 < v4) {
            this.output(arr_b, v3);
            this.maybeSilenceBufferSize = 0;
            this.state = 0;
            return;
        }
        int v5 = Math.min(v2, v4);
        byteBuffer0.limit(byteBuffer0.position() + v5);
        byteBuffer0.get(this.maybeSilenceBuffer, this.maybeSilenceBufferSize, v5);
        int v6 = this.maybeSilenceBufferSize + v5;
        this.maybeSilenceBufferSize = v6;
        byte[] arr_b1 = this.maybeSilenceBuffer;
        if(v6 == arr_b1.length) {
            if(this.hasOutputNoise) {
                this.output(arr_b1, this.paddingSize);
                this.skippedFrames += (long)((this.maybeSilenceBufferSize - this.paddingSize * 2) / this.bytesPerFrame);
            }
            else {
                this.skippedFrames += (long)((v6 - this.paddingSize) / this.bytesPerFrame);
            }
            this.updatePaddingBuffer(byteBuffer0, this.maybeSilenceBuffer, this.maybeSilenceBufferSize);
            this.maybeSilenceBufferSize = 0;
            this.state = 2;
        }
        byteBuffer0.limit(v);
    }

    private void processNoisy(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.limit();
        byteBuffer0.limit(Math.min(v, byteBuffer0.position() + this.maybeSilenceBuffer.length));
        int v1 = this.findNoiseLimit(byteBuffer0);
        if(v1 == byteBuffer0.position()) {
            this.state = 1;
        }
        else {
            byteBuffer0.limit(v1);
            this.output(byteBuffer0);
        }
        byteBuffer0.limit(v);
    }

    private void processSilence(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.limit();
        int v1 = this.findNoisePosition(byteBuffer0);
        byteBuffer0.limit(v1);
        this.skippedFrames += (long)(byteBuffer0.remaining() / this.bytesPerFrame);
        this.updatePaddingBuffer(byteBuffer0, this.paddingBuffer, this.paddingSize);
        if(v1 < v) {
            this.output(this.paddingBuffer, this.paddingSize);
            this.state = 0;
            byteBuffer0.limit(v);
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer0) {
        while(byteBuffer0.hasRemaining() && !this.hasPendingOutput()) {
            switch(this.state) {
                case 0: {
                    this.processNoisy(byteBuffer0);
                    break;
                }
                case 1: {
                    this.processMaybeSilence(byteBuffer0);
                    break;
                }
                case 2: {
                    this.processSilence(byteBuffer0);
                    break;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
        }
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    private void updatePaddingBuffer(ByteBuffer byteBuffer0, byte[] arr_b, int v) {
        int v1 = Math.min(byteBuffer0.remaining(), this.paddingSize);
        int v2 = this.paddingSize - v1;
        System.arraycopy(arr_b, v - v2, this.paddingBuffer, 0, v2);
        byteBuffer0.position(byteBuffer0.limit() - v1);
        byteBuffer0.get(this.paddingBuffer, v2, v1);
    }
}

