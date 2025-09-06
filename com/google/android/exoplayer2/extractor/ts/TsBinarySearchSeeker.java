package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker.DefaultSeekTimestampConverter;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

final class TsBinarySearchSeeker extends BinarySearchSeeker {
    static final class TsPcrSeeker implements TimestampSeeker {
        private final ParsableByteArray packetBuffer;
        private final int pcrPid;
        private final TimestampAdjuster pcrTimestampAdjuster;

        public TsPcrSeeker(int v, TimestampAdjuster timestampAdjuster0) {
            this.pcrPid = v;
            this.pcrTimestampAdjuster = timestampAdjuster0;
            this.packetBuffer = new ParsableByteArray();
        }

        @Override  // com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSeeker
        public void onSeekFinished() {
            this.packetBuffer.reset(Util.EMPTY_BYTE_ARRAY);
        }

        private TimestampSearchResult searchForPcrValueInBuffer(ParsableByteArray parsableByteArray0, long v, long v1) {
            int v2 = parsableByteArray0.limit();
            long v3 = -1L;
            long v4 = -1L;
            long v5 = 0x8000000000000001L;
            while(parsableByteArray0.bytesLeft() >= 0xBC) {
                int v6 = TsUtil.findSyncBytePosition(parsableByteArray0.data, parsableByteArray0.getPosition(), v2);
                if(v6 + 0xBC > v2) {
                    break;
                }
                long v7 = TsUtil.readPcrFromPacket(parsableByteArray0, v6, this.pcrPid);
                if(v7 != 0x8000000000000001L) {
                    long v8 = this.pcrTimestampAdjuster.adjustTsTimestamp(v7);
                    if(v8 > v) {
                        return v5 == 0x8000000000000001L ? TimestampSearchResult.overestimatedResult(v8, v1) : TimestampSearchResult.targetFoundResult(v1 + v4);
                    }
                    if(v8 + 100000L > v) {
                        return TimestampSearchResult.targetFoundResult(v1 + ((long)v6));
                    }
                    v4 = (long)v6;
                    v5 = v8;
                }
                parsableByteArray0.setPosition(v6 + 0xBC);
                v3 = (long)(v6 + 0xBC);
            }
            return v5 == 0x8000000000000001L ? TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT : TimestampSearchResult.underestimatedResult(v5, v1 + v3);
        }

        @Override  // com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSeeker
        public TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput0, long v) {
            long v1 = extractorInput0.getPosition();
            int v2 = (int)Math.min(112800L, extractorInput0.getLength() - v1);
            this.packetBuffer.reset(v2);
            extractorInput0.peekFully(this.packetBuffer.data, 0, v2);
            return this.searchForPcrValueInBuffer(this.packetBuffer, v, v1);
        }
    }

    private static final int MINIMUM_SEARCH_RANGE_BYTES = 940;
    private static final long SEEK_TOLERANCE_US = 100000L;
    private static final int TIMESTAMP_SEARCH_BYTES = 112800;

    public TsBinarySearchSeeker(TimestampAdjuster timestampAdjuster0, long v, long v1, int v2) {
        super(new DefaultSeekTimestampConverter(), new TsPcrSeeker(v2, timestampAdjuster0), v, 0L, v + 1L, 0L, v1, 0xBCL, 940);
    }
}

