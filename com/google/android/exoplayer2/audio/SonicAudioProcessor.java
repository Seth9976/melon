package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class SonicAudioProcessor implements AudioProcessor {
    private static final float CLOSE_THRESHOLD = 0.01f;
    public static final float MAXIMUM_PITCH = 8.0f;
    public static final float MAXIMUM_SPEED = 8.0f;
    public static final float MINIMUM_PITCH = 0.1f;
    public static final float MINIMUM_SPEED = 0.1f;
    private static final int MIN_BYTES_FOR_SPEEDUP_CALCULATION = 0x400;
    public static final int SAMPLE_RATE_NO_CHANGE = -1;
    private ByteBuffer buffer;
    private AudioFormat inputAudioFormat;
    private long inputBytes;
    private boolean inputEnded;
    private AudioFormat outputAudioFormat;
    private ByteBuffer outputBuffer;
    private long outputBytes;
    private AudioFormat pendingInputAudioFormat;
    private AudioFormat pendingOutputAudioFormat;
    private int pendingOutputSampleRate;
    private boolean pendingSonicRecreation;
    private float pitch;
    private ShortBuffer shortBuffer;
    private Sonic sonic;
    private float speed;

    public SonicAudioProcessor() {
        this.speed = 1.0f;
        this.pitch = 1.0f;
        this.pendingInputAudioFormat = AudioFormat.NOT_SET;
        this.pendingOutputAudioFormat = AudioFormat.NOT_SET;
        this.inputAudioFormat = AudioFormat.NOT_SET;
        this.outputAudioFormat = AudioFormat.NOT_SET;
        this.buffer = AudioProcessor.EMPTY_BUFFER;
        this.shortBuffer = AudioProcessor.EMPTY_BUFFER.asShortBuffer();
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.pendingOutputSampleRate = -1;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public AudioFormat configure(AudioFormat audioProcessor$AudioFormat0) {
        if(audioProcessor$AudioFormat0.encoding != 2) {
            throw new UnhandledAudioFormatException(audioProcessor$AudioFormat0);
        }
        this.pendingInputAudioFormat = audioProcessor$AudioFormat0;
        AudioFormat audioProcessor$AudioFormat1 = new AudioFormat((this.pendingOutputSampleRate == -1 ? audioProcessor$AudioFormat0.sampleRate : this.pendingOutputSampleRate), audioProcessor$AudioFormat0.channelCount, 2);
        this.pendingOutputAudioFormat = audioProcessor$AudioFormat1;
        this.pendingSonicRecreation = true;
        return audioProcessor$AudioFormat1;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if(this.isActive()) {
            AudioFormat audioProcessor$AudioFormat0 = this.pendingInputAudioFormat;
            this.inputAudioFormat = audioProcessor$AudioFormat0;
            AudioFormat audioProcessor$AudioFormat1 = this.pendingOutputAudioFormat;
            this.outputAudioFormat = audioProcessor$AudioFormat1;
            if(this.pendingSonicRecreation) {
                this.sonic = new Sonic(audioProcessor$AudioFormat0.sampleRate, audioProcessor$AudioFormat0.channelCount, this.speed, this.pitch, audioProcessor$AudioFormat1.sampleRate);
            }
            else {
                Sonic sonic0 = this.sonic;
                if(sonic0 != null) {
                    sonic0.flush();
                }
            }
        }
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.inputBytes = 0L;
        this.outputBytes = 0L;
        this.inputEnded = false;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer0 = this.outputBuffer;
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        return byteBuffer0;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.pendingOutputAudioFormat.sampleRate != -1 && (Math.abs(this.speed - 1.0f) >= 0.01f || Math.abs(this.pitch - 1.0f) >= 0.01f || this.pendingOutputAudioFormat.sampleRate != this.pendingInputAudioFormat.sampleRate);
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        return this.inputEnded && (this.sonic == null || this.sonic.getOutputSize() == 0);
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        Sonic sonic0 = this.sonic;
        if(sonic0 != null) {
            sonic0.queueEndOfStream();
        }
        this.inputEnded = true;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer0) {
        Sonic sonic0 = (Sonic)Assertions.checkNotNull(this.sonic);
        if(byteBuffer0.hasRemaining()) {
            ShortBuffer shortBuffer0 = byteBuffer0.asShortBuffer();
            int v = byteBuffer0.remaining();
            this.inputBytes += (long)v;
            sonic0.queueInput(shortBuffer0);
            byteBuffer0.position(byteBuffer0.position() + v);
        }
        int v1 = sonic0.getOutputSize();
        if(v1 > 0) {
            if(this.buffer.capacity() < v1) {
                ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(v1).order(ByteOrder.nativeOrder());
                this.buffer = byteBuffer1;
                this.shortBuffer = byteBuffer1.asShortBuffer();
            }
            else {
                this.buffer.clear();
                this.shortBuffer.clear();
            }
            sonic0.getOutput(this.shortBuffer);
            this.outputBytes += (long)v1;
            this.buffer.limit(v1);
            this.outputBuffer = this.buffer;
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.speed = 1.0f;
        this.pitch = 1.0f;
        this.pendingInputAudioFormat = AudioFormat.NOT_SET;
        this.pendingOutputAudioFormat = AudioFormat.NOT_SET;
        this.inputAudioFormat = AudioFormat.NOT_SET;
        this.outputAudioFormat = AudioFormat.NOT_SET;
        this.buffer = AudioProcessor.EMPTY_BUFFER;
        this.shortBuffer = AudioProcessor.EMPTY_BUFFER.asShortBuffer();
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.pendingOutputSampleRate = -1;
        this.pendingSonicRecreation = false;
        this.sonic = null;
        this.inputBytes = 0L;
        this.outputBytes = 0L;
        this.inputEnded = false;
    }

    public long scaleDurationForSpeedup(long v) {
        long v1 = this.outputBytes;
        if(v1 >= 0x400L) {
            int v2 = this.outputAudioFormat.sampleRate;
            int v3 = this.inputAudioFormat.sampleRate;
            return v2 == v3 ? Util.scaleLargeTimestamp(v, this.inputBytes, v1) : Util.scaleLargeTimestamp(v, this.inputBytes * ((long)v2), v1 * ((long)v3));
        }
        return (long)(((double)this.speed) * ((double)v));
    }

    public void setOutputSampleRateHz(int v) {
        this.pendingOutputSampleRate = v;
    }

    public float setPitch(float f) {
        float f1 = Util.constrainValue(f, 0.1f, 8.0f);
        if(this.pitch != f1) {
            this.pitch = f1;
            this.pendingSonicRecreation = true;
        }
        return f1;
    }

    public float setSpeed(float f) {
        float f1 = Util.constrainValue(f, 0.1f, 8.0f);
        if(this.speed != f1) {
            this.speed = f1;
            this.pendingSonicRecreation = true;
        }
        return f1;
    }
}

