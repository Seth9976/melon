package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class BaseAudioProcessor implements AudioProcessor {
    private ByteBuffer buffer;
    protected AudioFormat inputAudioFormat;
    private boolean inputEnded;
    protected AudioFormat outputAudioFormat;
    private ByteBuffer outputBuffer;
    private AudioFormat pendingInputAudioFormat;
    private AudioFormat pendingOutputAudioFormat;

    public BaseAudioProcessor() {
        this.buffer = AudioProcessor.EMPTY_BUFFER;
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.pendingInputAudioFormat = AudioFormat.NOT_SET;
        this.pendingOutputAudioFormat = AudioFormat.NOT_SET;
        this.inputAudioFormat = AudioFormat.NOT_SET;
        this.outputAudioFormat = AudioFormat.NOT_SET;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public final AudioFormat configure(AudioFormat audioProcessor$AudioFormat0) {
        this.pendingInputAudioFormat = audioProcessor$AudioFormat0;
        this.pendingOutputAudioFormat = this.onConfigure(audioProcessor$AudioFormat0);
        return this.isActive() ? this.pendingOutputAudioFormat : AudioFormat.NOT_SET;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public final void flush() {
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.inputEnded = false;
        this.inputAudioFormat = this.pendingInputAudioFormat;
        this.outputAudioFormat = this.pendingOutputAudioFormat;
        this.onFlush();
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer0 = this.outputBuffer;
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        return byteBuffer0;
    }

    public final boolean hasPendingOutput() {
        return this.outputBuffer.hasRemaining();
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.pendingOutputAudioFormat != AudioFormat.NOT_SET;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        return this.inputEnded && this.outputBuffer == AudioProcessor.EMPTY_BUFFER;
    }

    public AudioFormat onConfigure(AudioFormat audioProcessor$AudioFormat0) {
        return AudioFormat.NOT_SET;
    }

    public void onFlush() {
    }

    public void onQueueEndOfStream() {
    }

    public void onReset() {
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public final void queueEndOfStream() {
        this.inputEnded = true;
        this.onQueueEndOfStream();
    }

    public final ByteBuffer replaceOutputBuffer(int v) {
        if(this.buffer.capacity() < v) {
            this.buffer = ByteBuffer.allocateDirect(v).order(ByteOrder.nativeOrder());
        }
        else {
            this.buffer.clear();
        }
        this.outputBuffer = this.buffer;
        return this.buffer;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public final void reset() {
        this.flush();
        this.buffer = AudioProcessor.EMPTY_BUFFER;
        this.pendingInputAudioFormat = AudioFormat.NOT_SET;
        this.pendingOutputAudioFormat = AudioFormat.NOT_SET;
        this.inputAudioFormat = AudioFormat.NOT_SET;
        this.outputAudioFormat = AudioFormat.NOT_SET;
        this.onReset();
    }
}

