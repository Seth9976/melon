package com.google.android.exoplayer2.extractor.flac;

import com.facebook.appevents.b;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.FlacFrameReader.SampleNumberHolder;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacMetadataReader.FlacStreamMetadataHolder;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class FlacExtractor implements Extractor {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static final int BUFFER_LENGTH = 0x8000;
    public static final ExtractorsFactory FACTORY = null;
    public static final int FLAG_DISABLE_ID3_METADATA = 1;
    private static final int SAMPLE_NUMBER_UNKNOWN = -1;
    private static final int STATE_GET_FRAME_START_MARKER = 4;
    private static final int STATE_GET_STREAM_MARKER_AND_INFO_BLOCK_BYTES = 1;
    private static final int STATE_READ_FRAMES = 5;
    private static final int STATE_READ_ID3_METADATA = 0;
    private static final int STATE_READ_METADATA_BLOCKS = 3;
    private static final int STATE_READ_STREAM_MARKER = 2;
    private FlacBinarySearchSeeker binarySearchSeeker;
    private final ParsableByteArray buffer;
    private int currentFrameBytesWritten;
    private long currentFrameFirstSampleNumber;
    private ExtractorOutput extractorOutput;
    private FlacStreamMetadata flacStreamMetadata;
    private int frameStartMarker;
    private Metadata id3Metadata;
    private final boolean id3MetadataDisabled;
    private int minFrameSize;
    private final SampleNumberHolder sampleNumberHolder;
    private int state;
    private final byte[] streamMarkerAndInfoBlock;
    private TrackOutput trackOutput;

    static {
        FlacExtractor.FACTORY = new b(13);
    }

    public FlacExtractor() {
        this(0);
    }

    public FlacExtractor(int v) {
        this.streamMarkerAndInfoBlock = new byte[42];
        this.buffer = new ParsableByteArray(new byte[0x8000], 0);
        this.id3MetadataDisabled = (v & 1) != 0;
        this.sampleNumberHolder = new SampleNumberHolder();
        this.state = 0;
    }

    public static Extractor[] a() {
        return FlacExtractor.lambda$static$0();
    }

    private long findFrame(ParsableByteArray parsableByteArray0, boolean z) {
        boolean z2;
        Assertions.checkNotNull(this.flacStreamMetadata);
        int v;
        for(v = parsableByteArray0.getPosition(); v <= parsableByteArray0.limit() - 16; ++v) {
            parsableByteArray0.setPosition(v);
            if(FlacFrameReader.checkAndReadFrameHeader(parsableByteArray0, this.flacStreamMetadata, this.frameStartMarker, this.sampleNumberHolder)) {
                parsableByteArray0.setPosition(v);
                return this.sampleNumberHolder.sampleNumber;
            }
        }
        if(z) {
            while(v <= parsableByteArray0.limit() - this.minFrameSize) {
                parsableByteArray0.setPosition(v);
                boolean z1 = false;
                try {
                    z2 = false;
                    z2 = FlacFrameReader.checkAndReadFrameHeader(parsableByteArray0, this.flacStreamMetadata, this.frameStartMarker, this.sampleNumberHolder);
                }
                catch(IndexOutOfBoundsException unused_ex) {
                }
                if(parsableByteArray0.getPosition() <= parsableByteArray0.limit()) {
                    z1 = z2;
                }
                if(z1) {
                    parsableByteArray0.setPosition(v);
                    return this.sampleNumberHolder.sampleNumber;
                }
                ++v;
            }
            parsableByteArray0.setPosition(parsableByteArray0.limit());
            return -1L;
        }
        parsableByteArray0.setPosition(v);
        return -1L;
    }

    private void getFrameStartMarker(ExtractorInput extractorInput0) {
        this.frameStartMarker = FlacMetadataReader.getFrameStartMarker(extractorInput0);
        this.extractorOutput.seekMap(this.getSeekMap(extractorInput0.getPosition(), extractorInput0.getLength()));
        this.state = 5;
    }

    private SeekMap getSeekMap(long v, long v1) {
        Assertions.checkNotNull(this.flacStreamMetadata);
        FlacStreamMetadata flacStreamMetadata0 = this.flacStreamMetadata;
        if(flacStreamMetadata0.seekTable != null) {
            return new FlacSeekTableSeekMap(flacStreamMetadata0, v);
        }
        if(v1 != -1L && flacStreamMetadata0.totalSamples > 0L) {
            FlacBinarySearchSeeker flacBinarySearchSeeker0 = new FlacBinarySearchSeeker(flacStreamMetadata0, this.frameStartMarker, v, v1);
            this.binarySearchSeeker = flacBinarySearchSeeker0;
            return flacBinarySearchSeeker0.getSeekMap();
        }
        return new Unseekable(flacStreamMetadata0.getDurationUs());
    }

    private void getStreamMarkerAndInfoBlockBytes(ExtractorInput extractorInput0) {
        extractorInput0.peekFully(this.streamMarkerAndInfoBlock, 0, this.streamMarkerAndInfoBlock.length);
        extractorInput0.resetPeekPosition();
        this.state = 2;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        this.extractorOutput = extractorOutput0;
        this.trackOutput = extractorOutput0.track(0, 1);
        extractorOutput0.endTracks();
    }

    private static Extractor[] lambda$static$0() {
        return new Extractor[]{new FlacExtractor()};
    }

    private void outputSampleMetadata() {
        this.trackOutput.sampleMetadata(this.currentFrameFirstSampleNumber * 1000000L / ((long)this.flacStreamMetadata.sampleRate), 1, this.currentFrameBytesWritten, 0, null);
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        switch(this.state) {
            case 0: {
                this.readId3Metadata(extractorInput0);
                return 0;
            }
            case 1: {
                this.getStreamMarkerAndInfoBlockBytes(extractorInput0);
                return 0;
            }
            case 2: {
                this.readStreamMarker(extractorInput0);
                return 0;
            }
            case 3: {
                this.readMetadataBlocks(extractorInput0);
                return 0;
            }
            case 4: {
                this.getFrameStartMarker(extractorInput0);
                return 0;
            }
            case 5: {
                return this.readFrames(extractorInput0, positionHolder0);
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }

    private int readFrames(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        boolean z;
        Assertions.checkNotNull(this.trackOutput);
        Assertions.checkNotNull(this.flacStreamMetadata);
        if(this.binarySearchSeeker != null && this.binarySearchSeeker.isSeeking()) {
            return this.binarySearchSeeker.handlePendingSeek(extractorInput0, positionHolder0);
        }
        if(Long.compare(this.currentFrameFirstSampleNumber, -1L) == 0) {
            this.currentFrameFirstSampleNumber = FlacFrameReader.getFirstSampleNumber(extractorInput0, this.flacStreamMetadata);
            return 0;
        }
        int v = this.buffer.limit();
        if(v < 0x8000) {
            int v1 = extractorInput0.read(this.buffer.data, v, 0x8000 - v);
            z = v1 == -1;
            if(!z) {
                this.buffer.setLimit(v + v1);
            }
            else if(this.buffer.bytesLeft() == 0) {
                this.outputSampleMetadata();
                return -1;
            }
        }
        else {
            z = false;
        }
        int v2 = this.buffer.getPosition();
        int v3 = this.currentFrameBytesWritten;
        int v4 = this.minFrameSize;
        if(v3 < v4) {
            this.buffer.skipBytes(Math.min(v4 - v3, this.buffer.bytesLeft()));
        }
        long v5 = this.findFrame(this.buffer, z);
        int v6 = this.buffer.getPosition() - v2;
        this.buffer.setPosition(v2);
        this.trackOutput.sampleData(this.buffer, v6);
        this.currentFrameBytesWritten += v6;
        if(v5 != -1L) {
            this.outputSampleMetadata();
            this.currentFrameBytesWritten = 0;
            this.currentFrameFirstSampleNumber = v5;
        }
        if(this.buffer.bytesLeft() < 16) {
            System.arraycopy(this.buffer.data, this.buffer.getPosition(), this.buffer.data, 0, this.buffer.bytesLeft());
            this.buffer.reset(this.buffer.bytesLeft());
        }
        return 0;
    }

    private void readId3Metadata(ExtractorInput extractorInput0) {
        this.id3Metadata = FlacMetadataReader.readId3Metadata(extractorInput0, !this.id3MetadataDisabled);
        this.state = 1;
    }

    private void readMetadataBlocks(ExtractorInput extractorInput0) {
        FlacStreamMetadataHolder flacMetadataReader$FlacStreamMetadataHolder0 = new FlacStreamMetadataHolder(this.flacStreamMetadata);
        boolean z = false;
        while(!z) {
            z = FlacMetadataReader.readMetadataBlock(extractorInput0, flacMetadataReader$FlacStreamMetadataHolder0);
            this.flacStreamMetadata = flacMetadataReader$FlacStreamMetadataHolder0.flacStreamMetadata;
        }
        Assertions.checkNotNull(this.flacStreamMetadata);
        this.minFrameSize = Math.max(this.flacStreamMetadata.minFrameSize, 6);
        this.trackOutput.format(this.flacStreamMetadata.getFormat(this.streamMarkerAndInfoBlock, this.id3Metadata));
        this.state = 4;
    }

    private void readStreamMarker(ExtractorInput extractorInput0) {
        FlacMetadataReader.readStreamMarker(extractorInput0);
        this.state = 3;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        long v2 = 0L;
        if(Long.compare(v, 0L) == 0) {
            this.state = 0;
        }
        else {
            FlacBinarySearchSeeker flacBinarySearchSeeker0 = this.binarySearchSeeker;
            if(flacBinarySearchSeeker0 != null) {
                flacBinarySearchSeeker0.setSeekTargetUs(v1);
            }
        }
        if(v1 != 0L) {
            v2 = -1L;
        }
        this.currentFrameFirstSampleNumber = v2;
        this.currentFrameBytesWritten = 0;
        this.buffer.reset();
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput0) {
        FlacMetadataReader.peekId3Metadata(extractorInput0, false);
        return FlacMetadataReader.checkAndPeekStreamMarker(extractorInput0);
    }
}

