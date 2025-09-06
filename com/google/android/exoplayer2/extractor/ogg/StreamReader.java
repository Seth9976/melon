package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

abstract class StreamReader {
    static class SetupData {
        Format format;
        OggSeeker oggSeeker;

    }

    static final class UnseekableOggSeeker implements OggSeeker {
        private UnseekableOggSeeker() {
        }

        public UnseekableOggSeeker(com.google.android.exoplayer2.extractor.ogg.StreamReader.1 streamReader$10) {
        }

        @Override  // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public SeekMap createSeekMap() {
            return new Unseekable(0x8000000000000001L);
        }

        @Override  // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long read(ExtractorInput extractorInput0) {
            return -1L;
        }

        @Override  // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public void startSeek(long v) {
        }
    }

    private static final int STATE_END_OF_INPUT = 3;
    private static final int STATE_READ_HEADERS = 0;
    private static final int STATE_READ_PAYLOAD = 2;
    private static final int STATE_SKIP_HEADERS = 1;
    private long currentGranule;
    private ExtractorOutput extractorOutput;
    private boolean formatSet;
    private long lengthOfReadPacket;
    private final OggPacket oggPacket;
    private OggSeeker oggSeeker;
    private long payloadStartPosition;
    private int sampleRate;
    private boolean seekMapSet;
    private SetupData setupData;
    private int state;
    private long targetGranule;
    private TrackOutput trackOutput;

    public StreamReader() {
        this.oggPacket = new OggPacket();
    }

    public long convertGranuleToTime(long v) {
        return v * 1000000L / ((long)this.sampleRate);
    }

    public long convertTimeToGranule(long v) {
        return ((long)this.sampleRate) * v / 1000000L;
    }

    public void init(ExtractorOutput extractorOutput0, TrackOutput trackOutput0) {
        this.extractorOutput = extractorOutput0;
        this.trackOutput = trackOutput0;
        this.reset(true);
    }

    public void onSeekEnd(long v) {
        this.currentGranule = v;
    }

    public abstract long preparePayload(ParsableByteArray arg1);

    public final int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        int v = this.state;
        if(v != 0) {
            switch(v) {
                case 1: {
                    extractorInput0.skipFully(((int)this.payloadStartPosition));
                    this.state = 2;
                    return 0;
                }
                case 2: {
                    return this.readPayload(extractorInput0, positionHolder0);
                }
                default: {
                    throw new IllegalStateException();
                }
            }
        }
        return this.readHeaders(extractorInput0);
    }

    private int readHeaders(ExtractorInput extractorInput0) {
        boolean z = true;
        while(z) {
            if(!this.oggPacket.populate(extractorInput0)) {
                this.state = 3;
                return -1;
            }
            this.lengthOfReadPacket = extractorInput0.getPosition() - this.payloadStartPosition;
            z = this.readHeaders(this.oggPacket.getPayload(), this.payloadStartPosition, this.setupData);
            if(z) {
                this.payloadStartPosition = extractorInput0.getPosition();
            }
        }
        Format format0 = this.setupData.format;
        this.sampleRate = format0.sampleRate;
        if(!this.formatSet) {
            this.trackOutput.format(format0);
            this.formatSet = true;
        }
        OggSeeker oggSeeker0 = this.setupData.oggSeeker;
        if(oggSeeker0 != null) {
            this.oggSeeker = oggSeeker0;
        }
        else if(extractorInput0.getLength() == -1L) {
            this.oggSeeker = new UnseekableOggSeeker(null);
        }
        else {
            OggPageHeader oggPageHeader0 = this.oggPacket.getPageHeader();
            boolean z1 = (oggPageHeader0.type & 4) != 0;
            this.oggSeeker = new DefaultOggSeeker(this, this.payloadStartPosition, extractorInput0.getLength(), ((long)(oggPageHeader0.headerSize + oggPageHeader0.bodySize)), oggPageHeader0.granulePosition, z1);
        }
        this.setupData = null;
        this.state = 2;
        this.oggPacket.trimPayload();
        return 0;
    }

    public abstract boolean readHeaders(ParsableByteArray arg1, long arg2, SetupData arg3);

    private int readPayload(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        long v = this.oggSeeker.read(extractorInput0);
        if(Long.compare(v, 0L) >= 0) {
            positionHolder0.position = v;
            return 1;
        }
        if(v < -1L) {
            this.onSeekEnd(-(v + 2L));
        }
        if(!this.seekMapSet) {
            SeekMap seekMap0 = this.oggSeeker.createSeekMap();
            this.extractorOutput.seekMap(seekMap0);
            this.seekMapSet = true;
        }
        if(this.lengthOfReadPacket <= 0L && !this.oggPacket.populate(extractorInput0)) {
            this.state = 3;
            return -1;
        }
        this.lengthOfReadPacket = 0L;
        ParsableByteArray parsableByteArray0 = this.oggPacket.getPayload();
        long v1 = this.preparePayload(parsableByteArray0);
        if(v1 >= 0L) {
            long v2 = this.currentGranule;
            if(v2 + v1 >= this.targetGranule) {
                long v3 = this.convertGranuleToTime(v2);
                this.trackOutput.sampleData(parsableByteArray0, parsableByteArray0.limit());
                this.trackOutput.sampleMetadata(v3, 1, parsableByteArray0.limit(), 0, null);
                this.targetGranule = -1L;
            }
        }
        this.currentGranule += v1;
        return 0;
    }

    public void reset(boolean z) {
        if(z) {
            this.setupData = new SetupData();
            this.payloadStartPosition = 0L;
            this.state = 0;
        }
        else {
            this.state = 1;
        }
        this.targetGranule = -1L;
        this.currentGranule = 0L;
    }

    public final void seek(long v, long v1) {
        this.oggPacket.reset();
        if(v == 0L) {
            this.reset(!this.seekMapSet);
            return;
        }
        if(this.state != 0) {
            long v2 = this.convertTimeToGranule(v1);
            this.targetGranule = v2;
            this.oggSeeker.startSeek(v2);
            this.state = 2;
        }
    }

    class com.google.android.exoplayer2.extractor.ogg.StreamReader.1 {
    }

}

