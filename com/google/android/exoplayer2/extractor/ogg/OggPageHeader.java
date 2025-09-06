package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;

final class OggPageHeader {
    public static final int EMPTY_PAGE_HEADER_SIZE = 27;
    public static final int MAX_PAGE_PAYLOAD = 0xFE01;
    public static final int MAX_PAGE_SIZE = 0xFF1B;
    public static final int MAX_SEGMENT_COUNT = 0xFF;
    private static final int TYPE_OGGS = 0x4F676753;
    public int bodySize;
    public long granulePosition;
    public int headerSize;
    public final int[] laces;
    public long pageChecksum;
    public int pageSegmentCount;
    public long pageSequenceNumber;
    public int revision;
    private final ParsableByteArray scratch;
    public long streamSerialNumber;
    public int type;

    public OggPageHeader() {
        this.laces = new int[0xFF];
        this.scratch = new ParsableByteArray(0xFF);
    }

    public boolean populate(ExtractorInput extractorInput0, boolean z) {
        this.scratch.reset();
        this.reset();
        if(Long.compare(extractorInput0.getLength(), -1L) != 0 && extractorInput0.getLength() - extractorInput0.getPeekPosition() < 27L || !extractorInput0.peekFully(this.scratch.data, 0, 27, true)) {
            if(!z) {
                throw new EOFException();
            }
            return false;
        }
        if(this.scratch.readUnsignedInt() != 0x4F676753L) {
            if(!z) {
                throw new ParserException("expected OggS capture pattern at begin of page");
            }
            return false;
        }
        int v1 = this.scratch.readUnsignedByte();
        this.revision = v1;
        if(v1 != 0) {
            if(!z) {
                throw new ParserException("unsupported bit stream revision");
            }
            return false;
        }
        this.type = this.scratch.readUnsignedByte();
        this.granulePosition = this.scratch.readLittleEndianLong();
        this.streamSerialNumber = this.scratch.readLittleEndianUnsignedInt();
        this.pageSequenceNumber = this.scratch.readLittleEndianUnsignedInt();
        this.pageChecksum = this.scratch.readLittleEndianUnsignedInt();
        int v2 = this.scratch.readUnsignedByte();
        this.pageSegmentCount = v2;
        this.headerSize = v2 + 27;
        this.scratch.reset();
        extractorInput0.peekFully(this.scratch.data, 0, this.pageSegmentCount);
        for(int v = 0; v < this.pageSegmentCount; ++v) {
            this.laces[v] = this.scratch.readUnsignedByte();
            this.bodySize += this.laces[v];
        }
        return true;
    }

    public void reset() {
        this.revision = 0;
        this.type = 0;
        this.granulePosition = 0L;
        this.streamSerialNumber = 0L;
        this.pageSequenceNumber = 0L;
        this.pageChecksum = 0L;
        this.pageSegmentCount = 0;
        this.headerSize = 0;
        this.bodySize = 0;
    }
}

