package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class MergingMediaSource extends CompositeMediaSource {
    public static final class IllegalMergeException extends IOException {
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public static final int REASON_PERIOD_COUNT_MISMATCH;
        public final int reason;

        public IllegalMergeException(int v) {
            this.reason = v;
        }
    }

    private static final int PERIOD_COUNT_UNSET = -1;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final MediaSource[] mediaSources;
    private IllegalMergeException mergeError;
    private final ArrayList pendingTimelineSources;
    private int periodCount;
    private final Timeline[] timelines;

    public MergingMediaSource(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory0, MediaSource[] arr_mediaSource) {
        this.mediaSources = arr_mediaSource;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory0;
        this.pendingTimelineSources = new ArrayList(Arrays.asList(arr_mediaSource));
        this.periodCount = -1;
        this.timelines = new Timeline[arr_mediaSource.length];
    }

    public MergingMediaSource(MediaSource[] arr_mediaSource) {
        this(new DefaultCompositeSequenceableLoaderFactory(), arr_mediaSource);
    }

    private IllegalMergeException checkTimelineMerges(Timeline timeline0) {
        if(this.periodCount == -1) {
            this.periodCount = timeline0.getPeriodCount();
            return null;
        }
        return timeline0.getPeriodCount() == this.periodCount ? null : new IllegalMergeException(0);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaPeriodId mediaSource$MediaPeriodId0, Allocator allocator0, long v) {
        MediaPeriod[] arr_mediaPeriod = new MediaPeriod[this.mediaSources.length];
        int v2 = this.timelines[0].getIndexOfPeriod(mediaSource$MediaPeriodId0.periodUid);
        for(int v1 = 0; v1 < this.mediaSources.length; ++v1) {
            MediaPeriodId mediaSource$MediaPeriodId1 = mediaSource$MediaPeriodId0.copyWithPeriodUid(this.timelines[v1].getUidOfPeriod(v2));
            arr_mediaPeriod[v1] = this.mediaSources[v1].createPeriod(mediaSource$MediaPeriodId1, allocator0, v);
        }
        return new MergingMediaPeriod(this.compositeSequenceableLoaderFactory, arr_mediaPeriod);
    }

    public MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Integer integer0, MediaPeriodId mediaSource$MediaPeriodId0) {
        return ((int)integer0) == 0 ? mediaSource$MediaPeriodId0 : null;
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Object object0, MediaPeriodId mediaSource$MediaPeriodId0) {
        return this.getMediaPeriodIdForChildMediaPeriodId(((Integer)object0), mediaSource$MediaPeriodId0);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public Object getTag() {
        return this.mediaSources.length <= 0 ? null : this.mediaSources[0].getTag();
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void maybeThrowSourceInfoRefreshError() {
        IllegalMergeException mergingMediaSource$IllegalMergeException0 = this.mergeError;
        if(mergingMediaSource$IllegalMergeException0 != null) {
            throw mergingMediaSource$IllegalMergeException0;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    public void onChildSourceInfoRefreshed(Integer integer0, MediaSource mediaSource0, Timeline timeline0) {
        if(this.mergeError == null) {
            this.mergeError = this.checkTimelineMerges(timeline0);
        }
        if(this.mergeError == null) {
            this.pendingTimelineSources.remove(mediaSource0);
            this.timelines[((int)integer0)] = timeline0;
            if(this.pendingTimelineSources.isEmpty()) {
                this.refreshSourceInfo(this.timelines[0]);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(Object object0, MediaSource mediaSource0, Timeline timeline0) {
        this.onChildSourceInfoRefreshed(((Integer)object0), mediaSource0, timeline0);
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void prepareSourceInternal(TransferListener transferListener0) {
        super.prepareSourceInternal(transferListener0);
        for(int v = 0; v < this.mediaSources.length; ++v) {
            this.prepareChildSource(v, this.mediaSources[v]);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod0) {
        for(int v = 0; true; ++v) {
            MediaSource[] arr_mediaSource = this.mediaSources;
            if(v >= arr_mediaSource.length) {
                break;
            }
            arr_mediaSource[v].releasePeriod(((MergingMediaPeriod)mediaPeriod0).periods[v]);
        }
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        Arrays.fill(this.timelines, null);
        this.periodCount = -1;
        this.mergeError = null;
        this.pendingTimelineSources.clear();
        Collections.addAll(this.pendingTimelineSources, this.mediaSources);
    }
}

