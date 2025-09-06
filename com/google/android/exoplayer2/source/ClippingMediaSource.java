package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public final class ClippingMediaSource extends CompositeMediaSource {
    static final class ClippingTimeline extends ForwardingTimeline {
        private final long durationUs;
        private final long endUs;
        private final boolean isDynamic;
        private final long startUs;

        public ClippingTimeline(Timeline timeline0, long v, long v1) {
            super(timeline0);
            boolean z = false;
            if(timeline0.getPeriodCount() != 1) {
                throw new IllegalClippingException(0);
            }
            Window timeline$Window0 = timeline0.getWindow(0, new Window());
            long v2 = Math.max(0L, v);
            long v3 = v1 == 0x8000000000000000L ? timeline$Window0.durationUs : Math.max(0L, v1);
            long v4 = timeline$Window0.durationUs;
            if(v4 != 0x8000000000000001L) {
                if(v3 > v4) {
                    v3 = v4;
                }
                if(v2 != 0L && !timeline$Window0.isSeekable) {
                    throw new IllegalClippingException(1);
                }
                if(v2 > v3) {
                    throw new IllegalClippingException(2);
                }
            }
            this.startUs = v2;
            this.endUs = v3;
            int v5 = Long.compare(v3, 0x8000000000000001L);
            this.durationUs = v5 == 0 ? 0x8000000000000001L : v3 - v2;
            if(timeline$Window0.isDynamic && (v5 == 0 || v4 != 0x8000000000000001L && v3 == v4)) {
                z = true;
            }
            this.isDynamic = z;
        }

        @Override  // com.google.android.exoplayer2.source.ForwardingTimeline
        public Period getPeriod(int v, Period timeline$Period0, boolean z) {
            this.timeline.getPeriod(0, timeline$Period0, z);
            long v1 = timeline$Period0.getPositionInWindowUs() - this.startUs;
            return this.durationUs == 0x8000000000000001L ? timeline$Period0.set(timeline$Period0.id, timeline$Period0.uid, 0, 0x8000000000000001L, v1) : timeline$Period0.set(timeline$Period0.id, timeline$Period0.uid, 0, this.durationUs - v1, v1);
        }

        @Override  // com.google.android.exoplayer2.source.ForwardingTimeline
        public Window getWindow(int v, Window timeline$Window0, long v1) {
            this.timeline.getWindow(0, timeline$Window0, 0L);
            long v2 = this.startUs;
            timeline$Window0.positionInFirstPeriodUs += v2;
            timeline$Window0.durationUs = this.durationUs;
            timeline$Window0.isDynamic = this.isDynamic;
            long v3 = timeline$Window0.defaultPositionUs;
            if(v3 != 0x8000000000000001L) {
                long v4 = Math.max(v3, v2);
                timeline$Window0.defaultPositionUs = v4;
                long v5 = this.endUs;
                if(v5 != 0x8000000000000001L) {
                    v4 = Math.min(v4, v5);
                }
                timeline$Window0.defaultPositionUs = v4 - this.startUs;
            }
            long v6 = C.usToMs(this.startUs);
            long v7 = timeline$Window0.presentationStartTimeMs;
            if(v7 != 0x8000000000000001L) {
                timeline$Window0.presentationStartTimeMs = v7 + v6;
            }
            long v8 = timeline$Window0.windowStartTimeMs;
            if(v8 != 0x8000000000000001L) {
                timeline$Window0.windowStartTimeMs = v8 + v6;
            }
            return timeline$Window0;
        }
    }

    public static final class IllegalClippingException extends IOException {
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        public IllegalClippingException(int v) {
            String s = IllegalClippingException.getReasonDescription(v);
            super((s.length() == 0 ? new String("Illegal clipping: ") : "Illegal clipping: " + s));
            this.reason = v;
        }

        private static String getReasonDescription(int v) {
            switch(v) {
                case 0: {
                    return "invalid period count";
                }
                case 1: {
                    return "not seekable to start";
                }
                case 2: {
                    return "start exceeds end";
                }
                default: {
                    return "unknown";
                }
            }
        }
    }

    private final boolean allowDynamicClippingUpdates;
    private IllegalClippingException clippingError;
    private ClippingTimeline clippingTimeline;
    private final boolean enableInitialDiscontinuity;
    private final long endUs;
    private final ArrayList mediaPeriods;
    private final MediaSource mediaSource;
    private long periodEndUs;
    private long periodStartUs;
    private final boolean relativeToDefaultPosition;
    private final long startUs;
    private final Window window;

    public ClippingMediaSource(MediaSource mediaSource0, long v) {
        this(mediaSource0, 0L, v, true, false, true);
    }

    public ClippingMediaSource(MediaSource mediaSource0, long v, long v1) {
        this(mediaSource0, v, v1, true, false, false);
    }

    public ClippingMediaSource(MediaSource mediaSource0, long v, long v1, boolean z, boolean z1, boolean z2) {
        Assertions.checkArgument(v >= 0L);
        this.mediaSource = (MediaSource)Assertions.checkNotNull(mediaSource0);
        this.startUs = v;
        this.endUs = v1;
        this.enableInitialDiscontinuity = z;
        this.allowDynamicClippingUpdates = z1;
        this.relativeToDefaultPosition = z2;
        this.mediaPeriods = new ArrayList();
        this.window = new Window();
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaPeriodId mediaSource$MediaPeriodId0, Allocator allocator0, long v) {
        MediaPeriod mediaPeriod0 = new ClippingMediaPeriod(this.mediaSource.createPeriod(mediaSource$MediaPeriodId0, allocator0, v), this.enableInitialDiscontinuity, this.periodStartUs, this.periodEndUs);
        this.mediaPeriods.add(mediaPeriod0);
        return mediaPeriod0;
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public long getMediaTimeForChildMediaTime(Object object0, long v) {
        return this.getMediaTimeForChildMediaTime(((Void)object0), v);
    }

    public long getMediaTimeForChildMediaTime(Void void0, long v) {
        if(v == 0x8000000000000001L) {
            return 0x8000000000000001L;
        }
        long v1 = C.usToMs(this.startUs);
        long v2 = Math.max(0L, v - v1);
        return this.endUs == 0x8000000000000000L ? v2 : Math.min(C.usToMs(this.endUs) - v1, v2);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public Object getTag() {
        return this.mediaSource.getTag();
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void maybeThrowSourceInfoRefreshError() {
        IllegalClippingException clippingMediaSource$IllegalClippingException0 = this.clippingError;
        if(clippingMediaSource$IllegalClippingException0 != null) {
            throw clippingMediaSource$IllegalClippingException0;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(Object object0, MediaSource mediaSource0, Timeline timeline0) {
        this.onChildSourceInfoRefreshed(((Void)object0), mediaSource0, timeline0);
    }

    public void onChildSourceInfoRefreshed(Void void0, MediaSource mediaSource0, Timeline timeline0) {
        if(this.clippingError != null) {
            return;
        }
        this.refreshClippedTimeline(timeline0);
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void prepareSourceInternal(TransferListener transferListener0) {
        super.prepareSourceInternal(transferListener0);
        this.prepareChildSource(null, this.mediaSource);
    }

    private void refreshClippedTimeline(Timeline timeline0) {
        ClippingTimeline clippingMediaSource$ClippingTimeline0;
        long v4;
        timeline0.getWindow(0, this.window);
        long v1 = this.window.getPositionInFirstPeriodUs();
        long v2 = 0x8000000000000000L;
        if(this.clippingTimeline == null || this.mediaPeriods.isEmpty() || this.allowDynamicClippingUpdates) {
            long v5 = this.startUs;
            long v6 = this.endUs;
            if(this.relativeToDefaultPosition) {
                long v7 = this.window.getDefaultPositionUs();
                v5 += v7;
                v6 += v7;
            }
            this.periodStartUs = v1 + v5;
            if(this.endUs != 0x8000000000000000L) {
                v2 = v1 + v6;
            }
            this.periodEndUs = v2;
            int v8 = this.mediaPeriods.size();
            for(int v = 0; v < v8; ++v) {
                ((ClippingMediaPeriod)this.mediaPeriods.get(v)).updateClipping(this.periodStartUs, this.periodEndUs);
            }
            v4 = v5;
            v2 = v6;
        }
        else {
            long v3 = this.periodStartUs - v1;
            if(this.endUs != 0x8000000000000000L) {
                v2 = this.periodEndUs - v1;
            }
            v4 = v3;
        }
        try {
            clippingMediaSource$ClippingTimeline0 = new ClippingTimeline(timeline0, v4, v2);
            this.clippingTimeline = clippingMediaSource$ClippingTimeline0;
        }
        catch(IllegalClippingException clippingMediaSource$IllegalClippingException0) {
            this.clippingError = clippingMediaSource$IllegalClippingException0;
            return;
        }
        this.refreshSourceInfo(clippingMediaSource$ClippingTimeline0);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod0) {
        Assertions.checkState(this.mediaPeriods.remove(mediaPeriod0));
        this.mediaSource.releasePeriod(((ClippingMediaPeriod)mediaPeriod0).mediaPeriod);
        if(this.mediaPeriods.isEmpty() && !this.allowDynamicClippingUpdates) {
            this.refreshClippedTimeline(((ClippingTimeline)Assertions.checkNotNull(this.clippingTimeline)).timeline);
        }
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.clippingError = null;
        this.clippingTimeline = null;
    }
}

