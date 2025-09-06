package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;
import java.util.Map;

public final class LoopingMediaSource extends CompositeMediaSource {
    static final class InfinitelyLoopingTimeline extends ForwardingTimeline {
        public InfinitelyLoopingTimeline(Timeline timeline0) {
            super(timeline0);
        }

        @Override  // com.google.android.exoplayer2.source.ForwardingTimeline
        public int getNextWindowIndex(int v, int v1, boolean z) {
            int v2 = this.timeline.getNextWindowIndex(v, v1, z);
            return v2 == -1 ? this.getFirstWindowIndex(z) : v2;
        }

        @Override  // com.google.android.exoplayer2.source.ForwardingTimeline
        public int getPreviousWindowIndex(int v, int v1, boolean z) {
            int v2 = this.timeline.getPreviousWindowIndex(v, v1, z);
            return v2 == -1 ? this.getLastWindowIndex(z) : v2;
        }
    }

    static final class LoopingTimeline extends AbstractConcatenatedTimeline {
        private final int childPeriodCount;
        private final Timeline childTimeline;
        private final int childWindowCount;
        private final int loopCount;

        public LoopingTimeline(Timeline timeline0, int v) {
            boolean z = false;
            super(false, new UnshuffledShuffleOrder(v));
            this.childTimeline = timeline0;
            int v1 = timeline0.getPeriodCount();
            this.childPeriodCount = v1;
            this.childWindowCount = timeline0.getWindowCount();
            this.loopCount = v;
            if(v1 > 0) {
                if(v <= 0x7FFFFFFF / v1) {
                    z = true;
                }
                Assertions.checkState(z, "LoopingMediaSource contains too many periods");
            }
        }

        @Override  // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByChildUid(Object object0) {
            return object0 instanceof Integer ? ((int)(((Integer)object0))) : -1;
        }

        @Override  // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByPeriodIndex(int v) {
            return v / this.childPeriodCount;
        }

        @Override  // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByWindowIndex(int v) {
            return v / this.childWindowCount;
        }

        @Override  // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public Object getChildUidByChildIndex(int v) {
            return v;
        }

        @Override  // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getFirstPeriodIndexByChildIndex(int v) {
            return v * this.childPeriodCount;
        }

        @Override  // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getFirstWindowIndexByChildIndex(int v) {
            return v * this.childWindowCount;
        }

        @Override  // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.childPeriodCount * this.loopCount;
        }

        @Override  // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public Timeline getTimelineByChildIndex(int v) {
            return this.childTimeline;
        }

        @Override  // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return this.childWindowCount * this.loopCount;
        }
    }

    private final Map childMediaPeriodIdToMediaPeriodId;
    private final MediaSource childSource;
    private final int loopCount;
    private final Map mediaPeriodToChildMediaPeriodId;

    public LoopingMediaSource(MediaSource mediaSource0) {
        this(mediaSource0, 0x7FFFFFFF);
    }

    public LoopingMediaSource(MediaSource mediaSource0, int v) {
        Assertions.checkArgument(v > 0);
        this.childSource = mediaSource0;
        this.loopCount = v;
        this.childMediaPeriodIdToMediaPeriodId = new HashMap();
        this.mediaPeriodToChildMediaPeriodId = new HashMap();
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaPeriodId mediaSource$MediaPeriodId0, Allocator allocator0, long v) {
        if(this.loopCount == 0x7FFFFFFF) {
            return this.childSource.createPeriod(mediaSource$MediaPeriodId0, allocator0, v);
        }
        MediaPeriodId mediaSource$MediaPeriodId1 = mediaSource$MediaPeriodId0.copyWithPeriodUid(AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(mediaSource$MediaPeriodId0.periodUid));
        this.childMediaPeriodIdToMediaPeriodId.put(mediaSource$MediaPeriodId1, mediaSource$MediaPeriodId0);
        MediaPeriod mediaPeriod0 = this.childSource.createPeriod(mediaSource$MediaPeriodId1, allocator0, v);
        this.mediaPeriodToChildMediaPeriodId.put(mediaPeriod0, mediaSource$MediaPeriodId1);
        return mediaPeriod0;
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Object object0, MediaPeriodId mediaSource$MediaPeriodId0) {
        return this.getMediaPeriodIdForChildMediaPeriodId(((Void)object0), mediaSource$MediaPeriodId0);
    }

    public MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void void0, MediaPeriodId mediaSource$MediaPeriodId0) {
        return this.loopCount == 0x7FFFFFFF ? mediaSource$MediaPeriodId0 : ((MediaPeriodId)this.childMediaPeriodIdToMediaPeriodId.get(mediaSource$MediaPeriodId0));
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public Object getTag() {
        return this.childSource.getTag();
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(Object object0, MediaSource mediaSource0, Timeline timeline0) {
        this.onChildSourceInfoRefreshed(((Void)object0), mediaSource0, timeline0);
    }

    public void onChildSourceInfoRefreshed(Void void0, MediaSource mediaSource0, Timeline timeline0) {
        LoopingTimeline loopingMediaSource$LoopingTimeline0 = this.loopCount == 0x7FFFFFFF ? new InfinitelyLoopingTimeline(timeline0) : new LoopingTimeline(timeline0, this.loopCount);
        this.refreshSourceInfo(loopingMediaSource$LoopingTimeline0);
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void prepareSourceInternal(TransferListener transferListener0) {
        super.prepareSourceInternal(transferListener0);
        this.prepareChildSource(null, this.childSource);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod0) {
        this.childSource.releasePeriod(mediaPeriod0);
        MediaPeriodId mediaSource$MediaPeriodId0 = (MediaPeriodId)this.mediaPeriodToChildMediaPeriodId.remove(mediaPeriod0);
        if(mediaSource$MediaPeriodId0 != null) {
            this.childMediaPeriodIdToMediaPeriodId.remove(mediaSource$MediaPeriodId0);
        }
    }
}

