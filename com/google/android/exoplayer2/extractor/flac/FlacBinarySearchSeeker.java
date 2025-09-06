package com.google.android.exoplayer2.extractor.flac;

import androidx.media3.session.a0;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacFrameReader.SampleNumberHolder;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import java.util.Objects;

final class FlacBinarySearchSeeker extends BinarySearchSeeker {
    static final class FlacTimestampSeeker implements TimestampSeeker {
        private final FlacStreamMetadata flacStreamMetadata;
        private final int frameStartMarker;
        private final SampleNumberHolder sampleNumberHolder;

        private FlacTimestampSeeker(FlacStreamMetadata flacStreamMetadata0, int v) {
            this.flacStreamMetadata = flacStreamMetadata0;
            this.frameStartMarker = v;
            this.sampleNumberHolder = new SampleNumberHolder();
        }

        public FlacTimestampSeeker(FlacStreamMetadata flacStreamMetadata0, int v, com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker.1 flacBinarySearchSeeker$10) {
            this(flacStreamMetadata0, v);
        }

        private long findNextFrame(ExtractorInput extractorInput0) {
            while(extractorInput0.getPeekPosition() < extractorInput0.getLength() - 6L && !FlacFrameReader.checkFrameHeaderFromPeek(extractorInput0, this.flacStreamMetadata, this.frameStartMarker, this.sampleNumberHolder)) {
                extractorInput0.advancePeekPosition(1);
            }
            if(extractorInput0.getPeekPosition() >= extractorInput0.getLength() - 6L) {
                extractorInput0.advancePeekPosition(((int)(extractorInput0.getLength() - extractorInput0.getPeekPosition())));
                return this.flacStreamMetadata.totalSamples;
            }
            return this.sampleNumberHolder.sampleNumber;
        }

        @Override  // com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSeeker
        public TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput0, long v) {
            long v1 = extractorInput0.getPosition();
            long v2 = this.findNextFrame(extractorInput0);
            long v3 = extractorInput0.getPeekPosition();
            extractorInput0.advancePeekPosition(Math.max(6, this.flacStreamMetadata.minFrameSize));
            long v4 = this.findNextFrame(extractorInput0);
            long v5 = extractorInput0.getPeekPosition();
            if(v2 <= v && v4 > v) {
                return TimestampSearchResult.targetFoundResult(v3);
            }
            return v4 > v ? TimestampSearchResult.overestimatedResult(v2, v1) : TimestampSearchResult.underestimatedResult(v4, v5);
        }
    }

    public FlacBinarySearchSeeker(FlacStreamMetadata flacStreamMetadata0, int v, long v1, long v2) {
        Objects.requireNonNull(flacStreamMetadata0);
        a0 a00 = new a0(flacStreamMetadata0, 20);
        FlacTimestampSeeker flacBinarySearchSeeker$FlacTimestampSeeker0 = new FlacTimestampSeeker(flacStreamMetadata0, v, null);
        long v3 = flacStreamMetadata0.getDurationUs();
        long v4 = flacStreamMetadata0.getApproxBytesPerFrame();
        super(a00, flacBinarySearchSeeker$FlacTimestampSeeker0, v3, 0L, flacStreamMetadata0.totalSamples, v1, v2, v4, Math.max(6, flacStreamMetadata0.minFrameSize));
    }

    class com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker.1 {
    }

}

