package com.google.android.exoplayer2.ext.flac;

import com.facebook.appevents.b;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class FlacExtractor implements Extractor {
    static final class FlacSeekMap implements SeekMap {
        private final FlacDecoderJni decoderJni;
        private final long durationUs;

        public FlacSeekMap(long v, FlacDecoderJni flacDecoderJni0) {
            this.durationUs = v;
            this.decoderJni = flacDecoderJni0;
        }

        @Override  // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }

        @Override  // com.google.android.exoplayer2.extractor.SeekMap
        public SeekPoints getSeekPoints(long v) {
            SeekPoints seekMap$SeekPoints0 = this.decoderJni.getSeekPoints(v);
            return seekMap$SeekPoints0 == null ? new SeekPoints(SeekPoint.START) : seekMap$SeekPoints0;
        }

        @Override  // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final ExtractorsFactory FACTORY = null;
    public static final int FLAG_DISABLE_ID3_METADATA = 1;
    private FlacBinarySearchSeeker binarySearchSeeker;
    private FlacDecoderJni decoderJni;
    private ExtractorOutput extractorOutput;
    private Metadata id3Metadata;
    private final boolean id3MetadataDisabled;
    private final ParsableByteArray outputBuffer;
    private OutputFrameHolder outputFrameHolder;
    private FlacStreamMetadata streamMetadata;
    private boolean streamMetadataDecoded;
    private TrackOutput trackOutput;

    static {
        FlacExtractor.FACTORY = new b(12);
    }

    public FlacExtractor() {
        this(0);
    }

    public FlacExtractor(int v) {
        this.outputBuffer = new ParsableByteArray();
        this.id3MetadataDisabled = (v & 1) != 0;
    }

    public static Extractor[] a() {
        return FlacExtractor.lambda$static$0();
    }

    @EnsuresNonNull({"streamMetadata", "outputFrameHolder"})
    @RequiresNonNull({"decoderJni", "extractorOutput", "trackOutput"})
    private void decodeStreamMetadata(ExtractorInput extractorInput0) {
        FlacStreamMetadata flacStreamMetadata0;
        FlacDecoderJni flacDecoderJni0;
        if(!this.streamMetadataDecoded) {
            try {
                flacDecoderJni0 = this.decoderJni;
                flacStreamMetadata0 = flacDecoderJni0.decodeStreamMetadata();
                this.streamMetadataDecoded = true;
            }
            catch(IOException iOException0) {
                flacDecoderJni0.reset(0L);
                extractorInput0.setRetryPosition(0L, iOException0);
                throw iOException0;
            }
            if(this.streamMetadata == null) {
                this.streamMetadata = flacStreamMetadata0;
                this.outputBuffer.reset(flacStreamMetadata0.getMaxDecodedFrameSize());
                this.outputFrameHolder = new OutputFrameHolder(ByteBuffer.wrap(this.outputBuffer.data));
                this.binarySearchSeeker = FlacExtractor.outputSeekMap(flacDecoderJni0, flacStreamMetadata0, extractorInput0.getLength(), this.extractorOutput, this.outputFrameHolder);
                FlacExtractor.outputFormat(flacStreamMetadata0, flacStreamMetadata0.getMetadataCopyWithAppendedEntriesFrom(this.id3Metadata), this.trackOutput);
            }
        }
    }

    @RequiresNonNull({"binarySearchSeeker"})
    private int handlePendingSeek(ExtractorInput extractorInput0, PositionHolder positionHolder0, ParsableByteArray parsableByteArray0, OutputFrameHolder flacBinarySearchSeeker$OutputFrameHolder0, TrackOutput trackOutput0) {
        int v = this.binarySearchSeeker.handlePendingSeek(extractorInput0, positionHolder0);
        ByteBuffer byteBuffer0 = flacBinarySearchSeeker$OutputFrameHolder0.byteBuffer;
        if(v == 0 && byteBuffer0.limit() > 0) {
            FlacExtractor.outputSample(parsableByteArray0, byteBuffer0.limit(), flacBinarySearchSeeker$OutputFrameHolder0.timeUs, trackOutput0);
        }
        return v;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        this.extractorOutput = extractorOutput0;
        this.trackOutput = extractorOutput0.track(0, 1);
        this.extractorOutput.endTracks();
        try {
            this.decoderJni = new FlacDecoderJni();
        }
        catch(FlacDecoderException flacDecoderException0) {
            throw new RuntimeException(flacDecoderException0);
        }
    }

    @EnsuresNonNull({"decoderJni", "extractorOutput", "trackOutput"})
    private FlacDecoderJni initDecoderJni(ExtractorInput extractorInput0) {
        FlacDecoderJni flacDecoderJni0 = (FlacDecoderJni)Assertions.checkNotNull(this.decoderJni);
        flacDecoderJni0.setData(extractorInput0);
        return flacDecoderJni0;
    }

    private static Extractor[] lambda$static$0() {
        return new Extractor[]{new FlacExtractor()};
    }

    private static void outputFormat(FlacStreamMetadata flacStreamMetadata0, Metadata metadata0, TrackOutput trackOutput0) {
        trackOutput0.format(Format.createAudioSampleFormat(null, "audio/raw", null, flacStreamMetadata0.getBitRate(), flacStreamMetadata0.getMaxDecodedFrameSize(), flacStreamMetadata0.channels, flacStreamMetadata0.sampleRate, Util.getPcmEncoding(flacStreamMetadata0.bitsPerSample), 0, 0, null, null, 0, null, metadata0));
    }

    private static void outputSample(ParsableByteArray parsableByteArray0, int v, long v1, TrackOutput trackOutput0) {
        parsableByteArray0.setPosition(0);
        trackOutput0.sampleData(parsableByteArray0, v);
        trackOutput0.sampleMetadata(v1, 1, v, 0, null);
    }

    private static FlacBinarySearchSeeker outputSeekMap(FlacDecoderJni flacDecoderJni0, FlacStreamMetadata flacStreamMetadata0, long v, ExtractorOutput extractorOutput0, OutputFrameHolder flacBinarySearchSeeker$OutputFrameHolder0) {
        SeekMap seekMap0;
        FlacBinarySearchSeeker flacBinarySearchSeeker0 = null;
        if(flacDecoderJni0.getSeekPoints(0L) != null) {
            seekMap0 = new FlacSeekMap(flacStreamMetadata0.getDurationUs(), flacDecoderJni0);
        }
        else if(v == -1L) {
            seekMap0 = new Unseekable(flacStreamMetadata0.getDurationUs());
        }
        else {
            FlacBinarySearchSeeker flacBinarySearchSeeker1 = new FlacBinarySearchSeeker(flacStreamMetadata0, flacDecoderJni0.getDecodePosition(), v, flacDecoderJni0, flacBinarySearchSeeker$OutputFrameHolder0);
            seekMap0 = flacBinarySearchSeeker1.getSeekMap();
            flacBinarySearchSeeker0 = flacBinarySearchSeeker1;
        }
        extractorOutput0.seekMap(seekMap0);
        return flacBinarySearchSeeker0;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        if(extractorInput0.getPosition() == 0L && !this.id3MetadataDisabled && this.id3Metadata == null) {
            this.id3Metadata = FlacMetadataReader.peekId3Metadata(extractorInput0, true);
        }
        FlacDecoderJni flacDecoderJni0 = this.initDecoderJni(extractorInput0);
        try {
            this.decodeStreamMetadata(extractorInput0);
            if(this.binarySearchSeeker != null && this.binarySearchSeeker.isSeeking()) {
                return this.handlePendingSeek(extractorInput0, positionHolder0, this.outputBuffer, this.outputFrameHolder, this.trackOutput);
            }
            ByteBuffer byteBuffer0 = this.outputFrameHolder.byteBuffer;
            long v2 = flacDecoderJni0.getDecodePosition();
            try {
                flacDecoderJni0.decodeSampleWithBacktrackPosition(byteBuffer0, v2);
            }
            catch(FlacFrameDecodeException flacDecoderJni$FlacFrameDecodeException0) {
                throw new IOException("Cannot read frame at position " + v2, flacDecoderJni$FlacFrameDecodeException0);
            }
            int v3 = -1;
            int v4 = byteBuffer0.limit();
            if(v4 == 0) {
                return -1;
            }
            long v5 = flacDecoderJni0.getLastFrameTimestamp();
            FlacExtractor.outputSample(this.outputBuffer, v4, v5, this.trackOutput);
            if(!flacDecoderJni0.isEndOfData()) {
                v3 = 0;
            }
            return v3;
        }
        finally {
            flacDecoderJni0.clearData();
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        this.binarySearchSeeker = null;
        FlacDecoderJni flacDecoderJni0 = this.decoderJni;
        if(flacDecoderJni0 != null) {
            flacDecoderJni0.release();
            this.decoderJni = null;
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        if(v == 0L) {
            this.streamMetadataDecoded = false;
        }
        FlacDecoderJni flacDecoderJni0 = this.decoderJni;
        if(flacDecoderJni0 != null) {
            flacDecoderJni0.reset(v);
        }
        FlacBinarySearchSeeker flacBinarySearchSeeker0 = this.binarySearchSeeker;
        if(flacBinarySearchSeeker0 != null) {
            flacBinarySearchSeeker0.setSeekTargetUs(v1);
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput0) {
        this.id3Metadata = FlacMetadataReader.peekId3Metadata(extractorInput0, !this.id3MetadataDisabled);
        return FlacMetadataReader.checkAndPeekStreamMarker(extractorInput0);
    }
}

