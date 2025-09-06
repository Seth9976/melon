package com.google.android.exoplayer2.util;

public final class TimestampAdjuster {
    public static final long DO_NOT_OFFSET = 0x7FFFFFFFFFFFFFFFL;
    private static final long MAX_PTS_PLUS_ONE = 0x200000000L;
    private long firstSampleTimestampUs;
    private volatile long lastSampleTimestampUs;
    private long timestampOffsetUs;

    public TimestampAdjuster(long v) {
        this.lastSampleTimestampUs = 0x8000000000000001L;
        this.setFirstSampleTimestampUs(v);
    }

    public long adjustSampleTimestamp(long v) {
        if(v == 0x8000000000000001L) {
            return 0x8000000000000001L;
        }
        if(this.lastSampleTimestampUs != 0x8000000000000001L) {
            this.lastSampleTimestampUs = v;
            return v + this.timestampOffsetUs;
        }
        long v1 = this.firstSampleTimestampUs;
        if(v1 != 0x7FFFFFFFFFFFFFFFL) {
            this.timestampOffsetUs = v1 - v;
        }
        synchronized(this) {
            this.lastSampleTimestampUs = v;
            this.notifyAll();
            return v + this.timestampOffsetUs;
        }
    }

    // 去混淆评级： 中等(50)
    public long adjustTsTimestamp(long v) {
        return v == 0x8000000000000001L ? 0x8000000000000001L : this.adjustSampleTimestamp(v * 1000000L / 90000L);
    }

    public long getFirstSampleTimestampUs() {
        return this.firstSampleTimestampUs;
    }

    public long getLastAdjustedTimestampUs() {
        if(this.lastSampleTimestampUs != 0x8000000000000001L) {
            return this.lastSampleTimestampUs + this.timestampOffsetUs;
        }
        return this.firstSampleTimestampUs == 0x7FFFFFFFFFFFFFFFL ? 0x8000000000000001L : this.firstSampleTimestampUs;
    }

    public long getTimestampOffsetUs() {
        if(this.firstSampleTimestampUs == 0x7FFFFFFFFFFFFFFFL) {
            return 0L;
        }
        return this.lastSampleTimestampUs == 0x8000000000000001L ? 0x8000000000000001L : this.timestampOffsetUs;
    }

    public static long ptsToUs(long v) [...] // Inlined contents

    public void reset() {
        this.lastSampleTimestampUs = 0x8000000000000001L;
    }

    public void setFirstSampleTimestampUs(long v) {
        synchronized(this) {
            Assertions.checkState(this.lastSampleTimestampUs == 0x8000000000000001L);
            this.firstSampleTimestampUs = v;
        }
    }

    public static long usToPts(long v) [...] // Inlined contents

    public void waitUntilInitialized() {
        synchronized(this) {
            while(this.lastSampleTimestampUs == 0x8000000000000001L) {
                this.wait();
            }
        }
    }
}

