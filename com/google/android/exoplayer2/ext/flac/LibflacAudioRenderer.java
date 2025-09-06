package com.google.android.exoplayer2.ext.flac;

import android.os.Handler;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import com.google.android.exoplayer2.util.Util;

public final class LibflacAudioRenderer extends SimpleDecoderAudioRenderer {
    private static final int NUM_BUFFERS = 16;
    private FlacStreamMetadata streamMetadata;

    public LibflacAudioRenderer() {
        this(null, null, new AudioProcessor[0]);
    }

    public LibflacAudioRenderer(Handler handler0, AudioRendererEventListener audioRendererEventListener0, AudioSink audioSink0) {
        super(handler0, audioRendererEventListener0, null, false, audioSink0);
    }

    public LibflacAudioRenderer(Handler handler0, AudioRendererEventListener audioRendererEventListener0, AudioProcessor[] arr_audioProcessor) {
        super(handler0, audioRendererEventListener0, arr_audioProcessor);
    }

    @Override  // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer
    public SimpleDecoder createDecoder(Format format0, ExoMediaCrypto exoMediaCrypto0) {
        return this.createDecoder(format0, exoMediaCrypto0);
    }

    public FlacDecoder createDecoder(Format format0, ExoMediaCrypto exoMediaCrypto0) {
        FlacDecoder flacDecoder0 = new FlacDecoder(16, 16, format0.maxInputSize, format0.initializationData);
        this.streamMetadata = flacDecoder0.getStreamMetadata();
        return flacDecoder0;
    }

    @Override  // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer
    public Format getOutputFormat() {
        Assertions.checkNotNull(this.streamMetadata);
        return Format.createAudioSampleFormat(null, "audio/raw", null, -1, -1, this.streamMetadata.channels, this.streamMetadata.sampleRate, Util.getPcmEncoding(this.streamMetadata.bitsPerSample), null, null, 0, null);
    }

    @Override  // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer
    public int supportsFormatInternal(DrmSessionManager drmSessionManager0, Format format0) {
        if(FlacLibrary.isAvailable() && "audio/flac".equalsIgnoreCase(format0.sampleMimeType)) {
            int v = format0.initializationData.isEmpty() ? 2 : Util.getPcmEncoding(new FlacStreamMetadata(((byte[])format0.initializationData.get(0)), 8).bitsPerSample);
            if(!this.supportsOutput(format0.channelCount, v)) {
                return 1;
            }
            return BaseRenderer.supportsFormatDrm(drmSessionManager0, format0.drmInitData) ? 4 : 2;
        }
        return 0;
    }
}

