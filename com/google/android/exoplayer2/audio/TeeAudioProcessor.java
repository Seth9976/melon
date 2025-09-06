package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class TeeAudioProcessor extends BaseAudioProcessor {
    public interface AudioBufferSink {
        void flush(int arg1, int arg2, int arg3);

        void handleBuffer(ByteBuffer arg1);
    }

    public static final class WavFileAudioBufferSink implements AudioBufferSink {
        private static final int FILE_SIZE_MINUS_44_OFFSET = 40;
        private static final int FILE_SIZE_MINUS_8_OFFSET = 4;
        private static final int HEADER_LENGTH = 44;
        private static final String TAG = "WaveFileAudioBufferSink";
        private int bytesWritten;
        private int channelCount;
        private int counter;
        private int encoding;
        private final String outputFileNamePrefix;
        private RandomAccessFile randomAccessFile;
        private int sampleRateHz;
        private final byte[] scratchBuffer;
        private final ByteBuffer scratchByteBuffer;

        public WavFileAudioBufferSink(String s) {
            this.outputFileNamePrefix = s;
            byte[] arr_b = new byte[0x400];
            this.scratchBuffer = arr_b;
            this.scratchByteBuffer = ByteBuffer.wrap(arr_b).order(ByteOrder.LITTLE_ENDIAN);
        }

        @Override  // com.google.android.exoplayer2.audio.TeeAudioProcessor$AudioBufferSink
        public void flush(int v, int v1, int v2) {
            try {
                this.reset();
            }
            catch(IOException iOException0) {
                Log.e("WaveFileAudioBufferSink", "Error resetting", iOException0);
            }
            this.sampleRateHz = v;
            this.channelCount = v1;
            this.encoding = v2;
        }

        private String getNextOutputFileName() {
            int v = this.counter;
            this.counter = v + 1;
            return Util.formatInvariant("%s-%04d.wav", new Object[]{this.outputFileNamePrefix, v});
        }

        @Override  // com.google.android.exoplayer2.audio.TeeAudioProcessor$AudioBufferSink
        public void handleBuffer(ByteBuffer byteBuffer0) {
            try {
                this.maybePrepareFile();
                this.writeBuffer(byteBuffer0);
            }
            catch(IOException iOException0) {
                Log.e("WaveFileAudioBufferSink", "Error writing data", iOException0);
            }
        }

        private void maybePrepareFile() {
            if(this.randomAccessFile != null) {
                return;
            }
            RandomAccessFile randomAccessFile0 = new RandomAccessFile(this.getNextOutputFileName(), "rw");
            this.writeFileHeader(randomAccessFile0);
            this.randomAccessFile = randomAccessFile0;
            this.bytesWritten = 44;
        }

        private void reset() {
            RandomAccessFile randomAccessFile0;
            try {
                randomAccessFile0 = this.randomAccessFile;
                if(randomAccessFile0 == null) {
                    return;
                }
                this.scratchByteBuffer.clear();
                this.scratchByteBuffer.putInt(this.bytesWritten - 8);
                randomAccessFile0.seek(4L);
                randomAccessFile0.write(this.scratchBuffer, 0, 4);
                this.scratchByteBuffer.clear();
                this.scratchByteBuffer.putInt(this.bytesWritten - 44);
                randomAccessFile0.seek(40L);
                randomAccessFile0.write(this.scratchBuffer, 0, 4);
            }
            catch(IOException iOException0) {
                Log.w("WaveFileAudioBufferSink", "Error updating file size", iOException0);
            }
            try {
                randomAccessFile0.close();
                this.randomAccessFile = null;
            }
            catch(Throwable throwable0) {
                this.randomAccessFile = null;
                throw throwable0;
            }
        }

        private void writeBuffer(ByteBuffer byteBuffer0) {
            RandomAccessFile randomAccessFile0 = (RandomAccessFile)Assertions.checkNotNull(this.randomAccessFile);
            while(byteBuffer0.hasRemaining()) {
                int v = Math.min(byteBuffer0.remaining(), this.scratchBuffer.length);
                byteBuffer0.get(this.scratchBuffer, 0, v);
                randomAccessFile0.write(this.scratchBuffer, 0, v);
                this.bytesWritten += v;
            }
        }

        private void writeFileHeader(RandomAccessFile randomAccessFile0) {
            randomAccessFile0.writeInt(1380533830);
            randomAccessFile0.writeInt(-1);
            randomAccessFile0.writeInt(0x57415645);
            randomAccessFile0.writeInt(0x666D7420);
            this.scratchByteBuffer.clear();
            this.scratchByteBuffer.putInt(16);
            int v = (short)WavUtil.getTypeForPcmEncoding(this.encoding);
            this.scratchByteBuffer.putShort(((short)v));
            this.scratchByteBuffer.putShort(((short)this.channelCount));
            this.scratchByteBuffer.putInt(this.sampleRateHz);
            int v1 = Util.getPcmFrameSize(this.encoding, this.channelCount);
            this.scratchByteBuffer.putInt(this.sampleRateHz * v1);
            this.scratchByteBuffer.putShort(((short)v1));
            this.scratchByteBuffer.putShort(((short)(v1 * 8 / this.channelCount)));
            randomAccessFile0.write(this.scratchBuffer, 0, this.scratchByteBuffer.position());
            randomAccessFile0.writeInt(1684108385);
            randomAccessFile0.writeInt(-1);
        }
    }

    private final AudioBufferSink audioBufferSink;

    public TeeAudioProcessor(AudioBufferSink teeAudioProcessor$AudioBufferSink0) {
        this.audioBufferSink = (AudioBufferSink)Assertions.checkNotNull(teeAudioProcessor$AudioBufferSink0);
    }

    private void flushSinkIfActive() {
        if(this.isActive()) {
            this.audioBufferSink.flush(this.inputAudioFormat.sampleRate, this.inputAudioFormat.channelCount, this.inputAudioFormat.encoding);
        }
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioFormat onConfigure(AudioFormat audioProcessor$AudioFormat0) {
        return audioProcessor$AudioFormat0;
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        this.flushSinkIfActive();
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onQueueEndOfStream() {
        this.flushSinkIfActive();
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        this.flushSinkIfActive();
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.remaining();
        if(v == 0) {
            return;
        }
        ByteBuffer byteBuffer1 = byteBuffer0.asReadOnlyBuffer();
        this.audioBufferSink.handleBuffer(byteBuffer1);
        this.replaceOutputBuffer(v).put(byteBuffer0).flip();
    }
}

