package com.google.android.exoplayer2.ext.flac;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.decoder.SimpleOutputBuffer;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

final class FlacDecoder extends SimpleDecoder {
    private final FlacDecoderJni decoderJni;
    private final FlacStreamMetadata streamMetadata;

    public FlacDecoder(int v, int v1, int v2, List list0) {
        super(new DecoderInputBuffer[v], new SimpleOutputBuffer[v1]);
        FlacStreamMetadata flacStreamMetadata0;
        if(list0.size() != 1) {
            throw new FlacDecoderException("Initialization data must be of length 1");
        }
        FlacDecoderJni flacDecoderJni0 = new FlacDecoderJni();
        this.decoderJni = flacDecoderJni0;
        flacDecoderJni0.setData(ByteBuffer.wrap(((byte[])list0.get(0))));
        try {
            flacStreamMetadata0 = flacDecoderJni0.decodeStreamMetadata();
            this.streamMetadata = flacStreamMetadata0;
        }
        catch(ParserException parserException0) {
            throw new FlacDecoderException("Failed to decode StreamInfo", parserException0);
        }
        catch(IOException | InterruptedException iOException0) {
            throw new IllegalStateException(iOException0);
        }
        if(v2 == -1) {
            v2 = flacStreamMetadata0.maxFrameSize;
        }
        this.setInitialInputBufferSize(v2);
    }

    @Override  // com.google.android.exoplayer2.decoder.SimpleDecoder
    public DecoderInputBuffer createInputBuffer() {
        return new DecoderInputBuffer(1);
    }

    @Override  // com.google.android.exoplayer2.decoder.SimpleDecoder
    public OutputBuffer createOutputBuffer() {
        return this.createOutputBuffer();
    }

    public SimpleOutputBuffer createOutputBuffer() {
        return new SimpleOutputBuffer(this);
    }

    public FlacDecoderException createUnexpectedDecodeException(Throwable throwable0) {
        return new FlacDecoderException("Unexpected decode error", throwable0);
    }

    @Override  // com.google.android.exoplayer2.decoder.SimpleDecoder
    public Exception createUnexpectedDecodeException(Throwable throwable0) {
        return this.createUnexpectedDecodeException(throwable0);
    }

    public FlacDecoderException decode(DecoderInputBuffer decoderInputBuffer0, SimpleOutputBuffer simpleOutputBuffer0, boolean z) {
        if(z) {
            this.decoderJni.flush();
        }
        this.decoderJni.setData(decoderInputBuffer0.data);
        ByteBuffer byteBuffer0 = simpleOutputBuffer0.init(decoderInputBuffer0.timeUs, this.streamMetadata.getMaxDecodedFrameSize());
        try {
            this.decoderJni.decodeSample(byteBuffer0);
            return null;
        }
        catch(FlacFrameDecodeException flacDecoderJni$FlacFrameDecodeException0) {
            return new FlacDecoderException("Frame decoding failed", flacDecoderJni$FlacFrameDecodeException0);
        }
        catch(IOException | InterruptedException iOException0) {
            throw new IllegalStateException(iOException0);
        }
    }

    @Override  // com.google.android.exoplayer2.decoder.SimpleDecoder
    public Exception decode(DecoderInputBuffer decoderInputBuffer0, OutputBuffer outputBuffer0, boolean z) {
        return this.decode(decoderInputBuffer0, ((SimpleOutputBuffer)outputBuffer0), z);
    }

    @Override  // com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "libflac";
    }

    public FlacStreamMetadata getStreamMetadata() {
        return this.streamMetadata;
    }

    @Override  // com.google.android.exoplayer2.decoder.SimpleDecoder
    public void release() {
        super.release();
        this.decoderJni.release();
    }
}

