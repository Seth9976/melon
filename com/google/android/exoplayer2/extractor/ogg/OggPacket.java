package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

final class OggPacket {
    private int currentSegmentIndex;
    private final ParsableByteArray packetArray;
    private final OggPageHeader pageHeader;
    private boolean populated;
    private int segmentCount;

    public OggPacket() {
        this.pageHeader = new OggPageHeader();
        this.packetArray = new ParsableByteArray(new byte[0xFE01], 0);
        this.currentSegmentIndex = -1;
    }

    private int calculatePacketSize(int v) {
        int v1 = 0;
        this.segmentCount = 0;
        do {
            int v2 = this.segmentCount;
            OggPageHeader oggPageHeader0 = this.pageHeader;
            if(v + v2 >= oggPageHeader0.pageSegmentCount) {
                break;
            }
            this.segmentCount = v2 + 1;
            int v3 = oggPageHeader0.laces[v2 + v];
            v1 += v3;
        }
        while(v3 == 0xFF);
        return v1;
    }

    public OggPageHeader getPageHeader() {
        return this.pageHeader;
    }

    public ParsableByteArray getPayload() {
        return this.packetArray;
    }

    public boolean populate(ExtractorInput extractorInput0) {
        int v1;
        Assertions.checkState(extractorInput0 != null);
        if(this.populated) {
            this.populated = false;
            this.packetArray.reset();
        }
        while(!this.populated) {
            if(this.currentSegmentIndex < 0) {
                if(!this.pageHeader.populate(extractorInput0, true)) {
                    return false;
                }
                int v = this.pageHeader.headerSize;
                if((this.pageHeader.type & 1) != 1 || this.packetArray.limit() != 0) {
                    v1 = 0;
                }
                else {
                    v += this.calculatePacketSize(0);
                    v1 = this.segmentCount;
                }
                extractorInput0.skipFully(v);
                this.currentSegmentIndex = v1;
            }
            int v2 = this.calculatePacketSize(this.currentSegmentIndex);
            int v3 = this.currentSegmentIndex + this.segmentCount;
            if(v2 > 0) {
                if(this.packetArray.capacity() < this.packetArray.limit() + v2) {
                    this.packetArray.data = Arrays.copyOf(this.packetArray.data, this.packetArray.limit() + v2);
                }
                extractorInput0.readFully(this.packetArray.data, this.packetArray.limit(), v2);
                this.packetArray.setLimit(this.packetArray.limit() + v2);
                this.populated = this.pageHeader.laces[v3 - 1] != 0xFF;
            }
            if(v3 == this.pageHeader.pageSegmentCount) {
                v3 = -1;
            }
            this.currentSegmentIndex = v3;
        }
        return true;
    }

    public void reset() {
        this.pageHeader.reset();
        this.packetArray.reset();
        this.currentSegmentIndex = -1;
        this.populated = false;
    }

    public void trimPayload() {
        ParsableByteArray parsableByteArray0 = this.packetArray;
        byte[] arr_b = parsableByteArray0.data;
        if(arr_b.length == 0xFE01) {
            return;
        }
        parsableByteArray0.data = Arrays.copyOf(arr_b, Math.max(0xFE01, parsableByteArray0.limit()));
    }
}

