package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;

public final class SinglePeriodTimeline extends Timeline {
    private static final Object UID;
    private final boolean isDynamic;
    private final boolean isLive;
    private final boolean isSeekable;
    private final Object manifest;
    private final long periodDurationUs;
    private final long presentationStartTimeMs;
    private final Object tag;
    private final long windowDefaultStartPositionUs;
    private final long windowDurationUs;
    private final long windowPositionInPeriodUs;
    private final long windowStartTimeMs;

    static {
        SinglePeriodTimeline.UID = new Object();
    }

    public SinglePeriodTimeline(long v, long v1, long v2, long v3, long v4, long v5, boolean z, boolean z1, boolean z2, Object object0, Object object1) {
        this.presentationStartTimeMs = v;
        this.windowStartTimeMs = v1;
        this.periodDurationUs = v2;
        this.windowDurationUs = v3;
        this.windowPositionInPeriodUs = v4;
        this.windowDefaultStartPositionUs = v5;
        this.isSeekable = z;
        this.isDynamic = z1;
        this.isLive = z2;
        this.manifest = object0;
        this.tag = object1;
    }

    public SinglePeriodTimeline(long v, long v1, long v2, long v3, boolean z, boolean z1, boolean z2, Object object0, Object object1) {
        this(0x8000000000000001L, 0x8000000000000001L, v, v1, v2, v3, z, z1, z2, object0, object1);
    }

    public SinglePeriodTimeline(long v, boolean z, boolean z1, boolean z2) {
        this(v, z, z1, z2, null, null);
    }

    public SinglePeriodTimeline(long v, boolean z, boolean z1, boolean z2, Object object0, Object object1) {
        this(v, v, 0L, 0L, z, z1, z2, object0, object1);
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.Timeline
    public int getIndexOfPeriod(Object object0) {
        return SinglePeriodTimeline.UID.equals(object0) ? 0 : -1;
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public Period getPeriod(int v, Period timeline$Period0, boolean z) {
        Assertions.checkIndex(v, 0, 1);
        return z ? timeline$Period0.set(null, SinglePeriodTimeline.UID, 0, this.periodDurationUs, -this.windowPositionInPeriodUs) : timeline$Period0.set(null, null, 0, this.periodDurationUs, -this.windowPositionInPeriodUs);
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return 1;
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public Object getUidOfPeriod(int v) {
        Assertions.checkIndex(v, 0, 1);
        return SinglePeriodTimeline.UID;
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public Window getWindow(int v, Window timeline$Window0, long v1) {
        Assertions.checkIndex(v, 0, 1);
        long v2 = this.windowDefaultStartPositionUs;
        boolean z = this.isDynamic;
        if(z && v1 != 0L) {
            long v3 = this.windowDurationUs;
            if(v3 == 0x8000000000000001L) {
                return timeline$Window0.set(Window.SINGLE_WINDOW_UID, this.tag, this.manifest, this.presentationStartTimeMs, this.windowStartTimeMs, this.isSeekable, z, this.isLive, 0x8000000000000001L, this.windowDurationUs, 0, 0, this.windowPositionInPeriodUs);
            }
            v2 += v1;
            return v2 > v3 ? timeline$Window0.set(Window.SINGLE_WINDOW_UID, this.tag, this.manifest, this.presentationStartTimeMs, this.windowStartTimeMs, this.isSeekable, z, this.isLive, 0x8000000000000001L, this.windowDurationUs, 0, 0, this.windowPositionInPeriodUs) : timeline$Window0.set(Window.SINGLE_WINDOW_UID, this.tag, this.manifest, this.presentationStartTimeMs, this.windowStartTimeMs, this.isSeekable, z, this.isLive, v2, this.windowDurationUs, 0, 0, this.windowPositionInPeriodUs);
        }
        return timeline$Window0.set(Window.SINGLE_WINDOW_UID, this.tag, this.manifest, this.presentationStartTimeMs, this.windowStartTimeMs, this.isSeekable, z, this.isLive, v2, this.windowDurationUs, 0, 0, this.windowPositionInPeriodUs);
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return 1;
    }
}

