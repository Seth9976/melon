package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

final class PsDurationReader {
    private static final int TIMESTAMP_SEARCH_BYTES = 20000;
    private long durationUs;
    private long firstScrValue;
    private boolean isDurationRead;
    private boolean isFirstScrValueRead;
    private boolean isLastScrValueRead;
    private long lastScrValue;
    private final ParsableByteArray packetBuffer;
    private final TimestampAdjuster scrTimestampAdjuster;

    public PsDurationReader() {
        this.scrTimestampAdjuster = new TimestampAdjuster(0L);
        this.firstScrValue = 0x8000000000000001L;
        this.lastScrValue = 0x8000000000000001L;
        this.durationUs = 0x8000000000000001L;
        this.packetBuffer = new ParsableByteArray();
    }

    private static boolean checkMarkerBits(byte[] arr_b) {
        if((arr_b[0] & 0xC4) != 68) {
            return false;
        }
        if((arr_b[2] & 4) != 4) {
            return false;
        }
        if((arr_b[4] & 4) != 4) {
            return false;
        }
        return (arr_b[5] & 1) == 1 ? (arr_b[8] & 3) == 3 : false;
    }

    private int finishReadDuration(ExtractorInput extractorInput0) {
        this.packetBuffer.reset(Util.EMPTY_BYTE_ARRAY);
        this.isDurationRead = true;
        extractorInput0.resetPeekPosition();
        return 0;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public TimestampAdjuster getScrTimestampAdjuster() {
        return this.scrTimestampAdjuster;
    }

    public boolean isDurationReadFinished() {
        return this.isDurationRead;
    }

    private int peekIntAtPosition(byte[] arr_b, int v) {
        return arr_b[v + 3] & 0xFF | ((arr_b[v] & 0xFF) << 24 | (arr_b[v + 1] & 0xFF) << 16 | (arr_b[v + 2] & 0xFF) << 8);
    }

    public int readDuration(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        if(!this.isLastScrValueRead) {
            return this.readLastScrValue(extractorInput0, positionHolder0);
        }
        if(this.lastScrValue == 0x8000000000000001L) {
            return this.finishReadDuration(extractorInput0);
        }
        if(!this.isFirstScrValueRead) {
            return this.readFirstScrValue(extractorInput0, positionHolder0);
        }
        long v = this.firstScrValue;
        if(v == 0x8000000000000001L) {
            return this.finishReadDuration(extractorInput0);
        }
        long v1 = this.scrTimestampAdjuster.adjustTsTimestamp(v);
        this.durationUs = this.scrTimestampAdjuster.adjustTsTimestamp(this.lastScrValue) - v1;
        return this.finishReadDuration(extractorInput0);
    }

    private int readFirstScrValue(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        int v = (int)Math.min(20000L, extractorInput0.getLength());
        if(Long.compare(extractorInput0.getPosition(), 0L) != 0) {
            positionHolder0.position = 0L;
            return 1;
        }
        this.packetBuffer.reset(v);
        extractorInput0.resetPeekPosition();
        extractorInput0.peekFully(this.packetBuffer.data, 0, v);
        this.firstScrValue = this.readFirstScrValueFromBuffer(this.packetBuffer);
        this.isFirstScrValueRead = true;
        return 0;
    }

    private long readFirstScrValueFromBuffer(ParsableByteArray parsableByteArray0) {
        int v = parsableByteArray0.getPosition();
        int v1 = parsableByteArray0.limit();
        while(v < v1 - 3) {
            if(this.peekIntAtPosition(parsableByteArray0.data, v) == 442) {
                parsableByteArray0.setPosition(v + 4);
                long v2 = PsDurationReader.readScrValueFromPack(parsableByteArray0);
                if(v2 != 0x8000000000000001L) {
                    return v2;
                }
            }
            ++v;
        }
        return 0x8000000000000001L;
    }

    private int readLastScrValue(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        long v = extractorInput0.getLength();
        int v1 = (int)Math.min(20000L, v);
        long v2 = v - ((long)v1);
        if(Long.compare(extractorInput0.getPosition(), v2) != 0) {
            positionHolder0.position = v2;
            return 1;
        }
        this.packetBuffer.reset(v1);
        extractorInput0.resetPeekPosition();
        extractorInput0.peekFully(this.packetBuffer.data, 0, v1);
        this.lastScrValue = this.readLastScrValueFromBuffer(this.packetBuffer);
        this.isLastScrValueRead = true;
        return 0;
    }

    private long readLastScrValueFromBuffer(ParsableByteArray parsableByteArray0) {
        int v = parsableByteArray0.getPosition();
        for(int v1 = parsableByteArray0.limit() - 4; v1 >= v; --v1) {
            if(this.peekIntAtPosition(parsableByteArray0.data, v1) == 442) {
                parsableByteArray0.setPosition(v1 + 4);
                long v2 = PsDurationReader.readScrValueFromPack(parsableByteArray0);
                if(v2 != 0x8000000000000001L) {
                    return v2;
                }
            }
        }
        return 0x8000000000000001L;
    }

    public static long readScrValueFromPack(ParsableByteArray parsableByteArray0) {
        int v = parsableByteArray0.getPosition();
        if(parsableByteArray0.bytesLeft() < 9) {
            return 0x8000000000000001L;
        }
        byte[] arr_b = new byte[9];
        parsableByteArray0.readBytes(arr_b, 0, 9);
        parsableByteArray0.setPosition(v);
        return PsDurationReader.checkMarkerBits(arr_b) ? PsDurationReader.readScrValueFromPackHeader(arr_b) : 0x8000000000000001L;
    }

    private static long readScrValueFromPackHeader(byte[] arr_b) {
        return (((long)arr_b[0]) & 56L) >> 3 << 30 | (((long)arr_b[0]) & 3L) << 28 | (((long)arr_b[1]) & 0xFFL) << 20 | (((long)arr_b[2]) & 0xF8L) >> 3 << 15 | (((long)arr_b[2]) & 3L) << 13 | (((long)arr_b[3]) & 0xFFL) << 5 | (((long)arr_b[4]) & 0xF8L) >> 3;
    }
}

