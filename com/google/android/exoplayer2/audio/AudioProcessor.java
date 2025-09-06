package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface AudioProcessor {
    public static final class AudioFormat {
        public static final AudioFormat NOT_SET;
        public final int bytesPerFrame;
        public final int channelCount;
        public final int encoding;
        public final int sampleRate;

        static {
            AudioFormat.NOT_SET = new AudioFormat(-1, -1, -1);
        }

        public AudioFormat(int v, int v1, int v2) {
            this.sampleRate = v;
            this.channelCount = v1;
            this.encoding = v2;
            this.bytesPerFrame = Util.isEncodingLinearPcm(v2) ? Util.getPcmFrameSize(v2, v1) : -1;
        }

        @Override
        public String toString() {
            return "AudioFormat[sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + ", encoding=" + this.encoding + ']';
        }
    }

    public static final class UnhandledAudioFormatException extends Exception {
        public UnhandledAudioFormatException(AudioFormat audioProcessor$AudioFormat0) {
            super("Unhandled format: " + audioProcessor$AudioFormat0);
        }
    }

    public static final ByteBuffer EMPTY_BUFFER;

    static {
        AudioProcessor.EMPTY_BUFFER = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
    }

    AudioFormat configure(AudioFormat arg1);

    void flush();

    ByteBuffer getOutput();

    boolean isActive();

    boolean isEnded();

    void queueEndOfStream();

    void queueInput(ByteBuffer arg1);

    void reset();
}

