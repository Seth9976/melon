package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

public abstract class SimpleSubtitleDecoder extends SimpleDecoder implements SubtitleDecoder {
    private final String name;

    public SimpleSubtitleDecoder(String s) {
        super(new SubtitleInputBuffer[2], new SubtitleOutputBuffer[2]);
        this.name = s;
        this.setInitialInputBufferSize(0x400);
    }

    @Override  // com.google.android.exoplayer2.decoder.SimpleDecoder
    public DecoderInputBuffer createInputBuffer() {
        return this.createInputBuffer();
    }

    public final SubtitleInputBuffer createInputBuffer() {
        return new SubtitleInputBuffer();
    }

    @Override  // com.google.android.exoplayer2.decoder.SimpleDecoder
    public OutputBuffer createOutputBuffer() {
        return this.createOutputBuffer();
    }

    public final SubtitleOutputBuffer createOutputBuffer() {
        return new SimpleSubtitleOutputBuffer(this);
    }

    public final SubtitleDecoderException createUnexpectedDecodeException(Throwable throwable0) {
        return new SubtitleDecoderException("Unexpected decode error", throwable0);
    }

    @Override  // com.google.android.exoplayer2.decoder.SimpleDecoder
    public Exception createUnexpectedDecodeException(Throwable throwable0) {
        return this.createUnexpectedDecodeException(throwable0);
    }

    public abstract Subtitle decode(byte[] arg1, int arg2, boolean arg3);

    public final SubtitleDecoderException decode(SubtitleInputBuffer subtitleInputBuffer0, SubtitleOutputBuffer subtitleOutputBuffer0, boolean z) {
        try {
            ByteBuffer byteBuffer0 = (ByteBuffer)Assertions.checkNotNull(subtitleInputBuffer0.data);
            Subtitle subtitle0 = this.decode(byteBuffer0.array(), byteBuffer0.limit(), z);
            subtitleOutputBuffer0.setContent(subtitleInputBuffer0.timeUs, subtitle0, subtitleInputBuffer0.subsampleOffsetUs);
            subtitleOutputBuffer0.clearFlag(0x80000000);
            return null;
        }
        catch(SubtitleDecoderException subtitleDecoderException0) {
            return subtitleDecoderException0;
        }
    }

    @Override  // com.google.android.exoplayer2.decoder.SimpleDecoder
    public Exception decode(DecoderInputBuffer decoderInputBuffer0, OutputBuffer outputBuffer0, boolean z) {
        return this.decode(((SubtitleInputBuffer)decoderInputBuffer0), ((SubtitleOutputBuffer)outputBuffer0), z);
    }

    @Override  // com.google.android.exoplayer2.decoder.Decoder
    public final String getName() {
        return this.name;
    }

    @Override  // com.google.android.exoplayer2.decoder.SimpleDecoder
    public void releaseOutputBuffer(OutputBuffer outputBuffer0) {
        this.releaseOutputBuffer(((SubtitleOutputBuffer)outputBuffer0));
    }

    public final void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer0) {
        super.releaseOutputBuffer(subtitleOutputBuffer0);
    }

    @Override  // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long v) {
    }
}

