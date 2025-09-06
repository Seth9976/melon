package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class Sniffer {
    private static final int ID_EBML = 0x1A45DFA3;
    private static final int SEARCH_LENGTH = 0x400;
    private int peekLength;
    private final ParsableByteArray scratch;

    public Sniffer() {
        this.scratch = new ParsableByteArray(8);
    }

    private long readUint(ExtractorInput extractorInput0) {
        int v = 0;
        extractorInput0.peekFully(this.scratch.data, 0, 1);
        int v1 = this.scratch.data[0] & 0xFF;
        if(v1 == 0) {
            return 0x8000000000000000L;
        }
        int v2 = 0x80;
        int v3;
        for(v3 = 0; (v1 & v2) == 0; ++v3) {
            v2 >>= 1;
        }
        int v4 = v1 & ~v2;
        extractorInput0.peekFully(this.scratch.data, 1, v3);
        while(v < v3) {
            ++v;
            v4 = (this.scratch.data[v] & 0xFF) + (v4 << 8);
        }
        this.peekLength = v3 + 1 + this.peekLength;
        return (long)v4;
    }

    public boolean sniff(ExtractorInput extractorInput0) {
        long v7;
        int v6;
        long v = extractorInput0.getLength();
        int v1 = Long.compare(v, -1L);
        extractorInput0.peekFully(this.scratch.data, 0, 4);
        long v2 = this.scratch.readUnsignedInt();
        this.peekLength = 4;
        while(Long.compare(v2, 0x1A45DFA3L) != 0) {
            int v3 = this.peekLength + 1;
            this.peekLength = v3;
            if(v3 == ((int)(v1 == 0 || v > 0x400L ? 0x400L : v))) {
                return false;
            }
            extractorInput0.peekFully(this.scratch.data, 0, 1);
            v2 = v2 << 8 & 0xFFFFFFFFFFFFFF00L | ((long)(this.scratch.data[0] & 0xFF));
        }
        long v4 = this.readUint(extractorInput0);
        long v5 = (long)this.peekLength;
        if(v4 != 0x8000000000000000L && (v1 == 0 || v5 + v4 < v)) {
            while(true) {
                v6 = this.peekLength;
                v7 = v5 + v4;
                if(((long)v6) >= v7) {
                    break;
                }
                if(this.readUint(extractorInput0) == 0x8000000000000000L) {
                    return false;
                }
                long v8 = this.readUint(extractorInput0);
                int v9 = Long.compare(v8, 0L);
                if(v9 >= 0 && v8 <= 0x7FFFFFFFL) {
                    if(v9 == 0) {
                        continue;
                    }
                    extractorInput0.advancePeekPosition(((int)v8));
                    this.peekLength += (int)v8;
                    continue;
                }
                return false;
            }
            return ((long)v6) == v7;
        }
        return false;
    }
}

