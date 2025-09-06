package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

final class ChannelMappingAudioProcessor extends BaseAudioProcessor {
    private int[] outputChannels;
    private int[] pendingOutputChannels;

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioFormat onConfigure(AudioFormat audioProcessor$AudioFormat0) {
        int[] arr_v = this.pendingOutputChannels;
        if(arr_v == null) {
            return AudioFormat.NOT_SET;
        }
        if(audioProcessor$AudioFormat0.encoding != 2) {
            throw new UnhandledAudioFormatException(audioProcessor$AudioFormat0);
        }
        int v = audioProcessor$AudioFormat0.channelCount == arr_v.length ? 0 : 1;
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            int v2 = arr_v[v1];
            if(v2 >= audioProcessor$AudioFormat0.channelCount) {
                throw new UnhandledAudioFormatException(audioProcessor$AudioFormat0);
            }
            v |= (v2 == v1 ? 0 : 1);
        }
        return v == 0 ? AudioFormat.NOT_SET : new AudioFormat(audioProcessor$AudioFormat0.sampleRate, arr_v.length, 2);
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        this.outputChannels = this.pendingOutputChannels;
    }

    @Override  // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        this.outputChannels = null;
        this.pendingOutputChannels = null;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer0) {
        int[] arr_v = (int[])Assertions.checkNotNull(this.outputChannels);
        int v = byteBuffer0.position();
        int v1 = byteBuffer0.limit();
        ByteBuffer byteBuffer1 = this.replaceOutputBuffer((v1 - v) / this.inputAudioFormat.bytesPerFrame * this.outputAudioFormat.bytesPerFrame);
        while(v < v1) {
            for(int v2 = 0; v2 < arr_v.length; ++v2) {
                byteBuffer1.putShort(byteBuffer0.getShort(arr_v[v2] * 2 + v));
            }
            v += this.inputAudioFormat.bytesPerFrame;
        }
        byteBuffer0.position(v1);
        byteBuffer1.flip();
    }

    public void setChannelMap(int[] arr_v) {
        this.pendingOutputChannels = arr_v;
    }
}

