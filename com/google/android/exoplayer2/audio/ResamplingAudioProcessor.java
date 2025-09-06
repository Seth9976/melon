package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;

final class ResamplingAudioProcessor extends BaseAudioProcessor {
    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioFormat onConfigure(AudioFormat audioProcessor$AudioFormat0) {
        int v = audioProcessor$AudioFormat0.encoding;
        if(v != 2 && v != 3 && (v != 4 && v != 0x10000000 && v != 0x20000000 && v != 0x30000000)) {
            throw new UnhandledAudioFormatException(audioProcessor$AudioFormat0);
        }
        return v == 2 ? AudioFormat.NOT_SET : new AudioFormat(audioProcessor$AudioFormat0.sampleRate, audioProcessor$AudioFormat0.channelCount, 2);
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.position();
        int v1 = byteBuffer0.limit();
        int v2 = v1 - v;
        switch(this.inputAudioFormat.encoding) {
            case 3: {
                v2 *= 2;
                break;
            }
            case 0x10000000: {
                break;
            }
            case 0x20000000: {
                v2 = v2 / 3 * 2;
                break;
            }
            case 4: 
            case 0x30000000: {
                v2 /= 2;
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
        ByteBuffer byteBuffer1 = this.replaceOutputBuffer(v2);
    alab1:
        switch(this.inputAudioFormat.encoding) {
            case 3: {
                while(true) {
                    if(v >= v1) {
                        break alab1;
                    }
                    byteBuffer1.put(0);
                    byteBuffer1.put(((byte)((byteBuffer0.get(v) & 0xFF) - 0x80)));
                    ++v;
                }
            }
            case 4: {
                while(v < v1) {
                    int v3 = (short)(((int)(byteBuffer0.getFloat(v) * 32767.0f)));
                    byteBuffer1.put(((byte)(v3 & 0xFF)));
                    byteBuffer1.put(((byte)(v3 >> 8 & 0xFF)));
                    v += 4;
                }
                break;
            }
            case 0x10000000: {
                while(v < v1) {
                    byteBuffer1.put(byteBuffer0.get(v + 1));
                    byteBuffer1.put(byteBuffer0.get(v));
                    v += 2;
                }
                break;
            }
            case 0x20000000: {
                while(v < v1) {
                    byteBuffer1.put(byteBuffer0.get(v + 1));
                    byteBuffer1.put(byteBuffer0.get(v + 2));
                    v += 3;
                }
                break;
            }
            case 0x30000000: {
                while(v < v1) {
                    byteBuffer1.put(byteBuffer0.get(v + 2));
                    byteBuffer1.put(byteBuffer0.get(v + 3));
                    v += 4;
                }
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
        byteBuffer0.position(byteBuffer0.limit());
        byteBuffer1.flip();
    }
}

