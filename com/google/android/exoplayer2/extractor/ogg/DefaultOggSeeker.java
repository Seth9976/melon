package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;

final class DefaultOggSeeker implements OggSeeker {
    final class OggSeekMap implements SeekMap {
        private OggSeekMap() {
        }

        public OggSeekMap(com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.1 defaultOggSeeker$10) {
        }

        @Override  // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return DefaultOggSeeker.this.streamReader.convertGranuleToTime(DefaultOggSeeker.this.totalGranules);
        }

        @Override  // com.google.android.exoplayer2.extractor.SeekMap
        public SeekPoints getSeekPoints(long v) {
            return new SeekPoints(new SeekPoint(v, Util.constrainValue((DefaultOggSeeker.this.payloadEndPosition - DefaultOggSeeker.this.payloadStartPosition) * DefaultOggSeeker.this.streamReader.convertTimeToGranule(v) / DefaultOggSeeker.this.totalGranules + DefaultOggSeeker.this.payloadStartPosition - 30000L, DefaultOggSeeker.this.payloadStartPosition, DefaultOggSeeker.this.payloadEndPosition - 1L)));
        }

        @Override  // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }
    }

    private static final int DEFAULT_OFFSET = 30000;
    private static final int MATCH_BYTE_RANGE = 100000;
    private static final int MATCH_RANGE = 72000;
    private static final int STATE_IDLE = 4;
    private static final int STATE_READ_LAST_PAGE = 1;
    private static final int STATE_SEEK = 2;
    private static final int STATE_SEEK_TO_END = 0;
    private static final int STATE_SKIP = 3;
    private long end;
    private long endGranule;
    private final OggPageHeader pageHeader;
    private final long payloadEndPosition;
    private final long payloadStartPosition;
    private long positionBeforeSeekToEnd;
    private long start;
    private long startGranule;
    private int state;
    private final StreamReader streamReader;
    private long targetGranule;
    private long totalGranules;

    public DefaultOggSeeker(StreamReader streamReader0, long v, long v1, long v2, long v3, boolean z) {
        this.pageHeader = new OggPageHeader();
        Assertions.checkArgument(Long.compare(v, 0L) >= 0 && v1 > v);
        this.streamReader = streamReader0;
        this.payloadStartPosition = v;
        this.payloadEndPosition = v1;
        if(v2 != v1 - v && !z) {
            this.state = 0;
            return;
        }
        this.totalGranules = v3;
        this.state = 4;
    }

    @Override  // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public SeekMap createSeekMap() {
        return this.createSeekMap();
    }

    public OggSeekMap createSeekMap() {
        return Long.compare(this.totalGranules, 0L) == 0 ? null : new OggSeekMap(this, null);
    }

    private long getNextSeekPosition(ExtractorInput extractorInput0) {
        if(Long.compare(this.start, this.end) == 0) {
            return -1L;
        }
        long v = extractorInput0.getPosition();
        if(!this.skipToNextPage(extractorInput0, this.end)) {
            long v1 = this.start;
            if(v1 == v) {
                throw new IOException("No ogg page can be found.");
            }
            return v1;
        }
        this.pageHeader.populate(extractorInput0, false);
        extractorInput0.resetPeekPosition();
        long v2 = this.pageHeader.granulePosition;
        long v3 = this.targetGranule - v2;
        int v4 = this.pageHeader.headerSize + this.pageHeader.bodySize;
        if(0L <= v3 && v3 < 72000L) {
            return -1L;
        }
        int v5 = Long.compare(v3, 0L);
        if(v5 < 0) {
            this.end = v;
            this.endGranule = v2;
        }
        else {
            this.start = extractorInput0.getPosition() + ((long)v4);
            this.startGranule = this.pageHeader.granulePosition;
        }
        long v6 = this.start;
        if(this.end - v6 < 100000L) {
            this.end = v6;
            return v6;
        }
        long v7 = extractorInput0.getPosition();
        return Util.constrainValue((this.end - this.start) * v3 / (this.endGranule - this.startGranule) + (v7 - ((long)v4) * (v5 > 0 ? 1L : 2L)), this.start, this.end - 1L);
    }

    @Override  // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public long read(ExtractorInput extractorInput0) {
        int v = this.state;
        if(v == 0) {
            long v2 = extractorInput0.getPosition();
            this.positionBeforeSeekToEnd = v2;
            this.state = 1;
            long v3 = this.payloadEndPosition - 0xFF1BL;
            if(v3 > v2) {
                return v3;
            }
        }
        else if(v != 1) {
            switch(v) {
                case 2: {
                    long v1 = this.getNextSeekPosition(extractorInput0);
                    if(v1 != -1L) {
                        return v1;
                    }
                    this.state = 3;
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    return -1L;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
            this.skipToPageOfTargetGranule(extractorInput0);
            this.state = 4;
            return -(this.startGranule + 2L);
        }
        this.totalGranules = this.readGranuleOfLastPage(extractorInput0);
        this.state = 4;
        return this.positionBeforeSeekToEnd;
    }

    public long readGranuleOfLastPage(ExtractorInput extractorInput0) {
        this.skipToNextPage(extractorInput0);
        this.pageHeader.reset();
        while((this.pageHeader.type & 4) != 4 && extractorInput0.getPosition() < this.payloadEndPosition) {
            this.pageHeader.populate(extractorInput0, false);
            extractorInput0.skipFully(this.pageHeader.headerSize + this.pageHeader.bodySize);
        }
        return this.pageHeader.granulePosition;
    }

    private boolean skipToNextPage(ExtractorInput extractorInput0, long v) {
        long v1 = Math.min(v + 3L, this.payloadEndPosition);
        int v2 = 0x800;
        byte[] arr_b = new byte[0x800];
        while(true) {
            if(Long.compare(extractorInput0.getPosition() + ((long)v2), v1) > 0) {
                v2 = (int)(v1 - extractorInput0.getPosition());
                if(v2 < 4) {
                    return false;
                }
            }
            extractorInput0.peekFully(arr_b, 0, v2, false);
            for(int v3 = 0; v3 < v2 - 3; ++v3) {
                if(arr_b[v3] == 0x4F && arr_b[v3 + 1] == 103 && arr_b[v3 + 2] == 103 && arr_b[v3 + 3] == 83) {
                    extractorInput0.skipFully(v3);
                    return true;
                }
            }
            extractorInput0.skipFully(v2 - 3);
        }
    }

    public void skipToNextPage(ExtractorInput extractorInput0) {
        if(!this.skipToNextPage(extractorInput0, this.payloadEndPosition)) {
            throw new EOFException();
        }
    }

    private void skipToPageOfTargetGranule(ExtractorInput extractorInput0) {
        this.pageHeader.populate(extractorInput0, false);
        while(true) {
            OggPageHeader oggPageHeader0 = this.pageHeader;
            if(oggPageHeader0.granulePosition > this.targetGranule) {
                break;
            }
            extractorInput0.skipFully(oggPageHeader0.headerSize + oggPageHeader0.bodySize);
            this.start = extractorInput0.getPosition();
            this.startGranule = this.pageHeader.granulePosition;
            this.pageHeader.populate(extractorInput0, false);
        }
        extractorInput0.resetPeekPosition();
    }

    @Override  // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public void startSeek(long v) {
        this.targetGranule = Util.constrainValue(v, 0L, this.totalGranules - 1L);
        this.state = 2;
        this.start = this.payloadStartPosition;
        this.end = this.payloadEndPosition;
        this.startGranule = 0L;
        this.endGranule = this.totalGranules;
    }

    class com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.1 {
    }

}

