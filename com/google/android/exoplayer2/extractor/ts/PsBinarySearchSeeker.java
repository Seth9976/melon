package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker.DefaultSeekTimestampConverter;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

final class PsBinarySearchSeeker extends BinarySearchSeeker {
    static final class PsScrSeeker implements TimestampSeeker {
        private final ParsableByteArray packetBuffer;
        private final TimestampAdjuster scrTimestampAdjuster;

        private PsScrSeeker(TimestampAdjuster timestampAdjuster0) {
            this.scrTimestampAdjuster = timestampAdjuster0;
            this.packetBuffer = new ParsableByteArray();
        }

        public PsScrSeeker(TimestampAdjuster timestampAdjuster0, com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker.1 psBinarySearchSeeker$10) {
            this(timestampAdjuster0);
        }

        @Override  // com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSeeker
        public void onSeekFinished() {
            this.packetBuffer.reset(Util.EMPTY_BYTE_ARRAY);
        }

        private TimestampSearchResult searchForScrValueInBuffer(ParsableByteArray parsableByteArray0, long v, long v1) {
            int v2 = -1;
            int v3 = -1;
            long v4 = 0x8000000000000001L;
            while(parsableByteArray0.bytesLeft() >= 4) {
                if(PsBinarySearchSeeker.peekIntAtPosition(parsableByteArray0.data, parsableByteArray0.getPosition()) == 442) {
                    parsableByteArray0.skipBytes(4);
                    long v5 = PsDurationReader.readScrValueFromPack(parsableByteArray0);
                    if(v5 != 0x8000000000000001L) {
                        long v6 = this.scrTimestampAdjuster.adjustTsTimestamp(v5);
                        if(v6 > v) {
                            return v4 == 0x8000000000000001L ? TimestampSearchResult.overestimatedResult(v6, v1) : TimestampSearchResult.targetFoundResult(v1 + ((long)v3));
                        }
                        if(v6 + 100000L > v) {
                            return TimestampSearchResult.targetFoundResult(v1 + ((long)parsableByteArray0.getPosition()));
                        }
                        v3 = parsableByteArray0.getPosition();
                        v4 = v6;
                    }
                    PsScrSeeker.skipToEndOfCurrentPack(parsableByteArray0);
                    v2 = parsableByteArray0.getPosition();
                }
                else {
                    parsableByteArray0.skipBytes(1);
                }
            }
            return v4 == 0x8000000000000001L ? TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT : TimestampSearchResult.underestimatedResult(v4, v1 + ((long)v2));
        }

        @Override  // com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSeeker
        public TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput0, long v) {
            long v1 = extractorInput0.getPosition();
            int v2 = (int)Math.min(20000L, extractorInput0.getLength() - v1);
            this.packetBuffer.reset(v2);
            extractorInput0.peekFully(this.packetBuffer.data, 0, v2);
            return this.searchForScrValueInBuffer(this.packetBuffer, v, v1);
        }

        private static void skipToEndOfCurrentPack(ParsableByteArray parsableByteArray0) {
            int v = parsableByteArray0.limit();
            if(parsableByteArray0.bytesLeft() < 10) {
                parsableByteArray0.setPosition(v);
                return;
            }
            parsableByteArray0.skipBytes(9);
            int v1 = parsableByteArray0.readUnsignedByte();
            if(parsableByteArray0.bytesLeft() < (v1 & 7)) {
                parsableByteArray0.setPosition(v);
                return;
            }
            parsableByteArray0.skipBytes(v1 & 7);
            if(parsableByteArray0.bytesLeft() < 4) {
                parsableByteArray0.setPosition(v);
                return;
            }
            if(PsBinarySearchSeeker.peekIntAtPosition(parsableByteArray0.data, parsableByteArray0.getPosition()) == 443) {
                parsableByteArray0.skipBytes(4);
                int v2 = parsableByteArray0.readUnsignedShort();
                if(parsableByteArray0.bytesLeft() < v2) {
                    parsableByteArray0.setPosition(v);
                    return;
                }
                parsableByteArray0.skipBytes(v2);
            }
            while(parsableByteArray0.bytesLeft() >= 4) {
                int v3 = PsBinarySearchSeeker.peekIntAtPosition(parsableByteArray0.data, parsableByteArray0.getPosition());
                if(v3 == 441 || v3 == 442 || v3 >>> 8 != 1) {
                    break;
                }
                parsableByteArray0.skipBytes(4);
                if(parsableByteArray0.bytesLeft() < 2) {
                    parsableByteArray0.setPosition(v);
                    return;
                }
                parsableByteArray0.setPosition(Math.min(parsableByteArray0.limit(), parsableByteArray0.getPosition() + parsableByteArray0.readUnsignedShort()));
            }
        }
    }

    private static final int MINIMUM_SEARCH_RANGE_BYTES = 1000;
    private static final long SEEK_TOLERANCE_US = 100000L;
    private static final int TIMESTAMP_SEARCH_BYTES = 20000;

    public PsBinarySearchSeeker(TimestampAdjuster timestampAdjuster0, long v, long v1) {
        super(new DefaultSeekTimestampConverter(), new PsScrSeeker(timestampAdjuster0, null), v, 0L, v + 1L, 0L, v1, 0xBCL, 1000);
    }

    private static int peekIntAtPosition(byte[] arr_b, int v) {
        return arr_b[v + 3] & 0xFF | ((arr_b[v] & 0xFF) << 24 | (arr_b[v + 1] & 0xFF) << 16 | (arr_b[v + 2] & 0xFF) << 8);
    }

    class com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker.1 {
    }

}

