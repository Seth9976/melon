package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;

final class MediaPeriodQueue {
    private static final int MAXIMUM_BUFFER_AHEAD_PERIODS = 100;
    private int length;
    private MediaPeriodHolder loading;
    private long nextWindowSequenceNumber;
    private Object oldFrontPeriodUid;
    private long oldFrontPeriodWindowSequenceNumber;
    private final Period period;
    private MediaPeriodHolder playing;
    private MediaPeriodHolder reading;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private Timeline timeline;
    private final Window window;

    public MediaPeriodQueue() {
        this.period = new Period();
        this.window = new Window();
        this.timeline = Timeline.EMPTY;
    }

    public MediaPeriodHolder advancePlayingPeriod() {
        MediaPeriodHolder mediaPeriodHolder0 = this.playing;
        if(mediaPeriodHolder0 == null) {
            return null;
        }
        if(mediaPeriodHolder0 == this.reading) {
            this.reading = mediaPeriodHolder0.getNext();
        }
        this.playing.release();
        int v = this.length - 1;
        this.length = v;
        if(v == 0) {
            this.loading = null;
            this.oldFrontPeriodUid = this.playing.uid;
            this.oldFrontPeriodWindowSequenceNumber = this.playing.info.id.windowSequenceNumber;
        }
        MediaPeriodHolder mediaPeriodHolder1 = this.playing.getNext();
        this.playing = mediaPeriodHolder1;
        return mediaPeriodHolder1;
    }

    public MediaPeriodHolder advanceReadingPeriod() {
        Assertions.checkState(this.reading != null && this.reading.getNext() != null);
        MediaPeriodHolder mediaPeriodHolder0 = this.reading.getNext();
        this.reading = mediaPeriodHolder0;
        return mediaPeriodHolder0;
    }

    private boolean areDurationsCompatible(long v, long v1) {
        return v == 0x8000000000000001L || v == v1;
    }

    private boolean canKeepMediaPeriodHolder(MediaPeriodInfo mediaPeriodInfo0, MediaPeriodInfo mediaPeriodInfo1) {
        return mediaPeriodInfo0.startPositionUs == mediaPeriodInfo1.startPositionUs && mediaPeriodInfo0.id.equals(mediaPeriodInfo1.id);
    }

    public void clear(boolean z) {
        MediaPeriodHolder mediaPeriodHolder0 = this.playing;
        if(mediaPeriodHolder0 != null) {
            this.oldFrontPeriodUid = z ? mediaPeriodHolder0.uid : null;
            this.oldFrontPeriodWindowSequenceNumber = mediaPeriodHolder0.info.id.windowSequenceNumber;
            this.removeAfter(mediaPeriodHolder0);
            mediaPeriodHolder0.release();
        }
        else if(!z) {
            this.oldFrontPeriodUid = null;
        }
        this.playing = null;
        this.loading = null;
        this.reading = null;
        this.length = 0;
    }

    public MediaPeriodHolder enqueueNextMediaPeriodHolder(RendererCapabilities[] arr_rendererCapabilities, TrackSelector trackSelector0, Allocator allocator0, MediaSource mediaSource0, MediaPeriodInfo mediaPeriodInfo0, TrackSelectorResult trackSelectorResult0) {
        long v;
        MediaPeriodHolder mediaPeriodHolder0 = this.loading;
        if(mediaPeriodHolder0 != null) {
            v = mediaPeriodHolder0.getRendererOffset() + this.loading.info.durationUs - mediaPeriodInfo0.startPositionUs;
        }
        else if(mediaPeriodInfo0.id.isAd()) {
            v = mediaPeriodInfo0.contentPositionUs;
            if(v == 0x8000000000000001L) {
                v = 0L;
            }
        }
        else {
            v = 0L;
        }
        MediaPeriodHolder mediaPeriodHolder1 = new MediaPeriodHolder(arr_rendererCapabilities, v, trackSelector0, allocator0, mediaSource0, mediaPeriodInfo0, trackSelectorResult0);
        MediaPeriodHolder mediaPeriodHolder2 = this.loading;
        if(mediaPeriodHolder2 == null) {
            this.playing = mediaPeriodHolder1;
            this.reading = mediaPeriodHolder1;
        }
        else {
            mediaPeriodHolder2.setNext(mediaPeriodHolder1);
        }
        this.oldFrontPeriodUid = null;
        this.loading = mediaPeriodHolder1;
        ++this.length;
        return mediaPeriodHolder1;
    }

    private MediaPeriodInfo getFirstMediaPeriodInfo(PlaybackInfo playbackInfo0) {
        return this.getMediaPeriodInfo(playbackInfo0.periodId, playbackInfo0.contentPositionUs, playbackInfo0.startPositionUs);
    }

    private MediaPeriodInfo getFollowingMediaPeriodInfo(MediaPeriodHolder mediaPeriodHolder0, long v) {
        MediaPeriodInfo mediaPeriodInfo0 = mediaPeriodHolder0.info;
        long v1 = mediaPeriodHolder0.getRendererOffset() + mediaPeriodInfo0.durationUs - v;
        if(mediaPeriodInfo0.isLastInTimelinePeriod) {
            int v2 = this.timeline.getIndexOfPeriod(mediaPeriodInfo0.id.periodUid);
            int v3 = this.timeline.getNextPeriodIndex(v2, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if(v3 == -1) {
                return null;
            }
            int v4 = this.timeline.getPeriod(v3, this.period, true).windowIndex;
            Object object0 = this.period.uid;
            long v5 = mediaPeriodInfo0.id.windowSequenceNumber;
            if(this.timeline.getWindow(v4, this.window).firstPeriodIndex == v3) {
                Pair pair0 = this.timeline.getPeriodPosition(this.window, this.period, v4, 0x8000000000000001L, Math.max(0L, v1));
                if(pair0 == null) {
                    return null;
                }
                Object object1 = pair0.first;
                long v6 = (long)(((Long)pair0.second));
                MediaPeriodHolder mediaPeriodHolder1 = mediaPeriodHolder0.getNext();
                if(mediaPeriodHolder1 != null && mediaPeriodHolder1.uid.equals(object1)) {
                    return this.getMediaPeriodInfo(this.resolveMediaPeriodIdForAds(object1, v6, mediaPeriodHolder1.info.id.windowSequenceNumber), 0x8000000000000001L, v6);
                }
                long v7 = this.nextWindowSequenceNumber;
                this.nextWindowSequenceNumber = v7 + 1L;
                return this.getMediaPeriodInfo(this.resolveMediaPeriodIdForAds(object1, v6, v7), 0x8000000000000001L, v6);
            }
            return this.getMediaPeriodInfo(this.resolveMediaPeriodIdForAds(object0, 0L, v5), 0L, 0L);
        }
        MediaPeriodId mediaSource$MediaPeriodId0 = mediaPeriodInfo0.id;
        this.timeline.getPeriodByUid(mediaSource$MediaPeriodId0.periodUid, this.period);
        if(mediaSource$MediaPeriodId0.isAd()) {
            int v8 = mediaSource$MediaPeriodId0.adGroupIndex;
            int v9 = this.period.getAdCountInAdGroup(v8);
            if(v9 == -1) {
                return null;
            }
            int v10 = this.period.getNextAdIndexToPlay(v8, mediaSource$MediaPeriodId0.adIndexInAdGroup);
            if(v10 < v9) {
                return this.period.isAdAvailable(v8, v10) ? this.getMediaPeriodInfoForAd(mediaSource$MediaPeriodId0.periodUid, v8, v10, mediaPeriodInfo0.contentPositionUs, mediaSource$MediaPeriodId0.windowSequenceNumber) : null;
            }
            long v11 = mediaPeriodInfo0.contentPositionUs;
            if(v11 == 0x8000000000000001L) {
                Pair pair1 = this.timeline.getPeriodPosition(this.window, this.period, this.period.windowIndex, 0x8000000000000001L, Math.max(0L, v1));
                if(pair1 == null) {
                    return null;
                }
                v11 = (long)(((Long)pair1.second));
            }
            return this.getMediaPeriodInfoForContent(mediaSource$MediaPeriodId0.periodUid, v11, mediaSource$MediaPeriodId0.windowSequenceNumber);
        }
        int v12 = this.period.getAdGroupIndexForPositionUs(mediaPeriodInfo0.endPositionUs);
        if(v12 == -1) {
            return this.getMediaPeriodInfoForContent(mediaSource$MediaPeriodId0.periodUid, mediaPeriodInfo0.durationUs, mediaSource$MediaPeriodId0.windowSequenceNumber);
        }
        int v13 = this.period.getFirstAdIndexToPlay(v12);
        return this.period.isAdAvailable(v12, v13) ? this.getMediaPeriodInfoForAd(mediaSource$MediaPeriodId0.periodUid, v12, v13, mediaPeriodInfo0.durationUs, mediaSource$MediaPeriodId0.windowSequenceNumber) : null;
    }

    public MediaPeriodHolder getLoadingPeriod() {
        return this.loading;
    }

    private MediaPeriodInfo getMediaPeriodInfo(MediaPeriodId mediaSource$MediaPeriodId0, long v, long v1) {
        this.timeline.getPeriodByUid(mediaSource$MediaPeriodId0.periodUid, this.period);
        if(mediaSource$MediaPeriodId0.isAd()) {
            return this.period.isAdAvailable(mediaSource$MediaPeriodId0.adGroupIndex, mediaSource$MediaPeriodId0.adIndexInAdGroup) ? this.getMediaPeriodInfoForAd(mediaSource$MediaPeriodId0.periodUid, mediaSource$MediaPeriodId0.adGroupIndex, mediaSource$MediaPeriodId0.adIndexInAdGroup, v, mediaSource$MediaPeriodId0.windowSequenceNumber) : null;
        }
        return this.getMediaPeriodInfoForContent(mediaSource$MediaPeriodId0.periodUid, v1, mediaSource$MediaPeriodId0.windowSequenceNumber);
    }

    private MediaPeriodInfo getMediaPeriodInfoForAd(Object object0, int v, int v1, long v2, long v3) {
        MediaPeriodId mediaSource$MediaPeriodId0 = new MediaPeriodId(object0, v, v1, v3);
        long v4 = this.timeline.getPeriodByUid(mediaSource$MediaPeriodId0.periodUid, this.period).getAdDurationUs(mediaSource$MediaPeriodId0.adGroupIndex, mediaSource$MediaPeriodId0.adIndexInAdGroup);
        return v1 == this.period.getFirstAdIndexToPlay(v) ? new MediaPeriodInfo(mediaSource$MediaPeriodId0, this.period.getAdResumePositionUs(), v2, 0x8000000000000001L, v4, false, false) : new MediaPeriodInfo(mediaSource$MediaPeriodId0, 0L, v2, 0x8000000000000001L, v4, false, false);
    }

    private MediaPeriodInfo getMediaPeriodInfoForContent(Object object0, long v, long v1) {
        int v2 = this.period.getAdGroupIndexAfterPositionUs(v);
        MediaPeriodId mediaSource$MediaPeriodId0 = new MediaPeriodId(object0, v1, v2);
        boolean z = this.isLastInPeriod(mediaSource$MediaPeriodId0);
        boolean z1 = this.isLastInTimeline(mediaSource$MediaPeriodId0, z);
        long v3 = v2 == -1 ? 0x8000000000000001L : this.period.getAdGroupTimeUs(v2);
        return v3 == 0x8000000000000001L || v3 == 0x8000000000000000L ? new MediaPeriodInfo(mediaSource$MediaPeriodId0, v, 0x8000000000000001L, v3, this.period.durationUs, z, z1) : new MediaPeriodInfo(mediaSource$MediaPeriodId0, v, 0x8000000000000001L, v3, v3, z, z1);
    }

    public MediaPeriodInfo getNextMediaPeriodInfo(long v, PlaybackInfo playbackInfo0) {
        return this.loading == null ? this.getFirstMediaPeriodInfo(playbackInfo0) : this.getFollowingMediaPeriodInfo(this.loading, v);
    }

    public MediaPeriodHolder getPlayingPeriod() {
        return this.playing;
    }

    public MediaPeriodHolder getReadingPeriod() {
        return this.reading;
    }

    public MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo0) {
        MediaPeriodId mediaSource$MediaPeriodId0 = mediaPeriodInfo0.id;
        boolean z = this.isLastInPeriod(mediaSource$MediaPeriodId0);
        boolean z1 = this.isLastInTimeline(mediaSource$MediaPeriodId0, z);
        this.timeline.getPeriodByUid(mediaPeriodInfo0.id.periodUid, this.period);
        if(mediaSource$MediaPeriodId0.isAd()) {
            long v = this.period.getAdDurationUs(mediaSource$MediaPeriodId0.adGroupIndex, mediaSource$MediaPeriodId0.adIndexInAdGroup);
            return new MediaPeriodInfo(mediaSource$MediaPeriodId0, mediaPeriodInfo0.startPositionUs, mediaPeriodInfo0.contentPositionUs, mediaPeriodInfo0.endPositionUs, v, z, z1);
        }
        return mediaPeriodInfo0.endPositionUs != 0x8000000000000001L && mediaPeriodInfo0.endPositionUs != 0x8000000000000000L ? new MediaPeriodInfo(mediaSource$MediaPeriodId0, mediaPeriodInfo0.startPositionUs, mediaPeriodInfo0.contentPositionUs, mediaPeriodInfo0.endPositionUs, mediaPeriodInfo0.endPositionUs, z, z1) : new MediaPeriodInfo(mediaSource$MediaPeriodId0, mediaPeriodInfo0.startPositionUs, mediaPeriodInfo0.contentPositionUs, mediaPeriodInfo0.endPositionUs, this.period.getDurationUs(), z, z1);
    }

    private boolean isLastInPeriod(MediaPeriodId mediaSource$MediaPeriodId0) {
        return !mediaSource$MediaPeriodId0.isAd() && mediaSource$MediaPeriodId0.nextAdGroupIndex == -1;
    }

    private boolean isLastInTimeline(MediaPeriodId mediaSource$MediaPeriodId0, boolean z) {
        int v = this.timeline.getIndexOfPeriod(mediaSource$MediaPeriodId0.periodUid);
        Period timeline$Period0 = this.timeline.getPeriod(v, this.period);
        return !this.timeline.getWindow(timeline$Period0.windowIndex, this.window).isDynamic && this.timeline.isLastPeriod(v, this.period, this.window, this.repeatMode, this.shuffleModeEnabled) && z;
    }

    public boolean isLoading(MediaPeriod mediaPeriod0) {
        return this.loading != null && this.loading.mediaPeriod == mediaPeriod0;
    }

    public void reevaluateBuffer(long v) {
        MediaPeriodHolder mediaPeriodHolder0 = this.loading;
        if(mediaPeriodHolder0 != null) {
            mediaPeriodHolder0.reevaluateBuffer(v);
        }
    }

    public boolean removeAfter(MediaPeriodHolder mediaPeriodHolder0) {
        boolean z = false;
        Assertions.checkState(mediaPeriodHolder0 != null);
        this.loading = mediaPeriodHolder0;
        while(mediaPeriodHolder0.getNext() != null) {
            mediaPeriodHolder0 = mediaPeriodHolder0.getNext();
            if(mediaPeriodHolder0 == this.reading) {
                this.reading = this.playing;
                z = true;
            }
            mediaPeriodHolder0.release();
            --this.length;
        }
        this.loading.setNext(null);
        return z;
    }

    private MediaPeriodId resolveMediaPeriodIdForAds(Object object0, long v, long v1) {
        this.timeline.getPeriodByUid(object0, this.period);
        int v2 = this.period.getAdGroupIndexForPositionUs(v);
        return v2 == -1 ? new MediaPeriodId(object0, v1, this.period.getAdGroupIndexAfterPositionUs(v)) : new MediaPeriodId(object0, v2, this.period.getFirstAdIndexToPlay(v2), v1);
    }

    public MediaPeriodId resolveMediaPeriodIdForAds(Object object0, long v) {
        return this.resolveMediaPeriodIdForAds(object0, v, this.resolvePeriodIndexToWindowSequenceNumber(object0));
    }

    private long resolvePeriodIndexToWindowSequenceNumber(Object object0) {
        int v = this.timeline.getPeriodByUid(object0, this.period).windowIndex;
        Object object1 = this.oldFrontPeriodUid;
        if(object1 != null) {
            int v1 = this.timeline.getIndexOfPeriod(object1);
            if(v1 != -1 && this.timeline.getPeriod(v1, this.period).windowIndex == v) {
                return this.oldFrontPeriodWindowSequenceNumber;
            }
        }
        for(MediaPeriodHolder mediaPeriodHolder0 = this.playing; mediaPeriodHolder0 != null; mediaPeriodHolder0 = mediaPeriodHolder0.getNext()) {
            if(mediaPeriodHolder0.uid.equals(object0)) {
                return mediaPeriodHolder0.info.id.windowSequenceNumber;
            }
        }
        for(MediaPeriodHolder mediaPeriodHolder1 = this.playing; mediaPeriodHolder1 != null; mediaPeriodHolder1 = mediaPeriodHolder1.getNext()) {
            int v2 = this.timeline.getIndexOfPeriod(mediaPeriodHolder1.uid);
            if(v2 != -1 && this.timeline.getPeriod(v2, this.period).windowIndex == v) {
                return mediaPeriodHolder1.info.id.windowSequenceNumber;
            }
        }
        long v3 = this.nextWindowSequenceNumber;
        this.nextWindowSequenceNumber = v3 + 1L;
        if(this.playing == null) {
            this.oldFrontPeriodUid = object0;
            this.oldFrontPeriodWindowSequenceNumber = v3;
        }
        return v3;
    }

    public void setTimeline(Timeline timeline0) {
        this.timeline = timeline0;
    }

    // 去混淆评级： 低(20)
    public boolean shouldLoadNextMediaPeriod() {
        return this.loading == null || !this.loading.info.isFinal && this.loading.isFullyBuffered() && this.loading.info.durationUs != 0x8000000000000001L && this.length < 100;
    }

    private boolean updateForPlaybackModeChange() {
        MediaPeriodHolder mediaPeriodHolder0 = this.playing;
        if(mediaPeriodHolder0 == null) {
            return true;
        }
        int v = this.timeline.getIndexOfPeriod(mediaPeriodHolder0.uid);
        while(true) {
            v = this.timeline.getNextPeriodIndex(v, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            while(mediaPeriodHolder0.getNext() != null && !mediaPeriodHolder0.info.isLastInTimelinePeriod) {
                mediaPeriodHolder0 = mediaPeriodHolder0.getNext();
            }
            MediaPeriodHolder mediaPeriodHolder1 = mediaPeriodHolder0.getNext();
            if(v == -1 || mediaPeriodHolder1 == null || this.timeline.getIndexOfPeriod(mediaPeriodHolder1.uid) != v) {
                break;
            }
            mediaPeriodHolder0 = mediaPeriodHolder1;
        }
        boolean z = this.removeAfter(mediaPeriodHolder0);
        mediaPeriodHolder0.info = this.getUpdatedMediaPeriodInfo(mediaPeriodHolder0.info);
        return !z;
    }

    public boolean updateQueuedPeriods(long v, long v1) {
        MediaPeriodInfo mediaPeriodInfo1;
        MediaPeriodHolder mediaPeriodHolder0 = this.playing;
        MediaPeriodHolder mediaPeriodHolder1 = null;
        while(mediaPeriodHolder0 != null) {
            MediaPeriodInfo mediaPeriodInfo0 = mediaPeriodHolder0.info;
            if(mediaPeriodHolder1 == null) {
                mediaPeriodInfo1 = this.getUpdatedMediaPeriodInfo(mediaPeriodInfo0);
            }
            else {
                MediaPeriodInfo mediaPeriodInfo2 = this.getFollowingMediaPeriodInfo(mediaPeriodHolder1, v);
                if(mediaPeriodInfo2 == null) {
                    return !this.removeAfter(mediaPeriodHolder1);
                }
                if(!this.canKeepMediaPeriodHolder(mediaPeriodInfo0, mediaPeriodInfo2)) {
                    return !this.removeAfter(mediaPeriodHolder1);
                }
                mediaPeriodInfo1 = mediaPeriodInfo2;
            }
            mediaPeriodHolder0.info = mediaPeriodInfo1.copyWithContentPositionUs(mediaPeriodInfo0.contentPositionUs);
            if(!this.areDurationsCompatible(mediaPeriodInfo0.durationUs, mediaPeriodInfo1.durationUs)) {
                long v2 = mediaPeriodInfo1.durationUs == 0x8000000000000001L ? 0x7FFFFFFFFFFFFFFFL : mediaPeriodHolder0.toRendererTime(mediaPeriodInfo1.durationUs);
                boolean z = mediaPeriodHolder0 == this.reading && (v1 == 0x8000000000000000L || v1 >= v2);
                return !this.removeAfter(mediaPeriodHolder0) && !z;
            }
            mediaPeriodHolder1 = mediaPeriodHolder0;
            mediaPeriodHolder0 = mediaPeriodHolder0.getNext();
        }
        return true;
    }

    public boolean updateRepeatMode(int v) {
        this.repeatMode = v;
        return this.updateForPlaybackModeChange();
    }

    public boolean updateShuffleModeEnabled(boolean z) {
        this.shuffleModeEnabled = z;
        return this.updateForPlaybackModeChange();
    }
}

