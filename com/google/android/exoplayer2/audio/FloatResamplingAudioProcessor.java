package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

final class FloatResamplingAudioProcessor extends BaseAudioProcessor {
    private static final int FLOAT_NAN_AS_INT = 0;
    private static final double PCM_32_BIT_INT_TO_PCM_32_BIT_FLOAT_FACTOR = 4.656613E-10;

    static {
        FloatResamplingAudioProcessor.FLOAT_NAN_AS_INT = 0x7FC00000;
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioFormat onConfigure(AudioFormat audioProcessor$AudioFormat0) {
        int v = audioProcessor$AudioFormat0.encoding;
        if(!Util.isEncodingHighResolutionPcm(v)) {
            throw new UnhandledAudioFormatException(audioProcessor$AudioFormat0);
        }
        return v == 4 ? AudioFormat.NOT_SET : new AudioFormat(audioProcessor$AudioFormat0.sampleRate, audioProcessor$AudioFormat0.channelCount, 4);
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer0) {
        ByteBuffer byteBuffer1;
        int v = byteBuffer0.position();
        int v1 = byteBuffer0.limit();
        int v2 = v1 - v;
    alab1:
        switch(this.inputAudioFormat.encoding) {
            case 0x20000000: {
                byteBuffer1 = this.replaceOutputBuffer(v2 / 3 * 4);
                while(v < v1) {
                    FloatResamplingAudioProcessor.writePcm32BitFloat((byteBuffer0.get(v) & 0xFF) << 8 | (byteBuffer0.get(v + 1) & 0xFF) << 16 | (byteBuffer0.get(v + 2) & 0xFF) << 24, byteBuffer1);
                    v += 3;
                }
                break;
            }
            case 0x30000000: {
                byteBuffer1 = this.replaceOutputBuffer(v2);
                while(true) {
                    if(v >= v1) {
                        break alab1;
                    }
                    FloatResamplingAudioProcessor.writePcm32BitFloat(byteBuffer0.get(v) & 0xFF | (byteBuffer0.get(v + 1) & 0xFF) << 8 | (byteBuffer0.get(v + 2) & 0xFF) << 16 | (byteBuffer0.get(v + 3) & 0xFF) << 24, byteBuffer1);
                    v += 4;
                }
            }
            default: {
                throw new IllegalStateException();
            }
        }
        byteBuffer0.position(byteBuffer0.limit());
        byteBuffer1.flip();
    }

    private static void writePcm32BitFloat(int v, ByteBuffer byteBuffer0) {
        byteBuffer0.putInt((Float.floatToIntBits(((float)(((double)v) * 4.656613E-10))) == FloatResamplingAudioProcessor.FLOAT_NAN_AS_INT ? 0 : Float.floatToIntBits(((float)(((double)v) * 4.656613E-10)))));
    }
}

