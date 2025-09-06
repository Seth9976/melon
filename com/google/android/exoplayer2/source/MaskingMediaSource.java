package com.google.android.exoplayer2.source;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class MaskingMediaSource extends CompositeMediaSource {
    public static final class DummyTimeline extends Timeline {
        private final Object tag;

        public DummyTimeline(Object object0) {
            this.tag = object0;
        }

        @Override  // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object object0) {
            return object0 == MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID ? 0 : -1;
        }

        @Override  // com.google.android.exoplayer2.Timeline
        public Period getPeriod(int v, Period timeline$Period0, boolean z) {
            return timeline$Period0.set(0, MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID, 0, 0x8000000000000001L, 0L);
        }

        @Override  // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return 1;
        }

        @Override  // com.google.android.exoplayer2.Timeline
        public Object getUidOfPeriod(int v) {
            return MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID;
        }

        @Override  // com.google.android.exoplayer2.Timeline
        public Window getWindow(int v, Window timeline$Window0, long v1) {
            return timeline$Window0.set(Window.SINGLE_WINDOW_UID, this.tag, null, 0x8000000000000001L, 0x8000000000000001L, false, true, false, 0L, 0x8000000000000001L, 0, 0, 0L);
        }

        @Override  // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 1;
        }
    }

    static final class MaskingTimeline extends ForwardingTimeline {
        public static final Object DUMMY_EXTERNAL_PERIOD_UID;
        private final Object replacedInternalPeriodUid;
        private final Object replacedInternalWindowUid;

        static {
            MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID = new Object();
        }

        private MaskingTimeline(Timeline timeline0, Object object0, Object object1) {
            super(timeline0);
            this.replacedInternalWindowUid = object0;
            this.replacedInternalPeriodUid = object1;
        }

        public static Object access$000(MaskingTimeline maskingMediaSource$MaskingTimeline0) {
            return maskingMediaSource$MaskingTimeline0.replacedInternalPeriodUid;
        }

        public MaskingTimeline cloneWithUpdatedTimeline(Timeline timeline0) {
            return new MaskingTimeline(timeline0, this.replacedInternalWindowUid, this.replacedInternalPeriodUid);
        }

        public static MaskingTimeline createWithDummyTimeline(Object object0) {
            return new MaskingTimeline(new DummyTimeline(object0), Window.SINGLE_WINDOW_UID, MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID);
        }

        public static MaskingTimeline createWithRealTimeline(Timeline timeline0, Object object0, Object object1) {
            return new MaskingTimeline(timeline0, object0, object1);
        }

        @Override  // com.google.android.exoplayer2.source.ForwardingTimeline
        public int getIndexOfPeriod(Object object0) {
            Timeline timeline0 = this.timeline;
            if(MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID.equals(object0)) {
                object0 = this.replacedInternalPeriodUid;
            }
            return timeline0.getIndexOfPeriod(object0);
        }

        @Override  // com.google.android.exoplayer2.source.ForwardingTimeline
        public Period getPeriod(int v, Period timeline$Period0, boolean z) {
            this.timeline.getPeriod(v, timeline$Period0, z);
            if(Util.areEqual(timeline$Period0.uid, this.replacedInternalPeriodUid)) {
                timeline$Period0.uid = MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID;
            }
            return timeline$Period0;
        }

        public Timeline getTimeline() {
            return this.timeline;
        }

        @Override  // com.google.android.exoplayer2.source.ForwardingTimeline
        public Object getUidOfPeriod(int v) {
            Object object0 = this.timeline.getUidOfPeriod(v);
            return Util.areEqual(object0, this.replacedInternalPeriodUid) ? MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID : object0;
        }

        @Override  // com.google.android.exoplayer2.source.ForwardingTimeline
        public Window getWindow(int v, Window timeline$Window0, long v1) {
            this.timeline.getWindow(v, timeline$Window0, v1);
            if(Util.areEqual(timeline$Window0.uid, this.replacedInternalWindowUid)) {
                timeline$Window0.uid = Window.SINGLE_WINDOW_UID;
            }
            return timeline$Window0;
        }
    }

    private boolean hasStartedPreparing;
    private boolean isPrepared;
    private final MediaSource mediaSource;
    private final Period period;
    private MaskingTimeline timeline;
    private MaskingMediaPeriod unpreparedMaskingMediaPeriod;
    private EventDispatcher unpreparedMaskingMediaPeriodEventDispatcher;
    private final boolean useLazyPreparation;
    private final Window window;

    public MaskingMediaSource(MediaSource mediaSource0, boolean z) {
        this.mediaSource = mediaSource0;
        this.useLazyPreparation = z;
        this.window = new Window();
        this.period = new Period();
        this.timeline = MaskingTimeline.createWithDummyTimeline(mediaSource0.getTag());
    }

    public MaskingMediaPeriod createPeriod(MediaPeriodId mediaSource$MediaPeriodId0, Allocator allocator0, long v) {
        MaskingMediaPeriod maskingMediaPeriod0 = new MaskingMediaPeriod(this.mediaSource, mediaSource$MediaPeriodId0, allocator0, v);
        if(this.isPrepared) {
            maskingMediaPeriod0.createPeriod(mediaSource$MediaPeriodId0.copyWithPeriodUid(this.getInternalPeriodUid(mediaSource$MediaPeriodId0.periodUid)));
            return maskingMediaPeriod0;
        }
        this.unpreparedMaskingMediaPeriod = maskingMediaPeriod0;
        EventDispatcher mediaSourceEventListener$EventDispatcher0 = this.createEventDispatcher(0, mediaSource$MediaPeriodId0, 0L);
        this.unpreparedMaskingMediaPeriodEventDispatcher = mediaSourceEventListener$EventDispatcher0;
        mediaSourceEventListener$EventDispatcher0.mediaPeriodCreated();
        if(!this.hasStartedPreparing) {
            this.hasStartedPreparing = true;
            this.prepareChildSource(null, this.mediaSource);
        }
        return maskingMediaPeriod0;
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaPeriodId mediaSource$MediaPeriodId0, Allocator allocator0, long v) {
        return this.createPeriod(mediaSource$MediaPeriodId0, allocator0, v);
    }

    // 去混淆评级： 低(20)
    private Object getExternalPeriodUid(Object object0) {
        return MaskingTimeline.access$000(this.timeline).equals(object0) ? MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID : object0;
    }

    // 去混淆评级： 低(20)
    private Object getInternalPeriodUid(Object object0) {
        return object0.equals(MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID) ? MaskingTimeline.access$000(this.timeline) : object0;
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Object object0, MediaPeriodId mediaSource$MediaPeriodId0) {
        return this.getMediaPeriodIdForChildMediaPeriodId(((Void)object0), mediaSource$MediaPeriodId0);
    }

    public MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void void0, MediaPeriodId mediaSource$MediaPeriodId0) {
        return mediaSource$MediaPeriodId0.copyWithPeriodUid(this.getExternalPeriodUid(mediaSource$MediaPeriodId0.periodUid));
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public Object getTag() {
        return this.mediaSource.getTag();
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(Object object0, MediaSource mediaSource0, Timeline timeline0) {
        this.onChildSourceInfoRefreshed(((Void)object0), mediaSource0, timeline0);
    }

    public void onChildSourceInfoRefreshed(Void void0, MediaSource mediaSource0, Timeline timeline0) {
        long v2;
        if(this.isPrepared) {
            this.timeline = this.timeline.cloneWithUpdatedTimeline(timeline0);
        }
        else if(timeline0.isEmpty()) {
            this.timeline = MaskingTimeline.createWithRealTimeline(timeline0, Window.SINGLE_WINDOW_UID, MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID);
        }
        else {
            timeline0.getWindow(0, this.window);
            long v = this.window.getDefaultPositionUs();
            MaskingMediaPeriod maskingMediaPeriod0 = this.unpreparedMaskingMediaPeriod;
            if(maskingMediaPeriod0 == null) {
                v2 = v;
            }
            else {
                long v1 = maskingMediaPeriod0.getPreparePositionUs();
                v2 = v1 == 0L ? v : v1;
            }
            Object object0 = this.window.uid;
            Pair pair0 = timeline0.getPeriodPosition(this.window, this.period, 0, v2);
            Object object1 = pair0.first;
            long v3 = (long)(((Long)pair0.second));
            this.timeline = MaskingTimeline.createWithRealTimeline(timeline0, object0, object1);
            MaskingMediaPeriod maskingMediaPeriod1 = this.unpreparedMaskingMediaPeriod;
            if(maskingMediaPeriod1 != null) {
                maskingMediaPeriod1.overridePreparePositionUs(v3);
                Object object2 = this.getInternalPeriodUid(maskingMediaPeriod1.id.periodUid);
                maskingMediaPeriod1.createPeriod(maskingMediaPeriod1.id.copyWithPeriodUid(object2));
            }
        }
        this.isPrepared = true;
        this.refreshSourceInfo(this.timeline);
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void prepareSourceInternal(TransferListener transferListener0) {
        super.prepareSourceInternal(transferListener0);
        if(!this.useLazyPreparation) {
            this.hasStartedPreparing = true;
            this.prepareChildSource(null, this.mediaSource);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod0) {
        ((MaskingMediaPeriod)mediaPeriod0).releasePeriod();
        if(mediaPeriod0 == this.unpreparedMaskingMediaPeriod) {
            ((EventDispatcher)Assertions.checkNotNull(this.unpreparedMaskingMediaPeriodEventDispatcher)).mediaPeriodReleased();
            this.unpreparedMaskingMediaPeriodEventDispatcher = null;
            this.unpreparedMaskingMediaPeriod = null;
        }
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void releaseSourceInternal() {
        this.isPrepared = false;
        this.hasStartedPreparing = false;
        super.releaseSourceInternal();
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public boolean shouldDispatchCreateOrReleaseEvent(MediaPeriodId mediaSource$MediaPeriodId0) {
        return this.unpreparedMaskingMediaPeriod == null || !mediaSource$MediaPeriodId0.equals(this.unpreparedMaskingMediaPeriod.id);
    }
}

