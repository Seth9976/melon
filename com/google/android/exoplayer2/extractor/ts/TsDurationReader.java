package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

final class TsDurationReader {
    private static final int TIMESTAMP_SEARCH_BYTES = 112800;
    private long durationUs;
    private long firstPcrValue;
    private boolean isDurationRead;
    private boolean isFirstPcrValueRead;
    private boolean isLastPcrValueRead;
    private long lastPcrValue;
    private final ParsableByteArray packetBuffer;
    private final TimestampAdjuster pcrTimestampAdjuster;

    public TsDurationReader() {
        this.pcrTimestampAdjuster = new TimestampAdjuster(0L);
        this.firstPcrValue = 0x8000000000000001L;
        this.lastPcrValue = 0x8000000000000001L;
        this.durationUs = 0x8000000000000001L;
        this.packetBuffer = new ParsableByteArray();
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

    public TimestampAdjuster getPcrTimestampAdjuster() {
        return this.pcrTimestampAdjuster;
    }

    public boolean isDurationReadFinished() {
        return this.isDurationRead;
    }

    public int readDuration(ExtractorInput extractorInput0, PositionHolder positionHolder0, int v) {
        if(v <= 0) {
            return this.finishReadDuration(extractorInput0);
        }
        if(!this.isLastPcrValueRead) {
            return this.readLastPcrValue(extractorInput0, positionHolder0, v);
        }
        if(this.lastPcrValue == 0x8000000000000001L) {
            return this.finishReadDuration(extractorInput0);
        }
        if(!this.isFirstPcrValueRead) {
            return this.readFirstPcrValue(extractorInput0, positionHolder0, v);
        }
        long v1 = this.firstPcrValue;
        if(v1 == 0x8000000000000001L) {
            return this.finishReadDuration(extractorInput0);
        }
        long v2 = this.pcrTimestampAdjuster.adjustTsTimestamp(v1);
        this.durationUs = this.pcrTimestampAdjuster.adjustTsTimestamp(this.lastPcrValue) - v2;
        return this.finishReadDuration(extractorInput0);
    }

    private int readFirstPcrValue(ExtractorInput extractorInput0, PositionHolder positionHolder0, int v) {
        int v1 = (int)Math.min(112800L, extractorInput0.getLength());
        if(Long.compare(extractorInput0.getPosition(), 0L) != 0) {
            positionHolder0.position = 0L;
            return 1;
        }
        this.packetBuffer.reset(v1);
        extractorInput0.resetPeekPosition();
        extractorInput0.peekFully(this.packetBuffer.data, 0, v1);
        this.firstPcrValue = this.readFirstPcrValueFromBuffer(this.packetBuffer, v);
        this.isFirstPcrValueRead = true;
        return 0;
    }

    private long readFirstPcrValueFromBuffer(ParsableByteArray parsableByteArray0, int v) {
        int v1 = parsableByteArray0.getPosition();
        int v2 = parsableByteArray0.limit();
        while(v1 < v2) {
            if(parsableByteArray0.data[v1] == 71) {
                long v3 = TsUtil.readPcrFromPacket(parsableByteArray0, v1, v);
                if(v3 != 0x8000000000000001L) {
                    return v3;
                }
            }
            ++v1;
        }
        return 0x8000000000000001L;
    }

    private int readLastPcrValue(ExtractorInput extractorInput0, PositionHolder positionHolder0, int v) {
        long v1 = extractorInput0.getLength();
        int v2 = (int)Math.min(112800L, v1);
        long v3 = v1 - ((long)v2);
        if(Long.compare(extractorInput0.getPosition(), v3) != 0) {
            positionHolder0.position = v3;
            return 1;
        }
        this.packetBuffer.reset(v2);
        extractorInput0.resetPeekPosition();
        extractorInput0.peekFully(this.packetBuffer.data, 0, v2);
        this.lastPcrValue = this.readLastPcrValueFromBuffer(this.packetBuffer, v);
        this.isLastPcrValueRead = true;
        return 0;
    }

    private long readLastPcrValueFromBuffer(ParsableByteArray parsableByteArray0, int v) {
        int v1 = parsableByteArray0.getPosition();
        for(int v2 = parsableByteArray0.limit() - 1; v2 >= v1; --v2) {
            if(parsableByteArray0.data[v2] == 71) {
                long v3 = TsUtil.readPcrFromPacket(parsableByteArray0, v2, v);
                if(v3 != 0x8000000000000001L) {
                    return v3;
                }
            }
        }
        return 0x8000000000000001L;
    }
}

