package com.google.android.exoplayer2.ext.flac;

import androidx.media3.session.a0;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import java.nio.ByteBuffer;

final class FlacBinarySearchSeeker extends BinarySearchSeeker {
    static final class FlacTimestampSeeker implements TimestampSeeker {
        private final FlacDecoderJni decoderJni;
        private final OutputFrameHolder outputFrameHolder;

        private FlacTimestampSeeker(FlacDecoderJni flacDecoderJni0, OutputFrameHolder flacBinarySearchSeeker$OutputFrameHolder0) {
            this.decoderJni = flacDecoderJni0;
            this.outputFrameHolder = flacBinarySearchSeeker$OutputFrameHolder0;
        }

        public FlacTimestampSeeker(FlacDecoderJni flacDecoderJni0, OutputFrameHolder flacBinarySearchSeeker$OutputFrameHolder0, com.google.android.exoplayer2.ext.flac.FlacBinarySearchSeeker.1 flacBinarySearchSeeker$10) {
            this(flacDecoderJni0, flacBinarySearchSeeker$OutputFrameHolder0);
        }

        @Override  // com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSeeker
        public TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput0, long v) {
            ByteBuffer byteBuffer0 = this.outputFrameHolder.byteBuffer;
            long v1 = extractorInput0.getPosition();
            this.decoderJni.reset(v1);
            try {
                this.decoderJni.decodeSampleWithBacktrackPosition(byteBuffer0, v1);
            }
            catch(FlacFrameDecodeException unused_ex) {
                return TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
            }
            if(byteBuffer0.limit() == 0) {
                return TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
            }
            long v2 = this.decoderJni.getLastFrameFirstSampleIndex();
            long v3 = this.decoderJni.getNextFrameFirstSampleIndex();
            long v4 = this.decoderJni.getDecodePosition();
            if(v2 <= v && v3 > v) {
                this.outputFrameHolder.timeUs = this.decoderJni.getLastFrameTimestamp();
                return TimestampSearchResult.targetFoundResult(extractorInput0.getPosition());
            }
            return v3 > v ? TimestampSearchResult.overestimatedResult(v2, v1) : TimestampSearchResult.underestimatedResult(v3, v4);
        }
    }

    public static final class OutputFrameHolder {
        public final ByteBuffer byteBuffer;
        public long timeUs;

        public OutputFrameHolder(ByteBuffer byteBuffer0) {
            this.timeUs = 0L;
            this.byteBuffer = byteBuffer0;
        }
    }

    private final FlacDecoderJni decoderJni;

    public FlacBinarySearchSeeker(FlacStreamMetadata flacStreamMetadata0, long v, long v1, FlacDecoderJni flacDecoderJni0, OutputFrameHolder flacBinarySearchSeeker$OutputFrameHolder0) {
        flacStreamMetadata0.getClass();
        a0 a00 = new a0(flacStreamMetadata0, 20);
        FlacTimestampSeeker flacBinarySearchSeeker$FlacTimestampSeeker0 = new FlacTimestampSeeker(flacDecoderJni0, flacBinarySearchSeeker$OutputFrameHolder0, null);
        long v2 = flacStreamMetadata0.getDurationUs();
        long v3 = flacStreamMetadata0.getApproxBytesPerFrame();
        super(a00, flacBinarySearchSeeker$FlacTimestampSeeker0, v2, 0L, flacStreamMetadata0.totalSamples, v, v1, v3, Math.max(6, flacStreamMetadata0.minFrameSize));
        this.decoderJni = (FlacDecoderJni)Assertions.checkNotNull(flacDecoderJni0);
    }

    @Override  // com.google.android.exoplayer2.extractor.BinarySearchSeeker
    public void onSeekOperationFinished(boolean z, long v) {
        if(!z) {
            this.decoderJni.reset(v);
        }
    }

    class com.google.android.exoplayer2.ext.flac.FlacBinarySearchSeeker.1 {
    }

}

