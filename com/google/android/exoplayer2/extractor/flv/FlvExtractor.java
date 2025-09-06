package com.google.android.exoplayer2.extractor.flv;

import com.facebook.appevents.b;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class FlvExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = null;
    private static final int FLV_HEADER_SIZE = 9;
    private static final int FLV_TAG = 4607062;
    private static final int FLV_TAG_HEADER_SIZE = 11;
    private static final int STATE_READING_FLV_HEADER = 1;
    private static final int STATE_READING_TAG_DATA = 4;
    private static final int STATE_READING_TAG_HEADER = 3;
    private static final int STATE_SKIPPING_TO_TAG_HEADER = 2;
    private static final int TAG_TYPE_AUDIO = 8;
    private static final int TAG_TYPE_SCRIPT_DATA = 18;
    private static final int TAG_TYPE_VIDEO = 9;
    private AudioTagPayloadReader audioReader;
    private int bytesToNextTagHeader;
    private ExtractorOutput extractorOutput;
    private final ParsableByteArray headerBuffer;
    private long mediaTagTimestampOffsetUs;
    private final ScriptTagPayloadReader metadataReader;
    private boolean outputFirstSample;
    private boolean outputSeekMap;
    private final ParsableByteArray scratch;
    private int state;
    private final ParsableByteArray tagData;
    private int tagDataSize;
    private final ParsableByteArray tagHeaderBuffer;
    private long tagTimestampUs;
    private int tagType;
    private VideoTagPayloadReader videoReader;

    static {
        FlvExtractor.FACTORY = new b(14);
    }

    public FlvExtractor() {
        this.scratch = new ParsableByteArray(4);
        this.headerBuffer = new ParsableByteArray(9);
        this.tagHeaderBuffer = new ParsableByteArray(11);
        this.tagData = new ParsableByteArray();
        this.metadataReader = new ScriptTagPayloadReader();
        this.state = 1;
    }

    public static Extractor[] a() {
        return FlvExtractor.lambda$static$0();
    }

    private void ensureReadyForMediaOutput() {
        if(!this.outputSeekMap) {
            this.extractorOutput.seekMap(new Unseekable(0x8000000000000001L));
            this.outputSeekMap = true;
        }
    }

    private long getCurrentTimestampUs() {
        if(this.outputFirstSample) {
            return this.mediaTagTimestampOffsetUs + this.tagTimestampUs;
        }
        return this.metadataReader.getDurationUs() == 0x8000000000000001L ? 0L : this.tagTimestampUs;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        this.extractorOutput = extractorOutput0;
    }

    private static Extractor[] lambda$static$0() {
        return new Extractor[]{new FlvExtractor()};
    }

    private ParsableByteArray prepareTagData(ExtractorInput extractorInput0) {
        if(this.tagDataSize > this.tagData.capacity()) {
            this.tagData.reset(new byte[Math.max(this.tagData.capacity() * 2, this.tagDataSize)], 0);
        }
        else {
            this.tagData.setPosition(0);
        }
        this.tagData.setLimit(this.tagDataSize);
        extractorInput0.readFully(this.tagData.data, 0, this.tagDataSize);
        return this.tagData;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
    alab1:
        while(true) {
            switch(this.state) {
                case 1: {
                    if(this.readFlvHeader(extractorInput0)) {
                        break;
                    }
                    return -1;
                }
                case 2: {
                    this.skipToTagHeader(extractorInput0);
                    break;
                }
                case 3: {
                    if(this.readTagHeader(extractorInput0)) {
                        break;
                    }
                    return -1;
                }
                case 4: {
                    if(!this.readTagData(extractorInput0)) {
                        break;
                    }
                    break alab1;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
        }
        return 0;
    }

    private boolean readFlvHeader(ExtractorInput extractorInput0) {
        boolean z = false;
        if(!extractorInput0.readFully(this.headerBuffer.data, 0, 9, true)) {
            return false;
        }
        this.headerBuffer.setPosition(0);
        this.headerBuffer.skipBytes(4);
        int v = this.headerBuffer.readUnsignedByte();
        if((v & 1) != 0) {
            z = true;
        }
        if((v & 4) != 0 && this.audioReader == null) {
            this.audioReader = new AudioTagPayloadReader(this.extractorOutput.track(8, 1));
        }
        if(z && this.videoReader == null) {
            this.videoReader = new VideoTagPayloadReader(this.extractorOutput.track(9, 2));
        }
        this.extractorOutput.endTracks();
        this.bytesToNextTagHeader = this.headerBuffer.readInt() - 5;
        this.state = 2;
        return true;
    }

    private boolean readTagData(ExtractorInput extractorInput0) {
        boolean z1;
        boolean z;
        long v = this.getCurrentTimestampUs();
        int v1 = this.tagType;
        if(v1 == 8 && this.audioReader != null) {
            this.ensureReadyForMediaOutput();
            z = this.audioReader.consume(this.prepareTagData(extractorInput0), v);
            z1 = true;
        }
        else if(v1 == 9 && this.videoReader != null) {
            this.ensureReadyForMediaOutput();
            z = this.videoReader.consume(this.prepareTagData(extractorInput0), v);
            z1 = true;
        }
        else if(v1 != 18 || this.outputSeekMap) {
            extractorInput0.skipFully(this.tagDataSize);
            z = false;
            z1 = false;
        }
        else {
            ParsableByteArray parsableByteArray0 = this.prepareTagData(extractorInput0);
            z = this.metadataReader.consume(parsableByteArray0, v);
            long v2 = this.metadataReader.getDurationUs();
            if(v2 != 0x8000000000000001L) {
                this.extractorOutput.seekMap(new Unseekable(v2));
                this.outputSeekMap = true;
            }
            z1 = true;
        }
        if(!this.outputFirstSample && z) {
            this.outputFirstSample = true;
            this.mediaTagTimestampOffsetUs = this.metadataReader.getDurationUs() == 0x8000000000000001L ? -this.tagTimestampUs : 0L;
        }
        this.bytesToNextTagHeader = 4;
        this.state = 2;
        return z1;
    }

    private boolean readTagHeader(ExtractorInput extractorInput0) {
        if(!extractorInput0.readFully(this.tagHeaderBuffer.data, 0, 11, true)) {
            return false;
        }
        this.tagHeaderBuffer.setPosition(0);
        this.tagType = this.tagHeaderBuffer.readUnsignedByte();
        this.tagDataSize = this.tagHeaderBuffer.readUnsignedInt24();
        this.tagTimestampUs = (long)this.tagHeaderBuffer.readUnsignedInt24();
        this.tagTimestampUs = (((long)(this.tagHeaderBuffer.readUnsignedByte() << 24)) | this.tagTimestampUs) * 1000L;
        this.tagHeaderBuffer.skipBytes(3);
        this.state = 4;
        return true;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        this.state = 1;
        this.outputFirstSample = false;
        this.bytesToNextTagHeader = 0;
    }

    private void skipToTagHeader(ExtractorInput extractorInput0) {
        extractorInput0.skipFully(this.bytesToNextTagHeader);
        this.bytesToNextTagHeader = 0;
        this.state = 3;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput0) {
        extractorInput0.peekFully(this.scratch.data, 0, 3);
        this.scratch.setPosition(0);
        if(this.scratch.readUnsignedInt24() != 4607062) {
            return false;
        }
        extractorInput0.peekFully(this.scratch.data, 0, 2);
        this.scratch.setPosition(0);
        if((this.scratch.readUnsignedShort() & 0xFA) != 0) {
            return false;
        }
        extractorInput0.peekFully(this.scratch.data, 0, 4);
        this.scratch.setPosition(0);
        int v = this.scratch.readInt();
        extractorInput0.resetPeekPosition();
        extractorInput0.advancePeekPosition(v);
        extractorInput0.peekFully(this.scratch.data, 0, 4);
        this.scratch.setPosition(0);
        return this.scratch.readInt() == 0;
    }
}

